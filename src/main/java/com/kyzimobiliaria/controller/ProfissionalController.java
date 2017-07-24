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
		ModelAndView mv = new ModelAndView("redirect:/kyzimobiliaria/buscar/profissional");
		mv.addObject("profissional",  profissional);
		attributes.addFlashAttribute("mensagem", "Profissional salvo com sucesso!");
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
	
	@RequestMapping("/profissional/{id}")
	public ModelAndView getPageEdicaoProfissional(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView("/pages/profissional/edicao");
		Profissional profissional = profissionalService.getProfissionalId(id);
		mv.addObject("profissional", profissional);
		return mv;		
	}
	
	@PostMapping("/excluir/profissional")
	public ModelAndView excluirProfissional(int id){
		profissionalService.deletarProfissional(id);
		ModelAndView mv = new ModelAndView("redirect:/kyzimobiliaria/buscar/profissional");
		return mv;
	}

	
}
