<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="it.yeplab.referral.dbconnection.DBConnectionFactory"%>
<%@page import="it.yeplab.referral.datamanager.ManagerClienti"%>
<%@page import="it.yeplab.referral.domaindata.Cliente"%>
<%@page import="java.util.List"%>

<%
	ManagerClienti mc = new ManagerClienti(DBConnectionFactory.getConnection());
	List<Cliente> clienti = mc.getListaClientiAgente((Integer) request.getSession(false).getAttribute("agente"));
%>

<!--   -----------------------------------------------------  CLIENTI  ---------------------------------------------------------------->


<div class="col_12 	pagina">

	<div class="col_8">
		<p class="titoloPagina">Clienti</p>
	</div>
	<div class="col_2 right">
		<button class="small green clientAddButton">
			<i class="fa fa-plus"></i> AGGIUNGI NUOVO CLIENTE
		</button>
	</div>
	<div class="col_2 right buttonBarClient">
		<button class="small blue hide clientEditButton">
			<i class="fa fa-edit"></i> MODIFICA
		</button>
		<button class="small red hide clientDeleteButton">
			<i class="fa fa-trash"></i> ELIMINA
		</button>
	</div>

	<table class="striped tight sortable">
		<thead>
			<tr>
				<th>Denominazione</th>
				<th>Referente</th>
				<th>Indirizzo</th>
				<th>Telefono</th>
				<th>Email</th>
				<th>Cod.Fis.</th>
				<th>P.Iva</th>
				<th>Note</th>
			</tr>
		</thead>

		<tbody class="listaClienti">

			<%
				for (Cliente c : clienti) {
			%>

			<tr idCliente="<%=c.getId()%>">
				<th><%=c.getDenominazione()%></th>
				<th><%=c.getReferente()%></th>
				<th><%=c.getIndirizzo()%></th>
				<th><%=c.getTelefono()%></th>
				<th><%=c.getEmail()%></th>
				<th><%=c.getCf()%></th>
				<th><%=c.getPiva()%></th>
				<th><%=c.getNote()%></th>
			</tr>

			<%
				}
			%>

		</tbody>
	</table>


</div>


<!--   -----------------------------------------------------  FINE CLIENTI  ---------------------------------------------------------------->

<script>
	assignEventListClient();
</script>



