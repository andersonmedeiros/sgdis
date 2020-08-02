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
public class MilitarHasGrupoAcesso {
    private final Militar mil = new Militar();
    private final GrupoAcesso grpacesso = new GrupoAcesso();
    
    public String getIdentidadeMilitar() {
        return mil.getIdentidade();
    }

    public void setIdentidadeMilitar(String identidade) {
        mil.setIdentidade(identidade);
    }

    public String getNomeMilitar() {
        return mil.getNome();
    }

    public void setNomeMilitar(String nome) {
        mil.setNome(nome);
    }

    public String getSobrenomeMilitar() {
        return mil.getSobrenome();
    }

    public void setSobrenomeMilitar(String sobrenome) {
        mil.setSobrenome(sobrenome);
    }

    public String getNomeguerraMilitar() {
        return mil.getNomeguerra();
    }

    public void setNomeguerraMilitar(String nomeguerra) {
        mil.setNomeguerra(nomeguerra);
    }

    public String getSenhaMilitar() {
        return mil.getSenha();
    }

    public void setSenhaMilitar(String senha) {
        mil.setSenha(senha);
    }

    public int getNgsMilitar() {
        return mil.getNgs();
    }

    public void setNgsMilitar(int ngs) {
        mil.setNgs(ngs);
    }
    
    public int getIdPostoGraduacaoMilitar() {
        return mil.getIdPostoGraduacao();
    }

    public void setIdPostoGraduacaoMilitar(int idPostoGraduacao) {
        mil.setIdPostoGraduacao(idPostoGraduacao);
    }

    public String getNomePostoGraduacaoMilitar() {
        return mil.getNomePostoGraduacao();
    }

    public void setNomePostoGraduacaoMilitar(String nomePostoGraduacao) {
        mil.setNomePostoGraduacao(nomePostoGraduacao);
    }

    public String getAbreviaturaPostoGraduacaoMilitar() {
        return mil.getAbreviaturaPostoGraduacao();
    }

    public void setAbreviaturaPostoGraduacaoMilitar(String abreviaturaPostoGraduacao) {
        mil.setAbreviaturaPostoGraduacao(abreviaturaPostoGraduacao);
    }

    public String getCirculohierarquicoPostoGraduacaoMilitar() {
        return mil.getCirculohierarquicoPostoGraduacao();
    }

    public void setCirculohierarquicoPostoGraduacaoMilitar(String circulohierarquicoPostoGraduacao) {
        mil.setCirculohierarquicoPostoGraduacao(circulohierarquicoPostoGraduacao);
    }
    
    public int getIdForcaPostoGraduacaoMilitar() {
        return mil.getIdForcaPostoGraduacao();
    }

    public void setIdForcaPostoGraduacaoMilitar(int idForca) {
        mil.setIdForcaPostoGraduacao(idForca);
    }

    public String getNomeForcaPostoGraduacaoMilitar() {
        return mil.getNomeForcaPostoGraduacao();
    }

    public void setNomeForcaPostoGraduacaoMilitar(String nomeForca) {
        mil.setNomeForcaPostoGraduacao(nomeForca);
    }

    public String getSiglaForcaPostoGraduacaoMilitar() {
        return mil.getSiglaForcaPostoGraduacao();
    }

    public void setSiglaForcaPostoGraduacaoMilitar(String siglaForca) {
        mil.setSiglaForcaPostoGraduacao(siglaForca);
    }
    
    public int getIdTipoForcaPostoGraduacaoMilitar() {
        return mil.getIdTipoForcaPostoGraduacao();
    }

    public void setIdTipoForcaPostoGraduacaoMilitar(int id) {
        mil.setIdTipoForcaPostoGraduacao(id);
    }

    public String getNomeTipoForcaPostoGraduacaoMilitar() {
        return mil.getNomeTipoForcaPostoGraduacao();
    }

    public void setNomeTipoForcaPostoGraduacaoMilitar(String nome) {
        mil.setNomeTipoForcaPostoGraduacao(nome);
    }
    
    public int getIdCategoriaPostoGraduacaoMilitar() {
        return mil.getIdCategoriaPostoGraduacao();
    }

    public void setIdCategoriaPostoGraduacaoMilitar(int idCategoria) {
        mil.setIdCategoriaPostoGraduacao(idCategoria);
    }

    public String getNomeCategoriaPostoGraduacaoMilitar() {
        return mil.getNomeCategoriaPostoGraduacao();
    }

    public void setNomeCategoriaPostoGraduacaoMilitar(String nomeCategoria) {
        mil.setNomeCategoriaPostoGraduacao(nomeCategoria);
    }

    public String getDescricaoCategoriaPostoGraduacaoMilitar() {
        return mil.getDescricaoCategoriaPostoGraduacao();
    }

    public void setDescricaoCategoriaPostoGraduacaoMilitar(String descricaoCategoria) {
        mil.setDescricaoCategoriaPostoGraduacao(descricaoCategoria);
    }
    
    public int getIdGrpAcesso() {
        return grpacesso.getId();
    }

    public void setIdGrpAcesso(int id) {
        grpacesso.setId(id);
    }

    public String getNomeGrpAcesso() {
        return grpacesso.getNome();
    }

    public void setNomeGrpAcesso(String nome) {
        grpacesso.setNome(nome);
    }
}
