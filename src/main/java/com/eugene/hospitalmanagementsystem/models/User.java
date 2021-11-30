package com.eugene.hospitalmanagementsystem.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="users")
public class User {
private String name;

private String contact;
private String role;
@Id
private String usernumber;
private String email;
private String password;
public User() {
	


}

public User(String name, String contact, String role, String usernumber, String email, String password) {
	
	this.name = name;
	this.contact = contact;
	this.role = role;
	this.usernumber = usernumber;
	this.email = email;
	this.password=password;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getUsernumber() {
	return usernumber;
}
public void setUsernumber(String usernumber) {
	this.usernumber = usernumber;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "User [name=" + name + ", contact=" + contact + ", role=" + role + ", usernumber=" + usernumber + ", email="
			+ email + ", password=" + password + "]";
}



}

