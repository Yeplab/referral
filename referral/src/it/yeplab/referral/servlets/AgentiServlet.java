package it.yeplab.referral.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.yeplab.referral.datamanager.ManagerAgenti;
import it.yeplab.referral.dbconnection.DBConnectionFactory;

public class AgentiServlet extends HttpServlet {

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
		if (fun.equals("nuovo")) {
			String denominazione = req.getParameter("denominazione");
			String referente = req.getParameter("referente");
			String indirizzo = req.getParameter("indirizzo");
			String telefono = req.getParameter("telefono");
			String email = req.getParameter("email");
			String cf = req.getParameter("cf");
			String piva = req.getParameter("piva");
			String mezzopagamento = req.getParameter("mezzopagamento");
			String coordinatepagamento = req.getParameter("coordinatepagamento");
			ManagerAgenti ma = new ManagerAgenti(DBConnectionFactory.getConnection());
			int id = ma.addAgente(denominazione, referente, indirizzo, telefono, email, cf, piva, mezzopagamento,
					coordinatepagamento);
			msg = "nuovo agente=" + id;
		}
		if (fun.equals("cancella")) {
			int idagente = Integer.parseInt(req.getParameter("idagente"));
			ManagerAgenti ma = new ManagerAgenti(DBConnectionFactory.getConnection());
			int res = ma.remAgente(idagente);
			if (res > 0) {
				msg = "cancellato agente=" + idagente;
			} else {
				msg = "agente inesistente";
			}
		}
		if (fun.equals("modifica")) {
			int idagente = Integer.parseInt(req.getParameter("idagente"));
			String denominazione = req.getParameter("denominazione");
			String referente = req.getParameter("referente");
			String indirizzo = req.getParameter("indirizzo");
			String telefono = req.getParameter("telefono");
			String email = req.getParameter("email");
			String cf = req.getParameter("cf");
			String piva = req.getParameter("piva");
			String mezzopagamento = req.getParameter("mezzopagamento");
			String coordinatepagamento = req.getParameter("coordinatepagamento");
			ManagerAgenti ma = new ManagerAgenti(DBConnectionFactory.getConnection());
			int res = ma.editAgente(idagente, denominazione, referente, indirizzo, telefono, email, cf, piva,
					mezzopagamento, coordinatepagamento);
			if (res > 0) {
				msg = "modificato agente=" + idagente;
			} else {
				msg = "agente inesistente";
			}
		}
		if (fun.equals("password")) {
			int idagente = Integer.parseInt(req.getParameter("idagente"));
			String vecchiapassword = req.getParameter("vecchiapassword");
			String nuovapassword = req.getParameter("nuovapassword");
			ManagerAgenti ma = new ManagerAgenti(DBConnectionFactory.getConnection());
			int res=ma.cambioPassword(idagente, vecchiapassword, nuovapassword);
			if (res > 0) {
				msg = "modificato agente=" + idagente;
			} else {
				msg = "agente inesistente";
			}
		}
		out.print(msg);
	}

}
