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
public class AlunoServiuOM {
    private final Aluno al = new Aluno();
    private final Om om = new Om();
    private Date datainicio, datafim;
    private String ultfuncao1, ultfuncao2, ultfuncao3;

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        this.datafim = datafim;
    }

    public String getUltfuncao1() {
        return ultfuncao1;
    }

    public void setUltfuncao1(String ultfuncao1) {
        this.ultfuncao1 = ultfuncao1;
    }

    public String getUltfuncao2() {
        return ultfuncao2;
    }

    public void setUltfuncao2(String ultfuncao2) {
        this.ultfuncao2 = ultfuncao2;
    }

    public String getUltfuncao3() {
        return ultfuncao3;
    }

    public void setUltfuncao3(String ultfuncao3) {
        this.ultfuncao3 = ultfuncao3;
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
    
    public int getIdOM() {
        return om.getId();
    }

    public void setIdOM(int id) {
        om.setId(id);
    }

    public String getNomeOM() {
        return om.getNome();
    }

    public void setNomeOM(String nome) {
        om.setNome(nome);
    }

    public String getAbreviaturaOM() {
        return om.getAbreviatura();
    }

    public void setAbreviaturaOM(String abreviatura) {
        om.setAbreviatura(abreviatura);
    }

    public String getNumenderecoOM() {
        return om.getNumendereco();
    }

    public void setNumenderecoOM(String numendereco) {
        om.setNumendereco(numendereco);
    }
    
    public int getIdForcaOM() {
        return om.getIdForca();
    }

    public void setIdForcaOM(int idForca) {
        om.setIdForca(idForca);
    }

    public String getNomeForcaOM() {
        return om.getNomeForca();
    }

    public void setNomeForcaOM(String nomeForca) {
        om.setNomeForca(nomeForca);
    }

    public String getSiglaForcaOM() {
        return om.getSiglaForca();
    }

    public void setSiglaForcaOM(String siglaForca) {
        om.setSiglaForca(siglaForca);
    }
    
    public int getIdTipoForcaOM() {
        return om.getIdTipoForca();
    }

    public void setIdTipoForcaOM(int id) {
        om.setIdTipoForca(id);
    }

    public String getNomeTipoForcaOM() {
        return om.getNomeTipoForca();
    }

    public void setNomeTipoForcaOM(String nome) {
        om.setNomeTipoForca(nome);
    }
    
    public int getIdEstadoOM() {
        return om.getIdEstado();
    }

    public void setIdEstadoOM(int id) {
        om.setIdEstado(id);
    }

    public String getNomeEstadoOM() {
        return om.getNomeEstado();
    }

    public void setNomeEstadoOM(String nome) {
        om.setNomeEstado(nome);
    }

    public String getSiglaEstadoOM() {
        return om.getSiglaEstado();
    }

    public void setSiglaEstadoOM(String sigla) {
        om.setSiglaEstado(sigla);
    }
    
    public int getIdRegiaoEstadoOM() {
        return om.getIdRegiaoEstado();
    }

    public void setIdRegiaoEstadoOM(int id) {
        om.setIdRegiaoEstado(id);
    }

    public String getNomeRegiaoEstadoOM() {
        return om.getNomeRegiaoEstado();
    }

    public void setNomeRegiaoEstadoOM(String nome) {
        om.setNomeRegiaoEstado(nome);
    }
    
    public int getIdEnderecoOM() {
        return om.getIdEndereco();
    }

    public void setIdEnderecoOM(int idEndereco) {
        om.setIdEndereco(idEndereco);
    }

    public String getCepEnderecoOM() {
        return om.getCepEndereco();
    }

    public void setCepEnderecoOM(String cepEndereco) {
        om.setCepEndereco(cepEndereco);
    }

    public String getDescricaoEnderecoOM() {
        return om.getDescricaoEndereco();
    }

    public void setDescricaoEnderecoOM(String descricaoEndereco) {
        om.setDescricaoEndereco(descricaoEndereco);
    }

    public String getComplementoEnderecoOM() {
        return om.getComplementoEndereco();
    }

    public void setComplementoEnderecoOM(String complementoEndereco) {
        om.setComplementoEndereco(complementoEndereco);
    }

    public String getPontoreferenciaEnderecoOM() {
        return om.getPontoreferenciaEndereco();
    }

    public void setPontoreferenciaEnderecoOM(String pontoreferenciaEndereco) {
        om.setPontoreferenciaEndereco(pontoreferenciaEndereco);
    }

    public String getBairroEnderecoOM() {
        return om.getBairroEndereco();
    }

    public void setBairroEnderecoOM(String bairro) {
        om.setBairroEndereco(bairro);
    }
    
    public int getIdCidadeEnderecoOM() {
        return om.getIdCidadeEndereco();
    }

    public void setIdCidadeEnderecoOM(int idCidade) {
        om.setIdCidadeEndereco(idCidade);
    }

    public String getNomeCidadeEnderecoOM() {
        return om.getNomeCidadeEndereco();
    }

    public void setNomeCidadeEnderecoOM(String nomeCidade) {
        om.setNomeCidadeEndereco(nomeCidade);
    }
    
    public int getIdEstadoCidadeEnderecoOM() {
        return om.getIdEstadoCidadeEndereco();
    }

    public void setIdEstadoCidadeEnderecoOM(int idEstado) {
        om.setIdEstadoCidadeEndereco(idEstado);
    }

    public String getNomeEstadoCidadeEnderecoOM() {
        return om.getNomeEstadoCidadeEndereco();
    }

    public void setNomeEstadoCidadeEnderecoOM(String nomeEstado) {
        om.setNomeEstadoCidadeEndereco(nomeEstado);
    }

    public String getSiglaEstadoCidadeEnderecoOM() {
        return om.getSiglaEstadoCidadeEndereco();
    }

    public void setSiglaEstadoCidadeEnderecoOM(String siglaEstado) {
        om.setSiglaEstadoCidadeEndereco(siglaEstado);
    }
    
    public int getIdRegiaoEstadoCidadeEnderecoOM() {
        return om.getIdRegiaoEstadoCidadeEndereco();
    }

    public void setIdRegiaoEstadoCidadeEnderecoOM(int id) {
        om.setIdRegiaoEstadoCidadeEndereco(id);
    }

    public String getNomeRegiaoEstadoCidadeEnderecoOM() {
        return om.getNomeRegiaoEstadoCidadeEndereco();
    }

    public void setNomeRegiaoEstadoCidadeEnderecoOM(String nome) {
        om.setNomeRegiaoEstadoCidadeEndereco(nome);
    }
}
