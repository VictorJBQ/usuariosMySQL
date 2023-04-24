package com.dam2.actividad5.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class buscaArticuloForm {
	@NotNull
	@Size(min=3,max=30,message="El campo nombre debe tener entre 3 y 30 caracteres")
	private String articulo;

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	
}
