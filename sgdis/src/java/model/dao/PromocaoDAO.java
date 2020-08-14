/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Promocao;

/**
 *
 * @author anderson
 */
public class PromocaoDAO {
    //Tabela
    String tabela = "Promocao";
    
    //Atributos
    String id = "id";
    String dataultpromocao = "dataultpromocao";
    String qapromocao = "qapromocao";
    String dataqapromocao = "dataqapromocao";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + dataultpromocao + "," + qapromocao + "," + dataqapromocao + ")" +
                                  " VALUES(?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + dataultpromocao + "=?, " + qapromocao + "=?, " + dataqapromocao + "=? " +
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
    public void insert(Promocao prom) {
        if (prom != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, prom.getId());
                pstm.setDate(2, prom.getDataultpromocao());
                pstm.setString(3, prom.getQapromocao());
                pstm.setDate(4, prom.getDataqapromocao());
                                                              
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
    public void update(Promocao prom) {
        if (prom != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                
                pstm.setDate(1, prom.getDataultpromocao());
                pstm.setString(2, prom.getQapromocao());
                pstm.setDate(3, prom.getDataqapromocao());
                pstm.setInt(4, prom.getId());
            
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
       
    public Promocao getPromocaoById(int idPromocao){
        Promocao prom = new Promocao();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETTAFBYID);
            pstm.setInt(1, idPromocao);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                prom.setId(rs.getInt("id"));
                prom.setDataultpromocao(rs.getDate("dataultpromocao"));
                prom.setQapromocao(rs.getString("qapromocao"));
                prom.setDataqapromocao(rs.getDate("dataqapromocao"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return prom;
    }
    
    private final String GETPROMOCAOEXISTENTE = "SELECT * " + 
                                                " FROM " + tabela + 
                                                " WHERE " + dataultpromocao + "=? AND " + qapromocao + "=? AND " + dataqapromocao + "=?;";

    public Promocao getPromocaoExistente(Date dataultprom, String qaprom, Date dataqaprom){
        Promocao prom = new Promocao();   
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETPROMOCAOEXISTENTE);
            pstm.setDate(1, dataultprom);
            pstm.setString(2, qaprom);
            pstm.setDate(3, dataqaprom);
           
            rs = pstm.executeQuery();
            while (rs.next()) {                
                prom.setId(rs.getInt("id"));
                prom.setDataultpromocao(rs.getDate("dataultpromocao"));
                prom.setQapromocao(rs.getString("qapromocao"));
                prom.setDataqapromocao(rs.getDate("dataqapromocao"));
                
                return prom;
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return null;
    }
    
    private final String GETTAFS = "SELECT * " +
                                   "FROM " + tabela;
       
    public ArrayList<Promocao> getPromocoes(){
        ArrayList<Promocao> promcoes = new ArrayList<>();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETTAFS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Promocao prom = new Promocao();
                
                prom.setId(rs.getInt("id"));
                prom.setDataultpromocao(rs.getDate("dataultpromocao"));
                prom.setQapromocao(rs.getString("qapromocao"));
                prom.setDataqapromocao(rs.getDate("dataqapromocao"));
                
                promcoes.add(prom);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return promcoes;
    }
}
