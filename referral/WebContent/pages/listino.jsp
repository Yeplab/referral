<%@page import="it.yeplab.referral.datamanager.ManagerProdotti"%>
<%@page import="it.yeplab.referral.datamanager.ManagerCategorie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="it.yeplab.referral.dbconnection.DBConnectionFactory"%>
<%@page import="it.yeplab.referral.datamanager.ManagerCategorie"%>
<%@page import="it.yeplab.referral.datamanager.ManagerProdotti"%>
<%@page import="it.yeplab.referral.domaindata.Categoria"%>
<%@page import="it.yeplab.referral.domaindata.Prodotto"%>
<%@page import="it.yeplab.referral.domaindata.Agente"%>
<%@page import="java.util.List"%>

<%
	ManagerCategorie mc = new ManagerCategorie(DBConnectionFactory.getConnection());
	ManagerProdotti mp = new ManagerProdotti(DBConnectionFactory.getConnection());
%>

<!--   -----------------------------------------------------  LISTINO PRODOTTI  ---------------------------------------------------------------->

<div class="col_12 	pagina">

	<div class="col_12">
		<p class="titoloPagina">Listino Prodotti</p>
	</div>

	<%
		List<Categoria> categorie = mc.getListaCategorie();
		for (Categoria c : categorie) {
	%>

	<h6 idCategoria="<%=c.getId()%>"><%=c.getNome()%></h6>

	<%
		List<Prodotto> prodotti = mp.getListaProdottiCategoria(c.getId(), ManagerProdotti.AGENTE,
					((Agente) request.getSession(false).getAttribute("agente")).getId());
	%>

	<%
		for (Prodotto p : prodotti) {
	%>

	<div class="col_3 boxProdotto" idProdotto="<%=p.getId()%>">
		<div class="col_8">
			<h5><%=p.getNome()%></h5>
		</div>
		<div class="col_4 right redColor">
			<h4>
				&euro;
				<%=p.getPrezzo()%></h4>
		</div>
		<div class="col_12">

			<p><%=p.getDescrizione()%></p>

		</div>

		<div class="col_12 productFooter">
			<div class="col_4 left">
				<p>
					<a href="#"><i class="fa fa-download"></i> Scheda Tecnica</a>
				</p>
			</div>
			<div class="col_8 right">
				<p>
					Provviggione del
					<%=p.getProvvigione()%>
					(&euro;
					<%=p.getCalcoloProvvigione()%>)
				</p>
			</div>

		</div>

	</div>

	<%
		}
		}
	%>

</div>

<!--   ----------------------------------------------------- FINE LISTINO PRODOTTI  ---------------------------------------------------------------->