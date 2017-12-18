<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="it.yeplab.referral.dbconnection.DBConnectionFactory"%>
<%@page import="it.yeplab.referral.datamanager.*"%>
<%@page import="it.yeplab.referral.domaindata.*"%>

<%
ManagerAgenti ma=new ManagerAgenti(DBConnectionFactory.getConnection());
Agente agente=ma.getAgenteById((Integer) request.getSession(false).getAttribute("agente"));
%>


<!--   -----------------------------------------------------  MENU   ---------------------------------------------------------------->
<ul class="menu">
<li class="titleMenu">Reseller<span class="redColor">Program</span></li>
<li class="current pagDashboard"><a><i class="fa fa-pie-chart"></i> DashBoard</a></li>
<li class="pagPreventivi"><a><i class="fa fa-file-text"></i> Preventivi</a></li>
<li class="pagClienti"><a><i class="fa fa-group"></i> Clienti</a></li>
<li class="pagListino"><a><i class="fa fa-money"></i> Listino</a></li>

<li><a href=""><i class="fa fa-inbox"></i> menu</a>
	<ul>
	<li><a href=""><i class="fa fa-cog"></i> Sub Item</a></li>
	<li><a href=""><i class="fa fa-envelope"></i> Sub Item</a></li>
	<li class="divider"><a href=""><i class="fa fa-trash"></i> li.divider</a></li>
	</ul>
</li>

<li class="right logOutButtonMenu"><a href=""><i class="fa fa-sign-out"></i> Esci</a></li>
<li class="right userMenu"><a><i class="fa fa-user" aria-hidden="true"></i> <%=agente.getReferente()%></a></li>
<li class="right pagMessaggi"><a><i Style="color:red" class="fa fa-comments" aria-hidden="true"></i> <span class="mexNotice">2</span> Messaggi</a></li>

</ul>

<!--   ----------------------------------------------------- FINE MENU   ------------------------------------------------------------->
