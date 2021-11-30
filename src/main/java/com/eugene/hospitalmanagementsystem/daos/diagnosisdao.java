package com.eugene.hospitalmanagementsystem.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eugene.hospitalmanagementsystem.models.Diagnosis;

@Repository
public interface diagnosisdao extends CrudRepository<Diagnosis, String> {

public Diagnosis getBydiagnosisnumber(String diagnosisnumber);
@Query(value="SELECT * FROM diagnosis order by ctid desc LIMIT 5", nativeQuery=true)
public List<Diagnosis>getAllDiagnosisRecords();
}
