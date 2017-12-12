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

public class SessionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doJob(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doJob(req, resp);
	}

	private void doJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String msg = "";
		String fun = request.getParameter("fun");
		if (fun.equals("login")) {
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			ManagerAgenti ma=new ManagerAgenti(DBConnectionFactory.getConnection());
			int login=ma.logIn(email, password);
			HttpSession session=request.getSession(true);
			session.setAttribute("agente", login);
			msg="agente = "+login;
		}
		if(fun.equals("logout")) {
			HttpSession session=request.getSession(false);
			session.removeAttribute("agente");
			session.invalidate();
			msg="logout";
		}
		out.print(msg);
	}

}
