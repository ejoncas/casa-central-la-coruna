function showDialogModal(selector){
	$(""+selector).dialog({
			modal: true,
			show: "blind",
			buttons: {
				Ok: function() {
					$( this ).dialog( "close" );
				}
			}
		});
}

function jqAlert(message, title){
	$("body").append("<div id='temp' title="+title+">"+message+"</div>");
	$("#temp").dialog({modal: true,buttons: {Ok: function() {$(this).dialog('close');$("#temp").remove();}}});
}
function jqAlert(message, title, f){
	$("body").append("<div id='temp' title="+title+">"+message+"</div>");
	$("#temp").dialog({modal: true,buttons: {Ok: function() {$(this).dialog('close');$("#temp").remove();f();}}});
}