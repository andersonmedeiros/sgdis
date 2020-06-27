/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author anderson
 */
public class Estado {
    private int id;
    private String nome, sigla;
    private final Regiao r = new Regiao();
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    public int getIdRegiao() {
        return r.getId();
    }

    public void setIdRegiao(int id) {
        r.setId(id);
    }

    public String getNomeRegiao() {
        return r.getNome();
    }

    public void setNomeRegiao(String nome) {
        r.setNome(nome);
    }
}
