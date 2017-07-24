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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.kyzimobiliaria.model.Cliente;
import com.kyzimobiliaria.model.Imovel;
import com.kyzimobiliaria.service.ClienteService;
import com.kyzimobiliaria.service.ImovelService;
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
	public ModelAndView cadastrarImovel(String cpf, @Valid Imovel imovel, BindingResult result, 
			RedirectAttributes attributes){
		if(result.hasErrors()){
			ModelAndView mv = new ModelAndView("pages/imovel/cadastro-imovel");
			mv.addObject("imovel", imovel);
			return mv;
		}
		Cliente cliente = clienteService.getClientePeloCpf(cpf);
		if(cliente == null){
			ModelAndView mv = new ModelAndView("redirect:/kyzimobiliaria/cadastroimovel");
			attributes.addFlashAttribute("mensagem_erro", "Verifique o cpf do proprietário.");
			return mv;
		}
		
		imovel.setCliente(cliente);		
		imovelService.salvarImovel(imovel);
		ModelAndView mv = new ModelAndView("redirect:/kyzimobiliaria/buscar/imoveis");
		attributes.addFlashAttribute("mensagem", "Imóvel salvo com sucesso!");
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
	
	@RequestMapping("/imovel/{id}")
	public ModelAndView getPageEdicaoImovel(@PathVariable("id") int id_imovel){
		ModelAndView mv = new ModelAndView("/pages/imovel/edicao");
		Imovel imovel = imovelService.getImovel(id_imovel);
		mv.addObject("imovel", imovel);
		mv.addObject("tiposImovel", tipoImovelService.getTodosTipoImoveis());
		return mv;		
	}
	
	@PostMapping("/excluir/imovel")
	public ModelAndView excluirImovel(int id){
		imovelService.excluirImovel(id);
		ModelAndView mv = new ModelAndView("redirect:/kyzimobiliaria/buscar/imoveis");
		return mv;
	}
	
	@ModelAttribute("todosImoveis")
	public List<Imovel> getTodosImoveis(){
		return imovelService.getTodosImoveis();
	}
	
	

}
