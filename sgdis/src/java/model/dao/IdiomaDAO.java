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
import model.bean.Idioma;

/**
 *
 * @author anderson
 */
public class IdiomaDAO {
    //Tabela
    String tabela = "Idioma";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome + ")"
                                    + " VALUES(?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + nome + "=? " + 
                                  "WHERE " + id + "=?;";
    
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    private final String GETUltimoID = "SELECT MAX(" + id + ") as ultimo_id FROM " + tabela + ";";
    private final String GETIDIOMABYID = "SELECT * FROM " + tabela + " WHERE " + id + "=?;";
    private final String GETIDIOMAS = "SELECT * FROM "+ tabela +" ORDER BY "+ nome +";";
    
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
    public void insert(Idioma idioma) {
        if (idioma != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, idioma.getId());
                pstm.setString(2, idioma.getNome());
                                                              
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
    public void update(Idioma idioma) {
        if (idioma != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                
                pstm.setString(1, idioma.getNome());
                pstm.setInt(2, idioma.getId());
            
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
        if (id != 0) {
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
    
    //Idioma by ID
    public Idioma getIdiomaById(int idIdioma){
        Idioma idioma = new Idioma();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETIDIOMABYID);
            pstm.setInt(1, idIdioma);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                idioma.setId(rs.getInt(id));
                idioma.setNome(rs.getString(nome));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return idioma;
    }
    
    //Lista com todas os Idiomas
    public ArrayList<Idioma> getIdiomas(){
        ArrayList<Idioma> idiomas = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETIDIOMAS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Idioma idioma = new Idioma();
                
                idioma.setId(rs.getInt(id));
                idioma.setNome(rs.getString(nome));
                
                idiomas.add(idioma);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return idiomas;
    }
    
    private final static String GETIDIOMASDWR = "SELECT * " +
                                                "FROM Idioma " + 
                                                "ORDER BY nome";
    
    public static ArrayList<Idioma> getIdiomasDWR(){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Idioma> idiomas = new ArrayList<>();
        
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETIDIOMASDWR);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Idioma idioma = new Idioma();

                idioma.setId(rs.getInt("id"));
                idioma.setNome(rs.getString("nome"));

                idiomas.add(idioma);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return idiomas;
    }
}
