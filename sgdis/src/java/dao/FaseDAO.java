/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Fase;
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
public class FaseDAO {
    //Tabela
    String tabela = "Fase";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    String sigla = "sigla";
    String descricao = "descricao";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome + "," + sigla + ","  + descricao +")"
                                    + " VALUES(?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + nome + "=?, " + sigla + "=?, " + descricao + "=? " +
                                  "WHERE " + id + "=?;";
    
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    private final String GETUltimoID = "SELECT MAX(" + id + ") as ultimo_id FROM " + tabela + ";";
    private final String GETFaseByID = "SELECT * FROM " + tabela + " WHERE " + id + "=?;";
    private final String GETFASES = "SELECT * FROM "+ tabela +";";
    
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
    public void insert(Fase fase) {
        if (fase != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, fase.getId());
                pstm.setString(2, fase.getNome());
                pstm.setString(3, fase.getSigla());
                pstm.setString(4, fase.getDescricao());
                                              
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
    public void update(Fase fase) {
        if (fase != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                
                pstm.setString(1, fase.getNome());
                pstm.setString(2, fase.getSigla());
                pstm.setString(3, fase.getDescricao());
                pstm.setInt(4, fase.getId());
            
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
    
    //Fase by ID
    public Fase getFase(int id){
        Fase fase = new Fase();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETFaseByID);
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                fase.setId(rs.getInt(id));
                fase.setNome(rs.getString(nome));
                fase.setSigla(rs.getString(sigla));
                fase.setDescricao(rs.getString(descricao));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return fase;
    }
    
    //Lista com todas as fases
    public ArrayList<Fase> getFases(){
        conn = null;
        pstm = null;
        rs = null;
        ArrayList<Fase> fases = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETFASES);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Fase fase = new Fase();
                
                fase.setId(rs.getInt(id));
                fase.setNome(rs.getString(nome));
                fase.setSigla(rs.getString(sigla));
                fase.setDescricao(rs.getString(descricao));
                
                fases.add(fase);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return fases;
    }
}
