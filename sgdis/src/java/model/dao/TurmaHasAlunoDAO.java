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
import java.util.ArrayList;
import model.bean.*;

/**
 *
 * @author anderson
 */
public class TurmaHasAlunoDAO {
    //Tabela
    String tabela = "Turma_has_Aluno";
    
    //Atributos
    String idTurma = "idTurma";
    String idtAluno = "idtAluno";
    String idTentativa = "idTentativa";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + idTurma + "," + idtAluno + "," + idTentativa + ") " +
                                  "VALUES(?,?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " " +
                                  "WHERE " + idTurma + "=? AND "+ idtAluno +"=? AND "+ idTentativa +"=?;";
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(TurmaHasAluno turmaAluno) {
        if (turmaAluno != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, turmaAluno.getIdTurma());
                pstm.setString(2, turmaAluno.getIdentidadeAluno());
                pstm.setInt(3, turmaAluno.getIdTentativa());
                                                              
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
    public void delete(int idTurma, String idtAluno, int idTentativa) {
        if (idTurma != 0 && idtAluno !=  null && idTentativa != 0) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setInt(1, idTurma);
                pstm.setString(2, idtAluno);
                pstm.setInt(3, idTentativa);
            
                pstm.execute();
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {            
            throw new RuntimeException();
        }
    }
    
    private final static String GETALUNOSBYTURMADWR = "SELECT idtAluno FROM Turma_has_Aluno WHERE idTurma = ?;";
    
    public static ArrayList<Aluno> getAlunosByTurmaDWR(int idTurma){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Aluno> alunos = new ArrayList<>();
        AlunoDAO alDAO = new AlunoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETALUNOSBYTURMADWR);
            pstm.setInt(1, idTurma);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Aluno al = alDAO.getAlunoByIdentidade(rs.getString("idtAluno"));
                
                alunos.add(al);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return alunos;
    }
    
}
