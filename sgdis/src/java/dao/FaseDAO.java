/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Fase;
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
public class FaseDAO {
    //Tabela
    String tabela = "Fase";
    
    //Atributos
    String codigo = "codigo";
    String nome = "nome";
    String abreviatura = "abreviatura";
    String descricao = "descricao";
    String idModulo = "idModulo";
    String idModalidade = "idModalidade";
    String idCurso = "idCurso";
    String codigoGrade = "codigoGrade";
    
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + codigo + "," + nome + "," + abreviatura + ","  + descricao + "," + 
                                                                  codigoGrade + "," + idCurso + "," + idModulo + ","  + idModalidade +")" +
                                  " VALUES(?,?,?,?,?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " +  nome + "=?, " + abreviatura + "=?, " + descricao + "=? " + 
                                  "WHERE " + codigo + "=?;";
    
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + codigo + "=?;";
    
    //Consultas SQL
    private final String GETUltimoCOD = "SELECT MAX(" + codigo + ") as ultimo_id FROM " + tabela + ";";
    private final String GETFaseByCOD = "SELECT * FROM " + tabela + " WHERE " + codigo + "=?;";
    private final String GETFasesByCodGradeANDidCurso = "SELECT * FROM " + tabela + " WHERE " + codigoGrade + "=? AND " + idCurso + "=?;";
    private final String GETFASES = "SELECT * FROM "+ tabela +";";
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    //Próximo ID a ser inserido
    public int proxID(){
        int ultimo_id = 0;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(GETUltimoCOD);
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
    public void insert(Fase fase) {
        if (fase != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setString(1, fase.getCodigo());
                pstm.setString(2, fase.getNome());
                pstm.setString(3, fase.getAbreviatura());
                pstm.setString(4, fase.getDescricao());
                pstm.setString(5, fase.getCodigoGrade());
                pstm.setInt(6, fase.getIdCurso());
                pstm.setInt(7, fase.getIdModulo());
                pstm.setInt(8, fase.getIdModalidade());
                                              
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
    public void update(Fase fase) {
        if (fase != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                
                pstm.setString(1, fase.getNome());
                pstm.setString(2, fase.getAbreviatura());
                pstm.setString(3, fase.getDescricao());
                pstm.setString(4, fase.getCodigo());
            
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
    public void delete(String codigo) {
        if (codigo != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setString(1, codigo);
            
                pstm.execute();
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {            
            throw new RuntimeException();
        }
    }
    
    //Fase by Codigo
    public Fase getFase(String codFase){
        Fase fase = new Fase();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETFaseByCOD);
            pstm.setString(1, codFase);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                fase.setCodigo(rs.getString(codigo));
                fase.setNome(rs.getString(nome));
                fase.setAbreviatura(rs.getString(abreviatura));
                fase.setDescricao(rs.getString(descricao));
                fase.setCodigoGrade(rs.getString(codigoGrade));
                fase.setIdCurso(rs.getInt(idCurso));
                fase.setIdModulo(rs.getInt(idModulo));
                fase.setIdModalidade(rs.getInt(idModalidade));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return fase;
    }
    
    //Lista com todas as fases
    public ArrayList<Fase> getFases(){
        conn = null;
        pstm = null;
        rs = null;
        ArrayList<Fase> fases = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETFASES);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Fase fase = new Fase();
                
                fase.setCodigo(rs.getString(codigo));
                fase.setNome(rs.getString(nome));
                fase.setAbreviatura(rs.getString(abreviatura));
                fase.setDescricao(rs.getString(descricao));
                fase.setCodigoGrade(rs.getString(codigoGrade));
                fase.setIdCurso(rs.getInt(idCurso));
                fase.setIdModulo(rs.getInt(idModulo));
                fase.setIdModalidade(rs.getInt(idModalidade));
                
                fases.add(fase);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return fases;
    }
    
    //Lista com todas as fases By Codigo Grade and ID Curso
    public ArrayList<Fase> getFasesByCodGradeANDidCurso(String codGrade, int idcurso){
        conn = null;
        pstm = null;
        rs = null;
        ArrayList<Fase> fases = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETFasesByCodGradeANDidCurso);
            pstm.setString(1, codGrade);
            pstm.setInt(2, idcurso);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Fase fase = new Fase();
                
                fase.setCodigo(rs.getString(codigo));
                fase.setNome(rs.getString(nome));
                fase.setAbreviatura(rs.getString(abreviatura));
                fase.setDescricao(rs.getString(descricao));
                fase.setCodigoGrade(rs.getString(codigoGrade));
                fase.setIdCurso(rs.getInt(idCurso));
                fase.setIdModulo(rs.getInt(idModulo));
                fase.setIdModalidade(rs.getInt(idModalidade));
                
                fases.add(fase);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return fases;
    }
}
