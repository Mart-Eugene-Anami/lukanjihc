package com.eugene.hospitalmanagementsystem.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eugene.hospitalmanagementsystem.models.Drug;
import com.eugene.hospitalmanagementsystem.models.Patient;
@Repository
public interface drugdao extends CrudRepository <Drug, String> {
	public Drug findBydrugidentity(String drugidentity);
	public Drug findBydrugname(String drugname);
	@Query(value="SELECT * FROM drugs where quantity <30", nativeQuery=true)
	public List<Drug> getAllDepletedDrugs();
}
