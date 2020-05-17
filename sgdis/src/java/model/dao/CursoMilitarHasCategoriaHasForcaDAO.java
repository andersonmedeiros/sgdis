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
import model.bean.CursoMilitar;
import model.bean.CursoMilitarHasCategoriaHasForca;

/**
 *
 * @author anderson
 */
public class CursoMilitarHasCategoriaHasForcaDAO {
    //Tabela
    String tabela = "CursoMilitar_has_Categoria_has_Forca";
    
    //Atributos
    String idCurso = "idCursoMilitar";
    String idCategoria = "idCategoria";
    String idForca = "idForca";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + idCurso + "," + idCategoria + "," + idForca + ")" +
                                  " VALUES(?,?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + idCurso + "=? AND "+ idCategoria +"=? AND "+ idForca +"=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(CursoMilitarHasCategoriaHasForca cursomilitarCategoriaForca) {
        if (cursomilitarCategoriaForca != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, cursomilitarCategoriaForca.getIdCursoMilitar());
                pstm.setInt(2, cursomilitarCategoriaForca.getIdCategoria());
                pstm.setInt(3, cursomilitarCategoriaForca.getIdForca());
                                                              
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
    public void delete(int idCursoMilitar, int idCategoria, int idForca) {
        if (idCursoMilitar != 0 && idCategoria != 0 && idForca != 0) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setInt(1, idCursoMilitar);
                pstm.setInt(2, idCategoria);
                pstm.setInt(3, idForca);
            
                pstm.execute();
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {            
            throw new RuntimeException();
        }
    }
    
    private final static String GETCURSOSMILITARESSBYTIPOANDFORCAANDCATEGORIADWR = "SELECT cm.* " +
                                                                                   "FROM CursoMilitar_has_Categoria_has_Forca AS cm_cat_f " +
                                                                                   "INNER JOIN CursoMilitar AS cm ON cm.id = cm_cat_f.idCursoMilitar " +
                                                                                   "INNER JOIN Categoria AS cat ON cat.id = cm_cat_f.idCategoria " +
                                                                                   "INNER JOIN Forca AS f ON f.id = cm_cat_f.idForca " +
                                                                                   "WHERE cm.tipo = ? AND cat.id = ? AND f.id = ?;";
    
    public static ArrayList<CursoMilitar> getCursosMilitaresByTipoAndCategoriaAndForcaDWR(int tipo, int idCategoria, int idForca){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        ArrayList<CursoMilitar> cursosmilitares = new ArrayList<>();
        
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETCURSOSMILITARESSBYTIPOANDFORCAANDCATEGORIADWR);
            pstm.setInt(1, tipo);
            pstm.setInt(2, idCategoria);
            pstm.setInt(3, idForca);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                CursoMilitar cursomilitar = new CursoMilitar();
                
                cursomilitar.setId(rs.getInt("cm.id"));
                cursomilitar.setNome(rs.getString("cm.nome"));
                cursomilitar.setTipo(rs.getInt("cm.tipo"));
                
                cursosmilitares.add(cursomilitar);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return cursosmilitares;
    }
}
