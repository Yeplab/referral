package it.yeplab.referral.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.yeplab.referral.datamanager.ManagerClienti;
import it.yeplab.referral.dbconnection.DBConnectionFactory;

public class ClientiServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doJob(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doJob(req, resp);
	}
	
	private void doJob(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		String msg = "";
		String fun = req.getParameter("fun");
		if (fun.equals("nuovo")) {
			String denominazione=req.getParameter("denominazione");
			String referente=req.getParameter("referente");
			String indirizzo=req.getParameter("indirizzo");
			String telefono=req.getParameter("telefono");
			String email=req.getParameter("email");
			String cf=req.getParameter("cf");
			String piva=req.getParameter("piva");
			int idagente=(int) req.getSession().getAttribute("agente");
			String note=req.getParameter("note");
			ManagerClienti mc=new ManagerClienti(DBConnectionFactory.getConnection());
			int id=mc.addCliente(denominazione, referente, indirizzo, telefono, email, cf, piva, idagente, note);
			msg = "nuovo cliente=" + id;
		}
		if (fun.equals("cancella")) {
			int idcliente=Integer.parseInt(req.getParameter("idcliente"));
			ManagerClienti mc=new ManagerClienti(DBConnectionFactory.getConnection());
			int res=mc.remCliente(idcliente);
			if(res>0) {
				msg="cancellato cliente="+idcliente;
			}else {
				msg="cliente inesistente";
			}
		}
		if (fun.equals("modifica")) {
			int idcliente=Integer.parseInt(req.getParameter("idcliente"));
			String denominazione=req.getParameter("denominazione");
			String referente=req.getParameter("referente");
			String indirizzo=req.getParameter("indirizzo");
			String telefono=req.getParameter("telefono");
			String email=req.getParameter("email");
			String cf=req.getParameter("cf");
			String piva=req.getParameter("piva");
			int idagente=Integer.parseInt(req.getParameter("idagente"));
			String note=req.getParameter("note");
			ManagerClienti mc=new ManagerClienti(DBConnectionFactory.getConnection());
			int id=mc.editCliente(idcliente, denominazione, referente, indirizzo, telefono, email, cf, piva, idagente, note);			
			msg = "modificato cliente=" + id;
		}
		out.print(msg);
	}

}
