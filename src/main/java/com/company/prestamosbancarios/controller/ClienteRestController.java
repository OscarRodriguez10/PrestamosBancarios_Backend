package com.company.prestamosbancarios.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.prestamosbancarios.response.ClienteResponseRest;
import com.company.prestamosbancarios.services.IClienteServices;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1")
public class ClienteRestController {
	
	@Autowired
	private IClienteServices services;
	
	@GetMapping("/clientes")
	public ResponseEntity<ClienteResponseRest> searchClientes(){
		
		ResponseEntity<ClienteResponseRest> response = services.search();
		return response;
	}

}
