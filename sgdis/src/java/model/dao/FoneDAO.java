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
import model.bean.Fone;

/**
 *
 * @author anderson
 */
public class FoneDAO {
    //Tabela
    String tabela = "Fone";
    
    //Atributos
    String id = "id";
    String ddd = "ddd";
    String numero = "numero";
    String idtAluno = "idtAluno";
    String idOM = "idOM";
    String cpfReferencia = "cpfReferencia";
    String cpfConjuge = "cpfConjuge";
    
    //Insert SQL
    private final String INSERTFONEALUNO = "INSERT INTO " + tabela + "(" + id + "," + ddd + "," + numero + "," + idtAluno + ")" +
                                           " VALUES(?,?,?,?);";
    private final String INSERTFONEOM = "INSERT INTO " + tabela + "(" + id + "," + ddd + "," + numero + "," + idOM + ")" +
                                        " VALUES(?,?,?,?);";
    private final String INSERTFONEREFERENCIA = "INSERT INTO " + tabela + "(" + id + "," + ddd + "," + numero + "," + cpfReferencia + ")" +
                                                " VALUES(?,?,?,?);";
    private final String INSERTFONECONJUGE = "INSERT INTO " + tabela + "(" + id + "," + ddd + "," + numero + "," + cpfConjuge + ")" +
                                             " VALUES(?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + ddd + "=?, " + numero + "=?, " +
                                  "WHERE " + id + "=?;";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insertFoneAluno(Fone fone) {
        if (fone != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERTFONEALUNO);
                
                pstm.setInt(1, fone.getId());
                pstm.setString(2, fone.getDdd());
                pstm.setString(3, fone.getNumero());
                pstm.setString(4, fone.getIdentidadeAluno());
                                                              
                pstm.execute();
                
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {
            throw new RuntimeException();
        }
    }
    public void insertFoneOM(Fone fone) {
        if (fone != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERTFONEOM);
                
                pstm.setInt(1, fone.getId());
                pstm.setString(2, fone.getDdd());
                pstm.setString(3, fone.getNumero());
                pstm.setInt(4, fone.getIdOM());
                                                              
                pstm.execute();
                
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {
            throw new RuntimeException();
        }
    }
    public void insertFoneReferencia(Fone fone) {
        if (fone != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERTFONEREFERENCIA);
                
                pstm.setInt(1, fone.getId());
                pstm.setString(2, fone.getDdd());
                pstm.setString(3, fone.getNumero());
                pstm.setString(4, fone.getCpfReferencia());
                                                              
                pstm.execute();
                
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {
            throw new RuntimeException();
        }
    }
    public void insertFoneConjuge(Fone fone) {
        if (fone != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERTFONECONJUGE);
                
                pstm.setInt(1, fone.getId());
                pstm.setString(2, fone.getDdd());
                pstm.setString(3, fone.getNumero());
                pstm.setString(4, fone.getCpfConjuge());
                                                              
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
    public void updateFoneAluno(Fone fone) {
        if (fone != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                
                pstm.setString(1, fone.getDdd());
                pstm.setString(2, fone.getNumero());
                pstm.setInt(3, fone.getId());
            
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
    
    private final String GETFONEBYID = "SELECT * " +
                                        "FROM " + tabela + " " +
                                        "WHERE id = ?;";
       
    public Fone getFoneById(int idFONE){
        Fone fone = new Fone();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETFONEBYID);
            pstm.setInt(1, idFONE);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                fone.setId(rs.getInt("id"));
                fone.setDdd(rs.getString("ddd"));
                fone.setNumero(rs.getString("numero"));
                fone.setIdentidadeAluno(rs.getString("idtAluno"));
                fone.setIdOM(rs.getInt("idOM"));
                fone.setCpfReferencia(rs.getString("cpfReferencia"));
                fone.setCpfConjuge(rs.getString("cpfConjuge"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return fone;
    }
    
    private final String GETFONES = "SELECT * " +
                                   "FROM " + tabela;
       
    public ArrayList<Fone> getFones(){
        ArrayList<Fone> fones = new ArrayList<>();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETFONES);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Fone fone = new Fone();
                
                fone.setId(rs.getInt("id"));
                fone.setDdd(rs.getString("ddd"));
                fone.setNumero(rs.getString("numero"));
                fone.setIdentidadeAluno(rs.getString("idtAluno"));
                fone.setIdOM(rs.getInt("idOM"));
                fone.setCpfReferencia(rs.getString("cpfReferencia"));
                fone.setCpfConjuge(rs.getString("cpfConjuge"));
                
                fones.add(fone);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return fones;
    }
}
