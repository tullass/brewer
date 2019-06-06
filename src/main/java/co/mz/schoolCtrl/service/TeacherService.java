package co.mz.schoolCtrl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.mz.schoolCtrl.model.Teacher;
import co.mz.schoolCtrl.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Transactional
	public void save(Teacher subject) {
		teacherRepository.save(subject);
	}

	public List<Teacher> getAll() {

		return teacherRepository.findAll();
	}
	
	public Teacher findOne(Long id) {
		
		return teacherRepository.findOne(id);
	}
	
	public void remove(Long id){
		Teacher teacher = this.findOne(id);
		
		if(teacher!=null) teacherRepository.delete(teacher);
	}
	
}
