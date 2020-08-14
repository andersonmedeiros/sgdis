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
import model.bean.Banco;

/**
 *
 * @author anderson
 */
public class BancoDAO {
    //Tabela
    String tabela = "Banco";
    
    //Atributos
    String id = "id";
    String banco = "banco";
    String agencia = "agencia";
    String dvagencia = "dvagencia";
    String conta = "conta";
    String dvconta = "dvconta";
    String idtAluno = "idtAluno";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + banco + "," + agencia +  "," + dvagencia + "," + conta +  "," + dvconta +  "," + idtAluno + ")" +
                                  " VALUES(?,?,?,?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + banco + "=?, " + agencia + "=?, " + dvagencia + "=?, " + conta + "=?, " + dvconta + "=?, " + idtAluno + "=? " +
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
    public void insert(Banco b) {
        if (b != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, b.getId());
                pstm.setString(2, b.getBanco());
                pstm.setString(3, b.getAgencia());
                pstm.setString(4, b.getDvagencia());
                pstm.setString(5, b.getConta());
                pstm.setString(6, b.getDvconta());
                pstm.setString(7, b.getIdentidadeAluno());
                
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
    public void update(Banco b) {
        if (b != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE); 
                
                pstm.setString(1, b.getBanco());
                pstm.setString(2, b.getAgencia());
                pstm.setString(3, b.getDvagencia());
                pstm.setString(4, b.getConta());
                pstm.setString(5, b.getDvconta());
                pstm.setString(6, b.getIdentidadeAluno());
                pstm.setInt(7, b.getId());
                
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
    
    private final String GETBANCOBYID = "SELECT * " +
                                        "FROM Banco " + 
                                        "WHERE id = ?";
       
    public Banco getBancoById(int id){
        Banco b = new Banco();
        AlunoDAO alDAO = new AlunoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETBANCOBYID);
            pstm.setInt(1, id);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                b.setId(rs.getInt("id"));
                b.setBanco(rs.getString("agencia"));               
                b.setAgencia(rs.getString("dvagencia"));               
                b.setDvagencia(rs.getString("dvagencia"));               
                b.setConta(rs.getString("conta"));               
                b.setDvconta(rs.getString("dvconta"));               
                
                Aluno al = alDAO.getAlunoByIdentidade(rs.getString("idtAluno"));
                b.setIdentidadeAluno(al.getIdentidade());
                b.setSituacaoAluno(al.getSituacao());
                b.setIdPostoGraduacaoAluno(al.getIdPostoGraduacao());
                b.setIdQasQmsAluno(al.getIdQasQms());
                b.setIdCmtAluno(al.getIdCmt());
                b.setDataNascimentoAluno(al.getDataNascimento());
                b.setNomeAluno(al.getNome());
                b.setSobrenomeAluno(al.getSobrenome());
                b.setNomeguerraAluno(al.getNomeguerra());
                b.setPreccpAluno(al.getPreccp());
                b.setCpAluno(al.getCp());
                b.setCpfAluno(al.getCpf());
                b.setUltDataPracaAluno(al.getUltDataPraca());
                b.setIdNatCidadeAluno(al.getIdNatCidade());
                b.setIdEstadoCivilAluno(al.getIdEstadoCivil());
                b.setTsAluno(al.getTs());
                b.setFtrhAluno(al.getFtrh());
                b.setPaiAluno(al.getPai());
                b.setMaeAluno(al.getMae());
                b.setEmailAluno(al.getEmail());
                b.setFumanteAluno(al.getFumante());
                b.setIdOMAluno(al.getIdOM());
                b.setIdComportamentoAluno(al.getIdComportamento());
                b.setIdChImtoAluno(al.getIdChImto());
                b.setSexoAluno(al.getSexo());
                b.setUltfuncao1Aluno(al.getUltfuncao1());
                b.setUltfuncao2Aluno(al.getUltfuncao2());
                b.setUltfuncao3Aluno(al.getUltfuncao3());
                b.setIdTafAluno(al.getIdTaf());
                b.setIdPromocaoAluno(al.getIdPromocao());
                b.setIdPreparacaoAluno(al.getIdPreparacao());
                b.setIdUniformeAluno(al.getIdUniforme());
                b.setEasAluno(al.getEas());
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return b;
    }
    
    private final String GETBANCOBYIDTALUNO = "SELECT * " +
                                            "FROM Banco " + 
                                            "WHERE idtAluno = ?";
       
    public Banco getBancoByIdtAluno(String idtAluno){
        Banco b = new Banco();
        AlunoDAO alDAO = new AlunoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETBANCOBYIDTALUNO);
            pstm.setString(1, idtAluno);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                b.setId(rs.getInt("id"));
                b.setBanco(rs.getString("agencia"));               
                b.setAgencia(rs.getString("dvagencia"));               
                b.setDvagencia(rs.getString("dvagencia"));               
                b.setConta(rs.getString("conta"));               
                b.setDvconta(rs.getString("dvconta"));               
                
                Aluno al = alDAO.getAlunoByIdentidade(rs.getString("idtAluno"));
                b.setIdentidadeAluno(al.getIdentidade());
                b.setSituacaoAluno(al.getSituacao());
                b.setIdPostoGraduacaoAluno(al.getIdPostoGraduacao());
                b.setIdQasQmsAluno(al.getIdQasQms());
                b.setIdCmtAluno(al.getIdCmt());
                b.setDataNascimentoAluno(al.getDataNascimento());
                b.setNomeAluno(al.getNome());
                b.setSobrenomeAluno(al.getSobrenome());
                b.setNomeguerraAluno(al.getNomeguerra());
                b.setPreccpAluno(al.getPreccp());
                b.setCpAluno(al.getCp());
                b.setCpfAluno(al.getCpf());
                b.setUltDataPracaAluno(al.getUltDataPraca());
                b.setIdNatCidadeAluno(al.getIdNatCidade());
                b.setIdEstadoCivilAluno(al.getIdEstadoCivil());
                b.setTsAluno(al.getTs());
                b.setFtrhAluno(al.getFtrh());
                b.setPaiAluno(al.getPai());
                b.setMaeAluno(al.getMae());
                b.setEmailAluno(al.getEmail());
                b.setFumanteAluno(al.getFumante());
                b.setIdOMAluno(al.getIdOM());
                b.setIdComportamentoAluno(al.getIdComportamento());
                b.setIdChImtoAluno(al.getIdChImto());
                b.setSexoAluno(al.getSexo());
                b.setUltfuncao1Aluno(al.getUltfuncao1());
                b.setUltfuncao2Aluno(al.getUltfuncao2());
                b.setUltfuncao3Aluno(al.getUltfuncao3());
                b.setIdTafAluno(al.getIdTaf());
                b.setIdPromocaoAluno(al.getIdPromocao());
                b.setIdPreparacaoAluno(al.getIdPreparacao());
                b.setIdUniformeAluno(al.getIdUniforme());
                b.setEasAluno(al.getEas());
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return b;
    }
    
    private final String GETBANCOS = "SELECT * " +
                                   "FROM " + tabela;
       
    public ArrayList<Banco> getBancos(){
        ArrayList<Banco> bs = new ArrayList<>();  
        AlunoDAO alDAO = new AlunoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETBANCOS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Banco b = new Banco();
                
                b.setId(rs.getInt("id"));
                b.setBanco(rs.getString("agencia"));               
                b.setAgencia(rs.getString("dvagencia"));               
                b.setDvagencia(rs.getString("dvagencia"));               
                b.setConta(rs.getString("conta"));               
                b.setDvconta(rs.getString("dvconta"));
                
                Aluno al = alDAO.getAlunoByIdentidade(rs.getString("idtAluno"));
                b.setIdentidadeAluno(al.getIdentidade());
                b.setSituacaoAluno(al.getSituacao());
                b.setIdPostoGraduacaoAluno(al.getIdPostoGraduacao());
                b.setIdQasQmsAluno(al.getIdQasQms());
                b.setIdCmtAluno(al.getIdCmt());
                b.setDataNascimentoAluno(al.getDataNascimento());
                b.setNomeAluno(al.getNome());
                b.setSobrenomeAluno(al.getSobrenome());
                b.setNomeguerraAluno(al.getNomeguerra());
                b.setPreccpAluno(al.getPreccp());
                b.setCpAluno(al.getCp());
                b.setCpfAluno(al.getCpf());
                b.setUltDataPracaAluno(al.getUltDataPraca());
                b.setIdNatCidadeAluno(al.getIdNatCidade());
                b.setIdEstadoCivilAluno(al.getIdEstadoCivil());
                b.setTsAluno(al.getTs());
                b.setFtrhAluno(al.getFtrh());
                b.setPaiAluno(al.getPai());
                b.setMaeAluno(al.getMae());
                b.setEmailAluno(al.getEmail());
                b.setFumanteAluno(al.getFumante());
                b.setIdOMAluno(al.getIdOM());
                b.setIdComportamentoAluno(al.getIdComportamento());
                b.setIdChImtoAluno(al.getIdChImto());
                b.setSexoAluno(al.getSexo());
                b.setUltfuncao1Aluno(al.getUltfuncao1());
                b.setUltfuncao2Aluno(al.getUltfuncao2());
                b.setUltfuncao3Aluno(al.getUltfuncao3());
                b.setIdTafAluno(al.getIdTaf());
                b.setIdPromocaoAluno(al.getIdPromocao());
                b.setIdPreparacaoAluno(al.getIdPreparacao());
                b.setIdUniformeAluno(al.getIdUniforme());
                b.setEasAluno(al.getEas());
                
                bs.add(b);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return bs;
    }
}
