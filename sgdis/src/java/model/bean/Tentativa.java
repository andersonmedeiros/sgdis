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
public class Tentativa {
    int id, situacao;
    String mtvDeslg, faseDeslg, postoGraduacaoAluno, nomeOM, curso, turma;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public String getMtvDeslg() {
        return mtvDeslg;
    }

    public void setMtvDeslg(String mtvDeslg) {
        this.mtvDeslg = mtvDeslg;
    }

    public String getFaseDeslg() {
        return faseDeslg;
    }

    public void setFaseDeslg(String faseDeslg) {
        this.faseDeslg = faseDeslg;
    }

    public String getPostoGraduacaoAluno() {
        return postoGraduacaoAluno;
    }

    public void setPostoGraduacaoAluno(String postoGraduacaoAluno) {
        this.postoGraduacaoAluno = postoGraduacaoAluno;
    }

    public String getNomeOM() {
        return nomeOM;
    }

    public void setNomeOM(String nomeOM) {
        this.nomeOM = nomeOM;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
