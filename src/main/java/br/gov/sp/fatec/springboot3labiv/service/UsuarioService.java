package br.gov.sp.fatec.springboot3labiv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springboot3labiv.entity.Usuario;
import br.gov.sp.fatec.springboot3labiv.repository.UsuarioRepository;

@Service
public class UsuarioService {
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





    // você pode usar isso ou o @Autowired
    //public UsuarioService(UsuarioRepository usuarioRepo){
        //this.usuarioRepo = usuarioRepo;
   // }
    
}
