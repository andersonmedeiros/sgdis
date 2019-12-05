<%-- 
    Document   : gradeCurricular
    Created on : 12/11/2019, 09:25:32
    Author     : andersondepaula
--%>

<%@page import="dao.CategoriaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Curso"%>
<%@page import="dao.CursoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Anderson de Paula Andrade Medeiros">
        
        <link rel="icon" type="image/x-icon" href="../assets/img/logo_sgdis.png" />
        <title>Grade Curricular</title>
        
        <link rel="stylesheet" type="text/css" href="../assets/node_modules/bootstrap/compiler/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo_universal.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo_cadastroCurso.css">
        
        <script src="../assets/js/modalAlterar.js"></script>     
        
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
                            <a class="nav-link active" href="../restrito/cursos.jsp">Cursos</a>
                        </li>
                        <li class="nav-item dropdown active">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                STE
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">                                
                                <a class="dropdown-item" href="../restrito/curso.jsp">Curso</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item active" href="../restrito/gradeCurricular.jsp">Grade Curricular</a>
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
            <%
                if(request.getParameter("e") != null){
                    int retorno = Integer.parseInt(request.getParameter("e"));

                    if(retorno == 1){
                        out.println("<div class=\"alert alert-success shadow-sm text-center\" role=\"alert\">");
                        out.println("       Curso adicionado com sucesso!");
                        out.println("</div>");
                    }
                    else if(retorno == 2){
                        out.println("<div class=\"alert alert-danger shadow-sm text-center\" role=\"alert\">");
                        out.println("       Erro durante a realização do cadastro.<br>Tente Novamente!");
                        out.println("</div>");
                    }
                    else if(retorno == 3){
                        out.println("<div class=\"alert alert-danger shadow-sm text-center\" role=\"alert\">");
                        out.println("       Erro durante a exclusão do cadastro.<br>Tente Novamente!");
                        out.println("</div>");
                    }
                    else if(retorno == 4){
                        out.println("<div class=\"alert alert-success shadow-sm text-center\" role=\"alert\">");
                        out.println("       Curso excluído com sucesso!");
                        out.println("</div>");
                    }
                    else if(retorno == 5){
                        out.println("<div class=\"alert alert-danger shadow-sm text-center\" role=\"alert\">");
                        out.println("       Erro durante a atualização do cadastro.<br>Tente Novamente!");
                        out.println("</div>");
                    }
                    else if(retorno == 6){
                        out.println("<div class=\"alert alert-success shadow-sm text-center\" role=\"alert\">");
                        out.println("       Curso atualizado com sucesso!");
                        out.println("</div>");
                    }
                }
            %>
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">NOME</th>
                        <th scope="col">SIGLA</th>
                        <th scope="col">CATEGORIA</th>
                        <th scope="col">PORTARIA</th>
                        <th scope="col">AÇÃO</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        CursoDAO cursoDAO = new CursoDAO();
                        ArrayList<Curso> cursos = new ArrayList<>();
                        
                        CategoriaDAO categoriaDAO = new CategoriaDAO();
                        
                        cursos = cursoDAO.getCursos();
                        
                        if(cursos.size() == 0){
                            out.println("<div class=\"alert alert-danger shadow-sm text-center\" role=\"alert\">");
                            out.println("       Nenhum curso cadastrado.<br>Adicione um novo curso!");
                            out.println("</div>");
                        }else{
                            for(int i=0;i<cursos.size();i++){
                                out.println("<tr>");
                                out.println("   <th scope=\"row\">"+ cursos.get(i).getId() +"</th>");
                                out.println("   <th scope=\"row\">"+ cursos.get(i).getNome() +"</th>");
                                out.println("   <th scope=\"row\">"+ cursos.get(i).getSigla() +"</th>");
                                out.println("   <th scope=\"row\">"+ categoriaDAO.getCategoria(cursos.get(i).getIdCategoria()).getNome() +"</th>");
                                out.println("   <td>"+ cursos.get(i).getPortaria() +"</td>");
                                out.println("   <td>");
                                out.println("       <div class=form-row>");
                                
                                out.println("           <div class=form-group>");                  
                                //out.println("                   <button id="+ cursos.get(i).getId() +" type=\"submit\" name=\"btnAlterar\" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#modalFormAttCurso\" onclick=\"alterar_curso("+"'"+cursos.get(i).getId()+"'"+","+"'"+cursos.get(i).getNome()+"'"+","+"'"+cursos.get(i).getSigla()+"'"+","+"'"+cursos.get(i).getIdCategoria()+"'"+","+"'"+cursos.get(i).getPortaria()+"'"+","+"'"+cursos.get(i).getDescricao()+"'"+");\">Montar Grade</button>");
                                out.println("                   <a class=\"btn btn-dark\""+ "href=../restrito/visualizarGradeCurricular.jsp?idCurso="+cursos.get(i).getId()+">Visualizar Grades</a>");
                                out.println("           </div>");
                                out.println("       </div>");
                                out.println("   </td>");
                                out.println("</tr>");
                            }
                        }
                    %>
                </tbody>
            </table>        
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
