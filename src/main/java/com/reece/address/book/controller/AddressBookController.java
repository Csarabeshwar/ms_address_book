package com.reece.address.book.controller;

import java.util.concurrent.Callable;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.reece.address.book.model.AddressBookResponse;
import com.reece.address.book.services.AddressBookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AddressBookController {

	private final AddressBookService addressBookService;

	@GetMapping(value = "v1/address/contacts")
	public Callable<ResponseEntity<AddressBookResponse>> getContactFromAddressBook(final @RequestHeader HttpHeaders httpHeaders) {

		return () -> new ResponseEntity<>(addressBookService.getContactFromAddressBook(httpHeaders),
				HttpStatus.OK);
	}

}

