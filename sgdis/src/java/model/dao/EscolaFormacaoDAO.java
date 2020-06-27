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
import model.bean.EscolaFormacao;
import model.bean.Forca;

/**
 *
 * @author anderson
 */
public class EscolaFormacaoDAO {
    //Tabela
    String tabela = "EscolaFormacao";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    String abreviatura = "abreviatura";
    String idForca = "idForca";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome + "," + abreviatura + "," + idForca + ")" +
                                  " VALUES(?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + nome + "=?, " + abreviatura + "=?, " + idForca + "=?, " +
                                  "WHERE " + id + "=?;";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(EscolaFormacao escolaformacao) {
        if (escolaformacao != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, escolaformacao.getId());
                pstm.setString(2, escolaformacao.getNome());
                pstm.setString(3, escolaformacao.getAbreviatura());
                pstm.setInt(4, escolaformacao.getIdForca());
                                                              
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
    public void update(EscolaFormacao escolaformacao) {
        if (escolaformacao != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);                
                
                pstm.setString(1, escolaformacao.getNome());
                pstm.setString(2, escolaformacao.getAbreviatura());
                pstm.setInt(3, escolaformacao.getIdForca());
                pstm.setInt(4, escolaformacao.getId());
            
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
    
    
    private final String GETESCOLAFORMACAOBYID = "SELECT * " +
                                                 "FROM EscolaFormacao " + 
                                                 "WHERE id = ?";
    
    public EscolaFormacao getEscolaFormacaoById(int idEscolaFormacao){
        ForcaDAO forcaDAO = new ForcaDAO();
        EscolaFormacao escolaformacao = new EscolaFormacao();
        
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETESCOLAFORMACAOBYID);
            pstm.setInt(1, idEscolaFormacao);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
               escolaformacao.setId(rs.getInt("id"));
               escolaformacao.setNome(rs.getString("nome"));
               escolaformacao.setAbreviatura(rs.getString("abreviatura"));
               
               Forca forca = forcaDAO.getForcaById(rs.getInt("idForca"));
               escolaformacao.setIdForca(forca.getId());
               escolaformacao.setNomeForca(forca.getNome());
               escolaformacao.setSiglaForca(forca.getSigla());
               escolaformacao.setIdTipoForca(forca.getIdTipoForca());
               escolaformacao.setNomeTipoForca(forca.getNomeTipoForca());
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return escolaformacao;
    }
    
    private final String GETTAFS = "SELECT * " +
                                   "FROM " + tabela;
       
    public ArrayList<EscolaFormacao> getEscolasFormacao(){
        ArrayList<EscolaFormacao> escolas = new ArrayList<>();
        ForcaDAO forcaDAO = new ForcaDAO();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETTAFS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                EscolaFormacao escolaformacao = new EscolaFormacao();               
               
                escolaformacao.setId(rs.getInt("id"));
                escolaformacao.setNome(rs.getString("nome"));
                escolaformacao.setAbreviatura(rs.getString("abreviatura"));

                Forca forca = forcaDAO.getForcaById(rs.getInt("idForca"));
                escolaformacao.setIdForca(forca.getId());
                escolaformacao.setNomeForca(forca.getNome());
                escolaformacao.setSiglaForca(forca.getSigla());
                escolaformacao.setIdTipoForca(forca.getIdTipoForca());
                escolaformacao.setNomeTipoForca(forca.getNomeTipoForca());

                escolas.add(escolaformacao);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return escolas;
    }
    
    private final static String GETESCOLASFORMACAOBYIDFORCADWR = "SELECT * " +
                                                        "FROM EscolaFormacao " +
                                                        "WHERE idForca = ?;";
    
    public static ArrayList<EscolaFormacao> getEscolasFormacaoByForcaDWR(int idForca){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ForcaDAO forcaDAO = new ForcaDAO();
        ArrayList<EscolaFormacao> escolas = new ArrayList<>();
        
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETESCOLASFORMACAOBYIDFORCADWR);
            pstm.setInt(1, idForca);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                EscolaFormacao escolaformacao = new EscolaFormacao();               

                escolaformacao.setId(rs.getInt("id"));
                escolaformacao.setNome(rs.getString("nome"));
                escolaformacao.setAbreviatura(rs.getString("abreviatura"));

                Forca forca = forcaDAO.getForcaById(rs.getInt("idForca"));
                escolaformacao.setIdForca(forca.getId());
                escolaformacao.setNomeForca(forca.getNome());
                escolaformacao.setSiglaForca(forca.getSigla());
                escolaformacao.setIdTipoForca(forca.getIdTipoForca());
                escolaformacao.setNomeTipoForca(forca.getNomeTipoForca());

                escolas.add(escolaformacao);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return escolas;
    }
}
