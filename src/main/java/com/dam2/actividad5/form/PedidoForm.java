package com.dam2.actividad5.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PedidoForm {
	@NotNull
	@Size(min=3,max=30,message="El campo nombre debe tener entre 3 y 30 caracteres")
	private String articulo;
	private Integer idUsuario;
	
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
