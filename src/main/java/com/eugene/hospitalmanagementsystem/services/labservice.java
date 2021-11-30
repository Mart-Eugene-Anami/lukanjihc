package com.eugene.hospitalmanagementsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.hospitalmanagementsystem.models.Labform;
@Service
public class labservice {
	@Autowired
	com.eugene.hospitalmanagementsystem.daos.labdao labdao;
	
	public void saveLabForm(Labform labform) {
		labdao.save(labform);
	}
	public Labform getByformid(String formid) {
		return labdao.getByformid(formid);
	}

	
	public List<Labform> getAllLabRecords(){
		return (List<Labform>) labdao.getAllLabRecords();
	}

}
