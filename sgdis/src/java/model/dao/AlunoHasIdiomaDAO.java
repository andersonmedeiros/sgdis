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
import model.bean.AlunoHasIdioma;

/**
 *
 * @author anderson
 */
public class AlunoHasIdiomaDAO {
    //Tabela
    String tabela = "Aluno_has_Idioma";
    
    //Atributos
    String idtAluno = "idtAluno";
    String idIdioma = "idIdioma";
    String ipl = "ipl";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + idtAluno + "," + idIdioma + "," + ipl + ")" +
                                  " VALUES(?,?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + idtAluno + "=? AND " + idIdioma + "=? AND " + ipl + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(AlunoHasIdioma alunoidioma) {
        if (alunoidioma != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setString(1, alunoidioma.getIdentidadeAluno());
                pstm.setInt(2, alunoidioma.getIdIdioma());
                pstm.setString(3, alunoidioma.getIpl());
                                                              
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
    public void delete(String idtAluno, int idIdioma, String ipl) {
        if (idtAluno != null && idIdioma != 0 && ipl != null){
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setString(1, idtAluno);
                pstm.setInt(2, idIdioma);
                pstm.setString(3, ipl);
            
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
