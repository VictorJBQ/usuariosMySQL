package com.dam2.actividad5.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dam2.actividad5.model.pedidos;

public interface PedidoRepositorio extends CrudRepository<pedidos,Integer>{
	@Query("FROM pedidos Where usuario.id= :idUsu") //from tiene que llamarse igual que la clase 
	List<pedidos> buscarPedidosPorCliente(Integer idUsu);
	
	List<pedidos> findByArticulo(String paramArticulo);
}
