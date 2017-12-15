<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Yeplab - Referal Program</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="js/kickstart.js"></script>
<!-- KICKSTART -->
<link rel="stylesheet" href="css/kickstart.css" media="all" />
<!-- KICKSTART -->
<link rel="stylesheet" href="css/yeplab.css" media="all" />
<!-- YEPLAB -->
<link rel="stylesheet" type="text/css" href="style.css" media="all" />
<!-- CUSTOM STYLES -->

<link rel="stylesheet"
	href="css/fonts/font-awesome-4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>


<script src="js/Chart.bundle.js"></script>
<script src="js/utils.js"></script>

<script src="js/yeplab.js"></script>

</head>
<body>

	<div class="infoNotice col_3"></div>

	<%
		if ((Integer)request.getSession(false).getAttribute("agente")!=null) {
	%>

	<!--   -----------------------------------------------------  CONTENITORE  ---------------------------------------------------------------->

	<%@ include file="pages/menu.jsp"%>

	<div class="contenitore col_12">

		<%@ include file="pages/dashboard.jsp"%>

	</div>

	<!--   ----------------------------------------------------- FINE CONTENITORE  ---------------------------------------------------------------->

	<%
		} else {
	%>

	<%@ include file="pages/login.jsp"%>

	<%
		}
	%>

</body>

</html>