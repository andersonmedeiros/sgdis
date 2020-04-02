/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Assunto;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author depaula
 */
public class TurmaDAO {
    //Tabela
    String tabela = "Turma";
    
    //Atributos
    String codigo = "id";
    String nome = "nome";
    String chDiurna = "chDiurna";
    String chNoturna = "chNoturna";
    String codigoDisciplina = "codigoDisciplina";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + codigo + "," + nome + "," + chDiurna + "," + chNoturna + "," + codigoDisciplina + ")"
                                    + " VALUES(?,?,?,?,?);";
    
    
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    
    //Insert SQL
    public void insert(Assunto assunto) {
        if (assunto != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setString(1, assunto.getCodigo());
                pstm.setString(2, assunto.getNome());
                pstm.setInt(3, assunto.getCh_diurna());
                pstm.setInt(4, assunto.getCh_noturna());
                pstm.setString(5, assunto.getCodigoDisciplina());
                                              
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

