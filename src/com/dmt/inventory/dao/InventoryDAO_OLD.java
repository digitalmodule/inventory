package com.dmt.inventory.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmt.common.model.User;
import com.dmt.inventory.model.Room;
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

public class InventoryDAO_OLD
{
	static final Logger logger					= LoggerFactory.getLogger(com.dmt.inventory.dao.InventoryDAO_OLD.class);
	
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
	
	public void getProjectorInfo(SpreadsheetEntry spreadsheet, Room room)
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
			    found :
			    {	
				    for (ListEntry row : listFeed.getEntries())
				    {
				    	// Iterate over the remaining columns
				    	boolean rowFound = false;
				    	for (String tag : row.getCustomElements().getTags()) 
				    	{
				    		if(tag.equalsIgnoreCase("ProjectorModel"))
				    		{
				    			if(row.getCustomElements().getValue(tag) != null)
				    			{	
				    				if(!row.getCustomElements().getValue(tag).trim().equalsIgnoreCase(""))
				    				{
				    					if(Utils.checkNullValueForString(room.getProjectorModel()).equalsIgnoreCase(row.getCustomElements().getValue(tag)))
				    						rowFound = true;
				    				}
				    			}	
				    		}
				    		if(rowFound)
				    		{	
					    		if(tag.equalsIgnoreCase("HourReadingHelp"))
					    		{
					    			if(row.getCustomElements().getValue(tag) != null)
					    			{	
					    				if(!row.getCustomElements().getValue(tag).trim().equalsIgnoreCase(""))
					    				{	
					    					room.setHourReadingHelp(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
					    				}
					    			}	
					    		}
					    		if(tag.equalsIgnoreCase("Bulb"))
					    		{
					    			if(row.getCustomElements().getValue(tag) != null)
					    			{	
					    				if(!row.getCustomElements().getValue(tag).trim().equalsIgnoreCase(""))
					    				{	
					    					room.setBulb(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
					    				}
					    				break found;
					    			}	
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
			    logger.debug("mapBuildingRoom = {}",mapBuildingRoom);
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
		return mapBuildingRoom;
	}
	
	public Room getRoomData(SpreadsheetEntry spreadsheet, int buildingRoomNo)
	{
		Room room = new Room();
		try
		{
			SpreadsheetService service = (SpreadsheetService) spreadsheet.getService();
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
			    				matchFound = true;
	    					}	
			    		}
			    		if(matchFound)
			    		{
			    			if(tag.equalsIgnoreCase("No"))
		    					room.setNo(Utils.parseInt(row.getCustomElements().getValue(tag)));
		    				if(tag.equalsIgnoreCase("Building"))
		    					room.setBuilding(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
		    				if(tag.equalsIgnoreCase("Room"))
		    					room.setRoom(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
		    				if(tag.equalsIgnoreCase("LinkToRoomSchedule"))
		    					room.setLinkToRoomSchedule(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
		    				if(tag.equalsIgnoreCase("LinkToRoomDetails"))
		    					room.setLinkToRoomDetails(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
		    				if(tag.equalsIgnoreCase("DoorCode"))
		    				{	
		    					room.setDoorCode(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)).replaceAll("\"", ""));
		    				}	
		    				if(tag.equalsIgnoreCase("AVControlPanelLocation"))
		    					room.setAvControlPanelLocation(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
		    				if(tag.equalsIgnoreCase("NoOfProjectors"))
		    					room.setNoOfProjectors(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
		    				if(tag.equalsIgnoreCase("ProjectorModel"))
		    					room.setProjectorModel(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
		    				if(tag.equalsIgnoreCase("RoomType"))
		    					room.setRoomType(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
		    				if(tag.equalsIgnoreCase("BulbHoursUsed"))
		    					room.setBulbHoursUsed(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
		    				if(tag.equalsIgnoreCase("DellTag"))
		    					room.setDellTag(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
		    				if(tag.equalsIgnoreCase("Comments"))
		    					room.setComments(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
		    				if(tag.equalsIgnoreCase("DellTag1"))
		    					room.setDellTag1(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
		    				if(tag.equalsIgnoreCase("DellTagLaptop"))
		    					room.setDellTagLaptop(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
		    				if(tag.equalsIgnoreCase("DellTagBarcodeOnComputerBack"))
		    					room.setDellTagBarcodeOnComputerBack(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
		    				if(tag.equalsIgnoreCase("BarCodeOnProjector"))
		    					room.setBarCodeOnProjector(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
		    				if(tag.equalsIgnoreCase("ProjectorInstallYear"))
		    					room.setProjectorInstallYear(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
		    				if(tag.equalsIgnoreCase("BarCodeOnComputer"))
		    					room.setBarCodeOnComputer(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));

							if(tag.equalsIgnoreCase("AVPanelModel")) 	
								room.setAVPanelModel(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("FilterHours")) 	
								 room.setFilterHours(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("Capacity")) 		
								room.setCapacity(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("Campus")) 		
								room.setCampus(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("Whiteboard")) 	
								room.setWhiteboard(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("SmartBoard")) 	
								room.setSmartBoard(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("WhiteboardVsScreen")) 
								room.setWhiteboardVsScreen(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("MoveableFurniture")) 
								room.setMoveableFurniture(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("PodiumType")) 	
								room.setPodiumType(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("SmartPodium")) 	
								room.setSmartPodium(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("DocumentCamera")) 	
								room.setDocumentCamera(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("MediaPlayer")) 	
								room.setMediaPlayer(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("SoundSystem")) 	
								room.setSoundSystem(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("SpecialSoftware")) 	
								room.setSpecialSoftware(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("OtherRequests"))	
								room.setOtherRequests(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("MonitorType")) 	
								room.setMonitorType(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("StudentComputers")) 	
								room.setStudentComputers(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("DigitalSignage")) 	
								room.setDigitalSignage(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("WEPA"))		
								room.setWEPA(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));	
							if(tag.equalsIgnoreCase("Other")) 		
								room.setOther(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));	
							if(tag.equalsIgnoreCase("Extra1")) 		
								room.setExtra1(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("Extra2")) 		
								room.setExtra2(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));	
							if(tag.equalsIgnoreCase("Extra3")) 		
								room.setExtra3(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("LastUpdatedBy")) 	
								room.setLastUpdatedBy(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("UpdateDateTime")) 	
								room.setLastUpdatedTime(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
							if(tag.equalsIgnoreCase("EquipLocks")) 	
								room.setEquipLocks(Utils.checkNullValueForString(row.getCustomElements().getValue(tag)));
			    		}	
			    	}
			    	if(matchFound)
			    		break;
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
		getProjectorInfo(spreadsheet,room);
		return room;
		
	}
	
	public void saveInventory(SpreadsheetEntry spreadsheet, Room room, User user)
	{
		 Calendar currentdate = Calendar.getInstance();
         String strDate = null;
         DateFormat formatter = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z");
         strDate = formatter.format(currentdate.getTime());
         TimeZone obj = TimeZone.getTimeZone("America/Virgin");

         formatter.setTimeZone(obj);
         strDate = formatter.format(currentdate.getTime());
	     logger.debug("The date and time in :: {} is :: {}", obj.getDisplayName(), strDate);
		try
		{
			SpreadsheetService service = (SpreadsheetService) spreadsheet.getService();
			WorksheetEntry worksheet = SpreadSheetUtil.selectWorkSheet(spreadsheet, "Inventory");
			if(worksheet != null)
			{
				URL listFeedUrl = worksheet.getListFeedUrl();
			    ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
	
			    // Iterate through each row
			    udpate:
			    {	
				    for (ListEntry row : listFeed.getEntries())
				    {
				    	// Iterate over the remaining columns
				    	for (String tag : row.getCustomElements().getTags()) 
				    	{
				    		if(tag.equalsIgnoreCase("No"))
				    		{
				    			if(Utils.parseInt(row.getCustomElements().getValue(tag)) == room.getNo())
		    					{
				    				//row.getCustomElements().
				    				row.getCustomElements().setValueLocal("DoorCode", "\""+room.getDoorCode()+"\"");
				    				row.getCustomElements().setValueLocal("AVControlPanelLocation", room.getAvControlPanelLocation());
				    				row.getCustomElements().setValueLocal("NoOfProjectors", room.getNoOfProjectors());
				    				row.getCustomElements().setValueLocal("ProjectorModel", room.getProjectorModel());
				    				row.getCustomElements().setValueLocal("RoomType", room.getRoomType());
				    				row.getCustomElements().setValueLocal("BulbHoursUsed", room.getBulbHoursUsed());
				    				row.getCustomElements().setValueLocal("DellTag", room.getDellTag());
				    				row.getCustomElements().setValueLocal("Comments", room.getComments());
				    				row.getCustomElements().setValueLocal("BarCodeOnProjector", room.getBarCodeOnProjector());
				    				row.getCustomElements().setValueLocal("ProjectorInstallYear", room.getProjectorInstallYear());
				    				row.getCustomElements().setValueLocal("BarCodeOnComputer", room.getBarCodeOnComputer());
				    				row.getCustomElements().setValueLocal("AVPanelModel",room.getAVPanelModel());
				    				row.getCustomElements().setValueLocal("FilterHours",room.getFilterHours());
				    				row.getCustomElements().setValueLocal("Capacity",room.getCapacity());
				    				row.getCustomElements().setValueLocal("Campus",room.getCampus());
				    				row.getCustomElements().setValueLocal("Whiteboard",room.getWhiteboard());
				    				row.getCustomElements().setValueLocal("SmartBoard",room.getSmartBoard());
				    				row.getCustomElements().setValueLocal("WhiteboardVsScreen",room.getWhiteboardVsScreen());
				    				row.getCustomElements().setValueLocal("MoveableFurniture",room.getMoveableFurniture());
				    				row.getCustomElements().setValueLocal("PodiumType",room.getPodiumType());
				    				row.getCustomElements().setValueLocal("SmartPodium",room.getSmartPodium());
				    				row.getCustomElements().setValueLocal("DocumentCamera",room.getDocumentCamera());
				    				row.getCustomElements().setValueLocal("MediaPlayer",room.getMediaPlayer());
				    				row.getCustomElements().setValueLocal("SoundSystem",room.getSoundSystem());
				    				row.getCustomElements().setValueLocal("SpecialSoftware",room.getSpecialSoftware());
				    				row.getCustomElements().setValueLocal("OtherRequests",room.getOtherRequests());
				    				row.getCustomElements().setValueLocal("MonitorType",room.getMonitorType());
				    				row.getCustomElements().setValueLocal("StudentComputers",room.getStudentComputers());
				    				row.getCustomElements().setValueLocal("DigitalSignage",room.getDigitalSignage());
				    				row.getCustomElements().setValueLocal("WEPA",room.getWEPA());
				    				row.getCustomElements().setValueLocal("Other",room.getOther());
				    				row.getCustomElements().setValueLocal("Extra1",room.getExtra1());
				    				row.getCustomElements().setValueLocal("Extra2",room.getExtra2());
				    				row.getCustomElements().setValueLocal("Extra3",room.getExtra3());
				    				row.getCustomElements().setValueLocal("LastUpdatedBy", user.getFirstName()+" "+user.getLastName());
				    				row.getCustomElements().setValueLocal("UpdateDateTime",strDate);
				    				row.getCustomElements().setValueLocal("EquipLocks",room.getEquipLocks());
				    				
				    				row.update();
				    				break udpate;
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
	}
	
}
