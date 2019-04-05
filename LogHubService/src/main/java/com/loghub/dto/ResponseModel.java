package com.loghub.dto;

import com.fasterxml.jackson.databind.JsonNode;

public class ResponseModel {

	private boolean status;
	private String message;
	private JsonNode object;

	public ResponseModel() {
	}

	public ResponseModel(boolean status, String message, JsonNode object) {
		this.status = status;
		this.message = message;
		this.object = object;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public JsonNode getObject() {
		return object;
	}

	public void setObject(JsonNode object) {
		this.object = object;
	}

}
