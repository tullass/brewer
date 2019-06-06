package co.mz.schoolCtrl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.mz.schoolCtrl.model.Services;
import co.mz.schoolCtrl.repository.ServiceRepository;

@Service
public class ServiceOfService {

	@Autowired private ServiceRepository serviceRepository;

	@Transactional
	public void save(Services services){
		serviceRepository.save(services);
	}
	
	public Iterable<Services> listar(){
		return serviceRepository.findAll();
	}
	
	public Services findOne(Long id){
		return serviceRepository.findOne(id);
	}
	
	public Iterable<Services> findAll(){	
		return serviceRepository.findAll();
	}
	
	public void remove(Long id){
		Services services = this.findOne(id);
		if(services!=null) serviceRepository.delete(services);
	}
	
}
