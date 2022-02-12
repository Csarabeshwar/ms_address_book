# Address Book API

## Microservice to retrieve contact information from Address Book

### API Background

The sample application being requested by the candidate to build the backend REST APIs
needed to support a web application to that allows a user to view contacts from AddressBook API.

Required functionality:
* User should be able to print all contacts in an address book.

---

## Solution Brief

The solution is implemented using SpringBoot with Gradle. Solution consists of:

* Retrieve All contacts

In addition to above, the code has below features:

* DB can be started using `gradlew composeUp`
* Integrated DB Migration using Flyway
* Code has tests in 3 categories:
  * unit test for logic tests 
  * component test for Data Repos
  * integration test to validate end to end API calls using RestAssured
* Enabled actuator for health check

## Important Gradle Tasks

| Gradle Tasks | Description | Pre-requisite |
| ------------ | ----------- | ------------- |
| `gradlew composeUp` | Starts postgres container | |
| `gradlew bootRun`| Starts Application|


## Steps to get the code running

* Checkout the code from Github repository
* Go to the terminal under `/ms_address_book`
* Execute `gradlew composeUp` to start Postgres DB
* To load sample data:
  * Go to `/ms_address_book/src/test/resources/db/test_data` and execute the `data_setup.sql` script. This will
    load sample data into DB
* Execute `gradlew bootRun`

### Interface Specification

Swagger File having all the API Specification is defined in (/src/main/java/com/reece/address/book/api)

### Application Base URL

Base URL is exposed at 8090: **[Base URL](http://localhost:8090/ms_address_book)**

### Endpoints Exposed

| Request Type | Endpoint | Description |
  | ------------ | -------- | ----------- |
| GET | `/actuator/health` | Gets the status of the service |
| GET | `/v1/address/contacts` | Returns all contacts from AddressBook |

### Assumptions

* This is an Internal facing API presumably implemented through an API or Kong Gateway
* I assumed AddressBook table to present already and are populated with data.
* Assumed that other application-sit, prod files are not required to be updated

### Enhancements

* Pagination needs to be implemented to protect the API from timing out as well as for consistent performance
* Header validation needs to be added
* Database normalization. Introduce more normalized entity relationship
* More exception handling scenarios