package com.bibek.repository;

import org.springframework.data.repository.CrudRepository;

import com.bibek.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}
