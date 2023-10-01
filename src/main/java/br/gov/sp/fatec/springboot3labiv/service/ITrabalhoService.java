package br.gov.sp.fatec.springboot3labiv.service;

import java.util.List;

import br.gov.sp.fatec.springboot3labiv.entity.Trabalho;

public interface ITrabalhoService {

    public List<Trabalho> buscarTrabalhosPorPalavraChaveENota(String palavraChave, int nota);

    public Trabalho cadastroTrabalho (Trabalho trabalho);

    public List<Trabalho> buscarTodosRegistros();

    public Trabalho buscarPorId(Long id);
}
