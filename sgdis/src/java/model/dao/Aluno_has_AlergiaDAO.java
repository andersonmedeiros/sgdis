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
import model.bean.Aluno_has_Alergia;

/**
 *
 * @author anderson
 */
public class Aluno_has_AlergiaDAO {
    //Tabela
    String tabela = "Aluno_has_Alergia";
    
    //Atributos
    String idtAluno = "idtAluno";
    String idAlergia = "idAlergia";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + idtAluno + "," + idAlergia + ")" +
                                  " VALUES(?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + idtAluno + "=? AND " + idAlergia + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(Aluno_has_Alergia alunoalergia) {
        if (alunoalergia != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setString(1, alunoalergia.getIdentidadeAluno());
                pstm.setInt(2, alunoalergia.getIdAlergia());
                                                              
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
    public void delete(String idtAluno, int idAlergia) {
        if (idtAluno != null && idAlergia != 0){
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setString(1, idtAluno);
                pstm.setInt(2, idAlergia);
            
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
