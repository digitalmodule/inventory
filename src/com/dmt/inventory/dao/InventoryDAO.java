package com.dmt.inventory.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmt.common.model.User;
import com.dmt.inventory.model.Room;
import com.dmt.utility.Constants;
import com.dmt.utility.SpreadSheetUtil;
import com.dmt.utility.Utils;
import com.google.gdata.client.authn.oauth.*;
import com.google.gdata.client.spreadsheet.*;
import com.google.gdata.data.*;
import com.google.gdata.data.batch.*;
import com.google.gdata.data.spreadsheet.*;
import com.google.gdata.util.*;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class InventoryDAO
{
	static final Logger logger					= LoggerFactory.getLogger(com.dmt.inventory.dao.InventoryDAO.class);
	
	public void getAllCombos(SpreadsheetEntry spreadsheet,  ArrayList<String> listAvControlPanelLocation, 
															ArrayList<String> listProjectorModel, 
															ArrayList<String> listRoomType,
															ArrayList<String> listAVPanelModel, 
															ArrayList<String> listMediaPlayer, 
															ArrayList<String> listSoundSystem,
															ArrayList<String> listMonitorType,
															ArrayList<String> listPodiumType)
	{
		try
		{
			SpreadsheetService service = (SpreadsheetService) spreadsheet.getService();
			WorksheetEntry worksheet = SpreadSheetUtil.selectWorkSheet(spreadsheet, "options");
			if(worksheet != null)
			{
				URL listFeedUrl = worksheet.getListFeedUrl();
			    ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
	
			    // Iterate through each row
			    for (ListEntry row : listFeed.getEntries())
			    {
			    	// Iterate over the remaining columns
			    	for (String tag : row.getCustomElements().getTags()) 
			    	{
			    		if(tag.equalsIgnoreCase("AVControlPanelLocation"))
			    		{
			    			if(row.getCustomElements().getValue(tag) != null)
			    			{	
			    				if(!row.getCustomElements().getValue(tag).trim().equalsIgnoreCase(""))
			    					listAvControlPanelLocation.add(row.getCustomElements().getValue(tag));
			    			}	
			    		}
			    		if(tag.equalsIgnoreCase("ProjectorModel"))
			    		{
			    			if(row.getCustomElements().getValue(tag) != null)
			    			{	
			    				if(!row.getCustomElements().getValue(tag).trim().equalsIgnoreCase(""))
			    					listProjectorModel.add(row.getCustomElements().getValue(tag));
			    			}	
			    		}
			    		if(tag.equalsIgnoreCase("RoomType"))
			    		{
			    			if(row.getCustomElements().getValue(tag) != null)
			    			{	
			    				if(!row.getCustomElements().getValue(tag).trim().equalsIgnoreCase(""))
			    					listRoomType.add(row.getCustomElements().getValue(tag));
			    			}	
			    		}
			    		if(tag.equalsIgnoreCase("AVPanelModel"))
			    		{
			    			if(row.getCustomElements().getValue(tag) != null)
			    			{	
			    				if(!row.getCustomElements().getValue(tag).trim().equalsIgnoreCase(""))
			    					listAVPanelModel.add(row.getCustomElements().getValue(tag));
			    			}	
			    		}
			    		if(tag.equalsIgnoreCase("MediaPlayer"))
			    		{
			    			if(row.getCustomElements().getValue(tag) != null)
			    			{	
			    				if(!row.getCustomElements().getValue(tag).trim().equalsIgnoreCase(""))
			    					listMediaPlayer.add(row.getCustomElements().getValue(tag));
			    			}	
			    		}
			    		if(tag.equalsIgnoreCase("SoundSystem"))
			    		{
			    			if(row.getCustomElements().getValue(tag) != null)
			    			{	
			    				if(!row.getCustomElements().getValue(tag).trim().equalsIgnoreCase(""))
			    					listSoundSystem.add(row.getCustomElements().getValue(tag));
			    			}	
			    		}
			    		if(tag.equalsIgnoreCase("MonitorType"))
			    		{
			    			if(row.getCustomElements().getValue(tag) != null)
			    			{	
			    				if(!row.getCustomElements().getValue(tag).trim().equalsIgnoreCase(""))
			    					listMonitorType.add(row.getCustomElements().getValue(tag));
			    			}	
			    		}
			    		if(tag.equalsIgnoreCase("PodiumType"))
			    		{
			    			if(row.getCustomElements().getValue(tag) != null)
			    			{	
			    				if(!row.getCustomElements().getValue(tag).trim().equalsIgnoreCase(""))
			    					listPodiumType.add(row.getCustomElements().getValue(tag));
			    			}	
			    		}
			    	}	
			    }	
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ServiceException e)
		{
			e.printStackTrace();
		}
	}
	
	public HashMap<String, String> getProjectorInfo(SpreadsheetEntry spreadsheet, int projectorId)
	{
		HashMap<String, String> mapProjectorInfo = new HashMap<String, String>();
		try
		{
			SpreadsheetService service = (SpreadsheetService) spreadsheet.getService();
			WorksheetEntry worksheet = SpreadSheetUtil.selectWorkSheet(spreadsheet, "Projectors");
			
			if(worksheet != null)
			{
				URL listFeedUrl = worksheet.getListFeedUrl();
			    ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
	
			    // Iterate through each row
			    found :
			    {	
				    for (ListEntry row : listFeed.getEntries())
				    {
				    	// Iterate over the remaining columns
				    	boolean rowFound = false;
				    	for (String tag : row.getCustomElements().getTags()) 
				    	{
				    		if(tag.equalsIgnoreCase(Utils.getPlainString("no")))
				    		{
				    			if(Utils.parseInt(row.getCustomElements().getValue(tag)) == projectorId)
		    					{
				    				rowFound = true;
				    				mapProjectorInfo.put("no", Utils.checkNullValueForString(row.getCustomElements().getValue("no")));
		    					}	
				    		}
				    		if(rowFound)
				    		{
				    			mapProjectorInfo.put(tag, Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
				    		}	
				    		
				    	}	
				    }	
				}
			}    
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ServiceException e)
		{
			e.printStackTrace();
		}
		return mapProjectorInfo;
	}
	
	public HashMap<String, String> getComputerInfo(SpreadsheetEntry spreadsheet, int computerId)
	{
		HashMap<String, String> mapComputerInfo = new HashMap<String, String>();
		try
		{
			SpreadsheetService service = (SpreadsheetService) spreadsheet.getService();
			WorksheetEntry worksheet = SpreadSheetUtil.selectWorkSheet(spreadsheet, "Computers");
			
			if(worksheet != null)
			{
				URL listFeedUrl = worksheet.getListFeedUrl();
			    ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
	
			    // Iterate through each row
			    found :
			    {	
				    for (ListEntry row : listFeed.getEntries())
				    {
				    	// Iterate over the remaining columns
				    	boolean rowFound = false;
				    	for (String tag : row.getCustomElements().getTags()) 
				    	{
				    		if(tag.equalsIgnoreCase(Utils.getPlainString("no")))
				    		{
				    			if(Utils.parseInt(row.getCustomElements().getValue(tag)) == computerId)
		    					{
				    				rowFound = true;
				    				mapComputerInfo.put("no", Utils.checkNullValueForString(row.getCustomElements().getValue("no")));
		    					}	
				    		}
				    		if(rowFound)
				    		{
				    			mapComputerInfo.put(tag, Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
				    		}	
				    		
				    	}	
				    }	
				}
			}    
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ServiceException e)
		{
			e.printStackTrace();
		}
		return mapComputerInfo;
	}
	
	public HashMap<String, String> getProjectorModelInfo(SpreadsheetEntry spreadsheet, String projectorModelName)
	{
		HashMap<String, String> mapProjectorModelInfo = new HashMap<String, String>();
		try
		{
			SpreadsheetService service = (SpreadsheetService) spreadsheet.getService();
			WorksheetEntry worksheet = SpreadSheetUtil.selectWorkSheet(spreadsheet, "Information");
			
			if(worksheet != null)
			{
				URL listFeedUrl = worksheet.getListFeedUrl();
			    ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
	
			    // Iterate through each row
			    found :
			    {	
				    for (ListEntry row : listFeed.getEntries())
				    {
				    	// Iterate over the remaining columns
				    	boolean rowFound = false;
				    	for (String tag : row.getCustomElements().getTags()) 
				    	{
				    		if(tag.equalsIgnoreCase(Utils.getPlainString("ItemModel")))
				    		{
				    			if(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)).equalsIgnoreCase(projectorModelName))
		    					{
				    				rowFound = true;
				    				mapProjectorModelInfo.put("itemmodel", Utils.checkNullValueForString(row.getCustomElements().getValue("ItemModel")));
		    					}	
				    		}
				    		if(rowFound)
				    		{
				    			mapProjectorModelInfo.put(tag, Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
				    		}	
				    		
				    	}	
				    }	
				}
			}    
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ServiceException e)
		{
			e.printStackTrace();
		}
		return mapProjectorModelInfo;
	}
	
	public TreeMap<Integer, String> getBuildingRoom(SpreadsheetEntry spreadsheet)
	{
		TreeMap<Integer, String> mapBuildingRoom = new TreeMap<Integer, String>();
		try
		{	
			SpreadsheetService service = (SpreadsheetService) spreadsheet.getService();
			WorksheetEntry worksheet = SpreadSheetUtil.selectWorkSheet(spreadsheet, "Inventory");
			if(worksheet != null)
			{
				URL listFeedUrl = worksheet.getListFeedUrl();
			    ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);

			    // Iterate through each row
			    ROW:
			    for (ListEntry row : listFeed.getEntries())
			    {
			      // Iterate over the remaining columns
			      int no = 0;
			      String buildingRoom = "";
			      for (String tag : row.getCustomElements().getTags()) 
			      { 
			    	  if(tag.equalsIgnoreCase("No"))
			    	  {
			    		  no = 	Utils.parseInt(row.getCustomElements().getValue(tag));
			    	  }
			    	  if(tag.equalsIgnoreCase(Utils.getPlainString("Show On Class Inv")))
			    	  {
			    		  if(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)).equalsIgnoreCase("N"))
			    		  {
			    			 continue ROW; 
			    		  }		  
			    	  }	  
			    	  if(tag.equalsIgnoreCase("Building"))
			    	  {
			    		  buildingRoom = Utils.checkNullValueForString(row.getCustomElements().getValue(tag));
			    	  }
			    	  if(tag.equalsIgnoreCase("Room"))
			    	  {
			    		  buildingRoom = buildingRoom + " - " +	Utils.checkNullValueForString(row.getCustomElements().getValue(tag));
			    	  }
			      }
			      if(!buildingRoom.equalsIgnoreCase(" - "))
			    	  mapBuildingRoom.put(no, buildingRoom);
			    }
		    }
		    logger.debug("mapBuildingRoom = {}",mapBuildingRoom);
    
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ServiceException e)
		{
			e.printStackTrace();
		}
		return mapBuildingRoom;
	}
	
	public TreeMap<String, Object> getRoomData(SpreadsheetEntry spreadsheet, int buildingRoomNo)
	{
		Room room = new Room();
		int roomId = 0;
		TreeMap<String, Object> mapRoomInfo = new TreeMap<String, Object>();
		try
		{
			SpreadsheetService service = (SpreadsheetService) spreadsheet.getService();
			//getting data from inventory work sheet
			WorksheetEntry worksheet = SpreadSheetUtil.selectWorkSheet(spreadsheet, "Inventory");
			if(worksheet != null)
			{
				URL listFeedUrl = worksheet.getListFeedUrl();
			    ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
	
			    // Iterate through each row
			    for (ListEntry row : listFeed.getEntries())
			    {
			    	boolean matchFound = false;
			    	for (String tag : row.getCustomElements().getTags()) 
			    	{
			    		if(tag.equalsIgnoreCase("No"))
			    		{
			    			if(Utils.parseInt(row.getCustomElements().getValue(tag)) == buildingRoomNo)
	    					{
			    				roomId = Utils.parseInt(row.getCustomElements().getValue(tag));
			    				matchFound = true;
	    					}	
			    		}
			    		if(matchFound)
			    		{
			    			mapRoomInfo.put(tag, Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
			    		}	
			    	}
			    	if(matchFound)
			    		break;
			    }	
			}
			//getting all projectors available computer information
			ArrayList<HashMap<String, String>> listMapProjectorInformation = new ArrayList<HashMap<String, String>>();
			worksheet = SpreadSheetUtil.selectWorkSheet(spreadsheet, "Projectors");
			if(worksheet != null)
			{
				URL listFeedUrl = worksheet.getListFeedUrl();
			    ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
	
			    // Iterate through each row
			    for (ListEntry row : listFeed.getEntries())
			    {
			    	boolean matchFound = false;
			    	HashMap<String, String> mapProjectorInfo = new HashMap<String, String>();
			    	for (String tag : row.getCustomElements().getTags()) 
			    	{
			    		if(tag.equalsIgnoreCase(Utils.getPlainString("Room Id")))
			    		{
			    			if(Utils.parseInt(row.getCustomElements().getValue(tag)) == roomId)
	    					{
			    				matchFound = true;
			    				mapProjectorInfo.put("no", Utils.checkNullValueForString(row.getCustomElements().getValue("no")));
	    					}	
			    		}
			    		if(matchFound)
			    		{
			    			mapProjectorInfo.put(tag, Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
			    		}	
			    	}
			    	if(mapProjectorInfo != null && mapProjectorInfo.size()>0)
			    		listMapProjectorInformation.add(mapProjectorInfo);
			    }
			    mapRoomInfo.put("projectors", listMapProjectorInformation);
			}
			
			//getting all computers available computer information
			ArrayList<HashMap<String, String>> listMapComputerInformation = new ArrayList<HashMap<String, String>>();
			worksheet = SpreadSheetUtil.selectWorkSheet(spreadsheet, "Computers");
			if(worksheet != null)
			{
				URL listFeedUrl = worksheet.getListFeedUrl();
			    ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
	
			    // Iterate through each row
			    for (ListEntry row : listFeed.getEntries())
			    {
			    	boolean matchFound = false;
			    	HashMap<String, String> mapComputerInfo = new HashMap<String, String>();
			    	for (String tag : row.getCustomElements().getTags()) 
			    	{
			    		if(tag.equalsIgnoreCase(Utils.getPlainString("Room Id")))
			    		{
			    			if(Utils.parseInt(row.getCustomElements().getValue(tag)) == roomId)
	    					{
			    				matchFound = true;
			    				mapComputerInfo.put("no", Utils.checkNullValueForString(row.getCustomElements().getValue("no")));
	    					}	
			    		}
			    		if(matchFound)
			    		{
			    			mapComputerInfo.put(tag, Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
			    		}	
			    	}
			    	if(mapComputerInfo != null && mapComputerInfo.size()>0)
			    		listMapComputerInformation.add(mapComputerInfo);
			    }
			    mapRoomInfo.put("computers", listMapComputerInformation);
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ServiceException e)
		{
			e.printStackTrace();
		}
		return mapRoomInfo;
		
	}
	
	public void saveInventory(SpreadsheetEntry spreadsheet, TreeMap<String, String> mapRoomInfo, User user)
	{
		 Calendar currentdate = Calendar.getInstance();
         String strDate = null;
         DateFormat formatter = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z");
         strDate = formatter.format(currentdate.getTime());
         TimeZone obj = TimeZone.getTimeZone("America/Virgin");

         formatter.setTimeZone(obj);
         strDate = formatter.format(currentdate.getTime());
		try
		{
			SpreadsheetService service = (SpreadsheetService) spreadsheet.getService();
			WorksheetEntry worksheet = SpreadSheetUtil.selectWorkSheet(spreadsheet, "Inventory");
			boolean found = false;
			if(worksheet != null)
			{
				URL listFeedUrl = worksheet.getListFeedUrl();
			    ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
	
			    // Iterate through each row
			    udpate:
			    {	
				    int count = 1;
			    	for (ListEntry row : listFeed.getEntries())
				    {
				    	count++;
				    	// Iterate over the remaining columns
				    	for (String tag : row.getCustomElements().getTags()) 
				    	{
				    		if(tag.equalsIgnoreCase("No"))
				    		{
				    			if(Utils.parseInt(row.getCustomElements().getValue(tag)) == Utils.parseInt(mapRoomInfo.get(tag)))
		    					{
				    				found = true;
		    					}	
				    		}
				    		if(found)
					    	{
				    			if(!Constants.SAVE_COLUMN_IGNORE_LIST.contains(tag))
				    			{	
				    				row.getCustomElements().setValueLocal(tag, Utils.checkNullValueForString(mapRoomInfo.get(tag)));
				    			}
				    			else
				    			{
				    				System.out.println("static column "+tag+", so not saving");
				    			}
			    				
					    	}
					    	
				    	}
				    	if(found)
				    	{	
				    		row.getCustomElements().setValueLocal("LastUpdatedBy", user.getFirstName()+" "+user.getLastName());
		    				row.getCustomElements().setValueLocal("LastUpdatedTime",strDate);
				    		row.update();
		    				break;
				    	}
				    }
			    }
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ServiceException e)
		{
			e.printStackTrace();
		}
	}
	
	public void saveProjectorInformation(SpreadsheetEntry spreadsheet, TreeMap<String, String> mapProjectorInfo, User user)
	{
		 Calendar currentdate = Calendar.getInstance();
         String strDate = null;
         DateFormat formatter = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z");
         strDate = formatter.format(currentdate.getTime());
         TimeZone obj = TimeZone.getTimeZone("America/Virgin");

         formatter.setTimeZone(obj);
         strDate = formatter.format(currentdate.getTime());
		try
		{
			SpreadsheetService service = (SpreadsheetService) spreadsheet.getService();
			WorksheetEntry worksheet = SpreadSheetUtil.selectWorkSheet(spreadsheet, "Projectors");
			boolean found = false;
			if(worksheet != null)
			{
				URL listFeedUrl = worksheet.getListFeedUrl();
			    ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
	
			    // Iterate through each row
			    udpate:
			    {	
				    int count = 1;
			    	for (ListEntry row : listFeed.getEntries())
				    {
				    	count++;
				    	// Iterate over the remaining columns
				    	for (String tag : row.getCustomElements().getTags()) 
				    	{
				    		if(tag.equalsIgnoreCase("No"))
				    		{
				    			if(Utils.parseInt(row.getCustomElements().getValue(tag)) == Utils.parseInt(mapProjectorInfo.get(tag)))
		    					{
				    				found = true;
		    					}	
				    		}
				    		if(found)
					    	{
				    			if(!Constants.SAVE_PROJECTOR_COLUMN_IGNORE_LIST.contains(tag))
				    			{	
				    				row.getCustomElements().setValueLocal(tag, Utils.checkNullValueForString(mapProjectorInfo.get(tag)));
				    			}
				    			else
				    			{
				    				System.out.println("static column "+tag+", so not saving");
				    			}
			    				
					    	}
					    	
				    	}
				    	if(found)
				    	{	
				    		row.getCustomElements().setValueLocal("LastUpdatedBy", user.getFirstName()+" "+user.getLastName());
		    				row.getCustomElements().setValueLocal("UpdateDateTime",strDate);
				    		row.update();
		    				break;
				    	}
				    }
			    }
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ServiceException e)
		{
			e.printStackTrace();
		}
	}
	
	public void saveComputerInformation(SpreadsheetEntry spreadsheet, TreeMap<String, String> mapComputerInfo, User user)
	{
		 Calendar currentdate = Calendar.getInstance();
         String strDate = null;
         DateFormat formatter = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z");
         strDate = formatter.format(currentdate.getTime());
         TimeZone obj = TimeZone.getTimeZone("America/Virgin");

         formatter.setTimeZone(obj);
         strDate = formatter.format(currentdate.getTime());
		try
		{
			SpreadsheetService service = (SpreadsheetService) spreadsheet.getService();
			WorksheetEntry worksheet = SpreadSheetUtil.selectWorkSheet(spreadsheet, "Computers");
			boolean found = false;
			if(worksheet != null)
			{
				URL listFeedUrl = worksheet.getListFeedUrl();
			    ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
	
			    // Iterate through each row
			    udpate:
			    {	
				    int count = 1;
			    	for (ListEntry row : listFeed.getEntries())
				    {
				    	count++;
				    	// Iterate over the remaining columns
				    	for (String tag : row.getCustomElements().getTags()) 
				    	{
				    		if(tag.equalsIgnoreCase("No"))
				    		{
				    			if(Utils.parseInt(row.getCustomElements().getValue(tag)) == Utils.parseInt(mapComputerInfo.get(tag)))
		    					{
				    				found = true;
		    					}	
				    		}
				    		if(found)
					    	{
				    			if(!Constants.SAVE_COMPUTER_COLUMN_IGNORE_LIST.contains(tag))
				    			{	
				    				row.getCustomElements().setValueLocal(tag, Utils.checkNullValueForString(mapComputerInfo.get(tag)));
				    			}
				    			else
				    			{
				    				System.out.println("static column "+tag+", so not saving");
				    			}
			    				
					    	}
				    	}
				    	if(found)
				    	{	
				    		row.getCustomElements().setValueLocal("LastUpdatedBy", user.getFirstName()+" "+user.getLastName());
		    				row.getCustomElements().setValueLocal("UpdateDateTime",strDate);
				    		row.update();
		    				break;
				    	}
				    }
			    }
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ServiceException e)
		{
			e.printStackTrace();
		}
	}
	
	public String replaceBulb(SpreadsheetEntry spreadsheet, int projectorId)
	{
		String bulbName = "";
		Calendar currentdate = Calendar.getInstance();
        String strDate = null;
        DateFormat formatter = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z");
        strDate = formatter.format(currentdate.getTime());
        TimeZone obj = TimeZone.getTimeZone("America/Virgin");

        formatter.setTimeZone(obj);
        strDate = formatter.format(currentdate.getTime());
		try
		{
			String selectedModel = "";
			SpreadsheetService service = (SpreadsheetService) spreadsheet.getService();
			WorksheetEntry worksheet = SpreadSheetUtil.selectWorkSheet(spreadsheet, "Projectors");
			
			if(worksheet != null)
			{
				URL listFeedUrl = worksheet.getListFeedUrl();
			    ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
	
			    // Iterate through each row
			    found :
			    {	
				    for (ListEntry row : listFeed.getEntries())
				    {
				    	// Iterate over the remaining columns
				    	boolean rowFound = false;
				    	for (String tag : row.getCustomElements().getTags()) 
				    	{
				    		if(tag.equalsIgnoreCase(Utils.getPlainString("no")))
				    		{
				    			if(Utils.parseInt(row.getCustomElements().getValue(tag)) == projectorId)
		    					{
				    				rowFound = true;
		    					}	
				    		}
				    		if(rowFound)
				    		{
				    			if(tag.equalsIgnoreCase(Utils.getPlainString("Projector Model")))
					    		{
				    				selectedModel = Utils.checkNullValueForString(row.getCustomElements().getValue(tag));
				    				break;
					    		}
				    		}	
				    		
				    	}
				    	if(rowFound)
			    		{
			    			row.getCustomElements().setValueLocal(Utils.getPlainString("Bulb Hours Used"), "0");
			    			row.getCustomElements().setValueLocal(Utils.getPlainString("Bulb Replace Date"), strDate);
			    			row.update();
		    				break;
			    		}
				    }	
				}
			}  
			
			worksheet = SpreadSheetUtil.selectWorkSheet(spreadsheet, "Information");
			
			if(worksheet != null)
			{
				URL listFeedUrl = worksheet.getListFeedUrl();
			    ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
	
			    // Iterate through each row
			    found :
			    {	
				    for (ListEntry row : listFeed.getEntries())
				    {
				    	// Iterate over the remaining columns
				    	boolean rowFound = false;
				    	for (String tag : row.getCustomElements().getTags()) 
				    	{
				    		if(tag.equalsIgnoreCase(Utils.getPlainString("ItemModel")))
				    		{
				    			if(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)).equalsIgnoreCase(selectedModel))
		    					{
				    				rowFound = true;
		    					}	
				    		}
				    		if(rowFound)
				    		{
				    			if(tag.equalsIgnoreCase(Utils.getPlainString("Bulb")))
					    		{
				    				bulbName = Utils.checkNullValueForString(row.getCustomElements().getValue(tag));
					    		}
				    			else if(tag.equalsIgnoreCase(Utils.getPlainString("BulbStockQuantity")))
					    		{
				    				int oldQuantity = Utils.parseInt(row.getCustomElements().getValue(tag));
				    				row.getCustomElements().setValueLocal(tag, (oldQuantity-1)+"");
				    				row.update();
				    				break found;
					    		}
				    		}	
				    		
				    	}
				    }	
				}
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ServiceException e)
		{
			e.printStackTrace();
		}
		return bulbName;
	}
	
}
