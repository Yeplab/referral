<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="it.yeplab.referral.dbconnection.DBConnectionFactory"%>
<%@page import="it.yeplab.referral.datamanager.*"%>
<%@page import="it.yeplab.referral.domaindata.*"%>

<!--   -----------------------------------------------------  DashBoard  ---------------------------------------------------------------->

<script>

$( document ).ready(function() {
  
  $( function() {
    $( "#progressbar" ).progressbar({
      value: 60
    });
  } );
  

  
  
  var config = {
        type: 'doughnut',
        data: {
            datasets: [{
                data: [
                    1,
                    2,
                    2,
                    2,
                ],
                backgroundColor: [
                    window.chartColors.red,
                    window.chartColors.orange,
                    window.chartColors.green,
                    window.chartColors.blue,
                ],
                label: 'Prodotti'
            }],
            labels: [
                "E-commerce",
                "Vetrina",
                "Seo",
                "Danea"
                
            ]
        },
        options: {
            responsive: true,
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: 'Vendita Prodotti'
            },
            animation: {
                animateScale: true,
                animateRotate: true
            }
        }
    };

 
    var ctx = document.getElementById("chart-area").getContext("2d");
    window.myDoughnut = new Chart(ctx, config);
    
	
		
	$(".settingDashGear").click(function(){
		console.log( "Apro chiudo Setting Dashboard" );
		$(".settingDashBox").toggle();
	});
	
	
	$(".settingDashButton").click(function(){
		
		var resu = $(".settingDashBox").find( "input:checked" ).map(function() {
			return this.id;
		}).get().join();
		
		console.log( resu);
		
	});	
	
});
  
  </script>

<div class="col_12">

<p class="titoloPagina">DashBoard <a class="settingDashGear"><i class="fa fa-gear" aria-hidden="true"></i></a></p>

<div class="col_12 settingDashBox">
<p>Seleziona solo i widget da visualizzare:</p>
	<input type="checkbox" id="infoUser" class="checkbox" checked> <label for="infoUser" class="inline">Info User</label><br>
	<input type="checkbox" id="venditaProdotti" class="checkbox"> <label for="venditaProdotti" class="inline">Vendita Prodotti</label><br>
	<input type="checkbox" id="ultimiClienti" class="checkbox"> <label for="ultimiClienti" class="inline">Ultimi Clienti</label><br>
	<input type="checkbox" id="ultimiPreventivi" class="checkbox"> <label for="ultimiPreventivi" class="inline">Ultimi Preventivi</label><br>
	<input type="checkbox" id="messaggi" class="checkbox"> <label for="messaggi" class="inline">Messaggi</label><br>
	<input type="checkbox" id="box6" class="checkbox"> <label for="box6" class="inline">Altro</label><br>
	<br><button class="medium green settingDashButton right"><i class="fa fa-save"></i> Salva</button>
</div>  
 
  
<div class="col_4 boxDash red">
<strong>
	<div class="col_12">
	<div class="col_6"><p><i class="fa fa-user" aria-hidden="true"></i> <%=agente.getReferente() %> <br><i class="fa fa-building" aria-hidden="true"></i> <%=agente.getDenominazione() %></p></div>
	<div class="col_6 right"><p><i class="fa fa-calendar" aria-hidden="true"></i> Attivo dal <br><%=agente.getDataiscrizione() %></p></div>
	</div>
	<div class="col_12">
	<span class="matu"><p>&euro; 600,00</p></span>
	<div id="progressbar"></div>
	<p class="right"><i class="fa fa-handshake-o right" aria-hidden="true"></i> Maturato al 29/11/2017</p>
	</div>
	<div class="col_12">
	<p>Riscatto a 1000&euro; o <a class="medium riscattaButton"><i class="fa fa-money"></i> Riscatta</a></p>
	</div>
	
</strong>
	
</div>

<div class="col_4 center boxDash orange">
	<div id="canvas-holder" style="width:100%" >
        <canvas id="chart-area" />
    </div>
</div>


<div class="col_4 center boxDash blue widgetClient">
	<%@ include file="clienti-widget.jsp"%>
</div>
<div class="col_4 center boxDash green widgetPrevent">
	<%@ include file="preventivi-widget.jsp"%>
</div>

<div class="col_4 center boxDash yellow widgetMessaggi">
	<%@ include file="messaggi-widget.jsp"%>
</div>

<div class="col_4 center boxDash cadetblue">
	altro
</div>

</div>

<!--   ----------------------------------------------------- FINE DashBoard  ---------------------------------------------------------------->