<%-- 
    Document   : cursos.jsp
    Created on : 02/12/2019, 10:21:20
    Author     : andersondepaula
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="dao.CursoDAO"%>
<%@page import="bean.Categoria"%>
<%@page import="bean.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Anderson de Paula Andrade Medeiros">
        
        <link rel="icon" type="image/x-icon" href="../assets/img/logo_sgdis.png" />
        <title>Cursos</title>
        
        <link rel="stylesheet" type="text/css" href="../assets/node_modules/bootstrap/compiler/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo_universal.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo_cadastroCurso.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo_gradeCurricular.css">
    </head>
    <body>
        <header class="">
            
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
            
            <div class="text-center thead mb-3">
                <b>CURSOS</b>
            </div>
            <div class="row mb-3" style="margin-left: 0">
            <%
                CursoDAO cursoDAO = new CursoDAO();
                ArrayList<Curso> cursos = cursoDAO.getCursos();
                
                CategoriaDAO categoriaDAO = new CategoriaDAO();
                ArrayList<Categoria> categorias = categoriaDAO.getCategorias();
                
                Categoria categoria = new Categoria();
                
                
                int qtdeCategorias = categorias.size();
                
                for(int i=0; i<qtdeCategorias; i++){
                    out.println("<div class=\"list-group col\">");
                    out.println("<button type=\"button\" class=\"list-group-item list-group-item-action active\">");
                    out.println(""+categorias.get(i).getDescricao()+"");
                    out.println("</button>");
                    
                    cursos = cursoDAO.getCursosByCategoria(categorias.get(i).getId());
                    
                    for(int j=0; j<cursos.size(); j++){
                        out.println("<a class=\"list-group-item list-group-item-action\" href=../restrito/grades.jsp?idCurso=" + cursos.get(j).getId() + ">" + cursos.get(j).getNome() + "</a>");
                    }
                    out.println("</div>");                    
                }
            %>
            </div>
                        
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

