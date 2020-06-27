/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.*;

/**
 *
 * @author anderson
 */
public class AlunoDAO {
    //Tabela
    String tabela = "Aluno";
    
    //Atributos
    String idt = "identidade";
    String situacao = "situacao";
    String idPostoGraduacao = "idPostoGraduacao";
    String idQasQms = "idQasQms";
    String idComandante = "idComandante";
    String datanascimento = "datanascimento";
    String nome = "nome";
    String sobrenome = "sobrenome";
    String nomeguerra = "nomeguerra";
    String preccp = "preccp";
    String cp = "cp";
    String cpf = "cpf";
    String ultdatapraca = "ultdatapraca";
    String idNaturalidadeCidade = "idNaturalidadeCidade";
    String idEstadoCivil = "idEstadoCivil";
    String ts = "ts";
    String ftrh = "ftrh";
    String pai = "pai";
    String mae = "mae";
    String email = "email";
    String fumante = "fumante";
    String idOM = "idOM";
    String idComportamento = "idComportamento";
    String idChImediato = "idChImediato";
    String idFormacaoOrigem = "idFormacaoOrigem";
    String sexo = "sexo";
    String ultfuncao1 = "ultfuncao1";
    String ultfuncao2 = "ultfuncao2";
    String ultfuncao3 = "ultfuncao3";
    String idTAF = "idTAF";
    String idPromocao = "idPromocao";
    String idPreparacao = "idPreparacao";
    String idUniforme = "idUniforme";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + idt + "," + situacao + "," + idPostoGraduacao + "," + idQasQms + "," + idComandante + "," +
                                                                datanascimento + "," + nome + "," + sobrenome + "," + nomeguerra + "," + preccp + "," + cp + "," + 
                                                                cpf + "," + ultdatapraca + "," + idNaturalidadeCidade + "," + idEstadoCivil + "," + ts + "," + ftrh + "," +
                                                                pai + "," + mae + "," + email + "," + fumante + "," + idOM + "," + idComportamento + "," + idChImediato + "," +
                                                                idFormacaoOrigem + "," + sexo + "," + ultfuncao1 + "," + ultfuncao2 + "," + ultfuncao3 + "," + idTAF + "," + 
                                                                idPromocao + "," + idPreparacao + "," + idUniforme + ")" +
                                  " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + situacao + "=?, " + idPostoGraduacao + "=?, " + idQasQms + "=?, " + idComandante + "=?, " + datanascimento + "=?, " + 
                                            nome + "=?, " + sobrenome + "=?, " + nomeguerra + "=?, " + preccp + "=?, " + cp + "=?, " + cpf + "=?, " + ultdatapraca + "=?, " +
                                            idNaturalidadeCidade + "=?, " + idEstadoCivil + "=?, " + ts + "=?, " + ftrh + "=?, " + pai + "=?, " + mae + "=?, " + email + "=?, " +
                                            fumante + "=?, " + idOM + "=?, " + idComportamento + "=?, " + idChImediato + "=?, " + idFormacaoOrigem + "=?, " + sexo + "=?, " + 
                                            ultfuncao1 + "=?, " + ultfuncao2 + "=?, " + ultfuncao3 + "=?, " + idTAF + "=?, " + idPromocao + "=?, " + idPreparacao + "=?, " + 
                                            idUniforme + "=?, " +  
                                  "WHERE " + idt + "=?;";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + idt + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(Aluno al) {
        if (al != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setString(1, al.getIdentidade());
                pstm.setInt(2, al.getSituacao());
                pstm.setInt(3, al.getIdPostoGraduacao());
                pstm.setInt(4, al.getIdQasQms());
                pstm.setInt(5, al.getIdCmt());
                pstm.setDate(6, al.getDataNascimento());
                pstm.setString(7, al.getNome());
                pstm.setString(8, al.getSobrenome());
                pstm.setString(9, al.getNomeguerra());
                pstm.setString(10, al.getPreccp());
                pstm.setString(11, al.getCp());
                pstm.setString(12, al.getCpf());
                pstm.setDate(13, al.getUltDataPraca());
                pstm.setInt(14, al.getIdNatCidade());
                pstm.setInt(15, al.getIdEstadoCivil());
                pstm.setString(16, al.getTs());
                pstm.setInt(17, al.getFtrh());
                pstm.setString(18, al.getPai());
                pstm.setString(19, al.getMae());
                pstm.setString(20, al.getEmail());
                pstm.setInt(21, al.getFumante());
                pstm.setInt(22, al.getIdOM());
                pstm.setInt(23, al.getIdComportamento());
                pstm.setInt(24, al.getIdChImto());
                pstm.setInt(25, al.getIdFormOrigem());
                pstm.setString(26, al.getSexo());
                pstm.setString(27, al.getUltfuncao1());
                pstm.setString(28, al.getUltfuncao2());
                pstm.setString(29, al.getUltfuncao3());
                pstm.setInt(30, al.getIdTaf());
                pstm.setInt(31, al.getIdPromocao());
                pstm.setInt(32, al.getIdPreparacao());
                pstm.setInt(33, al.getIdUniforme());                
                                                              
                pstm.execute();
                
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {
            throw new RuntimeException();
        }
    }
    
    //Update SQL
    public void update(Aluno al) {
        if (al != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);                
                
                pstm.setInt(1, al.getSituacao());
                pstm.setInt(2, al.getIdPostoGraduacao());
                pstm.setInt(3, al.getIdQasQms());
                pstm.setInt(4, al.getIdCmt());
                pstm.setDate(5, al.getDataNascimento());
                pstm.setString(6, al.getNome());
                pstm.setString(7, al.getSobrenome());
                pstm.setString(8, al.getNomeguerra());
                pstm.setString(9, al.getPreccp());
                pstm.setString(10, al.getCp());
                pstm.setString(11, al.getCpf());
                pstm.setDate(12, al.getUltDataPraca());
                pstm.setInt(13, al.getIdNatCidade());
                pstm.setInt(14, al.getIdEstadoCivil());
                pstm.setString(15, al.getTs());
                pstm.setInt(16, al.getFtrh());
                pstm.setString(17, al.getPai());
                pstm.setString(18, al.getMae());
                pstm.setString(19, al.getEmail());
                pstm.setInt(20, al.getFumante());
                pstm.setInt(21, al.getIdOM());
                pstm.setInt(22, al.getIdComportamento());
                pstm.setInt(23, al.getIdChImto());
                pstm.setInt(24, al.getIdFormOrigem());
                pstm.setString(25, al.getSexo());
                pstm.setString(26, al.getUltfuncao1());
                pstm.setString(27, al.getUltfuncao2());
                pstm.setString(28, al.getUltfuncao3());
                pstm.setInt(29, al.getIdTaf());
                pstm.setInt(30, al.getIdPromocao());
                pstm.setInt(31, al.getIdPreparacao());
                pstm.setInt(32, al.getIdUniforme());
                pstm.setString(33, al.getIdentidade());
            
                pstm.execute();
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {            
            throw new RuntimeException();
        }
    }
    
    //Delete SQL
    public void delete(String idt) {
        if (idt != null){
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setString(1, idt);
            
                pstm.execute();
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {            
            throw new RuntimeException();
        }
    }
    
    private final String GETALUNOBYIDT = "SELECT * " +
                                         "FROM " + tabela + " " +
                                         "WHERE idt = ?;";
       
    public Aluno getAlunoById(String idtAl){
        Aluno al = new Aluno();

        PostoGraduacaoDAO pgDAO = new PostoGraduacaoDAO();
        QasQmsDAO qqDAO = new QasQmsDAO();
        ComandanteDAO cmtDAO = new ComandanteDAO();
        CidadeDAO natcidDAO = new CidadeDAO();
        EstadoCivilDAO ecDAO = new EstadoCivilDAO();
        OmDAO omDAO = new OmDAO();
        ComportamentoDAO cptmDAO = new ComportamentoDAO();
        ChefeImediatoDAO chimtoDAO = new ChefeImediatoDAO();
        FormacaoOrigemDAO formorigemDAO = new FormacaoOrigemDAO();
        TafDAO tafDAO = new TafDAO();
        PromocaoDAO promDAO = new PromocaoDAO();
        PreparacaoDAO prepDAO = new PreparacaoDAO();
        UniformeDAO unDAO = new UniformeDAO();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETALUNOBYIDT);
            pstm.setString(1, idtAl);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                al.setIdentidade(rs.getString("identidade"));
                al.setSituacao(rs.getInt("situacao"));
                
                PostoGraduacao pg = pgDAO.getPostoGraduacaoById(rs.getInt("idPostoGraduacao"));
                al.setIdPostoGraduacao(pg.getId());
                al.setNomePostoGraduacao(pg.getNome());
                al.setAbreviaturaPostoGraduacao(pg.getAbreviatura());
                al.setCirculohierarquicoPostoGraduacao(pg.getCirculohierarquico());                
                al.setIdForcaPostoGraduacao(pg.getIdForca());
                al.setNomeForcaPostoGraduacao(pg.getNomeForca());
                al.setSiglaForcaPostoGraduacao(pg.getSiglaForca());
                al.setIdTipoForcaPostoGraduacao(pg.getIdTipoForca());
                al.setNomeTipoForcaPostoGraduacao(pg.getNomeTipoForca());
                al.setIdCategoriaPostoGraduacao(pg.getIdCategoria());
                al.setNomeCategoriaPostoGraduacao(pg.getNomeCategoria());
                al.setDescricaoCategoriaPostoGraduacao(pg.getDescricaoCategoria());
                
                QasQms qq = qqDAO.getQasQmsById(rs.getInt("idQasQms"));
                al.setIdQasQms(qq.getId());
                al.setNomeQasQms(qq.getNome());
                al.setAbreviaturaQasQms(qq.getAbreviatura());
                al.setIdForcaQasQms(qq.getIdForca());
                al.setNomeForcaQasQms(qq.getNomeForca());
                al.setSiglaForcaQasQms(qq.getSiglaForca());
                al.setIdTipoForcaQasQms(qq.getIdTipoForca());
                al.setNomeTipoForcaQasQms(qq.getNomeTipoForca());
                
                Comandante cmt = cmtDAO.getComandanteById(rs.getInt("idComandante"));
                al.setIdCmt(cmt.getId());
                al.setNomeCmt(cmt.getNome());
                al.setSobrenomeCmt(cmt.getSobrenome());
                al.setNomeguerraCmt(cmt.getNomeguerra());
                al.setIdPostoGraduacaoCmt(cmt.getIdPostoGraduacao());
                al.setNomePostoGraduacaoCmt(cmt.getNomePostoGraduacao());
                al.setAbreviaturaPostoGraduacaoCmt(cmt.getAbreviaturaPostoGraduacao());
                al.setCirculohierarquicoPostoGraduacaoCmt(cmt.getCirculohierarquicoPostoGraduacao());                
                al.setIdForcaPostoGraduacaoCmt(cmt.getIdForcaPostoGraduacao());
                al.setNomeForcaPostoGraduacaoCmt(cmt.getNomeForcaPostoGraduacao());
                al.setSiglaForcaPostoGraduacaoCmt(cmt.getSiglaForcaPostoGraduacao());
                al.setIdTipoForcaPostoGraduacaoCmt(cmt.getIdTipoForcaPostoGraduacao());
                al.setNomeTipoForcaPostoGraduacaoCmt(cmt.getNomeTipoForcaPostoGraduacao());
                al.setIdCategoriaPostoGraduacaoCmt(cmt.getIdCategoriaPostoGraduacao());
                al.setNomeCategoriaPostoGraduacaoCmt(cmt.getNomeCategoriaPostoGraduacao());
                al.setDescricaoCategoriaPostoGraduacaoCmt(cmt.getDescricaoCategoriaPostoGraduacao());
                
                al.setDataNascimento(rs.getDate("datanascimento"));
                al.setNome(rs.getString("nome"));
                al.setSobrenome(rs.getString("sobrenome"));
                al.setNomeguerra(rs.getString("nomeguerra"));
                al.setPreccp(rs.getString("preccp"));
                al.setCp(rs.getString("cp"));
                al.setCpf(rs.getString("cpf"));
                al.setUltDataPraca(rs.getDate("ultdatapraca"));
                
                Cidade natcid = natcidDAO.getCidadeById(rs.getInt("idNaturalidadeCidade"));
                al.setIdNatCidade(natcid.getId());
                al.setNomeNatCidade(natcid.getNome());
                al.setIdEstadoNatCidade(natcid.getIdEstado());
                al.setNomeEstadoNatCidade(natcid.getNomeEstado());
                al.setSiglaEstadoNatCidade(natcid.getSiglaEstado());
                al.setIdRegiaoEstadoNatCidade(natcid.getIdRegiaoEstado());
                al.setNomeRegiaoEstadoNatCidade(natcid.getNomeRegiaoEstado());
                
                EstadoCivil ec = ecDAO.getEstadoCivilById(rs.getInt("idEstadoCivil"));
                al.setIdEstadoCivil(ec.getId());
                al.setNomeEstadoCivil(ec.getNome());
                
                al.setTs(rs.getString("ts"));
                al.setFtrh(rs.getInt("ftrh"));
                al.setPai(rs.getString("pai"));
                al.setMae(rs.getString("mae"));
                al.setEmail(rs.getString("email"));
                al.setFumante(rs.getInt("fumante"));
                
                Om om = omDAO.getOmById(rs.getInt("idOM"));
                al.setIdOM(om.getId());
                al.setNomeOM(om.getNome());
                al.setAbreviaturaOM(om.getAbreviatura());
                al.setNumenderecoOM(om.getNumendereco());
                al.setIdForcaOM(om.getIdForca());
                al.setNomeForcaOM(om.getNomeForca());
                al.setSiglaForcaOM(om.getSiglaForca());
                al.setIdTipoForcaOM(om.getIdTipoForca());
                al.setNomeTipoForcaOM(om.getNomeTipoForca());
                al.setIdEstadoOM(om.getIdEstado());
                al.setNomeEstadoOM(om.getNomeEstado());
                al.setSiglaEstadoOM(om.getSiglaEstado());
                al.setIdRegiaoEstadoOM(om.getIdRegiaoEstado());
                al.setNomeRegiaoEstadoOM(om.getNomeRegiaoEstado());
                al.setIdEnderecoOM(om.getIdEndereco());
                al.setCepEnderecoOM(om.getCepEndereco());
                al.setDescricaoEnderecoOM(om.getDescricaoEndereco());
                al.setComplementoEnderecoOM(om.getComplementoEndereco());
                al.setPontoreferenciaEnderecoOM(om.getPontoreferenciaEndereco());
                al.setBairroEnderecoOM(om.getBairroEndereco());
                al.setIdCidadeEnderecoOM(om.getIdCidadeEndereco());
                al.setNomeCidadeEnderecoOM(om.getNomeCidadeEndereco());
                al.setIdEstadoCidadeEnderecoOM(om.getIdEstadoCidadeEndereco());
                al.setNomeEstadoCidadeEnderecoOM(om.getNomeEstadoCidadeEndereco());
                al.setSiglaEstadoCidadeEnderecoOM(om.getSiglaEstadoCidadeEndereco());
                al.setIdRegiaoEstadoCidadeEnderecoOM(om.getIdRegiaoEstadoCidadeEndereco());
                al.setNomeRegiaoEstadoCidadeEnderecoOM(om.getNomeRegiaoEstadoCidadeEndereco());
                
                Comportamento cptm = cptmDAO.getComportamentoById(rs.getInt("idComportamento"));
                al.setIdComportamento(cptm.getId());
                al.setNomeComportamento(cptm.getNome());
                
                ChefeImediato chimto = chimtoDAO.getChefeImediatoById(rs.getInt("idChImediato"));
                al.setIdChImto(chimto.getId());
                al.setNomeChImto(chimto.getNome());
                al.setSobrenomeChImto(chimto.getSobrenome());
                al.setNomeguerraChImto(chimto.getNomeguerra());
                al.setIdPostoGraduacaoChImto(chimto.getIdPostoGraduacao());
                al.setNomePostoGraduacaoChImto(chimto.getNomePostoGraduacao());
                al.setAbreviaturaPostoGraduacaoChImto(chimto.getAbreviaturaPostoGraduacao());
                al.setCirculohierarquicoPostoGraduacaoChImto(chimto.getCirculohierarquicoPostoGraduacao());
                al.setIdForcaPostoGraduacaoChImto(chimto.getIdForcaPostoGraduacao());
                al.setNomeForcaPostoGraduacaoChImto(chimto.getNomeForcaPostoGraduacao());
                al.setSiglaForcaPostoGraduacaoChImto(chimto.getSiglaForcaPostoGraduacao());
                al.setIdTipoForcaPostoGraduacaoChImto(chimto.getIdTipoForcaPostoGraduacao());
                al.setNomeTipoForcaPostoGraduacaoChImto(chimto.getNomeTipoForcaPostoGraduacao());
                al.setIdCategoriaPostoGraduacaoChImto(chimto.getIdCategoriaPostoGraduacao());
                al.setNomeCategoriaPostoGraduacaoChImto(chimto.getNomeCategoriaPostoGraduacao());
                al.setDescricaoCategoriaPostoGraduacaoChImto(chimto.getDescricaoCategoriaPostoGraduacao());
                
                FormacaoOrigem formorigem = formorigemDAO.getFormacaoOrigemById(rs.getInt("idFormacaoOrigem"));
                al.setIdFormOrigem(formorigem.getId());
                al.setTurmaFormOrigem(formorigem.getTurma());
                al.setIdEscolaFormacaoFormOrigem(formorigem.getIdEscolaFormacao());
                al.setNomeEscolaFormacaoFormOrigem(formorigem.getNomeEscolaFormacao());
                al.setAbreviaturaEscolaFormacaoFormOrigem(formorigem.getAbreviaturaEscolaFormacao());
                al.setIdForcaEscolaFormacaoFormOrigem(formorigem.getIdForcaEscolaFormacao());
                al.setNomeForcaEscolaFormacaoFormOrigem(formorigem.getNomeForcaEscolaFormacao());
                al.setSiglaForcaEscolaFormacaoFormOrigem(formorigem.getSiglaForcaEscolaFormacao());
                al.setIdTipoForcaEscolaFormacaoFormOrigem(formorigem.getIdTipoForcaEscolaFormacao());
                al.setNomeForcaEscolaFormacaoFormOrigem(formorigem.getNomeForcaEscolaFormacao());
                
                al.setSexo(rs.getString("sexo"));
                al.setUltfuncao1(rs.getString("ultfuncao1"));
                al.setUltfuncao2(rs.getString("ultfuncao2"));
                al.setUltfuncao3(rs.getString("ultfuncao3"));
                
                Taf taf = tafDAO.getTafById(rs.getInt("idTAF"));
                al.setIdTaf(taf.getId());
                al.setDataUltTaf(taf.getDataUltTaf());
                al.setMencaoTaf(taf.getMencao());
                
                Promocao prom = promDAO.getPromocaoById(rs.getInt("idPromocao"));
                al.setIdPromocao(prom.getId());
                al.setDataultpromocao(prom.getDataultpromocao());
                al.setQapromocao(prom.getQapromocao());
                al.setDataqapromocao(prom.getDataqapromocao());
                
                Preparacao prep = prepDAO.getPreparacaoById(rs.getInt("idPreparacao"));
                al.setIdPreparacao(prep.getId());
                al.setPrepFisicaPreparacao(prep.getPrepFisica());
                al.setApoioFamiliaPreparacao(prep.getApoioFamilia());
                al.setApoioOMPreparacao(prep.getApoioOM());
                al.setCursoPreparacaoCOSPreparacao(prep.getCursoPreparacaoCOS());
                al.setProblemaRedimentoPreparacao(prep.getProblemaRedimento());
                al.setDedicacaoDoutrinaOPSPreparacao(prep.getDedicacaoDoutrinaOPS());
                al.setFatorMotivadorPreparacao(prep.getFatorMotivador());
                al.setConsultaSitePreparacao(prep.getConsultaSite());
                al.setCsltAmbVirtualAlPreparacao(prep.getCsltAmbVirtualAl());
                
                Uniforme un = unDAO.getUniformeById(rs.getInt("idUniforme"));
                al.setIdUniforme(un.getId());
                al.setTamCoturnoUniforme(un.getTamCoturno());
                al.setTamGandolaUniforme(un.getTamGandola());
                al.setTamCalcaUniforme(un.getTamCalca());
                al.setTamCamisaCamufladaUniforme(un.getTamCamisaCamuflada());
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return al;
    }
    
    private final String GETALUNOS = "SELECT * " +
                                     "FROM " + tabela;
       
    public ArrayList<Aluno> getAlunos(){
        ArrayList<Aluno> alunos = new ArrayList<>();        
        PostoGraduacaoDAO pgDAO = new PostoGraduacaoDAO();
        QasQmsDAO qqDAO = new QasQmsDAO();
        ComandanteDAO cmtDAO = new ComandanteDAO();
        CidadeDAO natcidDAO = new CidadeDAO();
        EstadoCivilDAO ecDAO = new EstadoCivilDAO();
        OmDAO omDAO = new OmDAO();
        ComportamentoDAO cptmDAO = new ComportamentoDAO();
        ChefeImediatoDAO chimtoDAO = new ChefeImediatoDAO();
        FormacaoOrigemDAO formorigemDAO = new FormacaoOrigemDAO();
        TafDAO tafDAO = new TafDAO();
        PromocaoDAO promDAO = new PromocaoDAO();
        PreparacaoDAO prepDAO = new PreparacaoDAO();
        UniformeDAO unDAO = new UniformeDAO();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETALUNOS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Aluno al = new Aluno();
                
                al.setIdentidade(rs.getString("identidade"));
                al.setSituacao(rs.getInt("situacao"));
                
                PostoGraduacao pg = pgDAO.getPostoGraduacaoById(rs.getInt("idPostoGraduacao"));
                al.setIdPostoGraduacao(pg.getId());
                al.setNomePostoGraduacao(pg.getNome());
                al.setAbreviaturaPostoGraduacao(pg.getAbreviatura());
                al.setCirculohierarquicoPostoGraduacao(pg.getCirculohierarquico());                
                al.setIdForcaPostoGraduacao(pg.getIdForca());
                al.setNomeForcaPostoGraduacao(pg.getNomeForca());
                al.setSiglaForcaPostoGraduacao(pg.getSiglaForca());
                al.setIdTipoForcaPostoGraduacao(pg.getIdTipoForca());
                al.setNomeTipoForcaPostoGraduacao(pg.getNomeTipoForca());
                al.setIdCategoriaPostoGraduacao(pg.getIdCategoria());
                al.setNomeCategoriaPostoGraduacao(pg.getNomeCategoria());
                al.setDescricaoCategoriaPostoGraduacao(pg.getDescricaoCategoria());
                
                QasQms qq = qqDAO.getQasQmsById(rs.getInt("idQasQms"));
                al.setIdQasQms(qq.getId());
                al.setNomeQasQms(qq.getNome());
                al.setAbreviaturaQasQms(qq.getAbreviatura());
                al.setIdForcaQasQms(qq.getIdForca());
                al.setNomeForcaQasQms(qq.getNomeForca());
                al.setSiglaForcaQasQms(qq.getSiglaForca());
                al.setIdTipoForcaQasQms(qq.getIdTipoForca());
                al.setNomeTipoForcaQasQms(qq.getNomeTipoForca());
                
                Comandante cmt = cmtDAO.getComandanteById(rs.getInt("idComandante"));
                al.setIdCmt(cmt.getId());
                al.setNomeCmt(cmt.getNome());
                al.setSobrenomeCmt(cmt.getSobrenome());
                al.setNomeguerraCmt(cmt.getNomeguerra());
                al.setIdPostoGraduacaoCmt(cmt.getIdPostoGraduacao());
                al.setNomePostoGraduacaoCmt(cmt.getNomePostoGraduacao());
                al.setAbreviaturaPostoGraduacaoCmt(cmt.getAbreviaturaPostoGraduacao());
                al.setCirculohierarquicoPostoGraduacaoCmt(cmt.getCirculohierarquicoPostoGraduacao());                
                al.setIdForcaPostoGraduacaoCmt(cmt.getIdForcaPostoGraduacao());
                al.setNomeForcaPostoGraduacaoCmt(cmt.getNomeForcaPostoGraduacao());
                al.setSiglaForcaPostoGraduacaoCmt(cmt.getSiglaForcaPostoGraduacao());
                al.setIdTipoForcaPostoGraduacaoCmt(cmt.getIdTipoForcaPostoGraduacao());
                al.setNomeTipoForcaPostoGraduacaoCmt(cmt.getNomeTipoForcaPostoGraduacao());
                al.setIdCategoriaPostoGraduacaoCmt(cmt.getIdCategoriaPostoGraduacao());
                al.setNomeCategoriaPostoGraduacaoCmt(cmt.getNomeCategoriaPostoGraduacao());
                al.setDescricaoCategoriaPostoGraduacaoCmt(cmt.getDescricaoCategoriaPostoGraduacao());
                
                al.setDataNascimento(rs.getDate("datanascimento"));
                al.setNome(rs.getString("nome"));
                al.setSobrenome(rs.getString("sobrenome"));
                al.setNomeguerra(rs.getString("nomeguerra"));
                al.setPreccp(rs.getString("preccp"));
                al.setCp(rs.getString("cp"));
                al.setCpf(rs.getString("cpf"));
                al.setUltDataPraca(rs.getDate("ultdatapraca"));
                
                Cidade natcid = natcidDAO.getCidadeById(rs.getInt("idNaturalidadeCidade"));
                al.setIdNatCidade(natcid.getId());
                al.setNomeNatCidade(natcid.getNome());
                al.setIdEstadoNatCidade(natcid.getIdEstado());
                al.setNomeEstadoNatCidade(natcid.getNomeEstado());
                al.setSiglaEstadoNatCidade(natcid.getSiglaEstado());
                al.setIdRegiaoEstadoNatCidade(natcid.getIdRegiaoEstado());
                al.setNomeRegiaoEstadoNatCidade(natcid.getNomeRegiaoEstado());
                
                EstadoCivil ec = ecDAO.getEstadoCivilById(rs.getInt("idEstadoCivil"));
                al.setIdEstadoCivil(ec.getId());
                al.setNomeEstadoCivil(ec.getNome());
                
                al.setTs(rs.getString("ts"));
                al.setFtrh(rs.getInt("ftrh"));
                al.setPai(rs.getString("pai"));
                al.setMae(rs.getString("mae"));
                al.setEmail(rs.getString("email"));
                al.setFumante(rs.getInt("fumante"));
                
                Om om = omDAO.getOmById(rs.getInt("idOM"));
                al.setIdOM(om.getId());
                al.setNomeOM(om.getNome());
                al.setAbreviaturaOM(om.getAbreviatura());
                al.setNumenderecoOM(om.getNumendereco());
                al.setIdForcaOM(om.getIdForca());
                al.setNomeForcaOM(om.getNomeForca());
                al.setSiglaForcaOM(om.getSiglaForca());
                al.setIdTipoForcaOM(om.getIdTipoForca());
                al.setNomeTipoForcaOM(om.getNomeTipoForca());
                al.setIdEstadoOM(om.getIdEstado());
                al.setNomeEstadoOM(om.getNomeEstado());
                al.setSiglaEstadoOM(om.getSiglaEstado());
                al.setIdRegiaoEstadoOM(om.getIdRegiaoEstado());
                al.setNomeRegiaoEstadoOM(om.getNomeRegiaoEstado());
                al.setIdEnderecoOM(om.getIdEndereco());
                al.setCepEnderecoOM(om.getCepEndereco());
                al.setDescricaoEnderecoOM(om.getDescricaoEndereco());
                al.setComplementoEnderecoOM(om.getComplementoEndereco());
                al.setPontoreferenciaEnderecoOM(om.getPontoreferenciaEndereco());
                al.setBairroEnderecoOM(om.getBairroEndereco());
                al.setIdCidadeEnderecoOM(om.getIdCidadeEndereco());
                al.setNomeCidadeEnderecoOM(om.getNomeCidadeEndereco());
                al.setIdEstadoCidadeEnderecoOM(om.getIdEstadoCidadeEndereco());
                al.setNomeEstadoCidadeEnderecoOM(om.getNomeEstadoCidadeEndereco());
                al.setSiglaEstadoCidadeEnderecoOM(om.getSiglaEstadoCidadeEndereco());
                al.setIdRegiaoEstadoCidadeEnderecoOM(om.getIdRegiaoEstadoCidadeEndereco());
                al.setNomeRegiaoEstadoCidadeEnderecoOM(om.getNomeRegiaoEstadoCidadeEndereco());
                
                Comportamento cptm = cptmDAO.getComportamentoById(rs.getInt("idComportamento"));
                al.setIdComportamento(cptm.getId());
                al.setNomeComportamento(cptm.getNome());
                
                ChefeImediato chimto = chimtoDAO.getChefeImediatoById(rs.getInt("idChImediato"));
                al.setIdChImto(chimto.getId());
                al.setNomeChImto(chimto.getNome());
                al.setSobrenomeChImto(chimto.getSobrenome());
                al.setNomeguerraChImto(chimto.getNomeguerra());
                al.setIdPostoGraduacaoChImto(chimto.getIdPostoGraduacao());
                al.setNomePostoGraduacaoChImto(chimto.getNomePostoGraduacao());
                al.setAbreviaturaPostoGraduacaoChImto(chimto.getAbreviaturaPostoGraduacao());
                al.setCirculohierarquicoPostoGraduacaoChImto(chimto.getCirculohierarquicoPostoGraduacao());
                al.setIdForcaPostoGraduacaoChImto(chimto.getIdForcaPostoGraduacao());
                al.setNomeForcaPostoGraduacaoChImto(chimto.getNomeForcaPostoGraduacao());
                al.setSiglaForcaPostoGraduacaoChImto(chimto.getSiglaForcaPostoGraduacao());
                al.setIdTipoForcaPostoGraduacaoChImto(chimto.getIdTipoForcaPostoGraduacao());
                al.setNomeTipoForcaPostoGraduacaoChImto(chimto.getNomeTipoForcaPostoGraduacao());
                al.setIdCategoriaPostoGraduacaoChImto(chimto.getIdCategoriaPostoGraduacao());
                al.setNomeCategoriaPostoGraduacaoChImto(chimto.getNomeCategoriaPostoGraduacao());
                al.setDescricaoCategoriaPostoGraduacaoChImto(chimto.getDescricaoCategoriaPostoGraduacao());
                
                FormacaoOrigem formorigem = formorigemDAO.getFormacaoOrigemById(rs.getInt("idFormacaoOrigem"));
                al.setIdFormOrigem(formorigem.getId());
                al.setTurmaFormOrigem(formorigem.getTurma());
                al.setIdEscolaFormacaoFormOrigem(formorigem.getIdEscolaFormacao());
                al.setNomeEscolaFormacaoFormOrigem(formorigem.getNomeEscolaFormacao());
                al.setAbreviaturaEscolaFormacaoFormOrigem(formorigem.getAbreviaturaEscolaFormacao());
                al.setIdForcaEscolaFormacaoFormOrigem(formorigem.getIdForcaEscolaFormacao());
                al.setNomeForcaEscolaFormacaoFormOrigem(formorigem.getNomeForcaEscolaFormacao());
                al.setSiglaForcaEscolaFormacaoFormOrigem(formorigem.getSiglaForcaEscolaFormacao());
                al.setIdTipoForcaEscolaFormacaoFormOrigem(formorigem.getIdTipoForcaEscolaFormacao());
                al.setNomeForcaEscolaFormacaoFormOrigem(formorigem.getNomeForcaEscolaFormacao());
                
                al.setSexo(rs.getString("sexo"));
                al.setUltfuncao1(rs.getString("ultfuncao1"));
                al.setUltfuncao2(rs.getString("ultfuncao2"));
                al.setUltfuncao3(rs.getString("ultfuncao3"));
                
                Taf taf = tafDAO.getTafById(rs.getInt("idTAF"));
                al.setIdTaf(taf.getId());
                al.setDataUltTaf(taf.getDataUltTaf());
                al.setMencaoTaf(taf.getMencao());
                
                Promocao prom = promDAO.getPromocaoById(rs.getInt("idPromocao"));
                al.setIdPromocao(prom.getId());
                al.setDataultpromocao(prom.getDataultpromocao());
                al.setQapromocao(prom.getQapromocao());
                al.setDataqapromocao(prom.getDataqapromocao());
                
                Preparacao prep = prepDAO.getPreparacaoById(rs.getInt("idPreparacao"));
                al.setIdPreparacao(prep.getId());
                al.setPrepFisicaPreparacao(prep.getPrepFisica());
                al.setApoioFamiliaPreparacao(prep.getApoioFamilia());
                al.setApoioOMPreparacao(prep.getApoioOM());
                al.setCursoPreparacaoCOSPreparacao(prep.getCursoPreparacaoCOS());
                al.setProblemaRedimentoPreparacao(prep.getProblemaRedimento());
                al.setDedicacaoDoutrinaOPSPreparacao(prep.getDedicacaoDoutrinaOPS());
                al.setFatorMotivadorPreparacao(prep.getFatorMotivador());
                al.setConsultaSitePreparacao(prep.getConsultaSite());
                al.setCsltAmbVirtualAlPreparacao(prep.getCsltAmbVirtualAl());
                
                Uniforme un = unDAO.getUniformeById(rs.getInt("idUniforme"));
                al.setIdUniforme(un.getId());
                al.setTamCoturnoUniforme(un.getTamCoturno());
                al.setTamGandolaUniforme(un.getTamGandola());
                al.setTamCalcaUniforme(un.getTamCalca());
                al.setTamCamisaCamufladaUniforme(un.getTamCamisaCamuflada());
                
                alunos.add(al);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return alunos;
    }
    
    
    
    private final static String GETALUNODWR = "select identidade, nome, sobrenome, nomeguerra " +
                                              "from Aluno " +
                                              "where identidade = ?";
    
    public static Aluno getAlunoByIdentidadeDWR(String identidade){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Aluno al = new Aluno();
        
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETALUNODWR);
            pstm.setString(1, identidade);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
               al.setIdentidade(rs.getString("identidade"));
               al.setNome(rs.getString("nome"));
               al.setSobrenome(rs.getString("sobrenome"));
               al.setNomeguerra(rs.getString("nomeguerra"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return al;
    }
}
