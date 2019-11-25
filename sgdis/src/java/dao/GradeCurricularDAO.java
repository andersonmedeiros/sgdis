/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.GradeCurricular;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author andersondepaula
 */
public class GradeCurricularDAO {
    //Tabela
    String tabela = "Grade";
    
    //Atributos
    String codigo = "codigo";
    String descricao = "descricao";
    String ano = "ano";
    String variacao = "variacao";
    String situacao = "situacao";
    String idCurso = "idCurso";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + codigo + "," + descricao + "," + ano + "," + variacao + "," + situacao + "," + idCurso +")"
                                    + " VALUES(?,?,?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + descricao + "=?, " + ano + "=?, " + variacao + "=?, " + situacao + "=?, " + idCurso + "=? " +
                                  "WHERE " + codigo + "=?;";
    
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + codigo + "=?;";
    
    //Consultas SQL
    private final String GETUltimaVariacaoByCursoANDAno = "SELECT MAX(" + variacao + ") as ultima_variacao FROM " + tabela + " WHERE " + idCurso + "=? and " + ano + "=?;";
    private final String GETGradeByCodigo = "SELECT * FROM " + tabela + " WHERE " + codigo + "=?;";
    private final String GETGRADES = "SELECT * FROM "+ tabela +";";
    
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    //Próximo ID a ser inserido
    public int proxVariacao(int idCurso, int ano){
        int ultima_variacao = 0;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(GETUltimaVariacaoByCursoANDAno);
            pstm.setInt(1, idCurso);
            pstm.setInt(2, ano);
            rs = pstm.executeQuery();
            while (rs.next()) {
                
                ultima_variacao = rs.getInt("ultima_variacao");
            }
           
            ConnectionFactory.fechaConexao(conn, pstm);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return (ultima_variacao+1);
    }
    
    //Insert SQL
    public void insert(GradeCurricular grade) {
        if (grade != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setString(1, grade.getCodigo());
                pstm.setString(2, grade.getDescricao());
                pstm.setInt(3, grade.getAno());
                pstm.setInt(4, grade.getVariacao());
                pstm.setString(5, grade.getSituacao());  
                pstm.setInt(6, grade.getIdCurso());
                                              
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
    public void update(GradeCurricular grade) {
        if (grade != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                
                pstm.setString(1, grade.getCodigo());
                pstm.setString(2, grade.getDescricao());
                pstm.setInt(3, grade.getAno());
                pstm.setInt(4, grade.getVariacao());
                pstm.setString(5, grade.getSituacao());  
                pstm.setInt(6, grade.getIdCurso());
            
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
    
    //Grade by Codigo
    public GradeCurricular getGrade(int id){
        GradeCurricular grade = new GradeCurricular();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETGradeByCodigo);
            pstm.setInt(1, id);
            
            rs = pstm.executeQuery();
            while (rs.next()) {                               
                grade.setCodigo(rs.getString(codigo));                
                grade.setDescricao(rs.getString(descricao));                
                grade.setAno(rs.getInt(ano));
                grade.setVariacao(rs.getInt(variacao));
                grade.setSituacao(rs.getString(situacao));
                grade.setIdCurso(rs.getInt(idCurso));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return grade;
    }
    
    //Lista com todas as grades curriculares
    public ArrayList<GradeCurricular> getGrades(){
        conn = null;
        pstm = null;
        rs = null;
        ArrayList<GradeCurricular> grades = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETGRADES);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                GradeCurricular grade = new GradeCurricular();
                
                grade.setCodigo(rs.getString(codigo));                
                grade.setDescricao(rs.getString(descricao));                
                grade.setAno(rs.getInt(ano));
                grade.setVariacao(rs.getInt(variacao));
                grade.setSituacao(rs.getString(situacao));
                grade.setIdCurso(rs.getInt(idCurso));
                
                grades.add(grade);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return grades;
    }
}
