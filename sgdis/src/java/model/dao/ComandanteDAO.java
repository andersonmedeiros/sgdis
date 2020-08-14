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
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + nome + "=?, " + sobrenome + "=?, " + nomeguerra + "=?, " + idPostoGraduacao + "=? " +
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
    
    //Update SQL
    public void update(Comandante cmt) {
        if (cmt != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);                
                
                pstm.setString(1, cmt.getNome());
                pstm.setString(2, cmt.getSobrenome());
                pstm.setString(3, cmt.getNomeguerra());
                pstm.setInt(4, cmt.getIdPostoGraduacao());
                pstm.setInt(5, cmt.getId());
            
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
                PostoGraduacao pg = pgDAO.getPostoGraduacaoById(rs.getInt("idPostoGraduacao"));
                
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
                cmt.setIdTipoForcaPostoGraduacao(pg.getIdTipoForca());
                cmt.setNomeTipoForcaPostoGraduacao(pg.getNomeTipoForca());
                
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
    
    private final String GETCMTEXISTENTE = "SELECT * " + 
                                           " FROM " + tabela + 
                                           " WHERE " + nome + "=? AND " + sobrenome + "=? AND " + nomeguerra + "=? AND " + idPostoGraduacao +"=?;";

    public Comandante getComandanteExistente(String nome, String sobrenome, String nomeguerra, int idPGrad){
        Comandante cmt = new Comandante();   
        PostoGraduacaoDAO pgDAO = new PostoGraduacaoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCMTEXISTENTE);
            pstm.setString(1, nome);
            pstm.setString(2, sobrenome);
            pstm.setString(3, nomeguerra);
            pstm.setInt(4, idPGrad);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                PostoGraduacao pg = pgDAO.getPostoGraduacaoById(rs.getInt("idPostoGraduacao"));
                
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
                cmt.setIdTipoForcaPostoGraduacao(pg.getIdTipoForca());
                cmt.setNomeTipoForcaPostoGraduacao(pg.getNomeTipoForca());
                
                cmt.setIdCategoriaPostoGraduacao(pg.getIdCategoria());
                cmt.setNomeCategoriaPostoGraduacao(pg.getNomeCategoria());
                cmt.setDescricaoCategoriaPostoGraduacao(pg.getDescricaoCategoria());
                
                return cmt;
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return null;
    }
}
