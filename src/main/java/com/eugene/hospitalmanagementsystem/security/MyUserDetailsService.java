package com.eugene.hospitalmanagementsystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eugene.hospitalmanagementsystem.models.User;
@Service
public class MyUserDetailsService implements UserDetailsService {
@Autowired
com.eugene.hospitalmanagementsystem.daos.userdao userdao;
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		User user=userdao.findByName(s);
		if(user==null) {throw new UsernameNotFoundException("User With That Name Does Not Exist");}
		return new MyUserDetails(user);
	}

}
