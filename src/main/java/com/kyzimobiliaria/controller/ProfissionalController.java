package com.kyzimobiliaria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kyzimobiliaria.model.Cliente;
import com.kyzimobiliaria.model.Imovel;
import com.kyzimobiliaria.model.Profissional;
import com.kyzimobiliaria.service.ProfissionalService;

@Controller
@RequestMapping("/kyzimobiliaria")
public class ProfissionalController {
	
	@Autowired
	private ProfissionalService profissionalService;
	
	@RequestMapping("/cadastroprofissional")
	public ModelAndView cadastroProfissional(){
		ModelAndView mv = new ModelAndView("pages/profissional/cadastro-profissional");
		mv.addObject("profissional", new Profissional());
		return mv;
	}
	
	@PostMapping("/cadastrarprofissional")
	public ModelAndView cadastrarProfissional(@Valid Profissional profissional, BindingResult result,
			RedirectAttributes attributes){
		if(result.hasErrors()){
			ModelAndView mv = new ModelAndView("pages/profissional/cadastro-profissional");
			mv.addObject("profissional", profissional);
			return mv;
		}
		profissionalService.salvarProfissional(profissional);
		ModelAndView mv = new ModelAndView("redirect:/kyzimobiliaria/cadastroprofissional");
		mv.addObject("profissional",  profissional);
		attributes.addFlashAttribute("mensagem", "Cadastro realizado com sucesso.");
		return mv;
	}
	
	@RequestMapping("/buscar/profissional")
	public ModelAndView getPageBuscarTodosProfissionais(){
		ModelAndView mv = new ModelAndView("pages/profissional/busca-profissional");
		return mv;
	}
	
	@ModelAttribute("todosProfissionais")
	public List<Profissional> getTodosProfissionais(){
		List<Profissional> todosProfissionais = profissionalService.getTodosProfissionais();
		return todosProfissionais;
	}
/*	@PostMapping("/salvarprofissional")
	public ModelAndView postsalvar(@Valid Profissional profissional, BindingResult result, 
			RedirectAttributes attributes){
		if(result.hasErrors()){
			return getPagePainelProfissional(profissional);
		}
		profissionalService.salvarProfissional(profissional);
		attributes.addFlashAttribute("mensagem", "Seus dados foram alterados com sucesso!");
		ModelAndView mv = new ModelAndView("redirect:/kyzimobiliaria/painel-profissional");
		mv.addObject(profissional);
		return mv;
	}*/
	
/*	@RequestMapping(value="/deletarprofissional/{id}", method = RequestMethod.GET) 
	public ModelAndView deletarCliente(@PathVariable("id") int id){
		Profissional profissional = profissionalService.getProfissionalId(id);
		profissionalService.deletarProfissional(profissional);
		return new ModelAndView("redirect:/kyzimobiliaria/loginprofissional");
	}*/
	
}
