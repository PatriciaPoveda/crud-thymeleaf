package com.formacionjava.springboot.apirest.servicedao;

import org.springframework.data.repository.CrudRepository;

import com.formacionjava.springboot.apirest.entity.Cliente;


public interface ServiceDao extends CrudRepository<Cliente, Long> {

}
