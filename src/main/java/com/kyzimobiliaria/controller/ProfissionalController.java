package com.kyzimobiliaria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	
	@RequestMapping("/profissional")
	public ModelAndView getPageProfissional(){
		ModelAndView mv = new ModelAndView("pages/profissional/login-profissional");
		return mv;
	}
	
	@RequestMapping("/loginprofissional")
	public ModelAndView loginProfissional(Profissional profissional){
		ModelAndView mv = new ModelAndView("pages/profissional/login-profissional");
		return mv;
	}
	
	@PostMapping("/entrarprofissional")
	public ModelAndView entrarProfissional(Profissional profissional, RedirectAttributes attributes){
		String email = profissional.getEmail();
		String senha = profissional.getSenha();
		
		Profissional prof = profissionalService.getProfissional(email, senha);
		
		if(prof != null){
			ModelAndView mv = new ModelAndView("pages/profissional/painel-profissional");
			mv.addObject("profissional", prof);
			return mv;
		}
		ModelAndView mv = new ModelAndView("redirect:/kyzimobiliaria/loginprofissional");
		attributes.addFlashAttribute("mensagem_erro", "Senha ou e-mail não confere.");
		return mv;			
	}
	
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
	
	@RequestMapping("/painel-profissional")
	public ModelAndView getPagePainelProfissional(Profissional profissional){
		ModelAndView mv = new ModelAndView("pages/profissional/painel-profissional");
		mv.addObject(profissional);
		return mv;
	}
	
	@PostMapping("/salvarprofissional")
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
	}
	
	@RequestMapping(value="/deletarprofissional/{id}", method = RequestMethod.GET) 
	public ModelAndView deletarCliente(@PathVariable("id") int id){
		Profissional profissional = profissionalService.getProfissionalId(id);
		profissionalService.deletarProfissional(profissional);
		return new ModelAndView("redirect:/kyzimobiliaria/loginprofissional");
	}
	
}
