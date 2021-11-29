package com.formacionjava.springboot.apirest.service;

import java.util.List;

import com.formacionjava.springboot.apirest.entity.Cliente;



public interface Service {
	public List<Cliente> findAll();
	public Cliente findById(Long id);
	public Cliente save(Cliente cliente);
	public void delete(Long id);
}
