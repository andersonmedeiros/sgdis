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
import model.bean.AlunoHasCursoMilitarHasCategoriaHasForca;

/**
 *
 * @author anderson
 */
public class AlunoHasCursoMilitarHasCategoriaHasForcaDAO {
    //Tabela
    String tabela = "Aluno_has_CursoMilitar_has_Categoria_has_Forca";
    
    //Atributos
    String idtAluno = "idtAluno";
    String idCursoMilitar = "idCursoMilitar";
    String idCategoria = "idCategoria";
    String idForca = "idForca";
    String anoconclusao = "anoconclusao";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + idtAluno + "," + idCursoMilitar + "," + idCategoria + "," + idForca + "," + anoconclusao + ")" +
                                  " VALUES(?,?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + idtAluno + "=? AND " + idCursoMilitar + "=? AND " + idCategoria + "=? AND " + idForca + "=? AND " + anoconclusao + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(AlunoHasCursoMilitarHasCategoriaHasForca alunocursomilitar) {
        if (alunocursomilitar != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setString(1, alunocursomilitar.getIdentidadeAluno());
                pstm.setInt(2, alunocursomilitar.getIdCursoMilitar());
                pstm.setInt(3, alunocursomilitar.getIdCategoria());
                pstm.setInt(4, alunocursomilitar.getIdForca());
                pstm.setInt(3, alunocursomilitar.getAnoconclusao());
                                                              
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
    public void delete(String idtAluno, int idCursoMilitar, int idCategoria, int idForca, int anoconclusao) {
        if (idtAluno != null && idCursoMilitar != 0 && idCategoria != 0 && idForca != 0 && anoconclusao != 0){
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setString(1, idtAluno);
                pstm.setInt(2, idCursoMilitar);
                pstm.setInt(3, idCategoria);
                pstm.setInt(4, idForca);
                pstm.setInt(5, anoconclusao);
            
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
