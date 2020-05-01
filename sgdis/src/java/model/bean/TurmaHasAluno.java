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
public class TurmaHasAluno {
    private final Turma turma = new Turma();
    private final Tentativa tent = new Tentativa();
    private final Aluno al = new Aluno();
    
    int idTurma, idTentativa;
    String idtAluno;

    public int getIdTurma(){
        return turma.getId();
    }

    public void setIdTurma(int idTurma){
        turma.setId(idTurma);
    }
    
    public int getAnoTurma(){
        return turma.getAno();
    }   
    
    public void setAnoTurma(int anoTurma){
        turma.setAno(anoTurma);
    }
    
    public int getnTurma(){
        return turma.getnTurma();
    }   
    
    public void setnTurma(int nTurma){
        turma.setnTurma(nTurma);
    }
    
    public Date getDataInicioTurma() {
        return turma.getDataInicio();
    }
    
    public void setDateInicioTurma(Date dataInicio){
        turma.setDataInicio(dataInicio);
    }
    
    public Date getDataFimTurma() {
        return turma.getDataFim();
    }
    
    public void setDateFimTurma(Date dataFim){
        turma.setDataFim(dataFim);
    }
    
    public int getIdCursoTurma(){
        return turma.getIdCurso();
    }    
    
    public void setIdCursoTurma(int idCurso){
        turma.setIdCurso(idCurso);
    }
    
    public int getIdCategoriaTurma(){
        return turma.getIdCategoria();
    }
    
    public void setIdCategoriaTurma(int idCategoria){
        turma.setIdCategoria(idCategoria);
    }
    
    public String getTurma(){
        return turma.getTurma();
    }
    
    public void setTurma(String nometurma){
        turma.setTurma(nometurma);
    }
    
    
    public int getIdTentativa() {
        return tent.getId();
    }

    public void setIdTentativa(int idTentativa){
        tent.setId(idTentativa);
    }
    
    public int getSituacaoTentativa() {
        return tent.getSituacao();
    }

    public void setSituacaoTentativa(int situacao) {
        tent.setSituacao(situacao);
    }

    public String getMtvDeslgTentativa() {
        return tent.getMtvDeslg();
    }

    public void setMtvDeslgTentativa(String mtvDeslg) {
        tent.setMtvDeslg(mtvDeslg);
    }

    public String getFaseDeslgTentativa() {
        return tent.getFaseDeslg();
    }

    public void setFaseDeslgTentativa(String faseDeslg) {
        tent.setFaseDeslg(faseDeslg);
    }

    public String getPostoGraduacaoAlunoTentativa() {
        return tent.getPostoGraduacaoAluno();
    }

    public void setPostoGraduacaoAlunoTentativa(String postoGraduacaoAluno) {
        tent.setPostoGraduacaoAluno(postoGraduacaoAluno);
    }

    public String getNomeOMTentativa() {
        return tent.getNomeOM();
    }

    public void setNomeOMTentativa(String nomeOM) {
        tent.setNomeOM(nomeOM);
    }

    public String getCursoTentativa() {
        return tent.getCurso();
    }

    public void setCurso(String curso) {
        tent.setCurso(curso);
    }

    public String getTurmaTentativa() {
        return tent.getTurma();
    }

    public void setTurmaTentativa(String turma) {
        tent.setTurma(turma);
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

    public String getTsAluno() {
        return al.getTs();
    }

    public void setTsAluno(String ts) {
        al.setTs(ts);
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

    public String getFuncao1Aluno() {
        return al.getFuncao1();
    }

    public void setFuncao1Aluno(String funcao1) {
        al.setFuncao1(funcao1);
    }

    public String getFuncao2Aluno() {
        return al.getFuncao2();
    }

    public void setFuncao2Aluno(String funcao2) {
        al.setFuncao2(funcao2);
    }

    public String getFuncao3Aluno() {
        return al.getFuncao3();
    }

    public void setFuncao3Aluno(String funcao3) {
        al.setFuncao3(funcao3);
    }

    public char getFtrhAluno() {
        return al.getFtrh();
    }

    public void setFtrhAluno(char ftrh) {
        al.setFtrh(ftrh);
    }

    public char getFumanteAluno() {
        return al.getFumante();
    }

    public void setFumanteAluno(char fumante) {
        al.setFumante(fumante);
    }

    public char getSexoAluno() {
        return al.getSexo();
    }

    public void setSexoAluno(char sexo) {
        al.setSexo(sexo);
    }

    public char getStatusAluno() {
        return al.getStatus();
    }

    public void setStatusAluno(char status) {
        al.setStatus(status);
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

    public void setIdQasQmsAluno(int idQasQms) {
        al.setIdQasQms(idQasQms);
    }

    public int getIdNaturalidadeCidadeAluno() {
        return al.getIdNaturalidadeCidade();
    }

    public void setIdNaturalidadeCidadeAluno(int idNaturalidadeCidade) {
        al.setIdNaturalidadeCidade(idNaturalidadeCidade);
    }

    public int getIdEstadoCivilAluno() {
        return al.getIdEstadoCivil();
    }

    public void setIdEstadoCivilAluno(int idEstadoCivil) {
        al.setIdEstadoCivil(idEstadoCivil);
    }

    public int getIdOMAluno() {
        return al.getIdOM();
    }

    public void setIdOMAluno(int idOM) {
        al.setIdOM(idOM);
    }

    public int getIdComportamentoAluno() {
        return al.getIdComportamento();
    }

    public void setIdComportamentoAluno(int idComportamento) {
        al.setIdComportamento(idComportamento);
    }

    public int getIdChImediatoAluno() {
        return al.getIdChImediato();
    }

    public void setIdChImediatoAluno(int idChImediato) {
        al.setIdChImediato(idChImediato);
    }

    public int getIdFormacaoOrigemAluno() {
        return al.getIdFormacaoOrigem();
    }

    public void setIdFormacaoOrigemAluno(int idFormacaoOrigem) {
        al.setIdFormacaoOrigem(idFormacaoOrigem);
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
}
