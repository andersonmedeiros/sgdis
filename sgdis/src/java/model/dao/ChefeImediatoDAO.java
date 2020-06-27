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
import model.bean.ChefeImediato;
import model.bean.PostoGraduacao;

/**
 *
 * @author anderson
 */
public class ChefeImediatoDAO {
    //Tabela
    String tabela = "ChImediato";
    
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
                                  " SET " + nome + "=?, " + sobrenome + "=?, " + nomeguerra + "=?, " + idPostoGraduacao + "=?, " +
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
    public void insert(ChefeImediato chImto) {
        if (chImto != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, chImto.getId());
                pstm.setString(2, chImto.getNome());
                pstm.setString(3, chImto.getSobrenome());
                pstm.setString(4, chImto.getNomeguerra());
                pstm.setInt(5, chImto.getIdPostoGraduacao());
                                                              
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
    public void update(ChefeImediato chImto) {
        if (chImto != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);                
                
                pstm.setString(1, chImto.getNome());
                pstm.setString(2, chImto.getSobrenome());
                pstm.setString(3, chImto.getNomeguerra());
                pstm.setInt(4, chImto.getIdPostoGraduacao());
                pstm.setInt(5, chImto.getId());
            
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
    
    private final String GETCHIMTO = "SELECT * " +
                                    "FROM ChImediato " + 
                                    "WHERE id = ?";
       
    public ChefeImediato getChefeImediatoById(int idCmt){
        ChefeImediato chImto = new ChefeImediato();   
        PostoGraduacaoDAO pgDAO = new PostoGraduacaoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCHIMTO);
            pstm.setInt(1, idCmt);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                PostoGraduacao pg = pgDAO.getPostoGraduacaoById(rs.getInt("idPostoGraduacao"));
                
                chImto.setId(rs.getInt("id"));
                chImto.setNome(rs.getString("nome"));
                chImto.setSobrenome(rs.getString("sobrenome"));
                chImto.setNomeguerra(rs.getString("nomeguerra"));
                
                chImto.setIdPostoGraduacao(pg.getId());
                chImto.setNomePostoGraduacao(pg.getNome());
                chImto.setAbreviaturaPostoGraduacao(pg.getAbreviatura());
                chImto.setCirculohierarquicoPostoGraduacao(pg.getCirculohierarquico());
                
                chImto.setIdForcaPostoGraduacao(pg.getIdForca());
                chImto.setNomeForcaPostoGraduacao(pg.getNomeForca());
                chImto.setSiglaForcaPostoGraduacao(pg.getSiglaForca());
                
                chImto.setIdCategoriaPostoGraduacao(pg.getIdCategoria());
                chImto.setNomeCategoriaPostoGraduacao(pg.getNomeCategoria());
                chImto.setDescricaoCategoriaPostoGraduacao(pg.getDescricaoCategoria());
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return chImto;
    }
    
    private final String GETCHIMTOEXISTENTE = "SELECT * " + 
                                           " FROM " + tabela + 
                                           " WHERE " + nome + "=? AND " + sobrenome + "=? AND " + nomeguerra + "=? AND " + idPostoGraduacao +"=? "+";";

    public ChefeImediato getChefeImediatoExistente(String nome, String sobrenome, String nomeguerra, int idPGrad){
        ChefeImediato chImto = new ChefeImediato();   
        PostoGraduacaoDAO pgDAO = new PostoGraduacaoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCHIMTOEXISTENTE);
            pstm.setString(1, nome);
            pstm.setString(2, sobrenome);
            pstm.setString(3, nomeguerra);
            pstm.setInt(4, idPGrad);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                PostoGraduacao pg = pgDAO.getPostoGraduacaoById(rs.getInt("idPostoGraduacao"));
                
                chImto.setId(rs.getInt("id"));
                chImto.setNome(rs.getString("nome"));
                chImto.setSobrenome(rs.getString("sobrenome"));
                chImto.setNomeguerra(rs.getString("nomeguerra"));
                
                chImto.setIdPostoGraduacao(pg.getId());
                chImto.setNomePostoGraduacao(pg.getNome());
                chImto.setAbreviaturaPostoGraduacao(pg.getAbreviatura());
                chImto.setCirculohierarquicoPostoGraduacao(pg.getCirculohierarquico());
                
                chImto.setIdForcaPostoGraduacao(pg.getIdForca());
                chImto.setNomeForcaPostoGraduacao(pg.getNomeForca());
                chImto.setSiglaForcaPostoGraduacao(pg.getSiglaForca());
                
                chImto.setIdCategoriaPostoGraduacao(pg.getIdCategoria());
                chImto.setNomeCategoriaPostoGraduacao(pg.getNomeCategoria());
                chImto.setDescricaoCategoriaPostoGraduacao(pg.getDescricaoCategoria());
                
                return chImto;
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return null;
    }
}
