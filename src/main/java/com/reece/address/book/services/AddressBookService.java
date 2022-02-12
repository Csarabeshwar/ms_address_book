package com.reece.address.book.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.reece.address.book.model.AddressBookResponse;
import com.reece.address.book.model.ContactsDto;
import com.reece.address.book.model.Title;
import com.reece.address.book.repository.IContactRepository;
import com.reece.address.book.repository.entity.Contact;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressBookService {


	private final IContactRepository contactRepository;

	public AddressBookResponse getContactFromAddressBook(HttpHeaders httpHeaders) {
		
		List<Contact> allLocationContactDetails = contactRepository.findAll();
		
		return databaseResponseMapperBasedOnLocation(allLocationContactDetails);

	}

	private AddressBookResponse databaseResponseMapperBasedOnLocation(List<Contact> contactsEntity) {

		List<ContactsDto> contactResponse = contactsEntity.stream().map(dto -> {

			return ContactsDto.builder().firstName(dto.getFirstName()).lastName(dto.getLastName())
					.title(Title.valueOf(dto.getTitle())).mobile(dto.getMobile()).homePhone(dto.getHomePhone())
					.postCode(dto.getPostCode()).city(dto.getCity()).build();

		}).collect(Collectors.toList());

		return AddressBookResponse.builder().contacts(contactResponse).build();

	}

}
