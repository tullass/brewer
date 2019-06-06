package co.mz.schoolCtrl.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.mz.schoolCtrl.model.Student;
import co.mz.schoolCtrl.service.StudentServices;

@RestController
@RequestMapping("matricula/students")
public class StudentController {

	@Autowired
	private StudentServices studentService;

	@RequestMapping("/student/new")
	public ModelAndView getInit(Student classObject) {
		ModelAndView mv = new ModelAndView("student/insert-student");
//		mv.addObject("getStudents", studentService.getAll());
		return mv;
	}

	@RequestMapping(value = "/student/new", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Student student, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return getInit(student);
		}

		Student lastId=studentService.findLastStudent();
		student.setOwnid("A1"+lastId.getId());
		studentService.save(student);
		attributes.addFlashAttribute("mensagem", "Estudante Inserido com sucesso!");
		return new ModelAndView("redirect:/student/new");
	}
	
	@RequestMapping(path = "/{name}", method = RequestMethod.GET)
	@ResponseBody 
	public List<Student> findGrades(@PathVariable("name") String name) {
		validarTamanhoNome(name);
		List<Student> foundedStudents =studentService.findByNameStartingWithIgnoreCase(name);
		if(!foundedStudents.isEmpty()) {
			return studentService.findByNameStartingWithIgnoreCase(name);
		}
		return null;
		
	}

	private void validarTamanhoNome(String nome) {
		if (StringUtils.isEmpty(nome) || nome.length() < 3) {
			throw new IllegalArgumentException();
		}
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Void> tratarIllegalArgumentException(IllegalArgumentException e) {
		return ResponseEntity.badRequest().build();
	}

}
