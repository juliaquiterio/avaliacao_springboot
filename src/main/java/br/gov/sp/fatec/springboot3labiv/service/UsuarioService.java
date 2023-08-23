package br.gov.sp.fatec.springboot3labiv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springboot3labiv.entity.Usuario;
import br.gov.sp.fatec.springboot3labiv.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepo;

    public Usuario novoUsuario(Usuario usuario){
        if(usuario == null ||
                usuario.getClass() == null ||
                usuario.getNome().isBlank() ||
                usuario.getSenha() == null ||
                usuario.getSenha().isBlank()) {
            throw new IllegalArgumentException("Usuario com atributos invalidos");
        }
        return usuarioRepo.save(usuario);

    }
    //metodo para buscar todos os usuarios
    public List<Usuario> buscarTodosUsuarios(){
        return usuarioRepo.findAll();
    }

    public Usuario buscarPorId(Long Id){
        Optional<Usuario> usuarioOp = usuarioRepo.findById(Id);
        if(usuarioOp.isEmpty()) {
            throw new IllegalArgumentException("Usuario não encintrado", null);
        }
        return usuarioOp.get();
    }





    // você pode usar isso ou o @Autowired
    //public UsuarioService(UsuarioRepository usuarioRepo){
        //this.usuarioRepo = usuarioRepo;
   // }
    
}
