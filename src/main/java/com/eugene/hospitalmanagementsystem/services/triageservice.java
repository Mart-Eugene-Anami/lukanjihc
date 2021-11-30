package com.eugene.hospitalmanagementsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eugene.hospitalmanagementsystem.models.triage;
@Service
public class triageservice {
	@Autowired
	com.eugene.hospitalmanagementsystem.daos.triagedao triagedao;
	public void addTriage(triage triage) {
		triagedao.save(triage);}
		public triage getBytriagenumber(String triagenumber) {
			return triagedao.getBytriagenumber(triagenumber);
			
		}
	     public List<triage> getAllTriageRecords(){
	    	 return triagedao.getAlltriagerecords();
	     }

}
