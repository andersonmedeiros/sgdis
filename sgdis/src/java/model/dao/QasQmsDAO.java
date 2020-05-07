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
import model.bean.QasQms;

/**
 *
 * @author anderson
 */
public class QasQmsDAO {
    //Tabela
    String tabela = "QasQms";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    String abreviatura = "abreviatura";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome + "," + abreviatura + ")" +
                                  " VALUES(?,?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(QasQms qq) {
        if (qq != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, qq.getId());
                pstm.setString(2, qq.getNome());
                pstm.setString(3, qq.getAbreviatura());
                                                              
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
    
    private final String GETQASQMS = "SELECT * " +
                                    "FROM QasQms " + 
                                    "WHERE id = ?;";
       
    public QasQms getQasQmsById(int idQasQms){
        QasQms qq = new QasQms();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETQASQMS);
            pstm.setInt(1, idQasQms);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                qq.setId(rs.getInt("id"));
                qq.setNome(rs.getString("nome"));
                qq.setAbreviatura(rs.getString("abreviatura"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return qq;
    }
    
    private final static String GETQASQMSDWR = "SELECT * " +
                                               "FROM QasQms";
       
    public static ArrayList<QasQms> getQasQmsDWR(){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<QasQms> qasqms = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETQASQMSDWR);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                QasQms qq = new QasQms();
                
                qq.setId(rs.getInt("id"));
                qq.setNome(rs.getString("nome"));
                qq.setAbreviatura(rs.getString("abreviatura"));
                
                qasqms.add(qq);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return qasqms;
    }
}
