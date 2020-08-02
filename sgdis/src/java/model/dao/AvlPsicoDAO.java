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
import model.bean.AvlPsico;

/**
 *
 * @author anderson
 */
public class AvlPsicoDAO {
    //Tabela
    String tabela = "AvlPsico";
    
    //Atributos
    String id = "id";
    String situacao = "situacao";
    String rto = "rto";
    String idTurma = "idTurma";
    String idtAluno = "idtAluno";
    String idtMilitarAvaliador = "idtMilitarAvaliador";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + situacao + "," + rto + "," + idTurma + "," + idtAluno + "," + idtMilitarAvaliador + ") " +
                                  "VALUES(?,?,?,?,?,?);";
        
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
    public void insert(AvlPsico avlpsico) {
        if (avlpsico != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, avlpsico.getId());
                pstm.setInt(2, avlpsico.getSituacao());
                pstm.setString(3, avlpsico.getRto());
                pstm.setInt(4, avlpsico.getIdTurma());
                pstm.setString(5, avlpsico.getIdentidadeAluno());
                pstm.setString(6, avlpsico.getIdentidadeMilitar());
                                                              
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
    
    private final static String GETSITAVLPSICOBYIDTALUNOANDTURMADWR = "SELECT situacao FROM AvlPsico WHERE idtAluno = ? and idTurma = ?;";
    
    public static String getSituacaoAvlPsicoByAlunoAndTurmaDWR(String idtAluno, int idTurma){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sit = "NÃO REALIZADO";
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETSITAVLPSICOBYIDTALUNOANDTURMADWR);
            pstm.setString(1, idtAluno);
            pstm.setInt(2, idTurma);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                if(!rs.getString("situacao").equals("")){
                    sit = rs.getString("situacao");
                }
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return sit;
    }

    private final static String GETAVLPSICOALUNOSBYTURMADWR = "SELECT tha.idtAluno, avp.* " +
                                                            "FROM AvlPsico AS avp " +
                                                            "RIGHT JOIN Turma_has_Aluno AS tha ON tha.idtAluno = avp.idtAluno AND tha.idTurma = avp.idTurma " +
                                                            "WHERE tha.idTurma = ?;";
    
    public static ArrayList<AvlPsico> getAvlPsicoAlunosByTurmaDWR(int idTurma){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<AvlPsico> avls = new ArrayList<>();
        AvlPsicoDAO avlpsicoDAO = new AvlPsicoDAO();
        AlunoDAO alDAO = new AlunoDAO();
        TurmaDAO turmaDAO = new TurmaDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETAVLPSICOALUNOSBYTURMADWR);
            pstm.setInt(1, idTurma);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                AvlPsico avp = new AvlPsico();
                avp.setId(rs.getInt("avp.id"));
                avp.setSituacao(rs.getInt("avp.situacao"));
                
                Aluno al = alDAO.getAlunoByIdentidade(rs.getString("tha.idtAluno"));
                avp.setIdentidadeAluno(al.getIdentidade());
                avp.setAbreviaturaPostoGraduacaoAluno(al.getAbreviaturaPostoGraduacao());
                avp.setNomeguerraAluno(al.getNomeguerra());
                
                avls.add(avp);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return avls;
    }
}
