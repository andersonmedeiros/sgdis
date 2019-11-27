<%-- 
    Document   : montarGradeCurricular
    Created on : 20/11/2019, 13:55:54
    Author     : andersondepaula
--%>

<%@page import="bean.Modalidade"%>
<%@page import="dao.ModalidadeDAO"%>
<%@page import="bean.Modulo"%>
<%@page import="dao.ModuloDAO"%>
<%@page import="bean.GradeCurricular"%>
<%@page import="dao.GradeCurricularDAO"%>
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
            <div class="row">
                <div class="col-md-6">
                    <%
                        Curso curso = new Curso();
                        Categoria categoria = new Categoria();
                        CategoriaDAO categoriaDAO = new CategoriaDAO();
                        CursoDAO cursoDAO = new CursoDAO();

                        int idCurso = Integer.parseInt(request.getParameter("idCurso"));

                        curso = cursoDAO.getCurso(idCurso);
                        categoria = categoriaDAO.getCategoria(curso.getIdCategoria());
                    %>
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
                </div>
                <div class="col-md-6">
                    <%
                        String codGrade = request.getParameter("codGrade");
                        GradeCurricularDAO gradeDAO = new GradeCurricularDAO();
                        GradeCurricular grade = gradeDAO.getGrade(codGrade);
                    %>
                    <table class="table">
                        <div class="text-center thead">
                            <b>Grade Curricular</b>
                        </div>
                        <tbody>
                            <tr>
                                <th scope="row">CÓDIGO</th>
                                <% out.println("<td>"+grade.getCodigo()+"</td>"); %>
                            </tr>
                            <tr>
                                <th scope="row">DESCRIÇÃO</th>
                                <% out.println("<td>"+grade.getDescricao()+"</td>"); %>
                            </tr>
                            <tr>
                                <th scope="row">ANO/VARIAÇÃO</th>
                                <% out.println("<td>"+grade.getAno()+"/"+grade.getVariacao()+"</td>"); %>
                            </tr>
                            <tr>
                                <th scope="row">SITUAÇÃO</th>
                                <% out.println("<td>"+grade.getSituacao()+"</td>"); %>
                            </tr>
                            
                        </tbody>
                    </table>
                </div>
            </div>
                
                        
                <nav class="mr-auto ml-auto">
                    <div class="nav nav-tabs nav-justified" id="nav-tab" role="tablist">
                        <a class="nav-item nav-link active" id="nav-fase-tab" data-toggle="tab" href="#nav-fase" role="tab" aria-controls="nav-fase" aria-selected="true">Fase</a>
                        <a class="nav-item nav-link" id="nav-disciplina-tab" data-toggle="tab" href="#nav-disciplina" role="tab" aria-controls="nav-disciplina" aria-selected="false">Disciplina</a>
                        <a class="nav-item nav-link" id="nav-assunto-tab" data-toggle="tab" href="#nav-assunto" role="tab" aria-controls="nav-assunto" aria-selected="false">Assunto</a>
                    </div>
                </nav>
                            
                <div class="tab-content mr-auto ml-auto" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="nav-fase" role="tabpanel" aria-labelledby="nav-fase-tab">
                        <div class="col-md-12 mt-2">
                            <table class="table">
                                <div class="text-center thead">
                                    <b>Fases</b>
                                </div>
                                <thead class="thead-light">
                                    <tr>
                                        <th scope="col">CÓDIGO</th>
                                        <th scope="col">NOME</th>
                                        <th scope="col">ABREVIATURA</th>
                                        <th scope="col">MÓDULO</th>
                                        <th scope="col">MODALIDADE</th>
                                        <th scope="col">AÇÃO</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        FaseDAO faseDAO = new FaseDAO();
                                        ArrayList<Fase> fases = faseDAO.getFasesByCodGradeANDidCurso(codGrade, idCurso);
                                        
                                        ModuloDAO moduloDAO = new ModuloDAO();
                                        ModalidadeDAO modalidadeDAO = new ModalidadeDAO();                                        
                                        
                                        if(request.getParameter("e") != null){
                                            int retorno = Integer.parseInt(request.getParameter("e"));

                                            if(retorno == 1){
                                                out.println("<div class=\"alert alert-success shadow-sm text-center mt-3\" role=\"alert\">");
                                                out.println("       Fase adicionada com sucesso!");
                                                out.println("</div>");
                                            }
                                            else if(retorno == 2){
                                                out.println("<div class=\"alert alert-danger shadow-sm text-center mt-3\" role=\"alert\">");
                                                out.println("       Erro durante a realização do cadastro.<br>Tente Novamente!");
                                                out.println("</div>");
                                            }
                                            else if(retorno == 3){
                                                out.println("<div class=\"alert alert-danger shadow-sm text-center mt-3\" role=\"alert\">");
                                                out.println("       Erro durante a exclusão do cadastro.<br>Tente Novamente!");
                                                out.println("</div>");
                                            }
                                            else if(retorno == 4){
                                                out.println("<div class=\"alert alert-success shadow-sm text-center mt-3\" role=\"alert\">");
                                                out.println("       Fase excluída com sucesso!");
                                                out.println("</div>");
                                            }
                                            else if(retorno == 5){
                                                out.println("<div class=\"alert alert-danger shadow-sm text-center mt-3\" role=\"alert\">");
                                                out.println("       Erro durante a atualização do cadastro.<br>Tente Novamente!");
                                                out.println("</div>");
                                            }
                                            else if(retorno == 6){
                                                out.println("<div class=\"alert alert-success shadow-sm text-center mt-3\" role=\"alert\">");
                                                out.println("       Fase atualizada com sucesso!");
                                                out.println("</div>");
                                            }
                                        }            
                                        
                                        if(fases.size() == 0){
                                            out.println("<div class=\"alert alert-warning shadow-sm text-center mt-3\" role=\"alert\">");
                                            out.println("       Nenhuma fase cadastrado.<br>Adicione uma nova fase!");
                                            out.println("</div>");
                                        }else{
                                            for(int i=0;i<fases.size();i++){
                                                out.println("<tr>");
                                                out.println("   <th scope=\"row\">"+ fases.get(i).getCodigo()+"</th>");
                                                out.println("   <td>"+ fases.get(i).getNome() +"</td>");
                                                out.println("   <td>"+ fases.get(i).getAbreviatura()+"</td>");
                                                out.println("   <td>"+ moduloDAO.getModulo(fases.get(i).getIdModulo()).getNome()+"</td>");
                                                out.println("   <td>"+ modalidadeDAO.getModalidade(fases.get(i).getIdModalidade()).getNome()+"</td>");
                                                out.println("   <td>");
                                                out.println("       <div class=form-row>");
                                                out.println("           <div class=\"form-group mr-2\">");
                                                out.println("               <form name=\"formExcluir\" method=\"POST\" action=\"controller.fase/ExcluirFase\">");
                                                out.println("                   <input type=\"hidden\" class=\"form-control\" name=\"fase_id_excluir\" id=\"fase_id_excluir\" readonly=\"readonly\" value=\""+fases.get(i).getCodigo()+"\"/>");
                                                out.println("                   <button id="+ fases.get(i).getCodigo()+" type=\"submit\" name=\"btnExcluir\" class=\"btn btn-danger\" onclick=\"return confirm('Tem certeza que deseja excluir o registro?');\">Excluir</button>");
                                                out.println("               </form>");
                                                out.println("           </div>");
                                                out.println("           <div class=form-group>");                  
                                                //out.println("                   <button id="+ fases.get(i).getCodigo()+" type=\"submit\" name=\"btnAlterar\" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#modalFormAttFase\" onclick=\"alterar_fase("+"'"+fases.get(i).getId()+"'"+","+"'"+fases.get(i).getNome()+"'"+","+"'"+fases.get(i).getSigla()+"'"+","+"'"+fases.get(i).getDescricao()+"'"+");\">Alterar</button>");
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
                            <button type="submit" class="btn btn-success" data-toggle="modal" data-target="#modalFormCadFase">Adicionar Fase</button>
                            
                            <!-- Modal Cadastro-->
                            <div class="modal fade" id="modalFormCadFase" tabindex="-1" role="dialog" aria-labelledby="modalFormCadFase" aria-hidden="true">
                                <div class="modal-dialog modal-lg" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title title" id="modalFormCadFase">Nova Fase</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">                            
                                            <form class="container-fluid" action="controller.fase/CadastrarFase" method="POST" name="formCadastrar">
                                                <div class="form-row">
                                                    <div class="form-group col-md-8">
                                                        <label for="txtNomeCad">Nome: </label>
                                                        <input type="text" class="form-control" id="txtNomeCad" name="txtNomeCad" placeholder="Nome">
                                                    </div>

                                                    <div class="form-group col-md-4">
                                                        <label for="txtAbreviaturaCad">Abreviatura: </label>
                                                        <input type="text" class="form-control" id="txtAbreviaturaCad" name="txtAbreviaturaCad" placeholder="Abreviatura">
                                                    </div>                                    
                                                </div>

                                                <div class="form-row">
                                                    <div class="form-group col-md-6">
                                                        <label for="txtModalidadeCad">Modalidade: </label>
                                                        <select class="form-control" id="txtModalidadeCad" name="txtModalidadeCad">
                                                            <option value="0" selected>Selecione uma Modalidade...</option>
                                                            <%
                                                                ModalidadeDAO modaDAO = new ModalidadeDAO();

                                                                int qtdeModalidade =  modaDAO.getModalidades().size();

                                                                if(qtdeModalidade != 0){
                                                                    for(int i=0;i<qtdeModalidade;i++){                                                    
                                                                        out.println("<option value='"+modaDAO.getModalidades().get(i).getId()+"'>"+modaDAO.getModalidades().get(i).getNome()+"</option>");
                                                                    }
                                                                }
                                                            %>
                                                        </select>
                                                    </div>

                                                    <div class="form-group col-md-6">
                                                        <label for="txtModuloCad">Módulo: </label>
                                                        <select class="form-control" id="txtModuloCad" name="txtModuloCad">
                                                            <option value="0" selected>Selecione um Modulo...</option>
                                                            <%
                                                                ModuloDAO modDAO = new ModuloDAO();

                                                                int qtdeModulo =  modDAO.getModulos().size();

                                                                if(qtdeModulo != 0){
                                                                    for(int i=0;i<qtdeModalidade;i++){
                                                                        out.println("<option value='"+modDAO.getModulos().get(i).getId()+"'>"+modDAO.getModulos().get(i).getNome()+"</option>");
                                                                    } 
                                                                }
                                                            %>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <div class="form-group col-md-12">
                                                        <label for="txtDescricaoCad">Descrição: </label>
                                                        <textarea class="form-control" id="txtDescricaoCad" name="txtDescricaoCad" rows="3" placeholder="Descrição"></textarea>
                                                    </div>
                                                </div>
                                                <input type="hidden" class="form-control" id="txtCodGrade" name="txtCodGrade" value="<%=grade.getCodigo() %>">
                                                <input type="hidden" class="form-control" id="txtIdCurso" name="txtIdCurso" value="<%=grade.getIdCurso() %>">
                                                <input type="hidden" class="form-control" id="txtAnoGrade" name="txtAnoGrade" value="<%=grade.getAno() %>">
                                                <input type="hidden" class="form-control" id="txtVariacaoGrade" name="txtVariacaoGrade" value="<%=grade.getVariacao() %>">
                                                
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
                        </div>
                    </div>
                    <div class="tab-pane fade" id="nav-disciplina" role="tabpanel" aria-labelledby="nav-profile-tab">..flamengo.</div>
                    <div class="tab-pane fade" id="nav-assunto" role="tabpanel" aria-labelledby="nav-contact-tab">..campeao.</div>
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
