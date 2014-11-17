package com.dmt.inventory.actions;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmt.common.actions.DefaultAction;
import com.dmt.inventory.dao.InventoryDAO;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;

public class LaunchInventoryAction extends DefaultAction
{	
	private static final long serialVersionUID	= 1L;
	static final Logger logger					= LoggerFactory.getLogger(com.dmt.inventory.actions.LaunchInventoryAction.class);
	private InventoryDAO inventoryDAO = new InventoryDAO();
	
	private TreeMap<Integer, String> mapBuildingRoom = new TreeMap<Integer, String>();
	private ArrayList<String> listAvControlPanelLocation = new ArrayList<String>();
	private ArrayList<String> listProjectorModel = new ArrayList<String>();
	private ArrayList<String> listRoomType = new ArrayList<String>();
	private ArrayList<String> listAVPanelModel = new ArrayList<String>();
	private ArrayList<String> listMediaPlayer = new ArrayList<String>();
	private ArrayList<String> listSoundSystem = new ArrayList<String>();
	private ArrayList<String> listMonitorType = new ArrayList<String>();
	private ArrayList<String> listPodiumType = new ArrayList<String>();
	
	public String launchInventory()
	{
		logger.info("executing launchInventory action...");
		
		SpreadsheetEntry spreadsheet = (SpreadsheetEntry)getSession().get("spreadsheet");
		if(spreadsheet != null)
		{
			inventoryDAO.getAllCombos(spreadsheet, 	listAvControlPanelLocation, 
													listProjectorModel, 
													listRoomType, 
													listAVPanelModel,
													listMediaPlayer, 
													listSoundSystem,
													listMonitorType,
													listPodiumType);
			mapBuildingRoom = inventoryDAO.getBuildingRoom(spreadsheet);
			
		}	
		return SUCCESS;
	}

	//getters and setters
	public InventoryDAO getInventoryDAO() {
		return inventoryDAO;
	}

	public void setInventoryDAO(InventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
		logger.debug("setting inventoryDAO = {}", this.inventoryDAO);
	}

	public TreeMap<Integer, String> getMapBuildingRoom() {
		return mapBuildingRoom;
	}

	public void setMapBuildingRoom(TreeMap<Integer, String> mapBuildingRoom) {
		this.mapBuildingRoom = mapBuildingRoom;
		logger.debug("setting mapBuildingRoom = {}", this.mapBuildingRoom);
	}

	public ArrayList<String> getListAvControlPanelLocation() {
		return listAvControlPanelLocation;
	}

	public void setListAvControlPanelLocation(
			ArrayList<String> listAvControlPanelLocation) {
		this.listAvControlPanelLocation = listAvControlPanelLocation;
		logger.debug("setting listAvControlPanelLocation = {}",
				this.listAvControlPanelLocation);
	}

	public ArrayList<String> getListProjectorModel() {
		return listProjectorModel;
	}

	public void setListProjectorModel(ArrayList<String> listProjectorModel) {
		this.listProjectorModel = listProjectorModel;
		logger.debug("setting listProjectorModel = {}", this.listProjectorModel);
	}

	public ArrayList<String> getListRoomType() {
		return listRoomType;
	}

	public void setListRoomType(ArrayList<String> listRoomType) {
		this.listRoomType = listRoomType;
		logger.debug("setting listRoomType = {}", this.listRoomType);
	}

	public ArrayList<String> getListAVPanelModel() {
		return listAVPanelModel;
	}

	public void setListAVPanelModel(ArrayList<String> listAVPanelModel) {
		this.listAVPanelModel = listAVPanelModel;
		logger.debug("setting listAVPanelModel = {}", this.listAVPanelModel);
	}

	public ArrayList<String> getListMediaPlayer() {
		return listMediaPlayer;
	}

	public void setListMediaPlayer(ArrayList<String> listMediaPlayer) {
		this.listMediaPlayer = listMediaPlayer;
		logger.debug("setting listMediaPlayer = {}", this.listMediaPlayer);
	}

	public ArrayList<String> getListSoundSystem() {
		return listSoundSystem;
	}

	public void setListSoundSystem(ArrayList<String> listSoundSystem) {
		this.listSoundSystem = listSoundSystem;
		logger.debug("setting listSoundSystem = {}", this.listSoundSystem);
	}

	public ArrayList<String> getListMonitorType() {
		return listMonitorType;
	}

	public void setListMonitorType(ArrayList<String> listMonitorType) {
		this.listMonitorType = listMonitorType;
		logger.debug("setting listMonitorType = {}", this.listMonitorType);
	}

	public ArrayList<String> getListPodiumType() {
		return listPodiumType;
	}

	public void setListPodiumType(ArrayList<String> listPodiumType) {
		this.listPodiumType = listPodiumType;
		logger.debug("setting listPodiumType = {}", this.listPodiumType);
	}
}
