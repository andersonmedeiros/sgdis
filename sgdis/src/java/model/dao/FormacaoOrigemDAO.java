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
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + turma + "," + idEscolaFormacao + ")" +
                                  " VALUES(?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + turma + "=?, " + idEscolaFormacao + "=?, " +
                                  "WHERE " + id + "=?;";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(FormacaoOrigem formorigem) {
        if (formorigem != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, formorigem.getId());
                pstm.setInt(2, formorigem.getTurma());
                pstm.setInt(3, formorigem.getIdEscolaFormacao());
                                                              
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
                pstm.setInt(3, formorigem.getId());
            
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
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETFORMACAOORIGEMBYID);
            pstm.setInt(1, idFormacaoOrigem);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                EscolaFormacao escform = escformDAO.getEscolaFormacaoById(rs.getInt("idEscolaFormacao"));
                formorigem.setId(rs.getInt("id"));
                formorigem.setTurma(rs.getInt("turma"));
                
                formorigem.setIdEscolaFormacao(escform.getId());
                formorigem.setNomeEscolaFormacao(escform.getNome());
                formorigem.setAbreviaturaEscolaFormacao(escform.getAbreviatura());
                formorigem.setIdForcaEscolaFormacao(escform.getIdForca());
                formorigem.setNomeForcaEscolaFormacao(escform.getNomeForca());
                formorigem.setSiglaForcaEscolaFormacao(escform.getSiglaForca());
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return formorigem;
    }
    
    private final String GETFORMACOESORIGEM = "SELECT * " +
                                              "FROM " + tabela;
       
    public ArrayList<FormacaoOrigem> getFormacoesOrigem(){
        ArrayList<FormacaoOrigem> formsoigem = new ArrayList<>();  
        EscolaFormacaoDAO escformDAO = new EscolaFormacaoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETFORMACOESORIGEM);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                FormacaoOrigem formorigem = new FormacaoOrigem();
                
                EscolaFormacao escform = escformDAO.getEscolaFormacaoById(rs.getInt("idEscolaFormacao"));
                formorigem.setId(rs.getInt("id"));
                formorigem.setTurma(rs.getInt("turma"));
                
                formorigem.setIdEscolaFormacao(escform.getId());
                formorigem.setNomeEscolaFormacao(escform.getNome());
                formorigem.setAbreviaturaEscolaFormacao(escform.getAbreviatura());
                formorigem.setIdForcaEscolaFormacao(escform.getIdForca());
                formorigem.setNomeForcaEscolaFormacao(escform.getNomeForca());
                formorigem.setSiglaForcaEscolaFormacao(escform.getSiglaForca());
                
                formsoigem.add(formorigem);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return formsoigem;
    }
}
