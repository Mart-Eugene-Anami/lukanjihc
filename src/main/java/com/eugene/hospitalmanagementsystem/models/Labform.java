package com.eugene.hospitalmanagementsystem.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="lab")
public class Labform {
	@Id
	private String formid;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	 @JoinTable(name="lab_labtests", joinColumns={@JoinColumn(name="formid")}, inverseJoinColumns= {@JoinColumn(name="testid")})
	private List<Labtests> labtestslist=new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name="usernumber")
	private User labofficer;
	
	@OneToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="diagnosisnumber")
	private Diagnosis diagnosis;
	
	@Transient
	private String diagnosisnumber;
	
	
	
	public Labform() {
		
	}
	public Labform(String formid, User labofficer) {
        this.formid=formid;
		this.labofficer = labofficer;
	}
	public void additem(Labtests labtests) {labtestslist.add(labtests);}
	
	public User getLabofficer() {
		return labofficer;
	}
	public void setLabofficer(User labofficer) {
		this.labofficer = labofficer;
	}
	public Diagnosis getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getFormid() {
		return formid;
	}
	public void setFormid(String formid) {
		this.formid = formid;
	}
	
	public List<Labtests> getLabtestslist() {
		return labtestslist;
	}
	public void setLabtestslist(List<Labtests> labtestslist) {
		this.labtestslist = labtestslist;
	}
	public String getDiagnosisnumber() {
		return diagnosisnumber;
	}
	public void setDiagnosisnumber(String diagnosisnumber) {
		this.diagnosisnumber = diagnosisnumber;
	}
		

}
