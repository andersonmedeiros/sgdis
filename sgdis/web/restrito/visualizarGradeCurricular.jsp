<%-- 
    Document   : visualizarGradeCurricular
    Created on : 25/11/2019, 09:20:46
    Author     : andersondepaula
--%>

<%@page import="bean.GradeCurricular"%>
<%@page import="dao.GradeCurricularDAO"%>
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
                        out.println("       Grade Curricular adicionada com sucesso!");
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
                        out.println("       Grade Curricular excluído com sucesso!");
                        out.println("</div>");
                    }
                    else if(retorno == 5){
                        out.println("<div class=\"alert alert-danger shadow-sm text-center\" role=\"alert\">");
                        out.println("       Erro durante a atualização do cadastro.<br>Tente Novamente!");
                        out.println("</div>");
                    }
                    else if(retorno == 6){
                        out.println("<div class=\"alert alert-success shadow-sm text-center\" role=\"alert\">");
                        out.println("       Grade Curricular atualizada com sucesso!");
                        out.println("</div>");
                    }
                }
            %>
            <table class="table">
                <div class="text-center thead">
                    <b style="color: green">GRADES ATIVAS</b>
                </div>
                <thead class="thead-light">
                    <tr>
                        <th scope="col">CÓDIGO</th>
                        <th scope="col">DESCRIÇÃO</th>
                        <th scope="col">ANO/VARIAÇÃO</th>
                        <th scope="col">CURSO</th>
                        <th scope="col">SITUAÇÃO</th>
                        <th scope="col">AÇÃO</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
                        GradeCurricularDAO gradeDAO = new GradeCurricularDAO();
                        ArrayList<GradeCurricular> grades = new ArrayList<>();
                        
                        grades = gradeDAO.getGradesBySitANDidCurso("A", idCurso);
                        
                        if(grades.size() == 0){
                            out.println("<div class=\"alert alert-danger shadow-sm text-center mt-3\" role=\"alert\">");
                            out.println("       O curso não possui grades curriculares ativas.<br>");
                            out.println("</div>");
                        }else{
                            for(int i=0;i<grades.size();i++){
                                out.println("<tr>");
                                out.println("   <th scope=\"row\">"+ grades.get(i).getCodigo()+"</th>");
                                out.println("   <td>"+ grades.get(i).getDescricao() +"</td>");
                                out.println("   <td>"+ grades.get(i).getAno()+"/"+grades.get(i).getVariacao()+"</td>");
                                out.println("   <td>"+ grades.get(i).getIdCurso()+"</td>");
                                out.println("   <td>"+ grades.get(i).getSituacao()+"</td>");
                                out.println("   <td>");
                                out.println("       <div class=form-row>");                                
                                out.println("           <div class=form-group>");                  
                                //out.println("                   <button id="+ cursos.get(i).getId() +" type=\"submit\" name=\"btnAlterar\" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#modalFormAttCurso\" onclick=\"alterar_curso("+"'"+cursos.get(i).getId()+"'"+","+"'"+cursos.get(i).getNome()+"'"+","+"'"+cursos.get(i).getSigla()+"'"+","+"'"+cursos.get(i).getIdCategoria()+"'"+","+"'"+cursos.get(i).getPortaria()+"'"+","+"'"+cursos.get(i).getDescricao()+"'"+");\">Montar Grade</button>");
                                out.println("                   <a class=\"btn btn-dark\""+ "href=../restrito/montarGradeCurricular.jsp?idCurso="+grades.get(i).getIdCurso()+"&codGrade="+grades.get(i).getCodigo()+">Montar Grade</a>");
                                out.println("           </div>");
                                out.println("       </div>");
                                out.println("   </td>");
                                out.println("</tr>");
                            }
                        }
                    %>
                </tbody>
            </table>
                
            <table class="table">
                <div class="text-center thead">
                    <b style="color: red;">GRADES INATIVAS</b>
                </div>
                <thead class="thead-light">
                    <tr>
                        <th scope="col">CÓDIGO</th>
                        <th scope="col">DESCRIÇÃO</th>
                        <th scope="col">ANO/VARIAÇÃO</th>
                        <th scope="col">CURSO</th>
                        <th scope="col">SITUAÇÃO</th>
                        <th scope="col">AÇÃO</th>
                    </tr>
                </thead>
                <tbody>
                    <%                        
                        grades = gradeDAO.getGradesBySitANDidCurso("I", idCurso);
                        
                        if(grades.size() == 0){
                            out.println("<div class=\"alert alert-danger shadow-sm text-center mt-3\" role=\"alert\">");
                            out.println("       O curso não possui grades Curriculares inativas.<br>");
                            out.println("</div>");
                        }else{
                            for(int i=0;i<grades.size();i++){
                                out.println("<tr>");
                                out.println("   <th scope=\"row\">"+ grades.get(i).getCodigo()+"</th>");
                                out.println("   <td>"+ grades.get(i).getDescricao() +"</td>");
                                out.println("   <td>"+ grades.get(i).getAno()+"/"+grades.get(i).getVariacao()+"</td>");
                                out.println("   <td>"+ grades.get(i).getIdCurso()+"</td>");
                                out.println("   <td>"+ grades.get(i).getSituacao()+"</td>");
                                out.println("   <td>");
                                out.println("       <div class=form-row>");                                
                                out.println("           <div class=form-group>");                  
                                //out.println("                   <button id="+ cursos.get(i).getId() +" type=\"submit\" name=\"btnAlterar\" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#modalFormAttCurso\" onclick=\"alterar_curso("+"'"+cursos.get(i).getId()+"'"+","+"'"+cursos.get(i).getNome()+"'"+","+"'"+cursos.get(i).getSigla()+"'"+","+"'"+cursos.get(i).getIdCategoria()+"'"+","+"'"+cursos.get(i).getPortaria()+"'"+","+"'"+cursos.get(i).getDescricao()+"'"+");\">Montar Grade</button>");
                                out.println("                   <a class=\"btn btn-dark\""+ "href=../restrito/montarGradeCurricular.jsp?idCurso="+grades.get(i).getIdCurso()+"&codGrade="+grades.get(i).getCodigo()+">Montar Grade</a>");
                                out.println("           </div>");
                                out.println("       </div>");
                                out.println("   </td>");
                                out.println("</tr>");
                            }
                        }
                    %>
                </tbody>
            </table>
            
            <!-- Modal Cadastro-->
            <div class="modal fade" id="modalFormCadGrade" tabindex="-1" role="dialog" aria-labelledby="modalFormCadGrade" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title title" id="modalFormCadGrade">Nova Grade</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">                            
                            <form class="container-fluid" action="controller.gradeCurricular/CadastrarGrade" method="POST" name="formCadastrar">
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label for="txtIdCursoCad">Curso: </label>
                                        <input type="text" class="form-control" id="txtIdCursoCad" name="txtIdCursoCad" placeholder="Curso" value=<%=request.getParameter("idCurso")%> disabled>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label for="txtDescricaoCad">Descrição: </label>
                                        <input type="text" class="form-control" id="txtNomeCad" name="txtDescricaoCad" placeholder="Descricao">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="txtAnoCad">Ano: </label>
                                        <input type="text" class="form-control" id="txtAnoCad" name="txtAnoCad" placeholder="Ano">
                                    </div>
                                    
                                    <div class="form-group col-md-6">
                                        <label for="txtVariacaoCad">Variação: </label>
                                        <input type="text" class="form-control" id="txtVariacaoCad" name="txtVariacaoCad" placeholder="Variacao">
                                    </div>
                                </div>
                                    
                                <button type="button" name="btnLimpar" class="btn btn-warning">Limpar</button>
                                <button type="submit" name="btnSalvar" class="btn btn-success">Salvar</button>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- Modal Atualizar-->
            <div class="modal fade" id="modalFormAttCurso" tabindex="-1" role="dialog" aria-labelledby="modalFormAttCurso" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title title" id="modalFormAttCurso">Novo Curso</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            
                            <form class="container-fluid" action="controller.curso/Atualizar" method="POST" name="formAtualizar">
                                <input type="hidden" class="form-control" id="txtIdAtt" name="txtIdAtt">
                                <div class="form-row">
                                    <div class="form-group col-md-8">
                                        <label for="txtNome">Nome: </label>
                                        <input type="text" class="form-control" id="txtNomeAtt" name="txtNomeAtt" placeholder="Nome">
                                    </div>

                                    <div class="form-group col-md-4">
                                        <label for="txtSigla">Sigla: </label>
                                        <input type="text" class="form-control" id="txtSiglaAtt" name="txtSiglaAtt" placeholder="Sigla">
                                    </div>                                    
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label for="txtCategoria">Categoria: </label>
                                        <select class="form-control" id="txtCategoriaAtt" name="txtCategoriaAtt">
                                            <option value="0" selected>Categoria </option>
                                            <option value="A">A</option>
                                            <option value="B">B</option>
                                            <option value="C">C</option>
                                        </select>
                                    </div>
                                    
                                    <div class="form-group col-md-9">
                                        <label for="txtPortaria">Portaria: </label>
                                        <input type="text" class="form-control" id="txtPortariaAtt" name="txtPortariaAtt" placeholder="Portaria">
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label for="txtDescricaoAtt">Descrição: </label>
                                        <textarea class="form-control" id="txtDescricaoAtt" name="txtDescricaoAtt" rows="3" placeholder="Descrição"></textarea>
                                    </div>
                                </div>
                                <button type="button" name="btnLimpar" class="btn btn-warning">Limpar</button>
                                <button type="submit" name="btnSalvar" class="btn btn-success">Salvar</button>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                        </div>
                    </div>
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