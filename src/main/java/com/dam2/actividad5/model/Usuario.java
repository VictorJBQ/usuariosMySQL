package com.dam2.actividad5.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	
	@OneToMany(mappedBy="usuario") //define una relacion one-to-many Mappedby indica la entidad que es dueña del uno a muchos de forma unica
	private List<pedidos> listaPedidos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Usuario(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Usuario() {
		super();
	}

}