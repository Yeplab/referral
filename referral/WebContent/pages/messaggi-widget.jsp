





<!--   -----------------------------------------------------  MESSAGGI  ---------------------------------------------------------------->

<span class="mexPageWidget">
<div class="col_12"><p class="titoloPagina">Messaggi Ricevuti <span class="mexNotice">2</span></p></div>

	<table class="striped tight sortable">
	<thead><tr>
	<th>Oggetto</th>
	<th>Testo</th>
</tr></thead>
<tbody>

<tr idMessaggio="1" class="unRead" >
	<td>Nuovo Preventivo</td>
	<td>A generic iterator function, which can be used to seamlessly...</td>
	
	
</tr>

<tr idMessaggio="2">
	<td>Preventivo Rifiutato</td>
	<td>A generic iterator function, which can be used to seamlessly...</td>
</tr>


</tbody>
	</table>
	
	
</span>


<!--   -----------------------------------------------------  FINE MESSAGGI  ---------------------------------------------------------------->

<script>
$( document ).ready(function() {
	
	var m = $(".menu");
    $(".mexPageWidget").click(function(){
		$(".contenitore").load("pages/messaggi.jsp");
		m.find(".current").removeClass("current");
		m.find(".pagMessaggi").addClass("current");
		
	});
	$(".unRead").click(function(){
		$(".contenitore").load("pages/messaggi.jsp");
		m.find(".current").removeClass("current");
		m.find(".pagMessaggi").addClass("current");
	});

	
});



</script>



