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

import co.mz.schoolCtrl.model.Teacher;
import co.mz.schoolCtrl.service.SubjectService;
import co.mz.schoolCtrl.service.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	@Autowired
	private SubjectService subjectService;

	@RequestMapping("/teacher/new")
	public ModelAndView getInit(Teacher teacher) {
		ModelAndView mv = new ModelAndView("teacher/insert-teacher");
		mv.addObject("getSubjects", subjectService.getAll());
		return mv;
	}

	@RequestMapping(value = "/teacher/new", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Teacher teacher, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			// attributes.addFlashAttribute("mensagem", "Erro ao tentar Inserir");
			return getInit(teacher);
		}

//		
		if (teacher.getSubject() != null) {

			teacherService.save(teacher);
			attributes.addFlashAttribute("mensagem", "Professor inserido com sucesso!");
			System.out.println(">>>>>>>>>" + teacher.getSubject().getId());
			return new ModelAndView("redirect:/teacher/new");

		}
		return null;
	}

}
