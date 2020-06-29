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
import model.bean.Alegria;

/**
 *
 * @author anderson
 */
public class AlegriaDAO {
    //Tabela
    String tabela = "Alegria";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome + ")" +
                                  " VALUES(?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + nome + "=?, " +
                                  "WHERE " + id + "=?;";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(Alegria alegria) {
        if (alegria != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, alegria.getId());
                pstm.setString(2, alegria.getNome());
                                                              
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
    public void update(Alegria alegria) {
        if (alegria != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                                
                pstm.setString(1, alegria.getNome());
                pstm.setInt(2, alegria.getId());
            
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
       
    public Alegria getAlegriaById(int idAlegria){
        Alegria alegria = new Alegria();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETALEGRIABYID);
            pstm.setInt(1, idAlegria);
           
            rs = pstm.executeQuery();
            while (rs.next()) {                
                alegria.setId(rs.getInt("id"));
                alegria.setNome(rs.getString("nome"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return alegria;
    }
    
    private final String GETALEGRIAS = "SELECT * " +
                                   "FROM " + tabela;
       
    public ArrayList<Alegria> getAlegrias(){
        ArrayList<Alegria> alegrias = new ArrayList<>();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETALEGRIAS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Alegria alegria = new Alegria();
                
                alegria.setId(rs.getInt("id"));
                alegria.setNome(rs.getString("nome"));
                
                alegrias.add(alegria);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return alegrias;
    }
}
