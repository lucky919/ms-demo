package com.learn.ms.service;

import java.util.Collections;
import java.util.UUID;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.ms.domain.UserEntity;
import com.learn.ms.dto.UserDTO;
import com.learn.ms.repository.UsersRepository;

@Service
public class UsersServiceImpl implements IUserService {
	
	@Autowired
	private UsersRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@Transactional
	@Override
	public UserDTO registerUser(UserDTO userDetails) {
		userDetails.setUserId(UUID.randomUUID().toString());
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity user = modelMapper.map(userDetails, UserEntity.class);
		user.setEncryptedPassword(bcryptPasswordEncoder.encode(userDetails.getPassword()));
		
		userRepo.save(user);
		
		UserDTO response = modelMapper.map(user, UserDTO.class);
		return response;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepo.findByEmail(username);
		if (user == null) 
			throw new UsernameNotFoundException(username);
		
		return new User(user.getEmail(), user.getEncryptedPassword(), true, true, true, true, Collections.emptyList());
	}
	
	@Override
	public UserDTO getUserByEmail(String email) {
		UserEntity user = userRepo.findByEmail(email);
		if (user == null) 
			throw new UsernameNotFoundException(email);
		
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserDTO userDTO = mapper.map(user, UserDTO.class);
		
		return userDTO;
	}
	
}
