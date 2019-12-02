<%-- 
    Document   : grades.jsp
    Created on : 02/12/2019, 13:56:32
    Author     : andersondepaula
--%>

<%@page import="bean.GradeCurricular"%>
<%@page import="dao.GradeCurricularDAO"%>
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
            
            <nav class="navbar navbar-expand-lg navbar-light bg-success">
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
            
            
            <div class="accordion" id="accordionCursos">
                
                    <%
                        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
                        GradeCurricularDAO gradeDAO = new GradeCurricularDAO();
                        ArrayList<GradeCurricular> grades = gradeDAO.getGradesByIdCurso(idCurso);
                        
                        int qtdeGrades = grades.size();
                        
                        for(int i=0; i<qtdeGrades; i++){
                            out.println("<div class=\"card\">");
                            out.println("   <div class=\"card-header\" id=heading" + grades.get(i).getCodigo() + ">");
                            out.println("       <h5 class=\"mb-0\">");
                            out.println("           <button class=\"btn btn-link\" type=\"button\" data-toggle=\"collapse\" data-target=#collapse" + grades.get(i).getCodigo() +  " aria-expanded=\"true\" aria-controls=collapse" + grades.get(i).getCodigo() + ">");
                            out.println("" +        grades.get(i).getCodigo()  + "");
                            out.println("           </button>");
                            out.println("       </h5>");
                            out.println("   </div>");
                            
                            
                            out.println("   <div id=collapse" + grades.get(i).getCodigo() + " class=\"collapse\" aria-labelledby=heading" + grades.get(i).getCodigo() + " data-parent=\"#accordionCursos\">");
                            out.println("       <div class=\"card-body\">");
                            out.println(""      + grades.get(i).getDescricao() + "");
                            
                            
                            
                            out.println("       </div>");
                            out.println("   </div>");
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

