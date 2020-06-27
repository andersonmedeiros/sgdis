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
import model.bean.Cidade;
import model.bean.Endereco;

/**
 *
 * @author anderson
 */
public class EnderecoDAO {
    //Tabela
    String tabela = "Endereco";
    
    //Atributos
    String id = "id";
    String cep = "cep";
    String descricao = "descricao";
    String complemento = "complemento";
    String pontoreferencia = "pontoreferencia";
    String bairro = "bairro";
    String idCidade = "idCidade";
    
    //Insert SQL
    private final String INSERT = "INSERT INTO " + tabela + "(" + id + "," + cep + "," + descricao + "," + complemento + "," + pontoreferencia + "," + bairro + "," + idCidade + ")" +
                                  " VALUES(?,?,?,?,?,?,?);";
    
    //Update SQL
    private final String UPDATE = "UPDATE " + tabela +
                                  " SET " + cep + "=?, " + descricao + "=?, " + complemento + "=?, " + pontoreferencia + "=?, " + bairro + "=?, " + idCidade + "=?, " +
                                  "WHERE " + id + "=?;";
        
    //Delete SQL
    private final String DELETE = "DELETE FROM " + tabela + " WHERE " + id + "=?;";
    
    //Consultas SQL
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    
    //Insert SQL
    public void insert(Endereco end) {
        if (end != null) {
            try {
                conn = ConnectionFactory.getConnection();
                
                pstm = conn.prepareStatement(INSERT);
                
                pstm.setInt(1, end.getId());
                pstm.setString(2, end.getCep());
                pstm.setString(3, end.getDescricao());
                pstm.setString(4, end.getComplemento());
                pstm.setString(5, end.getPontoreferencia());
                pstm.setString(6, end.getBairro());
                pstm.setInt(7, end.getIdCidade());
                
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
    public void update(Endereco end) {
        if (end != null) {
            try {
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(UPDATE);
                
                pstm.setString(1, end.getCep());
                pstm.setString(2, end.getDescricao());
                pstm.setString(3, end.getComplemento());
                pstm.setString(4, end.getPontoreferencia());
                pstm.setString(5, end.getBairro());
                pstm.setInt(6, end.getIdCidade());
                pstm.setInt(7, end.getId());
            
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
    
    private final String GETENDERECO = "SELECT * " +
                                       "FROM Endereco " + 
                                       "WHERE id = ?";
       
    public Endereco getEnderecoById(int idEndereco){
        Endereco end = new Endereco();
        CidadeDAO cidDAO = new CidadeDAO();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETENDERECO);
            pstm.setInt(1, idEndereco);
           
            rs = pstm.executeQuery();
            while (rs.next()) {
                Cidade cid = cidDAO.getCidadeById(rs.getInt("idCidade"));
                
                end.setId(rs.getInt("id"));
                end.setCep(rs.getString("cep"));
                end.setDescricao(rs.getString("descricao"));
                end.setComplemento(rs.getString("complemento"));
                end.setPontoreferencia(rs.getString("pontoreferencia"));
                end.setBairro(rs.getString("bairro"));
                
                end.setIdCidade(cid.getId());
                end.setNomeCidade(cid.getNome());
                end.setIdEstadoCidade(cid.getIdEstado());
                end.setNomeEstadoCidade(cid.getNomeEstado());
                end.setSiglaEstadoCidade(cid.getSiglaEstado());
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());           
        }
        return end;
    }
    
}
