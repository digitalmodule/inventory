package com.dmt.inventory.actions;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmt.common.actions.DefaultAction;
import com.dmt.inventory.dao.InventoryDAO;
import com.dmt.utility.GoogleMailSender;
import com.dmt.utility.Status;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;

public class EmailAction extends DefaultAction
{	
	private static final long serialVersionUID	= 1L;
	static final Logger logger					= LoggerFactory.getLogger(com.dmt.inventory.actions.EmailAction.class);
	
	private String emailFrom = "";
	private String emailTo = "";
	private String emailSubject = "";
	private String emailMessage = "";
	private Object jsonModel;
	
	
	public String sendTicketEmail()
	{
		logger.info("executing sendTicketEmail action...");
		Status status = new Status();
		boolean sentFlag = GoogleMailSender.sendEmail(emailFrom, emailTo, emailSubject, emailMessage);
		if(sentFlag)
		{
			status.setSuccess(true);
		}	
		else
		{
			status.setError("There are some problems sending an email, Please try later.");
		}
		setJsonModel(status);
		return SUCCESS;
	}


	//getters and setters
	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
		logger.debug("setting emailFrom = {}", this.emailFrom);
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
		logger.debug("setting emailTo = {}", this.emailTo);
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
		logger.debug("setting emailSubject = {}", this.emailSubject);
	}

	public String getEmailMessage() {
		return emailMessage;
	}

	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
		logger.debug("setting emailMessage = {}", this.emailMessage);
	}


	public Object getJsonModel() {
		return jsonModel;
	}


	public void setJsonModel(Object jsonModel) {
		this.jsonModel = jsonModel;
		logger.debug("setting jsonModel = {}", this.jsonModel);
	}
}
