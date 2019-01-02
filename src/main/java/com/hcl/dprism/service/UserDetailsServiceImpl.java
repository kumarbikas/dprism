package com.hcl.dprism.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hcl.dprism.dao.AppRoleDAO;
import com.hcl.dprism.dao.AppUserDAO;
import com.hcl.dprism.domain.AppUser;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private AppUserDAO appUserDAO;
 
    @Autowired
    private AppRoleDAO appRoleDAO;
    
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		 AppUser appUser = this.appUserDAO.findUserAccount(userName);
		 
	        if (appUser == null) {
	            System.out.println("User not found! " + userName);
	            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
	        }
	 
	        System.out.println("Found User: " + appUser);
	 
	        // [ROLE_USER, ROLE_ADMIN,..]
	        List<String> roleNames = this.appRoleDAO.getRoleNames(appUser.getUserId());
	 
	        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
	        if (roleNames != null) {
	            for (String role : roleNames) {
	                // ROLE_USER, ROLE_ADMIN,..
	                GrantedAuthority authority = new SimpleGrantedAuthority(role);
	                grantList.add(authority);
	            }
	        }
	 
	        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), //
	                appUser.getPassword(), grantList);
	 
	        return userDetails;
	    }
}


