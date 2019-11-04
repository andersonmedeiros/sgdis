/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Curso;
import bean.Militar;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andersondepaula
 */
public class CursoDAO {
    //Tabela
    String tabela = "Curso";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    String sigla = "sigla";
    String ch = "ch";
    String portaria = "portaria";
    String descricao = "descricao";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome + "," + sigla + "," + ch + "," + portaria + "," + descricao +")"
                                    + " VALUES(?,?,?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  "SET " + nome + "=?, " + sigla + "=?, " + ch + "=?, " + portaria + "=?, " + descricao + "=? " +
                                  "WHERE " + id + "=?;";
    
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    private final String GETUltimoID = "SELECT MAX(" + id + ") as ultimo_id FROM " + tabela + ";";
    private final String GETCursoByID = "SELECT * FROM " + tabela + " WHERE " + id + "=?;";
    
    
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
    public void insert(Curso curso) {
        if (curso != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, curso.getId());
                pstm.setString(2, curso.getNome());
                pstm.setString(3, curso.getSigla());
                pstm.setInt(4, curso.getCh());                
                pstm.setString(5, curso.getPortaria());
                pstm.setString(6, curso.getDescricao());
                                              
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
    public void update(Curso curso) {
        if (curso != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                
                pstm.setString(1, curso.getNome());
                pstm.setString(2, curso.getSigla());
                pstm.setInt(3, curso.getCh());
                pstm.setString(4, curso.getPortaria());
                pstm.setString(5, curso.getDescricao());
                pstm.setInt(6, curso.getId());
            
                pstm.execute();
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {            
            throw new RuntimeException();
        }
    }
    
    //Curso by ID
    public Curso getCurso(int id){
        Curso curso = new Curso();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCursoByID);
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                curso.setId(rs.getInt(id));
                curso.setNome(rs.getString(nome));
                curso.setSigla(rs.getString(sigla));
                curso.setCh(rs.getInt(ch));
                curso.setPortaria(rs.getString(portaria));
                curso.setDescricao(rs.getString(descricao));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return curso;
    }
}

