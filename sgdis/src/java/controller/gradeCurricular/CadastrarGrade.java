/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.gradeCurricular;

import bean.Categoria;
import bean.GradeCurricular;
import dao.CategoriaDAO;
import dao.GradeCurricularDAO;
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
public class CadastrarGrade extends HttpServlet {

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
            out.println("<title>Servlet CadastrarGrade</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastrarGrade at " + request.getContextPath() + "</h1>");
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
        int idCurso = Integer.parseInt(request.getParameter("txtIdCursoGrade").toUpperCase());
        if(sessao.getAttribute("militarAutenticado") != null){            
            try{
                GradeCurricularDAO gradeDAO = new GradeCurricularDAO();
                
                
                String siglaCurso = request.getParameter("txtSiglaGrade").toUpperCase();
                int idCatCurso = Integer.parseInt(request.getParameter("txtCategoriaGrade").toUpperCase());
                String descricao = request.getParameter("txtDescricaoGrade").toUpperCase();
                int ano = Integer.parseInt(request.getParameter("txtAnoGrade").toUpperCase());
                //int variacao = Integer.parseInt(request.getParameter("txtVariacaoGrade").toUpperCase());
                int variacao = gradeDAO.proxVariacao(idCurso, ano);
                
                String divisor_codigo = "_";          
                
                //Categoria Curso
                CategoriaDAO catDAO = new CategoriaDAO();
                Categoria cat = catDAO.getCategoria(idCatCurso);              
                                
                //Grade Curricular
                GradeCurricular grade = new GradeCurricular();
                
                String codigo = siglaCurso + divisor_codigo + cat.getNome() + divisor_codigo + ano + divisor_codigo + variacao;                
                grade.setCodigo(codigo);
                grade.setDescricao(descricao);
                grade.setAno(ano);
                grade.setVariacao(variacao);
                grade.setSituacao("I");
                grade.setIdCurso(idCurso);
                                
                gradeDAO.insert(grade);
            }catch(Exception ex){
                //e=2: erro durante realização do cadastro
                response.sendRedirect("/sgdis/restrito/visualizarGradeCurricular.jsp?idCurso="+idCurso+"&e=2");
                throw new ServletException(ex);
            }
            //e=1: cadastro sucesso
            response.sendRedirect("/sgdis/restrito/visualizarGradeCurricular.jsp?idCurso="+idCurso+"&e=1");
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
