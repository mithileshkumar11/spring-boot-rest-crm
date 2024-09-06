package com.crm.serviceImpl;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.crm.model.User;
import com.crm.service.CurrentLoggedInUserService;

@Service
public class CurrentLoggedInUserServiceImpl implements CurrentLoggedInUserService {
	
	@Override
	public String getCurrentUserName() {
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getUsername().trim();
	}

}
