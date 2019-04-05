$( function() {
    $( ".datepicker" ).datepicker({
    	dateFormat: 'dd/mm/yy',
      /*showOn: "button",
      buttonImage: "static/img/calendar.gif",*/
      buttonImageOnly: true,
      changeMonth: true,
      changeYear: true,
      buttonText: "Select date",
      readOnly:true,
      
      showButtonPanel: true,
      /*yearRange: '1985, 2050',*/
      
      closeText: 'Clear',
    	  
    	     /*  onClose: function (dateText, inst) {
    	             if ($(window.event.srcElement).hasClass('ui-datepicker-close'))
    	            	 {
    	            	 document.getElementById(this.id).value = "";
    	            	 }	
    	             },*/
    beforeShow: function( input ) {
        setTimeout(function () {
            $(input).datepicker("widget").find(".ui-datepicker-current").hide();
            var clearButton = $(input ).datepicker( "widget" ).find( ".ui-datepicker-close" );
            clearButton.unbind("click").bind("click",function(){$.datepicker._clearDate( input );});
        }, 1 );
    }
    });
  
    
  } );