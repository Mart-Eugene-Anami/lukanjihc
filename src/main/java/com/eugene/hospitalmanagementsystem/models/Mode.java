package com.eugene.hospitalmanagementsystem.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component 
@Entity
@Table(name="modes")
public class Mode {

private String modename;
@Id
@Column(name="modeid")
private String modeid;

public Mode() {}


public Mode(String modename, String modeid) {
	
	this.modename = modename;
	this.modeid = modeid;
}


public String getModename() {
	return modename;
}

public void setModename(String modename) {
	this.modename = modename;
}


public String getModeid() {
	return modeid;
}


public void setModeid(String modeid) {
	this.modeid = modeid;
}


}
