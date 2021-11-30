package com.eugene.hospitalmanagementsystem.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.eugene.hospitalmanagementsystem.models.triage;

public interface triagedao extends CrudRepository<triage, String> {
	public triage getBytriagenumber(String triagenumber);
	
	@Query(value="SELECT * FROM triage order by ctid desc LIMIT 5", nativeQuery=true)
	public List<triage> getAlltriagerecords();
}
