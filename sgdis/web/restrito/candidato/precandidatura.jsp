<%-- 
    Document   : precandidatura
    Created on : 26/04/2020, 00:24:32
    Author     : anderson
--%>

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
        <link rel="stylesheet" type="text/css" href="../../assets/css/estilo_precandidatura.css">
        
        <script type='text/javascript' src='../../dwr/engine.js'></script>
        <script type='text/javascript' src='../../dwr/interface/FacadeAjax.js'></script>
        <script type='text/javascript' src='../../dwr/util.js'></script>     
        
        <script src="../../assets/js/dwr/candidato/precandidatura/tabelaDinamica.js"></script>
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
        
        <section class="container-fluid mr-auto ml-auto area">
            <form id="formInicioCadCandidato" class="formCad col-md-10" method="post" action="controller.candidato/InicioCandidatura">
                <fieldset>
                    <div class="fieldset-header">
                        <h5 class="fieldset-title">Pré-Candidatura: Dados Importantes </h5>
                    </div>
                    <div class="fieldset-body">
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="txtIdtCandidato">Identidade Militar: <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control idt-mil" id="txtIdtCandidato" name="txtIdtCandidato" placeholder="Ex. 000000000-0">
                                <div class="valid-feedback">Selva!</div>
                                <div class="invalid-feedback invalid-idtMilCand">Campo Obrigatório!</div>
                            </div>
                        </div>
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
                               <button type="button" id="btn" name="btnTentativa" class="btn btn-warning btn-tentativas" value="Candidatura" >Verificar Tentativas</button>
                        </div>                        
                        <div class="header-interno">
                            <h5 class="title-interno">Tentativas</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="title-table">
                                <b>Quantidade de Tentativas: <span id="qtdeTentativas"></span></b>
                            </div>
                            <div class="table">
                                <table class="table">
                                    <thead class="thead-light text">
                                        <tr>
                                            <th scope="col">Curso</th>
                                            <th scope="col">Turma</th>
                                            <th scope="col">Motivo de Desligamento</th>
                                            <th scope="col">Fase de Desligamento</th>                                                
                                        </tr>
                                    </thead>
                                    <tbody id="tentativas"></tbody>
                                </table>
                            </div>                            
                            <div id="info-tent" class="alert to col-md-12 shadow-sm text-center" role="alert"></div>                            
                            <div id="div-btn-inicio-cad" class="form-row"></div>
                        </div>
                    </div>                    
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
            <b>Desenvolvido por Anderson de Paula Andrade Medeiros</b><br>
            <b class="text-center copy">&copy;2019-2020</b>
        </footer>
        
        <script src="../../assets/node_modules/jquery/dist/jquery.js"></script>
        <script src="../../assets/node_modules/popper.js/dist/popper.js"></script>
        <script src="../../assets/node_modules/bootstrap/dist/js/bootstrap.js"></script>
        
        <script src="../../assets/js/formulario/validacao/mascaras.js"></script>
        
        <script src="../../assets/js/dwr/candidato/precandidatura/camposDinamicos.js"></script>
        <script src="../../assets/js/formulario/validacao/candidato/precandidatura/funcoesImportantes.js"></script>
        <script src="../../assets/js/formulario/validacao/candidato/precandidatura/precandidatura.js"></script>
        
        <script src="../../assets/js/bootstrap-validate.js"></script>
    </body>
</html>
