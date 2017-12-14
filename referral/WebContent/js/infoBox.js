
const TIME = '33000';



function addNoticeSuccess(message){
	var infoBox = $(".infoNotice");
	var d = new Date();
	var id = d.getTime();
	var text = '<div id="'+id+'" class="notice success"><i class="fa fa-check"></i>'+message+'</div>'
	infoBox.append(text);
	deleteInfo("#"+id);
}

function addNoticeWarning(message){
	var infoBox = $(".infoNotice");
	var d = new Date();
	var id = d.getTime();
	var text = '<div id="'+id+'" class="notice warning"><i class="fa fa-exclamation-triangle"></i>'+message+'</div>'
	infoBox.append(text);
	deleteInfo("#"+id);
}

function addNoticeError(message){
	var infoBox = $(".infoNotice");
	var d = new Date();
	var id = d.getTime();
	var text = '<div id="'+id+'" class="notice error"><i class="fa fa-exclamation"></i>'+message+'</div>'
	infoBox.append(text);
	deleteInfo("#"+id);
}


function deleteInfo(id){
	setTimeout(function() {$( id ).remove()}, TIME);
	
}




