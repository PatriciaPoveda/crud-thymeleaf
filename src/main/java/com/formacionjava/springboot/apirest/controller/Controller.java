package com.formacionjava.springboot.apirest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionjava.springboot.apirest.entity.Cliente;
import com.formacionjava.springboot.apirest.service.Service;



//@RestController
@org.springframework.stereotype.Controller
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private Service service;
	
	@GetMapping("/clientes")
	public String index(Model modelo) {
		List<Cliente> clientes =service.findAll();	
		modelo.addAttribute("clientes", clientes);
		return "index";
	}
	@GetMapping("/agregar/{id}")
	public String showSave(@PathVariable("id") Long id, Model model) {
		if(id != null) {
			model.addAttribute("cliente", service.findById(id));		
		}
		return "guardar";
	}
	@GetMapping("/agregar")
	public String agregar(Cliente cliente) {
		return "guardar";
	}
	@PostMapping("/guardar")
	public String save(Cliente cliente, Model model) {
		
		service.save(cliente);
		return "redirect:/api/clientes";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {		
	service.delete(id);	
	return "redirect:/api/clientes";
	}
	
	

}
