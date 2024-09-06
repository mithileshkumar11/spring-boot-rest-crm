package com.crm.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crm.constants.Constants;
import com.crm.dto.request.SignUpRequest;
import com.crm.dto.request.SigninRequest;
import com.crm.dto.response.JwtAuthenticationResponse;
import com.crm.model.Role;
import com.crm.model.User;
import com.crm.repository.RoleRepository;
import com.crm.repository.UserRepository;
import com.crm.service.AuthenticationService;
import com.crm.service.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
       
    	var user = User.builder()
    			.firstName(request.getFirstName())
    			.lastName(request.getLastName())
                .email(request.getEmail())
                .mobile(request.getMobile())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(getRole(request.getRoles())).build();
        		userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    
    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
    
    private Set<Role> getRole(List<String> roleList){
        if (roleList == null) {
        	roleList=new ArrayList<>();
        	roleList.add(Constants.ROLE_USERS);
        	return roleRepository.getRole(roleList).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        
        } else 
        	return roleRepository.getRole(roleList).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    }
}
