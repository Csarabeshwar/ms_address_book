package com.reece.address.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reece.address.book.repository.entity.Contact;

public interface IContactRepository extends JpaRepository<Contact, String>{

}
