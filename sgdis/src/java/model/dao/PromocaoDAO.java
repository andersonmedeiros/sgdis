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
                                  " SET " + dataultpromocao + "=?, " + qapromocao + "=?, " + dataqapromocao + "=?, " +
                                  "WHERE " + id + "=?;";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(Promocao promo) {
        if (promo != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, promo.getId());
                pstm.setDate(2, promo.getDataultpromocao());
                pstm.setString(3, promo.getQapromocao());
                pstm.setDate(4, promo.getDataqapromocao());
                                                              
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
    public void update(Promocao promo) {
        if (promo != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                
                pstm.setDate(1, promo.getDataultpromocao());
                pstm.setString(2, promo.getQapromocao());
                pstm.setDate(3, promo.getDataqapromocao());
                pstm.setInt(4, promo.getId());
            
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
        Promocao promo = new Promocao();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETTAFBYID);
            pstm.setInt(1, idPromocao);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                promo.setId(rs.getInt("id"));
                promo.setDataultpromocao(rs.getDate("dataultpromocao"));
                promo.setQapromocao(rs.getString("qapromocao"));
                promo.setDataqapromocao(rs.getDate("dataqapromocao"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return promo;
    }
    
    private final String GETTAFS = "SELECT * " +
                                   "FROM " + tabela;
       
    public ArrayList<Promocao> getPromocoes(){
        ArrayList<Promocao> promocoes = new ArrayList<>();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETTAFS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Promocao promo = new Promocao();
                
                promo.setId(rs.getInt("id"));
                promo.setDataultpromocao(rs.getDate("dataultpromocao"));
                promo.setQapromocao(rs.getString("qapromocao"));
                promo.setDataqapromocao(rs.getDate("dataqapromocao"));
                
                promocoes.add(promo);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return promocoes;
    }
}
