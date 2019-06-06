package co.mz.schoolCtrl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.mz.schoolCtrl.model.Subject;
import co.mz.schoolCtrl.repository.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Transactional
	public void save(Subject subject) {
		subjectRepository.save(subject);
	}

	public List<Subject> getAll() {

		return subjectRepository.findAll();
	}
	
	public Subject findOne(Long id) {
		
		return subjectRepository.findOne(id);
	}
	
	public void remove(Long id){
		Subject subject = this.findOne(id);
		
		if(subject!=null) subjectRepository.delete(subject);
	}
	
}
