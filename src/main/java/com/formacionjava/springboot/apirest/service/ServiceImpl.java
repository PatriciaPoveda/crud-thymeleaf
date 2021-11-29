package com.formacionjava.springboot.apirest.service;

import java.lang.annotation.Annotation;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.formacionjava.springboot.apirest.entity.Cliente;
import com.formacionjava.springboot.apirest.servicedao.ServiceDao;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	@Autowired
	private ServiceDao serviceDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) serviceDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return serviceDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return serviceDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		serviceDao.deleteById(id);;
		
	}

}
