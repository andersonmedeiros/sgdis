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
import model.bean.Preparacao;

/**
 *
 * @author anderson
 */
public class PreparacaoDAO {
    //Tabela
    String tabela = "Preparacao";
    
    //Atributos
    String id = "id";
    String prepFisica = "prepfisica";
    String apoioFamilia = "apoiofamilia";
    String apoioOM = "apoioom";
    String cursoPreparacaoCOS = "cursopreparacaocos";
    String problemaRedimento = "problemarendimento";
    String tempoPrep = "tempoprep";
    String dedicacaoDoutrinaOPS = "dedicacaodoutrinaops";
    String fatorMotivador = "fatormotivador";
    String consultaSite = "consultasite";
    String csltAmbVirtualAl = "csltambvirtualal";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + prepFisica + "," + apoioFamilia + "," + apoioOM + "," + cursoPreparacaoCOS + "," + problemaRedimento + "," + tempoPrep + "," + dedicacaoDoutrinaOPS + "," + fatorMotivador + "," + consultaSite + "," + csltAmbVirtualAl + ")" +
                                  " VALUES(?,?,?,?,?,?,?,?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + prepFisica + "=?, " + apoioFamilia + "=?, " + apoioOM + "=?, " + cursoPreparacaoCOS + "=?, " + problemaRedimento + "=?, " + tempoPrep + "=?, " + dedicacaoDoutrinaOPS + "=?, " + fatorMotivador + "=?, " + consultaSite + "=?, " + csltAmbVirtualAl + "=? " +
                                  "WHERE " + id + "=?;";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
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
    public void insert(Preparacao prep) {
        if (prep != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, prep.getId());
                pstm.setString(2, prep.getPrepFisica());
                pstm.setInt(3, prep.getApoioFamilia());
                pstm.setInt(4, prep.getApoioOM());
                pstm.setInt(5, prep.getCursoPreparacaoCOS());
                pstm.setInt(6, prep.getProblemaRedimento());
                pstm.setInt(7, prep.getTempoPrep());
                pstm.setInt(8, prep.getDedicacaoDoutrinaOPS());
                pstm.setString(9, prep.getFatorMotivador());
                pstm.setInt(10, prep.getConsultaSite());
                pstm.setInt(11, prep.getCsltAmbVirtualAl());
                                                              
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
    public void update(Preparacao prep) {
        if (prep != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);                
               
                pstm.setString(1, prep.getPrepFisica());
                pstm.setInt(2, prep.getApoioFamilia());
                pstm.setInt(3, prep.getApoioOM());
                pstm.setInt(4, prep.getCursoPreparacaoCOS());
                pstm.setInt(5, prep.getProblemaRedimento());                
                pstm.setInt(6, prep.getTempoPrep());
                pstm.setInt(7, prep.getDedicacaoDoutrinaOPS());
                pstm.setString(8, prep.getFatorMotivador());
                pstm.setInt(9, prep.getConsultaSite());
                pstm.setInt(10, prep.getCsltAmbVirtualAl());
                pstm.setInt(11, prep.getId());
            
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
        if (id != 0){
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
    
    private final String GETPREPARACAPBYID = "SELECT * " +
                                      "FROM " + tabela + " " +
                                      "WHERE id = ?;";
       
    public Preparacao getPreparacaoById(int idPreparacap){
        Preparacao prep = new Preparacao();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETPREPARACAPBYID);
            pstm.setInt(1, idPreparacap);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                prep.setId(rs.getInt("id"));
                prep.setPrepFisica(rs.getString("prepfisica"));
                prep.setApoioFamilia(rs.getInt("apoiofamilia"));
                prep.setApoioOM(rs.getInt("apoioom"));
                prep.setCursoPreparacaoCOS(rs.getInt("cursopreparacaocos"));
                prep.setProblemaRedimento(rs.getInt("problemarendimento"));
                prep.setTempoPrep(rs.getInt("tempoprep"));
                prep.setDedicacaoDoutrinaOPS(rs.getInt("dedicacaodoutrinaops"));
                prep.setFatorMotivador(rs.getString("fatormotivador"));
                prep.setConsultaSite(rs.getInt("consultasite"));
                prep.setCsltAmbVirtualAl(rs.getInt("csltambvirtualal"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return prep;
    }
    
    private final String GETPREPARACAOEXISTENTE = "SELECT * " + 
                                                " FROM " + tabela + 
                                                " WHERE " + prepFisica + "=? AND " + apoioFamilia + "=? AND " + apoioOM + "=? AND " + cursoPreparacaoCOS + "=? AND " + problemaRedimento + "=? AND " + tempoPrep + "=? AND " + dedicacaoDoutrinaOPS + "=? AND " + fatorMotivador + "=? AND " + consultaSite + "=? AND " + csltAmbVirtualAl + "=?;";

    public Preparacao getPreparacaoExistente(String prepFisica, int apoioFamilia, int apoioOM, int cursoPreparacaoCOS, int problemaRendimento, int tempoPrep, int dedicacaoDoutrinaOPS, String fatorMotivador, int consultaSite, int csltAmbVirtualAl){
        Preparacao prep = new Preparacao();   
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETPREPARACAOEXISTENTE);
            pstm.setString(1, prepFisica);
            pstm.setInt(2, apoioFamilia);
            pstm.setInt(3, apoioOM);
            pstm.setInt(4, cursoPreparacaoCOS);
            pstm.setInt(5, problemaRendimento);
            pstm.setInt(6, tempoPrep);
            pstm.setInt(7, dedicacaoDoutrinaOPS);
            pstm.setString(8, fatorMotivador);
            pstm.setInt(9, consultaSite);
            pstm.setInt(10, csltAmbVirtualAl);
           
            rs = pstm.executeQuery();
            while (rs.next()) {                
                prep.setId(rs.getInt("id"));
                prep.setPrepFisica(rs.getString("prepfisica"));
                prep.setApoioFamilia(rs.getInt("apoiofamilia"));
                prep.setApoioOM(rs.getInt("apoioom"));
                prep.setCursoPreparacaoCOS(rs.getInt("cursopreparacaocos"));
                prep.setProblemaRedimento(rs.getInt("problemarendimento"));
                prep.setTempoPrep(rs.getInt("tempoprep"));
                prep.setDedicacaoDoutrinaOPS(rs.getInt("dedicacaodoutrinaops"));
                prep.setFatorMotivador(rs.getString("fatormotivador"));
                prep.setConsultaSite(rs.getInt("consultasite"));
                prep.setCsltAmbVirtualAl(rs.getInt("csltambvirtualal"));
                
                return prep;
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return null;
    }
    
    private final String GETPREPARACOES = "SELECT * " +
                                          "FROM " + tabela;
       
    public ArrayList<Preparacao> getPreparacoes(){
        ArrayList<Preparacao> preps = new ArrayList<>();        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETPREPARACOES);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Preparacao prep = new Preparacao();
                
                prep.setId(rs.getInt("id"));
                prep.setPrepFisica(rs.getString("prepfisica"));
                prep.setApoioFamilia(rs.getInt("apoiofamilia"));
                prep.setApoioOM(rs.getInt("apoioom"));
                prep.setCursoPreparacaoCOS(rs.getInt("cursopreparacaocos"));
                prep.setProblemaRedimento(rs.getInt("problemarendimento"));
                prep.setTempoPrep(rs.getInt("tempoprep"));
                prep.setDedicacaoDoutrinaOPS(rs.getInt("dedicacaodoutrinaops"));
                prep.setFatorMotivador(rs.getString("fatormotivador"));
                prep.setConsultaSite(rs.getInt("consultasite"));
                prep.setCsltAmbVirtualAl(rs.getInt("csltambvirtualal"));
                
                preps.add(prep);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return preps;
    }
}
