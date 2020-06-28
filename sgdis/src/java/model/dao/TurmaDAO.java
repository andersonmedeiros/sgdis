/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Turma;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bean.Categoria;
import model.bean.Curso;

/**
 *
 * @author depaula
 */
public class TurmaDAO {
    //Tabela
    String tabela = "Turma";
    
    //Atributos
    String id = "id";
    String ano = "ano";
    String nturma = "turma";
    String datainicio = "datainicio";
    String datafim = "datafim";
    String idCurso = "idCurso";
    String idCategoria = "idCategoria";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + ano + "," + nturma + "," + datainicio + "," + datafim + "," + idCurso + "," + idCategoria + ") " +
                                  "VALUES(?,?,?,?,?,?,?);";
    
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + 
                                  " WHERE " + id + "=?;";
        
    //Consultas SQL
    private final String GETUltimoID = "SELECT MAX(" + id + ") ultimo_id " + 
                                       "FROM " + tabela + ";";
    
    private final String GETURMAS = "SELECT * " + 
                                    "FROM "+ tabela +";";
    
    private final String GETQTDETURMABYCURSOANDANO = "SELECT COUNT(idCurso) ultnTurma " + 
                                                     "FROM Turma " + 
                                                     "WHERE idCurso = ? and ano = ?;";
    
    private final String GETEXISTETURMA = "SELECT COUNT(id) qtdeTurmas " + 
                                          "FROM Turma " + 
                                          "WHERE idCurso = ? AND idCategoria = ? AND dataInicio = ? AND dataFim = ?;";
    
    private final String GETTURMASABERTAS = "SELECT * " + 
                                            "FROM Turma " + 
                                            "WHERE date(sysdate()) < datafim " + 
                                            "ORDER BY idCurso, idCategoria;";
    
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
    
    //Próxima turma no curso
    public int proxnTurma(int idCurso, int ano){
        int ultima_turma = 0;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(GETQTDETURMABYCURSOANDANO);
            pstm.setInt(1, idCurso);
            pstm.setInt(2, ano);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                
                ultima_turma = rs.getInt("ultnTurma");
            }
           
            ConnectionFactory.fechaConexao(conn, pstm);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return (ultima_turma+1);
    }
    
    //Pesquisa se já existe uma turma no mesmo período
    public boolean getExisteTurma(int idCurso, int idCategoria, Date dataInicio, Date dataFim){
        boolean existeTurma = false;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(GETEXISTETURMA);
            pstm.setInt(1, idCurso);
            pstm.setInt(2, idCategoria);
            pstm.setDate(3, dataInicio);
            pstm.setDate(4, dataFim);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                if(rs.getInt("qtdeTurmas") > 0){
                    existeTurma = true;
                }
            }
           
            ConnectionFactory.fechaConexao(conn, pstm);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return existeTurma;
    }
    
    //Insert SQL
    public void insert(Turma turma) {
        if (turma != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, turma.getId());
                pstm.setInt(2, turma.getAno());
                pstm.setInt(3, turma.getnTurma());
                pstm.setDate(4, turma.getDataInicio());
                pstm.setDate(5, turma.getDataFim());
                pstm.setInt(6, turma.getIdCurso());
                pstm.setInt(7, turma.getIdCategoria());
                                              
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
    
    //Lista com todas as turmas
    public ArrayList<Turma> getTurmas(){
        ArrayList<Turma> turmas = new ArrayList<>();
        CursoDAO cursoDAO = new CursoDAO();
        CategoriaDAO catDAO = new CategoriaDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETURMAS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
               Turma turma = new Turma();
               
               turma.setId(rs.getInt(id));
               turma.setAno(rs.getInt(ano));               
               turma.setnTurma(rs.getInt(nturma));
               turma.setDataInicio(rs.getDate(datainicio));
               turma.setDataFim(rs.getDate(datafim));
               
               Curso curso = cursoDAO.getCurso(rs.getInt(idCurso));
               turma.setIdCurso(curso.getId());
               turma.setNomeCurso(curso.getNome());
               turma.setSiglaCurso(curso.getSigla());
               turma.setPortariaCurso(curso.getPortaria());
               turma.setDescricaoCurso(curso.getDescricao());
               
               Categoria cat = catDAO.getCategoriaById(rs.getInt(idCategoria));
               turma.setIdCategoria(cat.getId());
               turma.setNomeCategoria(cat.getNome());
               turma.setDescricaoCategoria(cat.getDescricao());
               
               turma.setTurma(rs.getInt(ano) + "/" + rs.getInt(nturma));
                
               turmas.add(turma);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return turmas;
    }
    
    //Lista com todas as turmas abertas
    public ArrayList<Turma> getTurmasAbertas(){
        ArrayList<Turma> turmas = new ArrayList<>();
        CursoDAO cursoDAO = new CursoDAO();
        CategoriaDAO catDAO = new CategoriaDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETTURMASABERTAS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
               Turma turma = new Turma();
               
               turma.setId(rs.getInt(id));
               turma.setAno(rs.getInt(ano));               
               turma.setnTurma(rs.getInt(nturma));
               turma.setDataInicio(rs.getDate(datainicio));
               turma.setDataFim(rs.getDate(datafim));
               
               Curso curso = cursoDAO.getCurso(rs.getInt(idCurso));
               turma.setIdCurso(curso.getId());
               turma.setNomeCurso(curso.getNome());
               turma.setSiglaCurso(curso.getSigla());
               turma.setPortariaCurso(curso.getPortaria());
               turma.setDescricaoCurso(curso.getDescricao());
               
               Categoria cat = catDAO.getCategoriaById(rs.getInt(idCategoria));
               turma.setIdCategoria(cat.getId());
               turma.setNomeCategoria(cat.getNome());
               turma.setDescricaoCategoria(cat.getDescricao());
               
               turma.setTurma(rs.getInt(ano) + "/" + rs.getInt(nturma));
                
               turmas.add(turma);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return turmas;
    }
    
    private final static String GETTURMASBYCURSOANDCATEGORIA = "SELECT * " +
                                            "FROM Turma " +
                                            "WHERE idCurso = ? AND idCategoria = ?";
    
    public static ArrayList<Turma> getTurmasByCursoAndCategoriaDWR(int idCurso, int idCategoria){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Turma> turmas = new ArrayList<>();
        CursoDAO cursoDAO = new CursoDAO();
        CategoriaDAO catDAO = new CategoriaDAO();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETTURMASBYCURSOANDCATEGORIA);
            pstm.setInt(1, idCurso);
            pstm.setInt(2, idCategoria);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
               Turma turma = new Turma();
               
               turma.setId(rs.getInt("id"));
               turma.setAno(rs.getInt("ano"));               
               turma.setnTurma(rs.getInt("nturma"));
               turma.setDataInicio(rs.getDate("datainicio"));
               turma.setDataFim(rs.getDate("datafim"));
               
               Curso curso = cursoDAO.getCurso(rs.getInt("idCurso"));
               turma.setIdCurso(curso.getId());
               turma.setNomeCurso(curso.getNome());
               turma.setSiglaCurso(curso.getSigla());
               turma.setPortariaCurso(curso.getPortaria());
               turma.setDescricaoCurso(curso.getDescricao());
               
               Categoria cat = catDAO.getCategoriaById(rs.getInt("idCategoria"));
               turma.setIdCategoria(cat.getId());
               turma.setNomeCategoria(cat.getNome());
               turma.setDescricaoCategoria(cat.getDescricao());
               
               turma.setTurma(rs.getInt("ano") + "/" + rs.getInt("nturma"));
                
               turmas.add(turma);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return turmas;
    }
}
