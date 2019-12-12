<%-- 
    Document   : cadastroCandidato
    Created on : 12/12/2019, 09:27:12
    Author     : andersondepaula
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Anderson de Paula Andrade Medeiros">
        
        <link rel="icon" type="image/x-icon" href="../assets/img/logo_sgdis.png" />
        <title>Cadastro de Candidato</title>
        
        <link rel="stylesheet" type="text/css" href="../assets/node_modules/bootstrap/compiler/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo_universal.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo_formulario_etapas.css">
        
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-success fixed-top">
                <a class="navbar-brand active" href="../restrito/inicial.jsp">SGDIS <span class="sr-only">(Página atual)</span></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerSgdis" aria-controls="navbarTogglerSgdis" aria-expanded="false" aria-label="Alterna navegação">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarTogglerSgdis">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        
                        <li class="nav-item">
                            <a class="nav-link active" href="../restrito/cursos.jsp">Cursos</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                STE
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">                                
                                <a class="dropdown-item" href="../restrito/curso.jsp">Curso</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="../restrito/gradeCurricular.jsp">Grade Curricular</a>
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
            <form id="formCadCandidato" class="col-md-10">
                <ul id="progress">
                    <li class="ativo">Dados Pessoais</li>
                    <li>Dados Familiares</li>
                    <li>Dados Bancários</li>
                    <li>Dados 4</li>
                </ul>

                <fieldset>
                    <div class="fieldset-header">
                        <h5 class="fieldset-title">Dados Pessoais</h5>
                    </div>
                    <div class="fieldset-body">
                        <div class="form-row">
                            <div class="form-group col-md-8">
                                <label for="txtNome">Nome: </label>
                                <input type="text" class="form-control" id="txtNome" name="txtNome" placeholder="Nome">
                            </div>

                            <div class="form-group col-md-4">
                                <label for="txtNomeGuerra">Nome Guerra: </label>
                                <input type="text" class="form-control" id="txtNomeGuerra" name="txtNomeGuerra" placeholder="Nome de Guerra">
                            </div>                
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="txtIdentidade">Identidade: </label>
                                <input type="text" class="form-control" id="txtIdentidade" name="txtIdentidade" placeholder="Identidade">
                            </div>  

                            <div class="form-group col-md-4">
                                <label for="txtCpf">CPF: </label>
                                <input type="text" class="form-control" id="txtCpf" name="txtCpf" placeholder="CPF">
                            </div>

                            <div class="form-group col-md-4">
                                <label for="txtPreccp">PRECCP: </label>
                                <input type="text" class="form-control" id="txtPreccp" name="txtPreccp" placeholder="PRECCP">
                            </div>                                
                        </div>
                    </div>
                    
                    <button type="button" name="btnProximo" class="btn btn-danger prox acao" value="Proximo">Próximo</button>
                
                    
                </fieldset>

                <fieldset>
                    <div class="fieldset-header">
                        <h5 class="fieldset-title">Dados Familiares</h5>
                    </div>
                    <div class="fieldset-body">
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="txtParentesco">Parentesco: </label>
                                <select class="form-control" id="txtParentesco" name="txtParentesco">
                                    <option value="0" selected>Selecione um Parentesco...</option>
                                </select>
                            </div>

                            <div class="form-group col-md-8">
                                <label for="txtNome">Nome: </label>
                                <input type="text" class="form-control" id="txtNome" name="txtNome" placeholder="Nome">
                            </div>               
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="txtCpf">CPF: </label>
                                <input type="text" class="form-control" id="txtCpf" name="txtCpf" placeholder="CPF">
                            </div> 

                            <div class="form-group col-md-3">
                                <label for="txttxtFone">Fone: </label>
                                <input type="text" class="form-control" id="txttxtFone" name="txtFone" placeholder="Fone">
                            </div>

                            <div class="form-group col-md-6">
                                <label for="txtEmail">Email: </label>
                                <input type="text" class="form-control" id="txtEmail" name="txtEmail" placeholder="Email">
                            </div>  
                        </div>
                    </div>
                    <button type="button" name="btnVoltar" class="btn btn-dark anterior acao">Anterior</button>
                    <button type="button" name="btnProximo" class="btn btn-danger prox acao" value="Proximo">Próximo</button>
                </fieldset>
                <fieldset>
                    <div class="fieldset-header">
                        <h5 class="fieldset-title">Dados Bancários</h5>
                    </div>
                    <div class="fieldset-body">
                        <div class="form-row">
                            <div class="form-group col-md-8">
                                <label for="txtNomeCad">Nome: </label>
                                <input type="text" class="form-control" id="txtNomeCad" name="txtNomeCad" placeholder="Nome">
                            </div>

                            <div class="form-group col-md-4">
                                <label for="txtCHCad">Carga Horária: </label>
                                <input type="text" class="form-control" id="txtSiglaCad" name="txtCHCad" placeholder="Sigla">
                            </div>                                    
                        </div>
                    </div>
                    <button type="button" name="btnAnterior" class="btn btn-dark anterior acao">Anterior</button>
                    <button type="button" name="btnProximo" class="btn btn-danger prox acao" value="Proximo">Próximo</button>
                </fieldset>
                <fieldset>
                    <div class="fieldset-header">
                        <h5 class="fieldset-title">Dados 4</h5>
                    </div>
                    <div class="fieldset-body">
                        <div class="form-row">
                            <div class="form-group col-md-8">
                                <label for="txtNomeCad">Nome: </label>
                                <input type="text" class="form-control" id="txtNomeCad" name="txtNomeCad" placeholder="Nome">
                            </div>

                            <div class="form-group col-md-4">
                                <label for="txtCHCad">Carga Horária: </label>
                                <input type="text" class="form-control" id="txtSiglaCad" name="txtCHCad" placeholder="Sigla">
                            </div>                                    
                        </div>
                    </div>
                    <button type="button" name="btnAnterior" class="btn btn-dark anterior acao">Anterior</button>
                    <button type="submit" name="btnSalvar" class="btn btn-success acao">Salvar</button>
                    
                </fieldset>
            </form>
        </section>
        <footer class="container-fluid bg-success text-center fixed-bottom">
            <b>Anderson de Paula Andrade Medeiros</b><br>
            <b class="text-center copy">&copy; 2019</b>
        </footer>
        
        <script src="../assets/node_modules/jquery/dist/jquery.js"></script>
        <script src="../assets/node_modules/popper.js/dist/popper.js"></script>
        <script src="../assets/node_modules/bootstrap/dist/js/bootstrap.js"></script>
        <script src="../assets/js/formularioEtapas.js"></script>
        
    </body>
</html>
