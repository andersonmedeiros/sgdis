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
import model.bean.GrauParentesco;
import model.bean.Referencia;

/**
 *
 * @author anderson
 */
public class ReferenciaDAO {
    //Tabela
    String tabela = "Referencia";
    
    //Atributos
    String cpf = "cpf";
    String nome = "nome";
    String sobrenome = "sobrenome";
    String email = "email";
    String idGrauParentesco = "idGrauParentesco";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + cpf + "," + nome + "," + sobrenome +  "," + email +  "," + idGrauParentesco + ")" +
                                  " VALUES(?,?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + nome + "=?, " + sobrenome + "=?, " + email + "=?, " + idGrauParentesco + "=? " +
                                  "WHERE " + cpf + "=?;";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + cpf + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    //Insert SQL
    public void insert(Referencia ref) {
        if (ref != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setString(1, ref.getCpf());
                pstm.setString(2, ref.getNome());
                pstm.setString(3, ref.getSobrenome());
                pstm.setString(4, ref.getEmail());
                pstm.setInt(5, ref.getIdGrauParentesco());
                
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
    public void update(Referencia ref) {
        if (ref != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);                           
                                
                pstm.setString(1, ref.getNome());
                pstm.setString(2, ref.getSobrenome());
                pstm.setString(3, ref.getEmail());
                pstm.setInt(4, ref.getIdGrauParentesco());
                pstm.setString(5, ref.getCpf());
                
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
    public void delete(String cpfReferencia) {
        if (cpfReferencia != null){
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setString(1, cpfReferencia);
            
                pstm.execute();
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {            
            throw new RuntimeException();
        }
    }
    
    private final String GETREFERENCIABYCPF = "SELECT * " +
                                              "FROM Referencia " + 
                                              "WHERE cpf = ?";
       
    public Referencia getReferenciaByCpf(String cpfReferencia){
        Referencia ref = new Referencia();
        GrauParentescoDAO gpDAO = new GrauParentescoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETREFERENCIABYCPF);
            pstm.setString(1, cpfReferencia);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                ref.setCpf(rs.getString("cpf"));
                ref.setNome(rs.getString("nome"));
                ref.setSobrenome(rs.getString("sobrenome"));
                ref.setEmail(rs.getString("email"));
                
                GrauParentesco gp = gpDAO.getGrauParentescoById(rs.getInt("idGrauParentesco"));
                ref.setIdGrauParentesco(gp.getId());
                ref.setNomeGrauParentesco(gp.getNome());
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return ref;
    }
    
    private final String GETREFERENCIABYIDTALUNO = "SELECT * " +
                                                   "FROM Referencia " + 
                                                   "WHERE idGrauParentesco = ?";
       
    public Referencia getReferenciaByIdtAluno(String idGrauParentesco){
        Referencia ref = new Referencia();
        GrauParentescoDAO gpDAO = new GrauParentescoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETREFERENCIABYIDTALUNO);
            pstm.setString(1, idGrauParentesco);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                ref.setCpf(rs.getString("cpf"));
                ref.setNome(rs.getString("nome"));
                ref.setSobrenome(rs.getString("sobrenome"));
                ref.setEmail(rs.getString("email"));
                
                GrauParentesco gp = gpDAO.getGrauParentescoById(rs.getInt("idGrauParentesco"));
                ref.setIdGrauParentesco(gp.getId());
                ref.setNomeGrauParentesco(gp.getNome());
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return ref;
    }
    
    private final String GETREFERENCIAEXISTENTE = "SELECT * " + 
                                                " FROM " + tabela + 
                                                " WHERE " + cpf + "=?;";

    public Referencia getReferenciaExistente(String cpf){
        Referencia ref = new Referencia();   
        GrauParentescoDAO gpDAO = new GrauParentescoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETREFERENCIAEXISTENTE);
            pstm.setString(1, cpf);
           
            rs = pstm.executeQuery();
            while (rs.next()) {                
                ref.setCpf(rs.getString("cpf"));
                ref.setNome(rs.getString("nome"));
                ref.setSobrenome(rs.getString("sobrenome"));
                ref.setEmail(rs.getString("email"));
                
                GrauParentesco gp = gpDAO.getGrauParentescoById(rs.getInt("idGrauParentesco"));
                ref.setIdGrauParentesco(gp.getId());
                ref.setNomeGrauParentesco(gp.getNome());
                
                return ref;
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return null;
    }
    
    private final String GETCNHS = "SELECT * " +
                                   "FROM " + tabela;
       
    public ArrayList<Referencia> getReferencias(){
        ArrayList<Referencia> refs = new ArrayList<>();  
        GrauParentescoDAO gpDAO = new GrauParentescoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCNHS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Referencia ref = new Referencia();
                
                ref.setCpf(rs.getString("cpf"));
                ref.setNome(rs.getString("nome"));
                ref.setSobrenome(rs.getString("sobrenome"));
                ref.setEmail(rs.getString("email"));
                
                GrauParentesco gp = gpDAO.getGrauParentescoById(rs.getInt("idGrauParentesco"));
                ref.setIdGrauParentesco(gp.getId());
                ref.setNomeGrauParentesco(gp.getNome());
                
                refs.add(ref);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return refs;
    }
}
