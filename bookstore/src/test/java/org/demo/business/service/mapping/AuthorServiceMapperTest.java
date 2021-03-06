/*
 * Created on 10 Jan 2017 ( Time 18:00:07 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.Author;
import org.demo.bean.jpa.AuthorEntity;
import org.demo.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class AuthorServiceMapperTest {

	private AuthorServiceMapper authorServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		authorServiceMapper = new AuthorServiceMapper();
		authorServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'AuthorEntity' to 'Author'
	 * @param authorEntity
	 */
	@Test
	public void testMapAuthorEntityToAuthor() {
		// Given
		AuthorEntity authorEntity = new AuthorEntity();
		authorEntity.setFirstName(mockValues.nextString(40));
		authorEntity.setLastName(mockValues.nextString(40));
		
		// When
		Author author = authorServiceMapper.mapAuthorEntityToAuthor(authorEntity);
		
		// Then
		assertEquals(authorEntity.getFirstName(), author.getFirstName());
		assertEquals(authorEntity.getLastName(), author.getLastName());
	}
	
	/**
	 * Test : Mapping from 'Author' to 'AuthorEntity'
	 */
	@Test
	public void testMapAuthorToAuthorEntity() {
		// Given
		Author author = new Author();
		author.setFirstName(mockValues.nextString(40));
		author.setLastName(mockValues.nextString(40));

		AuthorEntity authorEntity = new AuthorEntity();
		
		// When
		authorServiceMapper.mapAuthorToAuthorEntity(author, authorEntity);
		
		// Then
		assertEquals(author.getFirstName(), authorEntity.getFirstName());
		assertEquals(author.getLastName(), authorEntity.getLastName());
	}

}