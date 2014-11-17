package com.dmt.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.annotations.Expose;

public class Data 
{
	static final Logger logger 					= LoggerFactory.getLogger(com.dmt.utility.Data.class);
	@Expose
	private String text = "";
	
	//getters and setters
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
		logger.debug("setting text = {}", this.text);
	}
}
