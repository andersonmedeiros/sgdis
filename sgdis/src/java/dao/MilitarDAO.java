/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Militar;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andersondepaula
 */
public class MilitarDAO {
    //Tabela
    String tabela = "Militar";
    
    //Atributos
    String identidade = "mil_identidade";
    String senha = "mil_senha";
    
    //Consultas SQL
    private final String GETIDTSENHA = "SELECT " + identidade + "," + senha + " FROM " + tabela + " WHERE " + identidade + "=? AND " + senha + "=md5(?)";
    private final String GETSENHA = "SELECT " + senha + " FROM " + tabela + " WHERE " + senha + "=md5(?)";
    private final String GETIDENTIDADE = "SELECT "+ identidade + " FROM "+ tabela + " WHERE " + identidade + "=?";
    private final String GETMILITAR = "SELECT * FROM " + tabela + " WHERE " + identidade + "=?";
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    
    //Validação de Login(Identidade) e senha
    public boolean validarLoginSenha(String identidade, String senha) {
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETIDTSENHA);
            pstm.setString(1, identidade);
            pstm.setString(2, senha);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());            
        }
        return false;
    }
    
    //Validação de Login(Identidade)
    public boolean validarLogin(String identidade) {       
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETIDENTIDADE);
            pstm.setString(1, identidade);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());            
        }
        return false;
    }
    
    //Validação de Senha
    public boolean validarSenha(String senha) {
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(GETSENHA);
            
            pstm.setString(1, senha);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());            
        }
        return false;
    }
    
    //Recupera os dodos do militar que está logando
    public Militar autenticacao(Militar mil){
        Militar milRetorno = null;
        if(mil != null){
            conn = null;
            try{
                conn = ConnectionFactory.getConnection();
                pstm = conn.prepareStatement(GETMILITAR);
                pstm.setString(1, mil.getIdentidade());
                
                ResultSet rs = pstm.executeQuery();
                
                if(rs.next()){
                    milRetorno = new Militar();
                    
                    milRetorno.setId(rs.getInt("mil_id"));
                    milRetorno.setIdentidade(rs.getString("mil_identidade"));
                    milRetorno.setNome(rs.getString("mil_nome"));
                    milRetorno.setNome_guerra(rs.getString("mil_nome_guerra"));
                    milRetorno.setCpf(rs.getString("mil_cpf"));
                    milRetorno.setPreccp(rs.getString("mil_preccp"));
                    milRetorno.setSexo(rs.getString("mil_sexo"));
                    milRetorno.setData_nasc(rs.getString("mil_data_nasc")); 
                    milRetorno.setData_praca(rs.getString("mil_data_praca"));
                    milRetorno.setPai(rs.getString("mil_pai"));
                    milRetorno.setMae(rs.getString("mil_mae"));
                    milRetorno.setEmail(rs.getString("mil_email"));
                    milRetorno.setNome_referencia(rs.getString("mil_nome_referencia"));
                    milRetorno.setFone_referencia(rs.getString("mil_fone_referencia"));
                    milRetorno.setFone1(rs.getString("mil_fone1"));
                    milRetorno.setFone2(rs.getString("mil_fone2"));
                    milRetorno.setId_nat_est(rs.getInt("mil_naturalidade_estado"));
                    milRetorno.setNat_cid(rs.getString("mil_naturalidade_cidade"));
                    milRetorno.setEnd_num(rs.getString("mil_end_num"));
                    milRetorno.setSenha(rs.getString("mil_senha"));
                    milRetorno.setId_end(rs.getInt("mil_end_id"));
                    milRetorno.setId_div_sec(rs.getInt("mil_divisaoSecao_id"));
                    milRetorno.setId_pg(rs.getInt("mil_postograduacao_id"));
                    milRetorno.setId_qq(rs.getInt("mil_qasqms_id"));
                    milRetorno.setId_ec(rs.getInt("mil_estadocivil_id"));
                    milRetorno.setId_esc(rs.getInt("mil_escolaridade_id"));
                    milRetorno.setId_sit(rs.getInt("mil_situacao_id"));
                    milRetorno.setId_teleitor(rs.getInt("mil_tituloeleitor_id"));
                    milRetorno.setId_grp_acesso(rs.getInt("mil_grupoacesso_id"));
                    milRetorno.setId_grp_acesso_sgdis(rs.getInt("mil_grpacesso_sgdis_id"));
                    milRetorno.setId_religiao(rs.getInt("mil_religiao_id"));
                }
                
                ConnectionFactory.fechaConexao(conn, pstm, rs);
            }catch(SQLException e){
                throw new RuntimeException("Erro: " + e.getMessage());
            }
        }
        return milRetorno;
    }
}
