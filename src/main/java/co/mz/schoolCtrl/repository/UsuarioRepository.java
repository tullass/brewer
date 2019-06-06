package co.mz.schoolCtrl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.mz.schoolCtrl.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);

}
