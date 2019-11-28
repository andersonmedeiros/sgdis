/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Assunto;
import bean.Disciplina;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author andersondepaula
 */
public class AssuntoDAO {
    //Tabela
    String tabela = "Assunto";
    
    //Atributos
    String codigo = "codigo";
    String nome = "nome";
    String chDiurna = "chDiurna";
    String chNoturna = "chNoturna";
    String codigoDisciplina = "codigoDisciplina";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + codigo + "," + nome + "," + chDiurna + "," + chNoturna + "," + codigoDisciplina + ")"
                                    + " VALUES(?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + nome + "=?, " + chDiurna + "=? " +  chNoturna+ "=? " + codigoDisciplina+ "=? " +
                                  "WHERE " + codigo + "=?;";
    
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + codigo + "=?;";
    
    //Consultas SQL
    private final String GETUltimoID = "SELECT MAX(" + codigo + ") as ultimo_id FROM " + tabela + ";";
    private final String GETUltimaVariacaoByCodigoDisc = "SELECT MAX(" + codigo + ") as ultima_variacao FROM " + tabela + " WHERE " + codigoDisciplina +"=?;";
    private final String GETAssuntoByCOD = "SELECT * FROM " + tabela + " WHERE " + codigo + "=?;";
    private final String GETAssuntosByCodDiscANDcodGradeANDidCurso = "SELECT * FROM " + tabela + 
                                                                     " INNER JOIN Disciplina AS d ON " + tabela + "." + codigoDisciplina + " = d.codigo" +
                                                                     " INNER JOIN Fase AS f ON d.codigoFase = f.codigo AND f.codigoGrade = ? AND f.idCurso = ?;";
    
    private final String GETASSUNTOS = "SELECT * FROM "+ tabela +";";
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    //Próximo ID a ser inserido
    public int proxVariacao(String codigoDisc){
        String ultima_variacao = "";
        int proxVariacao = 0;
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(GETUltimaVariacaoByCodigoDisc);
            pstm.setString(1, codigoDisc);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                ultima_variacao = rs.getString("ultima_variacao");
                if(ultima_variacao == null){
                    return 1;
                }else{
                    String[] s = rs.getString("ultima_variacao").split("_");
                    proxVariacao = Integer.parseInt(s[s.length-1]);
                }
                
            }
           
            ConnectionFactory.fechaConexao(conn, pstm);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        
        return (proxVariacao + 1);
    }
    
    //Insert SQL
    public void insert(Assunto assunto) {
        if (assunto != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setString(1, assunto.getCodigo());
                pstm.setString(2, assunto.getNome());
                pstm.setInt(3, assunto.getCh_diurna());
                pstm.setInt(4, assunto.getCh_noturna());
                pstm.setString(5, assunto.getCodigoDisciplina());
                                              
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
    public void update(Assunto assunto) {
        if (assunto != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                
                pstm.setString(1, assunto.getCodigo());
                pstm.setString(2, assunto.getNome());
                pstm.setInt(3, assunto.getCh_diurna());
                pstm.setInt(4, assunto.getCh_noturna());
                pstm.setString(5, assunto.getCodigoDisciplina());
            
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
    public void delete(String cod) {
        if (cod != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setString(1, cod);
            
                pstm.execute();
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {            
            throw new RuntimeException();
        }
    }
    
    //Assunto by codigo
    public Assunto getAssunto(String codigoAssunto){
        Assunto assunto = new Assunto();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETAssuntoByCOD);
            pstm.setString(1, codigoAssunto);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                assunto.setCodigo(rs.getString(codigo));
                assunto.setNome(rs.getString(nome));
                assunto.setCh_diurna(rs.getInt(chDiurna));
                assunto.setCh_noturna(rs.getInt(chNoturna));
                assunto.setCodigoDisciplina(rs.getString(codigoDisciplina));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return assunto;
    }
    
    //Lista com todos os assuntos
    public ArrayList<Assunto> getAssuntos(){
        conn = null;
        pstm = null;
        rs = null;
        ArrayList<Assunto> assuntos = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETASSUNTOS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Assunto assunto = new Assunto();
                
                assunto.setCodigo(rs.getString(codigo));
                assunto.setNome(rs.getString(nome));
                assunto.setCh_diurna(rs.getInt(chDiurna));
                assunto.setCh_noturna(rs.getInt(chNoturna));
                assunto.setCodigoDisciplina(rs.getString(codigoDisciplina));
                
                assuntos.add(assunto);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return assuntos;
    }
    
    //Lista com todas as disciplinas By Codigo Fase
    public ArrayList<Assunto> getAssuntosByCodGradeANDidCurso(String codGrade, int idcurso){
        conn = null;
        pstm = null;
        rs = null;
        ArrayList<Assunto> assuntos = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETAssuntosByCodDiscANDcodGradeANDidCurso);
            pstm.setString(1, codGrade);
            pstm.setInt(2, idcurso);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Assunto assunto = new Assunto();
                
                assunto.setCodigo(rs.getString(codigo));
                assunto.setNome(rs.getString(nome));
                assunto.setCh_diurna(rs.getInt(chDiurna));
                assunto.setCh_noturna(rs.getInt(chNoturna));
                assunto.setCodigoDisciplina(rs.getString(codigoDisciplina));
                
                assuntos.add(assunto);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return assuntos;
    }
}
