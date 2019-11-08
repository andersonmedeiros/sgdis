/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Disciplina;
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
public class DisciplinaDAO {
    //Tabela
    String tabela = "Disciplina";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    String ch = "ch";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome + "," + ch +")"
                                    + " VALUES(?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + nome + "=?, " + ch+ "=? " +
                                  "WHERE " + id + "=?;";
    
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    private final String GETUltimoID = "SELECT MAX(" + id + ") as ultimo_id FROM " + tabela + ";";
    private final String GETDisciplinaByID = "SELECT * FROM " + tabela + " WHERE " + id + "=?;";
    private final String GETDISCIPLINAS = "SELECT * FROM "+ tabela +";";
    
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
    public void insert(Disciplina disciplina) {
        if (disciplina != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, disciplina.getId());
                pstm.setString(2, disciplina.getNome());
                pstm.setInt(3, disciplina.getCh());
                                              
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
    public void update(Disciplina disciplina) {
        if (disciplina != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                
                pstm.setString(1, disciplina.getNome());
                pstm.setInt(2, disciplina.getCh());
                pstm.setInt(3, disciplina.getId());
            
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
    
    //Disciplina by ID
    public Disciplina getDisciplina(int id){
        Disciplina disciplina = new Disciplina();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETDisciplinaByID);
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                disciplina.setId(rs.getInt(id));
                disciplina.setNome(rs.getString(nome));
                disciplina.setCh(rs.getInt(ch));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return disciplina;
    }
    
    //Lista com todas as disciplinas
    public ArrayList<Disciplina> getDisciplinas(){
        conn = null;
        pstm = null;
        rs = null;
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETDISCIPLINAS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Disciplina disciplina = new Disciplina();
                
                disciplina.setId(rs.getInt(id));
                disciplina.setNome(rs.getString(nome));
                disciplina.setCh(rs.getInt(ch));
                
                disciplinas.add(disciplina);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return disciplinas;
    }
}
