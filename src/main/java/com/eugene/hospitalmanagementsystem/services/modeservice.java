package com.eugene.hospitalmanagementsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.hospitalmanagementsystem.models.Mode;
@Service
public class modeservice {
	@Autowired
	com.eugene.hospitalmanagementsystem.daos.modedao modedao;
	public void addMode(Mode mode) {
		modedao.save(mode);
	
}
	public List<Mode> getAllModes(){
		return (List<Mode>)modedao.findAll();
	}
	public Mode getMode(String modeid) {
		return modedao.getBymodeid(modeid);
	}
}
