/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Modulo;
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
public class ModuloDAO {
    //Tabela
    String tabela = "Modulo";
    
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
    private final String GETModuloByID = "SELECT * FROM " + tabela + " WHERE " + id + "=?;";
    private final String GETMODULOS = "SELECT * FROM "+ tabela +";";
    
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
    public void insert(Modulo modulo) {
        if (modulo != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setString(1, modulo.getNome());
                pstm.setInt(2, modulo.getId());
                                              
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
    public void update(Modulo modulo) {
        if (modulo != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                
                pstm.setString(1, modulo.getNome());
                pstm.setInt(2, modulo.getId());
            
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
    
    //Modulo by ID
        public Modulo getModulo(int id){
        Modulo modulo = new Modulo();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETModuloByID);
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                modulo.setId(rs.getInt(id));
                modulo.setNome(rs.getString(nome));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return modulo;
    }
    
    //Lista com todas as modulos
    public ArrayList<Modulo> getModulos(){
        conn = null;
        pstm = null;
        rs = null;
        ArrayList<Modulo> modulos = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETMODULOS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Modulo modulo = new Modulo();
                
                modulo.setId(rs.getInt(id));
                modulo.setNome(rs.getString(nome));
                
                modulos.add(modulo);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return modulos;
    }
}
