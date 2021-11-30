package com.eugene.hospitalmanagementsystem.models;

import java.util.List;

public class addLabForm {
	private List <Labtests> labtests;
	private Labform labform;
	
	private String testid;
	private String formid;
	
	
	
	
	
	public addLabForm() {
		
	}
	public addLabForm(List<Labtests> labtests, Labform labform) {
		
		this.labtests = labtests;
		this.labform = labform;
	}
	public List<Labtests> getLabtests() {
		return labtests;
	}
	public void setLabtests(List<Labtests> labtests) {
		this.labtests = labtests;
	}
	public Labform getLabform() {
		return labform;
	}
	public void setLabform(Labform labform) {
		this.labform = labform;
	}
	public String getTestid() {
		return testid;
	}
	public void setTestid(String testid) {
		this.testid = testid;
	}
	public String getFormid() {
		return formid;
	}
	public void setFormid(String formid) {
		this.formid = formid;
	}
	
	
	

}
