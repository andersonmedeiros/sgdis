/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.curso;

import bean.Curso;
import dao.CursoDAO;
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
public class Atualizar extends HttpServlet {

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
            out.println("<title>Servlet Atualizar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Atualizar at " + request.getContextPath() + "</h1>");
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
        
        if(sessao.getAttribute("militarAutenticado") != null){
            try{
            CursoDAO cursoDAO = new CursoDAO();

            int id = Integer.parseInt(request.getParameter("txtIdAtt").toUpperCase());
            String nome = request.getParameter("txtNomeAtt").toUpperCase();
            String sigla = request.getParameter("txtSiglaAtt").toUpperCase();
            String categoria = request.getParameter("txtCategoriaAtt").toUpperCase();
            String portaria = request.getParameter("txtPortariaAtt").toUpperCase();
            String descricao = request.getParameter("txtDescricaoAtt").toUpperCase();

            Curso curso = new Curso();
            curso.setId(id);
            curso.setNome(nome);
            curso.setSigla(sigla);
            curso.setCategoria(categoria);
            curso.setPortaria(portaria);
            curso.setDescricao(descricao);
            
            cursoDAO.update(curso);
            }catch(Exception ex){
                //e=5: erro durante atualização do cadastro
                response.sendRedirect("/sgdis/restrito/curso.jsp?e=5");
                throw new ServletException(ex);
            }
            //e=6: atualização sucesso
            response.sendRedirect("/sgdis/restrito/curso.jsp?e=6");
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
