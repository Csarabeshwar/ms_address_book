package com.reece.address.book.blackbox;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.reece.address.book.Application;

import io.restassured.RestAssured;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest(classes = { Application.class })
@Configuration
@Sql(scripts = { "/db/test_data/data_setup.sql" }, executionPhase = BEFORE_TEST_METHOD)
@Sql(scripts = { "/db/test_data/data_cleanup.sql" }, executionPhase = AFTER_TEST_METHOD)
public class AddressBookApiTest {

	
	public static final String X_CORRELATION_ID = "X_CORRELATION_ID";

	@BeforeAll
	static void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.basePath = "/ms_address_book";
		RestAssured.port = 8090;
	}
	
	
	@Test
	void getAddressBook_returnAllContactsFromDB() {
		given().log().all().header(X_CORRELATION_ID, "Test_OK_1234").when().get("v1/address/contacts").then().log()
		.all().statusCode(HttpStatus.OK.value()).body(containsString("Sydney"));
	}
	
	
}
