<%-- 
    Document   : turma
    Created on : 02/04/2020, 14:21:25
    Author     : depaula
--%>

<%@page import="bean.Turma"%>
<%@page import="dao.TurmaDAO"%>
<%@page import="bean.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.CursoDAO"%>
<%@page import="dao.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Anderson de Paula Andrade Medeiros">
        
        <link rel="icon" type="image/x-icon" href="../../assets/img/logo_sgdis.png" />
        <title>SGDIS - Turma</title>
        
        <link rel="stylesheet" type="text/css" href="../../assets/node_modules/bootstrap/compiler/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="../../assets/css/estilo_universal.css">
        <link rel="stylesheet" type="text/css" href="../../assets/css/estilo_cadastroCurso.css">
    </head>
    <body>
        <header class="">
            
            <nav class="navbar navbar-expand-lg navbar-light bg-success">
                <a class="navbar-brand" href="../../restrito/inicial.jsp">SGDIS <span class="sr-only">(Página atual)</span></a>
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
                                <a class="dropdown-item active" href="cadastro.jsp">Cadastrar Turma</a>
                                <a class="dropdown-item" href="../../restrito/candidato/inicio.jsp">Cadastrar Candidato</a>
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
                    else if(retorno == 11){
                        out.println("<div class=\"alert alert-success shadow-sm text-center\" role=\"alert\">");
                        out.println("       Grade Curricular adicionada com sucesso! <a href=\"../restrito/visualizarGradeCurricular.jsp\">Clique aqui</a> para montar a Grade Curricular");
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
                        <th scope="col">CURSO</th>
                        <th scope="col">TURNO</th>
                        <th scope="col">INÍCIO</th>
                        <th scope="col">TÉRMINO</th>
                        <th scope="col">AÇÕES</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        CategoriaDAO catDAO = new CategoriaDAO();
                        CursoDAO cursoDAO = new CursoDAO();
                        TurmaDAO turmaDAO = new TurmaDAO();
                        ArrayList<Turma> turmas = new ArrayList<>();
                        
                        turmas = turmaDAO.getTurmas();
                        
                        if(turmas.size() == 0){
                            out.println("<div class=\"alert alert-danger shadow-sm text-center\" role=\"alert\">");
                            out.println("       Nenhum curso cadastrado.<br>Adicione um novo curso!");
                            out.println("</div>");
                        }else{
                            for(int i=0;i<turmas.size();i++){
                                out.println("<tr>");
                                out.println("   <th scope=\"row\">"+ turmas.get(i).getId() +"</th>");
                                out.println("   <td>"+ cursoDAO.getCurso(turmas.get(i).getIdCurso()).getSigla() + " "+ catDAO.getCategoria(turmas.get(i).getIdCategoria()).getNome() +"</td>");
                                out.println("   <td>"+ turmas.get(i).getAno()+ "/"+ turmas.get(i).getnTurma() +"</td>");
                                out.println("   <td>"+ turmas.get(i).getDataInicio()+"</td>");
                                out.println("   <td>"+ turmas.get(i).getDataFim()+"</td>");
                                out.println("   <td>");
                                out.println("       <div class=form-row>");
                                out.println("           <div class=\"form-group mr-2\">");
                                out.println("               <form name=\"formExcluir\" method=\"POST\" action=\"controller.turma/Excluir\">");
                                out.println("                   <input type=\"hidden\" class=\"form-control\" name=\"turma_id_excluir\" id=\"turma_id_excluir\" readonly=\"readonly\" value=\""+turmas.get(i).getId()+"\"/>");
                                out.println("                   <button id="+ turmas.get(i).getId() +" type=\"submit\" name=\"btnExcluir\" class=\"btn btn-danger\" onclick=\"return confirm('Tem certeza que deseja excluir o registro?');\">Excluir</button>");
                                out.println("               </form>");
                                out.println("           </div>");
                                out.println("           <div class=\"form-group mr-2\">");                  
                                out.println("                   <button id="+ turmas.get(i).getId() +" type=\"submit\" name=\"btnAlterar\" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#modalFormAttCurso\" onclick=\"alterar_curso("+"'"+turmas.get(i).getId()+"'"+","+"'"+turmas.get(i).getAno()+"'"+","+"'"+turmas.get(i).getDataInicio()+"'"+","+"'"+turmas.get(i).getDataFim()+"'"+","+"'"+turmas.get(i).getIdCurso()+"'"+","+"'"+turmas.get(i).getIdCategoria()+"'"+");\">Alterar</button>");
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
            <button type="submit" class="btn btn-success" data-toggle="modal" data-target="#modalFormAddTurma">Abrir nova turma</button>

            <!-- Modal Cadastro-->
            <div class="modal fade" id="modalFormAddTurma" tabindex="-1" role="dialog" aria-labelledby="modalFormAddTurma" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title title" id="modalFormAddTurma">Nova Turma</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            
                            <form class="container-fluid" action="controller.turma/Cadastrar" method="POST" name="formAddTurma">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="txtAno">Ano: </label>
                                        <input type="text" class="form-control" id="txtAno" name="txtAno" placeholder="Ano">
                                    </div>                                   
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="txtDataInicio">Início: <span class="campo-obrigatorio">*</span></label>
                                        <input type="date" class="form-control" id="txtDataInicio" name="txtDataInicio" placeholder="Ex.: DD/MM/AAAA">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback invalid-dataPracaAl">Campo Obrigatório!</div>
                                    </div>                                   
                                    <div class="form-group col-md-6">
                                        <label for="txtDataFim">Término: <span class="campo-obrigatorio">*</span></label>
                                        <input type="date" class="form-control" id="txtDataFim" name="txtDataFim" placeholder="Ex.: DD/MM/AAAA">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback invalid-dataPracaAl">Campo Obrigatório!</div>
                                    </div>                                   
                                </div>
                                
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="txtCurso">Curso: </label>
                                        <select class="form-control" id="txtCurso" name="txtCurso">
                                            <option value="0" selected>Selecione um Curso...</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="txtCategoria">Categoria: </label>
                                        <select class="form-control" id="txtCategoria" name="txtCategoria">
                                            <option value="0" selected>Selecione uma Categoria...</option>
                                        </select>
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
            <div class="modal fade" id="modalFormAttTurma" tabindex="-1" role="dialog" aria-labelledby="modalFormAttTurma" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title title" id="modalFormAttTurma">Atualizar Turma</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form class="container-fluid" action="controller.turma/Atualizar" method="POST" name="formAttTurma">
                                <input type="hidden" class="form-control" id="txtIdAtt" name="txtIdAtt">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="txtAnoAtt">Ano: </label>
                                        <input type="text" class="form-control" id="txtAnoAtt" name="txtAnoAtt" placeholder="Ano">
                                    </div>                                   
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="txtDataInicioAtt">Início: <span class="campo-obrigatorio">*</span></label>
                                        <input type="date" class="form-control" id="txtDataInicioAtt" name="txtDataInicioAtt" placeholder="Ex.: DD/MM/AAAA">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback invalid-dataPracaAl">Campo Obrigatório!</div>
                                    </div>                                   
                                    <div class="form-group col-md-6">
                                        <label for="txtDataFimAtt">Término: <span class="campo-obrigatorio">*</span></label>
                                        <input type="date" class="form-control" id="txtDataFimAtt" name="txtDataFimAtt" placeholder="Ex.: DD/MM/AAAA">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback invalid-dataPracaAl">Campo Obrigatório!</div>
                                    </div>                                   
                                </div>
                                
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="txtCursoAtt">Curso: </label>
                                        <select class="form-control" id="txtCursoAtt" name="txtCursoAtt">
                                            <option value="0" selected>Selecione um Curso...</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="txtCategoriaAtt">Categoria: </label>
                                        <select class="form-control" id="txtCategoriaAtt" name="txtCategoriaAtt">
                                            <option value="0" selected>Selecione uma Categoria...</option>
                                        </select>
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
        
        <script src="../../assets/node_modules/jquery/dist/jquery.js"></script>
        <script src="../../assets/node_modules/popper.js/dist/popper.js"></script>
        <script src="../../assets/node_modules/bootstrap/dist/js/bootstrap.js"></script>
    </body>
</html>