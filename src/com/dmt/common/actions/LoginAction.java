package com.dmt.common.actions;

import org.apache.struts2.dispatcher.SessionMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmt.common.dao.LoginDAO;
import com.dmt.common.model.User;
import com.dmt.utility.SpreadSheetUtil;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends DefaultAction
{	
	private static final long serialVersionUID	= 1L;
	static final Logger logger					= LoggerFactory.getLogger(com.dmt.common.actions.LoginAction.class);
	private LoginDAO loginDAO = new LoginDAO();
	private User user = new User();
	
	
	public String authenticate()
	{
		logger.info("executing authenticate action...");
		String result = "";
		SpreadsheetEntry spreadsheet = SpreadSheetUtil.getSpreadSheet();
		getSession().put("spreadsheet", spreadsheet);
		
		user = loginDAO.authenticate(spreadsheet, user);
		logger.debug("user no = {}",user.getNo());
		if(user.getNo()>0)
		{
			getSession().put("user", user);
			result = SUCCESS;
		}	
		else
		{
			addActionError("Invalid Login");
			result = INPUT;
		}
		
		return result;
	}
	
	public String logout()
	{
		if(getSession().get("user") != null )
		{
			getSession().remove("user");
		}	
		@SuppressWarnings("rawtypes")
		SessionMap session = (SessionMap) ActionContext.getContext().getSession();
		session.invalidate();
		return SUCCESS;
	}

	//getters and setters
	public LoginDAO getLoginDAO() {
		return loginDAO;
	}


	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
		logger.debug("setting loginDAO = {}", this.loginDAO);
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
		logger.debug("setting user = {}", this.user);
	}

}
