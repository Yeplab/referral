





<!--   -----------------------------------------------------  CLIENTI WIDGET  ---------------------------------------------------------------->

<span class="clientPageWidget">

<div class="col_12"><p class="titoloPagina">Ultimi Clienti</p></div>


<div class="col_12">
	<table class="striped tight sortable">
	<thead><tr>
	<th>Referente</th>
	<th>Rag Sociale</th>
	<th>Email</th>
</tr></thead>
<tbody class="listaClienti">

<tr idCliente="1" >
	<td>Gasperoni</td>
	<td>Unideatec SRL</td>
	<td>info@email.it</td>
</tr>



</tbody>
	</table>
	
	</div>
</span>


<!--   -----------------------------------------------------  FINE CLIENTI WIDGET ---------------------------------------------------------------->

<script>
$( document ).ready(function() {
	
	var m = $(".menu");
    $(".clientPageWidget").click(function(){
		$(".contenitore").load("pages/clienti.jsp");
		m.find(".current").removeClass("current");
		m.find(".pagClienti").addClass("current");
		
	});
	
});



</script>


