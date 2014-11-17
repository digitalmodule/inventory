$(document).ready(function()
{
	$("#disableCustomerConfirmDialogue").dialog({
        autoOpen: false,
        resizable: false,
        width: 300,
        height: 220,
        modal: true,
        buttons:
                {
                    "Ok": function()
                    {
                        //alert(deleteCandidateId);

                        $.fn.closeDialogueWithoutTitleBar("disableCustomerConfirmDialogue");
                    },
                }
    });

    $("#createTicketDiv").dialog({
        autoOpen: false,
        resizable: false,
        height: "auto",
        modal: true,
    });
    $(document).off("click", '#createTicket').on("click", "#createTicket", function(e)
    {
    	//$("#ticketEmailSubject").val($("#buildingRoomNo").children("option").is("selected").text());
    	$("#ticketEmailSubject").val($("#buildingRoomNo option:selected").text());
    	$("#ticketEmailMessage").val($("#comments").val());
    	$("#createTicketDiv").dialog("open");
    });
    
    $('#ticketEmailForm').livequery(function()
	{
		$("#ticketEmailForm").ajaxForm (
		{
		    dataType: "json",
		    success: function(jsonData)
		    {
		    	if (jsonData.success == true)
		        {
		    		$.fn.closeDialogueWithoutTitleBar("createTicketDiv");
		    		var succesNotyOptions = {
		                "text": "Ticket Email has been sent successfully",
		                "layout": "center",
		                "type": "success",
		                "modal": true,
		                "timeout" : 3000,
		            };
		            noty(succesNotyOptions);
		            
		        }
		        else if (jsonData.success == false)
		        {
		            if(jsonData.error == 'You are not logged in, Please log in to send Email')
		            {
		            	var errorNotyOptions = {
			                "text": jsonData.error,
			                "layout": "center",
			                "type": "error",
			                "modal": true,
			                "timeout" : 3000,
			                callback:
			                {
			                    afterClose: function() 
			                    {

			                    	window.location = "../common/Index.html";
			                    }
			                },
			            };
	            	 	noty(errorNotyOptions);
		            }	
		            else
		            {	
			        	var errorNotyOptions = {
			                "text": jsonData.error,
			                "layout": "bottomRight",
			                "type": "error",
			                "modal": true,
			                "timeout" : 1500
			            };
			        	 noty(errorNotyOptions);
		            }
		           
		        }
		    }
		});
	});

    $("#projectorsModelDiv").dialog({
        autoOpen: false,
        resizable: false,
        height: "auto",
        modal: true,
    });
    $(document).off("click", '.projectorsModel').on("click", ".projectorsModel", function(e)
    {
        $.ajax({
	        type: 'post',
	        url: '../inventory/GetProjectorInfo.html',
	        data: 'projectorId=' + $(this).attr("id"),
	        dataType: 'json',
	        async: 'true',
	        cache: 'false',
	        success: function(projector)
	        {
	        	 $('#projectorId').val(projector.no); 
	        	 $('#projectorLastUpdatedBy').val(projector.lastupdatedby);
	        	 $('#projectorLastUpdatedtime').val(projector.updatedatetime);
	        	 $('#projectorMUBarcode').val(projector.projectormubarcode);
	        	 $('#projectorManuDate').html(projector.projectormanudate);
	        	 $('#projectorCurrentAgeYears').html(projector.projectorcurrentageyears);
	        	 $('#bulbHoursUsed').val(projector.bulbhoursused);
	        	 $('#bulbReplaceDate').html(projector.bulbreplacedate);
	        	 $('#filterHoursUsed').val(projector.filterhoursused);
	        	 $('#filterReplaceDate').html(projector.filterreplacedate);
	        	 $('#equipLocks').val(projector.equiplocks);
	        }
	    });
        $("#projectorsModelDiv").dialog("open");
    });

    $("#modelInformationDiv").dialog({
        autoOpen: false,
        resizable: false,
        height: "auto",
        modal: true,
    });

    $("#computerModelDiv").dialog({
        autoOpen: false,
        resizable: false,
        height: "auto",
        modal: true,
    });
    $(document).off("click", '.computerModel').on("click", ".computerModel", function(e)
    {
    	$.ajax({
	        type: 'post',
	        url: '../inventory/GetComputerInfo.html',
	        data: 'computerId=' + $(this).attr("id"),
	        dataType: 'json',
	        async: 'true',
	        cache: 'false',
	        success: function(computer)
	        {
	        	 $('#computerId').val(computer.no); 
	        	 $('#computerLastUpdatedBy').val(computer.lastupdatedby); 
	        	 $('#computerLastUpdatedtime').val(computer.updatedatetime); 
	        	 $('#computerSerial').val(computer.computerserial); 
	        	 $('#computerModel').html(computer.computermodel); 
	        	 $('#linkToMakerHrefId').prop("href", computer.linktomaker); 
	        	 $('#linkToSoftwarePageHrefId').prop("href", computer.linktosoftwarepage); 
	        	 $('#computerMUBarCode').val(computer.computermubarcode); 
	        	 $('#computerManuDate').html(computer.computermanudate); 
	        	 $('#computerCurrentAgeYears').val(computer.computercurrentageyears); 
	        	 $('#specialSoftware').val(computer.specialsoftware); 
	        	 $('#monitorType').val(computer.monitortype); 
	        	 $('#computerEquipLocks').val(computer.equiplocks); 
	        	 $('#userPass').val(computer.userpass); 
	        	 $('#bIOSPass').val(computer.biospass); 
	        	 $('#smartShieldPass').val(computer.smartshieldpass);  
	        }
	    });
    	$("#computerModelDiv").dialog("open");

    });

    $("#computerInformationDiv101").dialog({
        autoOpen: false,
        resizable: false,
        height: "auto",
        modal: true,
    });
    $(document).off("click", '.computerInformation').on("click", ".computerInformation", function(e)
    {
        $("#computerInformationDiv").dialog("open");

    });

    $("#computer").slimscroll({
        height: "200px",
        alwaysVisible: false,
        size: "3px"
    }).css("width", "100%");


    $("#computerModelId").slimscroll({
        height: "200px",
        alwaysVisible: false,
        size: "3px"
    }).css("width", "100%");

    $("#projectorsModelId").slimscroll({
        height: "200px",
        alwaysVisible: false,
        size: "3px"
    }).css("width", "100%");

    $("#modelprojectinformation").slimscroll({
        height: "200px",
        alwaysVisible: false,
        size: "3px"
    }).css("width", "100%");

    $(".Computerscroll").slimscroll({
        height: "120px",
        alwaysVisible: false,
        size: "3px"
    }).css("width", "100%");

    $(".projectorscroll").slimscroll({
        height: "110px",
        alwaysVisible: false,
        size: "3px"
    }).css("width", "100%");
    
	$(document).off("change", '#buildingRoomNo').on("change", "#buildingRoomNo", function(e) 
	{
		$.ajax({
	        type: 'post',
	        url: '../inventory/GetRoom.html',
	        data: 'buildingRoomNo=' + $('#buildingRoomNo').val(),
	        dataType: 'json',
	        async: 'true',
	        cache: 'false',
	        success: function(data)
	        {
	        	if(data.success != undefined && data.success == false)
	        	{	
	        		var errorNotyOptions = {
			                "text": data.error,
			                "layout": "bottomRight",
			                "type": "error",
			                "modal": true,
			                "timeout" : 3000,
			                callback:
			                {
			                	afterClose: function() 
			                    {
						        	window.location = "../common/Index.html";
			                    }
			                },
			        };
			        noty(errorNotyOptions);
	        	}	
	        	else
	        	{	
		        	//$('#buildingRoomNo').val(data.no);
		            $('#linkToBuildingMap').prop("href", data.linktobldgmap);
		            $('#linkToRoomMap').prop("href", data.linktoroommap);
		            $('#linkToRoomPhoto').prop("href", data.linktoroomphoto);
		            $('#linkToRoomDiagram').prop("href", data.linktoroomdiagram);
		            $('#createTicket').prop("href", data.linktocreateTicket);
		            $('#LinkToRoomSchedule').prop("href", data.linktoroomschedule);
		            $('#linkToRoomDetails').prop("href", data.linktoroomdetails);
		        	
		            $('#doorCode').val(data.doorcode);
		            $('#avControlPanelLocation').val(data.avcontrolpanellocation);
		            $('#noOfProjectors').val(data.noofprojectors);
		            $('#projectorModel').val(data.projectormodel);
		            $('#roomType').val(data.roomtype);
		            $('#bulbHoursUsed').val(data.bulbhoursused);
		            $('#dellTag').val(data.dellTag);
		            $('#comments').val(data.comments);
		            $('#barCodeOnProjector').val(data.barcodeonprojector);
		            $('#projectorInstallYear').val(data.projectorinstallyear);
		            $('#barCodeOnComputer').val(data.barcodeoncomputer);
	
		            $('#dellTag1').attr('src', data.delltag1);
		            $('#dellTagLaptop').attr('src', data.delltaglaptop);
		            $('#dellTagBarcodeOnComputerBack').attr('src', data.delltagbarcodeOnComputerback);
		            
		            
		            $('#aVPanelModel').val(data.avpanelmodel);  	
		            $('#filterHours').val(data.filterhours);
		            $('#capacity').val(data.capacity);
		            $('#campus').val(data.campus);
		            if(data.whiteboard == "Y")
		            	$('#whiteboard').prop('checked', true);
		            else
		            	$('#whiteboard').prop('checked', false);
		           
		            if(data.smartboard == "Y")
		            	$('#smartBoard').prop('checked', true);
		            else
		            	$('#smartBoard').prop('checked', false);
		            
		            $('#whiteboardVsScreen').val(data.whiteboardvsscreen);
		            
		            if(data.moveablefurniture == "Y")
		            	$('#moveableFurniture').prop('checked', true);
		            else
		            	$('#moveableFurniture').prop('checked', false);
		            
		            $('#podiumType').val(data.podiumtype); 
		            $('#smartPodium').val(data.smartpodium);   
		            
		            if(data.moveablefurniture == "Y")
		            	$('#documentCamera').prop('checked', true);
		            else
		            	$('#documentCamera').prop('checked', false);
		              	
		            $('#mediaPlayer').val(data.mediaplayer);   
		            $('#soundSystem').val(data.soundsystem);   
		            $('#specialSoftware').val(data.specialsoftware);
		            $('#otherRequests').val(data.otherrequests);   	
		            $('#monitorType').val(data.monitortype);     	
		            $('#studentComputers').val(data.studentcomputers);
		            
		            if(data.digitalsignage == "Y")
		            	$('#digitalSignage').prop('checked', true);
		            else
		            	$('#digitalSignage').prop('checked', false);
		            
		            if(data.wepa == "Y")
		            	$('#wEPA').prop('checked', true);
		            else
		            	$('#wEPA').prop('checked', false);
		            	  	
		            $('#other').val(data.other);   	
		            $('#extra1').val(data.extra1);   	
		            $('#extra2').val(data.extra2);   	
		            $('#extra3').val(data.extra3);   	
		            $('#lastUpdatedBy').val(data.lastupdatedby);
		            $('#lastUpdatedtime').val(data.lastupdatedtime);
		            var helpText="";
		            if(data.hourreadinghelp != '')
		            	helpText = "<span style='color:#00a65a;'>Help</span> - "+data.hourreadinghelp;
		            $('#hourReadingHelpId').html(helpText);
		            var bulbText="";
		            if(data.bulb != '')
		            	bulbText = "<span style='color:#00a65a;'>Bulb#</span> - "+data.bulb;
		            $('#bulbId').html(bulbText);
		            $('#avEquipLocks').val(data.avequiplocks);
		            $('#podiumKeyCode').val(data.podiumkeycode);
		            
		            //getting projector information
		            $("#projectorListContainer").html("");
		            $.each(data.projectors, function(i, projector)
		            {
		            	$("#defaultProjectorListDiv").clone()
						  .attr("id","projectorId"+projector.no)
						  .show()
						  .appendTo($("#projectorListContainer"));
		            	$("#projectorId"+projector.no).find(".linkhover").html(projector.projectormodel);
		            	$("#projectorId"+projector.no).find("span").attr("id", projector.no);
		            });
		            
		            //getting computer information
		            $("#computerListContainer").html("");
		            $.each(data.computers, function(i, computer)
		            {
		            	$("#defaultComputerListDiv").clone()
						  .attr("id","computerId"+computer.no)
						  .show()
						  .appendTo($("#computerListContainer"));
		            	$("#computerId"+computer.no).find(".linkhover").html(computer.computermodel);
		            	$("#computerId"+computer.no).find("span").attr("id", computer.no);
		            });
		        }
	        }
	    });
	});
	
	$(document).off("click", '.modelInformation').on("click", ".modelInformation", function(e) 
	{
		var modelName = $(this).prev().find(".linkhover").html();
		$.ajax({
	        type: 'post',
	        global:false,
	        url: '../inventory/GetProjectorModelInfo.html',
	        data: 'projectorModelName=' +modelName,
	        dataType: 'json',
	        async: 'true',
	        cache: 'false',
	        success: function(projectorModel)
	        {
        		$("#modelPhotoHrefId").prop("href", projectorModel.modelphoto);
        		$('#projectorModel').html(projectorModel.itemmodel);
        		$("#modelIndicatorHrefId").prop("href", projectorModel.modelindicators);
        		$("#modelTroubleshootHrefId").prop("href", projectorModel.modeltroubleshoot);
        		$("#modelManualHrefId").prop("href", projectorModel.modelmanual);
        		$('#bulbMaxHours').html(projectorModel.bulbmaxhours);
        		$('#hourReadingHelp').html(projectorModel.hourreadinghelp);
        		$('#bulb').html(projectorModel.bulb);
        		$('#bulbStockQuantity').html(projectorModel.bulbstockquantity);
        		$('#bulbRepaceHelpHrefId').prop("href", projectorModel.bulblink);
        		$('#filterMaxLife').html(projectorModel.filtermaxlife);
        		$('#filerReplaceHelpHrefId').prop("href", projectorModel.filterlink);
	        }
	    });
		 $("#modelInformationDiv").dialog("open");
	    
	});
	$("#inventoryFormId").tooltip({
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
	
	$("#inventoryFormId").validate(
	{
	    messages:
	    {
	        "room.no":"Please select Building and Room",
			"room.doorCode":"Please enter Door Code",
			"room.avControlPanelLocation":"Please select AV Control Panel Location",
			"room.noOfProjectors":"Please enter Number of Projectors",
			"room.projectorModel":"Please select Projector Model",
			"room.roomType":"Please select Room Type",			
			"room.bulbHoursUsed":"Please enter Bulb Hours Used",
			"room.dellTag":"Please enter Dell Tag",
			"room.comments":"Please enter Comments",
			"Dell Tag 1":"Please enter Dell Tag 1",
			"room.barCodeOnProjector":"Please enter Barcode On Projector",
			"room.barCodeOnComputer":"Please enter Barcode On Computer",
			"room.projectorInstallYear":"Please enter Projector Install Year",
			"room.aVPanelModel":"Please enter AV Panel Model",
			"room.filterHours":"Please enter Filter Hours",
			"room.capacity":"Please enter Capacity",
			"room.campus":"Please enter Campus",
			"room.whiteboardVsScreen":"Please enter White Board Vs Screen",
			"room.mediaPlayer":"Please enter Media Player",
			"room.soundSystem":"Please enter Sound System",
			"room.specialSoftware":"Please enter Special Software",
			"room.otherRequests":"Please enter Other Requests",
			"room.studentComputers":"Please enter Student Computers",
			"room.other":"Please enter Other",
			"room.extra1":"Please enter Extra1 ",			
			"room.extra2":"Please enter Extra2 ",
			"room.extra3":"Please enter Extra3 ",
			"room.equipLocks":"Please enter EquipLocks "
	    },              
	    rules: 
	    {
	    	"room.no":{
	            "required": true
	    	} ,
		
	    	"room.linkToRoomSchedule":{
	    		"required": true
	    	},
		
			"room.linkToRoomDetails":{
		        "required": true
		    },
			"room.doorCode":{
		        "required": true
		    },
			"room.avControlPanelLocation":{
		        "required": true
		    },
			"room.noOfProjectors":{
		        "required": true
		    },
			"room.projectorModel":{
		        "required": true
		    },
			"room.roomType":{
		        "required": true
		    },		
			"room.bulbHoursUsed":{
		        "required": true
		    },
			"room.dellTag":{
		        "required": true
		    },		
			"room.comments":{
		        "required": true
		    },
			"Dell Tag 1":{
		        "required": true
		    },
			"room.barCodeOnProjector":{
		        "required": true
		    },
			"room.projectorInstallYear":{
		        "required": true
		    },
			"room.barCodeOnComputer":{
		        "required": true
		    },
			"room.aVPanelModel":{
		        "required": true
		    },
			"room.filterHours":{
		        "required": true
		    },
			"room.capacity":{
		        "required": true
		    },
			"room.campus":{
		        "required": true
		    },
			"room.otherRequests":{
		        "required": true
		    },
			"room.mediaPlayer":{
		        "required": true
		    },
			"room.soundSystem":{
		        "required": true
		    },
			"room.specialSoftware":{
		        "required": true
		    },
			"room.whiteboardVsScreen":{
		        "required": true
		    },			
			"room.studentComputers":{
		        "required": true
		    },
			"room.other":{
		        "required": true
		    },
			"room.extra1":{
		        "required": true
		    },
			"room.extra2":{
		        "required": true
		    },
			"room.extra3":{
		        "required": true
		    },
			"room.lastUpdatedBy":{
		        "required": true
		    },
			"room.equipLocks":{
		        "required": true
		    }
	    }
	});
	
	$('#inventoryFormId').livequery(function()
	{
		$("#inventoryFormId").ajaxForm (
		{
		    dataType: "json",
		    success: function(jsonData)
		    {
		    	if (jsonData.success == true)
		        {
		            var succesNotyOptions = {
		                "text": "Inventory information has been saved successfully",
		                "layout": "bottomRight",
		                "type": "success",
		                "modal": true,
		                "timeout" : 1500,
		            };
		            noty(succesNotyOptions);
		            $("#customerSearchId").trigger("click");
		        }
		        else if (jsonData.success == false)
		        {
		            if(jsonData.error == 'You are not logged in, Please log in to save Room Data')
		            {
		            	var errorNotyOptions = {
			                "text": jsonData.error,
			                "layout": "bottomRight",
			                "type": "error",
			                "modal": true,
			                "timeout" : 3000,
			                callback:
			                {
			                    afterClose: function() 
			                    {

			                    	window.location = "../common/Index.html";
			                    }
			                },
			            };
	            	 	noty(errorNotyOptions);
		            }	
		            else
		            {	
			        	var errorNotyOptions = {
			                "text": jsonData.error,
			                "layout": "bottomRight",
			                "type": "error",
			                "modal": true,
			                "timeout" : 1500
			            };
			        	 noty(errorNotyOptions);
		            }
		           
		        }
		    }
		});
	});
	
	$('#projectorInformationForm').livequery(function()
	{
		$("#projectorInformationForm").ajaxForm (
		{
		    dataType: "json",
		    success: function(jsonData)
		    {
		    	if (jsonData.success == true)
		        {
		            var succesNotyOptions = {
		                "text": "Projector information has been saved successfully",
		                "layout": "bottomRight",
		                "type": "success",
		                "modal": true,
		                "timeout" : 1500,
		            };
		            noty(succesNotyOptions);
		            $.fn.closeDialogueWithoutTitleBar("projectorsModelDiv");
		        }
		        else if (jsonData.success == false)
		        {
		            if(jsonData.error == 'You are not logged in, Please log in to save Projector Information')
		            {
		            	var errorNotyOptions = {
			                "text": jsonData.error,
			                "layout": "bottomRight",
			                "type": "error",
			                "modal": true,
			                "timeout" : 3000,
			                callback:
			                {
			                    afterClose: function() 
			                    {

			                    	window.location = "../common/Index.html";
			                    }
			                },
			            };
	            	 	noty(errorNotyOptions);
		            }	
		            else
		            {	
			        	var errorNotyOptions = {
			                "text": jsonData.error,
			                "layout": "bottomRight",
			                "type": "error",
			                "modal": true,
			                "timeout" : 1500
			            };
			        	 noty(errorNotyOptions);
		            }
		           
		        }
		    }
		});
	});
	
	$('#computerInformationForm').livequery(function()
	{
		$("#computerInformationForm").ajaxForm (
		{
		    dataType: "json",
		    success: function(jsonData)
		    {
		    	if (jsonData.success == true)
		        {
		            var succesNotyOptions = {
		                "text": "Computer information has been saved successfully",
		                "layout": "bottomRight",
		                "type": "success",
		                "modal": true,
		                "timeout" : 1500,
		            };
		            noty(succesNotyOptions);
		            $.fn.closeDialogueWithoutTitleBar("computerModelDiv");
		        }
		        else if (jsonData.success == false)
		        {
		            if(jsonData.error == 'You are not logged in, Please log in to save Computer Information')
		            {
		            	var errorNotyOptions = {
			                "text": jsonData.error,
			                "layout": "bottomRight",
			                "type": "error",
			                "modal": true,
			                "timeout" : 3000,
			                callback:
			                {
			                    afterClose: function() 
			                    {

			                    	window.location = "../common/Index.html";
			                    }
			                },
			            };
	            	 	noty(errorNotyOptions);
		            }	
		            else
		            {	
			        	var errorNotyOptions = {
			                "text": jsonData.error,
			                "layout": "bottomRight",
			                "type": "error",
			                "modal": true,
			                "timeout" : 1500
			            };
			        	 noty(errorNotyOptions);
		            }
		           
		        }
		    }
		});
	});
	
	$(document).off("blur", '#textToBeEncrypted').on("blur", "#textToBeEncrypted", function(e) 
	{
		$.ajax({
	        type: 'post',
	        url: '../common/EncryptText.html',
	        data: 'textToBeEncrypted=' + $('#textToBeEncrypted').val(),
	        dataType: 'json',
	        async: 'true',
	        cache: 'false',
	        success: function(data)
	        {
	        	$('#encryptedText').html("Encrypted Text = '"+data.error+"'");
				$.fn.openDialogueWithoutTitleBar("disableCustomerConfirmDialogue");
	        }
	    });
	});
	
	$(document).off("click", '#okButtonId').on("click", "#okButtonId", function(e) 
	{
		$.fn.clearFormElements('inventoryFormId');
		$('#inventoryFormId a').prop("href", "");
		$('#inventoryFormId a').text("No Link");
		$('#hourReadingHelpId').html("");
		$('#bulbId').html("");
		$('#inventoryFormId img').prop("src", "");
	});
	
	
	$(document).off("click", '#replaceBulbButtonId').on("click", "#replaceBulbButtonId", function(e) 
	{
		$.ajax({
	        type: 'post',
	        url: '../inventory/ReplaceBulb.html',
	        data: 'projectorId=' + $('#projectorId').val(),
	        dataType: 'json',
	        async: 'true',
	        cache: 'false',
	        success: function(jsonData)
	        {
	        	if (jsonData.success == true)
		        {
		            var succesNotyOptions = 
		            {
		                "text": "Please Reset Bulb Hours on Projector",
		                "layout": "center",
		                "type": "warning",
		                "modal": true,
		                "timeout" : 5000,
		            };
		            noty(succesNotyOptions);
		            $.fn.closeDialogueWithoutTitleBar("projectorsModelDiv");
		        }
		        else if (jsonData.success == false)
		        {
		            if(jsonData.error == 'You are not logged in, Please log in to save Computer Information')
		            {
		            	var errorNotyOptions = {
			                "text": jsonData.error,
			                "layout": "bottomRight",
			                "type": "error",
			                "modal": true,
			                "timeout" : 3000,
			                callback:
			                {
			                    afterClose: function() 
			                    {

			                    	window.location = "../common/Index.html";
			                    }
			                },
			            };
	            	 	noty(errorNotyOptions);
		            }	
		            else
		            {	
			        	var errorNotyOptions = {
			                "text": jsonData.error,
			                "layout": "bottomRight",
			                "type": "error",
			                "modal": true,
			                "timeout" : 1500
			            };
			        	 noty(errorNotyOptions);
		            }
		           
		        }
	        }
	    });
	});
			
});