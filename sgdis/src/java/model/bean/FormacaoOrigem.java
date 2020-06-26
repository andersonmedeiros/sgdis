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
public class FormacaoOrigem {
    int id, turma;
    private final EscolaFormacao escForm = new EscolaFormacao();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    public int getIdEscolaFormacao() {
        return escForm.getId();
    }

    public void setIdEscolaFormacao(int id) {
        escForm.setId(id);
    }

    public String getNomeEscolaFormacao() {
        return escForm.getNome();
    }

    public void setNomeEscolaFormacao(String nome) {
        escForm.setNome(nome);
    }

    public String getAbreviaturaEscolaFormacao() {
        return escForm.getAbreviatura();
    }

    public void setAbreviaturaEscolaFormacao(String abreviatura) {
        escForm.setAbreviatura(abreviatura);
    }
    
    public int getIdForcaEscolaFormacao() {
        return escForm.getIdForca();
    }

    public void setIdForcaEscolaFormacao(int idForca) {
        escForm.setIdForca(idForca);
    }

    public String getNomeForcaEscolaFormacao() {
        return escForm.getNomeForca();
    }

    public void setNomeForcaEscolaFormacao(String nomeForca) {
        escForm.setNomeForca(nomeForca);
    }

    public String getSiglaForcaEscolaFormacao() {
        return escForm.getSiglaForca();
    }

    public void setSiglaForcaEscolaFormacao(String siglaForca) {
        escForm.setSiglaForca(siglaForca);
    }
}
