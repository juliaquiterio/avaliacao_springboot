package br.gov.sp.fatec.springboot3labiv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springboot3labiv.entity.Trabalho;
import br.gov.sp.fatec.springboot3labiv.repository.TrabalhoRepository;

@Service
public class TrabalhoService implements ITrabalhoService {

     
    @Autowired
    private TrabalhoRepository trabRepo;
    

    @Transactional
    public Trabalho cadastroTrabalho(Trabalho trabalho){
        if(
            trabalho == null||
            trabalho.getTitulo() == null ||
            trabalho.getDescricao() == null||
            trabalho.getGrupo() == null ||
            trabalho.getTitulo().isBlank() ||
            trabalho.getDescricao().isBlank()||
            trabalho.getGrupo().isBlank()||
            trabalho.getNota() == null||
            trabalho.getJustificativa() == null||
            trabalho.getJustificativa().isBlank())
             {
                throw new IllegalArgumentException( "Trabalho com campos vazios ou inválidos, revise novamente.");
            }
        return trabalho;
        }

        public List<Trabalho> buscarTrabalhosPorPalavraChaveENota(String palavraChave, int nota) {
            return trabRepo.findByTituloIsNotNullAndTituloContainingAndNotaGreaterThan(palavraChave, nota);
        }

        //lista todos os registros das tabelas
        public List<Trabalho> buscarTodosRegistros(){
            return trabRepo.findAll();
        }

        //busca pelo id
        public Trabalho buscarPorId(Long id){
            Optional<Trabalho> trabalhoOp = trabRepo.findById(id);
            if(trabalhoOp.isEmpty()){
                throw new IllegalArgumentException("Trabalho não encontrado, tente novamente.");
            }
            return trabalhoOp.get();
        }

    }

