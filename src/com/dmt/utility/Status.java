package com.dmt.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.annotations.Expose;

public class Status 
{
	private static final long serialVersionUID	= 1L;
	static final Logger logger= LoggerFactory.getLogger(com.dmt.utility.Status.class);
	
	@Expose
	private boolean success	=	false;
	@Expose
	private String error	=	"";
	
	// getters and setters
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
}
