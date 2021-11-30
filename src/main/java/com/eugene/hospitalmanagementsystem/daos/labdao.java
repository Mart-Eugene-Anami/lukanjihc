package com.eugene.hospitalmanagementsystem.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eugene.hospitalmanagementsystem.models.Diagnosis;
import com.eugene.hospitalmanagementsystem.models.Labform;
import com.eugene.hospitalmanagementsystem.models.Patient;
@Repository
public interface labdao extends CrudRepository<Labform, String> {
	public Labform getByformid(String formid);
	
	@Query(value="SELECT * FROM lab order by ctid desc LIMIT 5", nativeQuery=true)
	public List<Labform>getAllLabRecords();
}
