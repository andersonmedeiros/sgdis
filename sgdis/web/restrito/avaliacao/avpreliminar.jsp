<%-- 
    Document   : avpreliminar
    Created on : 03/08/2020, 10:05:42
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
                        <li class="nav-item">
                            <a class="nav-link active" href="../restrito/avaliacao/avpreliminar.jsp">Avaliações Preliminares</a>
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
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
                                            out.println("<a class=\"dropdown-item\" href=\"../../restrito/avaliacao/psico.jsp\">Avaliação Psicológica</a>");
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
                        <h5 class="fieldset-title">Avaliação</h5>
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
                            <div class="form-group col-md-12">
                                <label for="txtAvaliacao">Avaliação: <span class="campo-obrigatorio">*</span></label>
                                <select class="form-control" id="txtAvaliacao" name="txtAvaliacao">
                                    <option value="0" selected>Selecione uma Avaliação...</option>                                    
                                    <option value="1">AVALIAÇÃO PSICOLÓGICA</option>                                    
                                    <option value="2">INSPEÇÃO DE SAÚDE</option>                                    
                                    <option value="3">TESTE DE CONHECIMENTO MILITAR</option>                                    
                                    <option value="4">EXAME DE APTIDÃO FÍSICA</option>                                    
                                </select>
                                <div class="valid-feedback">Selva!</div>
                                <div class="invalid-feedback">Campo Obrigatório!</div>
                            </div>
                        </div>
                        <div class="form-row">                            
                               <button type="button" id="btn" name="btnPesquisar" class="btn btn-warning btn-pesquisar" value="Pesquisar">Pesquisar</button>
                        </div>                        
                        <div class="header-interno">
                            <h5 class="title-interno"></h5>
                        </div>
                        <div class="fieldset-interno">
                            
                                <table id="avl" class="table">
                                    <thead class="thead-light text">
                                        <tr>                                 
                                        </tr>
                                    </thead>
                                    <tbody id="candidatos"></tbody>
                                </table>
                                                       
                        </div>
                    </div>                    
                </fieldset>                
            </form>
            
            <!-- Modal AvlPsico-->
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
                            <form class="container-fluid" name="formAvlPsico" method="post" action="controller.avaliacao.avpreliminar/CadastrarAvaliacao">      
                                <input type="hidden" id="txtIdTurma" name="txtIdTurma" readonly>
                                <input type="hidden" id="txtAvlPsico" name="txtAvlPsico" readonly>
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
                                        <input type="text" class="form-control" id="txtNomeGuerraAl" name="txtNomeGuerraAl" placeholder="Ex.: DE TAL" readonly="">
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
            
            <!-- Modal TCM-->
            <div class="modal fade" id="modalFormTCM" tabindex="-1" role="dialog" aria-labelledby="modalFormTCM" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title title" id="modalFormTCM">Avaliação Psicológica</h5>
                            <button type="button" name="btnFecharTCM" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">                            
                            <form class="container-fluid" name="formTCM" method="post" action="controller.avaliacao.avpreliminar/CadastrarAvaliacao">      
                                <input type="hidden" id="txtIdTurma" name="txtIdTurmaTCM" readonly>
                                <input type="hidden" id="txtAvl" name="txtAvlTCM" readonly>
                                <div class="form-row">
                                    <div class="form-group col-md-4">
                                        <label for="txtIdentidadeAlTCM">Identidade Militar: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtIdentidadeAlTCM" name="txtIdentidadeAlTCM" placeholder="Ex.: 1200000000" readonly="">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback invalid-identidadeAl">Campo Obrigatório!</div>
                                    </div>                                   
                                    <div class="form-group col-md-4">
                                        <label for="txtPGradAlTCM">Posto/Graduação: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtPGradAlTCM" name="txtPGradAlTCM" placeholder="Ex.: 1º TEN" readonly="">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>                                   
                                    <div class="form-group col-md-4">
                                        <label for="txtNomeGuerraAlTCM">Nome de Guerra: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtNomeGuerraAlTCM" name="txtNomeGuerraAlTCM" placeholder="Ex.: DE TAL" readonly="">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>                                   
                                </div>
                                
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label for="txtTCMT">Teste de Conhecimento Militar Teórico: <span class="campo-obrigatorio">*</span></label>
                                        <input type="number" step="0.01" min="0" class="form-control" id="txtTCMT" name="txtTCMT" placeholder="Ex.: 5.00">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label for="txtTCMP">Teste de Conhecimento Militar Prático: <span class="campo-obrigatorio">*</span></label>
                                        <input type="number" step="0.01" min="0" class="form-control" id="txtTCMP" name="txtTCMP" placeholder="Ex.: 5.00">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                            
                                
                                <button type="button" name="btnLimparTCM" class="btn btn-warning">Limpar</button>
                                <button type="submit" name="btnSalvarTCM" class="btn btn-success">Salvar</button>
                            </form>
                        </div>
                    </div>
                        <div class="modal-footer">
                            <button type="button" name="btnFecharTCM" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                        </div>
                </div>
            </div>
            
            <!-- Modal Eaf 1ª Tentativa-->
            <div class="modal fade" id="modalFormEafTent1" tabindex="-1" role="dialog" aria-labelledby="modalFormEafTent1" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title title" id="modalFormEafTent1">Exame de Aptidão Física</h5>
                            <button type="button" name="btnFecharEafTent1" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">                            
                            <form class="container-fluid" name="formEafTent1" method="post" action="controller.avaliacao.avpreliminar/CadastrarAvaliacao">      
                                <input type="hidden" id="txtIdTurmaEafTent1" name="txtIdTurmaEafTent1" readonly>
                                <input type="hidden" id="txtAvlEafTent1" name="txtAvlEafTent1" readonly>
                                <div class="form-row">
                                    <div class="form-group col-md-4">
                                        <label for="txtIdentidadeAlEafTent1">Identidade Militar: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtIdentidadeAlEafTent1" name="txtIdentidadeAlEafTent1" placeholder="Ex.: 1200000000" readonly="">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback invalid-identidadeAl">Campo Obrigatório!</div>
                                    </div>                                   
                                    <div class="form-group col-md-4">
                                        <label for="txtPGradAlEafTent1">Posto/Graduação: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtPGradAlEafTent1" name="txtPGradAlEafTent1" placeholder="Ex.: 1º TEN" readonly="">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>                                   
                                    <div class="form-group col-md-4">
                                        <label for="txtNomeGuerraAlEafTent1">Nome de Guerra: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtNomeGuerraAlEafTent1" name="txtNomeGuerraAlEafTent1" placeholder="Ex.: DE TAL" readonly="">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>                                   
                                </div>
                                
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label for="txtSexoEafTent1">Sexo: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtSexoEafTent1" name="txtSexoEafTent1">
                                            <option value="0" selected>Selecione uma Opção...</option>
                                            <option value="M">MASCULINO</option>
                                            <option value="F">FEMININO</option>
                                        </select>
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label for="txtCorridaEafTent1">Corrida 8KM: <span class="campo-obrigatorio">*</span></label>
                                        <input type="time" step="1" class="form-control" id="txtCorridaEafTent1" name="txtCorridaEafTent1" placeholder="Min">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>                                  
                                    <div class="form-group col-md-3">
                                        <label for="txtAbdSupraEafTent1">Abdominal Supra: <span class="campo-obrigatorio">*</span></label>
                                        <input type="number" min="0" class="form-control" id="txtAbdSupraEafTent1" name="txtAbdSupraEafTent1" placeholder="Ex.: 68">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="txtFlexaoBracoEafTent1">Flexão de Braço: <span class="campo-obrigatorio">*</span></label>
                                        <input type="number" min="0" class="form-control" id="txtFlexaoBracoEafTent1" name="txtFlexaoBracoEafTent1" placeholder="Ex.: 35">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                    <div class="form-group col-md-3" id="div-barra-masc" style="display: none;">
                                        <label for="txtFlexaoBarraEafTent1">Flexão na barra: <span class="campo-obrigatorio">*</span></label>
                                        <input type="number" min="0" class="form-control" id="txtFlexaoBarraEafTent1" name="txtFlexaoBarraEafTent1" placeholder="Ex.: 35">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                    <div class="form-group col-md-3" id="div-barra-fem" style="display: none;">
                                        <label for="txtSuspBarraEafTent1">Suspensão na barra: <span class="campo-obrigatorio">*</span></label>
                                        <input type="time" step="1" class="form-control" id="txtSuspBarraEafTent1" name="txtSuspBarraEafTent1" placeholder="Ex.: ">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="txtNadoSubmersoEafTent1">Nado Submerso: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtNadoSubmersoEafTent1" name="txtNadoSubmersoEafTent1">
                                            <option value="0" selected>Selecione uma Opção...</option>
                                            <option value="1">APTO</option>
                                            <option value="2">INAPTO</option>
                                        </select>
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="txtCordaVerticalEafTent1">Subida na Corda Vertical: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtCordaVerticalEafTent1" name="txtCordaVerticalEafTent1">
                                            <option value="0" selected>Selecione uma Opção...</option>
                                            <option value="1">APTO</option>
                                            <option value="2">INAPTO</option>
                                        </select>
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="txtPPMEafTent1">Pista de Pentatlo Militar (PPM): <span class="campo-obrigatorio">*</span></label>
                                        <input type="time" step="1" class="form-control" id="txtPPMEafTent1" name="txtPPMEafTent1" placeholder="Ex.: ">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="txtNatUtl">Natação Utilitária de 400M: <span class="campo-obrigatorio">*</span></label>
                                        <input type="time" step="1" class="form-control" id="txtNatUtl" name="txtNatUtlEafTent1" placeholder="Ex.: ">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="txtFlutuacaoEafTent1">Flutuação: <span class="campo-obrigatorio">*</span></label>
                                        <input type="time" step="1" class="form-control" id="txtFlutuacaoEafTent1" name="txtFlutuacaoEafTent1" placeholder="Ex.: ">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="txtMarchaEafTent1">Marcha de 15KM: <span class="campo-obrigatorio">*</span></label>
                                        <input type="time" step="1" class="form-control" id="txtMarchaEafTent1" name="txtMarchaEafTent1" placeholder="Ex.: ">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                
                                <button type="button" name="btnLimparEafTent1" class="btn btn-warning">Limpar</button>
                                <button type="submit" name="btnSalvarEafTent1" class="btn btn-success">Salvar</button>
                            </form>
                        </div>
                    </div>
                        <div class="modal-footer">
                            <button type="button" name="btnFecharEafTent1" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                        </div>
                </div>
            </div>
            <!-- Modal Eaf 2ª Tentativa-->
            <div class="modal fade" id="modalFormEafTent2" tabindex="-1" role="dialog" aria-labelledby="modalFormEafTent2" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title title" id="modalFormEafTent2">Exame de Aptidão Física</h5>
                            <button type="button" name="btnFecharEafTent2" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">                            
                            <form class="container-fluid" name="formEafTent2" method="post" action="controller.avaliacao.avpreliminar/CadastrarAvaliacao">      
                                <input type="hidden" id="txtIdTurmaEafTent2" name="txtIdTurmaEafTent2" readonly>
                                <input type="hidden" id="txtAvlEafTent2" name="txtAvlEafTent2" readonly>
                                <div class="form-row">
                                    <div class="form-group col-md-4">
                                        <label for="txtIdentidadeAlEafTent2">Identidade Militar: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtIdentidadeAlEafTent2" name="txtIdentidadeAlEafTent2" placeholder="Ex.: 1200000000" readonly="">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback invalid-identidadeAl">Campo Obrigatório!</div>
                                    </div>                                   
                                    <div class="form-group col-md-4">
                                        <label for="txtPGradAlEafTent2">Posto/Graduação: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtPGradAlEafTent2" name="txtPGradAlEafTent2" placeholder="Ex.: 1º TEN" readonly="">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>                                   
                                    <div class="form-group col-md-4">
                                        <label for="txtNomeGuerraAlEafTent2">Nome de Guerra: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtNomeGuerraAlEafTent2" name="txtNomeGuerraAlEafTent2" placeholder="Ex.: DE TAL" readonly="">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>                                   
                                </div>
                                
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label for="txtSexoEafTent2">Sexo: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtSexoEafTent2" name="txtSexoEafTent2">
                                            <option value="0" selected>Selecione uma Opção...</option>
                                            <option value="M">MASCULINO</option>
                                            <option value="F">FEMININO</option>
                                        </select>
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row" id="div-eaf-tent2-10" style="display: none;">
                                    <div class="form-group col-md-12">
                                        <label for="txtCorridaEafTent2">Corrida 8KM: <span class="campo-obrigatorio">*</span></label>
                                        <input type="time" step="1" class="form-control" id="txtCorridaEafTent2" name="txtCorridaEafTent2" placeholder="Min">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row" id="div-eaf-tent2-11" style="display: none;">
                                    <div class="form-group col-md-12">
                                        <label for="txtAbdSupraEafTent2">Abdominal Supra: <span class="campo-obrigatorio">*</span></label>
                                        <input type="number" min="0" class="form-control" id="txtAbdSupraEafTent2" name="txtAbdSupraEafTent2" placeholder="Ex.: 68">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row" id="div-eaf-tent2-12" style="display: none;">
                                    <div class="form-group col-md-12">
                                        <label for="txtFlexaoBracoEafTent2">Flexão de Braço: <span class="campo-obrigatorio">*</span></label>
                                        <input type="number" min="0" class="form-control" id="txtFlexaoBracoEafTent2" name="txtFlexaoBracoEafTent2" placeholder="Ex.: 35">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row" id="div-eaf-tent2-13" style="display: none;">
                                    <div class="form-group col-md-12">
                                        <label for="txtFlexaoBarraEafTent2">Flexão na barra: <span class="campo-obrigatorio">*</span></label>
                                        <input type="number" min="0" class="form-control" id="txtFlexaoBarraEafTent2" name="txtFlexaoBarraEafTent2" placeholder="Ex.: 35">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row" id="div-eaf-tent2-14" style="display: none;">
                                    <div class="form-group col-md-12">
                                        <label for="txtSuspBarraEafTent2">Suspensão na barra: <span class="campo-obrigatorio">*</span></label>
                                        <input type="time" step="1" class="form-control" id="txtSuspBarraEafTent2" name="txtSuspBarraEafTent2" placeholder="Ex.: ">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row" id="div-eaf-tent2-15" style="display: none;">
                                    <div class="form-group col-md-12">
                                        <label for="txtNadoSubmersoEafTent2">Nado Submerso: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtNadoSubmersoEafTent2" name="txtNadoSubmersoEafTent2">
                                            <option value="0" selected>Selecione uma Opção...</option>
                                            <option value="1">APTO</option>
                                            <option value="2">INAPTO</option>
                                        </select>
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row" id="div-eaf-tent2-16" style="display: none;">
                                    <div class="form-group col-md-12">
                                        <label for="txtCordaVerticalEafTent2">Subida na Corda Vertical: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtCordaVerticalEafTent2" name="txtCordaVerticalEafTent2">
                                            <option value="0" selected>Selecione uma Opção...</option>
                                            <option value="1">APTO</option>
                                            <option value="2">INAPTO</option>
                                        </select>
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row" id="div-eaf-tent2-17" style="display: none;">
                                    <div class="form-group col-md-12">
                                        <label for="txtPPMEafTent2">Pista de Pentatlo Militar (PPM): <span class="campo-obrigatorio">*</span></label>
                                        <input type="time" step="1" class="form-control" id="txtPPMEafTent2" name="txtPPMEafTent2" placeholder="Ex.: ">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row" id="div-eaf-tent2-18" style="display: none;">
                                    <div class="form-group col-md-12">
                                        <label for="txtNatUtl">Natação Utilitária de 400M: <span class="campo-obrigatorio">*</span></label>
                                        <input type="time" step="1" class="form-control" id="txtNatUtl" name="txtNatUtlEafTent2" placeholder="Ex.: ">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row" id="div-eaf-tent2-19" style="display: none;">
                                    <div class="form-group col-md-12">
                                        <label for="txtFlutuacaoEafTent2">Flutuação: <span class="campo-obrigatorio">*</span></label>
                                        <input type="time" step="1" class="form-control" id="txtFlutuacaoEafTent2" name="txtFlutuacaoEafTent2" placeholder="Ex.: ">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row" id="div-eaf-tent2-20" style="display: none;">
                                    <div class="form-group col-md-12">
                                        <label for="txtMarchaEafTent2">Marcha de 15KM: <span class="campo-obrigatorio">*</span></label>
                                        <input type="time" step="1" class="form-control" id="txtMarchaEafTent2" name="txtMarchaEafTent2" placeholder="Ex.: ">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                
                                <button type="button" name="btnLimparEafTent2" class="btn btn-warning">Limpar</button>
                                <button type="submit" name="btnSalvarEafTent2" class="btn btn-success">Salvar</button>
                            </form>
                        </div>
                    </div>
                        <div class="modal-footer">
                            <button type="button" name="btnFecharEafTent2" class="btn btn-danger" data-dismiss="modal">Fechar</button>
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
        
        <script src="../../assets/js/dwr/avaliacao/avpreliminar/camposDinamicos.js"></script>
        <script src="../../assets/js/dwr/avaliacao/avpreliminar/tabelaDinamica.js"></script>
        <script src="../../assets/js/formulario/validacao/avaliacao/avpreliminar/funcoesImportantes.js"></script>
        <script src="../../assets/js/formulario/validacao/avaliacao/avpreliminar/pesqalunobyturma.js"></script>
        <script src="../../assets/js/formulario/validacao/avaliacao/avpreliminar/avaliacao.js"></script>
        
        <script src="../../assets/js/bootstrap-validate.js"></script>
    </body>
</html>