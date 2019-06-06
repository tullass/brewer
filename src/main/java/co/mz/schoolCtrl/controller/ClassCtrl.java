package co.mz.schoolCtrl.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.mz.schoolCtrl.model.Classe;
import co.mz.schoolCtrl.service.ClassServices;
import co.mz.schoolCtrl.service.GradeServices;
import co.mz.schoolCtrl.service.SubjectService;

@Controller
@RequestMapping("classee")
public class ClassCtrl {
	

	@Autowired private ClassServices classService;
	@Autowired private GradeServices gradeService;
	@Autowired private SubjectService subjectService;
	
	@RequestMapping("/new")
	public ModelAndView getInit(Classe classObject) {
		ModelAndView mv = new ModelAndView("classee/insert-classee");
		mv.addObject("getGrades", gradeService.findAll());
		mv.addObject("getSubjects",subjectService.getAll());
			return mv;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Classe classObject,
	BindingResult result, Model model, 
	RedirectAttributes attributes) {
		if (result.hasErrors()) {
		//	attributes.addFlashAttribute("mensagem", "Erro ao tentar Inserir");
			return getInit(classObject);
		}
		
//		
		if(classObject.getGrade()!=null) {
		
			classService.save(classObject);
			attributes.addFlashAttribute("mensagem", "Classe salva com sucesso!");
			System.out.println(">>>>>>>>>"+classObject.getGrade().getId());
			return new ModelAndView("redirect:/classee/new");

		}
		return null;
	}
	
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Classe> findGradePerCode(
			@RequestParam(name = "grade", defaultValue = "-1") Long id) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {	}
		return classService.findGradeCode(id);
	}
	
	




}
