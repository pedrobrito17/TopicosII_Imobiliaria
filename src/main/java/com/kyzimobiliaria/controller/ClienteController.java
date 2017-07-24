package com.kyzimobiliaria.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kyzimobiliaria.model.Cliente;
import com.kyzimobiliaria.model.Imovel;
import com.kyzimobiliaria.service.ClienteService;

@Controller
@RequestMapping("/kyzimobiliaria")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("/cadastro-cliente")
	public ModelAndView getPageCadastroCliente(Cliente cliente){
		ModelAndView mv = new ModelAndView("pages/cliente/cadastro-cliente");
		return mv;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView postCadastrar(@Valid Cliente cliente, BindingResult result ,RedirectAttributes attributes){
		
		if(result.hasErrors()){
			ModelAndView mv = new ModelAndView("pages/cliente/cadastro-cliente");
			mv.addObject("cliente", cliente);
			return mv;
		}
		clienteService.salvarCliente(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!");
		return new ModelAndView("redirect:/kyzimobiliaria/buscar/clientes");
	}
	
	@RequestMapping("/buscar/clientes")
	public ModelAndView getpageBuscaClientes(){
		ModelAndView mv = new ModelAndView("/pages/cliente/busca-cliente");
		return mv;
	}
	
	@ModelAttribute("todosClientes")
	public List<Cliente> getTodosClientes(){
		List<Cliente> todosClientes = clienteService.getTodosClientes();
		return todosClientes;
	}
	
	@RequestMapping("/cliente/{id}")
	public ModelAndView getPageEdicaoImovel(@PathVariable("id") long idCliente){
		ModelAndView mv = new ModelAndView("/pages/cliente/edicao");
		Cliente cliente = clienteService.getClienteId(idCliente);
		mv.addObject("cliente", cliente);
		return mv;		
	}
	
	@PostMapping("/excluir/cliente")
	public ModelAndView excluirCliente(long id){
		clienteService.excluir(id);
		ModelAndView mv = new ModelAndView("redirect:/kyzimobiliaria/buscar/clientes");
		return mv;
	}
}
