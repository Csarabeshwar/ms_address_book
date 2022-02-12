package com.reece.address.book.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ContactsDto {

	private Title title;

	private String firstName;

	private String lastName;

	private String mobile;

	private String homePhone;

	private String postCode;
	
	private String city;
}
