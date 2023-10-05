package br.gov.sp.fatec.springboot3labiv.service;

import java.util.List;

import br.gov.sp.fatec.springboot3labiv.entity.Jogo;


public interface IJogoService {

    public List<Jogo> findByEstudioAndTituloContaining(String estudio, String titulo);

    public Jogo cadastroJogo(Jogo jogo);

    public List<Jogo> buscarTodosRegistros();

}
