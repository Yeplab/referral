

<!--   -----------------------------------------------------  PREVENTIVI WIDGET  ---------------------------------------------------------------->
 


<span class="prevPageWidget">
<div class="col_12"><p class="titoloPagina">Ultimi Preventivi</p></div>

	<table class="striped tight sortable">
		<thead><tr>
	<th>Cliente</th>
	<th>Tipologia</th>
	<th>Tot Preventivo</th>

	
</tr></thead>
<tbody class="listaPreventivi">

<tr idPreventivo="1">
	<td>Gasperoni Marco</td>
	<td>Ecommerce</td>
	<td>1000 &euro;</td>
</tr>


</tbody>
	</table>
	
</span>

<!--   ----------------------------------------------------- FINE PREVENTIVI WIDGET  ---------------------------------------------------------------->


<script>
$( document ).ready(function() {
	
	var m = $(".menu");
    $(".prevPageWidget").click(function(){
		$(".contenitore").load("pages/preventivi.jsp");
		m.find(".current").removeClass("current");
		m.find(".pagPreventivi").addClass("current");
		
	});
	
});



</script>


