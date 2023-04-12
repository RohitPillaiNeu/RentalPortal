package com.example.pojo;

public class Enquiry {
	private int postID;
	
	private String name;
	private String number;
	private String email;
	private String additionalQuestions;
	
	public Enquiry() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdditionalQuestions() {
		return additionalQuestions;
	}
	public void setAdditionalQuestions(String additionalQuestions) {
		this.additionalQuestions = additionalQuestions;
	}
	
}
