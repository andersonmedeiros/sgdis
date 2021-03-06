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
import model.bean.Estado;
import model.bean.ForcaHasEstado;

/**
 *
 * @author anderson
 */
public class ForcaHasEstadoDAO {
    //Tabela
    String tabela = "Forca_has_Estado";
    
    //Atributos
    String idForca = "idForca";
    String idEstado = "idEstado";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + idForca + "," + idEstado + ")" +
                                  " VALUES(?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + idForca + "=? AND "+ idEstado +"=?;";
    
    //Consultas SQL
    
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(ForcaHasEstado forcaestado) {
        if (forcaestado != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, forcaestado.getIdForca());
                pstm.setInt(2, forcaestado.getIdEstado());
                                                              
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
    public void delete(int idForca, int idEstado) {
        if (idForca != 0 && idEstado != 0) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(DELETE);
                pstm.setInt(1, idForca);
                pstm.setInt(2, idEstado);
            
                pstm.execute();
                ConnectionFactory.fechaConexao(conn, pstm);

            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());  
            }
        } else {            
            throw new RuntimeException();
        }
    }
    
    private final static String GETESTADOSBYFORCA = "SELECT e.* " +
                                                    "FROM Forca_has_Estado AS f_e " +
                                                    "INNER JOIN Forca AS f ON f.id = f_e.idForca " +
                                                    "INNER JOIN Estado AS e ON e.id = f_e.idEstado " +
                                                    "WHERE f.id = ?;";
    
    public static ArrayList<Estado> getEstadosByForcaDWR(int idForca){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Estado> estados = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETESTADOSBYFORCA);
            pstm.setInt(1, idForca);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Estado estado = new Estado();
                
                estado.setId(rs.getInt("e.id"));
                estado.setNome(rs.getString("e.nome"));
                estado.setSigla(rs.getString("e.sigla"));
                
                estados.add(estado);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return estados;
    }
}
