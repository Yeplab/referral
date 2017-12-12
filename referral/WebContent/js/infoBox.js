

function addNoticeSuccess(message){
	var infoBox = $(".infoNotice");
	var d = new Date();
	var id = d.getTime();
	var text = '<div id="'+id+'" class="notice success"><i class="fa fa-check"></i>'+message+'</div>'
	infoBox.append(text);
	deleteInfo("#"+id,3000);
}

function addNoticeWarning(message){
	var infoBox = $(".infoNotice");
	var d = new Date();
	var id = d.getTime();
	var text = '<div id="'+id+'" class="notice warning"><i class="fa fa-exclamation-triangle"></i>'+message+'</div>'
	infoBox.append(text);
	deleteInfo("#"+id,3000);
}

function addNoticeError(message){
	var infoBox = $(".infoNotice");
	var d = new Date();
	var id = d.getTime();
	var text = '<div id="'+id+'" class="notice error"><i class="fa fa-exclamation"></i>'+message+'</div>'
	infoBox.append(text);
	deleteInfo("#"+id,3000);
}


function deleteInfo(id,time){
	setTimeout(function() {$( id ).remove()}, time);
	
}




