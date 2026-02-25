package com.company.prestamosbancarios.services;

import java.util.List;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.prestamosbancarios.dao.IClienteDao;
import com.company.prestamosbancarios.model.Cliente;
import com.company.prestamosbancarios.response.ClienteResponseRest;
@Service

public class ClienteServicesImpl implements IClienteServices {

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	
	public ResponseEntity<ClienteResponseRest> search() {

		ClienteResponseRest response = new ClienteResponseRest();
		
		try {
			List<Cliente> cliente = (List<Cliente>) clienteDao.findAll();
			
			response.getClienteResponse().setCliente(cliente);
			response.setMetadata("Repuesta Ok","00" , "Respuesta Exitosa");
			
		} catch (Exception e) {
			response.setMetadata("Repuesta no OK","-1" , "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<ClienteResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
						
		}
		return new ResponseEntity<ClienteResponseRest>(response,HttpStatus.OK);

	}
	
	

}
