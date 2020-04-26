/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.turma;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.Turma;
import model.dao.TurmaDAO;

/**
 *
 * @author anderson
 */
public class CadastrarTurma extends HttpServlet {

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
            out.println("<title>Servlet CadastrarTurma</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastrarTurma at " + request.getContextPath() + "</h1>");
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
                if((request.getParameter("txtAno") != null || request.getParameter("txtAno") != "") ||
                   (request.getParameter("txtDataInicio") != null || request.getParameter("txtDataInicio") != "") || 
                   (request.getParameter("txtDataFim") != null || request.getParameter("txtDataFim") != "") ||
                   (request.getParameter("txtCurso") != null || request.getParameter("txtCurso") != "") ||
                   (request.getParameter("txtCurso") != null || request.getParameter("txtCurso") != "")){                    
                    
                    int ano = Integer.parseInt(request.getParameter("txtAno"));
                    
                    String[] dataInicioSeparada = request.getParameter("txtDataInicio").split("-");
                    int anoInicio = Integer.parseInt(dataInicioSeparada[0]) - 1900;
                    int mesInicio = Integer.parseInt(dataInicioSeparada[1]) - 1;
                    int diaInicio = Integer.parseInt(dataInicioSeparada[2]);
                    Date dataInicio = new Date(anoInicio, mesInicio, diaInicio);
                    
                    String[] dataFimSeparada = request.getParameter("txtDataFim").split("-");
                    int anoFim = Integer.parseInt(dataFimSeparada[0]) - 1900;
                    int mesFim = Integer.parseInt(dataFimSeparada[1]) - 1;
                    int diaFim = Integer.parseInt(dataFimSeparada[2]);
                    Date dataFim= new Date(anoFim, mesFim, diaFim);                    
                   
                    int idCurso = Integer.parseInt(request.getParameter("txtCurso"));
                    int idCategoria = Integer.parseInt(request.getParameter("txtCategoria"));                    
                    
                    TurmaDAO turmaDAO = new TurmaDAO();
                    int idTurma = turmaDAO.proxID();
                    int nTurma = turmaDAO.proxnTurma(idCurso, ano);
                    
                    boolean existeTurma = turmaDAO.getExisteTurma(idCurso, idCategoria, dataInicio, dataFim);
                    
                    if(existeTurma == false){
                        Turma turma = new Turma();                    
                        turma.setId(idTurma);
                        turma.setAno(ano);
                        turma.setnTurma(nTurma);
                        turma.setDataInicio(dataInicio);
                        turma.setDataFim(dataFim);
                        turma.setIdCurso(idCurso);
                        turma.setIdCategoria(idCategoria);

                        turmaDAO.insert(turma);
                    }
                    else{
                        //e=7: erro turma já existe
                        response.sendRedirect("/sgdis/restrito/turma/turma.jsp?e=7");
                    }
                }
                else{
                    //e=2: erro durante realização do cadastro
                    response.sendRedirect("/sgdis/restrito/turma/turma.jsp?e=2");
                }
            }catch(Exception ex){
                //e=2: erro durante realização do cadastro
                response.sendRedirect("/sgdis/restrito/turma/turma.jsp?e=2");
                throw new ServletException(ex);
            }
            //e=1: cadastro sucesso
            response.sendRedirect("/sgdis/restrito/turma/turma.jsp?e=1");
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
