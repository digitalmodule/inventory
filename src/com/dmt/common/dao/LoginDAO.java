package com.dmt.common.dao;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmt.common.model.User;
import com.dmt.utility.SpreadSheetUtil;
import com.dmt.utility.Utils;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.util.ServiceException;

public class LoginDAO
{
	Logger logger = LoggerFactory.getLogger(com.dmt.common.dao.LoginDAO.class);
	public User authenticate(SpreadsheetEntry spreadsheet, User user)
	{
		try
		{
			SpreadsheetService service = (SpreadsheetService) spreadsheet.getService();
			WorksheetEntry worksheet = SpreadSheetUtil.selectWorkSheet(spreadsheet, "Users");
			if(worksheet != null)
			{
				URL listFeedUrl = worksheet.getListFeedUrl();
			    ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
	
			    // Iterate through each row
			    for (ListEntry row : listFeed.getEntries())
			    {
			    	// Iterate over the remaining columns
			    	HashMap<String, String> mapUserInfo = new HashMap<String, String>();
			    	for (String tag : row.getCustomElements().getTags()) 
			    	{
			    		mapUserInfo.put(tag, row.getCustomElements().getValue(tag));
			    	}
			    	if(mapUserInfo.get("username").equalsIgnoreCase(user.getUserName()) && mapUserInfo.get("password").equalsIgnoreCase(user.getPassword()))
			    	{
			    		user.setNo(Utils.parseInt(mapUserInfo.get("no")));
			    		user.setFirstName(mapUserInfo.get("firstname"));
			    		user.setMiddleName(mapUserInfo.get("middlename"));
			    		user.setLastName(mapUserInfo.get("lastname"));
			    		user.setEmail(mapUserInfo.get("email"));
			    		user.setRole(mapUserInfo.get("role"));
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
		return user;
	}
}
