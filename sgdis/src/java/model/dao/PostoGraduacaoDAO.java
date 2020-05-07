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
import model.bean.Categoria;
import model.bean.Forca;
import model.bean.PostoGraduacao;

/**
 *
 * @author anderson
 */
public class PostoGraduacaoDAO {
    //Tabela
    String tabela = "PostoGraduacao";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    String abreviatura = "abreviatura";
    String circulohierarquico = "circulohierarquico";
    String idForca = "idForca";
    String idCategoria = "idCategoria";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome + "," + abreviatura + "," + circulohierarquico + "," + idForca + "," + idCategoria + ") " +
                                  "VALUES(?,?,?,?,?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    private final String GETPOSTOGRADUACAO = "SELECT * " +
                                             "FROM PostoGraduacao " + 
                                             "WHERE id = ?";
       
    public PostoGraduacao getPostoGraduacao(int idPG){
        PostoGraduacao pg = new PostoGraduacao();
        ForcaDAO forcaDAO = new ForcaDAO();
        CategoriaDAO catDAO = new CategoriaDAO();  
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETPOSTOGRADUACAO);
            pstm.setInt(1, idPG);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Forca forca = forcaDAO.getForcaById(rs.getInt("idForca"));
                Categoria cat = catDAO.getCategoriaById(rs.getInt("idCategoria"));

                pg.setId(rs.getInt("id"));
                pg.setNome(rs.getString("nome"));
                pg.setAbreviatura(rs.getString("abreviatura"));
                pg.setCirculohierarquico(rs.getString("circulohierarquico"));

                pg.setIdForca(forca.getId());
                pg.setNomeForca(forca.getNome());
                pg.setSiglaForca(forca.getSigla());

                pg.setIdCategoria(cat.getId());
                pg.setNomeCategoria(cat.getNome());
                pg.setDescricaoCategoria(cat.getDescricao());
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return pg;
    }
    
    private final static String GETPOSTOSGRADUACOESBYFORCAEXCETOCBSDDWR = "SELECT * " +
                                                                          "FROM PostoGraduacao " + 
                                                                          "WHERE idForca = ? AND circulohierarquico != 'CB_SD'";   
    
    
    public static ArrayList<PostoGraduacao> getPGsByForcaExcetoCbSdDWR(int idForca){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ForcaDAO forcaDAO = new ForcaDAO();
        CategoriaDAO catDAO = new CategoriaDAO();
        ArrayList<PostoGraduacao> pgs = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETPOSTOSGRADUACOESBYFORCAEXCETOCBSDDWR);
            pstm.setInt(1, idForca);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                PostoGraduacao pg = new PostoGraduacao();
                Forca forca = forcaDAO.getForcaById(rs.getInt("idForca"));
                Categoria cat = catDAO.getCategoriaById(rs.getInt("idCategoria"));

                pg.setId(rs.getInt("id"));
                pg.setNome(rs.getString("nome"));
                pg.setAbreviatura(rs.getString("abreviatura"));
                pg.setCirculohierarquico(rs.getString("circulohierarquico"));

                pg.setIdForca(forca.getId());
                pg.setNomeForca(forca.getNome());
                pg.setSiglaForca(forca.getSigla());

                pg.setIdCategoria(cat.getId());
                pg.setNomeCategoria(cat.getNome());
                pg.setDescricaoCategoria(cat.getDescricao());

                pgs.add(pg);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return pgs;
    }
    
    private final static String GETPOSTOSGRADUACOESBYFORCAEXCETOOFGENANDCBSDDWR = "SELECT * " +
                                                                                  "FROM PostoGraduacao " + 
                                                                                  "WHERE idForca = ? AND circulohierarquico != 'OFGEN' AND circulohierarquico != 'CB_SD'";   
    
    
    public static ArrayList<PostoGraduacao> getPGsByForcaExcetoOfGenAndCbSdDWR(int idForca){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ForcaDAO forcaDAO = new ForcaDAO();
        CategoriaDAO catDAO = new CategoriaDAO();
        ArrayList<PostoGraduacao> pgs = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETPOSTOSGRADUACOESBYFORCAEXCETOOFGENANDCBSDDWR);
            pstm.setInt(1, idForca);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                PostoGraduacao pg = new PostoGraduacao();
                Forca forca = forcaDAO.getForcaById(rs.getInt("idForca"));
                Categoria cat = catDAO.getCategoriaById(rs.getInt("idCategoria"));

                pg.setId(rs.getInt("id"));
                pg.setNome(rs.getString("nome"));
                pg.setAbreviatura(rs.getString("abreviatura"));
                pg.setCirculohierarquico(rs.getString("circulohierarquico"));

                pg.setIdForca(forca.getId());
                pg.setNomeForca(forca.getNome());
                pg.setSiglaForca(forca.getSigla());

                pg.setIdCategoria(cat.getId());
                pg.setNomeCategoria(cat.getNome());
                pg.setDescricaoCategoria(cat.getDescricao());

                pgs.add(pg);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return pgs;
    }
    
    private final static String GETPOSTOGRADUACAOBYFORCADWR = "SELECT * " +
                                                           "FROM PostoGraduacao " +
                                                           "WHERE idForca = ?;";   
    
    public static ArrayList<PostoGraduacao> getPGsByForcaDWR(int idForca){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ForcaDAO forcaDAO = new ForcaDAO();
        CategoriaDAO catDAO = new CategoriaDAO();
        ArrayList<PostoGraduacao> pgs = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETPOSTOGRADUACAOBYFORCADWR);
            pstm.setInt(1, idForca);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                PostoGraduacao pg = new PostoGraduacao();
                Forca forca = forcaDAO.getForcaById(rs.getInt("idForca"));
                Categoria cat = catDAO.getCategoriaById(rs.getInt("idCategoria"));

                pg.setId(rs.getInt("id"));
                pg.setNome(rs.getString("nome"));
                pg.setAbreviatura(rs.getString("abreviatura"));
                pg.setCirculohierarquico(rs.getString("circulohierarquico"));

                pg.setIdForca(forca.getId());
                pg.setNomeForca(forca.getNome());
                pg.setSiglaForca(forca.getSigla());

                pg.setIdCategoria(cat.getId());
                pg.setNomeCategoria(cat.getNome());
                pg.setDescricaoCategoria(cat.getDescricao());

                pgs.add(pg);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return pgs;
    }

    private final static String GETPOSTOGRADUACAOBYFORCAANDCAT = "SELECT * " +
                                                                 "FROM PostoGraduacao " +
                                                                 "WHERE idForca = ? AND idCategoria = ?;";   


    public static ArrayList<PostoGraduacao> getPGsByForcaAndCatDWR(int idForca, int idCategoria){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ForcaDAO forcaDAO = new ForcaDAO();
        CategoriaDAO catDAO = new CategoriaDAO();
        ArrayList<PostoGraduacao> pgs = new ArrayList<>();

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETPOSTOGRADUACAOBYFORCAANDCAT);
            pstm.setInt(1, idForca);
            pstm.setInt(2, idCategoria);

            rs = pstm.executeQuery();
            while (rs.next()) {
                PostoGraduacao pg = new PostoGraduacao();
                Forca forca = forcaDAO.getForcaById(rs.getInt("idForca"));
                Categoria cat = catDAO.getCategoriaById(rs.getInt("idCategoria"));

                pg.setId(rs.getInt("id"));
                pg.setNome(rs.getString("nome"));
                pg.setAbreviatura(rs.getString("abreviatura"));
                pg.setCirculohierarquico(rs.getString("circulohierarquico"));

                pg.setIdForca(forca.getId());
                pg.setNomeForca(forca.getNome());
                pg.setSiglaForca(forca.getSigla());

                pg.setIdCategoria(cat.getId());
                pg.setNomeCategoria(cat.getNome());
                pg.setDescricaoCategoria(cat.getDescricao());

                pgs.add(pg);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return pgs;
    }
}
