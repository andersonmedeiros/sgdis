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
import model.bean.Taf;

/**
 *
 * @author anderson
 */
public class TafDAO {
    //Tabela
    String tabela = "TAF";
    
    //Atributos
    String id = "id";
    String dataulttaf = "dataulttaf";
    String mencao = "mencao";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + dataulttaf + "," + mencao + ")" +
                                  " VALUES(?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + dataulttaf + "=?, " + mencao + "=?, " +
                                  "WHERE " + id + "=?;";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(Taf taf) {
        if (taf != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, taf.getId());
                pstm.setDate(2, taf.getDataUltTaf());
                pstm.setString(3, taf.getMencao());
                                                              
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
    public void update(Taf taf) {
        if (taf != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                
                pstm.setDate(1, taf.getDataUltTaf());
                pstm.setString(2, taf.getMencao());
                pstm.setInt(3, taf.getId());
            
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
    
    private final String GETTAFBYID = "SELECT * " +
                                      "FROM " + tabela + " " +
                                      "WHERE id = ?;";
       
    public Taf getTafById(int idTAF){
        Taf taf = new Taf();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETTAFBYID);
            pstm.setInt(1, idTAF);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                taf.setId(rs.getInt("id"));
                taf.setDataUltTaf(rs.getDate("dataulttaf"));
                taf.setMencao(rs.getString("mencao"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return taf;
    }
    
    private final String GETTAFS = "SELECT * " +
                                   "FROM " + tabela;
       
    public ArrayList<Taf> getTafs(){
        ArrayList<Taf> tafs = new ArrayList<>();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETTAFS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Taf taf = new Taf();
                
                taf.setId(rs.getInt("id"));
                taf.setDataUltTaf(rs.getDate("dataulttaf"));
                taf.setMencao(rs.getString("mencao"));
                
                tafs.add(taf);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return tafs;
    }
}
