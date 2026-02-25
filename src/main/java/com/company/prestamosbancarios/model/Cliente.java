package com.company.prestamosbancarios.model;

import java.io.Serializable;
import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="clientes")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7216144286031271836L;
	  	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String nombre;
	    private String apellido;
	
	    private String numeroIdentificacion;

	    private LocalDate fechaNacimiento;
	    private String direccion;
	    private String correo;
	    private String telefono;


}
