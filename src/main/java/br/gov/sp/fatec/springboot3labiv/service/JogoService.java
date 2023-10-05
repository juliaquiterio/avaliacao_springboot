package br.gov.sp.fatec.springboot3labiv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springboot3labiv.entity.Jogo;
import br.gov.sp.fatec.springboot3labiv.repository.JogoRepository;


@Service
public class JogoService implements IJogoService {

     
    @Autowired
    private JogoRepository jogoRepo;
    

    //cadastro
    @Transactional
    public Jogo cadastroJogo(Jogo jogo){
        if(
            jogo == null||
            jogo.getTitulo() == null ||
            jogo.getEstudio() == null||
            jogo.getData_hora() == null||
            jogo.getClassificacao() == null||
            jogo.getEstudio() == null||
            jogo.getTitulo().isBlank() ||
            jogo.getEstudio().isBlank()||
            jogo.getClassificacao().isBlank()
            )
             {
                throw new IllegalArgumentException( "Existem campos vazios ou inválidos, tente novamente.");
            }
        return jogoRepo.save(jogo);
        }


    //busca jogos de um estudio que contenhamuma palavra em seu titulo   
    public List<Jogo> findByEstudioAndTituloContaining(String estudio, String titulo) {
        return jogoRepo.findByEstudioAndTituloContaining(estudio, titulo);
    }

    //lista todos os registros das tabelas
    public List<Jogo> buscarTodosRegistros(){
        return jogoRepo.findAll();
    }


    }

