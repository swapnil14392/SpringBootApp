package com.app.Springbootjpademo.common;

import java.text.MessageFormat;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.app.Springbootjpademo.utility.PropertyUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Component
//@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST,proxyMode = ScopedProxyMode.TARGET_CLASS)
@JsonInclude(value = Include.NON_NULL)
public class ResponseObj {
	private HashMap<String, Object> data = new HashMap<String, Object>();
	//private String msg;
	private ResponseMsg msg;
	
	public ResponseObj() {
		super();
	}
	public HashMap<String, Object> add(String s, Object o) {
		data.put(s, o);
		return data;
	}
	public HashMap<String, Object> getData() {
		return data;
	}
	
	public void setMsg(String message,ResponseMsgType type,Object... parameters) {
		
		  if(message.startsWith("${") && message.endsWith("}"))
		  message=PropertyUtils.getProperty(message.substring(2, message.length()-1));
		 
		if(parameters!=null) {
			message=MessageFormat.format(message, parameters);
		}
		System.out.println("msg: "+message+"\t"+type);
		msg=new ResponseMsg(message, type);
	}
	
}
