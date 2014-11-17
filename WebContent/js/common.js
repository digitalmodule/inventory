
$(document).ready(function(){
	$.fn.openDialogueWithoutTitleBar = function(id)
	{
	    if($("#"+id).parents(".ui-dialog").is(":visible") == false)
	    {
	        $("#"+id).siblings(".ui-dialog-titlebar").hide();
	        $("#"+id).dialog("open");
	    }
	};

	$.fn.closeDialogueWithoutTitleBar = function(id)
	{
	    if($("#"+id).parents(".ui-dialog").is(":visible"))
	    {    
	        $("#"+id).dialog("close");
	    } 
	};
	$.fn.createElement = function(cloneElementType, cloneId,containerId,namePattern)
	{	
		var counter = $('#'+containerId+' '+cloneElementType).length-2;
		$("#"+cloneId).clone()
					  .attr("id",cloneId + counter)
					  .appendTo($("#"+containerId))
					  .find(':input')
					  .not(':button, :submit, :reset, :hidden')
					  .val('')
					  .removeAttr('checked')
					  .removeAttr('selected');
		$("#"+cloneId+counter).find(':input')
							.not(':button, :submit, :reset')
							.each(function(index)
							{
								$(this).attr("name",$(this).attr("name").replace(namePattern,namePattern+"["+counter+"]"));
								$(this).removeAttr("disabled");
							});
		$("#"+cloneId + counter).show();
		counter++;
	};
	
	$.fn.clearFormElements = function(id)
	{
		$("#"+id).find(':input')
				  .not(':button, :submit, :reset, :hidden')
				  .val('')
				  .removeAttr('checked')
				  .removeAttr('selected');
	};
	
	$.fn.deleteElement = function(element, elementType, cloneId, containerId, namePattern)
	{
		var counter = $('#'+containerId+' tr').length-2;
		//alert(element.parents(elementType+':eq(0)'));
		var elementNo =element.parents(elementType+':eq(0)').attr("id").substring(cloneId.length);
		//alert(elementNo);
		currentRowNo=parseInt(elementNo)+2;
		var count = currentRowNo; 
		$("#"+containerId+" "+elementType+":gt("+(currentRowNo-1)+")").each(function()
		{
			if(count == currentRowNo)
			{	
				count++;
				return true;
			}
			row = $("#"+containerId+" "+elementType+":eq("+count+")");//.attr("id"));
			row.find(':input')
			   .not(':button, :submit, :reset')
				.each(function(index)
				{
					var oldName = namePattern+"["+(parseInt(elementNo)+1)+"]";
					var newName = namePattern+"["+elementNo+"]";
					$(this).attr("name",$(this).attr("name").replace(oldName,newName));					
				});
			row.attr("id",row.attr("id").replace(row.attr("id").substring(cloneId.length),elementNo));
			elementNo++;
			count++;
		});
		element.parents(elementType+':eq(0)').remove();
		counter--;
	};
	
	$.fn.performAddition = function(containerId, elementType, name, targetId)
	{
		total = 0;
		count = 0;
		var tempName = name;
		$("#"+containerId+" "+elementType+":gt(1)").each(function()
		{
			name = tempName.replace("0",count);	
			var value = (!isNaN(parseFloat($("input[name='"+name+"']").val()))) ? parseFloat($("input[name='"+name+"']").val()) : 0;
			total+=value;
			count++;
		});
		$("#"+targetId).val(total);
	};
	
	$.fn.performAverage = function(containerId, elementType, name, targetId)
	{
		total = 0;
		count = 0;
		avg = 0.0;
		var tempName = name;
		$("#"+containerId+" "+elementType+":gt(1)").each(function()
		{
			name = tempName.replace("0",count);	
			var value = (!isNaN(parseFloat($("input[name='"+name+"']").val()))) ? parseFloat($("input[name='"+name+"']").val()) : 0;
			total+=value;
			count++;
		});

		avg=parseFloat(total)/count;
		$("#"+targetId).val(avg.toFixed(2));
	};
	
	$(	"<div align='center' id='commonBusyDialog' class='ui-dialog-content ui-widget-content' style='display:none;z-index: 99999'>" +
			"<div align='center' style='vertical-align:middle;'>" +
				"<img id='ajaxLoadingImageId' width='60' vspace='0' hspace='0' height='60' align='center' alt='loading ...' src='../img/ajax-loader.gif' style='vertical-align:middle; margin-top:10px; z-index:1000'><br/>" +
				
			"</div><br>" +
			"<div id='ajaxLoadingMessageDivId'>Processing Data Please wait...</div>"+
		"</div>" +
		"<div class='ui-resizable-handle ui-resizable-true' style='z-index: 99999; -moz-user-select: none;' unselectable='on'></div>")
	.appendTo("body");
	
	$("#commonBusyDialog").dialog({
	      height: "auto",
              autoOpen: false,
	      maxHeight: 80,
	      //minHeight:150,
	      width:"auto",
	      //minWidth: 350,
	      maxWidth : 350,
	      modal: true
	    });
	$.fn.closeBusyDialogue = function()
	{
	    //setTimeout("alert('ad');",3000);
            if($("#commonBusyDialog").parents(".ui-dialog").is(":visible"))
            {    
                $('#commonBusyDialog').dialog('close');
                //setTimeout("$('#commonBusyDialog').dialog('close')",3000);
            } 
	};
	
	
	$.fn.openBusyDialogue = function()
	{
	   // if($("#commonBusyDialog").parents(".ui-dialog").is(":visible") == false)
	    {
	        $("#commonBusyDialog").siblings(".ui-dialog-titlebar").hide();
                
	        $("#commonBusyDialog").dialog("open");  
	    }
           
	};

	
        
        $("<div align='center' id='requestCompletedDialog' class='ui-dialog-content ui-widget-content' style='display:none;z-index: 99999'>" +
			"<div align='center' style='vertical-align:middle;'>" +
				"<img id='ajaxCompleteImageId' width='60' vspace='0' hspace='0' height='60' align='center' alt='loading ...' src='img/icon1.png' style='vertical-align:middle; margin-top:-15px; float:left;  z-index:1000'>" +
				
			"</div>" +
			"<div id='ajaxCompleteMessageDivId' style='margin-top:9px;padding-left:5px;color:#0066FF;width:280px;'> Request is completed</div>"+
		"</div>" +
		"<div class='ui-resizable-handle ui-resizable-true' style='z-index: 99999; -moz-user-select: none;' unselectable='on'></div>")
	.appendTo("body");
	
	$("#requestCompletedDialog").dialog({
	      height: "auto",
              autoOpen: false,
	      maxHeight: 80,
	      //minHeight:150,
	     // width:"auto",
	      //minWidth: 350,
	      maxWidth : 460,
              show: {
                effect: "bounce",
                duration: 1000
              },
              hide: {
                effect: "explode",
                duration: 1500
              },
	      modal: true
	    });    
        
        $.fn.openCompleteDialogue = function(message,time)
	{
	   // if($("#commonBusyDialog").parents(".ui-dialog").is(":visible") == false)
	    {
	        $("#requestCompletedDialog").siblings(".ui-dialog-titlebar").hide();
                $("#ajaxCompleteMessageDivId").html(message);
	        $("#requestCompletedDialog").dialog("open");
                if($("#requestCompletedDialog").parents(".ui-dialog").is(":visible"))
                {    
                    setTimeout("$('#requestCompletedDialog').dialog('close')",time);
                }
	    }
	};
	
	
	
	$(document).on("keydown",".number",function(event)
	{
        // Allow: backspace, delete, tab, escape, enter and .
        if ( $.inArray(event.keyCode,[46,8,9,27,13,190]) !== -1 ||
             // Allow: Ctrl+A
            (event.keyCode == 65 && event.ctrlKey === true) || 
             // Allow: home, end, left, right
            (event.keyCode >= 35 && event.keyCode <= 39)) {
                 // let it happen, don't do anything
                 return;
        }
        else
        {
            // Ensure that it is a number and stop the keypress
            if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) 
            {
                event.preventDefault(); 
            }   
        }
    });
	
    $.fn.checkBlankForNumber = function(value)
    {
            return (value == '')? '0':value;
    };
    
    $.fn.formatedDATE = function(date)
    {
        var d = new Date(date);
        var day = d.getDate();
        var month = d.getMonth() + 1;
        var year = d.getFullYear();
        if (day < 10) 
        {
            day = "0" + day;
        }
        if (month < 10) 
        {
            month = "0" + month;
        }
        return day + "/" + month + "/" + year;
    };
});
function validateComboBox(input)
{
   if(input.val()==="")
   {
       return false;
   }
   return true;
 }
 
 var message="Sorry, right-click has been disabled"; 
/////////////////////////////////// 
function clickIE() {if (document.all) {(message);return false;}} 
function clickNS(e) {if 
(document.layers||(document.getElementById&&!document.all)) { 
if (e.which==2||e.which==3) {(message);return false;}}} 
if (document.layers) 
{document.captureEvents(Event.MOUSEDOWN);document.onmousedown=clickNS;} 
else{document.onmouseup=clickNS;document.oncontextmenu=clickIE;} 
document.oncontextmenu=new Function("return false") ;

var ie = (function(){

    var undef,
        v = 3,
        div = document.createElement('div'),
        all = div.getElementsByTagName('i');

    while (
        div.innerHTML = '<!--[if gt IE ' + (++v) + ']><i></i><![endif]-->',
        all[0]
    );

    return v > 4 ? v : undef;

}());
// --> 
