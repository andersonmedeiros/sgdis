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
import model.bean.Alergia;

/**
 *
 * @author anderson
 */
public class AlergiaDAO {
    //Tabela
    String tabela = "Alergia";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome + ")" +
                                  " VALUES(?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + nome + "=? " +
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
    public void insert(Alergia alergia) {
        if (alergia != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, alergia.getId());
                pstm.setString(2, alergia.getNome());
                                                              
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
    public void update(Alergia alergia) {
        if (alergia != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                                
                pstm.setString(1, alergia.getNome());
                pstm.setInt(2, alergia.getId());
            
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
    
    private final String GETALEGRIABYID = "SELECT * " +
                                          "FROM " + tabela + " " +
                                          "WHERE id = ?;";
       
    public Alergia getAlergiaById(int idAlergia){
        Alergia alergia = new Alergia();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETALEGRIABYID);
            pstm.setInt(1, idAlergia);
           
            rs = pstm.executeQuery();
            while (rs.next()) {                
                alergia.setId(rs.getInt("id"));
                alergia.setNome(rs.getString("nome"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return alergia;
    }
    
    private final String GETALERGIAEXISTENTE = "SELECT * " + 
                                                " FROM " + tabela + 
                                                " WHERE " + nome + "=?;";

    public Alergia getAlergiaExistente(String nomeAlergia){
        Alergia alergia = new Alergia();   
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETALERGIAEXISTENTE);
            pstm.setString(1, nomeAlergia);
           
            rs = pstm.executeQuery();
            while (rs.next()) {                
                alergia.setId(rs.getInt("id"));
                alergia.setNome(rs.getString("nome"));
                
                return alergia;
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return null;
    }
    
    private final String GETALEGRIAS = "SELECT * " +
                                   "FROM " + tabela;
       
    public ArrayList<Alergia> getAlergias(){
        ArrayList<Alergia> alergias = new ArrayList<>();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETALEGRIAS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Alergia alergia = new Alergia();
                
                alergia.setId(rs.getInt("id"));
                alergia.setNome(rs.getString("nome"));
                
                alergias.add(alergia);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return alergias;
    }
}
