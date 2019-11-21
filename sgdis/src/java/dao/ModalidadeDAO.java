/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Modalidade;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author andersondepaula
 */
public class ModalidadeDAO {
    //Tabela
    String tabela = "Modalidade";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome +")"
                                    + " VALUES(?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + nome + "=?, " +
                                  "WHERE " + id + "=?;";
    
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    private final String GETUltimoID = "SELECT MAX(" + id + ") as ultimo_id FROM " + tabela + ";";
    private final String GETModalidadeByID = "SELECT * FROM " + tabela + " WHERE " + id + "=?;";
    private final String GETMODALIDADES = "SELECT * FROM "+ tabela +";";
    
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
    public void insert(Modalidade modalidade) {
        if (modalidade != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, modalidade.getId());
                pstm.setString(2, modalidade.getNome());
                                                              
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
    public void update(Modalidade modalidade) {
        if (modalidade != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                
                pstm.setString(1, modalidade.getNome());
                pstm.setInt(2, modalidade.getId());
            
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
    
    //Modalidade by ID
        public Modalidade getModalidade(int id){
        Modalidade modalidade = new Modalidade();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETModalidadeByID);
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                modalidade.setId(rs.getInt("id"));
                modalidade.setNome(rs.getString(nome));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return modalidade;
    }
    
    //Lista com todas as modalidades
    public ArrayList<Modalidade> getModalidades(){
        conn = null;
        pstm = null;
        rs = null;
        ArrayList<Modalidade> modalidades = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETMODALIDADES);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Modalidade modalidade = new Modalidade();
                
                modalidade.setId(rs.getInt(id));
                modalidade.setNome(rs.getString(nome));
                
                modalidades.add(modalidade);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return modalidades;
    }
}
