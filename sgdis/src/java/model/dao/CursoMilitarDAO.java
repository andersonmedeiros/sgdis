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
import model.bean.CursoMilitar;

/**
 *
 * @author anderson
 */
public class CursoMilitarDAO {
    //Tabela
    String tabela = "CursoMilitar";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    String tipo = "tipo";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome + "," + tipo + ")" +
                                  " VALUES(?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + nome + "=?, " + tipo + "=?, " + 
                                  "WHERE " + id + "=?;";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(CursoMilitar cursomilitar) {
        if (cursomilitar != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, cursomilitar.getId());
                pstm.setString(2, cursomilitar.getNome());
                pstm.setInt(3, cursomilitar.getTipo());
                                                              
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
    public void update(CursoMilitar cursomilitar) {
        if (cursomilitar != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);                             
                                
                pstm.setString(1, cursomilitar.getNome());
                pstm.setInt(2, cursomilitar.getTipo());
                pstm.setInt(3, cursomilitar.getId());
                
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
    
    private final String GETCURSOMILITARBYID = "SELECT * " +
                                               "FROM CursoMilitar " + 
                                               "WHERE id = ?;";
       
    public CursoMilitar getCursoMilitarById(int idCursoMilitar){
        CursoMilitar cursomilitar = new CursoMilitar();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCURSOMILITARBYID);
            pstm.setInt(1, idCursoMilitar);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                cursomilitar.setId(rs.getInt(id));
                cursomilitar.setNome(rs.getString(nome));
                cursomilitar.setTipo(rs.getInt(tipo));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return cursomilitar;
    }
    
    private final String GETCURSOSMILITARES = "SELECT * " +
                                              "FROM " + tabela;
       
    public ArrayList<CursoMilitar> getCursosMilitares(){
        ArrayList<CursoMilitar> cursosmilitares = new ArrayList<>();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCURSOSMILITARES);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                CursoMilitar cursomilitar = new CursoMilitar();
                
                cursomilitar.setId(rs.getInt(id));
                cursomilitar.setNome(rs.getString(nome));
                cursomilitar.setTipo(rs.getInt(tipo));
                
                cursosmilitares.add(cursomilitar);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return cursosmilitares;
    }
    
    private final static String GETCURSOSMILITARESDWR = "SELECT * " +
                                                        "FROM CursoMilitar;";
       
    public static ArrayList<CursoMilitar> getCursosMilitaresDWR(){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<CursoMilitar> cursosmilitares = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCURSOSMILITARESDWR);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                CursoMilitar cursomilitar = new CursoMilitar();
                
                cursomilitar.setId(rs.getInt("id"));
                cursomilitar.setNome(rs.getString("nome"));
                cursomilitar.setTipo(rs.getInt("tipo"));                
                
                cursosmilitares.add(cursomilitar);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return cursosmilitares;
    }
}
