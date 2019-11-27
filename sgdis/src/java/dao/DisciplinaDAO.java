/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class DisciplinaDAO {
    //Tabela
    String tabela = "Disciplina";
    
    //Atributos
    String codigo = "codigo";
    String nome = "nome";
    String abreviatura = "abreviatura";
    String codigoFase = "codigoFase";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + codigo + "," + nome + "," + abreviatura + "," + codigoFase + ")"
                                    + " VALUES(?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + nome + "=?, " + abreviatura+ "=? " +  codigoFase+ "=? " +
                                  "WHERE " + codigo + "=?;";
    
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + codigo + "=?;";
    
    //Consultas SQL
    private final String GETUltimoID = "SELECT MAX(" + codigo + ") as ultimo_id FROM " + tabela + ";";
    private final String GETUltimaVariacaoByCodigoFase = "SELECT MAX(" + codigo + ") as ultima_variacao FROM " + tabela + " WHERE " + codigoFase +"=?;";
    private final String GETDisciplinaByCOD = "SELECT * FROM " + tabela + " WHERE " + codigo + "=?;";
    private final String GETDISCIPLINASByCodFase = "SELECT * FROM " + tabela + 
                                                   " INNER JOIN  Fase AS f ON " + tabela + "." + codigoFase + " = f.codigo AND f.codigoGrade = ? AND f.idCurso = ?;";
    
    
    private final String GETDISCIPLINAS = "SELECT * FROM "+ tabela +";";
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    //Próximo ID a ser inserido
    public int proxVariacao(String codigoFase){
        String ultima_variacao = "";
        int proxVariacao = 0;
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(GETUltimaVariacaoByCodigoFase);
            pstm.setString(1, codigoFase);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                ultima_variacao = rs.getString("ultima_variacao");
                if(ultima_variacao == null){
                    return 1;
                }else{
                    proxVariacao = Integer.parseInt(rs.getString("ultima_variacao").replaceAll(codigoFase+"_", ""));
                }
                
            }
           
            ConnectionFactory.fechaConexao(conn, pstm);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        
        return (proxVariacao + 1);
    }
    
    //Insert SQL
    public void insert(Disciplina disciplina) {
        if (disciplina != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setString(1, disciplina.getCodigo());
                pstm.setString(2, disciplina.getNome());
                pstm.setString(3, disciplina.getAbreviatura());
                pstm.setString(4, disciplina.getCodigoFase());
                                              
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
    public void update(Disciplina disciplina) {
        if (disciplina != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                
                pstm.setString(1, disciplina.getCodigo());
                pstm.setString(2, disciplina.getNome());
                pstm.setString(3, disciplina.getAbreviatura());
                pstm.setString(4, disciplina.getCodigoFase());
            
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
    
    //Disciplina by ID
    public Disciplina getDisciplina(String codigoDisc){
        Disciplina disciplina = new Disciplina();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETDisciplinaByCOD);
            pstm.setString(1, codigoDisc);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                disciplina.setCodigo(rs.getString(codigo));
                disciplina.setNome(rs.getString(nome));
                disciplina.setAbreviatura(rs.getString(abreviatura));
                disciplina.setCodigoFase(rs.getString(codigoFase));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return disciplina;
    }
    
    //Lista com todas as disciplinas
    public ArrayList<Disciplina> getDisciplinas(){
        conn = null;
        pstm = null;
        rs = null;
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETDISCIPLINAS);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Disciplina disciplina = new Disciplina();
                
                disciplina.setCodigo(rs.getString(codigo));
                disciplina.setNome(rs.getString(nome));
                disciplina.setAbreviatura(rs.getString(abreviatura));
                disciplina.setCodigoFase(rs.getString(codigoFase));
                
                disciplinas.add(disciplina);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return disciplinas;
    }
    
    //Lista com todas as disciplinas By Codigo Fase
    public ArrayList<Disciplina> getDisciplinas(String codGrade, int idcurso){
        conn = null;
        pstm = null;
        rs = null;
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETDISCIPLINASByCodFase);
            pstm.setString(1, codGrade);
            pstm.setInt(2, idcurso);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Disciplina disciplina = new Disciplina();
                
                disciplina.setCodigo(rs.getString(codigo));
                disciplina.setNome(rs.getString(nome));
                disciplina.setAbreviatura(rs.getString(abreviatura));
                disciplina.setCodigoFase(rs.getString(codigoFase));
                
                disciplinas.add(disciplina);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return disciplinas;
    }
}
