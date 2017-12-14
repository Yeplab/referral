$( document ).ready(function() {
    console.log( "Inzio Script" );
	$(".settingDashBox").hide();
	assignEventMenu();
	assignEventListClient();
	assignEventListPreventivi();
	assignEventMessages();
	
});


function assignEventMenu(){
	
	console.log( "Assegno Eventi menu" );
	var menu = $(".menu");
	
	var pagDashboard = menu.find(".pagDashboard");
		pagDashboard.click(function(){
			setCurrentClass(menu,$(this));
			console.log("vado a dashboard");
			$(".contenitore").load("pages/dashboard.jsp");
		});
	
	var pagPreventivi = menu.find(".pagPreventivi");
		pagPreventivi.click(function(){
			setCurrentClass(menu,$(this));
			console.log("vado a pagPreventivi");
			$(".contenitore").load("pages/preventivi.jsp");
		});
		
	var pagClienti = menu.find(".pagClienti");
		pagClienti.click(function(){
			setCurrentClass(menu,$(this));
			console.log("vado a pagClienti");
			$(".contenitore").load("pages/clienti.jsp");
		});
		
	var pagListino = menu.find(".pagListino");
		pagListino.click(function(){
			setCurrentClass(menu,$(this));
			console.log("vado a pagListino");
			$(".contenitore").load("pages/listino.jsp");
		});
		
	var pagMessaggi = menu.find(".pagMessaggi");
		pagMessaggi.click(function(){
			setCurrentClass(menu,$(this));
			console.log("vado a pagMessaggi");
			$(".contenitore").load("pages/messaggi.jsp");
		});
		
		
	var logOutButtonMenu = menu.find(".logOutButtonMenu");
		logOutButtonMenu.click(function(){
			logOut();
		});
		
	$(".accediButton").click(function() {
		login();
	});	
		
	
}

function setCurrentClass(menu,sel){
	menu.find(".current").removeClass("current");
	sel.addClass("current");
}

function assignEventListClient(){
	
	var tr =  $(".listaClienti").find("tr");
	tr.click(function(){
		
		if($(this).hasClass("clientTR")){
			tr.removeClass("clientTR");
			$(".buttonBarClient").find("button").hide();
		}else{
			tr.removeClass("clientTR");
			$(this).addClass("clientTR");
			console.log( $(this).attr("idCliente"));
			$(".buttonBarClient").find("button").show();
		}
	});
	
	$(".clientDeleteButton").click(function(){
		removeClient($(".listaClienti").find(".clientTR").attr("idCliente"));
	});
	
	$(".clientEditButton").click(function(){
		editClient($(".listaClienti").find(".clientTR").attr("idCliente"));
	});
	
	$(".clientAddButton").click(function(){
		$(".contenitore").load("pages/addCliente.jsp");
	});
	
	
	
}

function assignEventListPreventivi(){
	
	var tr =  $(".listaPreventivi").find("tr");
	tr.click(function(){
		
		if($(this).hasClass("preventiviTR")){
			tr.removeClass("preventiviTR");
			$(".buttonBarPreventivi").find("button").hide();
		}else{
			tr.removeClass("preventiviTR");
			$(this).addClass("preventiviTR");
			console.log( $(this).attr("idPreventivo"));
			$(".buttonBarPreventivi").find("button").show();
		}
	});
	
	
	$(".preventivoDeleteButton").click(function(){
		removePreventivo($(".listaPreventivi").find(".preventiviTR").attr("idPreventivo"));
	});
	
	$(".preventivoEditButton").click(function(){
		editPreventivo($(".listaPreventivi").find(".preventiviTR").attr("idPreventivo"));
	});
	
	$(".preventivoAddButton").click(function(){
		$(".contenitore").load("pages/nuovoPreventivo.jsp");
	});
	
	
}

function assignEventMessages(){
	$(".unRead").click(function(){
		leggiMessaggio($(this).attr("idMex"));
		$(".contenitore").load("pages/messaggi.jsp");
	});
	
}





function login(){
	addNoticeSuccess("button pressed");
	var loginBlock = $(".loginBlock");
	
	var email = loginBlock.find("#user").val();
	var pass = loginBlock.find("#pass").val();
	
	if (email === "") {
		//alert("inserisci l'user");
	} else if (password === "") {
		//alert("inserisci la password");
	} else {
		// doLogin
		var fun = "login";
		$.ajax({
			url : "/referral/Session",
			data : {
				fun : fun,
				email : email,
				password : pass
			},
			type : "POST",
			success : function(text) {
				var out=str.split("= ");
				if (out[0]==="agente") {
					if(out[1]!="-1"){
						//login ok
						addNoticeSuccess(text);
					}else{
						//email eo pass errati
						addNoticeWarning("email eo password errati");
					}
				} else {
					//ERRORE SERVLET
					addNoticeError("Servlet ERR");
				}
			},
			error : function() {
				addNoticeError("AJAX ERR");
			}
		});
	}
	
	
}

function logOut(){
	
	
}

function removeClient(id){
	addNoticeWarning("Rimuovo l'utente con id: "+id);
	console.log("Rimuovo cliente con id:"+id);
}

function editClient(id){
	addNoticeWarning("Stai Modificando il cliente con id: "+id);
	console.log("modifico cliente con id:"+id);
}

function removePreventivo(id){
	addNoticeError("Sto rimuovendo preventico con id: "+id);
	console.log("Rimuovo preventivo con id:"+id);
}

function editPreventivo(id){
	addNoticeWarning("Stai Modificando il preventivo con id: "+id);
	console.log("modifico preventivo con id:"+id);
}

function leggiMessaggio(id){
	addNoticeSuccess("Sul server imposto come letto il messaggio con id: "+id);
	console.log("Sul server imposto come letto il messaggio con id: "+id);
}
