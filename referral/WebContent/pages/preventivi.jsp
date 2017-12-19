

<!--   -----------------------------------------------------  PREVENTIVI  ---------------------------------------------------------------->
 

<div class="col_12 	pagina">

<div class="col_8"><p class="titoloPagina">Elenco Preventivi</p></div>
<div class="col_2 right">
<button class="small green preventivoAddButton"><i class="fa fa-plus"></i> AGGIUNGI NUOVO</button>
</div>
<div class="col_2 right buttonBarPreventivi">
<button class="small blue hide preventivoEditButton"><i class="fa fa-edit"></i> MODIFICA</button>
<button class="small red hide preventivoDeleteButton"><i class="fa fa-trash"></i> ELIMINA</button>
</div>



	<table class="tight">
		<thead><tr>
	<th>Id Preventivo</th>
	<th>Referente</th>
	<th>Cliente</th>
	<th>Tipologia</th>
	<th>Tot Preventivo</th>
	<th>Provvigione</th>
	<th>Maturato</th>
	<th>Stato</th>
	<th>Scarica</th>
	
</tr></thead>
<tbody class="listaPreventivi">

<tr idPreventivo="1">
	<td>PRVE001</td>
	<td>Vitale Enrico</td>
	<td>Gasperoni Marco</td>
	<td>Ecommerce</td>
	<td>1000 &euro;</td>
	<td>20%</td>
	<td>200 &euro;</td>
	<td>Accettato</td>
	<td>PRVE001.pdf</td>
</tr>

<tr idPreventivo="2">
	<td>PRVE002</td>
	<td>Ferraro Giuseppe</td>
	<td>Gasperoni Marco</td>
	<td>Ecommerce</td>
	<td>1000 &euro;</td>
	<td>20%</td>
	<td>200 &euro;</td>
	<td>Accettato</td>
	<td>PRVE001.pdf</td>
</tr>


</tbody>
	</table>
	
	
</div>

<!--   ----------------------------------------------------- FINE PREVENTIVI  ---------------------------------------------------------------->



<script>assignEventListPreventivi();</script>

