package co.mz.schoolCtrl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.mz.schoolCtrl.handler.EstiloHandler;
import co.mz.schoolCtrl.model.Estilo;
import co.mz.schoolCtrl.service.CadastroEstiloService;

@RestController
@RequestMapping("estilos")
public class EstiloController {

	@Autowired
	private CadastroEstiloService cadastroCervejaService;

	@RequestMapping("/novo")
	public ModelAndView novo(Estilo e) {

		return new ModelAndView("estilo/CadastroEstilo");
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView save(@Valid Estilo estilo, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return novo(estilo);
		}
		try {
			cadastroCervejaService.salvar(estilo);
		} catch (Exception ee) {
			result.rejectValue("nome", ee.getMessage(), ee.getMessage());
		}

		attr.addFlashAttribute("mensagem", "Has saved succefully");
		return new ModelAndView("redirect:/estilos/novo");
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?> save(@RequestBody @Valid Estilo estilo, BindingResult br) {
		if(br.hasErrors()) { 
			return ResponseEntity.badRequest().body(br.getFieldError("nome").getDefaultMessage());
		}
		
		try {
			cadastroCervejaService.salvar(estilo);
			
		} catch (EstiloHandler e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

		return ResponseEntity.ok(estilo);
	}

}
