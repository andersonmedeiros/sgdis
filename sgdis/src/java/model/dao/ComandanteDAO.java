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
import model.bean.Comandante;
import model.bean.PostoGraduacao;

/**
 *
 * @author anderson
 */
public class ComandanteDAO {
    //Tabela
    String tabela = "Comandante";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    String sobrenome = "sobrenome";
    String nomeguerra = "nomeguerra";
    String idPostoGraduacao = "idPostoGraduacao";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome + "," + sobrenome + "," + nomeguerra + "," + idPostoGraduacao + ")" +
                                  " VALUES(?,?,?,?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(Comandante cmt) {
        if (cmt != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, cmt.getId());
                pstm.setString(2, cmt.getNome());
                pstm.setString(3, cmt.getSobrenome());
                pstm.setString(4, cmt.getNomeguerra());
                pstm.setInt(5, cmt.getIdPostoGraduacao());
                                                              
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
    
    private final String GETCMT = "SELECT * " +
                                    "FROM Comandante " + 
                                    "WHERE id = ?";
       
    public Comandante getComandanteById(int idCmt){
        Comandante cmt = new Comandante();   
        PostoGraduacaoDAO pgDAO = new PostoGraduacaoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCMT);
            pstm.setInt(1, idCmt);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                PostoGraduacao pg = pgDAO.getPostoGraduacao(rs.getInt("idPostoGraduacao"));
                
                cmt.setId(rs.getInt("id"));
                cmt.setNome(rs.getString("nome"));
                cmt.setSobrenome(rs.getString("sobrenome"));
                cmt.setNomeguerra(rs.getString("nomeguerra"));
                
                cmt.setIdPostoGraduacao(pg.getId());
                cmt.setNomePostoGraduacao(pg.getNome());
                cmt.setAbreviaturaPostoGraduacao(pg.getAbreviatura());
                cmt.setCirculohierarquicoPostoGraduacao(pg.getCirculohierarquico());
                
                cmt.setIdForcaPostoGraduacao(pg.getIdForca());
                cmt.setNomeForcaPostoGraduacao(pg.getNomeForca());
                cmt.setSiglaForcaPostoGraduacao(pg.getSiglaForca());
                
                cmt.setIdCategoriaPostoGraduacao(pg.getIdCategoria());
                cmt.setNomeCategoriaPostoGraduacao(pg.getNomeCategoria());
                cmt.setDescricaoCategoriaPostoGraduacao(pg.getDescricaoCategoria());
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return cmt;
    }
}
