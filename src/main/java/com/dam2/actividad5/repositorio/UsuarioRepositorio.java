package com.dam2.actividad5.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.dam2.actividad5.model.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario,Integer> {
		Usuario findByid(Integer id);
}
