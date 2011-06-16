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

