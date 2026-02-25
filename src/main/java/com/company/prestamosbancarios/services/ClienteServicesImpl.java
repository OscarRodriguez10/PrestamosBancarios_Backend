package com.company.prestamosbancarios.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
	
	//aca obtengo todo los datos que tengamos en la tabla Clientes
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

	//aca obtengo el cliente por medio del ID
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<ClienteResponseRest> searchById(Long id) {
		
		ClienteResponseRest response = new ClienteResponseRest();
		List<Cliente> list = new ArrayList<>();
		try {
		
			Optional<Cliente> cliente = clienteDao.findById(id);
			
			if(cliente.isPresent()) {
				list.add(cliente.get());
				response.getClienteResponse().setCliente(list);
				response.setMetadata("Repuesta OK","00" , "Respuesta Existosa");
				
			}else 
			{
				response.setMetadata("Repuesta no OK","-1" , "Cliente no encontrado");
				return new ResponseEntity<ClienteResponseRest>(response,HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			response.setMetadata("Repuesta no OK","-1" , "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<ClienteResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
						
		}
		return new ResponseEntity<ClienteResponseRest>(response,HttpStatus.OK);
		 
	}

	@Override
	@Transactional

	public ResponseEntity<ClienteResponseRest> save(Cliente cliente) {
		
		ClienteResponseRest response = new ClienteResponseRest();
		List<Cliente> list = new ArrayList<>();
		try {
		
			Cliente clienteGuardar = clienteDao.save(cliente);
			
			if(clienteGuardar != null) {
				list.add(clienteGuardar);
				response.getClienteResponse().setCliente(list);
				response.setMetadata("Repuesta OK","00" , "Cliente guardado");
			}else {
				
				response.setMetadata("Repuesta no OK","-1" , "Cliente no guardado");
				return new ResponseEntity<ClienteResponseRest>(response,HttpStatus.BAD_REQUEST);
			}
			
			
		} catch (Exception e) {
			response.setMetadata("Repuesta no OK","-1" , "Error al guardar cliente");
			e.getStackTrace();
			return new ResponseEntity<ClienteResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
						
		}
		return new ResponseEntity<ClienteResponseRest>(response,HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<ClienteResponseRest> update(Cliente cliente, Long id) {
		ClienteResponseRest response = new ClienteResponseRest();
		List<Cliente> list = new ArrayList<>();
		try {
		
			Optional<Cliente> clienteSearch = clienteDao.findById(id);
			
			if (clienteSearch.isPresent()) {
				
				//se procedera a actualizar 
				
				clienteSearch.get().setNombre(cliente.getNombre());
				clienteSearch.get().setApellido(cliente.getApellido());
				clienteSearch.get().setNumeroIdentificacion(cliente.getNumeroIdentificacion());
				clienteSearch.get().setFechaNacimiento(cliente.getFechaNacimiento());
				clienteSearch.get().setDireccion(cliente.getDireccion());
				clienteSearch.get().setCorreo(cliente.getCorreo());
				clienteSearch.get().setTelefono(cliente.getTelefono());
			    
				Cliente clienteActualizar = clienteDao.save(clienteSearch.get());
				
				if(clienteActualizar != null)
				{
					list.add(clienteActualizar);
					response.getClienteResponse().setCliente(list);
					response.setMetadata("Repuesta OK","00" , "Cliente Actualizado Correctamente");

				}else {
					response.setMetadata("Repuesta no OK","-1" , "Error al actualizar el cliente");
					return new ResponseEntity<ClienteResponseRest>(response,HttpStatus.BAD_REQUEST);
				}
				
			}else {
				response.setMetadata("Repuesta no OK","-1" , "Error al encontrar al cliente");
				return new ResponseEntity<ClienteResponseRest>(response,HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			response.setMetadata("Repuesta no OK","-1" , "Error al actualizar el cliente");
			e.getStackTrace();
			return new ResponseEntity<ClienteResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
						
		}
		return new ResponseEntity<ClienteResponseRest>(response,HttpStatus.OK);
	}

	@Override
	@Transactional 
	public ResponseEntity<ClienteResponseRest> DeteleById(Long id) {
		
		ClienteResponseRest response = new ClienteResponseRest();
		
		
		try {
		
			clienteDao.deleteById(id);
			response.setMetadata("Repuesta OK","00" , "cliente Eliminado");
			
			
		} catch (Exception e) {
			response.setMetadata("Repuesta no OK","-1" , "Error al Eliminar");
			e.getStackTrace();
			return new ResponseEntity<ClienteResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
						
		}
		return new ResponseEntity<ClienteResponseRest>(response,HttpStatus.OK);
	}
	
	

}
