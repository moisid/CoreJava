/*
 * Created on 10 Jan 2017 ( Time 18:00:08 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service;

import java.util.List;

import org.demo.bean.Customer;

/**
 * Business Service Interface for entity Customer.
 */
public interface CustomerService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param code
	 * @return entity
	 */
	Customer findById( String code  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Customer> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Customer save(Customer entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Customer update(Customer entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Customer create(Customer entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param code
	 */
	void delete( String code );


}
