<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="it.yeplab.referral.dbconnection.DBConnectionFactory"%>
<%@page import="it.yeplab.referral.datamanager.ManagerClienti"%>
<%@page import="it.yeplab.referral.domaindata.Cliente"%>

<!--   ----------------------------------------------------- AGGIUNGI CLIENTE  ---------------------------------------------------------------->
<%
ManagerClienti mc=new ManagerClienti(DBConnectionFactory.getConnection());
Cliente c=mc.getClienteById(Integer.parseInt(request.getParameter("id")));
%>

<div class="col_12 	pagina">

<div class="col_12"><p class="titoloPagina">Modifica Cliente (id:<%=c.getId() %>)</p></div>



<div class="col_12">

<div class="col_2">
		<label for="denominazione"><i class="fa fa-user"></i> Denominazione</label><br>
		<input id="denominazione" type="text" value="<%=c.getDenominazione()%>"><br>
</div>

<div class="col_2">
		<label for="referente"><i class="fa fa-user"></i> Referente</label><br>
		<input id="referente" type="text" value="<%=c.getReferente()%>"><br>
</div>

<div class="col_2">
		<label for="indirizzo"><i class="fa fa-user"></i> Indirizzo</label><br>
		<input id="indirizzo" type="text" value="<%=c.getIndirizzo()%>"><br>
</div>

<div class="col_2">
		<label for="telefono"><i class="fa fa-user"></i> Telefono</label><br>
		<input id="telefono" type="text" value="<%=c.getTelefono()%>"><br>
</div>

<div class="col_2">
		<label for="email"><i class="fa fa-user"></i> Email</label><br>
		<input id="email" type="text" value="<%=c.getEmail()%>"><br>
</div>

<div class="col_2">
		<label for="cf"><i class="fa fa-phone"></i> Cod.Fis.</label><br>
		<input id="cf" type="text" value="<%=c.getCf()%>"><br>
</div>

<div class="col_2">
		<label for="piva"><i class="fa fa-user"></i> P.Iva</label><br>
		<input id="piva" type="text" value="<%=c.getPiva()%>"><br>
</div>

<div class="col_8">
		<label for="note"><i class="fa fa-user"></i> Note</label><br>
		<textarea class="textareaCliente" id="note" type="text" value="<%=c.getNote()%>" ></textarea><br>
</div>

	
</div>
<div class="col_6 right">
<button class="medium green" id="modificaClienteButton" idCliente="<%=c.getId() %>"><i class="fa fa-save"></i> MODIFICA</button>
</div>
<div class="col_6 left">
<button class="medium red" id="annullaModificaCliente"><i class="fa fa-save"></i> ANNULLA</button>
</div>

</div>

<!--   -----------------------------------------------------  FINE CLIENTI  ---------------------------------------------------------------->

<script>
	assignEventListClient();
</script>