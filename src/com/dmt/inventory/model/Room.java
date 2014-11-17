package com.dmt.inventory.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.annotations.Expose;

public class Room
{
	static final Logger logger							= LoggerFactory.getLogger(com.dmt.inventory.model.Room.class);
	
	@Expose private int no								= 0;
	@Expose private String building 					= ""; 
	@Expose private String room 						= ""; 
	@Expose private String linkToRoomSchedule 			= ""; 
	@Expose private String linkToRoomDetails 			= ""; 
	@Expose private String doorCode 					= ""; 
	@Expose private String avControlPanelLocation 		= "";  
	@Expose private String noOfProjectors 				= ""; 
	@Expose private String projectorModel 				= "";  
	@Expose private String roomType 					= "";  
	@Expose private String bulbHoursUsed 				= ""; 
	@Expose private String dellTag 						= ""; 
	@Expose private String comments 					= "";
	@Expose	private String dellTag1 					= ""; 
	@Expose private String dellTagLaptop 				= "";  
	@Expose private String dellTagBarcodeOnComputerBack	= "";  
	@Expose private String barCodeOnProjector 			= "";
	@Expose private String projectorInstallYear 		= ""; 
	@Expose private String barCodeOnComputer 			= "";
	@Expose private String aVPanelModel		 			= "";
	@Expose private String filterHours		 			= "";
	@Expose private String capacity 					= "";
	@Expose private String campus 						= "";
	@Expose private String whiteboard 					= "N";
	@Expose private String smartBoard					= "N";
	@Expose private String whiteboardVsScreen 			= "";
	@Expose private String moveableFurniture 			= "N";
	@Expose private String podiumType 					= "";
	@Expose private String smartPodium 					= "";
	@Expose private String documentCamera 				= "N";
	@Expose private String mediaPlayer 					= "";
	@Expose private String soundSystem 					= "";
	@Expose private String specialSoftware 				= "";
	@Expose private String otherRequests 				= "";
	@Expose private String monitorType					= "";
	@Expose private String studentComputers 			= "";
	@Expose private String digitalSignage 				= "N";
	@Expose private String wEPA 						= "N";
	@Expose private String other 						= "";
	@Expose private String extra1 						= "";
	@Expose private String extra2						= "";
	@Expose private String extra3 						= "";
	@Expose private String lastUpdatedBy 				= "";
	@Expose private String lastUpdatedTime 				= "";
	@Expose private String hourReadingHelp				= "";
	@Expose private String bulb							= "";
	@Expose private String equipLocks					= "";
	
	
	//getters and setters
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
		logger.debug("setting no = {}", this.no);
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
		logger.debug("setting building = {}", this.building);
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
		logger.debug("setting room = {}", this.room);
	}
	public String getLinkToRoomSchedule() {
		return linkToRoomSchedule;
	}
	public void setLinkToRoomSchedule(String linkToRoomSchedule) {
		this.linkToRoomSchedule = linkToRoomSchedule;
		logger.debug("setting linkToRoomSchedule = {}", this.linkToRoomSchedule);
	}
	public String getLinkToRoomDetails() {
		return linkToRoomDetails;
	}
	public void setLinkToRoomDetails(String linkToRoomDetails) {
		this.linkToRoomDetails = linkToRoomDetails;
		logger.debug("setting linkToRoomDetails = {}", this.linkToRoomDetails);
	}
	public String getDoorCode() {
		return doorCode;
	}
	public void setDoorCode(String doorCode) {
		this.doorCode = doorCode;
		logger.debug("setting doorCode = {}", this.doorCode);
	}
	public String getAvControlPanelLocation() {
		return avControlPanelLocation;
	}
	public void setAvControlPanelLocation(String avControlPanelLocation) {
		this.avControlPanelLocation = avControlPanelLocation;
		logger.debug("setting avControlPanelLocation = {}",
				this.avControlPanelLocation);
	}
	public String getNoOfProjectors() {
		return noOfProjectors;
	}
	public void setNoOfProjectors(String noOfProjectors) {
		this.noOfProjectors = noOfProjectors;
		logger.debug("setting noOfProjectors = {}", this.noOfProjectors);
	}
	public String getProjectorModel() {
		return projectorModel;
	}
	public void setProjectorModel(String projectorModel) {
		this.projectorModel = projectorModel;
		logger.debug("setting projectorModel = {}", this.projectorModel);
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
		logger.debug("setting roomType = {}", this.roomType);
	}
	public String getBulbHoursUsed() {
		return bulbHoursUsed;
	}
	public void setBulbHoursUsed(String bulbHoursUsed) {
		this.bulbHoursUsed = bulbHoursUsed;
		logger.debug("setting bulbHoursUsed = {}", this.bulbHoursUsed);
	}
	public String getDellTag() {
		return dellTag;
	}
	public void setDellTag(String dellTag) {
		this.dellTag = dellTag;
		logger.debug("setting dellTag = {}", this.dellTag);
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
		logger.debug("setting comments = {}", this.comments);
	}
	public String getDellTag1() {
		return dellTag1;
	}
	public void setDellTag1(String dellTag1) {
		this.dellTag1 = dellTag1;
		logger.debug("setting dellTag1 = {}", this.dellTag1);
	}
	public String getDellTagLaptop() {
		return dellTagLaptop;
	}
	public void setDellTagLaptop(String dellTagLaptop) {
		this.dellTagLaptop = dellTagLaptop;
		logger.debug("setting dellTagLaptop = {}", this.dellTagLaptop);
	}
	public String getDellTagBarcodeOnComputerBack() {
		return dellTagBarcodeOnComputerBack;
	}
	public void setDellTagBarcodeOnComputerBack(String dellTagBarcodeOnComputerBack) {
		this.dellTagBarcodeOnComputerBack = dellTagBarcodeOnComputerBack;
		logger.debug("setting dellTagBarcodeOnComputerBack = {}",
				this.dellTagBarcodeOnComputerBack);
	}
	public String getBarCodeOnProjector() {
		return barCodeOnProjector;
	}
	public void setBarCodeOnProjector(String barCodeOnProjector) {
		this.barCodeOnProjector = barCodeOnProjector;
		logger.debug("setting barCodeOnProjector = {}", this.barCodeOnProjector);
	}
	public String getProjectorInstallYear() {
		return projectorInstallYear;
	}
	public void setProjectorInstallYear(String projectorInstallYear) {
		this.projectorInstallYear = projectorInstallYear;
		logger.debug("setting projectorInstallYear = {}", this.projectorInstallYear);
	}
	public String getBarCodeOnComputer() {
		return barCodeOnComputer;
	}
	public void setBarCodeOnComputer(String barCodeOnComputer) {
		this.barCodeOnComputer = barCodeOnComputer;
		logger.debug("setting barCodeOnComputer = {}", this.barCodeOnComputer);
	}
	public String getAVPanelModel() {
		return aVPanelModel;
	}
	public void setAVPanelModel(String aVPanelModel) {
		this.aVPanelModel = aVPanelModel;
		logger.debug("setting aVPanelModel = {}", this.aVPanelModel);
	}
	public String getFilterHours() {
		return filterHours;
	}
	public void setFilterHours(String filterHours) {
		this.filterHours = filterHours;
		logger.debug("setting filterHours = {}", this.filterHours);
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
		logger.debug("setting capacity = {}", this.capacity);
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
		logger.debug("setting campus = {}", this.campus);
	}
	public String getWhiteboard() {
		return whiteboard;
	}
	public void setWhiteboard(String whiteboard) 
	{
		this.whiteboard = whiteboard;
		logger.debug("setting whiteboard = {}", this.whiteboard);
	}
	public String getSmartBoard() {
		return smartBoard;
	}
	public void setSmartBoard(String smartBoard) {
		this.smartBoard = smartBoard;
		logger.debug("setting smartBoard = {}", this.smartBoard);
	}
	public String getWhiteboardVsScreen() {
		return whiteboardVsScreen;
	}
	public void setWhiteboardVsScreen(String whiteboardVsScreen) {
		this.whiteboardVsScreen = whiteboardVsScreen;
		logger.debug("setting whiteboardVsScreen = {}", this.whiteboardVsScreen);
	}
	public String getMoveableFurniture() {
		return moveableFurniture;
	}
	public void setMoveableFurniture(String moveableFurniture) {
		this.moveableFurniture = moveableFurniture;
		logger.debug("setting moveableFurniture = {}", this.moveableFurniture);
	}
	public String getSmartPodium() {
		return smartPodium;
	}
	public void setSmartPodium(String smartPodium) {
		this.smartPodium = smartPodium;
		logger.debug("setting smartPodium = {}", this.smartPodium);
	}
	public String getDocumentCamera() {
		return documentCamera;
	}
	public void setDocumentCamera(String documentCamera) {
		this.documentCamera = documentCamera;
		logger.debug("setting documentCamera = {}", this.documentCamera);
	}
	public String getMediaPlayer() {
		return mediaPlayer;
	}
	public void setMediaPlayer(String mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
		logger.debug("setting mediaPlayer = {}", this.mediaPlayer);
	}
	public String getSoundSystem() {
		return soundSystem;
	}
	public void setSoundSystem(String soundSystem) {
		this.soundSystem = soundSystem;
		logger.debug("setting soundSystem = {}", this.soundSystem);
	}
	public String getSpecialSoftware() {
		return specialSoftware;
	}
	public void setSpecialSoftware(String specialSoftware) {
		this.specialSoftware = specialSoftware;
		logger.debug("setting specialSoftware = {}", this.specialSoftware);
	}
	public String getOtherRequests() {
		return otherRequests;
	}
	public void setOtherRequests(String otherRequests) {
		this.otherRequests = otherRequests;
		logger.debug("setting otherRequests = {}", this.otherRequests);
	}
	
	public String getStudentComputers() {
		return studentComputers;
	}
	public void setStudentComputers(String studentComputers) {
		this.studentComputers = studentComputers;
		logger.debug("setting studentComputers = {}", this.studentComputers);
	}
	public String getDigitalSignage() {
		return digitalSignage;
	}
	public void setDigitalSignage(String digitalSignage) {
		this.digitalSignage = digitalSignage;
		logger.debug("setting digitalSignage = {}", this.digitalSignage);
	}
	public String getWEPA() {
		return wEPA;
	}
	public void setWEPA(String wEPA) {
		this.wEPA = wEPA;
		logger.debug("setting wEPA = {}", this.wEPA);
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
		logger.debug("setting other = {}", this.other);
	}
	public String getExtra1() {
		return extra1;
	}
	public void setExtra1(String extra1) {
		this.extra1 = extra1;
		logger.debug("setting extra1 = {}", this.extra1);
	}
	public String getExtra2() {
		return extra2;
	}
	public void setExtra2(String extra2) {
		this.extra2 = extra2;
		logger.debug("setting extra2 = {}", this.extra2);
	}
	public String getExtra3() {
		return extra3;
	}
	public void setExtra3(String extra3) {
		this.extra3 = extra3;
		logger.debug("setting extra3 = {}", this.extra3);
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
		logger.debug("setting lastUpdatedBy = {}", this.lastUpdatedBy);
	}
	public String getHourReadingHelp() {
		return hourReadingHelp;
	}
	public void setHourReadingHelp(String hourReadingHelp) {
		this.hourReadingHelp = hourReadingHelp;
		logger.debug("setting hourReadingHelp = {}", this.hourReadingHelp);
	}
	public String getPodiumType() {
		return podiumType;
	}
	public void setPodiumType(String podiumType) {
		this.podiumType = podiumType;
		logger.debug("setting podiumType = {}", this.podiumType);
	}
	public String getMonitorType() {
		return monitorType;
	}
	public void setMonitorType(String monitorType) {
		this.monitorType = monitorType;
		logger.debug("setting monitorType = {}", this.monitorType);
	}
	public String getLastUpdatedTime() {
		return lastUpdatedTime;
	}
	public void setLastUpdatedTime(String lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
		logger.debug("setting lastUpdatedTime = {}", this.lastUpdatedTime);
	}
	public String getEquipLocks() {
		return equipLocks;
	}
	public void setEquipLocks(String equipLocks) {
		this.equipLocks = equipLocks;
		logger.debug("setting equipLocks = {}", this.equipLocks);
	}
	public String getBulb() {
		return bulb;
	}
	public void setBulb(String bulb) {
		this.bulb = bulb;
		logger.debug("setting bulb = {}", this.bulb);
	}
}
