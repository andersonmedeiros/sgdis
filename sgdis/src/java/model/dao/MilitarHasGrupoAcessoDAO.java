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
import model.bean.GrupoAcesso;
import model.bean.MilitarHasGrupoAcesso;

/**
 *
 * @author anderson
 */
public class MilitarHasGrupoAcessoDAO {
    //Tabela
    String tabela = "Militar_has_GrupoAcesso";
    
    //Atributos
    String idtMilitar = "idtMilitar";
    String idGrupoAcesso = "idGrupoAcesso";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + idtMilitar + "," + idGrupoAcesso + ")" +
                                  " VALUES(?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + idtMilitar + "=? AND " + idGrupoAcesso + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(MilitarHasGrupoAcesso milgrpacesso) {
        if (milgrpacesso != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setString(1, milgrpacesso.getIdentidadeMilitar());
                pstm.setInt(2, milgrpacesso.getIdGrpAcesso());
                                                              
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
    public void delete(String idtMilitar, int idGrpAcesso) {
        if (idtMilitar != null && idGrpAcesso != 0){
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setString(1, idtMilitar);
                pstm.setInt(2, idGrpAcesso);
            
                pstm.execute();
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {            
            throw new RuntimeException();
        }
    }
    
    private final String GETGRPSACESSOBYIDTMILITAR = "SELECT idGrupoAcesso " +
                                                     "FROM " + tabela + " " +
                                                     "WHERE idtMilitar = ?";
       
    public ArrayList<GrupoAcesso> getGruposAcesso(String idtMilitar){
        ArrayList<GrupoAcesso> grpsacesso = new ArrayList<>();  
        GrupoAcessoDAO grpacessoDAO = new GrupoAcessoDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETGRPSACESSOBYIDTMILITAR);
            pstm.setString(1, idtMilitar);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                GrupoAcesso grpacesso = grpacessoDAO.getGrupoAcessoById(rs.getInt("idGrupoAcesso"));
                
                grpsacesso.add(grpacesso);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return grpsacesso;
    }
}
