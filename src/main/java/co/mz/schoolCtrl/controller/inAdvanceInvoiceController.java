package co.mz.schoolCtrl.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.mz.schoolCtrl.enumerator.Bank;
import co.mz.schoolCtrl.enumerator.Month;
import co.mz.schoolCtrl.enumerator.Semester;
import co.mz.schoolCtrl.enumerator.Year;
import co.mz.schoolCtrl.model.Invoice;
import co.mz.schoolCtrl.model.Matricula;
import co.mz.schoolCtrl.service.InvoiceServices;
import co.mz.schoolCtrl.service.MatriculaServices;
import co.mz.schoolCtrl.service.ServiceOfService;

@Controller
@RequestMapping("in-advance-invoice")
public class inAdvanceInvoiceController {

	@Autowired
	private InvoiceServices InvoiceService;

	@Autowired
	private MatriculaServices matriculaServices;;

	@Autowired
	private ServiceOfService serviceService;

	@RequestMapping("/new")
	public ModelAndView getInit(Invoice classObject) {
		ModelAndView mv = new ModelAndView("invoice/in-advance-invoice");
		mv.addObject("getInvoices", InvoiceService.getAll());
		mv.addObject("getServices", serviceService.findAll());
		mv.addObject("getBanks", Bank.values());
		mv.addObject("getSemester", Semester.values());
		mv.addObject("getYears", Year.values());
		mv.addObject("getMonths", Month.values());

		return mv;
	}

	@RequestMapping("allInvoice")
	public ModelAndView listAllInvoices() {
		ModelAndView mv = new ModelAndView("invoice/in-advance-table-report-invoice");
		mv.addObject("getInvoices",InvoiceService.findAll());
			return mv;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Invoice Invoice, BindingResult result, Model model,
			RedirectAttributes attributes) {
		try {
			if (result.hasErrors()) {
				return getInit(Invoice);
			}

			InvoiceService.save(Invoice);
			attributes.addFlashAttribute("mensagem", "Invoice efectuada com sucesso!");
		} catch (Exception e) {
//			attributes.addFlashAttribute("mensagem", "e");
		}
		return new ModelAndView("redirect:/invoice/new");
	}

//	@RequestMapping(method = RequestMethod.GET,path = "invoice/{name}")
//	public @ResponseBody  List<Matricula> findGrades(@PathVariable String name) {
//	
//		return  matriculaServices.innerT(name);
//		
//	}

	@RequestMapping(path = "invoice/{name}", method = RequestMethod.GET)
	@ResponseBody
	public List<Matricula> findStudents(@PathVariable("name") String name) {
		ValidateLenthName(name);
		List<Matricula> foundedStudents = matriculaServices.innerT(name);
		if (!foundedStudents.isEmpty()) {
			return matriculaServices.innerT(name);
		}
		return null;

	}

	private void ValidateLenthName(String nome) {
		if (StringUtils.isEmpty(nome) || nome.length() < 3) {
			throw new IllegalArgumentException();
		}
	}
//	@RequestMapping(value = "/getAllClass", method = RequestMethod.GET)
//	@ResponseBody 
//	public Iterable<Classe> findGrades() {	
//		return classServices.findAll();		
//	}
//	
//	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody List<Classe> findGradePerCode(
//			@RequestParam(name = "grade", defaultValue = "-1") Long id) {
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {	}
//		return classService.findGradeCode(id);
//	}

//	@RequestMapping(method = RequestMethod.GET,path = "Invoice/{id}")
//	public @ResponseBody  List<Classe> findGrades(@PathVariable Long id) {
//	
//		return  classService.innerT(id);
//		
//	}

//	@RequestMapping(method=RequestMethod.GET, value="/{id}")
//	@ResponseBody
//	public Ingrediente buscarIngrediente(@PathVariable Long id){
//		Ingrediente ingrediente = servicoIngrediente.buscar(id);
//		return ingrediente;
//	}

}
