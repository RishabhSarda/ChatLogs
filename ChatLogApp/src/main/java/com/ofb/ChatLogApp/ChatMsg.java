package com.ofb.ChatLogApp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ChatMsg {

	private @Id @GeneratedValue int msgId;
	private String msg;
	private Long timestamp;
	private String userName;
	private Integer isSent;

	public ChatMsg(String msg, Long timestamp, String user, Integer isSent) {
		this.msg = msg;
		this.timestamp = timestamp;
		this.userName = user;
		this.isSent = isSent;
	}

	public ChatMsg() {
		
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getUser() {
		return userName;
	}

	public void setUser(String user) {
		this.userName = user;
	}

	public int getId() {
		return msgId;
	}	

	public Integer getIsSent() {
		return isSent;
	}

	@Override
	public String toString() {
		return "ChatMsg [msg=" + msg + ", timestamp=" + timestamp + ", userName=" + userName + ", isSent=" + isSent
				+ "]";
	}
	
}
