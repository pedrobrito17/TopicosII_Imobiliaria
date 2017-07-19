package com.kyzimobiliaria.service;

import java.util.List;

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
	
	public Cliente getClienteId(Long id){
		return clientes.findById(id);
	}
	
	public void deletarCliente(Cliente cliente){
		clientes.delete(cliente);
	}

	public List<Cliente> getTodosClientes() {
		return clientes.findAll();
	}

	public Cliente getClientePeloCpf(String cpfProprietario) {
		return clientes.findByCpf(cpfProprietario);
	}
}
