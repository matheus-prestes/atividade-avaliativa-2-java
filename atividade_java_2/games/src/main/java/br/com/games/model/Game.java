package br.com.games.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idGame;
    private String nome;    
    private String plataforma;
    private String horas;
    private String trofeus;

    public long getIdGame() {
        return idGame;
    }

    public void setIdGame(long idGame) {
        this.idGame = idGame;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getTrofeus() {
        return trofeus;
    }

    public void setTrofeus(String trofeus) {
        this.trofeus = trofeus;
    }
}
