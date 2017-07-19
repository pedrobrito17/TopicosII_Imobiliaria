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
import com.kyzimobiliaria.service.ClienteService;
import com.kyzimobiliaria.service.ImovelService;
import com.kyzimobiliaria.service.ProfissionalService;
import com.kyzimobiliaria.service.TipoImovelService;

@Controller
@RequestMapping("/kyzimobiliaria")
public class ImovelController {
	
	@Autowired
	private ImovelService imovelService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private TipoImovelService tipoImovelService;
	
	@PostMapping("/cadastrarimovel")
	public ModelAndView cadastrarImovel(String cpfProprietario, @Valid Imovel imovel, BindingResult result, 
			RedirectAttributes attributes){
		if(result.hasErrors()){
			ModelAndView mv = new ModelAndView("pages/imovel/cadastro-imovel");
			mv.addObject("imovel", imovel);
			return mv;
		}
		
		Cliente cliente = clienteService.getClientePeloCpf(cpfProprietario);
		imovel.setCliente(cliente);
		
		imovelService.salvarImovel(imovel);
		ModelAndView mv = new ModelAndView("redirect:/kyzimobiliaria/loginprofissional");
		attributes.addFlashAttribute("mensagem", "Cadastro concluído com sucesso!");
		return mv;
	}
	
	@RequestMapping("/cadastroimovel") 
	public ModelAndView cadastroImovel(Imovel imovel){	
		ModelAndView mv = new ModelAndView("pages/imovel/cadastro-imovel");
		mv.addObject("tiposImovel", tipoImovelService.getTodosTipoImoveis());
		return mv;
	}
	
	@RequestMapping("/buscar/imoveis")
	public ModelAndView getPageImoveis(){
		ModelAndView mv = new ModelAndView("pages/imovel/busca-imovel");
		return mv;
	}
	
	@ModelAttribute("todosImoveis")
	public List<Imovel> getTodosImoveis(){
		return imovelService.getTodosImoveis();
	}

}
