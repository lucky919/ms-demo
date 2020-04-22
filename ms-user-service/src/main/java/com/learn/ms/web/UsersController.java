package com.learn.ms.web;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ms.dto.UserDTO;
import com.learn.ms.io.model.RegisterUserRequestModel;
import com.learn.ms.io.model.RegisterUserResponseModel;
import com.learn.ms.service.IUserService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private Environment env;
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/status/check")
	public String status() {
		return "Working on port " + env.getProperty("local.server.port");
	}
	
	@PostMapping
	public ResponseEntity<RegisterUserResponseModel> registerUser(@Valid @RequestBody RegisterUserRequestModel registerUserModel) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDTO userDTO = mapper.map(registerUserModel, UserDTO.class);
		UserDTO createdUser = userService.registerUser(userDTO);
		
		RegisterUserResponseModel model = mapper.map(createdUser, RegisterUserResponseModel.class);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(model);
	}
}
