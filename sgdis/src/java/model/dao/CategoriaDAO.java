/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Categoria;
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
public class CategoriaDAO {
    //Tabela
    String tabela = "Categoria";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    String descricao = "descricao";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome + "," + descricao +")"
                                    + " VALUES(?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + nome + "=?, " + descricao + "=?, " +
                                  "WHERE " + id + "=?;";
    
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    private final String GETUltimoID = "SELECT MAX(" + id + ") as ultimo_id FROM " + tabela + ";";
    private final String GETCategoriaByID = "SELECT * FROM " + tabela + " WHERE " + id + "=?;";
    private final String GETCATEGORIAS = "SELECT * FROM "+ tabela +";";
    
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
    public void insert(Categoria categoria) {
        if (categoria != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, categoria.getId());
                pstm.setString(2, categoria.getNome());
                pstm.setString(3, categoria.getDescricao());
                                                              
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
    public void update(Categoria categoria) {
        if (categoria != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                
                pstm.setString(1, categoria.getNome());
                pstm.setString(2, categoria.getDescricao());
                pstm.setInt(3, categoria.getId());
            
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
    
    //Categoria by ID
    public Categoria getCategoria(int id){
        Categoria categoria = new Categoria();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCategoriaByID);
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString(nome));
                categoria.setDescricao(rs.getString(descricao));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return categoria;
    }
    
    //Lista com todas as modalidades
    public ArrayList<Categoria> getCategorias(){
        conn = null;
        pstm = null;
        rs = null;
        ArrayList<Categoria> categorias = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCATEGORIAS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                
                categoria.setId(rs.getInt(id));
                categoria.setNome(rs.getString(nome));
                categoria.setDescricao(rs.getString(descricao));
                
                categorias.add(categoria);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return categorias;
    }
    
    private final static String GETCATEGORIASDWR = "select * " +
                                                   "from Categoria ";
    
    public static ArrayList<Categoria> getCategoriasDWR(){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Categoria> categorias = new ArrayList<>();
        
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCATEGORIASDWR);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
               Categoria cat = new Categoria();
               
               cat.setId(rs.getInt("id"));
               cat.setNome(rs.getString("nome"));
               cat.setDescricao(rs.getString("descricao"));
                
               categorias.add(cat);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return categorias;
    }
}
