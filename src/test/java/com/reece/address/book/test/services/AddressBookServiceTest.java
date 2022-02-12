package com.reece.address.book.test.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;

import com.reece.address.book.model.AddressBookResponse;
import com.reece.address.book.repository.IContactRepository;
import com.reece.address.book.repository.entity.Contact;
import com.reece.address.book.services.AddressBookService;

@ExtendWith(MockitoExtension.class)
public class AddressBookServiceTest {

	@InjectMocks
	private AddressBookService addressBookService;

	@Mock
	private IContactRepository iContactRepository;

	@Test
	void getAll_contactDetails_thenReturnAllContactFromDB() {
		List<Contact> contactInfo = mockDbResponse();
		when(iContactRepository.findAll()).thenReturn(contactInfo);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("X_CORRELATION_ID", "TEST_04022022");
		AddressBookResponse addressBookResponse = addressBookService.getContactFromAddressBook(httpHeaders);
		assertThat(addressBookResponse.getContacts().size(), is(1));
		assertThat(addressBookResponse.getContacts().get(0).getCity(), is("Sydney"));

	}

	private List<Contact> mockDbResponse() {
		return Arrays.asList(Contact.builder().city("Sydney").firstName("Sarab").lastName("Chandra").mobile("0001112221").homePhone(null).title("Mr").postCode("3000").build());
	}

	
}
