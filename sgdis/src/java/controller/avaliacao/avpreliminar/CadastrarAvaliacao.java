/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.avaliacao.avpreliminar;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.*;
import model.dao.*;

/**
 *
 * @author anderson
 */
public class CadastrarAvaliacao extends HttpServlet {

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
            out.println("<title>Servlet CadastrarAvaliacao</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastrarAvaliacao at " + request.getContextPath() + "</h1>");
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
                Militar militarLogado = (Militar) sessao.getAttribute("militarAutenticado");
                
                if(request.getParameter("txtAvlPsico") != null){
                    AvlPsicoDAO avlpsicoDAO = new AvlPsicoDAO();    

                    AvlPsico avlpsico = new AvlPsico();  
                    avlpsico.setId(avlpsicoDAO.proxID());
                    avlpsico.setSituacao(Integer.parseInt(request.getParameter("txtSitAvlPsico")));
                    avlpsico.setRto(String.valueOf(request.getParameter("txtRtoAvlPsico")));
                    avlpsico.setIdTurma(Integer.parseInt(request.getParameter("txtIdTurma")));
                    avlpsico.setIdentidadeAluno(String.valueOf(request.getParameter("txtIdentidadeAl")));
                    avlpsico.setIdentidadeMilitar(militarLogado.getIdentidade());
                
                    avlpsicoDAO.insert(avlpsico);
                }
                else if(request.getParameter("txtAvlTCM") != null){
                    TcmDAO tcmDAO = new TcmDAO();
                    
                    Tcm tcm = new Tcm();
                    tcm.setId(tcmDAO.proxID());
                    tcm.setTcmt(Float.parseFloat(request.getParameter("txtTCMT")));
                    tcm.setTcmp(Float.parseFloat(request.getParameter("txtTCMP")));
                    tcm.setIdTurma(Integer.parseInt(request.getParameter("txtIdTurmaTCM")));
                    tcm.setIdentidadeAluno(String.valueOf(request.getParameter("txtIdentidadeAlTCM")));
                    tcm.setIdentidadeMilitar(militarLogado.getIdentidade());
                    
                    System.out.println("id: " + tcm.getId());
                    System.out.println("tcmt: " + tcm.getTcmt());
                    System.out.println("tcmp: " + tcm.getTcmp());
                    System.out.println("idturma: " + tcm.getIdTurma());
                    System.out.println("idtal: " + tcm.getIdentidadeAluno());
                    System.out.println("idtmilav: " + tcm.getIdentidadeMilitar());
                    
                    tcmDAO.insert(tcm);
                    
                }
                else if(request.getParameter("txtAvlEafTent1") != null){
                    //Indices do Eaf
                    //Masculino
                    Time indiceCorridaMasc = new Time(0,40,0);
                    int indiceFlexaoBarraMasc = 10;
                    int indiceAbdSupraMasc = 68;
                    int indiceFlexaoBracoMasc = 35;
                    Time indicePpmMasc = new Time(0,4,50);
                    Time indiceNatUtlMasc = new Time(0,15,0);
                    Time indiceFlutuacaoMasc = new Time(0,10,0);
                    Time indiceMarcha15kmMasc = new Time(3,0,0);
                    
                    //Feminino
                    Time indiceCorridaFem = new Time(1,0,0);
                    Time indiceSuspensaoBarraFem = new Time(0,0,28);
                    int indiceAbdSupraFem = 59;
                    int indiceFlexaoBracoFem = 31;
                    Time indicePpmFem = new Time(0,9,0);
                    Time indiceNatUtlFem = new Time(0,20,0);
                    Time indiceFlutuacaoFem = new Time(0,6,0);
                    Time indiceMarcha15kmFem = new Time(3,30,0);
                    
                    //Quantidade de reprovação
                    int EafInaptoEm = 0;
                    int inaptoMarcha = 0;
                    
                    EafDAO eafDAO = new EafDAO();                    
                    Eaf eaf = new Eaf();
                    eaf.setId(eafDAO.proxID());
                    
                    if(request.getParameter("txtSexoEafTent1").equals("M")){                        
                        String corrida[] = request.getParameter("txtCorridaEafTent1").split(":");
                        eaf.setCorrida(new Time(Integer.parseInt(corrida[0]), Integer.parseInt(corrida[1]), Integer.parseInt(corrida[2])));
                        if(eaf.getCorrida().after(indiceCorridaMasc)){EafInaptoEm++;eaf.setSituacao(10);}
                        
                        eaf.setAbdominal(Integer.parseInt(request.getParameter("txtAbdSupraEafTent1")));
                        if(eaf.getAbdominal() < indiceAbdSupraMasc){EafInaptoEm++;eaf.setSituacao(11);}
                        
                        eaf.setFlexaoBraco(Integer.parseInt(request.getParameter("txtFlexaoBracoEafTent1")));
                        if(eaf.getFlexaoBraco() < indiceFlexaoBracoMasc){EafInaptoEm++;eaf.setSituacao(12);}
                        
                        eaf.setFlexaoBarra(Integer.parseInt(request.getParameter("txtFlexaoBarraEafTent1")));
                        if(eaf.getFlexaoBarra() < indiceFlexaoBarraMasc){EafInaptoEm++;eaf.setSituacao(13);}
                        
                        eaf.setNadoSubmerso(Integer.parseInt(request.getParameter("txtNadoSubmersoEafTent1")));
                        if(eaf.getNadoSubmerso() == 2){EafInaptoEm++;eaf.setSituacao(15);}
                        
                        eaf.setSubidaCorda(Integer.parseInt(request.getParameter("txtCordaVerticalEafTent1")));
                        if(eaf.getSubidaCorda() == 2){EafInaptoEm++;eaf.setSituacao(16);}
                        
                        String ppm[] = request.getParameter("txtPPMEafTent1").split(":");
                        eaf.setPpm(new Time(Integer.parseInt(ppm[0]), Integer.parseInt(ppm[1]), Integer.parseInt(ppm[2])));
                        if(eaf.getPpm().after(indicePpmMasc)){EafInaptoEm++;eaf.setSituacao(17);}
                        
                        String natutl[] = request.getParameter("txtNatUtlEafTent1").split(":");
                        eaf.setNatacao(new Time(Integer.parseInt(natutl[0]), Integer.parseInt(natutl[1]), Integer.parseInt(natutl[2])));
                        if(eaf.getNatacao().after(indiceNatUtlMasc)){EafInaptoEm++;eaf.setSituacao(18);}
                        
                        String flutuacao[] = request.getParameter("txtFlutuacaoEafTent1").split(":");
                        eaf.setFlutuacao(new Time(Integer.parseInt(flutuacao[0]), Integer.parseInt(flutuacao[1]), Integer.parseInt(flutuacao[2])));
                        if(eaf.getFlutuacao().before(indiceFlutuacaoMasc)){EafInaptoEm++;eaf.setSituacao(19);}
                        
                        String marcha[] = request.getParameter("txtMarchaEafTent1").split(":");
                        eaf.setMarcha15km(new Time(Integer.parseInt(marcha[0]), Integer.parseInt(marcha[1]), Integer.parseInt(marcha[2])));
                        if(eaf.getMarcha15km().after(indiceMarcha15kmMasc)){EafInaptoEm++;inaptoMarcha=1;eaf.setSituacao(20);}
                        
                        //Apto
                        if(EafInaptoEm == 0){
                            eaf.setSituacao(1);
                        }
                        //Inapto
                        else if(EafInaptoEm >= 2 || inaptoMarcha == 1){
                            eaf.setSituacao(2);
                        }
                        
                        eaf.setIdTurma(Integer.parseInt(request.getParameter("txtIdTurmaEafTent1")));
                        eaf.setIdentidadeAluno(String.valueOf(request.getParameter("txtIdentidadeAlEafTent1")));
                        eaf.setIdentidadeMilitar(militarLogado.getIdentidade());

                        eafDAO.insert(eaf);
                    }else if(request.getParameter("txtSexoEafTent1").equals("F")){
                        String corrida[] = request.getParameter("txtCorridaEafTent1").split(":");
                        eaf.setCorrida(new Time(Integer.parseInt(corrida[0]), Integer.parseInt(corrida[1]), Integer.parseInt(corrida[2])));
                        if(eaf.getCorrida().after(indiceCorridaFem)){EafInaptoEm++;eaf.setSituacao(10);}
                        
                        eaf.setAbdominal(Integer.parseInt(request.getParameter("txtAbdSupraEafTent1")));
                        if(eaf.getAbdominal() < indiceAbdSupraFem){EafInaptoEm++;eaf.setSituacao(11);}
                        
                        eaf.setFlexaoBraco(Integer.parseInt(request.getParameter("txtFlexaoBracoEafTent1")));
                        if(eaf.getFlexaoBraco() < indiceFlexaoBracoFem){EafInaptoEm++;eaf.setSituacao(12);}
                        
                        String suspbarra[] = request.getParameter("txtSuspBarraEafTent1").split(":");
                        eaf.setSuspBarra(new Time(Integer.parseInt(suspbarra[0]), Integer.parseInt(suspbarra[1]), Integer.parseInt(suspbarra[2])));
                        if(eaf.getSuspBarra().before(indiceSuspensaoBarraFem)){EafInaptoEm++;eaf.setSituacao(14);}
                        
                        eaf.setNadoSubmerso(Integer.parseInt(request.getParameter("txtNadoSubmersoEafTent1")));
                        if(eaf.getNadoSubmerso() == 2){EafInaptoEm++;eaf.setSituacao(15);}
                        
                        eaf.setSubidaCorda(Integer.parseInt(request.getParameter("txtCordaVerticalEafTent1")));
                        if(eaf.getSubidaCorda() == 2){EafInaptoEm++;eaf.setSituacao(16);}
                        
                        String ppm[] = request.getParameter("txtPPMEafTent1").split(":");
                        eaf.setPpm(new Time(Integer.parseInt(ppm[0]), Integer.parseInt(ppm[1]), Integer.parseInt(ppm[2])));
                        if(eaf.getPpm().after(indicePpmFem)){EafInaptoEm++;eaf.setSituacao(17);}
                        
                        String natutl[] = request.getParameter("txtNatUtlEafTent1").split(":");
                        eaf.setNatacao(new Time(Integer.parseInt(natutl[0]), Integer.parseInt(natutl[1]), Integer.parseInt(natutl[2])));
                        if(eaf.getNatacao().after(indiceNatUtlFem)){EafInaptoEm++;eaf.setSituacao(18);}
                        
                        String flutuacao[] = request.getParameter("txtFlutuacaoEafTent1").split(":");
                        eaf.setFlutuacao(new Time(Integer.parseInt(flutuacao[0]), Integer.parseInt(flutuacao[1]), Integer.parseInt(flutuacao[2])));
                        if(eaf.getFlutuacao().before(indiceFlutuacaoFem)){EafInaptoEm++;eaf.setSituacao(19);}
                        
                        String marcha[] = request.getParameter("txtMarchaEafTent1").split(":");
                        eaf.setMarcha15km(new Time(Integer.parseInt(marcha[0]), Integer.parseInt(marcha[1]), Integer.parseInt(marcha[2])));
                        if(eaf.getMarcha15km().after(indiceMarcha15kmFem)){EafInaptoEm++;inaptoMarcha=1;eaf.setSituacao(20);}
                        
                        //Apto
                        if(EafInaptoEm == 0){
                            eaf.setSituacao(1);
                        }
                        //Inapto
                        else if(EafInaptoEm >= 2 || inaptoMarcha == 1){
                            eaf.setSituacao(2);
                        }
                        
                        eaf.setIdTurma(Integer.parseInt(request.getParameter("txtIdTurmaEafTent1")));
                        eaf.setIdentidadeAluno(String.valueOf(request.getParameter("txtIdentidadeAlEafTent1")));
                        eaf.setIdentidadeMilitar(militarLogado.getIdentidade());
                        
                        eafDAO.insert(eaf);
                    }                    
                }
                else if(request.getParameter("txtAvlEafTent2") != null){
                    //Indices do Eaf
                    //Masculino
                    Time indiceCorridaMasc = new Time(0,40,0);
                    int indiceFlexaoBarraMasc = 10;
                    int indiceAbdSupraMasc = 68;
                    int indiceFlexaoBracoMasc = 35;
                    Time indicePpmMasc = new Time(0,4,50);
                    Time indiceNatUtlMasc = new Time(0,15,0);
                    Time indiceFlutuacaoMasc = new Time(0,10,0);
                    Time indiceMarcha15kmMasc = new Time(3,0,0);
                    
                    //Feminino
                    Time indiceCorridaFem = new Time(1,0,0);
                    Time indiceSuspensaoBarraFem = new Time(0,0,28);
                    int indiceAbdSupraFem = 59;
                    int indiceFlexaoBracoFem = 31;
                    Time indicePpmFem = new Time(0,9,0);
                    Time indiceNatUtlFem = new Time(0,20,0);
                    Time indiceFlutuacaoFem = new Time(0,6,0);
                    Time indiceMarcha15kmFem = new Time(3,30,0);
                    
                    EafDAO eafDAO = new EafDAO();                    
                    Eaf eaf = new Eaf();
                    
                    eaf.setIdRec(eafDAO.proxIDRec());
                    eaf.setIdTurmaRec(Integer.parseInt(request.getParameter("txtIdTurmaEafTent2")));
                    eaf.setIdentidadeAlunoRec(String.valueOf(request.getParameter("txtIdentidadeAlEafTent2")));
                    eaf.setIdentidadeMilitarAvaliadorRec(militarLogado.getIdentidade());
                    
                    if(request.getParameter("txtSexoEafTent2").equals("M")){ 
                        if(!request.getParameter("txtCorridaEafTent2").equals("")){
                            String corridaRec[] = request.getParameter("txtCorridaEafTent2").split(":");
                            eaf.setCorridaRec(new Time(Integer.parseInt(corridaRec[0]), Integer.parseInt(corridaRec[1]), Integer.parseInt(corridaRec[2])));
                            if(eaf.getCorridaRec().after(indiceCorridaMasc)){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);}                      
                        }
                        
                        if(!request.getParameter("txtAbdSupraEafTent2").equals("") && !request.getParameter("txtAbdSupraEafTent2").equals("0")){                            
                            eaf.setAbdominalRec(Integer.parseInt(request.getParameter("txtAbdSupraEafTent2")));
                            if(eaf.getAbdominalRec()< indiceAbdSupraMasc){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);} 
                        }
                        
                        if(!request.getParameter("txtFlexaoBracoEafTent2").equals("") && !request.getParameter("txtFlexaoBracoEafTent2").equals("0")){
                            eaf.setFlexaoBracoRec(Integer.parseInt(request.getParameter("txtFlexaoBracoEafTent2")));
                            if(eaf.getFlexaoBracoRec() < indiceFlexaoBracoMasc){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);} 
                        }
                        
                        if(!request.getParameter("txtFlexaoBarraEafTent2").equals("") && !request.getParameter("txtFlexaoBarraEafTent2").equals("0")){
                            eaf.setFlexaoBarraRec(Integer.parseInt(request.getParameter("txtFlexaoBarraEafTent2")));
                            if(eaf.getFlexaoBarraRec() < indiceFlexaoBarraMasc){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);} 
                        }
                        
                        if(!request.getParameter("txtNadoSubmersoEafTent2").equals("") && !request.getParameter("txtNadoSubmersoEafTent2").equals("0")){
                            eaf.setNadoSubmersoRec(Integer.parseInt(request.getParameter("txtNadoSubmersoEafTent2")));
                            if(eaf.getNadoSubmersoRec() == 2){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);} 
                        }
                        
                        if(!request.getParameter("txtCordaVerticalEafTent2").equals("") && !request.getParameter("txtCordaVerticalEafTent2").equals("0")){
                            eaf.setSubidaCordaRec(Integer.parseInt(request.getParameter("txtCordaVerticalEafTent2")));
                            if(eaf.getSubidaCordaRec() == 2){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);}                             
                        }
                        
                        if(!request.getParameter("txtPPMEafTent2").equals("")){
                            String ppmRec[] = request.getParameter("txtPPMEafTent2").split(":");
                            eaf.setPpmRec(new Time(Integer.parseInt(ppmRec[0]), Integer.parseInt(ppmRec[1]), Integer.parseInt(ppmRec[2])));
                            if(eaf.getPpmRec().after(indicePpmMasc)){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);} 
                        }
                        
                        if(!request.getParameter("txtNatUtlEafTent2").equals("")){
                            String natutlRec[] = request.getParameter("txtNatUtlEafTent2").split(":");
                            eaf.setNatacaoRec(new Time(Integer.parseInt(natutlRec[0]), Integer.parseInt(natutlRec[1]), Integer.parseInt(natutlRec[2])));
                            if(eaf.getNatacaoRec().after(indiceNatUtlMasc)){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);} 
                        }
                        
                        if(!request.getParameter("txtFlutuacaoEafTent2").equals("")){
                            String flutuacaoRec[] = request.getParameter("txtFlutuacaoEafTent2").split(":");
                            eaf.setFlutuacaoRec(new Time(Integer.parseInt(flutuacaoRec[0]), Integer.parseInt(flutuacaoRec[1]), Integer.parseInt(flutuacaoRec[2])));
                            if(eaf.getFlutuacaoRec().before(indiceFlutuacaoMasc)){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);} 
                        }
                        if(!request.getParameter("txtMarchaEafTent2").equals("")){
                            String marchaRec[] = request.getParameter("txtMarchaEafTent2").split(":");
                            eaf.setMarcha15kmRec(new Time(Integer.parseInt(marchaRec[0]), Integer.parseInt(marchaRec[1]), Integer.parseInt(marchaRec[2])));
                            if(eaf.getMarcha15kmRec().after(indiceMarcha15kmMasc)){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);} 
                        }                        
                        
                        eafDAO.insertRec(eaf);
                       
                    }else if(request.getParameter("txtSexoEafTent2").equals("F")){
                        if(!request.getParameter("txtCorridaEafTent2").equals("")){
                            String corridaRec[] = request.getParameter("txtCorridaEafTent2").split(":");
                            eaf.setCorridaRec(new Time(Integer.parseInt(corridaRec[0]), Integer.parseInt(corridaRec[1]), Integer.parseInt(corridaRec[2])));
                            if(eaf.getCorridaRec().after(indiceCorridaFem)){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);}                      
                        }
                        
                        if(!request.getParameter("txtAbdSupraEafTent2").equals("") && !request.getParameter("txtAbdSupraEafTent2").equals("0")){
                            eaf.setAbdominalRec(Integer.parseInt(request.getParameter("txtAbdSupraEafTent2")));
                            if(eaf.getAbdominalRec()< indiceAbdSupraFem){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);}
                        }
                        
                        if(!request.getParameter("txtFlexaoBracoEafTent2").equals("") && !request.getParameter("txtFlexaoBracoEafTent2").equals("0")){
                            eaf.setFlexaoBracoRec(Integer.parseInt(request.getParameter("txtFlexaoBracoEafTent2")));
                            if(eaf.getFlexaoBracoRec() < indiceFlexaoBracoFem){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);}
                        }
                        
                        if(!request.getParameter("txtSuspBarraEafTent2").equals("")){
                            String suspbarraRec[] = request.getParameter("txtSuspBarraEafTent2").split(":");
                            eaf.setSuspBarraRec(new Time(Integer.parseInt(suspbarraRec[0]), Integer.parseInt(suspbarraRec[1]), Integer.parseInt(suspbarraRec[2])));
                            if(eaf.getSuspBarraRec().before(indiceSuspensaoBarraFem)){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);}
                        }
                        
                        if(!request.getParameter("txtNadoSubmersoEafTent2").equals("") && !request.getParameter("txtNadoSubmersoEafTent2").equals("0")){
                            eaf.setNadoSubmersoRec(Integer.parseInt(request.getParameter("txtNadoSubmersoEafTent2")));
                            if(eaf.getNadoSubmersoRec() == 2){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);}
                        }
                        
                        if(!request.getParameter("txtCordaVerticalEafTent2").equals("") && !request.getParameter("txtNadoSubmersoEafTent2").equals("0")){
                            eaf.setSubidaCordaRec(Integer.parseInt(request.getParameter("txtCordaVerticalEafTent2")));
                            if(eaf.getSubidaCordaRec() == 2){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);}
                        }
                        
                        if(!request.getParameter("txtPPMEafTent2").equals("")){
                            String ppmRec[] = request.getParameter("txtPPMEafTent2").split(":");
                            eaf.setPpmRec(new Time(Integer.parseInt(ppmRec[0]), Integer.parseInt(ppmRec[1]), Integer.parseInt(ppmRec[2])));
                            if(eaf.getPpmRec().after(indicePpmFem)){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);}
                        }
                        
                        if(!request.getParameter("txtNatUtlEafTent2").equals("")){
                            String natutlRec[] = request.getParameter("txtNatUtlEafTent2").split(":");
                            eaf.setNatacaoRec(new Time(Integer.parseInt(natutlRec[0]), Integer.parseInt(natutlRec[1]), Integer.parseInt(natutlRec[2])));
                            if(eaf.getNatacaoRec().after(indiceNatUtlFem)){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);}
                        }
                        
                        if(!request.getParameter("txtFlutuacaoEafTent2").equals("")){
                            String flutuacaoRec[] = request.getParameter("txtFlutuacaoEafTent2").split(":");
                            eaf.setFlutuacaoRec(new Time(Integer.parseInt(flutuacaoRec[0]), Integer.parseInt(flutuacaoRec[1]), Integer.parseInt(flutuacaoRec[2])));
                            if(eaf.getFlutuacaoRec().before(indiceFlutuacaoFem)){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);}
                        }
                        if(!request.getParameter("txtMarchaEafTent2").equals("")){
                            String marchaRec[] = request.getParameter("txtMarchaEafTent2").split(":");
                            eaf.setMarcha15kmRec(new Time(Integer.parseInt(marchaRec[0]), Integer.parseInt(marchaRec[1]), Integer.parseInt(marchaRec[2])));
                            if(eaf.getMarcha15kmRec().after(indiceMarcha15kmFem)){eaf.setSituacaoRec(2);}else{eaf.setSituacaoRec(1);}
                        }
                        
                        eafDAO.insertRec(eaf);
                    }                    
                }

            }catch(Exception ex){
                //e=2: erro durante realização do cadastro
                response.sendRedirect("/sgdis/restrito/avaliacao/avpreliminar.jsp?e=2");
                throw new ServletException(ex);
            }
            //e=1: cadastro sucesso
            response.sendRedirect("/sgdis/restrito/avaliacao/avpreliminar.jsp?e=1");
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
