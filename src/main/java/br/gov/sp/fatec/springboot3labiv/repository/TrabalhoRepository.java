package br.gov.sp.fatec.springboot3labiv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springboot3labiv.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long>{

    /*@Query("select t from trabalho t where t.tra_titulo like %?1% and t.tra_nota > 0")
    public List<Trabalho> findByTrabalhosContainsIgnoreCase(String tra_titulo);*/

    List<Trabalho> findByTituloIsNotNullAndTituloContainingAndNotaGreaterThan(String palavraChave, int tra_nota);

    
}
