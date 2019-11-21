/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Curso;
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
    String ano = "ano";
    String variacao = "variacao";
    String situacao = "situacao";
    String idCurso = "idCurso";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + codigo + "," + ano + "," + variacao + "," + situacao + "," + idCurso +")"
                                    + " VALUES(?,?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + ano + "=?, " + variacao + "=?, " + situacao + "=?, " + idCurso + "=? " +
                                  "WHERE " + codigo + "=?;";
    
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + codigo + "=?;";
    
    //Consultas SQL
    private final String GETUltimoCODIGOByCurso = "SELECT MAX(" + codigo + ") as ultimo_id FROM " + tabela + " WHERE " + idCurso + "=?;";
    private final String GETGradeByCodigo = "SELECT * FROM " + tabela + " WHERE " + codigo + "=?;";
    private final String GETGRADES = "SELECT * FROM "+ tabela +";";
    
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    //Próximo ID a ser inserido
    /*public int proxID(){
        int ultimo_id = 0;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(GETUltimoCODIGOByCurso);
            rs = pstm.executeQuery();
            while (rs.next()) {
                
                ultimo_id = rs.getInt("ultimo_id");
            }
           
            ConnectionFactory.fechaConexao(conn, pstm);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return (ultimo_id+1);
    }*/
    
    //Insert SQL
    public void insert(GradeCurricular grade) {
        if (grade != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setString(1, grade.getCodigo());
                pstm.setInt(2, grade.getAno());
                pstm.setInt(3, grade.getVariacao());
                pstm.setString(4, grade.getSituacao());  
                pstm.setInt(5, grade.getIdCurso());
                                              
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
                pstm.setInt(2, grade.getAno());
                pstm.setInt(3, grade.getVariacao());
                pstm.setString(4, grade.getSituacao());  
                pstm.setInt(5, grade.getIdCurso());
            
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
    public ArrayList<GradeCurricular> getGradeCurricular(){
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
