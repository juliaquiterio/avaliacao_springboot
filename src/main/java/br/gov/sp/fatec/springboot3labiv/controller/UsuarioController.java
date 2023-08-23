package br.gov.sp.fatec.springboot3labiv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot3labiv.entity.Usuario;
import br.gov.sp.fatec.springboot3labiv.service.IUsuarioService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin 
public class UsuarioController {

    //o spring reconhece que tem que colocar
    @Autowired
    private IUsuarioService service;

    //quando eu acessar o controller ele acessa pelo map
    @GetMapping
    public List<Usuario> buscarTodos(){
        return service.buscarTodosUsuarios();
        
    }

    //usamos o post para sobrescrever
    @PostMapping
    public Usuario novoUsuario(@RequestBody Usuario usuario){
        return service.novoUsuario(usuario);

    }

    

    //se tiver dois getters tenho que diferenciar
    //{} indica que é uma variavel
    @GetMapping(value = "/{id}")
    public Usuario buscarPorId(@PathVariable("id") Long id){
        return service.buscarPorId(id);

    }
    
}
