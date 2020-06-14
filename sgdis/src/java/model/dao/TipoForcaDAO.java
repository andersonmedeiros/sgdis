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
import model.bean.Forca;
import model.bean.TipoForca;

/**
 *
 * @author anderson
 */
public class TipoForcaDAO {
    //Tabela
    String tabela = "Tipo_Forca";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome +  ")" +
                                  " VALUES(?,?,);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    //Insert SQL
    public void insert(TipoForca tipoforca) {
        if (tipoforca != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, tipoforca.getId());
                pstm.setString(2, tipoforca.getNome());
                
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
    
    private final String GETTIPOFORCA = "SELECT * " +
                                    "FROM Tipo_Forca " + 
                                    "WHERE id = ?;";
       
    public TipoForca getTipoForcaById(int idTipoForca){
        TipoForca tipoforca = new TipoForca();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETTIPOFORCA);
            pstm.setInt(1, idTipoForca);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                tipoforca.setId(rs.getInt("id"));
                tipoforca.setNome(rs.getString("nome"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return tipoforca;
    }
    
    private final static String GETTIPOFORCADWR = "SELECT * " +
                                              "FROM Tipo_Forca " + 
                                              "WHERE id = ?;";
       
    public TipoForca getTipoForcaByIdDWR(int idTipoForca){
        TipoForca tipoforca = new TipoForca();    
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETTIPOFORCADWR);
            pstm.setInt(1, idTipoForca);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                tipoforca.setId(rs.getInt("id"));
                tipoforca.setNome(rs.getString("nome"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return tipoforca;
    }
    
    private final static String GETTIPOSFORCADWR = "SELECT * " +
                                                   "FROM Tipo_Forca";
       
    public static ArrayList<TipoForca> getTiposForcaDWR(){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<TipoForca> tiposforca = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETTIPOSFORCADWR);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                TipoForca tipoforca = new TipoForca();
                
                tipoforca.setId(rs.getInt("id"));
                tipoforca.setNome(rs.getString("nome"));            
                
                tiposforca.add(tipoforca);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return tiposforca;
    }
}
