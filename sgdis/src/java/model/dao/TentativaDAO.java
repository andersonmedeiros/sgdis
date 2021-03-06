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
import model.bean.Tentativa;

/**
 *
 * @author anderson
 */
public class TentativaDAO {
    //Tabela
    String tabela = "Tentativa";
    
    //Atributos
    String id = "id";
    String mtvDeslg = "mtvDeslg";
    String faseDeslg = "faseDeslg";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + mtvDeslg + "," + faseDeslg + ") " +
                                  "VALUES(?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + mtvDeslg + "=?, " + faseDeslg + "=? " +
                                  "WHERE " + id + "=?;";
        
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
    public void insert(Tentativa tent) {
        if (tent != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, tent.getId());
                pstm.setString(2, tent.getMtvDeslg());
                pstm.setString(3, tent.getFaseDeslg());
                                                              
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
    public void update(Tentativa tent) {
        if (tent != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);                                
                
                pstm.setString(1, tent.getMtvDeslg());
                pstm.setString(2, tent.getFaseDeslg());
                pstm.setInt(3, tent.getId());
            
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
    
    private final String GETTENTATIVABYID = "SELECT * " +
                                            "FROM " + tabela + " " +
                                            "WHERE id = ?;";
       
    public Tentativa getTentativaById(int idTentativa){
        Tentativa tent = new Tentativa();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETTENTATIVABYID);
            pstm.setInt(1, idTentativa);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                tent.setId(rs.getInt("id"));
               tent.setMtvDeslg(rs.getString("mtvDeslg"));
               tent.setFaseDeslg(rs.getString("faseDeslg"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return tent;
    }
    
    private final String GETTAFS = "SELECT * " +
                                   "FROM " + tabela;
       
    public ArrayList<Tentativa> getTentativas(){
        ArrayList<Tentativa> tentativas = new ArrayList<>();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETTAFS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Tentativa tent = new Tentativa();
                
                tent.setId(rs.getInt("id"));
                tent.setMtvDeslg(rs.getString("mtvDeslg"));
                tent.setFaseDeslg(rs.getString("faseDeslg"));
                
                tentativas.add(tent);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return tentativas;
    }
    
    private final static String GETQTDETENTBYCANDIDATOANDCURSO = "SELECT COUNT(ha.identidade) AS qtdeTentativas " +
                                                                    "FROM HistoricoAluno as ha " +
                                                                    "INNER JOIN Turma_has_Aluno as tha on ha.idTentativa = tha.idTentativa " +
                                                                    "INNER JOIN Tentativa as tent on ha.idTentativa = tent.id " +
                                                                    "INNER JOIN Turma as t on tha.idTurma = t.id " +
                                                                    "INNER JOIN Curso as c on t.idCurso = c.id " +
                                                                    "INNER JOIN Categoria AS cat ON cat.id = t.idCategoria " +
                                                                    "WHERE ha.identidade = ? AND t.idCurso = ?;";
    
    //Quantidade de tentativas por candidato
    public static int getQtdeTentativasByCandidatoAndCurso(String idtCandidato, int idCurso){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int qtdeTentativas = 0;
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETQTDETENTBYCANDIDATOANDCURSO);
            pstm.setString(1, idtCandidato);
            pstm.setInt(2, idCurso);
            
           
            rs = pstm.executeQuery();
            if(rs.next()){
                qtdeTentativas = rs.getInt("qtdeTentativas");
            }
                
            
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return qtdeTentativas;
    }
    
    private final static String GETTENTATIVASBYCANDIDATOANDCURSO = "SELECT c.sigla, cat.nome, t.ano, t.turma, tent.* " +
                                                                    "FROM HistoricoAluno as ha " +
                                                                    "INNER JOIN Turma_has_Aluno as tha on ha.idTentativa = tha.idTentativa " +
                                                                    "INNER JOIN Tentativa as tent on ha.idTentativa = tent.id " +
                                                                    "INNER JOIN Turma as t on tha.idTurma = t.id " +
                                                                    "INNER JOIN Curso as c on t.idCurso = c.id " +
                                                                    "INNER JOIN Categoria AS cat ON cat.id = t.idCategoria " +
                                                                    "WHERE ha.identidade = ? AND t.idCurso = ?;";
    
    //Lista com as tentativas do candidato em um determinado curso
    public static ArrayList<Tentativa> getTentativasByCandidatoAndCursoDWR(String idtAluno, int idCurso){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Tentativa> tentativas = new ArrayList<>();
        
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETTENTATIVASBYCANDIDATOANDCURSO);
            pstm.setString(1, idtAluno);
            pstm.setInt(2, idCurso);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
               Tentativa tent = new Tentativa();
               
               tent.setId(rs.getInt("tent.id"));
               tent.setMtvDeslg(rs.getString("tent.mtvDeslg"));
               tent.setFaseDeslg(rs.getString("tent.faseDeslg"));
               tent.setSiglaCursoCat(rs.getString("c.sigla") + " " + rs.getString("cat.nome"));
               tent.setTurma(rs.getInt("t.ano") + "/" + rs.getString("t.turma"));
                
               tentativas.add(tent);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return tentativas;
    }
}
