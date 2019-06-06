package co.mz.schoolCtrl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.mz.schoolCtrl.model.Subject;
import co.mz.schoolCtrl.service.SubjectService;

@Controller
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@RequestMapping("/subject/new")
	public ModelAndView getInit(Subject classObject) {
		ModelAndView mv = new ModelAndView("subject/insert-subject");
		mv.addObject("getSubjects", subjectService.getAll());
		return mv;
	}

	@RequestMapping(value = "/subject/new", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Subject subject, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return getInit(subject);
		}

		subjectService.save(subject);
		attributes.addFlashAttribute("mensagem", "Classe salva com sucesso!");
		return new ModelAndView("redirect:/subject/new");

	}

}
