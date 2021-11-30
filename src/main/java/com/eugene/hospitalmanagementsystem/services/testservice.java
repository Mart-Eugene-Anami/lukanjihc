package com.eugene.hospitalmanagementsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.hospitalmanagementsystem.models.Labtests;
@Service
public class testservice {
	@Autowired
	com.eugene.hospitalmanagementsystem.daos.labtestsdao labtestsdao;
    public List<Labtests> getAllTests(){
	return (List<Labtests>) labtestsdao.findAll();
    }
    public Labtests getBytestid(String testid) {
		return labtestsdao.getBytestid(testid);
	}
    public void addTest(Labtests labtest) {
    	labtestsdao.save(labtest);
    }
}
