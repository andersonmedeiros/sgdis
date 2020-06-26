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
    String problemaRedimento = "problemaredimento";
    String dedicacaoDoutrinaOPS = "dedicacaodoutrinaopd";
    String fatorMotivador = "fatormotivador";
    String consultaSite = "consultadite";
    String csltAmbVirtualAl = "csltambvirtualal";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + prepFisica + "," + apoioFamilia + "," + apoioOM + "," + cursoPreparacaoCOS + "," + problemaRedimento + "," + dedicacaoDoutrinaOPS + "," + fatorMotivador + "," + consultaSite + "," + csltAmbVirtualAl + ")" +
                                  " VALUES(?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + prepFisica + "=?, " + apoioFamilia + "=?, " + apoioOM + "=?, " + cursoPreparacaoCOS + "=?, " + problemaRedimento + "=?, " + dedicacaoDoutrinaOPS + "=?, " + fatorMotivador + "=?, " + consultaSite + "=?, " + csltAmbVirtualAl + "=?, " +
                                  "WHERE " + id + "=?;";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
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
                pstm.setInt(7, prep.getDedicacaoDoutrinaOPS());
                pstm.setString(8, prep.getFatorMotivador());
                pstm.setInt(9, prep.getConsultaSite());
                pstm.setInt(10, prep.getCsltAmbVirtualAl());
                                                              
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
                pstm.setInt(6, prep.getDedicacaoDoutrinaOPS());
                pstm.setString(7, prep.getFatorMotivador());
                pstm.setInt(8, prep.getConsultaSite());
                pstm.setInt(9, prep.getCsltAmbVirtualAl());
                pstm.setInt(10, prep.getId());
            
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
                prep.setProblemaRedimento(rs.getInt("problemaredimento"));
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
                prep.setProblemaRedimento(rs.getInt("problemaredimento"));
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
