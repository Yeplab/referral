<!--   ----------------------------------------------------- AGGIUNGI CLIENTE  ---------------------------------------------------------------->


<div class="col_12 	pagina">

<div class="col_12"><p class="titoloPagina">Aggiungi Cliente</p></div>



<div class="col_12">

<div class="col_2">
		<label for="denominazione"><i class="fa fa-user"></i> Denominazione</label><br>
		<input id="denominazione" type="text" value=""><br>
</div>

<div class="col_2">
		<label for="referente"><i class="fa fa-user"></i> Referente</label><br>
		<input id="referente" type="text" value=""><br>
</div>

<div class="col_2">
		<label for="indirizzo"><i class="fa fa-user"></i> Indirizzo</label><br>
		<input id="indirizzo" type="text" value=""><br>
</div>

<div class="col_2">
		<label for="telefono"><i class="fa fa-user"></i> Telefono</label><br>
		<input id="telefono" type="text" value=""><br>
</div>

<div class="col_2">
		<label for="email"><i class="fa fa-user"></i> Email</label><br>
		<input id="email" type="text" value=""><br>
</div>

<div class="col_2">
		<label for="cf"><i class="fa fa-phone"></i> Cod.Fis.</label><br>
		<input id="cf" type="text" value=""><br>
</div>

<div class="col_2">
		<label for="piva"><i class="fa fa-user"></i> P.Iva</label><br>
		<input id="piva" type="text" value=""><br>
</div>

<div class="col_8">
		<label for="note"><i class="fa fa-user"></i> Note</label><br>
		<textarea class="textareaCliente" id="note" type="text" value="" ></textarea><br>
</div>

	
</div>
<div class="col_6 right">
<button class="medium green" id="aggiungiClienteButton"><i class="fa fa-save"></i> AGGIUNGI</button>
</div>
<div class="col_6 left">
<button class="medium red" id="annullaOperazione"><i class="fa fa-save"></i> ANNULLA</button>
</div>

</div>

<!--   -----------------------------------------------------  FINE CLIENTI  ---------------------------------------------------------------->

<script>
	assignEventListClient();
</script>