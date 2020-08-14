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
import model.bean.Eaf;

/**
 *
 * @author anderson
 */
public class EafDAO {
    //Tabela
    String tabela = "EAF";
    String tabelaRec = "RecEAF";
    
    //Atributos
    String id = "id";
    String corrida = "corrida";
    String flexaobarra = "flexaobarra";
    String suspensaobarra = "suspensaobarra";
    String abdominal = "abdominal";
    String flexaobraco = "flexaobraco";
    String nadoSubmerso = "nadoSubmerso";
    String subidaCorda = "subidaCorda";
    String ppm = "ppm";
    String natacao = "natacao";
    String flutuacao = "flutuacao";
    String marcha15km = "marcha15km";
    String situacao = "situacao";
    String idTurma = "idTurma";
    String idtAluno = "idtAluno";
    String idtMilitarAvaliador = "idtMilitarAvaliador";
    
    String idRec = "id";
    String corridaRec = "corrida";
    String flexaobarraRec = "flexaobarra";
    String suspensaobarraRec = "suspensaobarra";
    String abdominalRec = "abdominal";
    String flexaobracoRec = "flexaobraco";
    String nadoSubmersoRec = "nadoSubmerso";
    String subidaCordaRec = "subidaCorda";
    String ppmRec = "ppm";
    String natacaoRec = "natacao";
    String flutuacaoRec = "flutuacao";
    String marcha15kmRec = "marcha15km";
    String situacaoRec = "situacao";
    String idTurmaRec = "idTurma";
    String idtAlunoRec = "idtAluno";
    String idtMilitarAvaliadorRec = "idtMilitarAvaliador";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + corrida + "," + flexaobarra + "," + suspensaobarra + "," + abdominal + "," + flexaobraco + "," + nadoSubmerso + "," + subidaCorda + "," + ppm + "," + natacao + "," + flutuacao + "," + marcha15km + "," + situacao + "," + idTurma + "," + idtAluno + "," + idtMilitarAvaliador + ") " +
                                  "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    //Insert SQL
    private final String INSERTREC = "INSERT INTO " + tabelaRec + "(" + idRec + "," + corridaRec + "," + flexaobarraRec + "," + suspensaobarraRec + "," + abdominalRec + "," + flexaobracoRec + "," + nadoSubmersoRec + "," + subidaCordaRec + "," + ppmRec + "," + natacaoRec + "," + flutuacaoRec + "," + marcha15kmRec + "," + situacaoRec + "," + idTurmaRec + "," + idtAlunoRec + "," + idtMilitarAvaliadorRec + ") " +
                                  "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " " +
                                  "WHERE " + id + "=?;";
    
    //Update SQL
    private final String UPDATECORRIDA = "UPDATE " + tabela +
                                        " SET " + corrida + "=?, " + situacao + "=? " +
                                        "WHERE " + idTurma + "=? AND " + idtAluno + "=? AND " + idtMilitarAvaliador + "=?";
    
    //Consultas SQL
    private final String GETUltimoID = "SELECT MAX(" + id + ") as ultimo_id FROM " + tabela + ";";
    private final String GETUltimoIDRec = "SELECT MAX(" + idRec + ") as ultimo_id FROM " + tabelaRec + ";";
    
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
    //Próximo ID a ser inserido
    public int proxIDRec(){
        int ultimo_id = 0;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(GETUltimoIDRec);
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
    public void insert(Eaf eaf) {
        if (eaf != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, eaf.getId());
                pstm.setTime(2, eaf.getCorrida());
                pstm.setInt(3, eaf.getFlexaoBarra());
                pstm.setTime(4, eaf.getSuspBarra());
                pstm.setInt(5, eaf.getAbdominal());
                pstm.setInt(6, eaf.getFlexaoBraco());
                pstm.setInt(7, eaf.getNadoSubmerso());
                pstm.setInt(8, eaf.getSubidaCorda());
                pstm.setTime(9, eaf.getPpm());
                pstm.setTime(10, eaf.getNatacao());
                pstm.setTime(11, eaf.getFlutuacao());
                pstm.setTime(12, eaf.getMarcha15km());
                pstm.setInt(13, eaf.getSituacao());
                pstm.setInt(14, eaf.getIdTurma());
                pstm.setString(15, eaf.getIdentidadeAluno());
                pstm.setString(16, eaf.getIdentidadeMilitar());
                                                              
                pstm.execute();
                
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {
            throw new RuntimeException();
        }
    }
    public void insertRec(Eaf eaf) {
        if (eaf != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERTREC);
                
                pstm.setInt(1, eaf.getIdRec());
                pstm.setTime(2, eaf.getCorridaRec());
                pstm.setInt(3, eaf.getFlexaoBarraRec());
                pstm.setTime(4, eaf.getSuspBarraRec());
                pstm.setInt(5, eaf.getAbdominalRec());
                pstm.setInt(6, eaf.getFlexaoBracoRec());
                pstm.setInt(7, eaf.getNadoSubmersoRec());
                pstm.setInt(8, eaf.getSubidaCordaRec());
                pstm.setTime(9, eaf.getPpmRec());
                pstm.setTime(10, eaf.getNatacaoRec());
                pstm.setTime(11, eaf.getFlutuacaoRec());
                pstm.setTime(12, eaf.getMarcha15kmRec());
                pstm.setInt(13, eaf.getSituacaoRec());
                pstm.setInt(14, eaf.getIdTurmaRec());
                pstm.setString(15, eaf.getIdentidadeAlunoRec());
                pstm.setString(16, eaf.getIdentidadeMilitarAvaliadorRec());
                                                              
                pstm.execute();
                
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {
            throw new RuntimeException();
        }
    }
    
    //Update SQL
    public void updateCorrida(Eaf eaf) {
        if (eaf != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATECORRIDA);
                
                pstm.setTime(1, eaf.getCorrida());
                pstm.setInt(2, eaf.getSituacao());
                pstm.setInt(3, eaf.getIdTurma());
                pstm.setString(4, eaf.getIdentidadeAluno());
                pstm.setString(5, eaf.getIdentidadeMilitar());
            
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

    private final static String GETEAFALUNOSBYTURMADWR = "SELECT tha.idtAluno, eaf.*, receaf.* " +
                                                        "FROM EAF AS eaf " +
                                                        "RIGHT JOIN Turma_has_Aluno AS tha ON tha.idtAluno = eaf.idtAluno AND tha.idTurma = eaf.idTurma " +
                                                        "LEFT JOIN RecEAF AS receaf ON tha.idtAluno = receaf.idtAluno AND tha.idTurma = receaf.idTurma " +
                                                        "WHERE tha.idTurma = ?;";
    
    public static ArrayList<Eaf> getEafsAlunosByTurmaDWR(int idTurma){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Eaf> eafs = new ArrayList<>();
        AlunoDAO alDAO = new AlunoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETEAFALUNOSBYTURMADWR);
            pstm.setInt(1, idTurma);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Eaf eaf = new Eaf();
                eaf.setId(rs.getInt("eaf.id"));
                eaf.setCorrida(rs.getTime("eaf.corrida"));
                eaf.setFlexaoBarra(rs.getInt("eaf.flexaobarra"));
                eaf.setSuspBarra(rs.getTime("eaf.suspensaobarra"));
                eaf.setAbdominal(rs.getInt("eaf.abdominal"));
                eaf.setFlexaoBraco(rs.getInt("eaf.flexaobraco"));
                eaf.setNadoSubmerso(rs.getInt("eaf.nadoSubmerso"));
                eaf.setSubidaCorda(rs.getInt("eaf.subidaCorda"));
                eaf.setPpm(rs.getTime("eaf.ppm"));
                eaf.setNatacao(rs.getTime("eaf.natacao"));
                eaf.setFlutuacao(rs.getTime("eaf.flutuacao"));
                eaf.setMarcha15km(rs.getTime("eaf.marcha15km"));
                eaf.setSituacao(rs.getInt("eaf.situacao"));
                
                Aluno al = alDAO.getAlunoByIdentidade(rs.getString("tha.idtAluno"));
                eaf.setIdentidadeAluno(al.getIdentidade());
                eaf.setAbreviaturaPostoGraduacaoAluno(al.getAbreviaturaPostoGraduacao());
                eaf.setNomeguerraAluno(al.getNomeguerra());
                
                eaf.setIdRec(rs.getInt("receaf.id"));
                eaf.setCorridaRec(rs.getTime("receaf.corrida"));
                eaf.setFlexaoBarraRec(rs.getInt("receaf.flexaobarra"));
                eaf.setSuspBarraRec(rs.getTime("receaf.suspensaobarra"));
                eaf.setAbdominalRec(rs.getInt("receaf.abdominal"));
                eaf.setFlexaoBracoRec(rs.getInt("receaf.flexaobraco"));
                eaf.setNadoSubmersoRec(rs.getInt("receaf.nadoSubmerso"));
                eaf.setSubidaCordaRec(rs.getInt("receaf.subidaCorda"));
                eaf.setPpmRec(rs.getTime("receaf.ppm"));
                eaf.setNatacaoRec(rs.getTime("receaf.natacao"));
                eaf.setFlutuacaoRec(rs.getTime("receaf.flutuacao"));
                eaf.setMarcha15kmRec(rs.getTime("receaf.marcha15km"));
                eaf.setSituacaoRec(rs.getInt("receaf.situacao"));
                
                Aluno alRec = alDAO.getAlunoByIdentidade(rs.getString("tha.idtAluno"));
                eaf.setIdentidadeAlunoRec(alRec.getIdentidade());
                eaf.setAbreviaturaPostoGraduacaoAlunoRec(alRec.getAbreviaturaPostoGraduacao());
                eaf.setNomeguerraAlunoRec(alRec.getNomeguerra());
                
                eafs.add(eaf);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return eafs;
    }
}
