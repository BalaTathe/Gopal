package com.demo.controller.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
//@SuppressWarnings("serial")
public class CustomUserDetail extends User implements UserDetails {
	public CustomUserDetail(User user) {
		super(user);
		
	}



	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}
	// TODO Auto-generated method stub
//	List<GrantedAuthority> authorityList=new ArrayList<>();
//	
//   	super.getRoles().forEach(role ->{
//   		authorityList.add(new SimpleGrantedAuthority(role.getName()));
//   	});
//		return authorityList;




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorityList=new ArrayList<>();
	
   	super.getRoles().forEach(role ->{
  		authorityList.add(new SimpleGrantedAuthority(role.getName()));
	   	});
   	return authorityList;
		// TODO Auto-generated method stub
	}




	@Override
	public String getUsername() {
		return super.getEmail();
		// TODO Auto-generated method stub
	}




	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}




	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}




	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}




	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	

}
