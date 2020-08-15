<%-- 
    Document   : cadastro
    Created on : 01/08/2020, 11:27:25
    Author     : CB Anderson de Paula Andrade Medeiros
--%>

<%@page import="model.dao.GrupoAcessoDAO"%>
<%@page import="model.bean.GrupoAcesso"%>
<%@page import="model.dao.MilitarHasGrupoAcessoDAO"%>
<%@page import="model.bean.Militar"%>
<%@page import="model.bean.CursoHasCategoria"%>
<%@page import="model.dao.CursoHasCategoriaDAO"%>
<%@page import="model.dao.CategoriaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Curso"%>
<%@page import="model.dao.CursoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Anderson de Paula Andrade Medeiros">
        
        <link rel="icon" type="image/x-icon" href="../../assets/img/logo_sgdis.png" />
        <title>Usuário</title>
        
        <link rel="stylesheet" type="text/css" href="../../assets/node_modules/bootstrap/compiler/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="../../assets/css/estilo_universal.css">
        <link rel="stylesheet" type="text/css" href="../../assets/css/usuario/estiloCadastro.css">
        <link rel="stylesheet" type="text/css" href="../../assets/css/estilo_cadastroCurso.css">   
        
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
                        <%
                            HttpSession sessao = request.getSession();
                            Militar militarLogado = (Militar) sessao.getAttribute("militarAutenticado");
                            MilitarHasGrupoAcessoDAO milgrpacessoDAO = new MilitarHasGrupoAcessoDAO();
                            ArrayList<GrupoAcesso> grpsacesso = milgrpacessoDAO.getGruposAcesso(militarLogado.getIdentidade());
                            for(GrupoAcesso ga : grpsacesso){
                                if(ga.getId() == 1){
                                    out.println(
                                                "<li class=\"nav-item dropdown\">"+
                                                    "<a class=\"nav-link dropdown-toggle active\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"+
                                                        "Usuários"+
                                                    "</a>"+
                                                    "<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">"+                                
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/usuario/ativos.jsp\">Listar Usuários Ativos</a>"+
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/usuario/inativos.jsp\">Listar Usuários Inativos</a>"+
                                                        "<div class=\"dropdown-divider\"></div>"+
                                                        "<a class=\"dropdown-item active\" href=\"../../restrito/usuario/cadastro.jsp\">Novo Usuário</a>"+
                                                    "</div>"+                                                    
                                                "</li>"
                                                );
                                }                            
                                else if(ga.getId() == 2){
                                    out.println(
                                                "<li class=\"nav-item\">"+
                                                    "<a class=\"nav-link\" href=\"../../restrito/avaliacao/avpreliminar.jsp\">Avaliações Preliminares</a>"+
                                                "</li>"+
                                                "<li class=\"nav-item dropdown\">"+
                                                    "<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"+
                                                        "STE"+
                                                    "</a>"+
                                                    "<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">"+                                
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/curso.jsp\">Curso</a>"+
                                                        "<div class=\"dropdown-divider\"></div>"+
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/gradeCurricular.jsp\">Grade Curricular</a>"+
                                                    "</div>"+
                                                "</li>");                                        
                                                    
                                }
                                else if(ga.getId() == 3){
                                    out.println(
                                                "<li class=\"nav-item\">"+
                                                    "<a class=\"nav-link\" href=\"../../restrito/avaliacao/avpreliminar.jsp\">Avaliações Preliminares</a>"+
                                                "</li>"+
                                                "<li class=\"nav-item dropdown\">"+
                                                    "<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"+
                                                        "DivAl"+
                                                    "</a>"+
                                                    "<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">"+
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/curso/curso.jsp\">Curso</a>"+
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/turma/turma.jsp\">Turma</a>"+
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/candidato/precandidatura.jsp\">Cadastrar Candidato</a>"+
                                                    "</div>"+
                                                "</li>");                        
                                }
                                else if(ga.getId() == 4){
                                    out.println("<li class=\"nav-item\">"+
                                                    "<a class=\"nav-link\" href=\"../../restrito/avaliacao/avpreliminar.jsp\">Avaliações Preliminares</a>"+
                                                "</li>");
                                }
                                else if(ga.getId() == 5){
                                    out.println("<li class=\"nav-item\">"+
                                                    "<a class=\"nav-link\" href=\"../../restrito/avaliacao/avpreliminar.jsp\">Avaliações Preliminares</a>"+
                                                "</li>");
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
            <%
                if(request.getParameter("e") != null){
                    int retorno = Integer.parseInt(request.getParameter("e"));

                    if(retorno == 1){
                        out.println("<div class=\"alert alert-success shadow-sm text-center\" role=\"alert\">");
                        out.println("       Usuário adicionado com sucesso!");
                        out.println("</div>");
                    }
                    else if(retorno == 2){
                        out.println("<div class=\"alert alert-danger shadow-sm text-center\" role=\"alert\">");
                        out.println("       Erro durante a realização do cadastro.<br>Tente Novamente!");
                        out.println("</div>");
                    }
                }
            %>
            
            <form class="container-fluid form" action="controller.usuario/CadastrarUsuario" method="POST" name="formCadastrar">
                <fieldset>
                    <div class="fieldset-header">
                        <h5 class="fieldset-title">Usuário</h5>
                    </div>
                    <div class="fieldset-body">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="txtPGrad">Posto/Graduação: <span class="campo-obrigatorio">*</span></label>
                                <select class="form-control" id="txtPGrad" name="txtPGrad">
                                    <option value="0" selected>Selecione um Posto/Graduação...</option>
                                </select>
                                <div class="valid-feedback">Selva!</div>
                                <div class="invalid-feedback">Campo Obrigatório!</div>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="txtIdentidade">Identidade: <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control idt-mil" id="txtIdentidade" name="txtIdentidade" placeholder="Ex.: 120000000-0">
                                <div class="valid-feedback">Selva!</div>
                                <div class="invalid-feedback invalid-identidade">Campo Obrigatório!</div>
                            </div>                                  
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="txtNome">Nome: <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control" id="txtNome" name="txtNome" placeholder="Ex.: Nome">
                                <div class="valid-feedback">Selva!</div>
                                <div class="invalid-feedback">Campo Obrigatório!</div>
                            </div>                                    
                            <div class="form-group col-md-8">
                                <label for="txtSobrenome">Sobrenome: <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control" id="txtSobrenome" name="txtSobrenome" placeholder="Ex.: Sobrenome">
                                <div class="valid-feedback">Selva!</div>
                                <div class="invalid-feedback">Campo Obrigatório!</div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="txtNomeGuerra">Nome de Guerra: <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control" id="txtNomeGuerra" name="txtNomeGuerra" placeholder="Ex.: Nome de Guerra">
                                <div class="valid-feedback">Selva!</div>
                                <div class="invalid-feedback">Campo Obrigatório!</div>
                            </div>                                    
                            <div class="form-group col-md-6">
                                <label for="txtNGS">Guerreiro de Selva Nº: <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control" id="txtNGS" name="txtNGS" placeholder="Ex.: 1000">
                                <div class="valid-feedback">Selva!</div>
                                <div class="invalid-feedback">Campo Obrigatório!</div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label for="txtSenha">Senha: <span class="campo-obrigatorio">*</span></label>
                                <input type="password" class="form-control" id="txtSenha" name="txtSenha" placeholder="Ex.: Senha">
                                <div class="valid-feedback">Selva!</div>
                                <div class="invalid-feedback invalid-senha">Campo Obrigatório!</div>
                            </div>  
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-12" style="margin-bottom: 0px;">
                                <label for="txtGruposAcesso">Grupos de Acesso: <span class="campo-obrigatorio">*</span></label>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-md-12">
                                <%
                                    GrupoAcessoDAO grpacessoDAO = new GrupoAcessoDAO();
                                    ArrayList<GrupoAcesso> grupos = grpacessoDAO.getGruposAcesso();
                                    
                                    for(GrupoAcesso ga : grupos){
                                        out.println(
                                                "<div class=\"form-check form-check-inline\">"+
                                                    "<input class=\"form-check-input\" type=\"checkbox\" id=txt" + ga.getNome() + " name=\"txtGrupoAcesso\" value="+ga.getId()+ ">"+
                                                    "<label class=\"form-check-label\" for=txt" + ga.getNome() + ">" + ga.getNome() +"</label>"+
                                                "</div>"                                       
                                        );
                                    }
                                %>
                            </div>
                        </div>  
                        <button type="button" name="btnLimparCadastro" class="btn btn-warning">Limpar</button>
                        <button type="submit" name="btnSalvarCadastro" class="btn btn-success">Salvar</button>                    
                    </div>
                </fieldset>
            </form>
        </section>
        
        <footer class="container-fluid bg-success text-center fixed-bottom">
            <b>Anderson de Paula Andrade Medeiros</b><br>
            <b class="text-center copy">&copy; 2019-2020</b>
        </footer>
        <script src="../../assets/node_modules/jquery/dist/jquery.js"></script>
        <script src="../../assets/node_modules/popper.js/dist/popper.js"></script>
        <script src="../../assets/node_modules/bootstrap/dist/js/bootstrap.js"></script>
        
        <script src="../../assets/js/formulario/validacao/mascaras.js"></script>
        <script src="../../assets/js/dwr/usuario/cadastro/camposDinamicos.js"></script>
        
        <script src="../../assets/js/formulario/validacao/usuario/funcoesImportantes.js"></script>
        <script src="../../assets/js/formulario/validacao/usuario/cadastro.js"></script> 
        <script src="../../assets/js/bootstrap-validate.js"></script>
    </body>
</html>

