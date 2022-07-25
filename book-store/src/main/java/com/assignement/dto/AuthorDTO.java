package com.assignement.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AuthorDTO {
	private Integer authorId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	private Integer addressId;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipcode;
	
	

}
