package com.company.prestamosbancarios.services;

import org.springframework.http.ResponseEntity;

import com.company.prestamosbancarios.model.Cliente;
import com.company.prestamosbancarios.response.ClienteResponseRest;

public interface IClienteServices {

	public ResponseEntity<ClienteResponseRest> search();
	public ResponseEntity<ClienteResponseRest> searchById(Long id);
	public ResponseEntity<ClienteResponseRest> save(Cliente cliente);
	
	
}
