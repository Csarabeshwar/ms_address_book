package com.reece.address.book.component.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.reece.address.book.component.ComponentTest;
import com.reece.address.book.repository.IContactRepository;
import com.reece.address.book.repository.entity.Contact;

@ComponentTest
@Sql(scripts = { "/db/test_data/data_setup.sql" }, executionPhase = BEFORE_TEST_METHOD)
@Sql(scripts = { "/db/test_data/data_cleanup.sql" }, executionPhase = AFTER_TEST_METHOD)
public class ContactRepositoryTest {
	
	@Autowired
	private IContactRepository iContactRepository;

	@Test
	void findByAllContacts_thenReturnListFromDB() {
		List<Contact> contact = iContactRepository.findAll();
		assertThat(contact.size(), is(3));
	}

}
