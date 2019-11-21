<%-- 
    Document   : montarGradeCurricular
    Created on : 20/11/2019, 13:55:54
    Author     : andersondepaula
--%>

<%@page import="bean.Fase"%>
<%@page import="dao.FaseDAO"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="bean.Categoria"%>
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
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo_gradeCurricular.css">
        
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
                            <a class="nav-link" href="#">Aluno</a>
                        </li>
                        <li class="nav-item dropdown active">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Configurações
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="../restrito/curso.jsp">Curso</a>
                                <a class="dropdown-item" href="../restrito/fase.jsp">Fase</a>
                                <a class="dropdown-item" href="../restrito/disciplina.jsp">Disciplina</a>
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
                Curso curso = new Curso();
                Categoria categoria = new Categoria();
                CategoriaDAO categoriaDAO = new CategoriaDAO();
                CursoDAO cursoDAO = new CursoDAO();
                
                int idCurso = Integer.parseInt(request.getParameter("idCurso"));
                
                curso = cursoDAO.getCurso(idCurso);
                categoria = categoriaDAO.getCategoria(curso.getIdCategoria());
            %>
            <div class="row">
                <div class="col-md-5 mr-1">
                    <table class="table">
                        <div class="text-center thead">
                            <b>Curso</b>
                        </div>
                        <tbody>
                            <tr>
                                <th scope="row">ID</th>
                                <% out.println("<td>"+curso.getId()+"</td>"); %>
                            </tr>
                            <tr>
                                <th scope="row">NOME</th>
                                <% out.println("<td>"+curso.getNome()+"</td>"); %>
                            </tr>
                            <tr>
                                <th scope="row">SIGLA</th>
                                <% out.println("<td>"+curso.getSigla()+"</td>"); %>
                            </tr>
                            <tr>
                                <th scope="row">CATEGORIA</th>
                                <% out.println("<td>"+categoria.getNome()+"</td>"); %>
                            </tr>
                            <tr>
                                <th scope="row">PORTARIA</th>
                                <% out.println("<td>"+curso.getPortaria()+"</td>"); %>
                            </tr>
                        </tbody>
                    </table>
                    
                    <table class="table">
                        <div class="text-center thead">
                            <b>Grade Curricular</b>
                        </div>
                        <tbody>
                            <tr>
                                <th scope="row">CÓDIGO</th>
                                <% out.println("<td>"+curso.getId()+"</td>"); %>
                            </tr>
                            <tr>
                                <th scope="row">ANO</th>
                                <% out.println("<td>"+curso.getNome()+"</td>"); %>
                            </tr>
                            <tr>
                                <th scope="row">VARIAÇÃO</th>
                                <% out.println("<td>"+curso.getSigla()+"</td>"); %>
                            </tr>
                            <tr>
                                <th scope="row">SITUAÇÃO</th>
                                <td><input type="text" class="form-control input-grade" id="txtSitGrade" name="txtSitGrade" value="ATIVO"></td>
                            </tr>
                            
                        </tbody>
                    </table>
                    
                
                </div>
                <div class="col-md-5">
                    <table class="table">
                        <div class="text-center thead">
                            <b>Fases</b>
                        </div>
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">CÓDIGO</th>
                                <th scope="col">NOME</th>
                                <th scope="col">SIGLA</th>
                                <th scope="col">AÇÃO</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                FaseDAO faseDAO = new FaseDAO();
                                ArrayList<Fase> fases = new ArrayList<>();

                                fases = faseDAO.getFases();

                                if(fases.size() == 0){
                                    out.println("<div class=\"alert alert-danger shadow-sm text-center mt-3\" role=\"alert\">");
                                    out.println("       Nenhuma fase cadastrado.<br>Adicione uma nova fase!");
                                    out.println("</div>");
                                }else{
                                    for(int i=0;i<fases.size();i++){
                                        out.println("<tr>");
                                        out.println("   <th scope=\"row\">"+ fases.get(i).getId() +"</th>");
                                        out.println("   <td>"+ fases.get(i).getNome() +"</td>");
                                        out.println("   <td>"+ fases.get(i).getSigla()+"</td>");
                                        out.println("   <td>");
                                        out.println("       <div class=form-row>");
                                        out.println("           <div class=\"form-group mr-2\">");
                                        out.println("               <form name=\"formExcluir\" method=\"POST\" action=\"controller.fase/ExcluirFase\">");
                                        out.println("                   <input type=\"hidden\" class=\"form-control\" name=\"fase_id_excluir\" id=\"fase_id_excluir\" readonly=\"readonly\" value=\""+fases.get(i).getId()+"\"/>");
                                        out.println("                   <button id="+ fases.get(i).getId() +" type=\"submit\" name=\"btnExcluir\" class=\"btn btn-danger\" onclick=\"return confirm('Tem certeza que deseja excluir o registro?');\">Excluir</button>");
                                        out.println("               </form>");
                                        out.println("           </div>");
                                        out.println("           <div class=form-group>");                  
                                        out.println("                   <button id="+ fases.get(i).getId() +" type=\"submit\" name=\"btnAlterar\" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#modalFormAttFase\" onclick=\"alterar_fase("+"'"+fases.get(i).getId()+"'"+","+"'"+fases.get(i).getNome()+"'"+","+"'"+fases.get(i).getSigla()+"'"+","+"'"+fases.get(i).getDescricao()+"'"+");\">Alterar</button>");
                                        out.println("           </div>");
                                        out.println("       </div>");
                                        out.println("   </td>");
                                        out.println("</tr>");
                                    }
                                }
                            %>
                        </tbody>                        
                    </table>
                        <!-- Botão para acionar modal -->
                    <button type="submit" class="btn btn-success" data-toggle="modal" data-target="#modalFormCadCurso">Adicionar fase</button>
                </div>
                
                               
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
