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
import model.bean.AlunoHasReferencia;

/**
 *
 * @author anderson
 */
public class AlunoHasReferenciaDAO {
    //Tabela
    String tabela = "Aluno_has_Referencia";
    
    //Atributos
    String idtAluno = "idtAluno";
    String cpfReferencia = "cpfReferencia";
    String tipo = "tipo";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + idtAluno + "," + cpfReferencia + "," + tipo + ")" +
                                  " VALUES(?,?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + idtAluno + "=? AND " + cpfReferencia + "=? AND " + tipo + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(AlunoHasReferencia alunoreferencia) {
        if (alunoreferencia != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setString(1, alunoreferencia.getIdentidadeAluno());
                pstm.setString(2, alunoreferencia.getCpfReferencia());
                pstm.setInt(3, alunoreferencia.getTipo());
                                                              
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
    public void delete(String idtAluno, String cpfReferencia, int tipo) {
        if (idtAluno != null && cpfReferencia != null && tipo != 0){
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setString(1, idtAluno);
                pstm.setString(2, cpfReferencia);
                pstm.setInt(3, tipo);
            
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
