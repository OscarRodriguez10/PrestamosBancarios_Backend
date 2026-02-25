package com.company.prestamosbancarios.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.prestamosbancarios.model.Cliente;
import com.company.prestamosbancarios.response.ClienteResponseRest;
import com.company.prestamosbancarios.services.IClienteServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
public class ClienteRestController {
	
	@Autowired
	private IClienteServices service;
	
	/**
	 * obtenemos todos los clientes
	 */
	@GetMapping("/clientes")
	public ResponseEntity<ClienteResponseRest> searchClientes(){
		
		ResponseEntity<ClienteResponseRest> response = service.search();
		return response;
	}
	
	/**
	 * obtenemos el cliente por medio del ID
	 */
	@GetMapping("/clientes/{id}")
	public ResponseEntity<ClienteResponseRest> searchClientesById(@PathVariable Long id){
		
		ResponseEntity<ClienteResponseRest> response = service.searchById(id);
		return response;
	}
	/**
	 * guardamos al cliente
	 * @param cliente
	 * @return
	 */
	@PostMapping("/clientes")
	public ResponseEntity<ClienteResponseRest> save(@RequestBody Cliente cliente){
		
		ResponseEntity<ClienteResponseRest> response = service.save(cliente);
		return response;
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<ClienteResponseRest> update(@RequestBody Cliente cliente, @PathVariable Long id){
		
		ResponseEntity<ClienteResponseRest> response = service.update(cliente,id);
		return response;
	}

}
