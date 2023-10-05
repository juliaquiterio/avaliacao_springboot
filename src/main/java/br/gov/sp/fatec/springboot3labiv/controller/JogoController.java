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

import br.gov.sp.fatec.springboot3labiv.entity.Jogo;
import br.gov.sp.fatec.springboot3labiv.service.IJogoService;



@RestController
@RequestMapping(value  = "/jogo")
@CrossOrigin
public class JogoController{

    @Autowired
    private IJogoService service;

    @GetMapping(value = "/{estudio}/{titulo}")
    public List<Jogo> findByEstudioAndTituloContaining(
        @PathVariable("estudio") String estudio,
        @PathVariable("titulo") String titulo
            ) {
        return service.findByEstudioAndTituloContaining(estudio, titulo);
    }


    @PostMapping
    public Jogo cadastroJogo(@RequestBody Jogo jogo){
        return service.cadastroJogo(jogo);
    }


    @GetMapping
    public List<Jogo> buscarTodosRegistros(){
        return service.buscarTodosRegistros();
    }
    
}
