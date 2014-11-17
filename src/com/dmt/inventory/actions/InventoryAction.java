package com.dmt.inventory.actions;


import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmt.common.actions.DefaultAction;
import com.dmt.common.model.User;
import com.dmt.inventory.dao.InventoryDAO;
import com.dmt.inventory.model.Room;
import com.dmt.utility.Data;
import com.dmt.utility.GoogleMailSender;
import com.dmt.utility.Status;
import com.dmt.utility.Utils;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gson.annotations.Expose;

public class InventoryAction extends DefaultAction
{	
	private static final long serialVersionUID	= 1L;
	static final Logger logger					= LoggerFactory.getLogger(com.dmt.inventory.actions.InventoryAction.class);
	InventoryDAO inventoryDAO = new InventoryDAO();
	private Room room = new Room();
	TreeMap<String, Object> mapRoomInfo = new TreeMap<String, Object>();
	private int buildingRoomNo = 0 ;
	private int projectorId = 0;
	private int computerId = 0;
	private String projectorModelName = "";
	private Object jsonModel;

	public String getRoomData()
	{
		logger.info("executing getRoomData action...");
		User user = (User)getSession().get("user");
		if(user != null  && user.getNo()>0)
		{	
			SpreadsheetEntry spreadsheet = (SpreadsheetEntry)getSession().get("spreadsheet");
			if(spreadsheet != null)
			{
				mapRoomInfo = inventoryDAO.getRoomData(spreadsheet, buildingRoomNo);
			}
			setJsonModel(mapRoomInfo);
		}
		else
		{
			Status status = new Status();
			status.setSuccess(false);
			status.setError("You are not logged in, Please log in to get Room Data");
			setJsonModel(status);
		}	
		return SUCCESS;
	}
	
	public String getProjectorInfo()
	{
		logger.info("executing getProjectorInfo action...");
		
		SpreadsheetEntry spreadsheet = (SpreadsheetEntry)getSession().get("spreadsheet");
		HashMap<String, String> mapProjectorInfo= inventoryDAO.getProjectorInfo(spreadsheet, projectorId);
		setJsonModel(mapProjectorInfo);
		return SUCCESS;
	}
	
	public String getProjectorModelInfo()
	{
		logger.info("executing getProjectorModelInfo action...");
		
		SpreadsheetEntry spreadsheet = (SpreadsheetEntry)getSession().get("spreadsheet");
		HashMap<String, String> mapProjectorModelInfo= inventoryDAO.getProjectorModelInfo(spreadsheet, projectorModelName);
		setJsonModel(mapProjectorModelInfo);
		return SUCCESS;
	}
	
	public String getComputerInfo()
	{
		logger.info("executing getComputerInfo action...");
		
		SpreadsheetEntry spreadsheet = (SpreadsheetEntry)getSession().get("spreadsheet");
		HashMap<String, String> mapComputerInfo= inventoryDAO.getComputerInfo(spreadsheet, computerId);
		setJsonModel(mapComputerInfo);
		return SUCCESS;
	}
	
	public String saveInventory()
	{
		logger.info("executing saveInventory action...");
		User user = (User)getSession().get("user");
		if(user!= null && user.getNo()>0)
		{
			SpreadsheetEntry spreadsheet = (SpreadsheetEntry)getSession().get("spreadsheet");
			Status status = new Status();
			if(spreadsheet != null)
			{
				TreeMap<String, String> mapRoomInfo = getAllRequestParamsInMap(getRequest());
				System.out.println("mapRoomInfo = "+mapRoomInfo);
				inventoryDAO.saveInventory(spreadsheet, mapRoomInfo, user);
				status.setSuccess(true);
			}
			else
			{
				status.setError("Could not connect to Google Spreadsheet for inventory, Please try again later.");
			}
			setJsonModel(status);
		}
		else
		{
			Status status = new Status();
			status.setSuccess(false);
			status.setError("You are not logged in, Please log in to save Room Data");
			setJsonModel(status);
		}
		return SUCCESS;
	}
	
	public String saveProjectorInformation()
	{
		logger.info("executing saveProjectorInformation action...");
		User user = (User)getSession().get("user");
		if(user!= null && user.getNo()>0)
		{
			SpreadsheetEntry spreadsheet = (SpreadsheetEntry)getSession().get("spreadsheet");
			Status status = new Status();
			if(spreadsheet != null)
			{
				TreeMap<String, String> mapProjectorInfo = getAllRequestParamsInMap(getRequest());
				System.out.println("mapProjectorInfo = "+mapProjectorInfo);
				inventoryDAO.saveProjectorInformation(spreadsheet, mapProjectorInfo, user);
				status.setSuccess(true);
			}
			else
			{
				status.setError("Could not connect to Google Spreadsheet for inventory, Please try again later.");
			}
			setJsonModel(status);
		}
		else
		{
			Status status = new Status();
			status.setSuccess(false);
			status.setError("You are not logged in, Please log in to save Projector Information");
			setJsonModel(status);
		}
		return SUCCESS;
	}
	
	public String saveComputerInformation()
	{
		logger.info("executing saveComputerInformation action...");
		User user = (User)getSession().get("user");
		if(user!= null && user.getNo()>0)
		{
			SpreadsheetEntry spreadsheet = (SpreadsheetEntry)getSession().get("spreadsheet");
			Status status = new Status();
			if(spreadsheet != null)
			{
				TreeMap<String, String> mapComputerInfo = getAllRequestParamsInMap(getRequest());
				System.out.println("mapComputerInfo = "+mapComputerInfo);
				inventoryDAO.saveComputerInformation(spreadsheet, mapComputerInfo, user);
				status.setSuccess(true);
			}
			else
			{
				status.setError("Could not connect to Google Spreadsheet for inventory, Please try again later.");
			}
			setJsonModel(status);
		}
		else
		{
			Status status = new Status();
			status.setSuccess(false);
			status.setError("You are not logged in, Please log in to save Computer Information");
			setJsonModel(status);
		}
		return SUCCESS;
	}
	
	private TreeMap<String, String> getAllRequestParamsInMap(HttpServletRequest request)
	{
		TreeMap<String, String> mapRoomInfo = new TreeMap<String, String>();
		
		 Enumeration<String> en = request.getParameterNames();
		 
         while (en.hasMoreElements()) 
         {
             String parameterName = en.nextElement();
             String parameterValue = request.getParameter(parameterName);
             mapRoomInfo.put(Utils.checkNullValueForString(parameterName).toLowerCase(), parameterValue);
         }
		
		return mapRoomInfo;
	}
	
	public String replaceBulb()
	{
		logger.info("executing replaceBulb action...");
		String bulbName = "";
		User user = (User)getSession().get("user");
		if(user!= null && user.getNo()>0)
		{
			SpreadsheetEntry spreadsheet = (SpreadsheetEntry)getSession().get("spreadsheet");
			Status status = new Status();
			if(spreadsheet != null)
			{
				bulbName = inventoryDAO.replaceBulb(spreadsheet, projectorId);
				String emailFrom = "noreply@digitalmodule.net";
				String emailTo = "stambert@marymount.edu";
				String emailSubject = "Order "+bulbName;
				String emailMessage = "Order "+bulbName;
				
				boolean sentFlag = GoogleMailSender.sendEmail(emailFrom, emailTo, emailSubject, emailMessage);
				if(sentFlag)
				{
					status.setSuccess(true);
				}	
				else
				{
					status.setError("There are some problems sending an email, Please try later.");
				}
			}
			else
			{
				status.setError("Could not connect to Google Spreadsheet for inventory, Please try again later.");
			}
			setJsonModel(status);
		}
		else
		{
			Status status = new Status();
			status.setSuccess(false);
			status.setError("You are not logged in, Please log in to save Computer Information");
			setJsonModel(status);
		}
		return SUCCESS;
	}
	
	//getters and setters
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
		logger.debug("setting room = {}", this.room);
	}
	public Object getJsonModel() {
		return jsonModel;
	}

	public void setJsonModel(Object jsonModel) {
		this.jsonModel = jsonModel;
		logger.debug("setting jsonModel = {}", this.jsonModel);
	}

	public int getBuildingRoomNo() {
		return buildingRoomNo;
	}

	public void setBuildingRoomNo(int buildingRoomNo) {
		this.buildingRoomNo = buildingRoomNo;
		logger.debug("setting buildingRoomNo = {}", this.buildingRoomNo);
	}

	public InventoryDAO getInventoryDAO() {
		return inventoryDAO;
	}

	public void setInventoryDAO(InventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
		logger.debug("setting inventoryDAO = {}", this.inventoryDAO);
	}

	public int getProjectorId() {
		return projectorId;
	}

	public void setProjectorId(int projectorId) {
		this.projectorId = projectorId;
		logger.debug("setting projectorId = {}", this.projectorId);
	}
	
	public String getProjectorModelName() {
		return projectorModelName;
	}

	public void setProjectorModelName(String projectorModelName) {
		this.projectorModelName = projectorModelName;
		logger.debug("setting projectorModelName = {}", this.projectorModelName);
	}

	public int getComputerId() {
		return computerId;
	}

	public void setComputerId(int computerId) {
		this.computerId = computerId;
		logger.debug("setting computerId = {}", this.computerId);
	}

}
