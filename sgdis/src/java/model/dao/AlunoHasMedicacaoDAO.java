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
import model.bean.AlunoHasMedicacao;

/**
 *
 * @author anderson
 */
public class AlunoHasMedicacaoDAO {
    //Tabela
    String tabela = "Aluno_has_Medicacao";
    
    //Atributos
    String idtAluno = "idtAluno";
    String idMedicacao = "idMedicacao";
    String frequencia = "frequencia";
    String periodo = "periodo";
    String tipo = "tipo";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + idtAluno + "," + idMedicacao + "," + frequencia + "," + periodo + "," + tipo + ")" +
                                  " VALUES(?,?,?,?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + idtAluno + "=? AND " + idMedicacao + "=? AND " + tipo + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(AlunoHasMedicacao alunomedicacao) {
        if (alunomedicacao != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setString(1, alunomedicacao.getIdentidadeAluno());
                pstm.setInt(2, alunomedicacao.getIdMedicacao());
                pstm.setInt(3, alunomedicacao.getFrequencia());
                pstm.setString(4, alunomedicacao.getPeriodo());
                pstm.setInt(5, alunomedicacao.getTipo());
                                                              
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
    public void delete(String idtAluno, int idMedicacao, int tipo) {
        if (idtAluno != null && idMedicacao != 0 && tipo != 0){
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setString(1, idtAluno);
                pstm.setInt(2, idMedicacao);
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
