package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.core.io.InputStreamSource;


public class OutcomeFileDetailsEntity {

	private int userId;
	
	private String email;
	
	private String attachmentFilename;
	
	private InputStreamSource inputStreamSource;
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAttachmentFilename() {
		return attachmentFilename;
	}

	public void setAttachmentFilename(String attachmentFilename) {
		this.attachmentFilename = attachmentFilename;
	}

	public InputStreamSource getInputStreamSource() {
		return inputStreamSource;
	}

	public void setInputStreamSource(InputStreamSource inputStreamSource) {
		this.inputStreamSource = inputStreamSource;
	}
	
}
