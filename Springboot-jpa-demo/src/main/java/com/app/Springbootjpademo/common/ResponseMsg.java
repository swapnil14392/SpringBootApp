package com.app.Springbootjpademo.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ResponseMsg {
private String msg;
private ResponseMsgType msgType;

public ResponseMsg(String msg, ResponseMsgType msgType) {
	super();
	this.msg = msg;
	this.msgType = msgType;
}

}
