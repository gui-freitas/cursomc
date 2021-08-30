package com.gapp.cursomc.resources.exception;

import java.time.Instant;

public class StandardError {
	
	private Integer status;
	private String msg;
	private Instant timestamp;
	
	public StandardError(Integer status, String msg, Instant timestamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
}