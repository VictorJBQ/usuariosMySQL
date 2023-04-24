package com.dam2.actividad5.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class pedidos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String articulo;
	private LocalDate fechapedido;
	private LocalDate fechaEntrega;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	
	public pedidos() {
	}
	public pedidos(Integer id, String articulo, LocalDate fechapedido, LocalDate fechaEntrega, String estado,
			Usuario usuario) {
		super();
		this.id = id;
		this.articulo = articulo;
		this.fechapedido = fechapedido;
		this.fechaEntrega = fechaEntrega;
		this.estado = estado;
		this.usuario = usuario;
	}
	public pedidos(String articulo, 
			Usuario usuario) {
		super();
		this.articulo = articulo;
		this.fechapedido = LocalDate.now();
		this.fechaEntrega = LocalDate.now().plusDays(10);
		this.estado = "Nuevo";
		this.usuario = usuario;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public LocalDate getFechapedido() {
		return fechapedido;
	}
	public void setFechapedido(LocalDate fechapedido) {
		this.fechapedido = fechapedido;
	}
	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
