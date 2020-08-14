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
import model.bean.Medicacao;

/**
 *
 * @author anderson
 */
public class MedicacaoDAO {
    //Tabela
    String tabela = "Medicacao";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome + ")" +
                                  " VALUES(?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + nome + "=? " +
                                  "WHERE " + id + "=?;";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    private final String GETUltimoID = "SELECT MAX(" + id + ") as ultimo_id FROM " + tabela + ";";
    
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
    public void insert(Medicacao medicacao) {
        if (medicacao != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, medicacao.getId());
                pstm.setString(2, medicacao.getNome());
                                                              
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
    public void update(Medicacao medicacao) {
        if (medicacao != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                                
                pstm.setString(1, medicacao.getNome());
                pstm.setInt(2, medicacao.getId());
            
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
    
    private final String GETMEDICACAOBYID = "SELECT * " +
                                          "FROM " + tabela + " " +
                                          "WHERE id = ?;";
       
    public Medicacao getMedicacaoById(int idMedicacao){
        Medicacao medicacao = new Medicacao();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETMEDICACAOBYID);
            pstm.setInt(1, idMedicacao);
           
            rs = pstm.executeQuery();
            while (rs.next()) {                
                medicacao.setId(rs.getInt("id"));
                medicacao.setNome(rs.getString("nome"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return medicacao;
    }
    
    private final String GETMEDICACAOEXISTENTE = "SELECT * " + 
                                                " FROM " + tabela + 
                                                " WHERE " + nome + "=?;";

    public Medicacao getMedicacaoExistente(String nomeMedicacao){
        Medicacao medicacao = new Medicacao();   
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETMEDICACAOEXISTENTE);
            pstm.setString(1, nomeMedicacao);
           
            rs = pstm.executeQuery();
            while (rs.next()) {                
                medicacao.setId(rs.getInt("id"));
                medicacao.setNome(rs.getString("nome"));
                
                return medicacao;
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return null;
    }
    
    private final String GETMEDICACOES = "SELECT * " +
                                   "FROM " + tabela;
       
    public ArrayList<Medicacao> getMedicacaos(){
        ArrayList<Medicacao> medicacoes = new ArrayList<>();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETMEDICACOES);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Medicacao medicacao = new Medicacao();
                
                medicacao.setId(rs.getInt("id"));
                medicacao.setNome(rs.getString("nome"));
                
                medicacoes.add(medicacao);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return medicacoes;
    }
}
