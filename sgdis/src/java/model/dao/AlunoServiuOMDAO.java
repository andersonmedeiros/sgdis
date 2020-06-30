/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.AlunoServiuOM;

/**
 *
 * @author anderson
 */
public class AlunoServiuOMDAO {
    //Tabela
    String tabela = "Aluno_serviu_OM";
    
    //Atributos
    String idtAluno = "idtAluno";
    String idOM = "idOM";
    String datainicio = "datainicio";
    String datafim = "datafim";
    String ultfuncao1 = "ultfuncao1";
    String ultfuncao2 = "ultfuncao2";
    String ultfuncao3 = "ultfuncao3";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + idtAluno + "," + idOM + "," + datainicio + "," + datafim + "," + ultfuncao1 + "," + ultfuncao2 + "," + ultfuncao3 + ")" +
                                  " VALUES(?,?,?,?,?,?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + idtAluno + "=? AND " + idOM + "=? AND " + datainicio + "=? AND " + datafim + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(AlunoServiuOM alunoserviuom) {
        if (alunoserviuom != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setString(1, alunoserviuom.getIdentidadeAluno());
                pstm.setInt(2, alunoserviuom.getIdOM());
                pstm.setDate(3, alunoserviuom.getDatainicio());
                pstm.setDate(4, alunoserviuom.getDatafim());
                pstm.setString(5, alunoserviuom.getUltfuncao1());
                pstm.setString(6, alunoserviuom.getUltfuncao2());
                pstm.setString(7, alunoserviuom.getUltfuncao3());
                                                              
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
    public void delete(String idtAluno, int idOM, Date datainicio, Date datafim) {
        if (idtAluno != null && idOM != 0 && datainicio != null && datafim != null){
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setString(1, idtAluno);
                pstm.setInt(2, idOM);
                pstm.setDate(3, datainicio);
                pstm.setDate(4, datafim);
            
                pstm.execute();
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {            
            throw new RuntimeException();
        }
    }
}
