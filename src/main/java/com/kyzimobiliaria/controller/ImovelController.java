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

import com.kyzimobiliaria.model.Imovel;
import com.kyzimobiliaria.model.Profissional;
import com.kyzimobiliaria.service.ImovelService;
import com.kyzimobiliaria.service.ProfissionalService;

@Controller
@RequestMapping("/kyzimobiliaria")
public class ImovelController {
	
	@Autowired
	private ImovelService imovelService;
	
	@Autowired
	private ProfissionalService profissionalService;
	
	@PostMapping("/cadastrarimovel/{id}")
	public ModelAndView cadastrarImovel(@PathVariable("id") int id, 
			@Valid Imovel imovel, BindingResult result, 
			RedirectAttributes attributes){
		if(result.hasErrors()){
			ModelAndView mv = new ModelAndView("pages/imovel/cadastro-imovel");
			mv.addObject("imovel", imovel);
			return mv;
		}
		Profissional prof = profissionalService.getProfissionalId(id);
		imovel.setProf(prof);
		imovelService.salvarImovel(imovel);
		ModelAndView mv = new ModelAndView("redirect:/kyzimobiliaria/loginprofissional");
		//mv.addObject("profissional", prof);
		//attributes.addFlashAttribute("mensagem", "Cadastro concluído com sucesso!");
		return mv;
	}
	
	@RequestMapping("/cadastroimovel/{id}") 
	public ModelAndView cadastroImovel(@PathVariable("id") int id, Imovel imovel){	
		Profissional prof = profissionalService.getProfissionalId(id);
		ModelAndView mv = new ModelAndView("pages/imovel/cadastro-imovel");
		mv.addObject("profissional", prof);
		return mv;
	}
	
	@RequestMapping("/imoveis")
	public ModelAndView getPageImoveis(){
		ModelAndView mv = new ModelAndView("pages/imovel/listar-imoveis");
		mv.addObject("imoveis", imovelService.getTodosImoveis());
		return mv;
	}

}
