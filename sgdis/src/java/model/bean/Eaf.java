/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author anderson
 */
public class Eaf {
    int id, flexaoBarra, abdominal, flexaoBraco, nadoSubmerso, subidaCorda, situacao;
    int idRec, flexaoBarraRec, abdominalRec, flexaoBracoRec, nadoSubmersoRec, subidaCordaRec, situacaoRec;
    Time corrida, suspBarra, ppm, natacao, flutuacao, marcha15km;
    Time corridaRec, suspBarraRec, ppmRec, natacaoRec, flutuacaoRec, marcha15kmRec;
    
    private final TurmaHasAluno turmaaluno = new TurmaHasAluno();
    private final TurmaHasAluno turmaalunoRec = new TurmaHasAluno();
    private final Militar milAvaliador = new Militar();
    private final Militar milAvaliadorRec = new Militar();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlexaoBarra() {
        return flexaoBarra;
    }

    public void setFlexaoBarra(int flexaoBarra) {
        this.flexaoBarra = flexaoBarra;
    }

    public Time getSuspBarra() {
        return suspBarra;
    }

    public void setSuspBarra(Time suspBarra) {
        this.suspBarra = suspBarra;
    }
    
    public int getAbdominal() {
        return abdominal;
    }

    public void setAbdominal(int abdominal) {
        this.abdominal = abdominal;
    }

    public int getFlexaoBraco() {
        return flexaoBraco;
    }

    public void setFlexaoBraco(int flexaoBraco) {
        this.flexaoBraco = flexaoBraco;
    }

    public int getNadoSubmerso() {
        return nadoSubmerso;
    }

    public void setNadoSubmerso(int nadoSubmerso) {
        this.nadoSubmerso = nadoSubmerso;
    }

    public int getSubidaCorda() {
        return subidaCorda;
    }

    public void setSubidaCorda(int subidaCorda) {
        this.subidaCorda = subidaCorda;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public Time getCorrida() {
        return corrida;
    }

    public void setCorrida(Time corrida) {
        this.corrida = corrida;
    }

    public Time getPpm() {
        return ppm;
    }

    public void setPpm(Time ppm) {
        this.ppm = ppm;
    }

    public Time getNatacao() {
        return natacao;
    }

    public void setNatacao(Time natacao) {
        this.natacao = natacao;
    }

    public Time getFlutuacao() {
        return flutuacao;
    }

    public void setFlutuacao(Time flutuacao) {
        this.flutuacao = flutuacao;
    }

    public Time getMarcha15km() {
        return marcha15km;
    }

    public void setMarcha15km(Time marcha15km) {
        this.marcha15km = marcha15km;
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

    public int getIdRec() {
        return idRec;
    }

    public void setIdRec(int idRec) {
        this.idRec = idRec;
    }

    public int getFlexaoBarraRec() {
        return flexaoBarraRec;
    }

    public void setFlexaoBarraRec(int flexaoBarraRec) {
        this.flexaoBarraRec = flexaoBarraRec;
    }

    public int getAbdominalRec() {
        return abdominalRec;
    }

    public void setAbdominalRec(int abdominalRec) {
        this.abdominalRec = abdominalRec;
    }

    public int getFlexaoBracoRec() {
        return flexaoBracoRec;
    }

    public void setFlexaoBracoRec(int flexaoBracoRec) {
        this.flexaoBracoRec = flexaoBracoRec;
    }

    public int getNadoSubmersoRec() {
        return nadoSubmersoRec;
    }

    public void setNadoSubmersoRec(int nadoSubmersoRec) {
        this.nadoSubmersoRec = nadoSubmersoRec;
    }

    public int getSubidaCordaRec() {
        return subidaCordaRec;
    }

    public void setSubidaCordaRec(int subidaCordaRec) {
        this.subidaCordaRec = subidaCordaRec;
    }

    public int getSituacaoRec() {
        return situacaoRec;
    }

    public void setSituacaoRec(int situacaoRec) {
        this.situacaoRec = situacaoRec;
    }

    public Time getCorridaRec() {
        return corridaRec;
    }

    public void setCorridaRec(Time corridaRec) {
        this.corridaRec = corridaRec;
    }

    public Time getSuspBarraRec() {
        return suspBarraRec;
    }

    public void setSuspBarraRec(Time suspBarraRec) {
        this.suspBarraRec = suspBarraRec;
    }

    public Time getPpmRec() {
        return ppmRec;
    }

    public void setPpmRec(Time ppmRec) {
        this.ppmRec = ppmRec;
    }

    public Time getNatacaoRec() {
        return natacaoRec;
    }

    public void setNatacaoRec(Time natacaoRec) {
        this.natacaoRec = natacaoRec;
    }

    public Time getFlutuacaoRec() {
        return flutuacaoRec;
    }

    public void setFlutuacaoRec(Time flutuacaoRec) {
        this.flutuacaoRec = flutuacaoRec;
    }

    public Time getMarcha15kmRec() {
        return marcha15kmRec;
    }

    public void setMarcha15kmRec(Time marcha15kmRec) {
        this.marcha15kmRec = marcha15kmRec;
    }
    
    public int getIdTurmaRec(){
        return turmaalunoRec.getIdTurma();
    }

    public void setIdTurmaRec(int idTurma){
        turmaalunoRec.setIdTurma(idTurma);
    }
    
    public int getAnoTurmaRec(){
        return turmaalunoRec.getAnoTurma();
    }   
    
    public void setAnoTurmaRec(int anoTurma){
        turmaalunoRec.setAnoTurma(anoTurma);
    }
    
    public int getnTurmaRec(){
        return turmaalunoRec.getnTurma();
    }   
    
    public void setnTurmaRec(int nTurma){
        turmaalunoRec.setnTurma(nTurma);
    }
    
    public Date getDataInicioTurmaRec() {
        return turmaalunoRec.getDataInicioTurma();
    }
    
    public void setDateInicioTurmaRec(Date dataInicio){
        turmaalunoRec.setDataInicioTurma(dataInicio);
    }
    
    public Date getDataFimTurmaRec() {
        return turmaalunoRec.getDataFimTurma();
    }
    
    public void setDateFimTurmaRec(Date dataFim){
        turmaalunoRec.setDataFimTurma(dataFim);
    }
    
    public String getTurmaRec(){
        return turmaalunoRec.getTurma();
    }
    
    public void setTurmaRec(String nometurmaalunoRec){
        turmaalunoRec.setTurma(nometurmaalunoRec);
    }
    
    public int getIdCursoTurmaRec() {
        return turmaalunoRec.getIdCursoTurma();
    }

    public void setIdCursoTurmaRec(int id) {
        turmaalunoRec.setIdCursoTurma(id);
    }

    public String getNomeCursoTurmaRec() {
        return turmaalunoRec.getNomeCursoTurma();
    }

    public void setNomeCursoTurmaRec(String nome) {
        turmaalunoRec.setNomeCursoTurma(nome);
    }

    public String getSiglaCursoTurmaRec() {
        return turmaalunoRec.getSiglaCursoTurma();
    }

    public void setSiglaCursoTurmaRec(String sigla) {
        turmaalunoRec.setSiglaCursoTurma(sigla);
    }

    public String getPortariaCursoTurmaRec() {
        return turmaalunoRec.getPortariaCursoTurma();
    }

    public void setPortariaCursoTurmaRec(String portaria) {
        turmaalunoRec.setPortariaCursoTurma(portaria);
    }

    public String getDescricaoCursoTurmaRec() {
        return turmaalunoRec.getDescricaoCursoTurma();
    }

    public void setDescricaoCursoTurmaRec(String descricao) {
        turmaalunoRec.setDescricaoCursoTurma(descricao);
    }
    
    public int getIdCategoriaTurmaRec() {
        return turmaalunoRec.getIdCategoriaTurma();
    }

    public void setIdCategoriaTurmaRec(int id) {
        turmaalunoRec.setIdCategoriaTurma(id);
    }

    public String getNomeCategoriaTurmaRec() {
        return turmaalunoRec.getNomeCategoriaTurma();
    }

    public void setNomeCategoriaTurmaRec(String nome) {
        turmaalunoRec.setNomeCategoriaTurma(nome);
    }

    public String getDescricaoCategoriaTurmaRec() {
        return turmaalunoRec.getDescricaoCategoriaTurma();
    }

    public void setDescricaoCategoriaTurmaRec(String descricao) {
        turmaalunoRec.setDescricaoCategoriaTurma(descricao);
    }    
    
    public int getIdTentativaRec() {
        return turmaalunoRec.getIdTentativa();
    }

    public void setIdTentativaRec(int idTentativa){
        turmaalunoRec.setIdTentativa(idTentativa);
    }

    public String getMtvDeslgTentativaRec() {
        return turmaalunoRec.getMtvDeslgTentativa();
    }

    public void setMtvDeslgTentativaRec(String mtvDeslg) {
        turmaalunoRec.setMtvDeslgTentativa(mtvDeslg);
    }

    public String getFaseDeslgTentativaRec() {
        return turmaalunoRec.getFaseDeslgTentativa();
    }

    public void setFaseDeslgTentativaRec(String faseDeslg) {
        turmaalunoRec.setFaseDeslgTentativa(faseDeslg);
    }    

    public String getIdentidadeAlunoRec() {
        return turmaalunoRec.getIdentidadeAluno();
    }

    public void setIdentidadeAlunoRec(String identidade) {
        turmaalunoRec.setIdentidadeAluno(identidade);
    }

    public String getNomeAlunoRec() {
        return turmaalunoRec.getNomeAluno();
    }

    public void setNomeAlunoRec(String nome) {
        turmaalunoRec.setNomeAluno(nome);
    }

    public String getSobrenomeAlunoRec() {
        return turmaalunoRec.getSobrenomeAluno();
    }

    public void setSobrenomeAlunoRec(String sobrenome) {
        turmaalunoRec.setSobrenomeAluno(sobrenome);
    }

    public String getNomeguerraAlunoRec() {
        return turmaalunoRec.getNomeguerraAluno();
    }

    public void setNomeguerraAlunoRec(String nomeguerra) {
        turmaalunoRec.setNomeguerraAluno(nomeguerra);
    }

    public String getPreccpAlunoRec() {
        return turmaalunoRec.getPreccpAluno();
    }

    public void setPreccpAlunoRec(String preccp) {
        turmaalunoRec.setPreccpAluno(preccp);
    }

    public String getCpAlunoRec() {
        return turmaalunoRec.getCpAluno();
    }

    public void setCpAlunoRec(String cp) {
        turmaalunoRec.setCpAluno(cp);
    }

    public String getCpfAlunoRec() {
        return turmaalunoRec.getCpfAluno();
    }

    public void setCpfAlunoRec(String cpf) {
        turmaalunoRec.setCpfAluno(cpf);
    }

    public String getTsRec() {
        return turmaalunoRec.getTs();
    }

    public void setTsAlunoRec(String ts) {
        turmaalunoRec.setTsAluno(ts);
    }

    public int getFtrhAlunoRec() {
        return turmaalunoRec.getFtrhAluno();
    }

    public void setFtrhAlunoRec(int ftrh) {
        turmaalunoRec.setFtrhAluno(ftrh);
    }

    public String getPaiAlunoRec() {
        return turmaalunoRec.getPaiAluno();
    }

    public void setPaiAlunoRec(String pai) {
        turmaalunoRec.setPaiAluno(pai);
    }

    public String getMaeAlunoRec() {
        return turmaalunoRec.getMaeAluno();
    }

    public void setMaeAlunoRec(String mae) {
        turmaalunoRec.setMaeAluno(mae);
    }

    public String getEmailAlunoRec() {
        return turmaalunoRec.getEmailAluno();
    }

    public void setEmailAlunoRec(String email) {
        turmaalunoRec.setEmailAluno(email);
    }

    public int getFumanteAlunoRec() {
        return turmaalunoRec.getFumanteAluno();
    }

    public void setFumanteAlunoRec(int fumante) {
        turmaalunoRec.setFumanteAluno(fumante);
    }

    public String getSexoAlunoRec() {
        return turmaalunoRec.getSexoAluno();
    }

    public void setSexoAlunoRec(String sexo) {
        turmaalunoRec.setSexoAluno(sexo);
    }

    public String getUltfuncao1AlunoRec() {
        return turmaalunoRec.getUltfuncao1Aluno();
    }

    public void setUltfuncao1AlunoRec(String ultfuncao1) {
        turmaalunoRec.setUltfuncao1Aluno(ultfuncao1);
    }

    public String getUltfuncao2AlunoRec() {
        return turmaalunoRec.getUltfuncao2Aluno();
    }

    public void setUltfuncao2AlunoRec(String ultfuncao2) {
        turmaalunoRec.setUltfuncao2Aluno(ultfuncao2);
    }

    public String getUltfuncao3AlunoRec() {
        return turmaalunoRec.getUltfuncao3Aluno();
    }

    public void setUltfuncao3AlunoRec(String ultfuncao3) {
        turmaalunoRec.setUltfuncao3Aluno(ultfuncao3);
    }

    public int getSituacaoAlunoRec() {
        return turmaalunoRec.getSituacaoAluno();
    }

    public void setSituacaoAlunoRec(int situacao) {
        turmaalunoRec.setSituacaoAluno(situacao);
    }

    public Date getDataNascimentoAlunoRec() {
        return turmaalunoRec.getDataNascimentoAluno();
    }

    public void setDataNascimentoAlunoRec(Date dataNascimento) {
        turmaalunoRec.setDataNascimentoAluno(dataNascimento);
    }

    public Date getUltDataPracaAlunoRec() {
        return turmaalunoRec.getUltDataPracaAluno();
    }

    public void setUltDataPracaAlunoRec(Date ultDataPraca) {
        turmaalunoRec.setUltDataPracaAluno(ultDataPraca);
    }

    public int getIdPostoGraduacaoAlunoRec() {
        return turmaalunoRec.getIdPostoGraduacaoAluno();
    }

    public void setIdPostoGraduacaoAlunoRec(int idPostoGraduacao) {
        turmaalunoRec.setIdPostoGraduacaoAluno(idPostoGraduacao);
    }
    
    public String getAbreviaturaPostoGraduacaoAlunoRec() {
        return turmaalunoRec.getAbreviaturaPostoGraduacaoAluno();
    }

    public void setAbreviaturaPostoGraduacaoAlunoRec(String abreviaturaPostoGraduacao) {
        turmaalunoRec.setAbreviaturaPostoGraduacaoAluno(abreviaturaPostoGraduacao);
    }
    
    public int getIdQasQmsAlunoRec() {
        return turmaalunoRec.getIdQasQmsAluno();
    }

    public void setIdQasQmsAlunoRec(int id) {
        turmaalunoRec.setIdQasQmsAluno(id);
    }
    
    public int getIdCmtAlunoRec() {
        return turmaalunoRec.getIdCmtAluno();
    }

    public void setIdCmtAlunoRec(int id) {
        turmaalunoRec.setIdCmtAluno(id);
    }
    
    public int getIdNatCidadeAlunoRec() {
        return turmaalunoRec.getIdNatCidadeAluno();
    }

    public void setIdNatCidadeAlunoRec(int id) {
        turmaalunoRec.setIdNatCidadeAluno(id);
    }
    
    public int getIdEstadoCivilAlunoRec() {
        return turmaalunoRec.getIdEstadoCivilAluno();
    }

    public void setIdEstadoCivilAlunoRec(int id) {
        turmaalunoRec.setIdEstadoCivilAluno(id);
    }
    
    public int getIdOMAlunoRec() {
        return turmaalunoRec.getIdOMAluno();
    }

    public void setIdOMAlunoRec(int id) {
        turmaalunoRec.setIdOMAluno(id);
    }
    
    public int getIdComportamentoAlunoRec() {
        return turmaalunoRec.getIdComportamentoAluno();
    }

    public void setIdComportamentoAlunoRec(int id) {
        turmaalunoRec.setIdComportamentoAluno(id);
    }
    
    public int getIdChImtoAlunoRec() {
        return turmaalunoRec.getIdChImtoAluno();
    }

    public void setIdChImtoAlunoRec(int id) {
        turmaalunoRec.setIdChImtoAluno(id);
    }
    
    public int getIdTafAlunoRec() {
        return turmaalunoRec.getIdTafAluno();
    }

    public void setIdTafAlunoRec(int id) {
        turmaalunoRec.setIdTafAluno(id);
    }
    
    public int getIdPromocaoAlunoRec() {
        return turmaalunoRec.getIdPromocaoAluno();
    }

    public void setIdPromocaoAlunoRec(int id) {
        turmaalunoRec.setIdPromocaoAluno(id);
    }
    
    public int getIdPreparacaoAlunoRec() {
        return turmaalunoRec.getIdPreparacaoAlno();
    }

    public void setIdPreparacaoAlunoRec(int id) {
        turmaalunoRec.setIdPreparacaoAluno(id);
    }
    
    public int getIdUniformeAlunoRec() {
        return turmaalunoRec.getIdUniformeAluno();
    }

    public void setIdUniformeAlunoRec(int id) {
        turmaalunoRec.setIdUniformeAluno(id);
    }
    
    public int getEasAlunoRec() {
        return turmaalunoRec.getEasAluno();
    }

    public void setEasAlunoRec(int eas) {
        turmaalunoRec.setEasAluno(eas);
    }
    
    public String getIdentidadeMilitarAvaliadorRec() {
        return milAvaliadorRec.getIdentidade();
    }

    public void setIdentidadeMilitarAvaliadorRec(String identidade) {
        milAvaliadorRec.setIdentidade(identidade);
    }

    public String getNomeMilitarAvaliadorRec() {
        return milAvaliadorRec.getNome();
    }

    public void setNomeMilitarAvaliadorRec(String nome) {
        milAvaliadorRec.setNome(nome);
    }

    public String getSobrenomeMilitarAvaliadorRec() {
        return milAvaliadorRec.getSobrenome();
    }

    public void setSobrenomeMilitarAvaliadorRec(String sobrenome) {
        milAvaliadorRec.setSobrenome(sobrenome);
    }

    public String getNomeguerraMilitarAvaliadorRec() {
        return milAvaliadorRec.getNomeguerra();
    }

    public void setNomeguerraMilitarAvaliadorRec(String nomeguerra) {
        milAvaliadorRec.setNomeguerra(nomeguerra);
    }

    public String getSenhaMilitarAvaliadorRec() {
        return milAvaliadorRec.getSenha();
    }

    public void setSenhaMilitarAvaliadorRec(String senha) {
        milAvaliadorRec.setSenha(senha);
    }

    public int getNgsMilitarAvaliadorRec() {
        return milAvaliadorRec.getNgs();
    }

    public void setNgsMilitarAvaliadorRec(int ngs) {
        milAvaliadorRec.setNgs(ngs);
    }

    public int getSituacaoMilitarAvaliadorRec() {
        return milAvaliadorRec.getSituacao();
    }

    public void setSituacaoMilitarAvaliadorRec(int situacao) {
        milAvaliadorRec.setSituacao(situacao);
    }   
    
    public int getIdPostoGraduacaoMilitarAvaliadorRec() {
        return milAvaliadorRec.getIdPostoGraduacao();
    }

    public void setIdPostoGraduacaoMilitarAvaliadorRec(int idPostoGraduacao) {
        milAvaliadorRec.setIdPostoGraduacao(idPostoGraduacao);
    }

    public String getNomePostoGraduacaoMilitarAvaliadorRec() {
        return milAvaliadorRec.getNomePostoGraduacao();
    }

    public void setNomePostoGraduacaoMilitarAvaliadorRec(String nomePostoGraduacao) {
        milAvaliadorRec.setNomePostoGraduacao(nomePostoGraduacao);
    }

    public String getAbreviaturaPostoGraduacaoMilitarAvaliadorRec() {
        return milAvaliadorRec.getAbreviaturaPostoGraduacao();
    }

    public void setAbreviaturaPostoGraduacaoMilitarAvaliadorRec(String abreviaturaPostoGraduacao) {
        milAvaliadorRec.setAbreviaturaPostoGraduacao(abreviaturaPostoGraduacao);
    }

    public String getCirculohierarquicoPostoGraduacaoMilitarAvaliadorRec() {
        return milAvaliadorRec.getCirculohierarquicoPostoGraduacao();
    }

    public void setCirculohierarquicoPostoGraduacaoMilitarAvaliadorRec(String circulohierarquicoPostoGraduacao) {
        milAvaliadorRec.setCirculohierarquicoPostoGraduacao(circulohierarquicoPostoGraduacao);
    }
    
    public int getIdForcaPostoGraduacaoMilitarAvaliadorRec() {
        return milAvaliadorRec.getIdForcaPostoGraduacao();
    }

    public void setIdForcaPostoGraduacaoMilitarAvaliadorRec(int idForca) {
        milAvaliadorRec.setIdForcaPostoGraduacao(idForca);
    }

    public String getNomeForcaPostoGraduacaoMilitarAvaliadorRec() {
        return milAvaliadorRec.getNomeForcaPostoGraduacao();
    }

    public void setNomeForcaPostoGraduacaoMilitarAvaliadorRec(String nomeForca) {
        milAvaliadorRec.setNomeForcaPostoGraduacao(nomeForca);
    }

    public String getSiglaForcaPostoGraduacaoMilitarAvaliadorRec() {
        return milAvaliadorRec.getSiglaForcaPostoGraduacao();
    }

    public void setSiglaForcaPostoGraduacaoMilitarAvaliadorRec(String siglaForca) {
        milAvaliadorRec.setSiglaForcaPostoGraduacao(siglaForca);
    }
    
    public int getIdTipoForcaPostoGraduacaoMilitarAvaliadorRec() {
        return milAvaliadorRec.getIdTipoForcaPostoGraduacao();
    }

    public void setIdTipoForcaPostoGraduacaoMilitarAvaliadorRec(int id) {
        milAvaliadorRec.setIdTipoForcaPostoGraduacao(id);
    }

    public String getNomeTipoForcaPostoGraduacaoMilitarAvaliadorRec() {
        return milAvaliadorRec.getNomeTipoForcaPostoGraduacao();
    }

    public void setNomeTipoForcaPostoGraduacaoMilitarAvaliadorRec(String nome) {
        milAvaliadorRec.setNomeTipoForcaPostoGraduacao(nome);
    }
    
    public int getIdCategoriaPostoGraduacaoMilitarAvaliadorRec() {
        return milAvaliadorRec.getIdCategoriaPostoGraduacao();
    }

    public void setIdCategoriaPostoGraduacaoMilitarAvaliadorRec(int idCategoria) {
        milAvaliadorRec.setIdCategoriaPostoGraduacao(idCategoria);
    }

    public String getNomeCategoriaPostoGraduacaoMilitarAvaliadorRec() {
        return milAvaliadorRec.getNomeCategoriaPostoGraduacao();
    }

    public void setNomeCategoriaPostoGraduacaoMilitarAvaliadorRec(String nomeCategoria) {
        milAvaliadorRec.setNomeCategoriaPostoGraduacao(nomeCategoria);
    }

    public String getDescricaoCategoriaPostoGraduacaoMilitarAvaliadorRec() {
        return milAvaliadorRec.getDescricaoCategoriaPostoGraduacao();
    }

    public void setDescricaoCategoriaPostoGraduacaoMilitarAvaliadorRec(String descricaoCategoria) {
        milAvaliadorRec.setDescricaoCategoriaPostoGraduacao(descricaoCategoria);
    }
}
