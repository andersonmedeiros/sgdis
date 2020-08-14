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
import model.bean.Aluno;
import model.bean.EscolaFormacao;
import model.bean.FormacaoOrigem;

/**
 *
 * @author anderson
 */
public class FormacaoOrigemDAO {
    //Tabela
    String tabela = "FormacaoOrigem";
    
    //Atributos
    String id = "id";
    String turma = "turma";
    String idEscolaFormacao = "idEscolaFormacao";
    String idtAluno = "idtAluno";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + turma + "," + idEscolaFormacao + "," + idtAluno + ")" +
                                  " VALUES(?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + turma + "=?, " + idEscolaFormacao + "=?, " + idtAluno + "=? " +
                                  "WHERE " + id + "=?;";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    private final String GETUltimoID = "SELECT MAX(" + id + ") as ultimo_id FROM " + tabela + ";";
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    //Próximo ID a ser inserido
    public int proxID(){
        int ultimo_id = 0;
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(GETUltimoID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                
                ultimo_id = rs.getInt("ultimo_id");
            }
           
            ConnectionFactory.fechaConexao(conn, pstm);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return (ultimo_id+1);
    }
    
    //Insert SQL
    public void insert(FormacaoOrigem formorigem) {
        if (formorigem != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, formorigem.getId());
                pstm.setInt(2, formorigem.getTurma());
                pstm.setInt(3, formorigem.getIdEscolaFormacao());
                pstm.setString(4, formorigem.getIdentidadeAluno());
                                                              
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
    public void update(FormacaoOrigem formorigem) {
        if (formorigem != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);                
                
                pstm.setInt(1, formorigem.getTurma());
                pstm.setInt(2, formorigem.getIdEscolaFormacao());                
                pstm.setString(3, formorigem.getIdentidadeAluno());
                pstm.setInt(4, formorigem.getId());
            
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
    public void delete(int id) {
        if (id != 0){
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setInt(1, id);
            
                pstm.execute();
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {            
            throw new RuntimeException();
        }
    }
    
    private final String GETFORMACAOORIGEMBYID = "SELECT * " +
                                                 "FROM " + tabela + " " +
                                                 "WHERE id = ?;";
       
    public FormacaoOrigem getFormacaoOrigemById(int idFormacaoOrigem){
        FormacaoOrigem formorigem = new FormacaoOrigem();
        EscolaFormacaoDAO escformDAO = new EscolaFormacaoDAO();
        AlunoDAO alDAO = new AlunoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETFORMACAOORIGEMBYID);
            pstm.setInt(1, idFormacaoOrigem);
           
            rs = pstm.executeQuery();
            while (rs.next()) {                
                formorigem.setId(rs.getInt("id"));
                formorigem.setTurma(rs.getInt("turma"));
                
                EscolaFormacao escform = escformDAO.getEscolaFormacaoById(rs.getInt("idEscolaFormacao"));
                formorigem.setIdEscolaFormacao(escform.getId());
                formorigem.setNomeEscolaFormacao(escform.getNome());
                formorigem.setAbreviaturaEscolaFormacao(escform.getAbreviatura());
                formorigem.setIdForcaEscolaFormacao(escform.getIdForca());
                formorigem.setNomeForcaEscolaFormacao(escform.getNomeForca());
                formorigem.setSiglaForcaEscolaFormacao(escform.getSiglaForca());
                formorigem.setIdTipoForcaEscolaFormacao(escform.getIdTipoForca());
                formorigem.setNomeTipoForcaEscolaFormacao(escform.getNomeTipoForca());
                
                Aluno al = alDAO.getAlunoByIdentidade(rs.getString("idtAluno"));
                formorigem.setIdentidadeAluno(al.getIdentidade());
                formorigem.setSituacaoAluno(al.getSituacao());
                formorigem.setIdPostoGraduacaoAluno(al.getIdPostoGraduacao());
                formorigem.setIdQasQmsAluno(al.getIdQasQms());
                formorigem.setIdCmtAluno(al.getIdCmt());
                formorigem.setDataNascimentoAluno(al.getDataNascimento());
                formorigem.setNomeAluno(al.getNome());
                formorigem.setSobrenomeAluno(al.getSobrenome());
                formorigem.setNomeguerraAluno(al.getNomeguerra());
                formorigem.setPreccpAluno(al.getPreccp());
                formorigem.setCpAluno(al.getCp());
                formorigem.setCpfAluno(al.getCpf());
                formorigem.setUltDataPracaAluno(al.getUltDataPraca());
                formorigem.setIdNatCidadeAluno(al.getIdNatCidade());
                formorigem.setIdEstadoCivilAluno(al.getIdEstadoCivil());
                formorigem.setTsAluno(al.getTs());
                formorigem.setFtrhAluno(al.getFtrh());
                formorigem.setPaiAluno(al.getPai());
                formorigem.setMaeAluno(al.getMae());
                formorigem.setEmailAluno(al.getEmail());
                formorigem.setFumanteAluno(al.getFumante());
                formorigem.setIdOMAluno(al.getIdOM());
                formorigem.setIdComportamentoAluno(al.getIdComportamento());
                formorigem.setIdChImtoAluno(al.getIdChImto());
                formorigem.setSexoAluno(al.getSexo());
                formorigem.setUltfuncao1Aluno(al.getUltfuncao1());
                formorigem.setUltfuncao2Aluno(al.getUltfuncao2());
                formorigem.setUltfuncao3Aluno(al.getUltfuncao3());
                formorigem.setIdTafAluno(al.getIdTaf());
                formorigem.setIdPromocaoAluno(al.getIdPromocao());
                formorigem.setIdPreparacaoAluno(al.getIdPreparacao());
                formorigem.setIdUniformeAluno(al.getIdUniforme());
                formorigem.setEasAluno(al.getEas());
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return formorigem;
    }
    
    private final String GETFORMACAOORIGEMEXISTENTE = "SELECT * " + 
                                                " FROM " + tabela + 
                                                " WHERE " + turma + "=? AND " + idEscolaFormacao + "=? AND " + idtAluno + "=?;" ;

    public FormacaoOrigem getFormacaoOrigemExistente(int turma, int idEscolaFormacao, String idtAluno){
        FormacaoOrigem formorigem = new FormacaoOrigem();   
        EscolaFormacaoDAO escformDAO = new EscolaFormacaoDAO();
        AlunoDAO alDAO = new AlunoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETFORMACAOORIGEMEXISTENTE);
            pstm.setInt(1, turma);
            pstm.setInt(2, idEscolaFormacao);
            pstm.setString(3, idtAluno);
           
            rs = pstm.executeQuery();
            while (rs.next()) {                
                formorigem.setId(rs.getInt("id"));
                formorigem.setTurma(rs.getInt("turma"));
                
                EscolaFormacao escform = escformDAO.getEscolaFormacaoById(rs.getInt("idEscolaFormacao"));
                formorigem.setIdEscolaFormacao(escform.getId());
                formorigem.setNomeEscolaFormacao(escform.getNome());
                formorigem.setAbreviaturaEscolaFormacao(escform.getAbreviatura());
                formorigem.setIdForcaEscolaFormacao(escform.getIdForca());
                formorigem.setNomeForcaEscolaFormacao(escform.getNomeForca());
                formorigem.setSiglaForcaEscolaFormacao(escform.getSiglaForca());
                formorigem.setIdTipoForcaEscolaFormacao(escform.getIdTipoForca());
                formorigem.setNomeTipoForcaEscolaFormacao(escform.getNomeTipoForca());
                
                Aluno al = alDAO.getAlunoByIdentidade(rs.getString("idtAluno"));
                formorigem.setIdentidadeAluno(al.getIdentidade());
                formorigem.setSituacaoAluno(al.getSituacao());
                formorigem.setIdPostoGraduacaoAluno(al.getIdPostoGraduacao());
                formorigem.setIdQasQmsAluno(al.getIdQasQms());
                formorigem.setIdCmtAluno(al.getIdCmt());
                formorigem.setDataNascimentoAluno(al.getDataNascimento());
                formorigem.setNomeAluno(al.getNome());
                formorigem.setSobrenomeAluno(al.getSobrenome());
                formorigem.setNomeguerraAluno(al.getNomeguerra());
                formorigem.setPreccpAluno(al.getPreccp());
                formorigem.setCpAluno(al.getCp());
                formorigem.setCpfAluno(al.getCpf());
                formorigem.setUltDataPracaAluno(al.getUltDataPraca());
                formorigem.setIdNatCidadeAluno(al.getIdNatCidade());
                formorigem.setIdEstadoCivilAluno(al.getIdEstadoCivil());
                formorigem.setTsAluno(al.getTs());
                formorigem.setFtrhAluno(al.getFtrh());
                formorigem.setPaiAluno(al.getPai());
                formorigem.setMaeAluno(al.getMae());
                formorigem.setEmailAluno(al.getEmail());
                formorigem.setFumanteAluno(al.getFumante());
                formorigem.setIdOMAluno(al.getIdOM());
                formorigem.setIdComportamentoAluno(al.getIdComportamento());
                formorigem.setIdChImtoAluno(al.getIdChImto());
                formorigem.setSexoAluno(al.getSexo());
                formorigem.setUltfuncao1Aluno(al.getUltfuncao1());
                formorigem.setUltfuncao2Aluno(al.getUltfuncao2());
                formorigem.setUltfuncao3Aluno(al.getUltfuncao3());
                formorigem.setIdTafAluno(al.getIdTaf());
                formorigem.setIdPromocaoAluno(al.getIdPromocao());
                formorigem.setIdPreparacaoAluno(al.getIdPreparacao());
                formorigem.setIdUniformeAluno(al.getIdUniforme());
                formorigem.setEasAluno(al.getEas());
                
                return formorigem;
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return null;
    }
    
    private final String GETFORMACOESORIGEM = "SELECT * " +
                                              "FROM " + tabela;
       
    public ArrayList<FormacaoOrigem> getFormacoesOrigem(){
        ArrayList<FormacaoOrigem> formsorigem = new ArrayList<>();  
        EscolaFormacaoDAO escformDAO = new EscolaFormacaoDAO();
        AlunoDAO alDAO = new AlunoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETFORMACOESORIGEM);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                FormacaoOrigem formorigem = new FormacaoOrigem();
                
                formorigem.setId(rs.getInt("id"));
                formorigem.setTurma(rs.getInt("turma"));
                
                EscolaFormacao escform = escformDAO.getEscolaFormacaoById(rs.getInt("idEscolaFormacao"));
                formorigem.setIdEscolaFormacao(escform.getId());
                formorigem.setNomeEscolaFormacao(escform.getNome());
                formorigem.setAbreviaturaEscolaFormacao(escform.getAbreviatura());
                formorigem.setIdForcaEscolaFormacao(escform.getIdForca());
                formorigem.setNomeForcaEscolaFormacao(escform.getNomeForca());
                formorigem.setSiglaForcaEscolaFormacao(escform.getSiglaForca());
                formorigem.setIdTipoForcaEscolaFormacao(escform.getIdTipoForca());
                formorigem.setNomeTipoForcaEscolaFormacao(escform.getNomeTipoForca());
                
                Aluno al = alDAO.getAlunoByIdentidade(rs.getString("idtAluno"));
                formorigem.setIdentidadeAluno(al.getIdentidade());
                formorigem.setSituacaoAluno(al.getSituacao());
                formorigem.setIdPostoGraduacaoAluno(al.getIdPostoGraduacao());
                formorigem.setIdQasQmsAluno(al.getIdQasQms());
                formorigem.setIdCmtAluno(al.getIdCmt());
                formorigem.setDataNascimentoAluno(al.getDataNascimento());
                formorigem.setNomeAluno(al.getNome());
                formorigem.setSobrenomeAluno(al.getSobrenome());
                formorigem.setNomeguerraAluno(al.getNomeguerra());
                formorigem.setPreccpAluno(al.getPreccp());
                formorigem.setCpAluno(al.getCp());
                formorigem.setCpfAluno(al.getCpf());
                formorigem.setUltDataPracaAluno(al.getUltDataPraca());
                formorigem.setIdNatCidadeAluno(al.getIdNatCidade());
                formorigem.setIdEstadoCivilAluno(al.getIdEstadoCivil());
                formorigem.setTsAluno(al.getTs());
                formorigem.setFtrhAluno(al.getFtrh());
                formorigem.setPaiAluno(al.getPai());
                formorigem.setMaeAluno(al.getMae());
                formorigem.setEmailAluno(al.getEmail());
                formorigem.setFumanteAluno(al.getFumante());
                formorigem.setIdOMAluno(al.getIdOM());
                formorigem.setIdComportamentoAluno(al.getIdComportamento());
                formorigem.setIdChImtoAluno(al.getIdChImto());
                formorigem.setSexoAluno(al.getSexo());
                formorigem.setUltfuncao1Aluno(al.getUltfuncao1());
                formorigem.setUltfuncao2Aluno(al.getUltfuncao2());
                formorigem.setUltfuncao3Aluno(al.getUltfuncao3());
                formorigem.setIdTafAluno(al.getIdTaf());
                formorigem.setIdPromocaoAluno(al.getIdPromocao());
                formorigem.setIdPreparacaoAluno(al.getIdPreparacao());
                formorigem.setIdUniformeAluno(al.getIdUniforme());
                formorigem.setEasAluno(al.getEas());
                
                formsorigem.add(formorigem);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return formsorigem;
    }
}
