$(document).ready(function()
{
	
	$("#userloginform").tooltip({
        position: {
            my: "center bottom-15",
            at: "center top",
            using: function( position, feedback ) {
                $( this ).css( position );
                $( "<div>" )
                .addClass( "arrow" )
                .addClass( feedback.vertical )
                .addClass( feedback.horizontal )
                .appendTo( this );
            }
        }
    });
	$.validator.setDefaults(
	{
	    //submitHandler: function() { alert("submitted!"); },
	    showErrors: function(map, list) {
	        // there's probably a way to simplify this
	        var focussed = document.activeElement;
	        if (focussed && $(focussed).is("input, textarea")) {
	            $(this.currentForm).tooltip("close", {
	                currentTarget: focussed
	            }, true)
	        }
	        this.currentElements.removeAttr("title").removeClass("ui-state-highlight");
	        $.each(list, function(index, error) {
	            $(error.element).attr("title", error.message).addClass("ui-state-highlight");
	        });
	        if (focussed && $(focussed).is("input, textarea")) {
	            $(this.currentForm).tooltip("open", {
	                target: focussed
	            });
	        }
	    }
	});
	
	$("#userloginform").validate(
	{
	    messages: {
	        "user.userName":"Please enter userName",
			"user.password":"Please enter password",
						
	
	    },              
	    rules: {
	    	"user.userName":{
	            "required": true
	    } ,
		
		"user.password":{
	        "required": true
	    },
		
	
	
		
		
	   }
	});
	

});