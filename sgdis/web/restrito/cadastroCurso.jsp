<%-- 
    Document   : cadastroCurso
    Created on : 31/10/2019, 14:24:52
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
        <title>Cadastro de Curso</title>
        
        <link rel="stylesheet" type="text/css" href="../assets/node_modules/bootstrap/compiler/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo_universal.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo_cadastroCurso.css">
        
        
        
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-success fixed-top">
                <a class="navbar-brand" href="../restrito/inicial.jsp">SGDIS</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerSgdis" aria-controls="navbarTogglerSgdis" aria-expanded="false" aria-label="Alterna navegação">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarTogglerSgdis">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="../restrito/cadastroCurso.jsp">Curso <span class="sr-only">(Página atual)</span></a>
                        </li>
                        <li class="nav-item dropdown active">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Cadastrar
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item active" href="../restrito/cadastroCurso.jsp">Curso</a>
                                <a class="dropdown-item" href="../restrito/cadastroFase.jsp">Fase</a>
                                <a class="dropdown-item" href="../restrito/cadastroDisciplina.jsp">Disciplina</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Algo mais aqui</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Aluno</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="#">Desativado</a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0" name="formSair" action="Sair" method="POST">                        
                        <button class="btn btn-danger my-2 my-sm-0" type="submit">Sair</button>
                    </form>
                </div>
            </nav>
        </header>
        
        <section class="container-fluid area">
            <form action="controller.curso/Cadastrar" method="POST" name="formCadastrar">
                <%
                    if(request.getParameter("e") != null){
                        int grp_acesso_sgdis = Integer.parseInt(request.getParameter("e"));

                        if(grp_acesso_sgdis == 1){
                            out.println("<div class=\"alert alert-success col-md-10 mr-auto ml-auto shadow-sm text-center\" role=\"alert\">");
                            out.println("       Curso adicionado com sucesso!");
                            out.println("</div>");
                        }
                        else if(grp_acesso_sgdis == 2){
                            out.println("<div class=\"alert alert-danger col-md-10 mr-auto ml-auto shadow-sm text-center\" role=\"alert\">");
                            out.println("       Erro durante a realização do cadastro.<br>Tente Novamente!");
                            out.println("</div>");
                        }
                    }
                %>
                
                <fieldset class="col-md-10 mr-auto ml-auto shadow-sm p-3 mb-5 bg-warning">
                    <legend class="text-center bg-danger">Curso</legend>
                    <div class="form-row">
                        <div class="form-group col-md-7">
                            <label for="txtNome">Nome: </label>
                            <input type="text" class="form-control" id="txtNome" name="txtNome" placeholder="Nome">
                        </div>
                    
                        <div class="form-group col-md-3">
                            <label for="txtSigla">Sigla: </label>
                            <input type="text" class="form-control" id="txtSigla" name="txtSigla" placeholder="Sigla">
                        </div>
                        
                        <div class="form-group col-md-2">
                            <label for="txtCategoria">Categoria: </label>
                            <select class="form-control" id="txtCategoria" name="txtCategoria">
                                <option value="0" selected>Categoria </option>
                                <option value="A">A</option>
                                <option value="B">B</option>
                                <option value="C">C</option>
                            </select>
                        </div>
                    </div>
                    
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="txtCH">Carga Horária: </label>
                            <input type="text" class="form-control" id="txtCH" name="txtCH" placeholder="Carga Horária">
                        </div>
                    
                        <div class="form-group col-md-6">
                            <label for="txtPortaria">Portaria: </label>
                            <input type="text" class="form-control" id="txtPortaria" name="txtPortaria" placeholder="Portaria">
                        </div>
                    </div>
                    
                    <div class="form-row">
                        <div class="form-group col-md-12">
                            <label for="txtDescricao">Descrição: </label>
                            <textarea class="form-control" id="txtDescricao" name="txtDescricao" rows="3" placeholder="Descrição"></textarea>
                        </div>
                    </div>
                    
                    <button type="submit" class="btn btn-success">Cadastrar</button>
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
    </body>
</html>
