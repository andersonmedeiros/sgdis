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
public class Om {
    private int id;
    private String nome, abreviatura, numendereco;
    private final Forca forca = new Forca();
    private final Endereco end = new Endereco();
    private final Comandante cmt = new Comandante();

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

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getNumendereco() {
        return numendereco;
    }

    public void setNumendereco(String numendereco) {
        this.numendereco = numendereco;
    }
    
    public int getIdForca() {
        return forca.getId();
    }

    public void setIdForca(int idForca) {
        forca.setId(idForca);
    }

    public String getNomeForca() {
        return forca.getNome();
    }

    public void setNomeForca(String nomeForca) {
        forca.setNome(nomeForca);
    }

    public String getSiglaForca() {
        return forca.getSigla();
    }

    public void setSiglaForca(String siglaForca) {
        forca.setSigla(siglaForca);
    }
    
    public int getIdEndereco() {
        return end.getId();
    }

    public void setIdEndereco(int idEndereco) {
        end.setId(idEndereco);
    }

    public String getCepEndereco() {
        return end.getCep();
    }

    public void setCepEndereco(String cepEndereco) {
        end.setCep(cepEndereco);
    }

    public String getDescricaoEndereco() {
        return end.getDescricao();
    }

    public void setDescricaoEndereco(String descricaoEndereco) {
        end.setDescricao(descricaoEndereco);
    }

    public String getComplementoEndereco() {
        return end.getComplemento();
    }

    public void setComplementoEndereco(String complementoEndereco) {
        end.setComplemento(complementoEndereco);
    }

    public String getPontoreferenciaEndereco() {
        return end.getPontoreferencia();
    }

    public void setPontoreferenciaEndereco(String pontoreferenciaEndereco) {
        end.setPontoreferencia(pontoreferenciaEndereco);
    }

    public String getBairroEndereco() {
        return end.getBairro();
    }

    public void setBairroEndereco(String bairro) {
        end.setBairro(bairro);
    }
    
    public int getIdCidadeEndereco() {
        return end.getIdCidade();
    }

    public void setIdCidadeEndereco(int idCidade) {
        end.setIdCidade(idCidade);
    }

    public String getNomeCidadeEndereco() {
        return end.getNomeCidade();
    }

    public void setNomeCidadeEndereco(String nomeCidade) {
        end.setNomeCidade(nomeCidade);
    }
    
    public int getIdEstadoCidadeEndereco() {
        return end.getIdEstadoCidade();
    }

    public void setIdEstadoCidadeEndereco(int idEstado) {
        end.setIdEstadoCidade(idEstado);
    }

    public String getNomeEstadoCidadeEndereco() {
        return end.getNomeEstadoCidade();
    }

    public void setNomeEstadoCidadeEndereco(String nomeEstado) {
        end.setNomeEstadoCidade(nomeEstado);
    }

    public String getSiglaEstadoCidadeEndereco() {
        return end.getSiglaEstadoCidade();
    }

    public void setSiglaEstadoCidadeEndereco(String siglaEstado) {
        end.setSiglaEstadoCidade(siglaEstado);
    }
    
    public int getIdCmt() {
        return cmt.getId();
    }

    public void setIdCmt(int idCmt) {
        cmt.setId(idCmt);
    }

    public String getNomeCmt() {
        return cmt.getNome();
    }

    public void setNomeCmt(String nomeCmt) {
        cmt.setNome(nomeCmt);
    }

    public String getSobrenomeCmt() {
        return cmt.getSobrenome();
    }

    public void setSobrenomeCmt(String sobrenomeCmt) {
        cmt.setSobrenome(sobrenomeCmt);
    }

    public String getNomeguerraCmt() {
        return cmt.getNomeguerra();
    }

    public void setNomeguerraCmt(String nomeguerraCmt) {
        cmt.setNomeguerra(nomeguerraCmt);
    }
    
    public int getIdPostoGraduacaoCmt() {
        return cmt.getIdPostoGraduacao();
    }

    public void setIdPostoGraduacaoCmt(int idPostoGraduacao) {
        cmt.setIdPostoGraduacao(idPostoGraduacao);
    }

    public String getNomePostoGraduacaoCmt() {
        return cmt.getNomePostoGraduacao();
    }

    public void setNomePostoGraduacaoCmt(String nomePostoGraduacao) {
        cmt.setNomePostoGraduacao(nomePostoGraduacao);
    }

    public String getAbreviaturaPostoGraduacaoCmt() {
        return cmt.getAbreviaturaPostoGraduacao();
    }

    public void setAbreviaturaPostoGraduacaoCmt(String abreviaturaPostoGraduacao) {
        cmt.setAbreviaturaPostoGraduacao(abreviaturaPostoGraduacao);
    }

    public String getCirculohierarquicoPostoGraduacaoCmt() {
        return cmt.getCirculohierarquicoPostoGraduacao();
    }

    public void setCirculohierarquicoPostoGraduacaoCmt(String circulohierarquicoPostoGraduacao) {
        cmt.setCirculohierarquicoPostoGraduacao(circulohierarquicoPostoGraduacao);
    }
    
    public int getIdForcaPostoGraduacaoCmt() {
        return cmt.getIdForcaPostoGraduacao();
    }

    public void setIdForcaPostoGraduacaoCmt(int idForca) {
        cmt.setIdForcaPostoGraduacao(idForca);
    }

    public String getNomeForcaPostoGraduacaoCmt() {
        return cmt.getNomeForcaPostoGraduacao();
    }

    public void setNomeForcaPostoGraduacaoCmt(String nomeForca) {
        cmt.setNomeForcaPostoGraduacao(nomeForca);
    }

    public String getSiglaForcaPostoGraduacaoCmt() {
        return cmt.getSiglaForcaPostoGraduacao();
    }

    public void setSiglaForcaPostoGraduacaoCmt(String siglaForca) {
        cmt.setSiglaForcaPostoGraduacao(siglaForca);
    }
    
    public int getIdCategoriaPostoGraduacaoCmt() {
        return cmt.getIdCategoriaPostoGraduacao();
    }

    public void setIdCategoriaPostoGraduacaoCmt(int idCategoria) {
        cmt.setIdCategoriaPostoGraduacao(idCategoria);
    }

    public String getNomeCategoriaPostoGraduacaoCmt() {
        return cmt.getNomeCategoriaPostoGraduacao();
    }

    public void setNomeCategoriaPostoGraduacaoCmt(String nomeCategoria) {
        cmt.setNomeCategoriaPostoGraduacao(nomeCategoria);
    }

    public String getDescricaoCategoriaPostoGraduacaoCmt() {
        return cmt.getDescricaoCategoriaPostoGraduacao();
    }

    public void setDescricaoCategoriaPostoGraduacaoCmt(String descricaoCategoria) {
        cmt.setDescricaoCategoriaPostoGraduacao(descricaoCategoria);
    }
}
