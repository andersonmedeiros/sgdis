/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Turma;
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
    String id = "id";
    String ano = "ano";
    String nturma = "turma";
    String datainicio = "datainicio";
    String datafim = "datafim";
    String idCurso = "idCurso";
    String idCategoria = "idCategoria";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + ano + "," + nturma + "," + datainicio + "," + datafim + "," + idCurso + "," + idCategoria + ")"
                                    + " VALUES(?,?,?,?,?,?,?);";
        
    //Consultas SQL
    private final String GETUltimoID = "SELECT MAX(" + id + ") as ultimo_id FROM " + tabela + ";";
    private final String GETURMAS = "SELECT * FROM "+ tabela +";";
    
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
    public void insert(Turma turma) {
        if (turma != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, turma.getId());
                pstm.setString(2, turma.getAno());
                pstm.setInt(3, turma.getnTurma());
                pstm.setString(4, turma.getDataInicio());
                pstm.setString(5, turma.getDataFim());
                pstm.setInt(6, turma.getIdCurso());
                pstm.setInt(7, turma.getIdCategoria());
                                              
                pstm.execute();
                
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {
            throw new RuntimeException();
        }
    }
    
    //Lista com todas as turmas
    public ArrayList<Turma> getModalidades(){
        conn = null;
        pstm = null;
        rs = null;
        ArrayList<Turma> turmas = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETURMAS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Turma turma = new Turma();
               
               turma.setId(rs.getInt(id));
               turma.setAno(rs.getString(ano));               
               turma.setnTurma(rs.getInt(nturma));
               turma.setDataInicio(rs.getString(datainicio));
               turma.setDataFim(rs.getString(datafim));
               turma.setIdCurso(rs.getInt(idCurso));
               turma.setIdCategoria(rs.getInt(idCategoria));
                
               turmas.add(turma);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return turmas;
    }
    
    private final static String GETTURMAS = "select * " +
                                            "from Turma";
    
    public static ArrayList<Turma> getTurmas(){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Turma> turmas = new ArrayList<>();
        
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETTURMAS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
               Turma turma = new Turma();
               
               turma.setId(rs.getInt("id"));
               turma.setAno(rs.getString("ano"));               
               turma.setnTurma(rs.getInt("turma"));
               turma.setDataInicio(rs.getString("datainicio"));
               turma.setDataFim(rs.getString("datafim"));
               turma.setIdCurso(rs.getInt("idCurso"));
               turma.setIdCategoria(rs.getInt("idCategoria"));
                
               turmas.add(turma);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return turmas;
    }
    
    
    
}

