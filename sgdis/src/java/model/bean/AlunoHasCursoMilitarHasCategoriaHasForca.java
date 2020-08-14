/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;

/**
 *
 * @author anderson
 */
public class AlunoHasCursoMilitarHasCategoriaHasForca {
    private final Aluno al = new Aluno();
    private final CursoMilitar cursomilitar = new CursoMilitar();
    private final Categoria cat = new Categoria();
    private final Forca forca = new Forca();
    private int anoconclusao;

    public int getAnoconclusao() {
        return anoconclusao;
    }

    public void setAnoconclusao(int anoconclusao) {
        this.anoconclusao = anoconclusao;
    }
    
    public String getIdentidadeAluno() {
        return al.getIdentidade();
    }

    public void setIdentidadeAluno(String identidade) {
        al.setIdentidade(identidade);
    }

    public String getNomeAluno() {
        return al.getNome();
    }

    public void setNomeAluno(String nome) {
        al.setNome(nome);
    }

    public String getSobrenomeAluno() {
        return al.getSobrenome();
    }

    public void setSobrenomeAluno(String sobrenome) {
        al.setSobrenome(sobrenome);
    }

    public String getNomeguerraAluno() {
        return al.getNomeguerra();
    }

    public void setNomeguerraAluno(String nomeguerra) {
        al.setNomeguerra(nomeguerra);
    }

    public String getPreccpAluno() {
        return al.getPreccp();
    }

    public void setPreccpAluno(String preccp) {
        al.setPreccp(preccp);
    }

    public String getCpAluno() {
        return al.getCp();
    }

    public void setCpAluno(String cp) {
        al.setCp(cp);
    }

    public String getCpfAluno() {
        return al.getCpf();
    }

    public void setCpfAluno(String cpf) {
        al.setCpf(cpf);
    }

    public String getTs() {
        return al.getTs();
    }

    public void setTsAluno(String ts) {
        al.setTs(ts);
    }

    public int getFtrhAluno() {
        return al.getFtrh();
    }

    public void setFtrhAluno(int ftrh) {
        al.setFtrh(ftrh);
    }

    public String getPaiAluno() {
        return al.getPai();
    }

    public void setPaiAluno(String pai) {
        al.setPai(pai);
    }

    public String getMaeAluno() {
        return al.getMae();
    }

    public void setMaeAluno(String mae) {
        al.setMae(mae);
    }

    public String getEmailAluno() {
        return al.getEmail();
    }

    public void setEmailAluno(String email) {
        al.setEmail(email);
    }

    public int getFumanteAluno() {
        return al.getFumante();
    }

    public void setFumanteAluno(int fumante) {
        al.setFumante(fumante);
    }

    public String getSexoAluno() {
        return al.getSexo();
    }

    public void setSexoAluno(String sexo) {
        al.setSexo(sexo);
    }

    public String getUltfuncao1Aluno() {
        return al.getUltfuncao1();
    }

    public void setUltfuncao1Aluno(String ultfuncao1) {
        al.setUltfuncao1(ultfuncao1);
    }

    public String getUltfuncao2Aluno() {
        return al.getUltfuncao2();
    }

    public void setUltfuncao2Aluno(String ultfuncao2) {
        al.setUltfuncao2(ultfuncao2);
    }

    public String getUltfuncao3Aluno() {
        return al.getUltfuncao3();
    }

    public void setUltfuncao3Aluno(String ultfuncao3) {
        al.setUltfuncao3(ultfuncao3);
    }

    public int getSituacaoAluno() {
        return al.getSituacao();
    }

    public void setSituacaoAluno(int situacao) {
        al.setSituacao(situacao);
    }

    public Date getDataNascimentoAluno() {
        return al.getDataNascimento();
    }

    public void setDataNascimentoAluno(Date dataNascimento) {
        al.setDataNascimento(dataNascimento);
    }

    public Date getUltDataPracaAluno() {
        return al.getUltDataPraca();
    }

    public void setUltDataPracaAluno(Date ultDataPraca) {
        al.setUltDataPraca(ultDataPraca);
    }

    public int getIdPostoGraduacaoAluno() {
        return al.getIdPostoGraduacao();
    }

    public void setIdPostoGraduacaoAluno(int idPostoGraduacao) {
        al.setIdPostoGraduacao(idPostoGraduacao);
    }
    
    public int getIdQasQmsAluno() {
        return al.getIdQasQms();
    }

    public void setIdQasQmsAluno(int id) {
        al.setIdQasQms(id);
    }
    
    public int getIdCmtAluno() {
        return al.getIdCmt();
    }

    public void setIdCmtAluno(int id) {
        al.setIdCmt(id);
    }
    
    public int getIdNatCidadeAluno() {
        return al.getIdNatCidade();
    }

    public void setIdNatCidadeAluno(int id) {
        al.setIdNatCidade(id);
    }
    
    public int getIdEstadoCivilAluno() {
        return al.getIdEstadoCivil();
    }

    public void setIdEstadoCivilAluno(int id) {
        al.setIdEstadoCivil(id);
    }
    
    public int getIdOMAluno() {
        return al.getIdOM();
    }

    public void setIdOMAluno(int id) {
        al.setIdOM(id);
    }
    
    public int getIdComportamentoAluno() {
        return al.getIdComportamento();
    }

    public void setIdComportamentoAluno(int id) {
        al.setIdComportamento(id);
    }
    
    public int getIdChImtoAluno() {
        return al.getIdChImto();
    }

    public void setIdChImtoAluno(int id) {
        al.setIdChImto(id);
    }
        
    public int getIdTafAluno() {
        return al.getIdTaf();
    }

    public void setIdTafAluno(int id) {
        al.setIdTaf(id);
    }
    
    public int getIdPromocaoAluno() {
        return al.getIdPromocao();
    }

    public void setIdPromocaoAluno(int id) {
        al.setIdPromocao(id);
    }
    
    public int getIdPreparacaoAlno() {
        return al.getIdPreparacao();
    }

    public void setIdPreparacaoAluno(int id) {
        al.setIdPreparacao(id);
    }
    
    public int getIdUniformeAluno() {
        return al.getIdUniforme();
    }

    public void setIdUniformeAluno(int id) {
        al.setIdUniforme(id);
    }
    
    public int getEasAluno() {
        return al.getEas();
    }

    public void setEasAluno(int eas) {
        al.setEas(eas);
    }
    
    public int getIdCursoMilitar() {
        return cursomilitar.getId();
    }

    public void setIdCursoMilitar(int idCursoMilitar) {
        cursomilitar.setId(idCursoMilitar);
    }

    public int getTipoCursoMilitar() {
        return cursomilitar.getTipo();
    }

    public void setTipoCursoMilitar(int tipoCursoMilitar) {
        cursomilitar.setTipo(tipoCursoMilitar);
    }

    public String getNomeCursoMilitar() {
        return cursomilitar.getNome();
    }

    public void setNomeCursoMilitar(String nomeCursoMilitar) {
        cursomilitar.setNome(nomeCursoMilitar);
    }
    
    public int getIdCategoria() {
        return cat.getId();
    }

    public void setIdCategoria(int idCategoria) {
        cat.setId(idCategoria);
    }

    public String getNomeCategoria() {
        return cat.getNome();
    }

    public void setNomeCategoria(String nomeCategoria) {
        cat.setNome(nomeCategoria);
    }

    public String getDescricaoCategoria() {
        return cat.getDescricao();
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        cat.setDescricao(descricaoCategoria);
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
    
    public int getIdTipoForca() {
        return forca.getIdTipoForca();
    }

    public void setIdTipoForca(int id) {
        forca.setIdTipoForca(id);
    }

    public String getNomeTipoForca() {
        return forca.getNomeTipoForca();
    }

    public void setNomeTipoForca(String nome) {
        forca.setNomeTipoForca(nome);
    }
    
}
