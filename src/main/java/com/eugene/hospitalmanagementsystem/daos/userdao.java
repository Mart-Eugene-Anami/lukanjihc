package com.eugene.hospitalmanagementsystem.daos;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eugene.hospitalmanagementsystem.models.User;
@Repository
public interface userdao extends CrudRepository<User, Integer> {
public User getByusernumber(String usernumber);
@Query(value="SELECT * FROM users",nativeQuery=true)
List<User>getAllUserRecords();
@Query(value="SELECT * FROM users u where u.name= :name", nativeQuery=true)
User findByName(String name);
public User getByname(String name);
}
