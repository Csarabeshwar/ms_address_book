package com.reece.address.book.repository.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Table(name = "address_book")
public class Contact {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;
	
    @Column(name ="title")
	private String title;
	
    @Column(name ="first_name")
	private String firstName;
	
    @Column(name ="last_name")
	private String lastName;
	
    @Column(name ="mobile")
	private String mobile;
	
    @Column(name ="home_phone")
	private String homePhone;
    
    @Column(name ="post_code")
    private String postCode;
    
    @Column(name ="city")
    private String city;

}
