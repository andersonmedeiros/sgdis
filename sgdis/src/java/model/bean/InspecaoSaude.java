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
public class InspecaoSaude {
    int id, situacao;
    
    private final TurmaHasAluno turmaaluno = new TurmaHasAluno();
    private final Militar milAvaliador = new Militar();

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
    
    public int getIdTurma(){
        return turmaaluno.getIdTurma();
    }

    public void setIdTurma(int idTurma){
        turmaaluno.setIdTurma(idTurma);
    }
    
    public int getAnoTurma(){
        return turmaaluno.getAnoTurma();
    }   
    
    public void setAnoTurma(int anoTurma){
        turmaaluno.setAnoTurma(anoTurma);
    }
    
    public int getnTurma(){
        return turmaaluno.getnTurma();
    }   
    
    public void setnTurma(int nTurma){
        turmaaluno.setnTurma(nTurma);
    }
    
    public Date getDataInicioTurma() {
        return turmaaluno.getDataInicioTurma();
    }
    
    public void setDateInicioTurma(Date dataInicio){
        turmaaluno.setDataInicioTurma(dataInicio);
    }
    
    public Date getDataFimTurma() {
        return turmaaluno.getDataFimTurma();
    }
    
    public void setDateFimTurma(Date dataFim){
        turmaaluno.setDataFimTurma(dataFim);
    }
    
    public String getTurma(){
        return turmaaluno.getTurma();
    }
    
    public void setTurma(String nometurmaaluno){
        turmaaluno.setTurma(nometurmaaluno);
    }
    
    public int getIdCursoTurma() {
        return turmaaluno.getIdCursoTurma();
    }

    public void setIdCursoTurma(int id) {
        turmaaluno.setIdCursoTurma(id);
    }

    public String getNomeCursoTurma() {
        return turmaaluno.getNomeCursoTurma();
    }

    public void setNomeCursoTurma(String nome) {
        turmaaluno.setNomeCursoTurma(nome);
    }

    public String getSiglaCursoTurma() {
        return turmaaluno.getSiglaCursoTurma();
    }

    public void setSiglaCursoTurma(String sigla) {
        turmaaluno.setSiglaCursoTurma(sigla);
    }

    public String getPortariaCursoTurma() {
        return turmaaluno.getPortariaCursoTurma();
    }

    public void setPortariaCursoTurma(String portaria) {
        turmaaluno.setPortariaCursoTurma(portaria);
    }

    public String getDescricaoCursoTurma() {
        return turmaaluno.getDescricaoCursoTurma();
    }

    public void setDescricaoCursoTurma(String descricao) {
        turmaaluno.setDescricaoCursoTurma(descricao);
    }
    
    public int getIdCategoriaTurma() {
        return turmaaluno.getIdCategoriaTurma();
    }

    public void setIdCategoriaTurma(int id) {
        turmaaluno.setIdCategoriaTurma(id);
    }

    public String getNomeCategoriaTurma() {
        return turmaaluno.getNomeCategoriaTurma();
    }

    public void setNomeCategoriaTurma(String nome) {
        turmaaluno.setNomeCategoriaTurma(nome);
    }

    public String getDescricaoCategoriaTurma() {
        return turmaaluno.getDescricaoCategoriaTurma();
    }

    public void setDescricaoCategoriaTurma(String descricao) {
        turmaaluno.setDescricaoCategoriaTurma(descricao);
    }    
    
    public int getIdTentativa() {
        return turmaaluno.getIdTentativa();
    }

    public void setIdTentativa(int idTentativa){
        turmaaluno.setIdTentativa(idTentativa);
    }

    public String getMtvDeslgTentativa() {
        return turmaaluno.getMtvDeslgTentativa();
    }

    public void setMtvDeslgTentativa(String mtvDeslg) {
        turmaaluno.setMtvDeslgTentativa(mtvDeslg);
    }

    public String getFaseDeslgTentativa() {
        return turmaaluno.getFaseDeslgTentativa();
    }

    public void setFaseDeslgTentativa(String faseDeslg) {
        turmaaluno.setFaseDeslgTentativa(faseDeslg);
    }    

    public String getIdentidadeAluno() {
        return turmaaluno.getIdentidadeAluno();
    }

    public void setIdentidadeAluno(String identidade) {
        turmaaluno.setIdentidadeAluno(identidade);
    }

    public String getNomeAluno() {
        return turmaaluno.getNomeAluno();
    }

    public void setNomeAluno(String nome) {
        turmaaluno.setNomeAluno(nome);
    }

    public String getSobrenomeAluno() {
        return turmaaluno.getSobrenomeAluno();
    }

    public void setSobrenomeAluno(String sobrenome) {
        turmaaluno.setSobrenomeAluno(sobrenome);
    }

    public String getNomeguerraAluno() {
        return turmaaluno.getNomeguerraAluno();
    }

    public void setNomeguerraAluno(String nomeguerra) {
        turmaaluno.setNomeguerraAluno(nomeguerra);
    }

    public String getPreccpAluno() {
        return turmaaluno.getPreccpAluno();
    }

    public void setPreccpAluno(String preccp) {
        turmaaluno.setPreccpAluno(preccp);
    }

    public String getCpAluno() {
        return turmaaluno.getCpAluno();
    }

    public void setCpAluno(String cp) {
        turmaaluno.setCpAluno(cp);
    }

    public String getCpfAluno() {
        return turmaaluno.getCpfAluno();
    }

    public void setCpfAluno(String cpf) {
        turmaaluno.setCpfAluno(cpf);
    }

    public String getTs() {
        return turmaaluno.getTs();
    }

    public void setTsAluno(String ts) {
        turmaaluno.setTsAluno(ts);
    }

    public int getFtrhAluno() {
        return turmaaluno.getFtrhAluno();
    }

    public void setFtrhAluno(int ftrh) {
        turmaaluno.setFtrhAluno(ftrh);
    }

    public String getPaiAluno() {
        return turmaaluno.getPaiAluno();
    }

    public void setPaiAluno(String pai) {
        turmaaluno.setPaiAluno(pai);
    }

    public String getMaeAluno() {
        return turmaaluno.getMaeAluno();
    }

    public void setMaeAluno(String mae) {
        turmaaluno.setMaeAluno(mae);
    }

    public String getEmailAluno() {
        return turmaaluno.getEmailAluno();
    }

    public void setEmailAluno(String email) {
        turmaaluno.setEmailAluno(email);
    }

    public int getFumanteAluno() {
        return turmaaluno.getFumanteAluno();
    }

    public void setFumanteAluno(int fumante) {
        turmaaluno.setFumanteAluno(fumante);
    }

    public String getSexoAluno() {
        return turmaaluno.getSexoAluno();
    }

    public void setSexoAluno(String sexo) {
        turmaaluno.setSexoAluno(sexo);
    }

    public String getUltfuncao1Aluno() {
        return turmaaluno.getUltfuncao1Aluno();
    }

    public void setUltfuncao1Aluno(String ultfuncao1) {
        turmaaluno.setUltfuncao1Aluno(ultfuncao1);
    }

    public String getUltfuncao2Aluno() {
        return turmaaluno.getUltfuncao2Aluno();
    }

    public void setUltfuncao2Aluno(String ultfuncao2) {
        turmaaluno.setUltfuncao2Aluno(ultfuncao2);
    }

    public String getUltfuncao3Aluno() {
        return turmaaluno.getUltfuncao3Aluno();
    }

    public void setUltfuncao3Aluno(String ultfuncao3) {
        turmaaluno.setUltfuncao3Aluno(ultfuncao3);
    }

    public int getSituacaoAluno() {
        return turmaaluno.getSituacaoAluno();
    }

    public void setSituacaoAluno(int situacao) {
        turmaaluno.setSituacaoAluno(situacao);
    }

    public Date getDataNascimentoAluno() {
        return turmaaluno.getDataNascimentoAluno();
    }

    public void setDataNascimentoAluno(Date dataNascimento) {
        turmaaluno.setDataNascimentoAluno(dataNascimento);
    }

    public Date getUltDataPracaAluno() {
        return turmaaluno.getUltDataPracaAluno();
    }

    public void setUltDataPracaAluno(Date ultDataPraca) {
        turmaaluno.setUltDataPracaAluno(ultDataPraca);
    }

    public int getIdPostoGraduacaoAluno() {
        return turmaaluno.getIdPostoGraduacaoAluno();
    }

    public void setIdPostoGraduacaoAluno(int idPostoGraduacao) {
        turmaaluno.setIdPostoGraduacaoAluno(idPostoGraduacao);
    }
    
    public String getAbreviaturaPostoGraduacaoAluno() {
        return turmaaluno.getAbreviaturaPostoGraduacaoAluno();
    }

    public void setAbreviaturaPostoGraduacaoAluno(String abreviaturaPostoGraduacao) {
        turmaaluno.setAbreviaturaPostoGraduacaoAluno(abreviaturaPostoGraduacao);
    }
    
    public int getIdQasQmsAluno() {
        return turmaaluno.getIdQasQmsAluno();
    }

    public void setIdQasQmsAluno(int id) {
        turmaaluno.setIdQasQmsAluno(id);
    }
    
    public int getIdCmtAluno() {
        return turmaaluno.getIdCmtAluno();
    }

    public void setIdCmtAluno(int id) {
        turmaaluno.setIdCmtAluno(id);
    }
    
    public int getIdNatCidadeAluno() {
        return turmaaluno.getIdNatCidadeAluno();
    }

    public void setIdNatCidadeAluno(int id) {
        turmaaluno.setIdNatCidadeAluno(id);
    }
    
    public int getIdEstadoCivilAluno() {
        return turmaaluno.getIdEstadoCivilAluno();
    }

    public void setIdEstadoCivilAluno(int id) {
        turmaaluno.setIdEstadoCivilAluno(id);
    }
    
    public int getIdOMAluno() {
        return turmaaluno.getIdOMAluno();
    }

    public void setIdOMAluno(int id) {
        turmaaluno.setIdOMAluno(id);
    }
    
    public int getIdComportamentoAluno() {
        return turmaaluno.getIdComportamentoAluno();
    }

    public void setIdComportamentoAluno(int id) {
        turmaaluno.setIdComportamentoAluno(id);
    }
    
    public int getIdChImtoAluno() {
        return turmaaluno.getIdChImtoAluno();
    }

    public void setIdChImtoAluno(int id) {
        turmaaluno.setIdChImtoAluno(id);
    }
    
    public int getIdTafAluno() {
        return turmaaluno.getIdTafAluno();
    }

    public void setIdTafAluno(int id) {
        turmaaluno.setIdTafAluno(id);
    }
    
    public int getIdPromocaoAluno() {
        return turmaaluno.getIdPromocaoAluno();
    }

    public void setIdPromocaoAluno(int id) {
        turmaaluno.setIdPromocaoAluno(id);
    }
    
    public int getIdPreparacaoAlno() {
        return turmaaluno.getIdPreparacaoAlno();
    }

    public void setIdPreparacaoAluno(int id) {
        turmaaluno.setIdPreparacaoAluno(id);
    }
    
    public int getIdUniformeAluno() {
        return turmaaluno.getIdUniformeAluno();
    }

    public void setIdUniformeAluno(int id) {
        turmaaluno.setIdUniformeAluno(id);
    }
    
    public int getEasAluno() {
        return turmaaluno.getEasAluno();
    }

    public void setEasAluno(int eas) {
        turmaaluno.setEasAluno(eas);
    }
    
    public String getIdentidadeMilitar() {
        return milAvaliador.getIdentidade();
    }

    public void setIdentidadeMilitar(String identidade) {
        milAvaliador.setIdentidade(identidade);
    }

    public String getNomeMilitar() {
        return milAvaliador.getNome();
    }

    public void setNomeMilitar(String nome) {
        milAvaliador.setNome(nome);
    }

    public String getSobrenomeMilitar() {
        return milAvaliador.getSobrenome();
    }

    public void setSobrenomeMilitar(String sobrenome) {
        milAvaliador.setSobrenome(sobrenome);
    }

    public String getNomeguerraMilitar() {
        return milAvaliador.getNomeguerra();
    }

    public void setNomeguerraMilitar(String nomeguerra) {
        milAvaliador.setNomeguerra(nomeguerra);
    }

    public String getSenhaMilitar() {
        return milAvaliador.getSenha();
    }

    public void setSenhaMilitar(String senha) {
        milAvaliador.setSenha(senha);
    }

    public int getNgsMilitar() {
        return milAvaliador.getNgs();
    }

    public void setNgsMilitar(int ngs) {
        milAvaliador.setNgs(ngs);
    }

    public int getSituacaoMilitar() {
        return milAvaliador.getSituacao();
    }

    public void setSituacaoMilitar(int situacao) {
        milAvaliador.setSituacao(situacao);
    }   
    
    public int getIdPostoGraduacaoMilitar() {
        return milAvaliador.getIdPostoGraduacao();
    }

    public void setIdPostoGraduacaoMilitar(int idPostoGraduacao) {
        milAvaliador.setIdPostoGraduacao(idPostoGraduacao);
    }

    public String getNomePostoGraduacaoMilitar() {
        return milAvaliador.getNomePostoGraduacao();
    }

    public void setNomePostoGraduacaoMilitar(String nomePostoGraduacao) {
        milAvaliador.setNomePostoGraduacao(nomePostoGraduacao);
    }

    public String getAbreviaturaPostoGraduacaoMilitar() {
        return milAvaliador.getAbreviaturaPostoGraduacao();
    }

    public void setAbreviaturaPostoGraduacaoMilitar(String abreviaturaPostoGraduacao) {
        milAvaliador.setAbreviaturaPostoGraduacao(abreviaturaPostoGraduacao);
    }

    public String getCirculohierarquicoPostoGraduacaoMilitar() {
        return milAvaliador.getCirculohierarquicoPostoGraduacao();
    }

    public void setCirculohierarquicoPostoGraduacaoMilitar(String circulohierarquicoPostoGraduacao) {
        milAvaliador.setCirculohierarquicoPostoGraduacao(circulohierarquicoPostoGraduacao);
    }
    
    public int getIdForcaPostoGraduacaoMilitar() {
        return milAvaliador.getIdForcaPostoGraduacao();
    }

    public void setIdForcaPostoGraduacaoMilitar(int idForca) {
        milAvaliador.setIdForcaPostoGraduacao(idForca);
    }

    public String getNomeForcaPostoGraduacaoMilitar() {
        return milAvaliador.getNomeForcaPostoGraduacao();
    }

    public void setNomeForcaPostoGraduacaoMilitar(String nomeForca) {
        milAvaliador.setNomeForcaPostoGraduacao(nomeForca);
    }

    public String getSiglaForcaPostoGraduacaoMilitar() {
        return milAvaliador.getSiglaForcaPostoGraduacao();
    }

    public void setSiglaForcaPostoGraduacaoMilitar(String siglaForca) {
        milAvaliador.setSiglaForcaPostoGraduacao(siglaForca);
    }
    
    public int getIdTipoForcaPostoGraduacaoMilitar() {
        return milAvaliador.getIdTipoForcaPostoGraduacao();
    }

    public void setIdTipoForcaPostoGraduacaoMilitar(int id) {
        milAvaliador.setIdTipoForcaPostoGraduacao(id);
    }

    public String getNomeTipoForcaPostoGraduacaoMilitar() {
        return milAvaliador.getNomeTipoForcaPostoGraduacao();
    }

    public void setNomeTipoForcaPostoGraduacaoMilitar(String nome) {
        milAvaliador.setNomeTipoForcaPostoGraduacao(nome);
    }
    
    public int getIdCategoriaPostoGraduacaoMilitar() {
        return milAvaliador.getIdCategoriaPostoGraduacao();
    }

    public void setIdCategoriaPostoGraduacaoMilitar(int idCategoria) {
        milAvaliador.setIdCategoriaPostoGraduacao(idCategoria);
    }

    public String getNomeCategoriaPostoGraduacaoMilitar() {
        return milAvaliador.getNomeCategoriaPostoGraduacao();
    }

    public void setNomeCategoriaPostoGraduacaoMilitar(String nomeCategoria) {
        milAvaliador.setNomeCategoriaPostoGraduacao(nomeCategoria);
    }

    public String getDescricaoCategoriaPostoGraduacaoMilitar() {
        return milAvaliador.getDescricaoCategoriaPostoGraduacao();
    }

    public void setDescricaoCategoriaPostoGraduacaoMilitar(String descricaoCategoria) {
        milAvaliador.setDescricaoCategoriaPostoGraduacao(descricaoCategoria);
    }
}
