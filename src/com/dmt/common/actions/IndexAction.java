package com.dmt.common.actions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmt.utility.CryptoUtil;
import com.dmt.utility.Status;

public class IndexAction extends DefaultAction
{	
	private static final long serialVersionUID	= 1L;
	static final Logger logger					= LoggerFactory.getLogger(com.dmt.common.actions.IndexAction.class);
	private String textToBeEncrypted = "";
	private Object jsonModel;
	
	
	public String launchIndex()
	{
		logger.info("executing launchIndex action...");
		return SUCCESS;
	}
	
	public String encryptText()
	{
		Status status = new Status();
		String encryptedText = CryptoUtil.encrypt(textToBeEncrypted);
		status.setSuccess(true);
		status.setError(encryptedText);
		setJsonModel(status);
		return SUCCESS;
		
	}
	
	//text to be encrypted
	public String getTextToBeEncrypted() {
		return textToBeEncrypted;
	}

	public void setTextToBeEncrypted(String textToBeEncrypted) {
		this.textToBeEncrypted = textToBeEncrypted;
		logger.debug("setting textToBeEncrypted = {}", this.textToBeEncrypted);
	}

	public Object getJsonModel() {
		return jsonModel;
	}

	public void setJsonModel(Object jsonModel) {
		this.jsonModel = jsonModel;
		logger.debug("setting jsonModel = {}", this.jsonModel);
	}


}
