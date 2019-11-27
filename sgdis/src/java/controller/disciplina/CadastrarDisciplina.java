/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.disciplina;

import bean.Disciplina;
import dao.DisciplinaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andersondepaula
 */
public class CadastrarDisciplina extends HttpServlet {

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
            out.println("<title>Servlet CadastrarDisciplina</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastrarDisciplina at " + request.getContextPath() + "</h1>");
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
        request.setCharacterEncoding("UTF-8");
        HttpSession sessao = request.getSession();
        String codigoGrade = request.getParameter("txtCodGrade");
        int idCurso = Integer.parseInt(request.getParameter("txtIdCurso").toUpperCase());
        if(sessao.getAttribute("militarAutenticado") != null){
            try{
                DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

                String nome = request.getParameter("txtNomeCad").toUpperCase();
                String abreviatura = request.getParameter("txtAbreviaturaCad").toUpperCase();
                String codigoFase = request.getParameter("txtFaseCad").toUpperCase();
                
                int variacao = disciplinaDAO.proxVariacao(codigoFase);
                //Formulação do código
                String divisor_codigo = "_";
                String codigo = codigoFase + divisor_codigo + variacao;

                Disciplina disciplina = new Disciplina();

                disciplina.setCodigo(codigo);
                disciplina.setNome(nome);
                disciplina.setAbreviatura(abreviatura);
                disciplina.setCodigoFase(codigoFase);

                disciplinaDAO.insert(disciplina);
            }catch(Exception ex){
                //e=2: erro durante realização do cadastro
                response.sendRedirect("/sgdis/restrito/montarGradeCurricular.jsp?idCurso="+idCurso+"&codGrade="+codigoGrade+"&ed=2");
                throw new ServletException(ex);
            }
            //e=1: cadastro sucesso
            response.sendRedirect("/sgdis/restrito/montarGradeCurricular.jsp?idCurso="+idCurso+"&codGrade="+codigoGrade+"&ed=1");
            /*RequestDispatcher despachante = getServletContext().getRequestDispatcher("/restrito/cadastroCurso.jsp?e=1");
            despachante.forward(request, response);*/
        }
        else{
            //e=4: Sessão Encerrada
            response.sendRedirect("/sgdis/index.jsp?e=4");
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
