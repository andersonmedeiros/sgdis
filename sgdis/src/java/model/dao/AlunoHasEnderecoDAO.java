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
import model.bean.AlunoHasEndereco;

/**
 *
 * @author anderson
 */
public class AlunoHasEnderecoDAO {
    //Tabela
    String tabela = "Aluno_has_Endereco";
    
    //Atributos
    String idtAluno = "idtAluno";
    String idEndereco = "idEndereco";
    String numendereco = "numendereco";
    String tipo = "tipo";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + idtAluno + "," + idEndereco + "," + numendereco + "," + tipo + ")" +
                                  " VALUES(?,?,?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + idtAluno + "=? AND " + idEndereco + "=? AND " + tipo + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(AlunoHasEndereco alunoendereco) {
        if (alunoendereco != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setString(1, alunoendereco.getIdentidadeAluno());
                pstm.setInt(2, alunoendereco.getIdEndereco());
                pstm.setInt(3, alunoendereco.getTipo());
                                                              
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
    public void delete(String idtAluno, int idEndereco, int tipo) {
        if (idtAluno != null && idEndereco != 0 && tipo != 0){
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setString(1, idtAluno);
                pstm.setInt(2, idEndereco);
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
