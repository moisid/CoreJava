/*
 * Created on 10 Jan 2017 ( Time 18:00:08 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.demo.bean.EmployeeGroup;
import org.demo.bean.jpa.EmployeeGroupEntity;
import org.demo.bean.jpa.EmployeeGroupEntityKey;
import org.demo.business.service.EmployeeGroupService;
import org.demo.business.service.mapping.EmployeeGroupServiceMapper;
import org.demo.data.repository.jpa.EmployeeGroupJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of EmployeeGroupService
 */
@Component
@Transactional
public class EmployeeGroupServiceImpl implements EmployeeGroupService {

	@Resource
	private EmployeeGroupJpaRepository employeeGroupJpaRepository;

	@Resource
	private EmployeeGroupServiceMapper employeeGroupServiceMapper;
	
	@Override
	public EmployeeGroup findById(String employeeCode, Short groupId) {
		EmployeeGroupEntityKey id = new EmployeeGroupEntityKey(employeeCode, groupId);
		EmployeeGroupEntity employeeGroupEntity = employeeGroupJpaRepository.findOne(id);
		return employeeGroupServiceMapper.mapEmployeeGroupEntityToEmployeeGroup(employeeGroupEntity);
	}

	@Override
	public List<EmployeeGroup> findAll() {
		Iterable<EmployeeGroupEntity> entities = employeeGroupJpaRepository.findAll();
		List<EmployeeGroup> beans = new ArrayList<EmployeeGroup>();
		for(EmployeeGroupEntity employeeGroupEntity : entities) {
			beans.add(employeeGroupServiceMapper.mapEmployeeGroupEntityToEmployeeGroup(employeeGroupEntity));
		}
		return beans;
	}

	@Override
	public EmployeeGroup save(EmployeeGroup employeeGroup) {
		return update(employeeGroup) ;
	}

	@Override
	public EmployeeGroup create(EmployeeGroup employeeGroup) {
		EmployeeGroupEntityKey id = new EmployeeGroupEntityKey(employeeGroup.getEmployeeCode(), employeeGroup.getGroupId());
		EmployeeGroupEntity employeeGroupEntity = employeeGroupJpaRepository.findOne(id);
		if( employeeGroupEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		employeeGroupEntity = new EmployeeGroupEntity();
		employeeGroupServiceMapper.mapEmployeeGroupToEmployeeGroupEntity(employeeGroup, employeeGroupEntity);
		EmployeeGroupEntity employeeGroupEntitySaved = employeeGroupJpaRepository.save(employeeGroupEntity);
		return employeeGroupServiceMapper.mapEmployeeGroupEntityToEmployeeGroup(employeeGroupEntitySaved);
	}

	@Override
	public EmployeeGroup update(EmployeeGroup employeeGroup) {
		EmployeeGroupEntityKey id = new EmployeeGroupEntityKey(employeeGroup.getEmployeeCode(), employeeGroup.getGroupId());
		EmployeeGroupEntity employeeGroupEntity = employeeGroupJpaRepository.findOne(id);
		employeeGroupServiceMapper.mapEmployeeGroupToEmployeeGroupEntity(employeeGroup, employeeGroupEntity);
		EmployeeGroupEntity employeeGroupEntitySaved = employeeGroupJpaRepository.save(employeeGroupEntity);
		return employeeGroupServiceMapper.mapEmployeeGroupEntityToEmployeeGroup(employeeGroupEntitySaved);
	}

	@Override
	public void delete(String employeeCode, Short groupId) {
		EmployeeGroupEntityKey id = new EmployeeGroupEntityKey(employeeCode, groupId);
		employeeGroupJpaRepository.delete(id);
	}

	public EmployeeGroupJpaRepository getEmployeeGroupJpaRepository() {
		return employeeGroupJpaRepository;
	}

	public void setEmployeeGroupJpaRepository(EmployeeGroupJpaRepository employeeGroupJpaRepository) {
		this.employeeGroupJpaRepository = employeeGroupJpaRepository;
	}

	public EmployeeGroupServiceMapper getEmployeeGroupServiceMapper() {
		return employeeGroupServiceMapper;
	}

	public void setEmployeeGroupServiceMapper(EmployeeGroupServiceMapper employeeGroupServiceMapper) {
		this.employeeGroupServiceMapper = employeeGroupServiceMapper;
	}

}