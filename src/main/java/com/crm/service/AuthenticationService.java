package com.crm.service;

import com.crm.dto.request.SignUpRequest;
import com.crm.dto.request.SigninRequest;
import com.crm.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
	JwtAuthenticationResponse signup(SignUpRequest request);

	JwtAuthenticationResponse signin(SigninRequest request);
}
