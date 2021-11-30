package com.eugene.hospitalmanagementsystem.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eugene.hospitalmanagementsystem.models.Drug;
import com.eugene.hospitalmanagementsystem.models.Patient;
import com.eugene.hospitalmanagementsystem.models.Pharmform;
@Repository
public interface pharmdao extends CrudRepository<Pharmform, String> {
	
}
