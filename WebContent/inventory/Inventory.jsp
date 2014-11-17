<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Small boxes (Stat box) -->
<style>
    .boxheaders .box-header {
        border-bottom: 0 solid #f4f4f4;
        border-radius: 5px 5px 0 0;
        color: #FFFFFF;
        position: relative;

    }
	.btn-sm {
    border-radius: 3px;
    font-size: 12px;
    line-height: 1.5;
    padding: 3px 5px;
}
	.projectorsModel{cursor:pointer;}
	.modelInformation{color:#0099FF; cursor:pointer;}
    .linkhover{color:#00a65a; cursor:pointer;}
	.computerModel{cursor:pointer;}
	.computerInformation{cursor:pointer;color:#0099FF;}
    .boxheaders {
        background: none repeat scroll 0 0 #3c8dbc;
        border-radius: 5px;
        border-top: 2px solid #c1c1c1;
        box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
        margin-bottom: 20px;
        position: relative;
        width: 100%;
    }
    .boxheaders .box-body {
        border-radius: 0 0 3px 3px;
        padding: 0px;
    }
</style>
<!-- Main content -->
<section class="content">
    <s:form id="inventoryFormId" theme="simple" action="../inventory/SaveInventory.html" method="post">
        <div class="row">
            <div class="col-md-12">
                <!-- general form elements -->
                <div class="box box-primary boxheaders">
                    <div class="box-header">
                        <h3 class="box-title">Inventory Update</h3>
                    </div>
                </div>
            </div>
            <!-- left column -->
            <div class="col-md-6">
                <!-- general form elements -->
                <div class="box box-primary">  
                    <div class="box-header">
                        <h3 class="box-title">Room Info</h3>
                    </div>                  
                    <div class="box-body">
                        <div class="form-group">
                            <label class="lbl">Building-Room   
                                <span><a href="#" id="linkToBuildingMap"  target="_blank"><img src="../img/buildingmap.png"  title="Building Map" /></a></span>
                                <span cssClass="form-control"><a href="#" id="linkToRoomMap"  target="_blank"><img src="../img/roomphoto.png" title="Room Map"  /></a></span>
                                <span cssClass="form-control"><a href="#" id="linkToRoomPhoto"  target="_blank"><img src="../img/roommap.png" title="Room Photo"  /></a></span>
                                <span cssClass="form-control"><a href="#" id="linkToRoomDiagram"  target="_blank"><img src="../img/Diagram.png" title="Room Diagram" /></a></span>
                                <span cssClass="form-control"><a href="#" id="createTicket"><img src="../img/ticket.png"  title="Create Ticket"  /></a></span>
                                <span cssClass="form-control"><a href="#" id="linkToRoomSchedule" target="_blank"><img src="../img/roomshedule.png"  title="Link to Room Schedule"  /></a></span>
                                <span cssClass="form-control"><a href="#" id="linkToRoomDetails"  target="_blank"><img src="../img/roomdatial.png"  title="Link to Room Details"  /></a></span>
                            </label>
                            <s:select name="no" id="buildingRoomNo"  cssClass="form-control cntrl" headerKey="" headerValue="Please Select"  list="mapBuildingRoom"/>
                        </div>
                        <div class="form-group">
                            <label class="lbl">Comments </label>
                            <s:textarea name="comments" id="comments" cssClass="form-control" maxlength='1000' placeholder="Comments "></s:textarea>
                        </div> 
                        <div class="form-group">
                            <label class="lbl">Last Updated By</label>	
                            <s:textfield name="lastUpdatedBy" id="lastUpdatedBy" readonly="true" cssClass="form-control" maxlength='100' placeholder="Last Updated By"/>
                        </div> 
                        <div class="form-group">
                            <label class="lbl">Last Update Time</label>	
                            <s:textfield name="lastUpdatedtime" id="lastUpdatedtime" readonly="true"  cssClass="form-control" maxlength='100' placeholder="Last Updated Time"/>
                        </div>
                        <div class="form-group">
                            <label class="lbl">Door Code</label>	
                            <s:textfield name="doorCode" id="doorCode"  cssClass="form-control" maxlength='100' placeholder="Door Code"/>
                        </div>  
                        <div class="form-group">
                            <label class="lbl">Room Type</label>
                            <s:select name="roomType" id="roomType" cssClass="form-control cntrl" cssStyle="height:34px;" headerKey="" headerValue="Please Select" list="listRoomType" maxlength='100'/>
                        </div>
                        <div class="form-group">
                            <label class="lbl">Capacity</label>	
                            <s:textfield name="capacity" id="capacity"  cssClass="form-control" maxlength='100' placeholder="Capacity"/>
                        </div> 
                        <div class="checkbox">
                            <label class="lbl">Moveable Furniture</label>	
                            <input type="checkbox" class="minimal" name="moveableFurniture" id="moveableFurniture"  value="Y">
                        </div>
                        <div class="checkbox">
                            <label class="lbl">White Board</label>
                            <input type="checkbox" class="minimal" name="whiteboard" id="whiteboard"  value="Y">
                            </label>
                        </div>
                        <div class="checkbox">
                            <label class="lbl">Smart Board</label>	
                            <input type="checkbox" class="minimal" name="smartBoard" id="smartBoard"  value="Y">
                        </div>
                        <div class="form-group"> 
                            <label class="lbl">White Board VS Screen %</label>	
                            <s:textfield name="whiteboardVsScreen" id="whiteboardVsScreen"  cssClass="form-control" maxlength='100' placeholder="White Board Vs Screen %"/>
                        </div>
                        <div class="box box-danger">
                            <div class="box-header">
                                <h3 class="box-title">Projectors</h3>
                            </div>
                            <div class="projectorscroll" id="projectorListContainer">
                                
                            </div>
                            <div class="clear">&nbsp;</div>
                        </div>
                        <div class="box box-success">
                            <div class="box-header">
                                <h3 class="box-title">Computers</h3>
                            </div>
                            <div class="Computerscroll" id="computerListContainer">
                               
                            </div>
                            <div class="clear">&nbsp;</div>
                        </div>
                    </div><!-- /.box-body -->
                </div><!-- /.box -->
                <!-- Form Element sizes -->
            </div><!--/.col (left) -->
            <!-- right column -->
            <div class="col-md-6">
                <!-- general form elements disabled -->
                <div class="box box-warning">                   
                    <div class="box-body">
                        <!-- text input -->
                        <div class="box-header">
                            <h3 class="box-title">Audio-Visual</h3>
                        </div>
                        <div class="form-group">
                            <label class="lbl">Podium Type</label>	
                            <s:select name="podiumType" id="podiumType" cssClass="form-control cntrl" cssStyle="height:34px;" headerKey="" headerValue="Please Select" list="listPodiumType" maxlength='100'/>
                        </div>
                        <div class="form-group">
                            <label class="lbl">Podium Key Code</label>	
                            <s:textfield name="podiumKeyCode" id="podiumKeyCode"  cssClass="form-control" maxlength='100' placeholder="Podium Key Code"/>
                        </div>
                        <div class="form-group">
                            <label class="lbl">AV Control Panel Location</label>
                            <s:select name="avControlPanelLocation" id="avControlPanelLocation" cssClass="form-control cntrl" cssStyle="height:34px;" headerKey="" headerValue="Please Select" list="listAvControlPanelLocation" maxlength='100'/> 
                        </div>  
                        <div class="form-group">
                            <label class="lbl">AV Panel Model</label>
                            <s:select name="aVPanelModel" id="aVPanelModel" cssClass="form-control cntrl" cssStyle="height:34px;" headerKey="" headerValue="Please Select" list="listAVPanelModel" maxlength='100'/>
                        </div>
                        <div class="form-group">
                            <label class="lbl">Sound System</label>	
                            <s:select name="soundSystem" id="soundSystem" cssClass="form-control cntrl" cssStyle="height:34px;" headerKey="" headerValue="Please Select" list="listSoundSystem" maxlength='100'/>
                        </div>  
                        <div class="form-group">
                            <label class="lbl">Media Player</label>	
                            <s:select name="mediaPlayer" id="mediaPlayer" cssClass="form-control cntrl" cssStyle="height:34px;" headerKey="" headerValue="Please Select" list="listMediaPlayer" maxlength='100'/>
                        </div>
                        <div class="checkbox">
                            <label class="lbl">Document Camera</label>	
                            <input type="checkbox" class="minimal" name="documentCamera" id="documentCamera"  value="Y">
                        </div>
						 <div class="form-group">
                                <label class="lbl">AV Equip Locks</label>	
                                <s:textfield name="avEquipLocks" id="avEquipLocks"  cssClass="form-control" maxlength='100' placeholder="AV Equip Locks"/>
                            </div> 
                        <div class="box box-success">
                            <div class="box-header">
                                <h3 class="box-title">Misc</h3>
                            </div>	

                            <div class="checkbox">
                                <label class="lbl">Digital Signage</label>	
                                <input type="checkbox" class="minimal" name="digitalSignage" id="digitalSignage"  value="Y">
                            </div>
                            <div class="checkbox">
                                <label class="lbl">WEPA</label>	
                                <input type="checkbox" class="minimal" name="wEPA" id="wEPA"  value="Y">
                            </div> 
                            <div class="form-group">
                                <label class="lbl">Other</label>	
                                <s:textfield name="other" id="other"  cssClass="form-control" maxlength='100' placeholder="Other"/>
                            </div> 
                            <div class="form-group">
                                <label class="lbl">Extra1</label>	
                                <s:textfield name="extra1" id="extra1"  cssClass="form-control" maxlength='100' placeholder="Extra1"/>
                            </div> 
                            <div class="form-group">
                                <label class="lbl">Extra2</label>	
                                <s:textfield name="extra2" id="extra2"  cssClass="form-control" maxlength='100' placeholder="Extra2"/>
                            </div>
                            <div class="form-group">
                                <label class="lbl">Extra3</label>	
                                <s:textfield name="extra3" id="extra3"  cssClass="form-control" maxlength='100' placeholder="Extra3"/>
                            </div>
                            <div class="form-group">
                                <label class="lbl">Other Requests</label>	
                                <s:textfield name="otherRequests" id="otherRequests"  cssClass="form-control" maxlength='100' placeholder="Other Requests"/>
                            </div> 
                        </div>

                    </div><!-- /.box-body -->
                </div><!-- /.box -->
            </div>
            <!--/.col (right) -->
        </div>
        <s:if test="#session.user.Role == 'full'">
            <div class="box-footer" align="center">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div> 
        </s:if>
        <s:else>
            <div class="box-footer" align="center">
                <button type="button" id="okButtonId" class="btn btn-primary">OK</button>
            </div> 
        </s:else>
    </s:form>  
    <!-- /.row -->
</section><!-- /.content -->
<div id="disableCustomerConfirmDialogue" style="display:none">
    <p>
        <span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 5px 0;"> </span>
    <div id="encryptedText"></div>
</p>
<div id="disableCustomerMessageId">&nbsp;</div>
</div>
<div id="createTicketDiv" style="display:none">
    <div class="box box-primary">
        <div class="box-header">
            <h3 class="box-title">Ticket</h3>
        </div><!-- /.box-header -->
        <!-- form start -->
        <form role="form" name="ticketEmailForm" id="ticketEmailForm" method="post" action="../inventory/SendTicketEmail.html">
            <div class="box-body">
           		<div class="form-group">
                    <label for="exampleInputEmail1">From</label>
                    <s:textfield cssClass="form-control" name="emailFrom" id="ticketEmailFrom" value="%{#session.user.email}" readonly="true" placeholder="Email From" />
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">To</label>
                    <input type="text" class="form-control" name="emailTo" id="ticketEmailTo" value="bhavesh.khatri1982@gmail.com" placeholder="Email TO">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Subject</label>
                    <input type="text" class="form-control" name="emailSubject" id="ticketEmailSubject" placeholder="Subject">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Message</label>
                    <textarea class="form-control" rows="5" name="emailMessage" id="ticketEmailMessage" cols="5" placeholder="Message"></textarea>
                </div> 
            </div><!-- /.box-body -->
            <div class="box-footer" align="center">
                <button type="submit" class="btn btn-primary">Send Email</button>
            </div>
        </form>
    </div><!-- /.box -->
</div>
<div id="projectorsModelDiv" style="display:none">
    <div class="box box-primary">
        <div class="box-header">
            <h3 class="box-title">Projector</h3>
        </div><!-- /.box-header -->
        <!-- form start -->
        <div id="projectorsModelId">
            <form role="form" name="projectorInformationForm" method="post" id="projectorInformationForm" action="../inventory/SaveProjectorInformation.html">
                <div class="box-body">
                    <div class="form-group">
                        <label class="lbl">Last Updated By</label>	
                        <s:hidden name="no" id="projectorId" value="0"></s:hidden>
                        <s:textfield name="lastUpdatedBy" id="projectorLastUpdatedBy" readonly="true" cssClass="form-control" maxlength='100' placeholder="Last Updated By"/>
                    </div> 
                    <div class="form-group">
                        <label class="lbl">Last Update Time</label>	
                        <s:textfield name="lastUpdatedtime" id="projectorLastUpdatedtime" readonly="true"  cssClass="form-control" maxlength='100' placeholder="Last Updated Time"/>
                    </div>

                    <div class="form-group">
                        <label for="exampleInputPassword1">Projector MU Barcode#</label>
                        <s:textfield  cssClass="form-control" name="projectorMUBarcode" id="projectorMUBarcode" placeholder="Projector MU Barcode"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Projector Manu Date</label>
                        <div cssClass="form-control" id="projectorManuDate">
                                Projector Manu Date
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Projector Current Age Years
                        </label>
                       <div cssClass="form-control" id="projectorCurrentAgeYears">
                                Projector Current Age Years
                       </div>
                    </div>              
                    <div class="form-group">
                        <label for="exampleInputPassword1">Bulb Hours Used</label>
                        <s:textfield  cssclass="form-control" name="bulbHoursUsed" id="bulbHoursUsed" placeholder="Bulb Hours Used"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Bulb Replace Date  <input type="button" id="replaceBulbButtonId" value="Replace" class="btn btn-primary btn-sm"></label>
                        <div cssClass="form-control" id="bulbReplaceDate">
                                Bulb Replace Date
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Filter Hours Used</label>
                        <s:textfield  cssclass="form-control" name="filterHoursUsed" id="filterHoursUsed" placeholder="Filter Hours Used"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Filter Replace Date</label>
                       <div cssClass="form-control" id="filterReplaceDate">
                                Filter Replace Date
                            </div>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Equip Locks</label>
                        <s:textfield  cssclass="form-control" name="equipLocks" id="equipLocks" placeholder="Equip Locks"/>
                    </div>
                </div><!-- /.box-body -->
                <div class="box-footer" align="center">
                    <button type="submit" class="btn btn-primary">Save</button>
                   
                </div>
            </form>
        </div>
    </div>
</div>
<!--Model Information-->
<div id="modelInformationDiv" style="display:none">
    <div class="box box-primary">
        <div class="box-header">
            <h3 class="box-title">Project Model Information</h3>
        </div><!-- /.box-header -->
        <!-- form start -->
        <div id="modelprojectinformation">
              <div class="box-body">
		<div class="form-group has-warning">
               <div class="imag-control has-success">
                  <a id="modelPhotoHrefId" href="#" target="_blank"><img src="../img/rws36ysn.png" height="50" style="margin-top:5px;" /></a>
               </div>
              </div>
                  <div class="form-group has-warning">
                      <label>Projector Model#</label>
                      <div class="imag-control has-success">
                          <div cssClass="form-control has-warning" id="projectorModel">&nbsp;</div>
                      </div>
                  </div>
                  <div class="form-group has-warning">
                      <label ><a id="modelIndicatorHrefId" href="#" target="_blank">Indicators</a></label>
                  </div>
                  
                  <div class="form-group has-warning">
                      <label > <a id="modelTroubleshootHrefId" href="#" target="_blank">Trouble shoot</a></label>
                  </div>
                  <div class="form-group has-warning">
                      <label ><a id="modelManualHrefId" href="#" target="_blank">Manual</a></label>
                                     </div>
                  
                  <div class="form-group has-warning">
                      <label >Bulb Max Hours</label>
                      <div class="imag-control has-success">
                          <div cssClass="form-control" id="bulbMaxHours">&nbsp;</div>
                      </div>
                  </div>
                  <div class="form-group has-warning">
                      <label >Hour Reading Help</label>
                      <div class="imag-control has-success">
                          <div cssClass="form-control" id="hourReadingHelp">&nbsp;</div>
                      </div>
                  </div>
                  <div class="form-group has-warning">
                      <label >Bulb #</label>
                      <div class="imag-control has-success">
                          <div cssClass="form-control" id="bulb">&nbsp;</div>
                      </div>
                  </div>
                  <div class="form-group has-warning">
                      <label >Bulb Stock Quantity</label>
                      <div class="imag-control has-success">
                          <div cssClass="form-control" id="bulbStockQuantity">&nbsp;</div>
                      </div>
                  </div>
                  <div class="form-group has-warning">
                      <label > <a id="bulbRepaceHelpHrefId" href="#" target="_blank">Bulb Replace Help</a></label>
                    
                  </div>
                  <div class="form-group has-warning">
                      <label >Filter Max Life Hours</label>
                      <div class="imag-control has-success">
                          <div cssClass="form-control" id="filterMaxLife">&nbsp;</div>
                      </div>
                  </div>
                  <div class="form-group has-warning">
                      <label > <a id="filerReplaceHelpHrefId" href="#" target="_blank">Filter Clean/Replace Help</a></label>
                  </div>
              </div>
              </div><!-- /.box-body -->
        </div>
    </div>
</div>
<!--model Information-->
<!--computermodel-->
<div id="computerModelDiv" style="display:none">
    <div class="box box-primary">
        <div class="box-header">
            <h3 class="box-title">Computer</h3>
        </div><!-- /.box-header -->
        <!-- form start -->
        <div id="computerModelId">
            <form role="form" name="computerInformationForm" method="post" id="computerInformationForm" action="../inventory/SaveComputerInformation.html">
                <div class="box-body">
                    <div class="form-group">
                        <label class="lbl">Last Updated By</label>	
                        <s:hidden name="no" id="computerId" value="0"></s:hidden>
                        <s:textfield name="lastUpdatedBy" id="computerLastUpdatedBy" readonly="true" cssClass="form-control" maxlength='100' placeholder="Last Updated By"/>
                    </div> 
                    <div class="form-group">
                        <label class="lbl">Last Update Time</label>	
                        <s:textfield name="lastUpdatedtime" id="computerLastUpdatedtime" readonly="true"  cssClass="form-control" maxlength='100' placeholder="Last Updated Time"/>
                    </div>

                    <div class="form-group">
                        <label for="exampleInputPassword1">Computer Serial #</label>
                        <input type="text" class="form-control" name="computerSerial" id="computerSerial" placeholder="Computer Serial #">
                        <span>(For Dell: Tag# 7 letters and numbers.  For Apple: Apple Menu, About This Mac, Double-click the Version #, See the Serial #.)</span>
                    </div>

                    <div class="form-group">
                        <label for="exampleInputPassword1">Computer Model</label>
                        <div class="imag-control">
                            <span cssClass="form-control" id="computerModel">
                                &nbsp;
                            </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1"><a id="linkToMakerHrefId" href="#">Maker Details</a></label>
                    </div>
					<div class="form-group">
                        <label for="exampleInputPassword1"><a id="linkToSoftwarePageHrefId" href="#">Link to Software Page</a></label>
                    </div>
                    <!-- div class="form-group">
                        <label for="exampleInputPassword1">Information</label>
                        <div class="imag-control">
                            <span cssClass="form-control">
                                Tag# 7 letters 
                            </span>
                        </div>
                    </div-->
                    <div class="form-group">
                        <label for="exampleInputPassword1">Computer MU Barcode</label>
                        <input type="text" class="form-control" name="computerMUBarCode" id="computerMUBarCode" placeholder="Computer MU Barcode">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Computer Manu Date</label>
                        <div class="imag-control">
                            <span cssClass="form-control" id="computerManuDate">
                                Computer Manu Date 
                            </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Computer Current Age Years</label>
                        <div class="imag-control">
                            <span cssClass="form-control" id="computerCurrentAgeYears">
                                Computer Current Age Years
                            </span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="exampleInputPassword1">Special Software</label>
                        <input type="text" class="form-control" name="specialSoftware" id="specialSoftware" placeholder="Special Software">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Monitor Type</label>
						 <input type="text" class="form-control" name="monitorType" id="monitorType" placeholder="Special Software">
                        </div>
					               
                    <div class="form-group">
                        <label for="exampleInputPassword1">Equip Locks</label>
                        <input type="text" class="form-control" name="equipLocks" id="computerEquipLocks" placeholder="Equip Locks">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">User / Pass</label>
                        <input type="text" class="form-control" name="userPass" id="userPass" placeholder="User / Pass">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Bios Pass</label>
                        <input type="text" class="form-control" name="bIOSPass" id="bIOSPass" placeholder="Bios Pass">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Smart Shield Pass</label>
                        <input type="text" class="form-control" name="smartShieldPass" id="smartShieldPass" placeholder="Smart Shield Pass">
                    </div>
                </div><!-- /.box-body -->
                <div class="box-footer" align="center">
                    <button class="btn btn-info btn-sm">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!--computermodel-->
<!--computer Information-->
<div id="computerInformationDiv101" style="display:none">
    <div class="box box-primary">
        <div class="box-header">
            <h3 class="box-title">Computer Information</h3>
        </div><!-- /.box-header -->
        <!-- form start -->
        <div id="computer">
            <form role="form">
                <div class="box-body">
                    <div class="form-group has-warning">
                        <label>Item Model#</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control has-warning">Christie LW400</div>
                        </div>
                    </div>
                    <div class="form-group has-warning">
                        <label >Model Indicators</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                <a href="" target="_blank">
                                    https://astraweb.marymount.edu/AstraProd/Calendars/Calendar.aspx?len=Day&type=Grid
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="form-group has-warning">
                        <label >Model Troubleshoot</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                <a href="" target="_blank">
                                    https://astraweb.marymount.edu/AstraProd/Calendars/Calendar.aspx?len=Day&type=Grid
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="form-group has-warning">
                        <label >Model Manual</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                <a href="" target="_blank">
                                    https://astraweb.marymount.edu/AstraProd/Calendars/Calendar.aspx?len=Day&type=Grid
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="form-group has-warning">
                        <label >ModelPhoto</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                <a href="" target="_blank">
                                    https://astraweb.marymount.edu/AstraProd/Calendars/Calendar.aspx?len=Day&type=Grid
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="form-group has-warning">
                        <label >Bulb Max Hours</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                2000
                            </div>
                        </div>
                    </div>

                    <div class="form-group has-warning">
                        <label >Hour Reading Help</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                Menu, Go to Advanced Menu, Option, Lamp Time
                            </div>
                        </div>
                    </div>

                    <div class="form-group has-warning">
                        <label >Bulb</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                003-120457-01 (DT0873)
                            </div>
                        </div>
                    </div>

                    <div class="form-group has-warning">
                        <label >Bulb Stock Quantity</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                0
                            </div>
                        </div>
                    </div>
                    <div class="form-group has-warning">
                        <label >Bulb Link</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                <a href="" target="_blank">
                                    http://i62.tinypic.com/sdff60.jpg
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="form-group has-warning">
                        <label >Filter Max Life</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                500
                            </div>
                        </div>
                    </div>
                    <div class="form-group has-warning">
                        <label >Filter Link</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                <a href="" target="_blank">
                                    http://i62.tinypic.com/sdff60.jpg
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="form-group has-warning">
                        <label >Room Type</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                Classroom
                            </div>
                        </div>
                    </div>
                    <div class="form-group has-warning">
                        <label >Link To Software Page</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                <a href="" target="_blank">
                                    https://astraweb.marymount.edu/AstraProd/Calendars/Calendar.aspx?len=Day&type=Grid
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="form-group has-warning">
                        <label >AV Panel Model</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                Crestron
                            </div>
                        </div>
                    </div>
                    <div class="form-group has-warning">
                        <label >Media Player</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                DVD
                            </div>
                        </div>
                    </div>
                    <div class="form-group has-warning">
                        <label >Sound System</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                Ceiling Speakers
                            </div>
                        </div>
                    </div>
                    <div class="form-group has-warning">
                        <label >Monitor Type</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                Touchscreen
                            </div>
                        </div>
                    </div>
                    <div class="form-group has-warning">
                        <label >Podium Type</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                Podium
                            </div>
                        </div>
                    </div>
                    <div class="form-group has-warning">
                        <label >AV Control Panel Location</label>
                        <div class="imag-control has-success">
                            <div cssClass="form-control">
                                On Podium
                            </div>
                        </div>
                    </div>

                </div><!-- /.box-body -->
            </form>
        </div>
    </div>
</div>
<!--computer Information-->
<!-- /.row -->

<!--  divs to be cloned -->
<div class="form-group linkform " id="defaultProjectorListDiv" style="display:none">                              
    <div class="imag-control form-group has-success">
        <div>
        	<label class="lbl" for="inputSuccess">
        		<span class="projectorsModel"><img src="../img/projector.png" />&nbsp;&nbsp;<span class="i linkhover">&nbsp;</span></span>&nbsp;
            	<span class="has-warning modelInformation">(Model Information)</span>
            </label>
        </div>
    </div>
</div>
<div class="form-group linkform" id="defaultComputerListDiv" style="display:none">                                
    <div class="imag-control form-group has-success">
        <div>
        	<span class="computerModel"><img src="../img/computer.png"  /></span> 
        	<label class="lbl" for="inputSuccess"><span class="computerModel linkhover">Dell X0</span></label>
        </div>
    </div>
</div>
<script type="text/javascript" src="../js/inventory/inventory.js"></script>
<script>
    //$(document).on("click", "#textToBeEncrypted", function() {
    // disalbeCustomerId = $(this).attr('id');
    //alert(disalbeCustomerId);
    //   $.fn.openDialogueWithoutTitleBar("disableCustomerConfirmDialogue");
    // });
</script>

