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
import model.bean.Comandante;
import model.bean.Endereco;
import model.bean.Forca;
import model.bean.Om;

/**
 *
 * @author anderson
 */
public class OmDAO {
    //Tabela
    String tabela = "Estado";
    
    //Atributos
    String id = "id";
    String nome = "nome";
    String abreviatura = "abreviatura";
    String numendereco = "numendereco";
    String idForca = "idForca";
    String idEstado = "idEstado";
    String idEndereco = "idEndereco";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + nome + "," + abreviatura + "," + numendereco + "," + idForca + "," + idEstado + "," + idEndereco + ") " +
                                  "VALUES(?,?,?,?,?,?,?);";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    private final static String GETOMBYFORCAANDESTADO = "SELECT * " +
                                                        "FROM OM " +
                                                        "WHERE idForca = ? AND idEstado = ? " + 
                                                        "ORDER BY nome";
    
    public static ArrayList<Om> getOmsByForcaAndEstadoDWR(int idForca, int idEstado){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Om> oms = new ArrayList<>();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETOMBYFORCAANDESTADO);
            pstm.setInt(1, idForca);
            pstm.setInt(2, idEstado);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
               Om om = new Om();
               
               om.setId(rs.getInt("id"));
               om.setNome(rs.getString("nome"));
               om.setAbreviatura(rs.getString("abreviatura"));
               om.setNumendereco(rs.getString("numendereco"));
               om.setIdForca(rs.getInt("idForca"));
               om.setIdEstadoCidadeEndereco(rs.getInt("idEstado"));
               om.setIdEndereco(rs.getInt("idEndereco"));
                
               oms.add(om);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return oms;
    }
    
    private final static String GETOMSREGIAONORTE = "SELECT om.* " +
                                                    "FROM OM AS om " +
                                                    "INNER JOIN Estado as e on om.idEstado = e.id " +
                                                    "INNER JOIN Regiao as r on e.idRegiao = r.id " +
                                                    "WHERE om.idForca = ? AND r.id = 1 " + 
                                                    "ORDER BY om.nome";
    
    public static ArrayList<Om> getOmsRegiaoNorteDWR(int idForca){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Om> oms = new ArrayList<>();        
        ForcaDAO forcaDAO = new ForcaDAO();
        EnderecoDAO endDAO = new EnderecoDAO();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETOMSREGIAONORTE);
            pstm.setInt(1, idForca);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
               Forca forca = forcaDAO.getForcaById(rs.getInt("om.idForca"));
               Endereco end = endDAO.getEnderecoById(rs.getInt("om.idEndereco"));
               Om om = new Om();
               
               om.setId(rs.getInt("om.id"));
               om.setNome(rs.getString("om.nome"));
               om.setAbreviatura(rs.getString("om.abreviatura"));
               om.setNumendereco(rs.getString("om.numendereco"));
               
               om.setIdForca(forca.getId());
               om.setNomeForca(forca.getNome());
               om.setSiglaForca(forca.getSigla());
               
               om.setIdEndereco(end.getId());
               om.setCepEndereco(end.getCep());
               om.setDescricaoEndereco(end.getDescricao());
               om.setComplementoEndereco(end.getComplemento());
               om.setPontoreferenciaEndereco(end.getPontoreferencia());
               om.setBairroEndereco(end.getBairro());
               om.setIdCidadeEndereco(end.getIdCidade());
               om.setNomeCidadeEndereco(end.getNomeCidade());
               om.setIdEstadoCidadeEndereco(end.getIdEstadoCidade());
               om.setNomeEstadoCidadeEndereco(end.getNomeEstadoCidade());
               om.setSiglaEstadoCidadeEndereco(end.getSiglaEstadoCidade());
                
               oms.add(om);
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return oms;
    }
    
    private final static String GETOMBYID = "SELECT * " +
                                            "FROM OM " +
                                            "WHERE id = ?;";
    
    public static Om getOmByIdDWR(int idOM){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Om om = new Om();
        ForcaDAO forcaDAO = new ForcaDAO();
        EnderecoDAO endDAO = new EnderecoDAO();
        
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETOMBYID);
            pstm.setInt(1, idOM);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
               Forca forca = forcaDAO.getForcaById(rs.getInt("idForca"));
               Endereco end = endDAO.getEnderecoById(rs.getInt("idEndereco"));
               
               om.setId(rs.getInt("id"));
               om.setNome(rs.getString("nome"));
               om.setAbreviatura(rs.getString("abreviatura"));
               om.setNumendereco(rs.getString("numendereco"));
               
               om.setIdForca(forca.getId());
               om.setNomeForca(forca.getNome());
               om.setSiglaForca(forca.getSigla());
               
               om.setIdEndereco(end.getId());
               om.setCepEndereco(end.getCep());
               om.setDescricaoEndereco(end.getDescricao());
               om.setComplementoEndereco(end.getComplemento());
               om.setPontoreferenciaEndereco(end.getPontoreferencia());
               om.setBairroEndereco(end.getBairro());
               om.setIdCidadeEndereco(end.getIdCidade());
               om.setNomeCidadeEndereco(end.getNomeCidade());
               om.setIdEstadoCidadeEndereco(end.getIdEstadoCidade());
               om.setNomeEstadoCidadeEndereco(end.getNomeEstadoCidade());
               om.setSiglaEstadoCidadeEndereco(end.getSiglaEstadoCidade());
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return om;
    }
}
