package com.eugene.hospitalmanagementsystem.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eugene.hospitalmanagementsystem.models.Patient;

@Repository
public interface patientdao extends CrudRepository<Patient, Integer> {
public Patient getBypatientnumber(String patientnumber);
public Patient getBypatientname(String patientname);
@Query(value="SELECT * FROM patients order by ctid desc LIMIT 5", nativeQuery=true)
public List<Patient> getAllPatientRecords();

}
