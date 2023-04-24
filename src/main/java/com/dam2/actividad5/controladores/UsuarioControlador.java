package com.dam2.actividad5.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dam2.actividad5.form.PedidoForm;
import com.dam2.actividad5.form.UsuarioForm;
import com.dam2.actividad5.form.buscaArticuloForm;
import com.dam2.actividad5.model.Usuario;
import com.dam2.actividad5.model.pedidos;
import com.dam2.actividad5.repositorio.PedidoRepositorio;
import com.dam2.actividad5.repositorio.UsuarioRepositorio;

import jakarta.validation.Valid;

@Controller
public class UsuarioControlador {
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private PedidoRepositorio pedidoRepositorio;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewUsuarii(@RequestParam String name, @RequestParam String email) {
		Usuario usu = new Usuario();
		usu.setName(name);
		usu.setEmail(email);
		usuarioRepositorio.save(usu);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Usuario> getAllUser() {
		return usuarioRepositorio.findAll();
	}

//agregar desde formulario
	@GetMapping(path = "usuario/alta")
	public String showForm(UsuarioForm usuarioForm) {

		return "usuario/alta";

	}
	
	@GetMapping(path="/usuario/index")
	public String inicio(Model modelo) {
		
		modelo.addAttribute("mensaje",modelo.getAttribute("mensaje"));
		return "/usuario/index";
		
	}
	@GetMapping(path="/usuario/listado")
	public String listarUsuarios(PedidoForm pedidoForm,Model modelo) {
		Iterable<Usuario> itUsuario = usuarioRepositorio.findAll();
		System.out.println("it Usuario: "+itUsuario);
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		itUsuario.forEach(listaUsuarios::add);
		modelo.addAttribute("listaUsuarios",listaUsuarios);
		return "/usuario/listado";
		
	}
	@PostMapping(path="/usuario/listado")
	public String listabusca(PedidoForm pedidoForm,Model modelo) {
		return "/usuario/listado";
	}

	@PostMapping(path = "usuario/alta")
	public String checkPersonInfo(@Valid UsuarioForm usuarioForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "usuario/alta";
		}
		Usuario usuNuevo = new Usuario(usuarioForm.getName(), usuarioForm.getEmail());
		usuarioRepositorio.save(usuNuevo);
		model.addAttribute("mensaje", "Usuario "+usuNuevo.getName()+" dado de alta correctamente");
		return inicio(model);
	}
	
	@GetMapping(path="/usuario/altapedido")
	public String showForm(PedidoForm pedidoform, Model modelo) {
		
		Iterable<Usuario> itusuario = usuarioRepositorio.findAll();
		List<Usuario> listausuarios= new ArrayList<Usuario>();
		itusuario.forEach(listausuarios::add);
		modelo.addAttribute("listaUsuarios",listausuarios);
		return "/usuario/altapedido";
	}
	@GetMapping(path="/usuario/buscaArticulo")
	public String showFormBuscaArticulo(buscaArticuloForm buscaArticulo,Model modelo) {
		
		return "/usuario/buscaArticulo";
	}
	@PostMapping(path = "usuario/buscaArticulo")
	public String BusquedaArticulo( buscaArticuloForm pedidoForm, Model model) {
		Iterable<pedidos> pedi = pedidoRepositorio.findByArticulo(pedidoForm.getArticulo());
		List<pedidos> listapedido = new ArrayList<pedidos>();
		pedi.forEach(listapedido::add);
		model.addAttribute("listapedidos",listapedido);
		return "/usuario/listadopedidos";

	}
	@GetMapping(path="/usuario/buscaPedidosClientes")
	public String showFormBuscaPedidos(PedidoForm pedidoForm,Model modelo) {
		Iterable<Usuario> itusuario = usuarioRepositorio.findAll();
		List<Usuario> listausuarios= new ArrayList<Usuario>();
		itusuario.forEach(listausuarios::add);
		modelo.addAttribute("listaUsuarios",listausuarios);
		return "/usuario/buscaPedidosClientes";
	}
	@PostMapping(path = "usuario/buscaPedidosClientes")
	public String Busqueda( PedidoForm pedidoForm, Model model) {
		Iterable<pedidos> pedi = pedidoRepositorio.buscarPedidosPorCliente(pedidoForm.getIdUsuario());
		List<pedidos> listapedido = new ArrayList<pedidos>();
		pedi.forEach(listapedido::add);
		model.addAttribute("listapedidos",listapedido);
		return "/usuario/listadopedidos";

	}
	
	@PostMapping(path = "usuario/altapedido")
	public String checkPedidoInfo(@Valid PedidoForm pedidoForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return showForm(pedidoForm, model);
		}
		Usuario usu = usuarioRepositorio.findByid(pedidoForm.getIdUsuario());
		pedidos pedido1= new pedidos(pedidoForm.getArticulo(),usu);
		pedidoRepositorio.save(pedido1);
		model.addAttribute("mensaje", "Pedido "+pedido1.getArticulo()+ " recepcionado correctamente");
		return inicio(model);
	}
	@GetMapping(path="/usuario/listadopedidos")
	public String listarpedidos(Model modelo) {
		Iterable<pedidos> itPedido = pedidoRepositorio.findAll();
		System.out.println("it Pedidos: "+itPedido);
		List<pedidos> listaPedidos = new ArrayList<pedidos>();
		itPedido.forEach(listaPedidos::add);		
		modelo.addAttribute("listapedidos",listaPedidos);
		return "/usuario/listadopedidos";
		
	}

}
