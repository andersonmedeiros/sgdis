/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Curso;
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
public class CursoDAO {
    //Tabela
    String tabela = "Curso";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    String sigla = "sigla";
    String categoria = "categoria";
    String portaria = "portaria";
    String descricao = "descricao";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome + "," + sigla + "," + categoria + "," + portaria + "," + descricao +")"
                                    + " VALUES(?,?,?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  "SET " + nome + "=?, " + sigla + "=?, " + categoria + "=?, " + portaria + "=?, " + descricao + "=? " +
                                  "WHERE " + id + "=?;";
    
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    private final String GETUltimoID = "SELECT MAX(" + id + ") as ultimo_id FROM " + tabela + ";";
    private final String GETCursoByID = "SELECT * FROM " + tabela + " WHERE " + id + "=?;";
    private final String GETCURSOS = "SELECT * FROM "+ tabela +";";
    
    
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
                pstm.setString(4, curso.getCategoria());             
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
                pstm.setString(3, curso.getCategoria());
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
                curso.setCategoria(rs.getString(categoria));
                curso.setPortaria(rs.getString(portaria));
                curso.setDescricao(rs.getString(descricao));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return curso;
    }
    
    //Lista com todos os cursos
    public ArrayList<Curso> getCursos(){
        conn = null;
        pstm = null;
        ResultSet rs = null;
        ArrayList<Curso> cursos = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCURSOS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                
                curso.setId(rs.getInt(id));
                curso.setNome(rs.getString(nome));
                curso.setSigla(rs.getString(sigla));
                curso.setCategoria(rs.getString(categoria));
                curso.setPortaria(rs.getString(portaria));
                curso.setDescricao(rs.getString(descricao));
                
                cursos.add(curso);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());           
        }
        return cursos;
    }
}

