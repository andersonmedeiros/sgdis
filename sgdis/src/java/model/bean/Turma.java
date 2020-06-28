/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;

/**
 *
 * @author depaula
 */
public class Turma {
    private int id, ano, nTurma;
    private Date dataInicio, dataFim;
    private String turma;
    private final Curso curso = new Curso();
    private final Categoria cat = new Categoria();
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getnTurma() {
        return nTurma;
    }

    public void setnTurma(int nTurma) {
        this.nTurma = nTurma;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
    
    public int getIdCurso() {
        return curso.getId();
    }

    public void setIdCurso(int id) {
        curso.setId(id);
    }

    public String getNomeCurso() {
        return curso.getNome();
    }

    public void setNomeCurso(String nome) {
        curso.setNome(nome);
    }

    public String getSiglaCurso() {
        return curso.getSigla();
    }

    public void setSiglaCurso(String sigla) {
        curso.setSigla(sigla);
    }

    public String getPortariaCurso() {
        return curso.getPortaria();
    }

    public void setPortariaCurso(String portaria) {
        curso.setPortaria(portaria);
    }

    public String getDescricaoCurso() {
        return curso.getDescricao();
    }

    public void setDescricaoCurso(String descricao) {
        curso.setDescricao(descricao);
    }
    
    public int getIdCategoria() {
        return cat.getId();
    }

    public void setIdCategoria(int id) {
        cat.setId(id);
    }

    public String getNomeCategoria() {
        return cat.getNome();
    }

    public void setNomeCategoria(String nome) {
        cat.setNome(nome);
    }

    public String getDescricaoCategoria() {
        return cat.getDescricao();
    }

    public void setDescricaoCategoria(String descricao) {
        cat.setDescricao(descricao);
    }    
}
