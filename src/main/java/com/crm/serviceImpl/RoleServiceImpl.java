package com.crm.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.crm.constants.Constants;
import com.crm.model.Role;
import com.crm.repository.RoleRepository;
import com.crm.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	@EventListener(ContextRefreshedEvent.class)
	public void createRole() {
			
		List<Role> isExist=roleRepository.getRole();
		System.out.println("Role isExist:"+isExist.size());
		
		if(isExist.size()==0) {
			roleRepository.saveAll(getRoleList());
		}
	}
	
	private List<Role> getRoleList(){
		
		List<Role> roleList=new ArrayList<>();
		
		var role=new Role();
		role.setName(Constants.ROLE_MODERATOR);
		role.setCreatedBy(Constants.ROLE_ADMIN);
		role.setStatus(Constants.ONE);
		role.setUpdatedBy(Constants.ROLE_ADMIN);
		roleList.add(role);
		
		var role2=new Role();
		role2.setName(Constants.ROLE_USERS);
		role2.setCreatedBy(Constants.ROLE_ADMIN);
		role2.setStatus(Constants.ONE);
		role2.setUpdatedBy(Constants.ROLE_ADMIN);
		roleList.add(role2);
		
		var role3=new Role();
		role3.setName(Constants.ROLE_ADMIN);
		role3.setCreatedBy(Constants.ROLE_ADMIN);
		role3.setStatus(Constants.ONE);
		role3.setUpdatedBy(Constants.ROLE_ADMIN);
		roleList.add(role3);
		
		return roleList;
	}

}
