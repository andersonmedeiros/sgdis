/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.aluno;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
public class Candidatura extends HttpServlet {

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
            out.println("<title>Servlet Candidatura</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Candidatura at " + request.getContextPath() + "</h1>");
            
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
                if((request.getParameter("txtTipoForca") == null) || (request.getParameter("txtForca") == null) || (request.getParameter("txtNomeOM") == null)
                        || (request.getParameter("txtPGradCmtOM") == null) || (request.getParameter("txtNomeCmtOM") == null) || (request.getParameter("txtSobrenomeCmtOM") == null)
                        || (request.getParameter("txtNomeGuerraCmtOM") == null)
                        || (request.getParameter("txtPGradChImtoOM") == null) || (request.getParameter("txtNomeChImtoOM") == null) || (request.getParameter("txtSobrenomeChImtoOM") == null)
                        || (request.getParameter("txtNomeGuerraChImtoOM") == null)
                        || (request.getParameter("txtPGradAl") == null) || (request.getParameter("txtArmaAl") == null) || (request.getParameter("txtDataNascAl") == null)
                        || (request.getParameter("txtNomeAl") == null) || (request.getParameter("txtSobrenomeAl") == null) || (request.getParameter("txtNomeGuerraAl") == null)
                        || (request.getParameter("txtIdtMilAl") == null) || (request.getParameter("txtCpfAl") == null) || (request.getParameter("txtUltDataPracaAl") == null)
                        || (request.getParameter("txtNatCidAl") == null) || (request.getParameter("txtEstCivilAl") == null) || (request.getParameter("txtSexoAl") == null)
                        || (request.getParameter("txtTSAl") == null) || (request.getParameter("txtFatorRHAl") == null)
                        || (request.getParameter("txtTitEleitorNumAl") == null) || (request.getParameter("txtTitEleitorZonaAl") == null) || (request.getParameter("txtTitEleitorSecaoAl") == null)
                        || (request.getParameter("txtTitEleitorCidAl") == null) || (request.getParameter("txtBancoAl") == null) || (request.getParameter("txtAgenciaAl") == null)
                        || (request.getParameter("txtDvAgenciaAl") == null) || (request.getParameter("txtContaAl") == null) || (request.getParameter("txtDvContaAl") == null)
                        || (request.getParameter("txtEmailAl") == null) || (request.getParameter("txtFoneAl") == null) || (request.getParameter("txtNumCoturnoAl") == null)
                        || (request.getParameter("txtTamGandAl") == null) || (request.getParameter("txtTamCalcaAl") == null) || (request.getParameter("txtTamCamCmfAl") == null)
                        || (request.getParameter("txtPossuiCNH") == null) || (request.getParameter("txtTraraVeiculo") == null) || (request.getParameter("txtFumante") == null)
                        || (request.getParameter("txtAlergico") == null) || (request.getParameter("txtUsoMtoCt") == null) || (request.getParameter("txtUsoTermErgSupAli") == null)
                        || (request.getParameter("txtCptmAl") == null)
                        || (request.getParameter("txtDataUltProm") == null) || (request.getParameter("txtQaProm") == null) || (request.getParameter("txtDataUltTAF") == null)
                        || (request.getParameter("txtMencaoTAF") == null) || (request.getParameter("txtFunc1") == null) || (request.getParameter("txtFunc2") == null)
                        || (request.getParameter("txtFunc3") == null) || (request.getParameter("txtSvAmz") == null) || (request.getParameter("txtPossuiConjuge") == null)
                        || (request.getParameter("txtParentescoRef") == null) || (request.getParameter("txtNomeRef") == null) || (request.getParameter("txtSobrenomeRef") == null)
                        || (request.getParameter("txtCpfRef") == null) || (request.getParameter("txtEmailRef") == null) || (request.getParameter("txtFoneRef") == null)
                        || (request.getParameter("txtAddRefConclusao") == null) || (request.getParameter("txtCepEndResid") == null) || (request.getParameter("txtNomeEndResid") == null)
                        || (request.getParameter("txtNumEndResid") == null) || (request.getParameter("txtCidadeEndResid") == null) || (request.getParameter("txtBairroEndResid") == null)
                        || (request.getParameter("txtEndCurso") == null)
                        || (request.getParameter("txtCepEndCurso") == null) || (request.getParameter("txtNomeEndCurso") == null) || (request.getParameter("txtNumEndCurso") == null)
                        || (request.getParameter("txtCidadeEndCurso") == null) || (request.getParameter("txtBairroEndCurso") == null)
                        || (request.getParameter("txtPossuiEAS") == null) || (request.getParameter("txtHabIdiomas") == null)
                        || (request.getParameter("txtPrepFisica") == null) || (request.getParameter("txtApoioFam") == null) || (request.getParameter("txtApoioOM") == null)
                        || (request.getParameter("txtCPrepCOS") == null) || (request.getParameter("txtProbRend") == null) || (request.getParameter("txtTempoPrep") == null)
                        || (request.getParameter("txtDedicacaoDoutOPS") == null) || (request.getParameter("txtFatorMotivacao") == null) || (request.getParameter("txtCsltSite") == null)
                        || (request.getParameter("txtCsltAmbVirtAl") == null)){
                    //e=2: erro durante realização do cadastro
                    
                    response.sendRedirect("/sgdis/restrito/candidato/candidatura.jsp?e=2");
                }else{
                    int idCursoCandidatura = Integer.parseInt(request.getParameter("txtCursoCandidatura"));
                    int idCategoriaCandidatura = Integer.parseInt(request.getParameter("txtCategoriaCandidatura"));
                    int turmaCandidatura = Integer.parseInt(request.getParameter("txtTurmaCandidatura"));
                    //Verificando Força escolhida;
                    int idForca = Integer.parseInt(request.getParameter("txtForca"));    
                    
                    //OM
                    int idOM = Integer.parseInt(request.getParameter("txtNomeOM"));
                    
                    //Fone OM
                    String foneOM = String.valueOf(request.getParameter("txtFoneOM").replace("(", "").replace(")", "").replace("-", "").replace(" ", ""));
                    FoneDAO foneDAO = new FoneDAO();
                    Fone foneOm = new Fone();
                    System.out.println("FONE OM: ");
                    System.out.println("FONE: " + foneOM);
                    System.out.println("ID OM: " + idOM);
                    System.out.println("----------");
                    System.out.println("");
                    
                    foneOm.setId(foneDAO.proxID());
                    foneOm.setNumero(foneOM);
                    foneOm.setIdOM(idOM);
                    foneDAO.insertFoneOM(foneOm);
                    
                    //Comandante
                    ComandanteDAO cmtDAO = new ComandanteDAO();
                    int idCmtOM;
                    int idPGradCmtOM = Integer.parseInt(request.getParameter("txtPGradCmtOM"));
                    String nomeCmtOM = String.valueOf(request.getParameter("txtNomeCmtOM"));
                    String sobrenomeCmtOM = String.valueOf(request.getParameter("txtSobrenomeCmtOM"));
                    String nomeGuerraCmtOM = String.valueOf(request.getParameter("txtNomeGuerraCmtOM"));
                    
                    System.out.println("COMANDANTE: ");
                    System.out.println("idPGrad: " + idPGradCmtOM);
                    System.out.println("nome: " + nomeCmtOM);
                    System.out.println("sobrenome: " + sobrenomeCmtOM);
                    System.out.println("nome guerra: " + nomeGuerraCmtOM);
                    System.out.println("-----------");
                    System.out.println("");
                    
                    Comandante cmtExistente = cmtDAO.getComandanteExistente(nomeCmtOM, sobrenomeCmtOM, nomeGuerraCmtOM, idPGradCmtOM);
                    //Verfica se o cmt já existe no banco de dados
                    if(cmtExistente != null){
                        idCmtOM = cmtExistente.getId();
                    }else{       
                        idCmtOM = cmtDAO.proxID();

                        Comandante cmt = new Comandante();                                                                                           
                        cmt.setId(idCmtOM);
                        cmt.setIdPostoGraduacao(idPGradCmtOM);
                        cmt.setNome(nomeCmtOM);
                        cmt.setSobrenome(sobrenomeCmtOM);
                        cmt.setNomeguerra(nomeGuerraCmtOM);
                        cmtDAO.insert(cmt);
                    }

                    //Chefe Imediato
                    ChefeImediatoDAO chImtoDAO = new ChefeImediatoDAO();
                    int idChImto;
                    int idPGradChImto = Integer.parseInt(request.getParameter("txtPGradChImtoOM"));
                    String nomeChImto = String.valueOf(request.getParameter("txtNomeChImtoOM"));
                    String sobrenomeChImto = String.valueOf(request.getParameter("txtSobrenomeChImtoOM"));
                    String nomeGuerraChImto = String.valueOf(request.getParameter("txtNomeGuerraChImtoOM"));
                    
                    System.out.println("CH IMEDIATO: ");
                    System.out.println("idPGrad: " + idPGradChImto);
                    System.out.println("nome: " + nomeChImto);
                    System.out.println("sobrenome: " + sobrenomeChImto);
                    System.out.println("nome guerra: " + nomeGuerraChImto);
                    System.out.println("-----------");
                    System.out.println("");

                    ChefeImediato chImtoExistente = chImtoDAO.getChefeImediatoExistente(nomeChImto, sobrenomeChImto, nomeGuerraChImto, idPGradChImto);
                    //Verfica se o chefe imediato já existe no banco de dados
                    if(chImtoExistente != null){
                        idChImto = chImtoExistente.getId();
                    }else{
                        idChImto = chImtoDAO.proxID();

                        ChefeImediato chImto = new ChefeImediato();                                                                                           
                        chImto.setId(idChImto);
                        chImto.setIdPostoGraduacao(idPGradChImto);
                        chImto.setNome(nomeChImto);
                        chImto.setSobrenome(sobrenomeChImto);
                        chImto.setNomeguerra(nomeGuerraChImto);
                        chImtoDAO.insert(chImto);
                    }
                    
                    //Uniforme
                    UniformeDAO unAlunoDAO = new UniformeDAO();
                    int idUniformeAl;
                    int tamCoturno = Integer.parseInt(request.getParameter("txtNumCoturnoAl"));
                    String tamGandola = String.valueOf(request.getParameter("txtTamGandAl")).toUpperCase();
                    String tamCalca = String.valueOf(request.getParameter("txtTamCalcaAl")).toUpperCase();
                    String tamCamCmf = String.valueOf(request.getParameter("txtTamCamCmfAl")).toUpperCase();
                    
                    System.out.println("UNIFORME: ");
                    System.out.println("tam coturno: " + tamCoturno);
                    System.out.println("tam gandola: " + tamGandola);
                    System.out.println("tam calca: " + tamCalca);
                    System.out.println("tam cam camuflada: " + tamCamCmf);
                    System.out.println("-----------");
                    System.out.println("");
                    
                    Uniforme unExistente = unAlunoDAO.getUniformeExistente(tamCoturno, tamGandola, tamCalca, tamCamCmf);
                    //Verfica se o uniforme já existe no banco de dados
                    if(unExistente != null){
                        idUniformeAl = unExistente.getId();
                    }else{
                        idUniformeAl = unAlunoDAO.proxID();
                        
                        Uniforme unAluno = new Uniforme();
                        unAluno.setId(idUniformeAl);
                        unAluno.setTamCoturno(tamCoturno);
                        unAluno.setTamGandola(tamGandola);
                        unAluno.setTamCalca(tamCalca);
                        unAluno.setTamCamisaCamuflada(tamCamCmf);
                        unAlunoDAO.insert(unAluno);
                    }
                    
                    //Promoção
                    PromocaoDAO promDAO = new PromocaoDAO();
                    int idProm;
                    String dataUltPromAlSeparada[] = String.valueOf(request.getParameter("txtDataUltProm")).split("-");
                    Date dataUltPromAl = new Date((Integer.parseInt(dataUltPromAlSeparada[0])-1900), (Integer.parseInt(dataUltPromAlSeparada[1]) - 1), Integer.parseInt(dataUltPromAlSeparada[2]));
                    String qaPromAl = String.valueOf(request.getParameter("txtQaProm")).toUpperCase();
                    String dataQaQuandoPromSeparada[];
                    Date dataQaQuandoPromAl;
                    if(qaPromAl.equals("S")){
                        dataQaQuandoPromSeparada = String.valueOf(request.getParameter("txtQaQuandoProm")).split("-");
                        dataQaQuandoPromAl = new Date((Integer.parseInt(dataQaQuandoPromSeparada[0])-1900), (Integer.parseInt(dataQaQuandoPromSeparada[1]) - 1), Integer.parseInt(dataQaQuandoPromSeparada[2]));
                    }else{
                        dataQaQuandoPromAl = null;
                    }
                    
                    System.out.println("PROMOÇÃO: ");
                    System.out.println("dt ult prom: " + dataUltPromAl);
                    System.out.println("qa prom: " + qaPromAl);
                    System.out.println("dt qa quando: " + dataQaQuandoPromAl);
                    System.out.println("-----------");
                    System.out.println("");
                    
                    Promocao promExistente = promDAO.getPromocaoExistente(dataUltPromAl, qaPromAl, dataQaQuandoPromAl);
                    //Verfica se a promoção já existe no banco de dados
                    if(promExistente != null){
                        idProm = promExistente.getId();
                    }else{
                        Promocao promAluno = new Promocao();
                        
                        idProm = promDAO.proxID();
                        promAluno.setId(idProm);
                        promAluno.setDataultpromocao(dataUltPromAl);
                        promAluno.setQapromocao(qaPromAl);
                        promAluno.setDataqapromocao(dataQaQuandoPromAl);
                        promDAO.insert(promAluno);
                    }
                    
                    //Taf
                    TafDAO tafDAO = new TafDAO();
                    int idTaf;
                    String dataUltTAFAlSeparada[] = String.valueOf(request.getParameter("txtDataUltTAF")).split("-");
                    Date dataUltTAFAl = new Date((Integer.parseInt(dataUltTAFAlSeparada[0])-1900), (Integer.parseInt(dataUltTAFAlSeparada[1]) - 1), Integer.parseInt(dataUltTAFAlSeparada[2]));
                    String mencaoTAF = String.valueOf(request.getParameter("txtMencaoTAF")).toUpperCase();
                    Taf tafExistente = tafDAO.getTafExistente(dataUltTAFAl, mencaoTAF);
                    
                    System.out.println("TAF: ");
                    System.out.println("dt ult taf: " + dataUltTAFAl);
                    System.out.println("mencao taf: " + mencaoTAF);
                    System.out.println("-----------");
                    System.out.println("");
                    
                    //Verfica se o taf já existe no banco de dados
                    if(tafExistente != null){
                        idTaf = tafExistente.getId();
                    }else{
                        Taf tafAluno = new Taf();
                        
                        idTaf = tafDAO.proxID();
                        tafAluno.setId(idTaf);
                        tafAluno.setDataUltTaf(dataUltTAFAl);
                        tafAluno.setMencao(mencaoTAF);
                        tafDAO.insert(tafAluno);
                    }
                    
                    //Preparação
                    PreparacaoDAO prepDAO = new PreparacaoDAO();
                    int idPrep;
                    String prepFisica = String.valueOf(request.getParameter("txtPrepFisica")).toUpperCase();
                    int apoioFam = Integer.parseInt(request.getParameter("txtApoioFam"));
                    int apoioOM = Integer.parseInt(request.getParameter("txtApoioOM"));
                    int cPrepCOS = Integer.parseInt(request.getParameter("txtCPrepCOS"));
                    int probRend = Integer.parseInt(request.getParameter("txtProbRend"));
                    int tempoPrep = Integer.parseInt(request.getParameter("txtTempoPrep"));
                    int dedicacaoDoutOPS = Integer.parseInt(request.getParameter("txtDedicacaoDoutOPS"));
                    String fatorMotivador = String.valueOf(request.getParameter("txtFatorMotivacao")).toUpperCase();
                    int csltSite = Integer.parseInt(request.getParameter("txtCsltSite"));
                    int csltAmbVirtAl = Integer.parseInt(request.getParameter("txtCsltAmbVirtAl"));
                    Preparacao prepExistente = prepDAO.getPreparacaoExistente(prepFisica, apoioFam, apoioOM, cPrepCOS, probRend, tempoPrep, dedicacaoDoutOPS, fatorMotivador, csltSite, csltAmbVirtAl);
                    //Verfica se a preparacao já existe no banco de dados
                    if(prepExistente != null){
                        idPrep = prepExistente.getId();
                    }else{
                        Preparacao prepAluno = new Preparacao();
                        
                        idPrep = prepDAO.proxID();
                        prepAluno.setId(idPrep);
                        prepAluno.setPrepFisica(prepFisica);
                        prepAluno.setApoioFamilia(apoioFam);
                        prepAluno.setApoioOM(apoioOM);
                        prepAluno.setCursoPreparacaoCOS(cPrepCOS);
                        prepAluno.setProblemaRedimento(probRend);
                        prepAluno.setTempoPrep(tempoPrep);
                        prepAluno.setDedicacaoDoutrinaOPS(dedicacaoDoutOPS);
                        prepAluno.setFatorMotivador(fatorMotivador);
                        prepAluno.setConsultaSite(csltSite);
                        prepAluno.setCsltAmbVirtualAl(csltAmbVirtAl);
                        prepDAO.insert(prepAluno);
                    }                    
                    
                    //Aluno
                    AlunoDAO alDAO = new AlunoDAO();
                    Aluno al = new Aluno();
                    String idtMilitarAl = String.valueOf(request.getParameter("txtIdtMilAl").replace("-", ""));
                    al.setIdentidade(idtMilitarAl);
                    al.setSituacao(1);
                    al.setIdPostoGraduacao(Integer.parseInt(request.getParameter("txtPGradAl")));
                    al.setIdQasQms(Integer.parseInt(request.getParameter("txtArmaAl")));
                    al.setIdCmt(idCmtOM);
                    
                    String dtNascAlSeparada[] = String.valueOf(request.getParameter("txtDataNascAl")).split("-");
                    Date dataNascAl = new Date((Integer.parseInt(dtNascAlSeparada[0])-1900), (Integer.parseInt(dtNascAlSeparada[1]) - 1), Integer.parseInt(dtNascAlSeparada[2]));
                    al.setDataNascimento(dataNascAl);
                    
                    al.setNome(String.valueOf(request.getParameter("txtNomeAl")).toUpperCase());
                    al.setSobrenome(String.valueOf(request.getParameter("txtSobrenomeAl")).toUpperCase());
                    al.setNomeguerra(String.valueOf(request.getParameter("txtNomeGuerraAl")).toUpperCase());
                    al.setCpf(String.valueOf(request.getParameter("txtCpfAl").replace(".", "").replace("-", "")));                    
                    
                    if(idForca == 2){
                        al.setPreccp(String.valueOf(request.getParameter("txtPreccpAl")));
                        al.setCp(String.valueOf(request.getParameter("txtCPAl")));
                    }
                    
                    String ultDataPracaAlSeparada[] = String.valueOf(request.getParameter("txtUltDataPracaAl")).split("-");
                    Date ultDataPracaAl = new Date((Integer.parseInt(ultDataPracaAlSeparada[0])-1900), (Integer.parseInt(ultDataPracaAlSeparada[1]) - 1), Integer.parseInt(ultDataPracaAlSeparada[2]));
                    al.setUltDataPraca(ultDataPracaAl);
                    al.setIdNatCidade(Integer.parseInt(request.getParameter("txtNatCidAl")));
                    al.setIdEstadoCivil(Integer.parseInt(request.getParameter("txtEstCivilAl")));
                    al.setTs(String.valueOf(request.getParameter("txtTSAl")).toUpperCase());
                    al.setFtrh(Integer.parseInt(request.getParameter("txtFatorRHAl")));
                    al.setPai(String.valueOf(request.getParameter("txtPaiAl")).toUpperCase());
                    al.setMae(String.valueOf(request.getParameter("txtMaeAl")).toUpperCase());
                    al.setEmail(String.valueOf(request.getParameter("txtEmailAl")).toUpperCase());
                    al.setFumante(Integer.parseInt(request.getParameter("txtFumante")));
                    al.setIdOM(idOM);
                    al.setIdComportamento(Integer.parseInt(request.getParameter("txtCptmAl")));
                    al.setIdChImto(idChImto);                    
                    al.setSexo(String.valueOf(request.getParameter("txtSexoAl")).toUpperCase());
                    al.setUltfuncao1(String.valueOf(request.getParameter("txtFunc1")).toUpperCase());
                    al.setUltfuncao2(String.valueOf(request.getParameter("txtFunc2")).toUpperCase());
                    al.setUltfuncao3(String.valueOf(request.getParameter("txtFunc3")).toUpperCase());
                    al.setIdTaf(idTaf);
                    al.setIdPromocao(idProm);
                    al.setIdPreparacao(idPrep);
                    al.setIdUniforme(idUniformeAl);
                    al.setEas(Integer.parseInt(request.getParameter("txtPossuiEAS")));
                    alDAO.insert(al);
                    
                    //Titulo de Eleitor
                    TituloEleitorDAO titEleitorDAO = new TituloEleitorDAO();
                    TituloEleitor titEleitor = new TituloEleitor();
                    titEleitor.setRegistro(String.valueOf(request.getParameter("txtTitEleitorNumAl").replace(" ", "")));
                    titEleitor.setZona(String.valueOf(request.getParameter("txtTitEleitorZonaAl")));
                    titEleitor.setSecao(String.valueOf(request.getParameter("txtTitEleitorSecaoAl")));
                    titEleitor.setIdCidade(Integer.parseInt(request.getParameter("txtTitEleitorCidAl")));
                    titEleitor.setIdentidadeAluno(idtMilitarAl);
                    
                    System.out.println("TIT ELEITOR: ");
                    System.out.println("num: " + titEleitor.getRegistro());
                    System.out.println("zona: " + titEleitor.getZona());
                    System.out.println("secao: " + titEleitor.getSecao());
                    System.out.println("cid: " + titEleitor.getIdCidade());
                    System.out.println("-----------");
                    System.out.println("");
                    
                    titEleitorDAO.insert(titEleitor);
                    
                    //Informações Bancárias
                    BancoDAO bancoDAO = new BancoDAO();
                    Banco banco = new Banco();
                    banco.setId(bancoDAO.proxID());
                    banco.setBanco(String.valueOf(request.getParameter("txtBancoAl")).toUpperCase());
                    banco.setAgencia(String.valueOf(request.getParameter("txtAgenciaAl")));
                    banco.setDvagencia(String.valueOf(request.getParameter("txtDvAgenciaAl")));
                    banco.setConta(String.valueOf(request.getParameter("txtContaAl")));
                    banco.setDvconta(String.valueOf(request.getParameter("txtDvContaAl")));
                    banco.setIdentidadeAluno(idtMilitarAl);
                    
                    System.out.println("BANCO: ");
                    System.out.println("banco: " + banco.getBanco());
                    System.out.println("agencia: " + banco.getAgencia());
                    System.out.println("dv agencia: " + banco.getDvagencia());
                    System.out.println("conta: " + banco.getConta());
                    System.out.println("dv conta: " + banco.getDvconta());
                    System.out.println("-----------");
                    System.out.println("");
                    
                    bancoDAO.insert(banco);
                    
                    //Fone Aluno
                    String foneAl = String.valueOf(request.getParameter("txtFoneAl").replace("(", "").replace(")", "").replace(" ", "").replace("-", ""));
                    Fone foneAluno = new Fone();
                    foneAluno.setId(foneDAO.proxID());
                    foneAluno.setNumero(foneAl);
                    foneAluno.setIdentidadeAluno(idtMilitarAl);
                    
                    System.out.println("FONE AL: ");
                    System.out.println("numero: " + foneAluno.getNumero());
                    System.out.println("-----------");
                    System.out.println("");
                    
                    foneDAO.insertFoneAluno(foneAluno);                  
                                            
                    
                    /*String possuiCNH = request.getParameter("txtPossuiCNH");
                    String traraVeiculo = request.getParameter("txtTraraVeiculo");
                    String alergico = request.getParameter("txtAlergico");
                    String mtoct = request.getParameter("txtUsoMtoCt"); 
                    String termergsupali = request.getParameter("txtUsoTermErgSupAli");
                    String possuiConjuge = request.getParameter("txtPossuiConjuge");
                    String refConclusao = request.getParameter("txtAddRefConclusao");
                    String habIdiomas = request.getParameter("txtHabIdiomas");     */                      
                    
                        
                    //Veiculo 
                    /*VeiculoDAO veiculoDAO = new VeiculoDAO();
                    String[] tipoVeiculos = request.getParameterValues("txtTipoVeiculoAl");
                    String[] marcaVeiculos = request.getParameterValues("txtMarcaVeiculoAl");
                    String[] modeloVeiculos = request.getParameterValues("txtModeloVeiculoAl");
                    String[] corVeiculos = request.getParameterValues("txtCorVeiculoAl");
                    String[] placaVeiculos = request.getParameterValues("txtPlacaVeiculoAl");
                    
                    if(tipoVeiculos != null){
                        for(int i=0; i<tipoVeiculos.length; i++){
                            System.out.println("VEICULO: ");
                            System.out.println("vtipo: " + tipoVeiculos[i]);
                            System.out.println("vmarca: " + marcaVeiculos[i]);
                            System.out.println("vmodelo: " + modeloVeiculos[i]);
                            System.out.println("vcor: " + corVeiculos[i]);
                            System.out.println("vplaca: " + placaVeiculos[i]);
                            System.out.println("------------");
                            System.out.println("");
                            
                            Veiculo veiculo = new Veiculo();
                            veiculo.setId(veiculoDAO.proxID());
                            veiculo.setTipo(tipoVeiculos[i].toUpperCase());
                            veiculo.setMarca(marcaVeiculos[i].toUpperCase());
                            veiculo.setModelo(modeloVeiculos[i].toUpperCase());
                            veiculo.setCor(corVeiculos[i].toUpperCase());
                            veiculo.setPlaca(placaVeiculos[i].toUpperCase());
                            veiculo.setIdentidadeAluno(idtMilitarAl);

                            veiculoDAO.insert(veiculo);        
                        }   
                    }*/
                        
                    //Alergia
                    AlergiaDAO alergiaDAO = new AlergiaDAO();
                    AlunoHasAlergiaDAO alunoalergiaDAO = new AlunoHasAlergiaDAO();
                    String[] alergias = request.getParameterValues("txtAlergia");

                    int idAlergia;
                    
                    if(alergias != null){
                        System.out.println("ALERGIAS: ");
                        for (String alergia1 : alergias) {
                            
                            System.out.println("alergia: " + alergia1);                            
                            System.out.println("-");
                            
                            Alergia alergiaExistente = alergiaDAO.getAlergiaExistente(alergia1.toUpperCase());
                            if (alergiaExistente != null) {
                                AlunoHasAlergia alunoalergia = new AlunoHasAlergia();
                                alunoalergia.setIdentidadeAluno(idtMilitarAl);
                                alunoalergia.setIdAlergia(alergiaExistente.getId());
                                alunoalergiaDAO.insert(alunoalergia);
                            } else {
                                Alergia alergia = new Alergia();
                                idAlergia = alergiaDAO.proxID();
                                alergia.setId(idAlergia);
                                alergia.setNome(alergia1.toUpperCase());
                                alergiaDAO.insert(alergia);
                                AlunoHasAlergia alunoalergia = new AlunoHasAlergia();
                                alunoalergia.setIdentidadeAluno(idtMilitarAl);
                                alunoalergia.setIdAlergia(idAlergia);
                                
                                alunoalergiaDAO.insert(alunoalergia);
                            }
                        }
                        System.out.println("------------");
                    }
                    System.out.println("");
                    
                    //Medicação                    
                    MedicacaoDAO medicacaoDAO = new MedicacaoDAO();
                    AlunoHasMedicacaoDAO alunomedicacaoDAO = new AlunoHasMedicacaoDAO();
                    //Medicacamento Controlado (Tipo: 1)
                    String[] mtosct = request.getParameterValues("txtNomeMtoCt");
                    String[] frequencias = request.getParameterValues("txtFrqMtoCt");
                    String[] periodos = request.getParameterValues("txtTpMtoCt");
                    int idMtoCt;
                    
                    if(mtosct != null){
                        System.out.println("MTO CT: ");
                        for(int i=0;i<mtosct.length;i++){
                            
                            System.out.println("almednome: " + mtosct[i]);
                            System.out.println("almedfreq: " + frequencias[i]);
                            System.out.println("almedperiodo: " + periodos[i]);
                            System.out.println("-");
                            
                            
                            
                            Medicacao medicacaoExistente = medicacaoDAO.getMedicacaoExistente(mtosct[i].toUpperCase());
                            if(medicacaoExistente != null){
                                AlunoHasMedicacao alunomedicacao = new AlunoHasMedicacao();
                                alunomedicacao.setIdentidadeAluno(idtMilitarAl);
                                alunomedicacao.setIdMedicacao(medicacaoExistente.getId());
                                alunomedicacao.setFrequencia(Integer.parseInt(frequencias[i]));
                                alunomedicacao.setPeriodo(periodos[i].toUpperCase());
                                alunomedicacao.setTipo(1);//1 - Medicamento Controlado

                                

                                alunomedicacaoDAO.insert(alunomedicacao);
                            }else{
                                Medicacao medicacao = new Medicacao();
                                idMtoCt = medicacaoDAO.proxID();
                                medicacao.setId(idMtoCt);
                                medicacao.setNome(mtosct[i].toUpperCase());

                                medicacaoDAO.insert(medicacao);

                                AlunoHasMedicacao alunomedicacao = new AlunoHasMedicacao();
                                alunomedicacao.setIdentidadeAluno(idtMilitarAl);
                                alunomedicacao.setIdMedicacao(idMtoCt);
                                alunomedicacao.setFrequencia(Integer.parseInt(frequencias[i]));
                                alunomedicacao.setPeriodo(periodos[i].toUpperCase());
                                alunomedicacao.setTipo(1);//1 - Medicamento Controlado

                                alunomedicacaoDAO.insert(alunomedicacao);
                            }
                        }
                        System.out.println("------------------");
                    }
                    System.out.println("");

                    //Termogênicos, Ergogênicos ou Suplementos Alimentares (Tipo: 2)
                    String[] terergsupali = request.getParameterValues("txtNomeTermErgSupAli");
                    int idTermErgSupAli;
                    
                    if(terergsupali != null){
                        System.out.println("TERM ERG SUP ALI: ");
                        for (String terergsupali1 : terergsupali) {
                            System.out.println("altermergsupalinome: " + terergsupali1);
                            System.out.println("-");
                            Medicacao medicacaoExistente = medicacaoDAO.getMedicacaoExistente(terergsupali1.toUpperCase());
                            if (medicacaoExistente != null) {
                                AlunoHasMedicacao alunomedicacao = new AlunoHasMedicacao();
                                alunomedicacao.setIdentidadeAluno(idtMilitarAl);
                                alunomedicacao.setIdMedicacao(medicacaoExistente.getId());
                                alunomedicacao.setTipo(2);//2 - Termogênicos, Ergogênicos ou Suplementos Alimentares

                                alunomedicacaoDAO.insert(alunomedicacao);
                            } else {
                                Medicacao medicacao = new Medicacao();
                                idTermErgSupAli = medicacaoDAO.proxID();
                                medicacao.setId(idTermErgSupAli);
                                medicacao.setNome(terergsupali1.toUpperCase());
                                medicacaoDAO.insert(medicacao);
                                AlunoHasMedicacao alunomedicacao = new AlunoHasMedicacao();
                                alunomedicacao.setIdentidadeAluno(idtMilitarAl);
                                alunomedicacao.setIdMedicacao(idTermErgSupAli);
                                alunomedicacao.setTipo(2);//2 - Termogênicos, Ergogênicos ou Suplementos Alimentares
                                alunomedicacaoDAO.insert(alunomedicacao);
                            }
                        }
                        System.out.println("------------------");
                        System.out.println("");
                    }                    
                    
                    //Cnh
                    CnhDAO cnhDAO = new CnhDAO();
                    if(!request.getParameter("txtPossuiCNH").equals("n") && !request.getParameter("txtPossuiCNH").equals("0")){
                        Cnh cnhAluno = new Cnh();
                        cnhAluno.setNumero(String.valueOf(request.getParameter("txtCNHNumAl")));
                        cnhAluno.setCategoria(String.valueOf(request.getParameter("txtCNHCatgAl")));
                        String cnhDataValAlSeparada[] = String.valueOf(request.getParameter("txtCNHDataValAl")).split("-");
                        Date cnhDataValAl = new Date((Integer.parseInt(cnhDataValAlSeparada[0])-1900), (Integer.parseInt(cnhDataValAlSeparada[1]) - 1), Integer.parseInt(cnhDataValAlSeparada[2]));
                        cnhAluno.setDataValidade(cnhDataValAl);
                        cnhAluno.setIdentidadeAluno(idtMilitarAl);
                        System.out.println("CNH: ");
                        System.out.println("cnhnum: " + cnhAluno.getNumero());
                        System.out.println("cnhcat: " + cnhAluno.getCategoria());
                        System.out.println("cnhdataval: " + cnhAluno.getDataValidade());
                        System.out.println("-----------------------");
                        System.out.println("");
                        cnhDAO.insert(cnhAluno);
                    }
                    
                    //Veiculo
                    VeiculoDAO veiculoDAO = new VeiculoDAO();
                    if(!request.getParameter("txtTraraVeiculo").equals("n") && !request.getParameter("txtTraraVeiculo").equals("0")){
                        Veiculo veiculo = new Veiculo();
                        veiculo.setId(veiculoDAO.proxID());
                        veiculo.setTipo(String.valueOf(request.getParameter("txtTipoVeiculoAl")).toUpperCase());
                        veiculo.setMarca(String.valueOf(request.getParameter("txtMarcaVeiculoAl")).toUpperCase());
                        veiculo.setModelo(String.valueOf(request.getParameter("txtModeloVeiculoAl")).toUpperCase());
                        veiculo.setCor(String.valueOf(request.getParameter("txtCorVeiculoAl")).toUpperCase());
                        veiculo.setPlaca(String.valueOf(request.getParameter("txtPlacaVeiculoAl")).toUpperCase());
                        veiculo.setIdentidadeAluno(idtMilitarAl);
                            
                        System.out.println("VEICULO: ");
                        System.out.println("vtipo: " + veiculo.getTipo());
                        System.out.println("vmarca: " + veiculo.getMarca());
                        System.out.println("vmodelo: " + veiculo.getModelo());
                        System.out.println("vcor: " + veiculo.getCor());
                        System.out.println("vplaca: " + veiculo.getPlaca());
                        System.out.println("------------");
                        System.out.println("");
                        
                        veiculoDAO.insert(veiculo);      
                    }
                        
                    //Conjuge
                    ConjugeDAO conjugeDAO = new ConjugeDAO();
                    if(!request.getParameter("txtPossuiConjuge").equals("n") && !request.getParameter("txtPossuiConjuge").equals("0")){
                        Conjuge conjuge = new Conjuge();
                        int idConjuge = conjugeDAO.proxID();
                        conjuge.setId(idConjuge);
                        conjuge.setNome(String.valueOf(request.getParameter("txtNomeConjuge")).toUpperCase());
                        conjuge.setSobrenome(String.valueOf(request.getParameter("txtSobrenomeConjuge")).toUpperCase());
                        conjuge.setCpf(String.valueOf(request.getParameter("txtCpfConjuge").replace(".", "").replace("-", "")));
                        conjuge.setEmail(String.valueOf(request.getParameter("txtEmailConjuge")).toUpperCase());
                        conjuge.setIdentidadeAluno(idtMilitarAl);
                        
                        System.out.println("CONJUGE: ");
                        System.out.println("conjugenome: " + conjuge.getNome());
                        System.out.println("conjugecpf: " + conjuge.getCpf());
                        System.out.println("conjugeemail: " + conjuge.getEmail());
                        System.out.println("conjugeidt: " + conjuge.getIdentidadeAluno());                        
                        System.out.println("---------------------");                        

                        conjugeDAO.insert(conjuge);

                        Fone foneConjuge = new Fone();
                        foneConjuge.setId(foneDAO.proxID());
                        foneConjuge.setNumero(String.valueOf(request.getParameter("txtFoneConjuge").replace("(", "").replace(")", "").replace(" ", "").replace("-", "")));
                        foneConjuge.setIdConjuge(idConjuge);
                        
                        System.out.println("FONE CONJUGE: ");
                        System.out.println("foneconjuge: " + foneConjuge.getNumero());
                        System.out.println("----------------");
                        System.out.println("");
                        foneDAO.insertFoneConjuge(foneConjuge);                       
                    }
                    
                    //Referência Obrigatória
                    AlunoHasReferenciaDAO alunoreferenciaDAO = new AlunoHasReferenciaDAO();
                    ReferenciaDAO refDAO = new ReferenciaDAO();
                    String cpfRefAluno = String.valueOf(request.getParameter("txtCpfRef").replace(".", "").replace("-", ""));
                    
                    System.out.println("REFERENCIA: ");
                    System.out.println("parentesco: " + request.getParameter("txtParentescoRef"));
                    System.out.println("parentesco: " + request.getParameter("txtCpfRef"));
                    System.out.println("nome: " + request.getParameter("txtNomeRef"));
                    System.out.println("sobrenome: " + request.getParameter("txtSobrenomeRef"));
                    System.out.println("email: " + request.getParameter("txtEmailRef"));
                    System.out.println("fone: " + request.getParameter("txtFoneRef"));
                    System.out.println("----------------");
                    System.out.println("");
                    
                    Referencia refExistente = refDAO.getReferenciaExistente(cpfRefAluno);
                    
                    if(refExistente != null){
                        cpfRefAluno = refExistente.getCpf();
                        
                        Fone foneRefAluno = foneDAO.getFoneByCpfReferencia(cpfRefAluno);
                        foneRefAluno.setNumero(String.valueOf(request.getParameter("txtFoneRef").replace("(", "").replace(")", "").replace(" ", "").replace("-", "")));
                        foneDAO.update(foneRefAluno);
                        
                        AlunoHasReferencia alunoreferencia = new AlunoHasReferencia();
                        alunoreferencia.setIdentidadeAluno(idtMilitarAl);
                        alunoreferencia.setCpfReferencia(cpfRefAluno);
                        alunoreferencia.setTipo(1); //Referência obrigatória do aluno (Tipo: 1)
                        alunoreferenciaDAO.insert(alunoreferencia);
                    }else{
                        Referencia refAluno = new Referencia();
                        refAluno.setIdGrauParentesco(Integer.parseInt(request.getParameter("txtParentescoRef")));
                        refAluno.setNome(String.valueOf(request.getParameter("txtNomeRef")).toUpperCase());
                        refAluno.setSobrenome(String.valueOf(request.getParameter("txtSobrenomeRef")).toUpperCase());
                        refAluno.setCpf(cpfRefAluno);
                        refAluno.setEmail(String.valueOf(request.getParameter("txtEmailRef")).toUpperCase());
                        refDAO.insert(refAluno);
                        
                        Fone foneRefAluno = new Fone();
                        foneRefAluno.setId(foneDAO.proxID());
                        foneRefAluno.setNumero(String.valueOf(request.getParameter("txtFoneRef").replace("(", "").replace(")", "").replace(" ", "").replace("-", "")));
                        foneRefAluno.setCpfReferencia(cpfRefAluno);
                        foneDAO.insertFoneReferencia(foneRefAluno);
                        
                        AlunoHasReferencia alunoreferencia = new AlunoHasReferencia();
                        alunoreferencia.setIdentidadeAluno(idtMilitarAl);
                        alunoreferencia.setCpfReferencia(cpfRefAluno);
                        alunoreferencia.setTipo(1); //Referência obrigatória do aluno (Tipo: 1)
                        alunoreferenciaDAO.insert(alunoreferencia);
                    } 
                    
                    //Referência em caso de conclusão etc
                    if(!request.getParameter("txtAddRefConclusao").equals("n") && !request.getParameter("txtAddRefConclusao").equals("0")){
                        String cpfRefConclusaoAluno = String.valueOf(request.getParameter("txtCpfRefConclusao").replace(".", "").replace("-", ""));

                        System.out.println("REFERENCIA Conclusao: ");
                        System.out.println("parentesco: " + request.getParameter("txtParentescoRefConclusao"));
                        System.out.println("parentesco: " + request.getParameter("txtCpfRefConclusao"));
                        System.out.println("nome: " + request.getParameter("txtNomeRefConclusao"));
                        System.out.println("sobrenome: " + request.getParameter("txtSobrenomeRefConclusao"));
                        System.out.println("email: " + request.getParameter("txtEmailRefConclusao"));
                        System.out.println("fone: " + request.getParameter("txtFoneRefConclusao"));
                        System.out.println("----------------");
                        System.out.println("");

                        Referencia refConclusaoExistente = refDAO.getReferenciaExistente(cpfRefConclusaoAluno);

                        if(refConclusaoExistente != null){
                            cpfRefConclusaoAluno = refConclusaoExistente.getCpf();

                            Fone foneRefConclusaoAluno = foneDAO.getFoneByCpfReferencia(cpfRefConclusaoAluno);
                            foneRefConclusaoAluno.setNumero(String.valueOf(request.getParameter("txtFoneRefConclusao").replace("(", "").replace(")", "").replace(" ", "").replace("-", "")));
                            foneDAO.update(foneRefConclusaoAluno);

                            AlunoHasReferencia alunoreferencia = new AlunoHasReferencia();
                            alunoreferencia.setIdentidadeAluno(idtMilitarAl);
                            alunoreferencia.setCpfReferencia(cpfRefConclusaoAluno);
                            alunoreferencia.setTipo(2); //Referência em caso de conclusão etc (Tipo: 2)
                            alunoreferenciaDAO.insert(alunoreferencia);
                        }else{
                            Referencia refConclusaoAluno = new Referencia();
                            refConclusaoAluno.setIdGrauParentesco(Integer.parseInt(request.getParameter("txtParentescoRefConclusao")));
                            refConclusaoAluno.setNome(String.valueOf(request.getParameter("txtNomeRefConclusao")).toUpperCase());
                            refConclusaoAluno.setSobrenome(String.valueOf(request.getParameter("txtSobrenomeRefConclusao")).toUpperCase());
                            refConclusaoAluno.setCpf(cpfRefConclusaoAluno);
                            refConclusaoAluno.setEmail(String.valueOf(request.getParameter("txtEmailRefConclusao")).toUpperCase());
                            refDAO.insert(refConclusaoAluno);

                            Fone foneRefConclusaoAluno = new Fone();
                            foneRefConclusaoAluno.setId(foneDAO.proxID());
                            foneRefConclusaoAluno.setNumero(String.valueOf(request.getParameter("txtFoneRefConclusao").replace("(", "").replace(")", "").replace(" ", "").replace("-", "")));
                            foneRefConclusaoAluno.setCpfReferencia(cpfRefConclusaoAluno);
                            foneDAO.insertFoneReferencia(foneRefConclusaoAluno);

                            AlunoHasReferencia alunoreferencia = new AlunoHasReferencia();
                            alunoreferencia.setIdentidadeAluno(idtMilitarAl);
                            alunoreferencia.setCpfReferencia(cpfRefConclusaoAluno);
                            alunoreferencia.setTipo(2); //Referência em caso de conclusão etc (Tipo: 2)
                            alunoreferenciaDAO.insert(alunoreferencia);
                        }
                    }
                        
                    //Endereço
                    EnderecoDAO endDAO = new EnderecoDAO();
                    AlunoHasEnderecoDAO alunoenderecoDAO = new AlunoHasEnderecoDAO();
                    int idEndResid;
                    String cepEndResid = String.valueOf(request.getParameter("txtCepEndResid").replace("-", ""));
                    String descricaoEndResid = String.valueOf(request.getParameter("txtNomeEndResid")).toUpperCase();
                    String numEndResid = String.valueOf(request.getParameter("txtNumEndResid")).toUpperCase();
                    int idCidadeEndResid = Integer.parseInt(request.getParameter("txtCidadeEndResid"));
                    String bairroEndResid = String.valueOf(request.getParameter("txtBairroEndResid")).toUpperCase();
                    String complementoEndResid = String.valueOf(request.getParameter("txtCompEndResid")).toUpperCase();
                    String pontoRefEndResid = String.valueOf(request.getParameter("txtPtRefEndResid")).toUpperCase();
                    
                    System.out.println("ENDERECO DE RESIDENCIA: ");
                    System.out.println("cep: " + cepEndResid);
                    System.out.println("descricao: " + descricaoEndResid);
                    System.out.println("num: " + numEndResid);
                    System.out.println("cidade: " + idCidadeEndResid);
                    System.out.println("bairro: " + bairroEndResid);
                    System.out.println("complemento: " + complementoEndResid);
                    System.out.println("ponto ref: " + pontoRefEndResid);
                    

                    Endereco endExistente = endDAO.getEnderecoExistente(cepEndResid, descricaoEndResid, complementoEndResid, pontoRefEndResid, bairroEndResid, idCidadeEndResid);
                    if(endExistente != null){
                        idEndResid = endExistente.getId();

                        AlunoHasEndereco alunoendereco = new AlunoHasEndereco();
                        alunoendereco.setIdentidadeAluno(idtMilitarAl);
                        alunoendereco.setIdEndereco(idEndResid);
                        alunoendereco.setNumendereco(numEndResid);
                        alunoendereco.setTipo(1);//Endereço de residencia (Tipo: 1)
                        alunoenderecoDAO.insert(alunoendereco);
                    }else{
                        Endereco endResidAluno = new Endereco();

                        idEndResid = endDAO.proxID();
                        endResidAluno.setId(idEndResid);
                        endResidAluno.setCep(cepEndResid);
                        endResidAluno.setDescricao(descricaoEndResid);
                        endResidAluno.setBairro(bairroEndResid);
                        endResidAluno.setComplemento(complementoEndResid);
                        endResidAluno.setPontoreferencia(pontoRefEndResid);
                        endResidAluno.setIdCidade(idCidadeEndResid);
                        endDAO.insert(endResidAluno);

                        AlunoHasEndereco alunoendereco = new AlunoHasEndereco();
                        alunoendereco.setIdentidadeAluno(idtMilitarAl);
                        alunoendereco.setIdEndereco(idEndResid);
                        alunoendereco.setNumendereco(numEndResid);
                        alunoendereco.setTipo(1);//Endereço de residencia (Tipo: 1)
                        alunoenderecoDAO.insert(alunoendereco);
                    }
                    
                    System.out.println("------------------");
                    System.out.println("");

                    AlunoHasEndereco alunoendereco = new AlunoHasEndereco();
                    int idEndCurso;
                    String cepEndCurso = String.valueOf(request.getParameter("txtCepEndCurso").replace("-", ""));
                    String descricaoEndCurso = String.valueOf(request.getParameter("txtNomeEndCurso")).toUpperCase();
                    String numEndCurso = String.valueOf(request.getParameter("txtNumEndCurso")).toUpperCase();
                    int idCidadeEndCurso = Integer.parseInt(request.getParameter("txtCidadeEndCurso"));
                    String bairroEndCurso = String.valueOf(request.getParameter("txtBairroEndCurso")).toUpperCase();
                    String complementoEndCurso = String.valueOf(request.getParameter("txtCompEndCurso")).toUpperCase();
                    String pontoRefEndCurso = String.valueOf(request.getParameter("txtPtRefEndCurso")).toUpperCase();
                    
                    System.out.println("ENDERECO DE CURSO: ");
                    System.out.println("cep: " + cepEndCurso);
                    System.out.println("descricao: " + descricaoEndCurso);
                    System.out.println("num: " + numEndCurso);
                    System.out.println("cidade: " + idCidadeEndCurso);
                    System.out.println("bairro: " + bairroEndCurso);
                    System.out.println("complemento: " + complementoEndCurso);
                    System.out.println("ponto ref: " + pontoRefEndCurso);

                    switch (request.getParameter("txtEndCurso")) {
                        case "resid":                            
                            idEndCurso = idEndResid;                            

                            alunoendereco.setIdentidadeAluno(idtMilitarAl);
                            alunoendereco.setIdEndereco(idEndCurso);
                            alunoendereco.setNumendereco(numEndCurso);
                            alunoendereco.setTipo(2); //Endereço durante o curso (Tipo: 2)
                            alunoenderecoDAO.insert(alunoendereco);
                            System.out.println("**resid**");
                            break;
                        case "cigs":                                    
                            Endereco endCigs = endDAO.getEnderecoExistente(cepEndCurso, descricaoEndCurso, complementoEndCurso, pontoRefEndCurso, bairroEndCurso, idCidadeEndCurso);
                            if(endCigs != null){
                                alunoendereco.setIdentidadeAluno(idtMilitarAl);
                                alunoendereco.setIdEndereco(endCigs.getId());
                                alunoendereco.setNumendereco(numEndCurso);
                                alunoendereco.setTipo(2); //Endereço durante o curso (Tipo: 2)
                                alunoenderecoDAO.insert(alunoendereco);
                            }
                            System.out.println("**cigs**");
                            break;
                        case "novo":                            
                            Endereco endCursoAluno = new Endereco();

                            idEndCurso = endDAO.proxID();
                            endCursoAluno.setId(idEndCurso);
                            endCursoAluno.setCep(cepEndCurso);
                            endCursoAluno.setDescricao(descricaoEndCurso);
                            endCursoAluno.setBairro(bairroEndCurso);
                            endCursoAluno.setComplemento(complementoEndCurso);
                            endCursoAluno.setPontoreferencia(pontoRefEndCurso);
                            endCursoAluno.setIdCidade(idCidadeEndCurso);
                            endDAO.insert(endCursoAluno);

                            alunoendereco.setIdentidadeAluno(idtMilitarAl);
                            alunoendereco.setIdEndereco(idEndCurso);
                            alunoendereco.setNumendereco(numEndCurso);
                            alunoendereco.setTipo(2);//Endereço durante o curso (Tipo: 2)
                            alunoenderecoDAO.insert(alunoendereco);
                            System.out.println("**novo**");
                            break;
                        default:
                            break;
                    }
                    
                    System.out.println("------------------");
                    System.out.println("");
                        
                    //Idiomas
                    AlunoHasIdiomaDAO alunoidiomaDAO = new AlunoHasIdiomaDAO();
                    String[] idiomas = request.getParameterValues("txtIdioma");
                    String[] ipls = request.getParameterValues("txtIplIdioma");
                    if(idiomas != null){
                        System.out.println("IDIOMA: ");
                        for(int i=0;i<idiomas.length;i++){
                            
                            System.out.println("idioma: " + idiomas[i]);
                            System.out.println("ipl: " + ipls[i]);
                            System.out.println("-");
                            
                            
                            AlunoHasIdioma alunoidioma = new AlunoHasIdioma();
                            alunoidioma.setIdentidadeAluno(idtMilitarAl);
                            alunoidioma.setIdIdioma(Integer.parseInt(idiomas[i]));
                            alunoidioma.setIpl(String.valueOf(ipls[i]).toUpperCase());
                            alunoidiomaDAO.insert(alunoidioma);
                        }
                        System.out.println("-------------");
                        System.out.println("");
                    }
                        
                    //Verificando Tipo de Força escolhida;
                    int idTipoForca = Integer.parseInt(request.getParameter("txtTipoForca"));
                    //Forças Armadas
                    if(idTipoForca == 1){                       
                        //Formação de Origem
                        FormacaoOrigemDAO formOrigemAlunoDAO = new FormacaoOrigemDAO();
                        int idFormOrigem;                        
                        FormacaoOrigem formOrigemAluno = new FormacaoOrigem();
                        idFormOrigem = formOrigemAlunoDAO.proxID();
                        formOrigemAluno.setId(idFormOrigem);
                        formOrigemAluno.setTurma(Integer.parseInt(request.getParameter("txtFormTurma")));
                        formOrigemAluno.setIdEscolaFormacao(Integer.parseInt(request.getParameter("txtFormEscNome")));
                        formOrigemAluno.setIdentidadeAluno(idtMilitarAl);
                        
                        System.out.println("FORM ORIGEM: ");
                        System.out.println("forigemturma: " + formOrigemAluno.getTurma());
                        System.out.println("forigemescola: " + formOrigemAluno.getIdEscolaFormacao());
                        System.out.println("------------------------");
                        System.out.println("");
                        formOrigemAlunoDAO.insert(formOrigemAluno);

                        //Oms Servidas
                        AlunoServiuOMDAO alunoserviuomDAO = new AlunoServiuOMDAO();
                        if(!request.getParameter("txtSvAmz").equals("n") && !request.getParameter("txtSvAmz").equals("0")){
                            String[] omsservidas = request.getParameterValues("txtOMNomeSvAmz");
                            String[] datasinicio = request.getParameterValues("txtDInOMSvAmz");
                            String[] datasfim = request.getParameterValues("txtDFimOMSvAmz");
                            String[] ultfuncoes1 = request.getParameterValues("txtFunc1OMSvAmz");
                            String[] ultfuncoes2 = request.getParameterValues("txtFunc2OMSvAmz");
                            String[] ultfuncoes3 = request.getParameterValues("txtFunc3OMSvAmz");

                            if(omsservidas != null){
                                System.out.println("OMS SERVIDAS: ");
                                for(int i=0;i<omsservidas.length;i++){
                                    System.out.println("omserv: " + omsservidas[i]);
                                    System.out.println("dtini: " + datasinicio[i]);
                                    System.out.println("dtfim: " + datasfim[i]);
                                    System.out.println("ultf1: " + ultfuncoes1[i]);
                                    System.out.println("ultf2: " + ultfuncoes2[i]);
                                    System.out.println("ultf3: " + ultfuncoes3[i]);
                                    System.out.println("-");

                                    AlunoServiuOM alunoserviuom = new AlunoServiuOM();
                                    alunoserviuom.setIdentidadeAluno(idtMilitarAl);
                                    alunoserviuom.setIdOM(Integer.parseInt(omsservidas[i]));
                                    String dataInicioSeparada[] = String.valueOf(datasinicio[i]).split("-");
                                    Date datainicio = new Date((Integer.parseInt(dataInicioSeparada[0])-1900), (Integer.parseInt(dataInicioSeparada[1]) - 1), Integer.parseInt(dataInicioSeparada[2]));
                                    alunoserviuom.setDatainicio(datainicio);
                                    String dataFimSeparada[] = String.valueOf(datasfim[i]).split("-");
                                    Date datafim = new Date((Integer.parseInt(dataFimSeparada[0])-1900), (Integer.parseInt(dataFimSeparada[1]) - 1), Integer.parseInt(dataFimSeparada[2]));
                                    alunoserviuom.setDatafim(datafim);
                                    alunoserviuom.setUltfuncao1(ultfuncoes1[i].toUpperCase());
                                    alunoserviuom.setUltfuncao2(ultfuncoes2[i].toUpperCase());
                                    alunoserviuom.setUltfuncao3(ultfuncoes3[i].toUpperCase());
                                    alunoserviuomDAO.insert(alunoserviuom);
                                }
                                System.out.println("----------------------");
                                System.out.println("");
                            }
                        }
                        //Exército Brasileiro
                        if(idForca == 2){                                               
                            AlunoHasCursoMilitarHasCategoriaHasForcaDAO alunocursomilitarDAO = new AlunoHasCursoMilitarHasCategoriaHasForcaDAO();
                            if(!request.getParameter("txtPossuiCAperf").equals("n") && !request.getParameter("txtPossuiCAperf").equals("0")){
                                String[] cursosCAperf = request.getParameterValues("txtCAperf");
                                String[] anosCAperf = request.getParameterValues("txtAnoCAperf");
                                if(cursosCAperf != null){   
                                    System.out.println("C APERF: ");
                                    for(int i=0;i<cursosCAperf.length;i++){

                                        System.out.println("capefr: " + cursosCAperf[i]);
                                        System.out.println("anoscapefr: " + anosCAperf[i]);
                                        System.out.println("-");

                                        AlunoHasCursoMilitarHasCategoriaHasForca alunocursomilitar = new AlunoHasCursoMilitarHasCategoriaHasForca();
                                        alunocursomilitar.setIdentidadeAluno(idtMilitarAl);
                                        alunocursomilitar.setIdCursoMilitar(Integer.parseInt(cursosCAperf[i]));
                                        alunocursomilitar.setIdCategoria(idCategoriaCandidatura);
                                        alunocursomilitar.setIdForca(idForca);
                                        alunocursomilitar.setAnoconclusao(Integer.parseInt(anosCAperf[i]));
                                        alunocursomilitarDAO.insert(alunocursomilitar);
                                    }
                                    System.out.println("-------------------");
                                    System.out.println("");
                                }
                            }
                            
                            if(!request.getParameter("txtPossuiCAltEstudos").equals("n") && !request.getParameter("txtPossuiCAltEstudos").equals("0")){
                                String[] cursosAltEstudos = request.getParameterValues("txtCAltEstudos");
                                String[] anosCAltEstudos = request.getParameterValues("txtAnoCAltEstudos");
                                if(cursosAltEstudos != null){
                                    System.out.println("CALTESTUDOS: ");
                                    for(int i=0;i<cursosAltEstudos.length;i++){

                                        System.out.println("calest: " + cursosAltEstudos[i]);
                                        System.out.println("anoscalest: " + anosCAltEstudos[i]);
                                        System.out.println("-");

                                        AlunoHasCursoMilitarHasCategoriaHasForca alunocursomilitar = new AlunoHasCursoMilitarHasCategoriaHasForca();
                                        alunocursomilitar.setIdentidadeAluno(idtMilitarAl);
                                        alunocursomilitar.setIdCursoMilitar(Integer.parseInt(cursosAltEstudos[i]));
                                        alunocursomilitar.setIdCategoria(idCategoriaCandidatura);
                                        alunocursomilitar.setIdForca(idForca);
                                        alunocursomilitar.setAnoconclusao(Integer.parseInt(anosCAltEstudos[i]));  

                                        alunocursomilitarDAO.insert(alunocursomilitar);
                                    }
                                    System.out.println("----------------");
                                    System.out.println("");
                                }
                            }
                        }
                        //Marinha do Brasil e Força Aérea Brasileira
                        else{

                        }             
                    }

                    Tentativa tent = new Tentativa();
                    TentativaDAO tentDAO = new TentativaDAO();
                    int idTent = tentDAO.proxID();
                    tent.setId(idTent);
                    tentDAO.insert(tent);

                    TurmaHasAlunoDAO turmaalunoDAO = new TurmaHasAlunoDAO();
                    TurmaHasAluno turmaaluno = new TurmaHasAluno();
                    turmaaluno.setIdTurma(turmaCandidatura);
                    turmaaluno.setIdentidadeAluno(idtMilitarAl);
                    turmaaluno.setIdTentativa(idTent);
                    turmaalunoDAO.insert(turmaaluno);
                    
                    
                }                
            }catch(Exception ex){
                //e=2: erro durante realização do cadastro
                response.sendRedirect("/sgdis/restrito/candidato/candidatura.jsp?e=2");
                throw new ServletException(ex);
            }
            //e=1: cadastro sucesso
            response.sendRedirect("/sgdis/restrito/candidato/precandidatura.jsp?e=1");
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
