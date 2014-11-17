package com.dmt.utility;

/**
 *
 * @author b.khatri
 */
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.util.ValueStack;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * The JSONResult is a custom result to serlialize an object to the JSON format. This
 * result type can be used to provide Ajax clients with JSON responses.
 *
 * This result is basically just to show two things. First, the fundamentals of making
 * a custom result. And second, how Ajax applications can be easily integrated with the
 * framework.
 *
 * This result takes a single parameter, classAlias, which will be the JSON object name
 * under which the domain model object will be serialized. As far as what gets serialized,
 * the JSON result will look for a property on the ValueStack called jsonModel. This
 * value could arrive on the ValueStack via a variety of methods.
 */
public class GsonJSONResult implements Result {

	private static final long serialVersionUID = 1L;
	static final Logger logger 					= LoggerFactory.getLogger(com.dmt.utility.GsonJSONResult.class);
	public static final String DEFAULT_PARAM 	= "classAlias";
    String classAlias;

    public String getClassAlias() {
        return classAlias;
    }

    public void setClassAlias(String classAlias) {
        this.classAlias = classAlias;
    }

    public void execute(ActionInvocation invocation) throws Exception {
    	logger.debug("executing JSONResult execute()");
        ServletActionContext.getResponse().setContentType("text/plain");
        PrintWriter responseStream = ServletActionContext.getResponse().getWriter();
        /* Retrieve Objects to Serialize to JSON from ValueStack */
        ValueStack valueStack = invocation.getStack();
        Object jsonModel = valueStack.findValue("jsonModel");

        //Gson gson = new Gson();
        
        final GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();
        
    	// convert java object to JSON format,
    	// and returned as JSON formatted string
    	String json = gson.toJson(jsonModel);

        /* Write to the response stream */
        logger.debug("json from model  == " + json);
        responseStream.println(json);
        //responseStream.println(xstream.toXML(jsonModel));
    }
}
