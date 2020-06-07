package com.udemy.springboot.webservices.restfulwebservices.exception;

import java.util.Date;
/*
 this sort of seprate exception class is required to generalize the format
 exception same throughout the organisation.s
 */
public class ExceptionResponse {
 
	private Date currTimeStampDate;
	
	private String message;
	
	private String detailS;

	public ExceptionResponse(Date currTimeStampDate, String message, String detailS) {
		super();
		this.currTimeStampDate = currTimeStampDate;
		this.message = message;
		this.detailS = detailS;
	}

	public Date getCurrTimeStampDate() {
		return currTimeStampDate;
	}

	public void setCurrTimeStampDate(Date currTimeStampDate) {
		this.currTimeStampDate = currTimeStampDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetailS() {
		return detailS;
	}

	public void setDetailS(String detailS) {
		this.detailS = detailS;
	}
	
	
}
