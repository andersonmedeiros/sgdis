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
public class Comandante {
    private int id;
    private String nome, sobrenome, nomeguerra;
    private final PostoGraduacao pg = new PostoGraduacao();

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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNomeguerra() {
        return nomeguerra;
    }

    public void setNomeguerra(String nomeguerra) {
        this.nomeguerra = nomeguerra;
    }
    
    public int getIdPostoGraduacao() {
        return pg.getId();
    }

    public void setIdPostoGraduacao(int idPostoGraduacao) {
        pg.setId(idPostoGraduacao);
    }

    public String getNomePostoGraduacao() {
        return pg.getNome();
    }

    public void setNomePostoGraduacao(String nomePostoGraduacao) {
        pg.setNome(nomePostoGraduacao);
    }

    public String getAbreviaturaPostoGraduacao() {
        return pg.getAbreviatura();
    }

    public void setAbreviaturaPostoGraduacao(String abreviaturaPostoGraduacao) {
        pg.setAbreviatura(abreviaturaPostoGraduacao);
    }

    public String getCirculohierarquicoPostoGraduacao() {
        return pg.getCirculohierarquico();
    }

    public void setCirculohierarquicoPostoGraduacao(String circulohierarquicoPostoGraduacao) {
        pg.setCirculohierarquico(circulohierarquicoPostoGraduacao);
    }
    
    public int getIdForcaPostoGraduacao() {
        return pg.getIdForca();
    }

    public void setIdForcaPostoGraduacao(int idForca) {
        pg.setIdForca(idForca);
    }

    public String getNomeForcaPostoGraduacao() {
        return pg.getNomeForca();
    }

    public void setNomeForcaPostoGraduacao(String nomeForca) {
        pg.setNomeForca(nomeForca);
    }

    public String getSiglaForcaPostoGraduacao() {
        return pg.getSiglaForca();
    }

    public void setSiglaForcaPostoGraduacao(String siglaForca) {
        pg.setSiglaForca(siglaForca);
    }
    
    public int getIdCategoriaPostoGraduacao() {
        return pg.getIdCategoria();
    }

    public void setIdCategoriaPostoGraduacao(int idCategoria) {
        pg.setIdCategoria(idCategoria);
    }

    public String getNomeCategoriaPostoGraduacao() {
        return pg.getNomeCategoria();
    }

    public void setNomeCategoriaPostoGraduacao(String nomeCategoria) {
        pg.setNomeCategoria(nomeCategoria);
    }

    public String getDescricaoCategoriaPostoGraduacao() {
        return pg.getDescricaoCategoria();
    }

    public void setDescricaoCategoriaPostoGraduacao(String descricaoCategoria) {
        pg.setDescricaoCategoria(descricaoCategoria);
    }
}
