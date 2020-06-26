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
import model.bean.Uniforme;

/**
 *
 * @author anderson
 */
public class UniformeDAO {
    //Tabela
    String tabela = "Uniforme";
    
    //Atributos
    String id = "id";
    String tamcoturno = "tamcoturno";
    String tamgandola = "tamgandola";
    String tamcalca = "tamcalca";
    String tamcamisacamuflada = "tamcamisacamuflada";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + tamcoturno + "," + tamgandola + "," + tamcalca + "," + tamcamisacamuflada + ")" +
                                  " VALUES(?,?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + tamcoturno + "=?, " + tamgandola + "=?, " + tamcalca + "=?, " + tamcamisacamuflada + "=?, " +
                                  "WHERE " + id + "=?;";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(Uniforme u) {
        if (u != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, u.getId());
                pstm.setInt(2, u.getTamCoturno());
                pstm.setString(3, u.getTamGandola());
                pstm.setString(4, u.getTamCalca());
                pstm.setString(5, u.getTamCamisaCamuflada());
                                                              
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
    public void update(Uniforme u) {
        if (u != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);                
                
                pstm.setInt(1, u.getTamCoturno());
                pstm.setString(2, u.getTamGandola());
                pstm.setString(3, u.getTamCalca());
                pstm.setString(4, u.getTamCamisaCamuflada());
                pstm.setInt(5, u.getId());
            
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
    
    private final String GETUNIFORMEBYID = "SELECT * " +
                                           "FROM " + tabela + " " +
                                           "WHERE id = ?;";
       
    public Uniforme getUniformeById(int idUniforme){
        Uniforme u = new Uniforme();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETUNIFORMEBYID);
            pstm.setInt(1, idUniforme);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setTamCoturno(rs.getInt("tamcoturno"));
                u.setTamGandola(rs.getString("tamgandola"));
                u.setTamCalca(rs.getString("tamcalca"));
                u.setTamCamisaCamuflada(rs.getString("tamcamisacamuflada"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return u;
    }
    
    private final String GETUNIFORMES = "SELECT * " +
                                        "FROM " + tabela;
       
    public ArrayList<Uniforme> getUniformes(){
        ArrayList<Uniforme> uniformes = new ArrayList<>();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETUNIFORMES);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Uniforme u = new Uniforme();
                
                u.setId(rs.getInt("id"));
                u.setTamCoturno(rs.getInt("tamcoturno"));
                u.setTamGandola(rs.getString("tamgandola"));
                u.setTamCalca(rs.getString("tamcalca"));
                u.setTamCamisaCamuflada(rs.getString("tamcamisacamuflada"));
                
                uniformes.add(u);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return uniformes;
    }
}
