//package co.mz.schoolCtrl.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import co.mz.schoolCtrl.model.Usuario;
//import co.mz.schoolCtrl.repository.UsuarioRepository;
//
//@Service
//public class CadastroUsuarioService {
//
//	@Autowired
//	private UsuarioRepository usuarios;
//	
////	@Autowired
////	private PasswordEncoder passwordEncoder;
//	
//	@Transactional
//	public void salvar(Usuario usuario) {
//	//Optional<Usuario> usuarioExistente = usuarios.findByEmail(usuario.getEmail());
////		if (usuarioExistente.isPresent()) {
////		//	throw new EmailUsuarioJaCadastradoException("E-mail já cadastrado");
////		}
////		
////		if (usuario.isNovo() && StringUtils.isEmpty(usuario.getSenha())) {
////		//	throw new SenhaObrigatoriaUsuarioException("Senha é obrigatória para novo usuário");
////		}
////		
////		if (usuario.isNovo()) {
//////			usuario.setSenha(this.passwordEncoder.encode(usuario.getSenha()));
//////			usuario.setConfirmacaoSenha(usuario.getSenha());
////		}
//		
//		usuarios.save(usuario);
//	}
//	
//}
