package br.gov.sp.fatec.springboot3labiv.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jog_jogo")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jog_id")
    private Long id;

    @Column(name = "jog_titulo")
    private String titulo;

    @Column(name = "jog_estudio")
    private String estudio;

    @Column(name = "jog_data_hora_lancamento")
    private LocalDateTime data_hora;

    @Column(name = "jog_classificacao")
    private String classificacao;

    @Column(name = "jog_duracao_media")
    private Float duracao;

    public Jogo() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Float getDuracao() {
        return duracao;
    }

    public void setDuracao(Float duracao) {
        this.duracao = duracao;
    }

    public Jogo(Long id, String titulo, String estudio, LocalDateTime data_hora, String classificacao,
            Float duracao) {
        this.id = id;
        this.titulo = titulo;
        this.estudio = estudio;
        this.data_hora = data_hora;
        this.classificacao = classificacao;
        this.duracao = duracao;
    }


    
    

    
}
