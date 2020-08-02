<%-- 
    Document   : avaliacaopsico
    Created on : 14/07/2020, 14:15:34
    Author     : CB Anderson de Paula Andrade Medeiros
--%>

<%@page import="model.bean.GrupoAcesso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.MilitarHasGrupoAcessoDAO"%>
<%@page import="model.bean.Militar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Anderson de Paula Andrade Medeiros">
        
        <link rel="icon" type="image/x-icon" href="../../assets/img/logo_sgdis.png" />
        <title>Cadastro de Candidato</title>
        
        <link rel="stylesheet" type="text/css" href="../../assets/node_modules/bootstrap/compiler/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="../../assets/css/estilo_universal.css">
        <link rel="stylesheet" type="text/css" href="../../assets/css/estilo_formulario_etapas.css">
        <link rel="stylesheet" type="text/css" href="../../assets/css/avaliacao/psico/estiloavlpsico.css">
        
        <script type='text/javascript' src='../../dwr/engine.js'></script>
        <script type='text/javascript' src='../../dwr/interface/FacadeAjax.js'></script>
        <script type='text/javascript' src='../../dwr/util.js'></script>     
        
        <script src="../../assets/js/dwr/avaliacao/psico/tabelaDinamica.js"></script>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-success">
                <a class="navbar-brand active" href="../../restrito/inicial.jsp"><img src="../../assets/img/logo_sgdis.png" width="30px" height="35px"><span class="sr-only">SGDis</span></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerSgdis" aria-controls="navbarTogglerSgdis" aria-expanded="false" aria-label="Alterna navegação">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarTogglerSgdis">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">          
                        <li class="nav-item">
                            <a class="nav-link" href="../../restrito/cursos.jsp">Cursos</a>
                        </li>
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
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/usuario/ativos.jsp\">Listar Usuários Ativos</a>"+
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/usuario/inativos.jsp\">Listar Usuários Inativos</a>"+
                                                        "<div class=\"dropdown-divider\"></div>"+
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/usuario/cadastro.jsp\">Novo Usuário</a>"+
                                                    "</div>"+                                                    
                                                "</li>"
                                                );
                                }
                            }
                        %>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Avaliações
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <%
                                    for(GrupoAcesso ga : grpsacesso){                                        
                                        if(ga.getId() == 2){
                                            out.println("<a class=\"dropdown-item\" href=\"../../restrito/curso.jsp\">Teste de Conhecimento Militar</a>");
                                        }
                                        else if(ga.getId() == 3){                                            
                                            out.println("<a class=\"dropdown-item\" href=\"../../restrito/curso.jsp\">Exame de Aptidão Física</a>");
                                        }
                                        else if(ga.getId() == 4){
                                            out.println("<a class=\"dropdown-item active\" href=\"../../restrito/avaliacao/psico.jsp\">Avaliação Psicológica</a>");
                                        }
                                    }
                                %>
                            </div>
                        </li>
                        <%

                            for(GrupoAcesso ga : grpsacesso){
                                if(ga.getId() == 2){
                                    out.println(
                                                "<li class=\"nav-item dropdown\">"+
                                                    "<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"+
                                                        "STE"+
                                                    "</a>"+
                                                    "<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">"+                                
                                                        "<a class=\"dropdown-item\" href=\"../restrito/curso.jsp\">Curso</a>"+
                                                        "<div class=\"dropdown-divider\"></div>"+
                                                        "<a class=\"dropdown-item\" href=\"../restrito/gradeCurricular.jsp\">Grade Curricular</a>"+
                                                    "</div>"+
                                                "</li>");                                        
                                                    
                                }
                                else if(ga.getId() == 3){
                                    out.println(
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
                                    out.println();
                                }
                            }
                        %>   
                    </ul>
                    <form class="form-inline my-2 my-lg-0" name="formSair" action="Sair" method="POST">                  
                        <button class="btn btn-danger my-2 my-sm-0" type="submit">Sair</button>
                    </form>
                </div>
            </nav>
        </header>
        
        <section class="container-fluid col-md-10 mr-auto ml-auto area">
            <div class="">
                <%
                    if(request.getParameter("e") != null){
                        int retorno = Integer.parseInt(request.getParameter("e"));

                        if(retorno == 1){
                            out.println("<div class=\"alert alert-success shadow-sm text-center\" role=\"alert\">");
                            out.println("       Avaliação realizada com sucesso!");
                            out.println("</div>");
                        }
                        else if(retorno == 2){
                            out.println("<div class=\"alert alert-danger shadow-sm text-center\" role=\"alert\">");
                            out.println("       Erro durante a realização da avaliação de candidato.<br>Tente Novamente!");
                            out.println("</div>");
                        }
                    }
                %>
            </div>
            
            <form id="formPesqAlunosTurma" class="form formCad">
                <fieldset>
                    <div class="fieldset-header">
                        <h5 class="fieldset-title">Avaliação Psicológica</h5>
                    </div>
                    <div class="fieldset-body">
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
                               <button type="button" id="btn" name="btnPesquisar" class="btn btn-warning btn-pesquisar" value="Pesquisar">Pesquisar</button>
                        </div>                        
                        <div class="header-interno">
                            <h5 class="title-interno">Aluno</h5>
                        </div>
                        <div class="fieldset-interno">
                            
                                <table class="table">
                                    <thead class="thead-light text">
                                        <tr>
                                            <th scope="col">IDENTIDADE</th>
                                            <th scope="col">MILITAR</th>
                                            <th scope="col">AVALIAÇÃO</th>
                                            <th scope="col">AÇÃO</th>                                       
                                        </tr>
                                    </thead>
                                    <tbody id="candidatos"></tbody>
                                </table>
                                                       
                        </div>
                    </div>                    
                </fieldset>                
            </form>
            
            <!-- Modal Cadastro-->
            <div class="modal fade" id="modalFormAvlPsico" tabindex="-1" role="dialog" aria-labelledby="modalFormAvlPsico" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title title" id="modalFormAvlPsico">Avaliação Psicológica</h5>
                            <button type="button" name="btnFecharAvlPsico" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">                            
                            <form class="container-fluid" name="formAvlPsico" method="post" action="controller.avaliacao.psico/CadastrarAvlPsico">      
                                <input type="hidden" id="txtIdTurma" name="txtIdTurma" readonly="">
                                <div class="form-row">
                                    <div class="form-group col-md-4">
                                        <label for="txtIdentidadeAl">Identidade Militar: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtIdentidadeAl" name="txtIdentidadeAl" placeholder="Ex.: 1200000000" readonly="">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback invalid-identidadeAl">Campo Obrigatório!</div>
                                    </div>                                   
                                    <div class="form-group col-md-4">
                                        <label for="txtPGradAl">Posto/Graduação: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtPGradAl" name="txtPGradAl" placeholder="Ex.: 1º TEN" readonly="">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>                                   
                                    <div class="form-group col-md-4">
                                        <label for="txtNomeGuerraAl">Nome de Guerra: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtNomeGuerraAl" name="txtNomeGuerraAl" placeholder="DE TAL" readonly="">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>                                   
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label for="txtSitAvlPsico">Situação: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtSitAvlPsico" name="txtSitAvlPsico">
                                            <option value="0" selected>Selecione uma Situação...</option>
                                            <option value="1">Indicado</option>
                                            <option value="2">Indicado com Restrição</option>
                                            <option value="3">Inapto</option>
                                        </select>
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>               
                                </div>
                                <div id="div-rtoavlpsico" style="display: none;">
                                    <div class="form-row">
                                        <div class="form-group col-md-12">
                                            <label for="txtRtoAvlPsico">Restrição: <span class="campo-obrigatorio">*</span></label>
                                            <input type="text" class="form-control" id="txtRtoAvlPsico" name="txtRtoAvlPsico" placeholder="Ex.: Com problema tal">
                                            <div class="valid-feedback">Selva!</div>
                                            <div class="invalid-feedback">Campo Obrigatório!</div>
                                        </div>
                                    </div>
                                </div>
                                
                                <button type="button" name="btnLimparAvlPsico" class="btn btn-warning">Limpar</button>
                                <button type="submit" name="btnSalvarAvlPsico" class="btn btn-success">Salvar</button>
                                
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" name="btnFecharAvlPsico" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
            
            
        
        <footer class="container-fluid bg-success text-center fixed-bottom">
            <b>Desenvolvido por Anderson de Paula Andrade Medeiros</b><br>
            <b class="text-center copy">&copy;2019-2020</b>
        </footer>
        
        <script src="../../assets/node_modules/jquery/dist/jquery.js"></script>
        <script src="../../assets/node_modules/popper.js/dist/popper.js"></script>
        <script src="../../assets/node_modules/bootstrap/dist/js/bootstrap.js"></script>
        
        <script src="../../assets/js/formulario/validacao/mascaras.js"></script>
        
        <script src="../../assets/js/dwr/avaliacao/psico/camposDinamicos.js"></script>
        <script src="../../assets/js/formulario/validacao/avaliacao/psico/funcoesImportantes.js"></script>
        <script src="../../assets/js/formulario/validacao/avaliacao/psico/pesqalunobyturma.js"></script>
        <script src="../../assets/js/formulario/validacao/avaliacao/psico/avaliacaopsico.js"></script>
        
        <script src="../../assets/js/bootstrap-validate.js"></script>
    </body>
</html>
