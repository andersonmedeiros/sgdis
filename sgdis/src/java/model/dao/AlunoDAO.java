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
import model.bean.Aluno;

/**
 *
 * @author anderson
 */
public class AlunoDAO {
    //Tabela
    String tabela = "Aluno";
    
    //Atributos
    String idt = "identidade";
    String nome = "nome";
    String sobrenome = "sobrenome";
    String nomeguerra = "nomeguerra";
    
    //Consultas SQL
    
    
    
    private final static String GETALUNODWR = "select identidade, nome, sobrenome, nomeguerra " +
                                              "from Aluno " +
                                              "where identidade = ?";
    
    public static Aluno getAlunoByIdentidadeDWR(String identidade){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Aluno al = new Aluno();
        
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETALUNODWR);
            pstm.setString(1, identidade);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
               al.setIdentidade(rs.getString("identidade"));
               al.setNome(rs.getString("nome"));
               al.setSobrenome(rs.getString("sobrenome"));
               al.setNomeguerra(rs.getString("nomeguerra"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return al;
    }
}
