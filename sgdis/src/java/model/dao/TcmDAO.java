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
import model.bean.Tcm;

/**
 *
 * @author anderson
 */
public class TcmDAO {
    //Tabela
    String tabela = "TCM";
    
    //Atributos
    String id = "id";
    String tcmt = "tcmt";
    String tcmp = "tcmp";
    String situacao = "situacao";
    String idTurma = "idTurma";
    String idtAluno = "idtAluno";
    String idtMilitarAvaliador = "idtMilitarAvaliador";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + tcmt + "," + tcmp + "," + situacao + "," + idTurma + "," + idtAluno + "," + idtMilitarAvaliador + ") " +
                                  "VALUES(?,?,?,?,?,?,?);";
        
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
    public void insert(Tcm tcm) {
        if (tcm != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, tcm.getId());
                pstm.setFloat(2, tcm.getTcmt());
                pstm.setFloat(3, tcm.getTcmp());
                pstm.setInt(4, tcm.getSituacao());
                pstm.setInt(5, tcm.getIdTurma());
                pstm.setString(6, tcm.getIdentidadeAluno());
                pstm.setString(7, tcm.getIdentidadeMilitar());
                                                              
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

    private final static String GETTCMALUNOSBYTURMADWR = "SELECT tha.idtAluno, tcm.* " +
                                                        "FROM TCM AS tcm " +
                                                        "RIGHT JOIN Turma_has_Aluno AS tha ON tha.idtAluno = tcm.idtAluno AND tha.idTurma = tcm.idTurma " +
                                                        "WHERE tha.idTurma = ?;";
    
    public static ArrayList<Tcm> getTcmsAlunosByTurmaDWR(int idTurma){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Tcm> tcms = new ArrayList<>();
        AlunoDAO alDAO = new AlunoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETTCMALUNOSBYTURMADWR);
            pstm.setInt(1, idTurma);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Tcm tcm = new Tcm();
                tcm.setId(rs.getInt("tcm.id"));
                tcm.setTcmt(rs.getFloat("tcm.tcmt"));
                tcm.setTcmp(rs.getFloat("tcm.tcmp"));
                tcm.setSituacao(rs.getInt("tcm.situacao"));
                
                Aluno al = alDAO.getAlunoByIdentidade(rs.getString("tha.idtAluno"));
                tcm.setIdentidadeAluno(al.getIdentidade());
                tcm.setAbreviaturaPostoGraduacaoAluno(al.getAbreviaturaPostoGraduacao());
                tcm.setNomeguerraAluno(al.getNomeguerra());
                
                tcms.add(tcm);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return tcms;
    }
}
