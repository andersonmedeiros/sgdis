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
import model.bean.Aluno;
import model.bean.InspecaoSaude;

/**
 *
 * @author anderson
 */
public class InspecaoSaudeDAO {
    //Tabela
    String tabela = "InspecaoSaude";
    
    //Atributos
    String id = "id";
    String situacao = "situacao";
    String idTurma = "idTurma";
    String idtAluno = "idtAluno";
    String idtMilitarAvaliador = "idtMilitarAvaliador";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + situacao + "," + idTurma + "," + idtAluno + "," + idtMilitarAvaliador + ") " +
                                  "VALUES(?,?,?,?,?);";
    
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " " +
                                  "WHERE " + id + "=?;";
    
    
    
    //Consultas SQL
    private final String GETUltimoID = "SELECT MAX(" + id + ") as ultimo_id FROM " + tabela + ";";
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    //Próximo ID a ser inserido
    public int proxID(){
        int ultimo_id = 0;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(GETUltimoID);
            rs = pstm.executeQuery();
            while (rs.next()) {
                
                ultimo_id = rs.getInt("ultimo_id");
            }
           
            ConnectionFactory.fechaConexao(conn, pstm);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return (ultimo_id+1);
    }   
    
    //Insert SQL
    public void insert(InspecaoSaude is) {
        if (is != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, is.getId());
                pstm.setInt(2, is.getSituacao());
                pstm.setInt(3, is.getIdTurma());
                pstm.setString(4, is.getIdentidadeAluno());
                pstm.setString(5, is.getIdentidadeMilitar());
                                                              
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
    public void delete(int id) {
        if (id != 0) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setInt(1, id);
            
                pstm.execute();
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {            
            throw new RuntimeException();
        }
    }

    private final static String GETISALUNOSBYTURMADWR = "SELECT tha.idtAluno, isau.* " +
                                                        "FROM InspecaoSaude AS isau " +
                                                        "RIGHT JOIN Turma_has_Aluno AS tha ON tha.idtAluno = isau.idtAluno AND tha.idTurma = isau.idTurma " +
                                                        "WHERE tha.idTurma = ?;";
    
    public static ArrayList<InspecaoSaude> getISAlunosByTurmaDWR(int idTurma){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<InspecaoSaude> iss = new ArrayList<>();
        AlunoDAO alDAO = new AlunoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETISALUNOSBYTURMADWR);
            pstm.setInt(1, idTurma);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                InspecaoSaude is = new InspecaoSaude();
                is.setId(rs.getInt("isau.id"));
                is.setSituacao(rs.getInt("isau.situacao"));
                
                Aluno al = alDAO.getAlunoByIdentidade(rs.getString("tha.idtAluno"));
                is.setIdentidadeAluno(al.getIdentidade());
                is.setAbreviaturaPostoGraduacaoAluno(al.getAbreviaturaPostoGraduacao());
                is.setNomeguerraAluno(al.getNomeguerra());
                
                iss.add(is);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return iss;
    }
}
