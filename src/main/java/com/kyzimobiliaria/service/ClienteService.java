package com.kyzimobiliaria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kyzimobiliaria.model.Cliente;
import com.kyzimobiliaria.model.Role;
import com.kyzimobiliaria.repository.Clientes;
import com.kyzimobiliaria.repository.Roles;

@Service
public class ClienteService {
	
	@Autowired
	private Clientes clientes;
	
	@Autowired
	private Roles roles;
	
	@Transactional
	public void salvarCliente(Cliente cliente){
		Cliente clienteDeletado = clientes.findByCpf(cliente.getCpf());
		if(clienteDeletado != null){
			cliente.setId(clienteDeletado.getId());
			clientes.save(cliente);
		}else{
			Role role = roles.findOne(2); //ROLE_CLIENTE
			cliente.getPermissoes().add(role);
			String senhaCriptografa = new BCryptPasswordEncoder().encode(cliente.getPassword());
			cliente.setPassword(senhaCriptografa);
			clientes.save(cliente);
		}
	}
	
	public Cliente getClienteId(Long id){
		return clientes.findById(id);
	}
	
	public void deletarCliente(Cliente cliente){
		clientes.delete(cliente);
	}

	public List<Cliente> getTodosClientes() {
		return clientes.selectTodosClientes();
	}

	public Cliente getClientePeloCpf(String cpfProprietario) {
		return clientes.findByCpf(cpfProprietario);
	}
	
	@Transactional
	public void excluir(long id) {
		Cliente cliente = clientes.findById(id);
		cliente.setAtivo(false);
		clientes.save(cliente);
	}

	public Cliente getClienteEmail(String email) {
		return clientes.findByEmail(email);
	}
}
