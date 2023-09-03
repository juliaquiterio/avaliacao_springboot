package br.gov.sp.fatec.springboot3labiv.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springboot3labiv.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public Optional<Usuario> findByNome(String nome);

    //aqui eu utilizo o nome da classe
    //ele sempre faz catch
    @Query("select u from Usuario u where u.nome = ?1")
    public Optional<Usuario> buscarPeloNome(String nome);

    //use o contains que eh igual ao like
    //quando eh para texto eu uso o ignorecase maiusculo ou minusculo
    public List<Usuario> findByNomeContainsIgnoreCase(String nome);

    @Query("select u from Usuario u where u.nome like %?1%")
    public List<Usuario> buscarPeloNomeParecido(String nome);

    public Optional<Usuario> findByNomeAndSenha(String nome, String senha);

    @Query("select u from Usuario u where u.nome = ?1 and u.senha = ?2")
    public Optional<Usuario> buscarPeloNomeESenha(String nome, String senha);

    //use autorizacao
    //ele faz um join
    //se eu usar uma outra condição ele considera com a tabela na qual eu estou
    public List<Usuario> findByAutorizacoesNome(String nomeAutorizacao);


    //se quero join eu uso o atributo nçao a tabela em si
    @Query("select u from Usuario u join u.autorizacoes a where a.nome = ?1")
    public List<Usuario> buscarPeloNomeAutorizacao(String nomeAutorizacao);
    
}
