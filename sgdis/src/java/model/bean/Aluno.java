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
public class Aluno {
    String identidade, nome, sobrenome, nomeguerra, preccp, cp, cpf, ts, pai, mae, email, sexo, ultfuncao1, ultfuncao2, ultfuncao3, abrevPGrad;
    int situacao, ftrh, fumante, eas;
    Date dataNascimento, ultDataPraca;
    
    private final PostoGraduacao pg = new PostoGraduacao();
    private final QasQms qq = new QasQms();
    private final Comandante cmt = new Comandante();
    private final Cidade naturalidadecidade = new Cidade();
    private final EstadoCivil estcivil = new EstadoCivil();
    private final Om om = new Om();
    private final Comportamento comportamento = new Comportamento();
    private final ChefeImediato chimto = new ChefeImediato();
    private final Taf taf = new Taf();
    private final Promocao promocao = new Promocao();
    private final Preparacao preparacao = new Preparacao();
    private final Uniforme uniforme = new Uniforme();

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
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

    public String getPreccp() {
        return preccp;
    }

    public void setPreccp(String preccp) {
        this.preccp = preccp;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public int getFtrh() {
        return ftrh;
    }

    public void setFtrh(int ftrh) {
        this.ftrh = ftrh;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFumante() {
        return fumante;
    }

    public void setFumante(int fumante) {
        this.fumante = fumante;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getUltDataPraca() {
        return ultDataPraca;
    }

    public void setUltDataPraca(Date ultDataPraca) {
        this.ultDataPraca = ultDataPraca;
    }

    public int getEas() {
        return eas;
    }

    public void setEas(int eas) {
        this.eas = eas;
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

    /*public String getAbrevPGrad() {
        return abrevPGrad;
    }

    public void setAbrevPGrad(String abrevPGrad) {
        this.abrevPGrad = abrevPGrad;
    }*/
    
    

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
    
    public int getIdTipoForcaPostoGraduacao() {
        return pg.getIdTipoForca();
    }

    public void setIdTipoForcaPostoGraduacao(int id) {
        pg.setIdTipoForca(id);
    }

    public String getNomeTipoForcaPostoGraduacao() {
        return pg.getNomeTipoForca();
    }

    public void setNomeTipoForcaPostoGraduacao(String nome) {
        pg.setNomeTipoForca(nome);
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
    
    public int getIdQasQms() {
        return qq.getId();
    }

    public void setIdQasQms(int id) {
        qq.setId(id);
    }

    public String getNomeQasQms() {
        return qq.getNome();
    }

    public void setNomeQasQms(String nome) {
        qq.setNome(nome);
    }

    public String getAbreviaturaQasQms() {
        return qq.getAbreviatura();
    }

    public void setAbreviaturaQasQms(String abreviatura) {
        qq.setAbreviatura(abreviatura);
    }
    
    public int getIdForcaQasQms() {
        return qq.getIdForca();
    }

    public void setIdForcaQasQms(int id) {
        qq.setIdForca(id);
    }

    public String getNomeForcaQasQms() {
        return qq.getNomeForca();
    }

    public void setNomeForcaQasQms(String nome) {
        qq.setNomeForca(nome);
    }

    public String getSiglaForca() {
        return qq.getSiglaForca();
    }

    public void setSiglaForcaQasQms(String sigla) {
        qq.setSiglaForca(sigla);
    }
    
    public int getIdTipoForcaQasQms() {
        return qq.getIdTipoForca();
    }

    public void setIdTipoForcaQasQms(int id) {
        qq.setIdTipoForca(id);
    }

    public String getNomeTipoForcaQasQms() {
        return qq.getNomeTipoForca();
    }

    public void setNomeTipoForcaQasQms(String nome) {
        qq.setNomeTipoForca(nome);
    }
    
    public int getIdCmt() {
        return cmt.getId();
    }

    public void setIdCmt(int id) {
        cmt.setId(id);
    }

    public String getNomeCmt() {
        return cmt.getNome();
    }

    public void setNomeCmt(String nome) {
        cmt.setNome(nome);
    }

    public String getSobrenomeCmt() {
        return cmt.getSobrenome();
    }

    public void setSobrenomeCmt(String sobrenome) {
        cmt.setSobrenome(sobrenome);
    }

    public String getNomeguerraCmt() {
        return cmt.getNomeguerra();
    }

    public void setNomeguerraCmt(String nomeguerra) {
        cmt.setNomeguerra(nomeguerra);
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
    
    public int getIdTipoForcaPostoGraduacaoCmt() {
        return cmt.getIdTipoForcaPostoGraduacao();
    }

    public void setIdTipoForcaPostoGraduacaoCmt(int id) {
        cmt.setIdTipoForcaPostoGraduacao(id);
    }

    public String getNomeTipoForcaPostoGraduacaoCmt() {
        return cmt.getNomeTipoForcaPostoGraduacao();
    }

    public void setNomeTipoForcaPostoGraduacaoCmt(String nome) {
        cmt.setNomeTipoForcaPostoGraduacao(nome);
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
    
    public int getIdNatCidade() {
        return naturalidadecidade.getId();
    }

    public void setIdNatCidade(int id) {
        naturalidadecidade.setId(id);
    }

    public String getNomeNatCidade() {
        return naturalidadecidade.getNome();
    }

    public void setNomeNatCidade(String nome) {
        naturalidadecidade.setNome(nome);
    }
    
    public int getIdEstadoNatCidade() {
        return naturalidadecidade.getIdEstado();
    }

    public void setIdEstadoNatCidade(int idEstado) {
        naturalidadecidade.setIdEstado(idEstado);
    }

    public String getNomeEstadoNatCidade() {
        return naturalidadecidade.getNomeEstado();
    }

    public void setNomeEstadoNatCidade(String nomeEstado) {
        naturalidadecidade.setNomeEstado(nomeEstado);
    }

    public String getSiglaEstadoNatCidade() {
        return naturalidadecidade.getSiglaEstado();
    }

    public void setSiglaEstadoNatCidade(String siglaEstado) {
        naturalidadecidade.setSiglaEstado(siglaEstado);
    }
    
    public int getIdRegiaoEstadoNatCidade() {
        return naturalidadecidade.getIdRegiaoEstado();
    }

    public void setIdRegiaoEstadoNatCidade(int id) {
        naturalidadecidade.setIdRegiaoEstado(id);
    }

    public String getNomeRegiaoEstadoNatCidade() {
        return naturalidadecidade.getNomeRegiaoEstado();
    }

    public void setNomeRegiaoEstadoNatCidade(String nome) {
        naturalidadecidade.setNomeRegiaoEstado(nome);
    }
    
    public int getIdEstadoCivil() {
        return estcivil.getId();
    }

    public void setIdEstadoCivil(int id) {
        estcivil.setId(id);
    }

    public String getNomeEstadoCivil() {
        return estcivil.getNome();
    }

    public void setNomeEstadoCivil(String nome) {
        estcivil.setNome(nome);
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
    
    public int getIdComportamento() {
        return comportamento.getId();
    }

    public void setIdComportamento(int id) {
        comportamento.setId(id);
    }

    public String getNomeComportamento() {
        return comportamento.getNome();
    }

    public void setNomeComportamento(String nome) {
        comportamento.setNome(nome);
    }
    
    public int getIdChImto() {
        return chimto.getId();
    }

    public void setIdChImto(int id) {
        chimto.setId(id);
    }

    public String getNomeChImto() {
        return chimto.getNome();
    }

    public void setNomeChImto(String nome) {
        chimto.setNome(nome);
    }

    public String getSobrenomeChImto() {
        return chimto.getSobrenome();
    }

    public void setSobrenomeChImto(String sobrenome) {
        chimto.setSobrenome(sobrenome);
    }

    public String getNomeguerraChImto() {
        return chimto.getNomeguerra();
    }

    public void setNomeguerraChImto(String nomeguerra) {
        chimto.setNomeguerra(nomeguerra);
    }
    
    public int getIdPostoGraduacaoChImto() {
        return chimto.getIdPostoGraduacao();
    }

    public void setIdPostoGraduacaoChImto(int idPostoGraduacao) {
        chimto.setIdPostoGraduacao(idPostoGraduacao);
    }

    public String getNomePostoGraduacaoChImto() {
        return chimto.getNomePostoGraduacao();
    }

    public void setNomePostoGraduacaoChImto(String nomePostoGraduacao) {
        chimto.setNomePostoGraduacao(nomePostoGraduacao);
    }

    public String getAbreviaturaPostoGraduacaoChImto() {
        return chimto.getAbreviaturaPostoGraduacao();
    }

    public void setAbreviaturaPostoGraduacaoChImto(String abreviaturaPostoGraduacao) {
        chimto.setAbreviaturaPostoGraduacao(abreviaturaPostoGraduacao);
    }

    public String getCirculohierarquicoPostoGraduacaoChImto() {
        return chimto.getCirculohierarquicoPostoGraduacao();
    }

    public void setCirculohierarquicoPostoGraduacaoChImto(String circulohierarquicoPostoGraduacao) {
        chimto.setCirculohierarquicoPostoGraduacao(circulohierarquicoPostoGraduacao);
    }
    
    public int getIdForcaPostoGraduacaoChImto() {
        return chimto.getIdForcaPostoGraduacao();
    }

    public void setIdForcaPostoGraduacaoChImto(int idForca) {
        chimto.setIdForcaPostoGraduacao(idForca);
    }

    public String getNomeForcaPostoGraduacaoChImto() {
        return chimto.getNomeForcaPostoGraduacao();
    }

    public void setNomeForcaPostoGraduacaoChImto(String nomeForca) {
        chimto.setNomeForcaPostoGraduacao(nomeForca);
    }

    public String getSiglaForcaPostoGraduacaoChImto() {
        return chimto.getSiglaForcaPostoGraduacao();
    }

    public void setSiglaForcaPostoGraduacaoChImto(String siglaForca) {
        chimto.setSiglaForcaPostoGraduacao(siglaForca);
    }
    
    public int getIdTipoForcaPostoGraduacaoChImto() {
        return chimto.getIdTipoForcaPostoGraduacao();
    }

    public void setIdTipoForcaPostoGraduacaoChImto(int id) {
        chimto.setIdTipoForcaPostoGraduacao(id);
    }

    public String getNomeTipoForcaPostoGraduacaoChImto() {
        return chimto.getNomeTipoForcaPostoGraduacao();
    }

    public void setNomeTipoForcaPostoGraduacaoChImto(String nome) {
        chimto.setNomeTipoForcaPostoGraduacao(nome);
    }
    
    public int getIdCategoriaPostoGraduacaoChImto() {
        return chimto.getIdCategoriaPostoGraduacao();
    }

    public void setIdCategoriaPostoGraduacaoChImto(int idCategoria) {
        chimto.setIdCategoriaPostoGraduacao(idCategoria);
    }

    public String getNomeCategoriaPostoGraduacaoChImto() {
        return chimto.getNomeCategoriaPostoGraduacao();
    }

    public void setNomeCategoriaPostoGraduacaoChImto(String nomeCategoria) {
        chimto.setNomeCategoriaPostoGraduacao(nomeCategoria);
    }

    public String getDescricaoCategoriaPostoGraduacaoChImto() {
        return chimto.getDescricaoCategoriaPostoGraduacao();
    }

    public void setDescricaoCategoriaPostoGraduacaoChImto(String descricaoCategoria) {
        chimto.setDescricaoCategoriaPostoGraduacao(descricaoCategoria);
    }
    
    public int getIdTaf() {
        return taf.getId();
    }

    public void setIdTaf(int id) {
        taf.setId(id);
    }

    public Date getDataUltTaf() {
        return taf.getDataUltTaf();
    }

    public void setDataUltTaf(Date dataUltTaf) {
        taf.setDataUltTaf(dataUltTaf);
    }

    public String getMencaoTaf() {
        return taf.getMencao();
    }

    public void setMencaoTaf(String mencao) {
        taf.setMencao(mencao);
    }
    
    public int getIdPromocao() {
        return promocao.getId();
    }

    public void setIdPromocao(int id) {
        promocao.setId(id);
    }

    public Date getDataultpromocao() {
        return promocao.getDataultpromocao();
    }

    public void setDataultpromocao(Date dataultpromocao) {
        promocao.setDataultpromocao(dataultpromocao);
    }

    public Date getDataqapromocao() {
        return promocao.getDataqapromocao();
    }

    public void setDataqapromocao(Date dataqapromocao) {
        promocao.setDataqapromocao(dataqapromocao);
    }

    public String getQapromocao() {
        return promocao.getQapromocao();
    }

    public void setQapromocao(String qapromocao) {
        promocao.setDataqapromocao(dataNascimento);
    }
    
    public int getIdPreparacao() {
        return preparacao.getId();
    }

    public void setIdPreparacao(int id) {
        preparacao.setId(id);
    }

    public int getApoioFamiliaPreparacao() {
        return preparacao.getApoioFamilia();
    }

    public void setApoioFamiliaPreparacao(int apoioFamilia) {
        preparacao.setApoioFamilia(apoioFamilia);
    }

    public int getApoioOMPreparacao() {
        return preparacao.getApoioOM();
    }

    public void setApoioOMPreparacao(int apoioOM) {
        preparacao.setApoioOM(apoioOM);
    }

    public int getCursoPreparacaoCOSPreparacao() {
        return preparacao.getCursoPreparacaoCOS();
    }

    public void setCursoPreparacaoCOSPreparacao(int cursoPreparacaoCOS) {
        preparacao.setCursoPreparacaoCOS(cursoPreparacaoCOS);
    }

    public int getProblemaRedimentoPreparacao() {
        return preparacao.getProblemaRedimento();
    }

    public void setProblemaRedimentoPreparacao(int problemaRedimento) {
        preparacao.setProblemaRedimento(problemaRedimento);
    }

    public int getDedicacaoDoutrinaOPSPreparacao() {
        return preparacao.getDedicacaoDoutrinaOPS();
    }

    public void setDedicacaoDoutrinaOPSPreparacao(int dedicacaoDoutrinaOPS) {
        preparacao.setDedicacaoDoutrinaOPS(dedicacaoDoutrinaOPS);
    }

    public int getConsultaSitePreparacao() {
        return preparacao.getConsultaSite();
    }

    public void setConsultaSitePreparacao(int consultaSite) {
        preparacao.setConsultaSite(consultaSite);
    }

    public int getCsltAmbVirtualAlPreparacao() {
        return preparacao.getCsltAmbVirtualAl();
    }

    public void setCsltAmbVirtualAlPreparacao(int csltAmbVirtualAl) {
        preparacao.setCsltAmbVirtualAl(csltAmbVirtualAl);
    }

    public String getPrepFisicaPreparacao() {
        return preparacao.getPrepFisica();
    }

    public void setPrepFisicaPreparacao(String prepFisica) {
        preparacao.setPrepFisica(prepFisica);
    }

    public String getFatorMotivadorPreparacao() {
        return preparacao.getFatorMotivador();
    }

    public void setFatorMotivadorPreparacao(String fatorMotivador) {
        preparacao.setFatorMotivador(fatorMotivador);
    }
    
    public int getIdUniforme() {
        return uniforme.getId();
    }

    public void setIdUniforme(int id) {
        uniforme.setId(id);
    }

    public int getTamCoturnoUniforme() {
        return uniforme.getTamCoturno();
    }

    public void setTamCoturnoUniforme(int tamCoturno) {
        uniforme.setTamCoturno(tamCoturno);
    }

    public String getTamGandolaUniforme() {
        return uniforme.getTamGandola();
    }

    public void setTamGandolaUniforme(String tamGandola) {
        uniforme.setTamGandola(tamGandola);
    }

    public String getTamCalcaUniforme() {
        return uniforme.getTamCalca();
    }

    public void setTamCalcaUniforme(String tamCalca) {
        uniforme.setTamCalca(tamCalca);
    }

    public String getTamCamisaCamufladaUniforme() {
        return uniforme.getTamCamisaCamuflada();
    }

    public void setTamCamisaCamufladaUniforme(String tamCamisaCamuflada) {
        uniforme.setTamCamisaCamuflada(tamCamisaCamuflada);
    }
}
