package co.mz.schoolCtrl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.mz.schoolCtrl.model.Student;
import co.mz.schoolCtrl.repository.StudentRepository;

@Service
public class StudentServices {

	@Autowired
	private StudentRepository studentRepository;

	@Transactional
	public void save(Student student) {
		studentRepository.save(student);
	}

	public Iterable<Student> getAll() {
		return studentRepository.findAll();
	}

	public Student findOne(Long id) {
		return studentRepository.findOne(id);
	}

	public Iterable<Student> findAll() {
		return studentRepository.findAll();
	}

	public Student findLastStudent() {
		return studentRepository.findlast();
	}

	public List<Student> findByNameStartingWithIgnoreCase(String name) {

		return studentRepository.findByNameStartingWithIgnoreCase(name);
	}

	public void remove(Long id) {
		// Student student = this.findOne(id);
		// if(student!=null) studentRepository.delete(student);
	}

}
