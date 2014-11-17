package com.dmt.utility;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gdata.client.authn.oauth.*;
import com.google.gdata.client.spreadsheet.*;
import com.google.gdata.data.*;
import com.google.gdata.data.batch.*;
import com.google.gdata.data.spreadsheet.*;
import com.google.gdata.util.*;


public class SpreadSheetUtil implements Constants
{
	static final Logger logger					= LoggerFactory.getLogger(com.dmt.utility.SpreadSheetUtil.class);
	
	public static SpreadsheetEntry getSpreadSheet()
	{
		SpreadsheetEntry spreadsheet = null;
		try
		{
			SpreadsheetService service = new SpreadsheetService("MySpreadsheetIntegration-v1");
			
			service.setUserCredentials(CryptoUtil.decrypt(USERNAME),CryptoUtil.decrypt(PASSWORD));
			
			URL SPREADSHEET_FEED_URL = new URL("https://spreadsheets.google.com/feeds/spreadsheets/private/full");
	
			SpreadsheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL, SpreadsheetFeed.class);
			List<SpreadsheetEntry> spreadsheets  = feed.getEntries();

		    for(SpreadsheetEntry tempSpreadsheet : spreadsheets )
		    {
		    	if(tempSpreadsheet.getKey().equalsIgnoreCase("1Ppj15THpiwZSiiKGYa2qStdE5oNAH2vCxyXtK7WqSPY"))
		    	{
		    		spreadsheet = tempSpreadsheet;
		    		break;
		    	}	
		    }
		}
		catch(AuthenticationException ae)
		{
			ae.printStackTrace();
		}
		catch(MalformedURLException mue)
		{
			mue.printStackTrace();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch(ServiceException se)
		{
			se.printStackTrace();
		} 
	    
	    return spreadsheet;
	}
	
	public static WorksheetEntry selectWorkSheet(SpreadsheetEntry spreadsheet, String sheetName) throws IOException, ServiceException
	{
		SpreadsheetService service = (SpreadsheetService) spreadsheet.getService();
		WorksheetFeed worksheetFeed;
		WorksheetEntry worksheet = null;
		
		worksheetFeed = service.getFeed(spreadsheet.getWorksheetFeedUrl(), WorksheetFeed.class);
		List<WorksheetEntry> worksheets = worksheetFeed.getEntries();
		
		for(WorksheetEntry tempWorksheet:worksheets)
		{
			if(tempWorksheet.getTitle().getPlainText().equalsIgnoreCase(sheetName))
			{
				worksheet = tempWorksheet;
			}	
		}
		return worksheet;
	}
}
