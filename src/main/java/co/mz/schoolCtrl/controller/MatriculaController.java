	package co.mz.schoolCtrl.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.mz.schoolCtrl.enumerator.Period;
import co.mz.schoolCtrl.enumerator.Semester;
import co.mz.schoolCtrl.model.Classe;
import co.mz.schoolCtrl.model.Matricula;
import co.mz.schoolCtrl.service.ClassServices;
import co.mz.schoolCtrl.service.MatriculaServices;

@RestController
@RequestMapping("matricula")
public class MatriculaController {

	@Autowired
	private MatriculaServices matriculaService;

	@Autowired private ClassServices classService;
	
	@RequestMapping("/new")
	public ModelAndView getInit(Matricula classObject) {
		ModelAndView mv = new ModelAndView("matricula/insert-matricula");
		mv.addObject("getMatriculas", matriculaService.getAll());
		mv.addObject("getClasses",classService.findAll());
		mv.addObject("getPeriods",Period.values());
		mv.addObject("getSemester",Semester.values());

		return mv;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Matricula matricula,BindingResult result, Model model,
			RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return getInit(matricula);
		}

	
		matriculaService.save(matricula);
		attributes.addFlashAttribute("mensagem", "Matricula efectuada com sucesso!");
		return new ModelAndView("redirect:/matricula/new");
	}


	
	@RequestMapping(method = RequestMethod.GET,path = "matricula/{id}")
	public @ResponseBody  List<Classe> findGrades(@PathVariable Long id) {
	
		return  classService.innerT(id);
		
	}
	
	

//	@RequestMapping(method=RequestMethod.GET, value="/{id}")
//	@ResponseBody
//	public Ingrediente buscarIngrediente(@PathVariable Long id){
//		Ingrediente ingrediente = servicoIngrediente.buscar(id);
//		return ingrediente;
//	}

}
