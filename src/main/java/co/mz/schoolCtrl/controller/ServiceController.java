package co.mz.schoolCtrl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.mz.schoolCtrl.model.Services;
import co.mz.schoolCtrl.service.ServiceOfService;

@RestController
@RequestMapping("service")
public class ServiceController {

	@Autowired
	private ServiceOfService serviceServices;

	@RequestMapping("/new")
	public ModelAndView novo(Services services) {
		ModelAndView mv = new ModelAndView("servicee/insert-servicee");
		mv.addObject("getServices", serviceServices.findAll());

		return mv;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Services services, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Erro ao salvar");
			return novo(services);
		}

		serviceServices.save(services);
		attributes.addFlashAttribute("mensagem", "A classe " + services.getDescription() + " foi inserida");
		return new ModelAndView("redirect:/service/new");
	}

//	@RequestMapping("/allServicess")
//	public ModelAndView list(Services services) {
//		ModelAndView mv = new ModelAndView("servicee/table-servicee");
//		mv.addObject("getServices", serviceServices.findAll());
//		return mv;
//	}
	
	@RequestMapping("/allServices")
	@ResponseBody 
	public Iterable<Services> findGrades() {
		return serviceServices.findAll();
	}
}
