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
public class AlunoHasEndereco {
    private final Aluno al = new Aluno();
    private final Endereco end = new Endereco();
    private String numendereco;
    private int tipo;

    public String getNumendereco() {
        return numendereco;
    }

    public void setNumendereco(String numendereco) {
        this.numendereco = numendereco;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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
    
    public int getIdFormOrigemAluno() {
        return al.getIdFormOrigem();
    }

    public void setIdFormOrigemAluno(int id) {
        al.setIdFormOrigem(id);
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
    
    public int getIdEndereco() {
        return end.getId();
    }

    public void setIdEndereco(int id) {
        end.setId(id);
    }

    public String getCepEndereco() {
        return end.getCep();
    }

    public void setCepEndereco(String cep) {
        end.setCep(cep);
    }

    public String getDescricaoEndereco() {
        return end.getDescricao();
    }

    public void setDescricaoEndereco(String descricao) {
        end.setDescricao(descricao);
    }

    public String getComplementoEndereco() {
        return end.getComplemento();
    }

    public void setComplementoEndereco(String complemento) {
        end.setComplemento(complemento);
    }

    public String getPontoreferenciaEndereco() {
        return end.getPontoreferencia();
    }

    public void setPontoreferenciaEndereco(String pontoreferencia) {
        end.setPontoreferencia(pontoreferencia);
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

    public void setIdCidadeEndereco(int id) {
        end.setIdCidade(id);
    }

    public String getNomeCidadeEndereco() {
        return end.getNomeCidade();
    }

    public void setNomeCidadeEndereco(String nome) {
        end.setNomeCidade(nome);
    }
    
    public int getIdEstadoCidadeEndereco() {
        return end.getIdEstadoCidade();
    }

    public void setIdEstadoCidadeEndereco(int idEstado) {
        end.getIdEstadoCidade();
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
    
    public int getIdRegiaoEstadoCidadeEndereco() {
        return end.getIdRegiaoEstadoCidade();
    }

    public void setIdRegiaoEstadoCidadeEndereco(int id) {
        end.setIdRegiaoEstadoCidade(id);
    }

    public String getNomeRegiaoEstadoCidadeEndereco() {
        return end.getNomeRegiaoEstadoCidade();
    }

    public void setNomeRegiaoEstadoCidadeEndereco(String nome) {
        end.setNomeRegiaoEstadoCidade(nome);
    }
}
