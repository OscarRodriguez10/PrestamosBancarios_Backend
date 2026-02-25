package com.company.prestamosbancarios.response;

import java.util.List;

import com.company.prestamosbancarios.model.Cliente;

import lombok.Data;
@Data
public class ClienteResponse {
	
	private List<Cliente> cliente;

}
