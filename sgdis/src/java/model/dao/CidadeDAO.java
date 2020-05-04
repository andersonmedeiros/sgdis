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
import model.bean.Cidade;
import model.bean.Estado;

/**
 *
 * @author anderson
 */
public class CidadeDAO {
    //Tabela
        String tabela = "Cidade";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    String idEstado = "idEstado";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome + "," + idEstado + ")" +
                                  " VALUES(?,?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(Cidade cid) {
        if (cid != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, cid.getId());
                pstm.setString(2, cid.getNome());
                pstm.setInt(3, cid.getIdEstado());
                                                              
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
    
    
    private final String GETCIDADE = "SELECT * " +
                                     "FROM Cidade " + 
                                     "WHERE id = ?";
    
    public Cidade getCidadeById(int idCidade){
        Cidade cid = new Cidade();
        EstadoDAO estDAO = new EstadoDAO();
        
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCIDADE);
            pstm.setInt(1, idCidade);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Estado est = estDAO.getEstadoById(rs.getInt("idEstado"));
                
                cid.setId(rs.getInt("id"));
                cid.setNome(rs.getString("nome"));
                
                cid.setIdEstado(est.getId());
                cid.setNomeEstado(est.getNome());
                cid.setSiglaEstado(est.getSigla());
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return cid;
    }
}
