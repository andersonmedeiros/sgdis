<%-- 
    Document   : disciplina
    Created on : 08/11/2019, 09:05:29
    Author     : andersondepaula
--%>

<%@page import="bean.Disciplina"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DisciplinaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Anderson de Paula Andrade Medeiros">
        
        <link rel="icon" type="image/x-icon" href="../assets/img/logo_sgdis.png" />
        <title>Disciplina</title>
        
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
                            <a class="nav-link active" href="../restrito/curso.jsp">Curso <span class="sr-only">(Página atual)</span></a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Cadastrar
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="../restrito/cadastroCurso.jsp">Curso</a>
                                <a class="dropdown-item" href="../restrito/cadastroFase.jsp">Fase</a>
                                <a class="dropdown-item" href="../restrito/cadastroDisciplina.jsp">Disciplina</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Algo mais aqui</a>
                            </div>
                        </li>
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
                                <a class="dropdown-item active" href="../restrito/disciplina.jsp">Disciplina</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Algo mais aqui</a>
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
                        out.println("       Disciplina adicionada com sucesso!");
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
                        out.println("       Disciplina excluída com sucesso!");
                        out.println("</div>");
                    }
                    else if(retorno == 5){
                        out.println("<div class=\"alert alert-danger shadow-sm text-center\" role=\"alert\">");
                        out.println("       Erro durante a atualização do cadastro.<br>Tente Novamente!");
                        out.println("</div>");
                    }
                    else if(retorno == 6){
                        out.println("<div class=\"alert alert-success shadow-sm text-center\" role=\"alert\">");
                        out.println("       Disciplina atualizada com sucesso!");
                        out.println("</div>");
                    }
                }
            %>
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">NOME</th>
                        <th scope="col">CH</th>
                        <th scope="col">AÇÃO</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        DisciplinaDAO discplinaDAO = new DisciplinaDAO();
                        ArrayList<Disciplina> disciplinas = new ArrayList<>();
                        
                        disciplinas = discplinaDAO.getDisciplinas();
                        
                        if(disciplinas.size() == 0){
                            out.println("<div class=\"alert alert-danger shadow-sm text-center\" role=\"alert\">");
                            out.println("       Nenhuma disciplina cadastrada.<br>Adicione uma nova disciplina!");
                            out.println("</div>");
                        }else{
                            for(int i=0;i<disciplinas.size();i++){
                                out.println("<tr>");
                                out.println("   <th scope=\"row\">"+ disciplinas.get(i).getId() +"</th>");
                                out.println("   <td>"+ disciplinas.get(i).getNome() +"</td>");
                                out.println("   <td>"+ disciplinas.get(i).getCh()+"</td>");
                                out.println("   <td>");
                                out.println("       <div class=form-row>");
                                out.println("           <div class=\"form-group mr-2\">");
                                out.println("               <form name=\"formExcluir\" method=\"POST\" action=\"controller.disciplina/Excluir\">");
                                out.println("                   <input type=\"hidden\" class=\"form-control\" name=\"disciplina_id_excluir\" id=\"disciplina_id_excluir\" readonly=\"readonly\" value=\""+disciplinas.get(i).getId()+"\"/>");
                                out.println("                   <button id="+ disciplinas.get(i).getId() +" type=\"submit\" name=\"btnExcluir\" class=\"btn btn-danger\" onclick=\"return confirm('Tem certeza que deseja excluir o registro?');\">Excluir</button>");
                                out.println("               </form>");
                                out.println("           </div>");
                                out.println("           <div class=form-group>");                  
                                out.println("                   <button id="+ disciplinas.get(i).getId() +" type=\"submit\" name=\"btnAlterar\" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#modalFormAttDisciplina\" onclick=\"alterar_disciplina("+"'"+disciplinas.get(i).getId()+"'"+","+"'"+disciplinas.get(i).getNome()+"'"+","+"'"+disciplinas.get(i).getCh()+"'"+");\">Alterar</button>");
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
            <button type="submit" class="btn btn-success" data-toggle="modal" data-target="#modalFormCadDisciplina">Adicionar nova disiciplina</button>

            <!-- Modal Cadastro-->
            <div class="modal fade" id="modalFormCadDisciplina" tabindex="-1" role="dialog" aria-labelledby="modalFormCadDisciplina" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title title" id="modalFormCadDisciplina">Nova Disciplina</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">                            
                            <form class="container-fluid" action="controller.disciplina/Cadastrar" method="POST" name="formCadastrar">
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
            <div class="modal fade" id="modalFormAttDisciplina" tabindex="-1" role="dialog" aria-labelledby="modalFormAttDisciplina" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title title" id="modalFormAttDisciplina">Nova Disciplina</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            
                            <form class="container-fluid" action="controller.disciplina/Atualizar" method="POST" name="formAtualizar">
                                <input type="hidden" class="form-control" id="txtIdAtt" name="txtIdAtt">
                                <div class="form-row">
                                    <div class="form-group col-md-8">
                                        <label for="txtNomeAtt">Nome: </label>
                                        <input type="text" class="form-control" id="txtNomeAtt" name="txtNomeAtt" placeholder="Nome">
                                    </div>

                                    <div class="form-group col-md-4">
                                        <label for="txtCHAtt">Carga Horária: </label>
                                        <input type="text" class="form-control" id="txtCHAtt" name="txtCHAtt" placeholder="Sigla">
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

