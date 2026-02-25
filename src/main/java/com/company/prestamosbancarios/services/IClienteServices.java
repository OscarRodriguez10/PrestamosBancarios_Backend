package com.company.prestamosbancarios.services;

import org.springframework.http.ResponseEntity;

import com.company.prestamosbancarios.response.ClienteResponseRest;

public interface IClienteServices {

	public ResponseEntity<ClienteResponseRest> search();
}
