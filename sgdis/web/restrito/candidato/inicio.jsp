<%-- 
    Document   : cadastro
    Created on : 15/02/2020, 16:07:05
    Author     : anderson
--%>

<%@page import="model.dao.CursoDAO"%>
<%@page import="model.dao.CategoriaDAO"%>
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
        
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-success fixed-top">
                <a class="navbar-brand active" href="../../restrito/inicial.jsp">SGDIS <span class="sr-only">(Página atual)</span></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerSgdis" aria-controls="navbarTogglerSgdis" aria-expanded="false" aria-label="Alterna navegação">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarTogglerSgdis">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        
                        <li class="nav-item">
                            <a class="nav-link" href="../../restrito/cursos.jsp">Cursos</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                STE
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">                                
                                <a class="dropdown-item" href="../../restrito/curso.jsp">Curso</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="../../restrito/gradeCurricular.jsp">Grade Curricular</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                DivAl
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">                                
                                <a class="dropdown-item active" href="../../restrito/cadastroCandidato.jsp">Cadastrar Candidato</a>
                            </div>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0" name="formSair" action="Sair" method="POST">                        
                        <button class="btn btn-danger my-2 my-sm-0" type="submit">Sair</button>
                    </form>
                </div>
            </nav>
        </header>
        
        <section class="container-fluid col-md-10 mr-auto ml-auto area">
            <form id="formInicioCadCandidato" class="col-md-10 formCad" method="post" action="controller.candidato/InicioCadastro">
                <fieldset>
                    <div class="fieldset-header">
                        <h5 class="fieldset-title">Dados Importantes</h5>
                    </div>
                    <div class="fieldset-body">
                        <div class="form-row">
                            <div class="form-group col-md-4 ">
                                <label for="txtIdtCandidato">Identidade Militar: <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control idt-mil" id="txtIdtCandidato" name="txtIdtCandidato" placeholder="Ex. 000000000-0">
                                <div class="valid-feedback">Selva!</div>
                                <div class="invalid-feedback invalid-idtMilAl">Campo Obrigatório!</div>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtCurso">Curso: </label>
                                <select class="form-control" id="txtCurso" name="txtCurso">
                                    <option value="0" selected>Selecione um Curso...</option>
                                    
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtCategoria">Categoria: </label>
                                <select class="form-control" id="txtCategoria" name="txtCategoria">
                                    <option value="0" selected>Selecione uma Categoria...</option>
                                    
                                </select>
                            </div>
                        </div>
                    </div>
                    <button type="submit" id="btn" name="btnIniciar" class="btn btn-success prox acao" value="ICadastro">Inciar Cadastro</button>
                </fieldset>
                
            </form>
                                
            <fieldset id="formCadCandidato" class="col-md-10">
                <div class="fieldset-header">
                    <h5 class="fieldset-title">Avisos</h5>
                </div>
                <div class="fieldset-body">
                    sdfjhsdfsd
                    sdfsjdfnsd
                </div>
            </fieldset>
        </section>
        
        <footer class="container-fluid bg-success text-center fixed-bottom">
            <b>Anderson de Paula Andrade Medeiros</b><br>
            <b class="text-center copy">&copy; 2019</b>
        </footer>
        
        <script src="../../assets/node_modules/jquery/dist/jquery.js"></script>
        <script src="../../assets/node_modules/popper.js/dist/popper.js"></script>
        <script src="../../assets/node_modules/bootstrap/dist/js/bootstrap.js"></script>
        <script src="../../assets/js/formularioEtapas.js"></script>
        <script src="../../assets/js/formulario/validacao/mascaras.js"></script>
        <script src="../../assets/js/formulario/camposdinamico/cursos.js"></script>
        <script src="../../assets/js/formulario/validacao/form-casdatroCandidato-cos.js"></script>
        <script src="../../assets/js/bootstrap-validate.js"></script>
    </body>
</html>
