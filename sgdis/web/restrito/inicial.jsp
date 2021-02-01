<%-- 
    Document   : inicial
    Created on : 04/11/2019, 11:19:30
    Author     : andersondepaula
--%>

<%@page import="model.dao.MilitarHasGrupoAcessoDAO"%>
<%@page import="model.bean.GrupoAcesso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.GrupoAcessoDAO"%>
<%@page import="model.bean.Militar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Anderson de Paula Andrade Medeiros">
        
        <link rel="icon" type="image/x-icon" href="../assets/img/logo_sgdis.png" />
        <title>SGDIS</title>
        
        <link rel="stylesheet" type="text/css" href="../assets/node_modules/bootstrap/compiler/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo_universal.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo_cadastroCurso.css">
        
        <script type='text/javascript' src='../dwr/engine.js'></script>
        <script type='text/javascript' src='../dwr/interface/FacadeAjax.js'></script>
        <script type='text/javascript' src='../dwr/util.js'></script> 
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-success">
                <a class="navbar-brand active" href="../restrito/inicial.jsp"><img src="../assets/img/logo_sgdis.png" width="30px" height="35px"><span class="sr-only">SGDis</span></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerSgdis" aria-controls="navbarTogglerSgdis" aria-expanded="false" aria-label="Alterna navegação">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarTogglerSgdis">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">          
                        <%
                            HttpSession sessao = request.getSession();
                            Militar militarLogado = (Militar) sessao.getAttribute("militarAutenticado");
                            MilitarHasGrupoAcessoDAO milgrpacessoDAO = new MilitarHasGrupoAcessoDAO();
                            ArrayList<GrupoAcesso> grpsacesso = milgrpacessoDAO.getGruposAcesso(militarLogado.getIdentidade());
                            for(GrupoAcesso ga : grpsacesso){
                                if(ga.getId() == 1){
                                    out.println(
                                                "<li class=\"nav-item dropdown\">"+
                                                    "<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"+
                                                        "Usuários"+
                                                    "</a>"+
                                                    "<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">"+                                
                                                        "<a class=\"dropdown-item\" href=\"../restrito/usuario/ativos.jsp\">Listar Usuários Ativos</a>"+
                                                        "<a class=\"dropdown-item\" href=\"../restrito/usuario/inativos.jsp\">Listar Usuários Inativos</a>"+
                                                        "<div class=\"dropdown-divider\"></div>"+
                                                        "<a class=\"dropdown-item\" href=\"../restrito/usuario/cadastro.jsp\">Novo Usuário</a>"+
                                                    "</div>"+                                                    
                                                "</li>"
                                                );
                                }                            
                                else if(ga.getId() == 2){
                                    out.println(
                                                "<li class=\"nav-item\">"+
                                                    "<a class=\"nav-link\" href=\"../restrito/avaliacao/avpreliminar.jsp\">Avaliações Preliminares</a>"+
                                                "</li>"+
                                                "<li class=\"nav-item dropdown\">"+
                                                    "<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"+
                                                        "STE"+
                                                    "</a>"+
                                                    "<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">"+                                
                                                        "<a class=\"dropdown-item\" href=\"../restrito/curso.jsp\">Curso</a>"+
                                                        "<div class=\"dropdown-divider\"></div>"+
                                                        "<a class=\"dropdown-item\" href=\"../restrito/gradeCurricular.jsp\">Grade Curricular</a>"+
                                                    "</div>"+
                                                "</li>"+                                       
                                                "<li class=\"nav-item dropdown\">"+
                                                    "<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"+
                                                        "Relatórios"+
                                                    "</a>"+
                                                    "<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">"+                                
                                                        "<a class=\"dropdown-item\" data-toggle=\"modal\" data-target=\"#modalFormGRelaAvlPreliminar\">Avaliação Preliminar</a>"+
                                                        
                                                    "</div>"+
                                                "</li>");                                        
                                                    
                                }
                                else if(ga.getId() == 3){
                                    out.println(
                                                "<li class=\"nav-item\">"+
                                                    "<a class=\"nav-link\" href=\"../restrito/avaliacao/avpreliminar.jsp\">Avaliações Preliminares</a>"+
                                                "</li>"+
                                                "<li class=\"nav-item dropdown\">"+
                                                    "<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"+
                                                        "DivAl"+
                                                    "</a>"+
                                                    "<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">"+
                                                        "<a class=\"dropdown-item\" href=\"../restrito/curso/curso.jsp\">Curso</a>"+
                                                        "<a class=\"dropdown-item\" href=\"../restrito/turma/turma.jsp\">Turma</a>"+
                                                        "<a class=\"dropdown-item\" href=\"../restrito/candidato/precandidatura.jsp\">Cadastrar Candidato</a>"+
                                                    "</div>"+
                                                "</li>");                        
                                }
                                else if(ga.getId() == 4){
                                    out.println("<li class=\"nav-item\">"+
                                                    "<a class=\"nav-link\" href=\"../restrito/avaliacao/avpreliminar.jsp\">Avaliações Preliminares</a>"+
                                                "</li>");
                                }
                                else if(ga.getId() == 5){
                                    out.println("<li class=\"nav-item\">"+
                                                    "<a class=\"nav-link\" href=\"../restrito/avaliacao/avpreliminar.jsp\">Avaliações Preliminares</a>"+
                                                "</li>");
                                }
                            }
                        %>   
                    </ul>
                    <form class="form-inline my-2 my-lg-0" name="formSair" action="Sair" method="POST">                  
                        <button class="btn btn-danger my-2 my-sm-0" type="submit">Sair</button>
                    </form>
                </div>
                
                <!-- Modal Atualizar-->
                <div class="modal fade" id="modalFormGRelaAvlPreliminar" tabindex="-1" role="dialog" aria-labelledby="modalFormGRelaAvlPreliminar" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title title" id="modalFormGRelaAvlPreliminar">Novo Curso</h5>
                                <button type="button" name="btnFecharFormGRelaAvlPreliminar" class="close" data-dismiss="modal" aria-label="Fechar">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">                            
                                <form class="container-fluid" action="controller.relatorio/GerarRelatorioAvlPreliminar" method="POST" name="formGRelaAvlPreliminar">
                                    <div class="form-row">
                                        <div class="form-group col-md-4">
                                            <label for="txtCurso">Curso: <span class="campo-obrigatorio">*</span></label>
                                            <select class="form-control" id="txtCurso" name="txtCurso">
                                                <option value="0" selected>Selecione um Curso...</option>                                    
                                            </select>
                                            <div class="valid-feedback">Selva!</div>
                                            <div class="invalid-feedback">Campo Obrigatório!</div>
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="txtCategoria">Categoria: <span class="campo-obrigatorio">*</span></label>
                                            <select class="form-control" id="txtCategoria" name="txtCategoria">
                                                <option value="0" selected>Selecione uma Categoria...</option>                                    
                                            </select>
                                            <div class="valid-feedback">Selva!</div>
                                            <div class="invalid-feedback">Campo Obrigatório!</div>
                                        </div>
                                        <div class="form-group col-md-4">
                                            <label for="txtTurma">Turma: <span class="campo-obrigatorio">*</span></label>
                                            <select class="form-control" id="txtTurma" name="txtTurma">
                                                <option value="0" selected>Selecione uma Turma...</option>                                    
                                            </select>
                                            <div class="valid-feedback">Selva!</div>
                                            <div class="invalid-feedback">Campo Obrigatório!</div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="form-group col-md-12">
                                            <label for="txtAvaliacao">Avaliação: <span class="campo-obrigatorio">*</span></label>
                                            <select class="form-control" id="txtAvaliacao" name="txtAvaliacao">
                                                <option value="0" selected>Selecione uma Avaliação...</option>
                                                <option value="3">TESTE DE CONHECIMENTO MILITAR</option>                                                     
                                                <option value="4">EXAME DE APTIDÃO FÍSICA</option>
                                                <option value="1">AVALIAÇÃO PSICOLÓGICA</option>
                                                <option value="2">INSPEÇÃO DE SAÚDE</option>                                                      
                                            </select>
                                            <div class="valid-feedback">Selva!</div>
                                            <div class="invalid-feedback">Campo Obrigatório!</div>
                                        </div>
                                    </div>
                                    <button type="button" name="btnLimpar" class="btn btn-warning">Limpar</button>
                                    <button type="submit" name="btnGerarRelatorioAvlPreliminar" class="btn btn-success">Gerar Relatório</button>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" name="btnFechar" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
        </header>
        
        <section class="container-fluid">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
        </section>
        
        <footer class="container-fluid bg-success text-center fixed-bottom">
            <b>Anderson de Paula Andrade Medeiros</b><br>
            <b class="text-center copy">&copy; 2019-2020</b>
        </footer>
        
        <script src="../assets/node_modules/jquery/dist/jquery.js"></script>
        <script src="../assets/node_modules/popper.js/dist/popper.js"></script>
        <script src="../assets/node_modules/bootstrap/dist/js/bootstrap.js"></script>
        
        <script src="../assets/js/dwr/avaliacao/avpreliminar/camposDinamicos.js"></script>
        
        
        <script src="../assets/js/formulario/validacao/relatorio/avpreliminar/funcoesImportantes.js"></script>
        <script src="../assets/js/formulario/validacao/relatorio/avpreliminar/avaliacao.js"></script>
        <script src="../assets/js/formulario/validacao/relatorio/avpreliminar/pesqalunobyturma.js"></script>
    </body>
</html>
