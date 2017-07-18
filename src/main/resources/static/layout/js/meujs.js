$(function(){

	//alert("teste");
	
	$('#callPopover').popover({
		trigger: 'click focus',
		html:'true',
		placement:'bottom',
        container: 'body',
		content: $('#myPopover').html()
	});
    
    $('#callPopover').click(function(){
        $('#callPopover').popover('show');
    });
    
    $(document).keyup(function (event) {
        if (event.which === 27) {
            $('#callPopover').popover('hide');
        }
    });


});


