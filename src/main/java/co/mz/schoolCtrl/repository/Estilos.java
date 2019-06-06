package co.mz.schoolCtrl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.mz.schoolCtrl.model.Estilo;

@Repository
public interface Estilos extends JpaRepository<Estilo, Long> {

	
	
	public Optional< Estilo> findByNomeIgnoreCase(String nome);
}
