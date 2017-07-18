package com.kyzimobiliaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyzimobiliaria.model.Cliente;
import com.kyzimobiliaria.repository.Clientes;

@Service
public class ClienteService {
	
	@Autowired
	private Clientes clientes;
	
	public void salvarCliente(Cliente cliente){
		clientes.save(cliente);
	}
	
	public Cliente getCliente(String email, String senha){
		return clientes.findByEmailAndSenha(email, senha);
	}
	
	public Cliente getClienteId(Long id){
		return clientes.findById(id);
	}
	
	public void deletarCliente(Cliente cliente){
		clientes.delete(cliente);
	}
}
