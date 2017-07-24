package com.kyzimobiliaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kyzimobiliaria.model.Cliente;
import com.kyzimobiliaria.model.Imovel;
import com.kyzimobiliaria.model.Locacao;
import com.kyzimobiliaria.model.Profissional;
import com.kyzimobiliaria.service.ClienteService;
import com.kyzimobiliaria.service.ImovelService;
import com.kyzimobiliaria.service.LocacaoService;
import com.kyzimobiliaria.service.ProfissionalService;

@Controller
@RequestMapping("/kyzimobiliaria")
public class LocacaoController {
	
	@Autowired
	private LocacaoService locacaoService;
	
	@Autowired
	private ImovelService imovelService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProfissionalService profissionalService;
	
	private Imovel imovel;
	
	@RequestMapping("/locacao/{id}")
	public ModelAndView getPageLocacao(@PathVariable("id") int idImovel, Locacao locacao){
		imovel = imovelService.getImovel(idImovel);
		ModelAndView mv = new ModelAndView("pages/locacao/locacao");
		return mv;
	}
	
	@RequestMapping("/locacao/salvar")
	public ModelAndView salvarLocacao(String cpf, String creci, Locacao locacao, 
			BindingResult result, RedirectAttributes attributes){
		
		ModelAndView mv = new ModelAndView("pages/locacao/locacao");
		if(creci.isEmpty()){
			mv.addObject("mensagem_erro", "CRECI do profissional não existe.");
			mv.addObject("locacao", locacao);
			return mv;
		}
		
		Cliente inquilino = clienteService.getClientePeloCpf(cpf);
		Profissional profissional = profissionalService.getProfissionalPeloCreci(Integer.parseInt(creci));

		if(inquilino == null){
			mv.addObject("mensagem_erro", "Cpf do inquilino inválido.");
			mv.addObject("locacao", locacao);
			return mv;
		}
		if(profissional == null){
			mv.addObject("mensagem_erro", "CRECI do profissional não existe.");
			mv.addObject("locacao", locacao);
			return mv;
		}
		if(result.hasErrors()){
			mv.addObject("locacao", locacao);
			return mv;
		}
		locacao.setInquilino(inquilino);
		locacao.setProfissional(profissional);
		locacao.setImovel(imovel);
		locacaoService.salvarLocacao(locacao);
		attributes.addFlashAttribute("mensagem", "Locação do imóvel concluída.");
		mv.setViewName("redirect:/kyzimobiliaria/buscar/locacoes");
		return mv;
	}
	
	@RequestMapping("/buscar/locacoes")
	public ModelAndView getPageBuscarLocacaoes(){
		ModelAndView mv = new ModelAndView("pages/locacao/busca-locacao");
		mv.addObject("locacoes", locacaoService.getTodasLocacoes());
		return mv;
	}
}







