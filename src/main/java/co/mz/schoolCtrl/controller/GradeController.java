package co.mz.schoolCtrl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.mz.schoolCtrl.model.Grade;
import co.mz.schoolCtrl.repository.GradeRepository;


@Controller
public class GradeController {

	@Autowired 
	private GradeRepository gradeServices;
		
	@RequestMapping("grade/new")
	public ModelAndView novo(Grade grade) {
		ModelAndView mv = new ModelAndView("gradee/insert-gradee");
			return mv;
	}
	
	@RequestMapping(value="grade/new", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Grade grade, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Erro ao salvar");
			return novo(grade);
		}
	
		gradeServices.save(grade);
		attributes.addFlashAttribute("mensagem", "A classe "+grade.getDescription()+" foi inserida");
		return new ModelAndView("redirect:/grade/new");
	}
	

	@RequestMapping("/allGrades")
	public ModelAndView list(Grade grade) {
		ModelAndView mv = new ModelAndView("gradee/table-gradee");
		mv.addObject("grades",gradeServices.findAll());
			return mv;
	}
	@RequestMapping(path = "/{description}", method = RequestMethod.GET)
	 @ResponseBody 
	public Iterable<Grade> findGrades(@PathVariable("description") String description) {
//		validarTamanhoNome(nome);
		return gradeServices.findByDescriptionStartingWithIgnoreCase(description);
//		return gradeServices.findAll();
	}

//	s
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public Object tun() {
		return gradeServices.findAll();
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Void> tratarIllegalArgumentException(IllegalArgumentException e) {
		return ResponseEntity.badRequest().build();
	}
}
