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
public class Fone {
    private final Aluno al = new Aluno();
    private final Om om = new Om();
    private final Referencia ref = new Referencia();
    private final Conjuge conjuge = new Conjuge();    
    private int id;
    private String ddd, numero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
    
    public String getCpfReferencia() {
        return ref.getCpf();
    }

    public void setCpfReferencia(String cpf) {
        ref.setCpf(cpf);
    }

    public String getNomeReferencia() {
        return ref.getNome();
    }

    public void setNomeReferencia(String nome) {
        ref.setNome(nome);
    }

    public String getSobrenomeReferencia() {
        return ref.getSobrenome();
    }

    public void setSobrenomeReferencia(String sobrenome) {
        ref.setSobrenome(sobrenome);
    }

    public String getEmailReferencia() {
        return ref.getEmail();
    }

    public void setEmailReferencia(String email) {
        ref.setEmail(email);
    }
    
    public int getIdGrauParentescoReferencia() {
        return ref.getIdGrauParentesco();
    }

    public void setIdGrauParentescoReferencia(int id) {
        ref.setIdGrauParentesco(id);
    }

    public String getNomeGrauParentescoReferencia() {
        return ref.getNomeGrauParentesco();
    }

    public void setNomeGrauParentescoReferencia(String nome) {
        ref.setNomeGrauParentesco(nome);
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
    
    public String getCpfConjuge() {
        return conjuge.getCpf();
    }

    public void setCpfConjuge(String cpf) {
        conjuge.setCpf(cpf);
    }

    public String getNomeConjuge() {
        return conjuge.getNome();
    }

    public void setNomeConjuge(String nome) {
        conjuge.setNome(nome);
    }

    public String getSobrenomeConjuge() {
        return conjuge.getSobrenome();
    }

    public void setSobrenomeConjuge(String sobrenome) {
        conjuge.setSobrenome(sobrenome);
    }

    public String getEmailConjuge() {
        return conjuge.getEmail();
    }

    public void setEmailConjuge(String email) {
        conjuge.setEmail(email);
    }
    
    public String getIdentidadeAlunoConjuge() {
        return conjuge.getIdentidadeAluno();
    }

    public void setIdentidadeAlunoConjuge(String identidade) {
        conjuge.setIdentidadeAluno(identidade);
    }

    public String getNomeAlunoConjuge() {
        return conjuge.getNomeAluno();
    }

    public void setNomeAlunoConjuge(String nome) {
        conjuge.setNomeAluno(nome);
    }

    public String getSobrenomeAlunoConjuge() {
        return conjuge.getSobrenomeAluno();
    }

    public void setSobrenomeAlunoConjuge(String sobrenome) {
        conjuge.setSobrenomeAluno(sobrenome);
    }

    public String getNomeguerraAlunoConjuge() {
        return conjuge.getNomeguerraAluno();
    }

    public void setNomeguerraAlunoConjuge(String nomeguerra) {
        conjuge.setNomeguerraAluno(nomeguerra);
    }

    public String getPreccpAlunoConjuge() {
        return conjuge.getPreccpAluno();
    }

    public void setPreccpAlunoConjuge(String preccp) {
        conjuge.setPreccpAluno(preccp);
    }

    public String getCpAlunoConjuge() {
        return conjuge.getCpAluno();
    }

    public void setCpAlunoConjuge(String cp) {
        conjuge.setCpAluno(cp);
    }

    public String getCpfAlunoConjuge() {
        return conjuge.getCpfAluno();
    }

    public void setCpfAlunoConjuge(String cpf) {
        conjuge.setCpfAluno(cpf);
    }

    public String getTsConjuge() {
        return conjuge.getTsAluno();
    }

    public void setTsAlunoConjugeConjuge(String ts) {
        conjuge.setTsAluno(ts);
    }

    public int getFtrhAlunoConjuge() {
        return conjuge.getFtrhAluno();
    }

    public void setFtrhAlunoConjuge(int ftrh) {
        conjuge.setFtrhAluno(ftrh);
    }

    public String getPaiAlunoConjuge() {
        return conjuge.getPaiAluno();
    }

    public void setPaiAlunoConjuge(String pai) {
        conjuge.setPaiAluno(pai);
    }

    public String getMaeAlunoConjuge() {
        return conjuge.getMaeAluno();
    }

    public void setMaeAlunoConjuge(String mae) {
        conjuge.setMaeAluno(mae);
    }

    public String getEmailAlunoConjuge() {
        return conjuge.getEmailAluno();
    }

    public void setEmailAlunoConjuge(String email) {
        conjuge.setEmailAluno(email);
    }

    public int getFumanteAlunoConjuge() {
        return conjuge.getFumanteAluno();
    }

    public void setFumanteAlunoConjuge(int fumante) {
        conjuge.setFumanteAluno(fumante);
    }

    public String getSexoAlunoConjuge() {
        return conjuge.getSexoAluno();
    }

    public void setSexoAlunoConjuge(String sexo) {
        conjuge.setSexoAluno(sexo);
    }

    public String getUltfuncao1AlunoConjuge() {
        return conjuge.getUltfuncao1Aluno();
    }

    public void setUltfuncao1AlunoConjuge(String ultfuncao1) {
        conjuge.setUltfuncao1Aluno(ultfuncao1);
    }

    public String getUltfuncao2AlunoConjuge() {
        return conjuge.getUltfuncao2Aluno();
    }

    public void setUltfuncao2AlunoConjuge(String ultfuncao2) {
        conjuge.setUltfuncao2Aluno(ultfuncao2);
    }

    public String getUltfuncao3AlunoConjuge() {
        return conjuge.getUltfuncao3Aluno();
    }

    public void setUltfuncao3AlunoConjuge(String ultfuncao3) {
        conjuge.setUltfuncao3Aluno(ultfuncao3);
    }

    public int getSituacaoAlunoConjuge() {
        return conjuge.getSituacaoAluno();
    }

    public void setSituacaoAlunoConjuge(int situacao) {
        conjuge.setSituacaoAluno(situacao);
    }

    public Date getDataNascimentoAlunoConjuge() {
        return conjuge.getDataNascimentoAluno();
    }

    public void setDataNascimentoAlunoConjuge(Date dataNascimento) {
        conjuge.setDataNascimentoAluno(dataNascimento);
    }

    public Date getUltDataPracaAlunoConjuge() {
        return conjuge.getUltDataPracaAluno();
    }

    public void setUltDataPracaAlunoConjuge(Date ultDataPraca) {
        conjuge.setUltDataPracaAluno(ultDataPraca);
    }

    public int getIdPostoGraduacaoAlunoConjuge() {
        return conjuge.getIdPostoGraduacaoAluno();
    }

    public void setIdPostoGraduacaoAlunoConjuge(int idPostoGraduacao) {
        conjuge.setIdPostoGraduacaoAluno(idPostoGraduacao);
    }
    
    public int getIdQasQmsAlunoConjuge() {
        return conjuge.getIdQasQmsAluno();
    }

    public void setIdQasQmsAlunoConjuge(int id) {
        conjuge.setIdQasQmsAluno(id);
    }
    
    public int getIdCmtAlunoConjuge() {
        return conjuge.getIdCmtAluno();
    }

    public void setIdCmtAlunoConjuge(int id) {
        conjuge.setIdCmtAluno(id);
    }
    
    public int getIdNatCidadeAlunoConjuge() {
        return conjuge.getIdNatCidadeAluno();
    }

    public void setIdNatCidadeAlunoConjuge(int id) {
        conjuge.setIdNatCidadeAluno(id);
    }
    
    public int getIdEstadoCivilAlunoConjuge() {
        return conjuge.getIdEstadoCivilAluno();
    }

    public void setIdEstadoCivilAlunoConjuge(int id) {
        conjuge.setIdEstadoCivilAluno(id);
    }
    
    public int getIdOMAlunoConjuge() {
        return conjuge.getIdOMAluno();
    }

    public void setIdOMAlunoConjuge(int id) {
        conjuge.setIdOMAluno(id);
    }
    
    public int getIdComportamentoAlunoConjuge() {
        return conjuge.getIdComportamentoAluno();
    }

    public void setIdComportamentoAlunoConjuge(int id) {
        conjuge.setIdComportamentoAluno(id);
    }
    
    public int getIdChImtoAlunoConjuge() {
        return conjuge.getIdChImtoAluno();
    }

    public void setIdChImtoAlunoConjuge(int id) {
        conjuge.setIdChImtoAluno(id);
    }
    
    public int getIdFormOrigemAlunoConjuge() {
        return conjuge.getIdFormOrigemAluno();
    }

    public void setIdFormOrigemAlunoConjuge(int id) {
        conjuge.setIdFormOrigemAluno(id);
    }
    
    public int getIdTafAlunoConjuge() {
        return conjuge.getIdTafAluno();
    }

    public void setIdTafAlunoConjuge(int id) {
        conjuge.setIdTafAluno(id);
    }
    
    public int getIdPromocaoAlunoConjuge() {
        return conjuge.getIdPromocaoAluno();
    }

    public void setIdPromocaoAlunoConjuge(int id) {
        conjuge.setIdPromocaoAluno(id);
    }
    
    public int getIdPreparacaoAlnoConjuge() {
        return conjuge.getIdPreparacaoAlno();
    }

    public void setIdPreparacaoAlunoConjuge(int id) {
        conjuge.setIdPreparacaoAluno(id);
    }
    
    public int getIdUniformeAlunoConjuge() {
        return conjuge.getIdUniformeAluno();
    }

    public void setIdUniformeAlunoConjuge(int id) {
        conjuge.setIdUniformeAluno(id);
    }
}
