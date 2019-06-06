package co.mz.schoolCtrl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.mz.schoolCtrl.model.Classe;
import co.mz.schoolCtrl.repository.ClassRepository;;


@Service
public class ClassServices {

	@Autowired private ClassRepository repositorio;

	@Transactional
	public void save(Classe classs){
		repositorio.save(classs);
	}
	
	public Iterable<Classe> findAll(){
		return repositorio.findAll();
	}
	
	public Classe findOne(Long id){
		return repositorio.findOne(id);
	}
	
	
	public List<Classe> innerT(Long id){
		
		return repositorio.ineer(id);
	}
	public List<Classe> findGradeCode(Long id){
		
		return repositorio.findByGradeId(id);
	}
	
	
	
	
	public void remove(Long id){
		Classe classs = this.findOne(id);
		if(classs!=null) repositorio.delete(classs);
	}
	
}
