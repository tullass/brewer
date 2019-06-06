package co.mz.schoolCtrl.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.mz.schoolCtrl.handler.EstiloHandler;
import co.mz.schoolCtrl.model.Estilo;
import co.mz.schoolCtrl.repository.Estilos;

@Service
public class CadastroEstiloService {

	@Autowired
	private Estilos cervejas;
	
	@Transactional
	public void salvar(Estilo cerveja) {
		
		Optional<Estilo> seeifexistes=cervejas.findByNomeIgnoreCase(cerveja.getNome());
		if(seeifexistes.isPresent()) {
			throw new EstiloHandler("Esse nome ja existe");
		}
		cervejas.saveAndFlush(cerveja);
	}
	

}
