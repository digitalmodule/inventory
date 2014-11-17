package com.dmt.utility;

import java.util.ArrayList;
import java.util.Arrays;

public interface Constants
{
	String USERNAME	= "8sQOe92aU4STOC7uvasdfasfJxfaHZIUEDYP0xeHgg+GDT4BdY=";
	String PASSWORD = "Bc7oFOWKRgo5pasdfasd6clNJlABQ==";

	
	ArrayList<String> SAVE_COLUMN_IGNORE_LIST =  new ArrayList<String>(Arrays.asList(new String[]{
																					Utils.getPlainString("Show On Class Inv"),
																					Utils.getPlainString("Building"),
																					Utils.getPlainString("Room"),
																					Utils.getPlainString("Link To Bldg Map"),
																					Utils.getPlainString("Link To Room Map"),
																					Utils.getPlainString("Link To Room Photo"),
																					Utils.getPlainString("Link To Room Diagram"),
																					Utils.getPlainString("Link To Create Ticket"),
																					Utils.getPlainString("Link To Room Schedule"),
																					Utils.getPlainString("Link To Room Details"),
																					Utils.getPlainString("Link To Room Tickets")
																					}));
	ArrayList<String> SAVE_PROJECTOR_COLUMN_IGNORE_LIST =  new ArrayList<String>(Arrays.asList(new String[]{
																					Utils.getPlainString("Room Id"),
																					Utils.getPlainString("Room"),
																					Utils.getPlainString("Projector Model"),
																					Utils.getPlainString("Projector Serial"),
																					Utils.getPlainString("Projector Current Age Years"),
																					Utils.getPlainString("Bulb Replace Date"),
																					Utils.getPlainString("Filter Replace Date")
																					}));
	ArrayList<String> SAVE_COMPUTER_COLUMN_IGNORE_LIST =  new ArrayList<String>(Arrays.asList(new String[]{
																					Utils.getPlainString("Room Id"),
																					Utils.getPlainString("Room"),
																					Utils.getPlainString("ComputerModel"),
																					Utils.getPlainString("LinkToMaker"),
																					Utils.getPlainString("LinkToSoftwarePage"),
																					Utils.getPlainString("ComputerManuDate"),
																					Utils.getPlainString("ComputerCurrentAgeYears")
																					}));
}
