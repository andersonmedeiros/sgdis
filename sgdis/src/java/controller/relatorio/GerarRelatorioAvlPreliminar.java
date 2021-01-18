/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.relatorio;

import connection.ConnectionFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.GeradorDeRelatorios;

/**
 *
 * @author anderson
 */
public class GerarRelatorioAvlPreliminar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GeradorRelatorio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GeradorRelatorio at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if((request.getParameter("txtTurma")!=null) && (request.getParameter("txtAvaliacao")!=null)){
            ServletContext contexto = getServletContext();

            // abre conexão com o banco
            Connection conexao = new ConnectionFactory().getConnection();
            // gera relatório
            GeradorDeRelatorios gerador = new GeradorDeRelatorios(conexao);
            
            int idTurma = Integer.parseInt(request.getParameter("txtTurma"));
            int avl = Integer.parseInt(request.getParameter("txtAvaliacao"));
            
            switch(avl){
                case 1:
                    {
                        Map<String, Object> parametros = new HashMap<>();
                        String sql_query = "SELECT c.nome curso, c.sigla siglaCurso, cat.nome nomeCategoria, t.ano anoTurma, t.turma turma,  " +
                                            "alu.identidade idtAlu, pgAlu.abreviatura pGradAlu, alu.nome nomeAlu, alu.sobrenome sobrenomeAlu, " +
                                            "alu.nomeguerra guerraAlu, IF(avlpsico.situacao=1, \"APTO\", IF(avlpsico.situacao=2, \"INDICADO COM RESTRIÇÃO\", IF(avlpsico.situacao=3, \"INAPTO\", \"-\"))) sitpsico, " +
                                            "IF(avlpsico.rto=\"\", \"-\", IF(avlpsico.rto IS NULL, \"-\", avlpsico.rto)) rto, mil.nomeguerra guerraAva, pgAva.abreviatura pGradAva " +
                                            "FROM AvlPsico avlpsico " +
                                            "INNER JOIN Aluno alu on avlpsico.idtAluno = alu.identidade " +
                                            "INNER JOIN PostoGraduacao pgAlu on alu.idPostoGraduacao = pgAlu.id " +
                                            "INNER JOIN Militar mil on avlpsico.idtMilitarAvaliador = mil.identidade " +
                                            "INNER JOIN PostoGraduacao pgAva on mil.idPostoGraduacao = pgAva.id " +
                                            "INNER JOIN Turma t on avlpsico.idTurma = t.id " +
                                            "INNER JOIN Curso c on t.idCurso = c.id " +
                                            "INNER JOIN Categoria cat on t.idCategoria = cat.id " +
                                            "WHERE t.id = " + idTurma;
                        String jrxml = contexto.getRealPath("/relatorio/avlpreliminar/relatorio_avlpsico.jrxml");
                        gerador.geraPdf(jrxml, parametros, response.getOutputStream(), sql_query);
                        break;
                    }
                case 2:
                    {
                        Map<String, Object> parametros = new HashMap<>();
                        String sql_query = "SELECT c.nome curso, c.sigla siglaCurso, cat.nome nomeCategoria, t.ano anoTurma, t.turma turma, " +
                                            "alu.identidade idtAlu, pgAlu.abreviatura pGradAlu, alu.nome nomeAlu, alu.sobrenome sobrenomeAlu, " +
                                            "alu.nomeguerra guerraAlu, IF(inspSau.situacao=1, \"APTO\", \"INAPTO\") sitSau, mil.nomeguerra guerraAva, pgAva.abreviatura pGradAva " +
                                            "FROM InspecaoSaude inspSau " +
                                            "INNER JOIN Aluno alu on inspSau.idtAluno = alu.identidade " +
                                            "INNER JOIN PostoGraduacao pgAlu on alu.idPostoGraduacao = pgAlu.id " +
                                            "INNER JOIN Militar mil on inspSau.idtMilitarAvaliador = mil.identidade " +
                                            "INNER JOIN PostoGraduacao pgAva on mil.idPostoGraduacao = pgAva.id " +
                                            "INNER JOIN Turma t on inspSau.idTurma = t.id " +
                                            "INNER JOIN Curso c on t.idCurso = c.id " +
                                            "INNER JOIN Categoria cat on t.idCategoria = cat.id " +
                                            "WHERE t.id = " + idTurma;
                        String jrxml = contexto.getRealPath("/relatorio/avlpreliminar/relatorio_inspsau.jrxml");
                        gerador.geraPdf(jrxml, parametros, response.getOutputStream(), sql_query);
                        break;
                    }
                case 3:
                    {
                        Map<String, Object> parametros = new HashMap<>();
                        String sql_query = "SELECT c.nome curso, c.sigla siglaCurso, cat.nome nomeCategoria, t.ano anoTurma, t.turma turma, " +
                                            "alu.identidade idtAlu, pgAlu.abreviatura pGradAlu, alu.nome nomeAlu, alu.sobrenome sobrenomeAlu, alu.nomeguerra guerraAlu, " +
                                            "TCM.tcmt, TCM.tcmp, IF(TCM.situacao=1, \"APTO\", IF(TCM.situacao=2,\"INAPTO\", \"-\")) sitTCM, mil.nomeguerra guerraAva, pgAva.abreviatura pGradAva " +
                                            "FROM TCM " +
                                            "INNER JOIN Aluno alu on TCM.idtAluno = alu.identidade " +
                                            "INNER JOIN PostoGraduacao pgAlu on alu.idPostoGraduacao = pgAlu.id " +
                                            "INNER JOIN Militar mil on TCM.idtMilitarAvaliador = mil.identidade " +
                                            "INNER JOIN PostoGraduacao pgAva on mil.idPostoGraduacao = pgAva.id " +
                                            "INNER JOIN Turma t on TCM.idTurma = t.id " +
                                            "INNER JOIN Curso c on t.idCurso = c.id " +
                                            "INNER JOIN Categoria cat on t.idCategoria = cat.id " +
                                            "WHERE t.id = " + idTurma;
                        String jrxml = contexto.getRealPath("/relatorio/avlpreliminar/relatorio_tcm.jrxml");
                        gerador.geraPdf(jrxml, parametros, response.getOutputStream(), sql_query);
                        break;
                    }
                case 4:
                    {
                        Map<String, Object> parametros = new HashMap<>();
                        String sql_query = "SELECT c.nome curso, c.sigla siglaCurso, cat.nome nomeCategoria, t.ano anoTurma, t.turma turma, " +
                                            "alu.identidade idtAlu, pgAlu.abreviatura pGradAlu, alu.nome nomeAlu, alu.sobrenome sobrenomeAlu, alu.nomeguerra guerraAlu, " +
                                            "eaf.corrida corridaEAF,  " +
                                            "IFNULL(eaf.flexaobarra, \"-\") fbarraEAF,  " +
                                            "IFNULL(eaf.suspensaobarra, \"-\") sbarraEAF,  " +
                                            "eaf.abdominal abdEAF, eaf.flexaobraco fbracoEAF,  " +
                                            "IF(eaf.nadoSubmerso=1, \"APTO\", IF(eaf.nadoSubmerso=2, \"INAPTO\", \"-\")) nadoEAF, " +
                                            "IF(eaf.subidaCorda=1, \"APTO\", IF(eaf.subidaCorda=2, \"INAPTO\", \"-\")) cordaEAF,  " +
                                            "eaf.ppm ppmEAF, eaf.natacao natEAF, eaf.flutuacao flutuEAF, eaf.marcha15km marchaEAF, " +
                                            "IF(eaf.situacao=1, \"APTO\", IF(eaf.situacao=2,\"INAPTO\", \"2ª TENTATIVA\")) sitEAF, " +
                                            "pgAvaEAF.abreviatura pGradAvaEAF, milEAF.nomeguerra guerraAvaEAF,  " +
                                            "IFNULL(rec.corrida, \"-\") corridaREC,  " +
                                            "IF(rec.flexaobarra=0, \"-\", IF(rec.flexaobarra IS NULL,\"-\",rec.flexaobarra)) fbarraREC,  " +
                                            "IFNULL(rec.suspensaobarra, \"-\") sbarraREC, " +
                                            "IF(rec.abdominal=0, \"-\", IF(rec.abdominal IS NULL,\"-\",rec.abdominal)) abdREC,  " +
                                            "IF(rec.flexaobraco=0, \"-\", IF(rec.flexaobraco IS NULL,\"-\",rec.flexaobraco)) fbracoREC,  " +
                                            "IF(rec.nadoSubmerso=0, \"-\", IF(rec.nadoSubmerso IS NULL, \"-\", IF(rec.nadoSubmerso=1, \"APTO\", IF(rec.nadoSubmerso=2, \"INAPTO\", \"-\")))) nadoREC, " +
                                            "IF(rec.subidaCorda=0, \"-\", IF(rec.subidaCorda IS NULL, \"-\", IF(rec.subidaCorda=1, \"APTO\", IF(rec.subidaCorda=2, \"INAPTO\", \"-\")))) cordaREC, " +
                                            "IFNULL(rec.ppm, \"-\") ppmREC, " +
                                            "IFNULL(rec.natacao, \"-\") natREC, " +
                                            "IFNULL(rec.flutuacao, \"-\") flutuREC, " +
                                            "IFNULL(rec.marcha15km, \"-\") marchaREC, " +
                                            "IF(rec.situacao=1, \"APTO\", IF(rec.situacao=2,\"INAPTO\", \"-\")) sitREC, " +
                                            "IFNULL(pgAvaRecEAF.abreviatura, \"-\") pGradAvaRecEAF,  " +
                                            "IFNULL(milRecEAF.nomeguerra, \"-\") guerraAvaRecEAF " +
                                            "FROM EAF eaf " +
                                            "LEFT JOIN RecEAF rec ON rec.idtAluno = eaf.idtAluno " +
                                            "LEFT JOIN Aluno alu ON alu.identidade = eaf.idtAluno " +
                                            "LEFT JOIN PostoGraduacao pgAlu ON pgAlu.id = alu.idPostoGraduacao " +
                                            "LEFT JOIN Militar milEAF on milEAF.identidade = eaf.idtMilitarAvaliador " +
                                            "LEFT JOIN PostoGraduacao pgAvaEAF on pgAvaEAF.id = milEAF.idPostoGraduacao " +
                                            "LEFT JOIN Militar milRecEAF on milRecEAF.identidade = rec.idtMilitarAvaliador " +
                                            "LEFT JOIN PostoGraduacao pgAvaRecEAF on pgAvaRecEAF.id = milRecEAF.idPostoGraduacao " +
                                            "LEFT JOIN Turma t on eaf.idTurma = t.id " +
                                            "LEFT JOIN Curso c on t.idCurso = c.id " +
                                            "LEFT JOIN Categoria cat on t.idCategoria = cat.id " +
                                            "WHERE t.id = " + idTurma;
                        String jrxml = contexto.getRealPath("/relatorio/avlpreliminar/relatorio_eaf.jrxml");
                        gerador.geraPdf(jrxml, parametros, response.getOutputStream(), sql_query);
                        break;
                    }
                default:
                    break;
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
