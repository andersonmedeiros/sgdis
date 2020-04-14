/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Categoria;
import bean.CursoHasCategoria;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anderson
 */
public class CursoHasCategoriaDAO {
    //Tabela
    String tabela = "Curso_has_Categoria";
    
    //Atributos
    String idCurso = "idCurso";
    String idCategoria = "idCategoria";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + idCurso + "," + idCategoria + ")" +
                                  " VALUES(?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + idCurso + "=? AND "+ idCategoria +"=?;";
    
    //Consultas SQL
    private final String GETCategoriasByCurso = "SELECT idCategoria FROM " + tabela + " WHERE " + idCurso + "=?;";
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(CursoHasCategoria cursoCategoria) {
        if (cursoCategoria != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, cursoCategoria.getIdCurso());
                pstm.setInt(2, cursoCategoria.getIdCategoria());
                                                              
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
    public void delete(int idCurso, int idCategoria) {
        if (idCurso != 0 && idCategoria != 0) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setInt(1, idCurso);
                pstm.setInt(2, idCategoria);
            
                pstm.execute();
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {            
            throw new RuntimeException();
        }
    }
      
    //Lista com todas as categorias por curso
    public ArrayList<Integer> getCategoriasByCurso(int idCurso){
        conn = null;
        pstm = null;
        rs = null;
        ArrayList<Integer> categorias = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCategoriasByCurso);
            pstm.setInt(1, idCurso);
           
            rs = pstm.executeQuery();
            while (rs.next()) {                
                categorias.add(rs.getInt("idCategoria"));
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return categorias;
    }
}
