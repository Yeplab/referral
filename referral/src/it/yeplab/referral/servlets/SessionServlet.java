package it.yeplab.referral.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.yeplab.referral.datamanager.ManagerAgenti;
import it.yeplab.referral.dbconnection.DBConnectionFactory;
import it.yeplab.referral.domaindata.Agente;

public class SessionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doJob(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doJob(req, resp);
	}

	private void doJob(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String msg = "";
		String fun = req.getParameter("fun");
		if (fun.equals("login")) {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			ManagerAgenti ma = new ManagerAgenti(DBConnectionFactory.getConnection());
			int login = ma.logIn(email, password);
			Agente a=ma.getAgenteById(login);
			if (login > 0) {
				HttpSession session = req.getSession(false);
				if (session != null) {
					session.setAttribute("agente", a);
				} else {
					session = req.getSession(true);
					session.setAttribute("agente", a);
				}
			}
			msg = "agente=" + login;
		}
		if (fun.equals("logout")) {
			HttpSession session = req.getSession(false);
			if (session != null) {
				session.removeAttribute("agente");
			}
			msg = "logout";
		}
		out.print(msg);
	}

}
