package com.dmt.common.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class DefaultAction extends ActionSupport implements SessionAware, ServletRequestAware, Preparable
{	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger( com.dmt.common.actions.DefaultAction.class);
	private Map<String, Object> session;
	private HttpServletRequest request;
	
	
	public void prepare() throws Exception
	{
		logger.trace(" prepare() is called.");
		clearErrors();
	}
	


	public void setSession(Map<String, Object> session)
	{
		this.session = session;
		logger.trace(" setting session object on class {}",this);
		
	}
	

	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;
		logger.trace(" setting request object on class {}",this);
	}
	
	// getters and setters
	public Map<String, Object> getSession()
	{
		return session;
	}

	public HttpServletRequest getRequest()
	{
		return request;
	}
}
