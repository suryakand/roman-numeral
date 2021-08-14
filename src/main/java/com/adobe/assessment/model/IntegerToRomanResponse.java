package com.adobe.assessment.model;

import javax.validation.constraints.NotBlank;

/**
 * 
 * A model class that represents REST API response (JSON)
 * 
 * @author Suryakand Shinde
 *
 */
public class IntegerToRomanResponse {

	@NotBlank
	private Integer input;
	@NotBlank
	private String output;
	
	public Integer getInput() {
		return input;
	}
	public void setInput(Integer input) {
		this.input = input;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
}
