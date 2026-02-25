package com.company.prestamosbancarios.dao;

import org.springframework.data.repository.CrudRepository;

import com.company.prestamosbancarios.model.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {
	
	

}
