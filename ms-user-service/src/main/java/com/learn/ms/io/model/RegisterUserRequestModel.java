package com.learn.ms.io.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequestModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9060466914437626456L;

	@NotNull(message = "First name cannot be null")
	@Size(min=2, message = "First name should be atleast 2 characters")
	private String firstName;
	
	@NotNull(message = "Last name cannot be null")
	@Size(min=1, message = "Last name should be atleast 1 character")
	private String lastName;
	
	@NotNull(message = "Email cannot be null")
	@Email
	private String email;
	
	@NotNull(message = "Password cannot be null")
	@Size(min=4, message = "Password should be atleast 4 characters")
	private String password;
	
}
