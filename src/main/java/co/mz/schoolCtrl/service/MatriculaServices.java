package co.mz.schoolCtrl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.mz.schoolCtrl.model.Matricula;
import co.mz.schoolCtrl.repository.MatriculaRepository;;

@Service
public class MatriculaServices {

	@Autowired
	private MatriculaRepository matriculaRepository;

	@Transactional
	public void save(Matricula matricula) {

		matriculaRepository.save(matricula);
	}

	@Transactional(readOnly = true)
	public Iterable<Matricula> findAll() {
		return matriculaRepository.findAll();
	}

	public Matricula findOne(Long id) {
		return matriculaRepository.findOne(id);
	}

	public List<Matricula> innerT(String name) {
		return matriculaRepository.findStudentByNameStartinrgWithIgnoreCase(name);
	}

	public void remove(Long id) {
		Matricula matricula = this.findOne(id);
		if (matricula != null)
			matriculaRepository.delete(matricula);
	}

	public List<Matricula> getAll() {

		List<Matricula> listAll = (List<Matricula>) matriculaRepository.findAll();
		return listAll;
	}

}
