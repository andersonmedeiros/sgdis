/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Categoria;
import model.bean.CursoHasCategoria;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Curso;

/**
 *
 * @author anderson
 */
public class CursoHasCategoriaDAO {
    //Tabela
    String tabela = "Curso_has_Categoria";
    
    //Atributos
    String idCurso = "idCurso";
    String idCategoria = "idCategoria";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + idCurso + "," + idCategoria + ")" +
                                  " VALUES(?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + idCurso + "=? AND "+ idCategoria +"=?;";
    
    //Consultas SQL
    private final String GETCATEGORIASBYCURSO = "SELECT idCategoria FROM " + tabela + " WHERE " + idCurso + "=?;";
    private final String GETCURSOANDCATEGORIA = "SELECT " + idCurso + "," + idCategoria + " FROM " + tabela + " WHERE " + idCurso + "=? AND " + idCategoria + "=?;";
    private final String GETCURSOSANDCATEGORIAS = "select c.*, cat.* " +
                                                  "from Curso_has_Categoria as c_cat " +
                                                  "inner join Curso as c on c.id = c_cat.idCurso " +
                                                  "inner join Categoria as cat on cat.id = c_cat.idCategoria " +
                                                  "order by c.nome, cat.nome;";
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(CursoHasCategoria cursoCategoria) {
        if (cursoCategoria != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, cursoCategoria.getIdCurso());
                pstm.setInt(2, cursoCategoria.getIdCategoria());
                                                              
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
    public void delete(int idCurso, int idCategoria) {
        if (idCurso != 0 && idCategoria != 0) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setInt(1, idCurso);
                pstm.setInt(2, idCategoria);
            
                pstm.execute();
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {            
            throw new RuntimeException();
        }
    }
      
    //Lista com todas as categorias por curso
    public ArrayList<Integer> getCategoriasByCurso(int idCurso){
        conn = null;
        pstm = null;
        rs = null;
        ArrayList<Integer> categorias = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCATEGORIASBYCURSO);
            pstm.setInt(1, idCurso);
           
            rs = pstm.executeQuery();
            while (rs.next()) {                
                categorias.add(rs.getInt("idCategoria"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return categorias;
    }
    
    //Lista com todas as categorias e cursos
    public ArrayList<CursoHasCategoria> getCursosAndCategorias(){
        conn = null;
        pstm = null;
        rs = null;
        ArrayList<CursoHasCategoria> cursoscategorias = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCURSOSANDCATEGORIAS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                CursoHasCategoria cursocategoria = new CursoHasCategoria();
                
                cursocategoria.setIdCurso(rs.getInt("c.id"));                
                cursocategoria.setNomeCurso(rs.getString("c.nome"));
                cursocategoria.setSiglaCurso(rs.getString("c.sigla"));                
                cursocategoria.setPortariaCurso(rs.getString("c.portaria"));
                cursocategoria.setDescricaoCurso(rs.getString("c.descricao"));
                
                cursocategoria.setIdCategoria(rs.getInt("cat.id"));
                cursocategoria.setNomeCategoria(rs.getString("cat.nome"));
                cursocategoria.setDescricaoCategoria(rs.getString("cat.descricao"));
                
                cursoscategorias.add(cursocategoria);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return cursoscategorias;
    }
    //Curso e Categoria
    public CursoHasCategoria getCursoAndCategoria(int idCurso, int idCategoria){
        conn = null;
        pstm = null;
        rs = null;
        CursoHasCategoria cursocategoria = new CursoHasCategoria();
        CursoDAO cursoDAO = new CursoDAO();
        CategoriaDAO catDAO = new CategoriaDAO();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCURSOANDCATEGORIA);
            pstm.setInt(1, idCurso);
            pstm.setInt(2, idCategoria);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Curso curso = cursoDAO.getCurso(rs.getInt("idCurso"));
                cursocategoria.setIdCurso(curso.getId());
                cursocategoria.setNomeCurso(curso.getNome());
                cursocategoria.setSiglaCurso(curso.getSigla());
                cursocategoria.setPortariaCurso(curso.getPortaria());
                cursocategoria.setDescricaoCurso(curso.getDescricao());
                
                Categoria cat = catDAO.getCategoriaById(rs.getInt("idCategoria"));
                cursocategoria.setIdCategoria(cat.getId());
                cursocategoria.setNomeCategoria(cat.getNome());
                cursocategoria.setDescricaoCategoria(cat.getDescricao());
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return cursocategoria;
    }
    
    private final static String GETCATEGORIASBYCURSODWR = "select cat.*\n" +
                                                          "from Curso_has_Categoria as c_cat\n" +
                                                          "inner join Curso as c on c.id = c_cat.idCurso\n" +
                                                          "inner join Categoria as cat on cat.id = c_cat.idCategoria\n" +
                                                          "where c.id = ?;";
    
    public static ArrayList<Categoria> getCategoriasByCursoDWR(int idCurso){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        ArrayList<Categoria> categorias = new ArrayList<>();
        
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCATEGORIASBYCURSODWR);
            pstm.setInt(1, idCurso);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Categoria cat = new Categoria();
                
                cat.setId(rs.getInt("cat.id"));
                cat.setNome(rs.getString("cat.nome"));
                cat.setDescricao(rs.getString("cat.descricao"));
                
                categorias.add(cat);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return categorias;
    }
}
