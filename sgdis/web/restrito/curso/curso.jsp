<%-- 
    Document   : curso
    Created on : 07/11/2019, 09:10:51
    Author     : andersondepaula
--%>

<%@page import="model.bean.GrupoAcesso"%>
<%@page import="model.dao.MilitarHasGrupoAcessoDAO"%>
<%@page import="model.bean.Militar"%>
<%@page import="model.bean.CursoHasCategoria"%>
<%@page import="model.dao.CursoHasCategoriaDAO"%>
<%@page import="model.dao.CategoriaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Curso"%>
<%@page import="model.dao.CursoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Anderson de Paula Andrade Medeiros">
        
        <link rel="icon" type="image/x-icon" href="../../assets/img/logo_sgdis.png" />
        <title>Curso</title>
        
        <link rel="stylesheet" type="text/css" href="../../assets/node_modules/bootstrap/compiler/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="../../assets/css/estilo_universal.css">
        <link rel="stylesheet" type="text/css" href="../../assets/css/estilo_cadastroCurso.css">   
        
        <script type='text/javascript' src='../../dwr/engine.js'></script>
        <script type='text/javascript' src='../../dwr/interface/FacadeAjax.js'></script>
        <script type='text/javascript' src='../../dwr/util.js'></script> 
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-success fixed-top">
                <a class="navbar-brand" href="../../restrito/inicial.jsp">SGDIS</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerSgdis" aria-controls="navbarTogglerSgdis" aria-expanded="false" aria-label="Alterna navegação">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarTogglerSgdis">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">                        
                        <li class="nav-item">
                            <a class="nav-link" href="../../restrito/cursos.jsp">Cursos</a>
                        </li>
                        <%
                            HttpSession sessao = request.getSession();
                            Militar militarLogado = (Militar) sessao.getAttribute("militarAutenticado");

                            MilitarHasGrupoAcessoDAO milgrpacessoDAO = new MilitarHasGrupoAcessoDAO();
                            ArrayList<GrupoAcesso> grpsacesso = milgrpacessoDAO.getGruposAcesso(militarLogado.getIdentidade());

                            for(GrupoAcesso ga : grpsacesso){
                                if(ga.getId() == 1){
                                    out.println("<li class=\"nav-item dropdown\">"+
                                                    "<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"+
                                                        "STE"+
                                                    "</a>"+
                                                    "<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">"+                                
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/curso.jsp\">Curso</a>"+
                                                        "<div class=\"dropdown-divider\"></div>"+
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/gradeCurricular.jsp\">Grade Curricular</a>"+
                                                    "</div>"+
                                                "</li>"+

                                                "<li class=\"nav-item dropdown\">"+
                                                    "<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"+
                                                        "DivAl"+
                                                    "</a>"+
                                                    "<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">"+
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/curso/curso.jsp\">Curso</a>"+
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/turma/turma.jsp\">Turma</a>"+
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/candidato/precandidatura.jsp\">Cadastrar Candidato</a>"+
                                                    "</div>"+
                                                "</li>"+

                                                "<li class=\"nav-item dropdown\">"+
                                                    "<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"+
                                                        "Psico"+
                                                    "</a>"+
                                                    "<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">"+                       
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/avaliacao/psico.jsp\">Avaliação Psicológica</a>"+
                                                    "</div>"+
                                                "</li>");
                                }
                                else if(ga.getId() == 2){
                                    out.println("<li class=\"nav-item dropdown\">"+
                                                    "<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"+
                                                        "STE"+
                                                    "</a>"+
                                                    "<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">"+                                
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/curso.jsp\">Curso</a>"+
                                                        "<div class=\"dropdown-divider\"></div>"+
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/gradeCurricular.jsp\">Grade Curricular</a>"+
                                                    "</div>"+
                                                "</li>");                        
                                }
                                else if(ga.getId() == 3){
                                    out.println("<li class=\"nav-item dropdown\">"+
                                                    "<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"+
                                                        "DivAl"+
                                                    "</a>"+
                                                    "<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">"+
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/curso/curso.jsp\">Curso</a>"+
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/turma/turma.jsp\">Turma</a>"+
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/candidato/precandidatura.jsp\">Cadastrar Candidato</a>"+
                                                    "</div>"+
                                                "</li>");                        
                                }
                                else if(ga.getId() == 4){
                                    out.println("<li class=\"nav-item dropdown\">"+
                                                    "<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">"+
                                                        "Psico"+
                                                    "</a>"+
                                                    "<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">"+                       
                                                        "<a class=\"dropdown-item\" href=\"../../restrito/avaliacao/psico.jsp\">Avaliação Psicológica</a>"+
                                                    "</div>"+
                                                "</li>");
                                }
                            }
                        %>
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
                        <th scope="col">#</th>
                        <th scope="col">NOME</th>
                        <th scope="col">SIGLA</th>
                        <th scope="col">CATEGORIA</th>
                        <th scope="col">PORTARIA</th>
                        <th scope="col">AÇÃO</th>
                    </tr>
                </thead>
                <tbody>
                    <%              
                        CursoHasCategoriaDAO cursoCategoriaDAO = new CursoHasCategoriaDAO();
                        ArrayList<CursoHasCategoria> cursos = new ArrayList<>();
                        cursos = cursoCategoriaDAO.getCursosAndCategorias();
                        
                        if(cursos.size() == 0){
                            out.println("<div class=\"alert alert-danger shadow-sm text-center\" role=\"alert\">");
                            out.println("       Nenhum curso cadastrado.<br>Adicione um novo curso!");
                            out.println("</div>");
                        }
                        else{
                            for(int i=0;i<cursos.size();i++){
                                out.println("<tr>");
                                out.println("   <th scope=\"row\">"+ (i+1) +"</th>");
                                out.println("   <td>"+ cursos.get(i).getNomeCurso() +"</td>");
                                out.println("   <td>"+ cursos.get(i).getSiglaCurso()+"</td>");                                
                                out.println("   <td>"+ cursos.get(i).getNomeCategoria()+"</td>");
                                out.println("   <td>"+ cursos.get(i).getPortariaCurso()+"</td>");
                                out.println("   <td>");
                                out.println("       <div class=form-row>");
                                out.println("           <div class=\"form-group mr-2\">");
                                out.println("               <form name=\"formExcluir\" method=\"POST\" action=\"controller.curso/Excluir\">");
                                out.println("                   <input type=\"hidden\" class=\"form-control\" name=\"idCursoExcluir\" id=\"idCursoExcluir\" readonly=\"readonly\" value=\""+cursos.get(i).getIdCurso()+"\"/>");
                                out.println("                   <input type=\"hidden\" class=\"form-control\" name=\"idCategoriaExcluir\" id=\"idCategoriaExcluir\" readonly=\"readonly\" value=\""+cursos.get(i).getIdCategoria()+"\"/>");
                                out.println("                   <button id="+cursos.get(i).getIdCurso()+" type=\"submit\" name=\"btnExcluir\" class=\"btn btn-danger\" onclick=\"return confirm('Tem certeza que deseja excluir o registro?');\">Excluir</button>");
                                out.println("               </form>");
                                out.println("           </div>");
                                out.println("           <div class=\"form-group mr-2\">");                  
                                out.println("                   <button id="+cursos.get(i).getIdCurso()+" type=\"submit\" name=\"btnAlterar\" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#modalFormAttCurso\" onclick=\"alteraCurso("+"'"+cursos.get(i).getIdCurso()+"'"+","+"'"+cursos.get(i).getIdCategoria()+"'"+");\">Alterar</button>");
                                out.println("           </div>");
                                out.println("           <div class=form-group>");                  
                                //out.println("                   <button id="+ cursos.get(i).getId() +" type=\"submit\" name=\"btnGrade\" class=\"btn btn-dark\" data-toggle=\"modal\" data-target=\"#modalFormGradeCurso\" onclick=\"grade_curso("+"'"+cursos.get(i).getId()+"'"+","+"'"+cursos.get(i).getSigla()+"'"+","+"'"+cursos.get(i).getIdCategoria()+"'"+");\">Grade</button>");
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
            <button type="submit" class="btn btn-success" data-toggle="modal" data-target="#modalFormCadCurso">Novo Curso</button>

            <!-- Modal Cadastro-->
            <div class="modal fade" id="modalFormCadCurso" tabindex="-1" role="dialog" aria-labelledby="modalFormCadCurso" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title title" id="modalFormCadCurso">Novo Curso</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">                            
                            <form class="container-fluid" action="controller.curso/Cadastrar" method="POST" name="formCadastrar">
                                <div class="form-row">
                                    <div class="form-group col-md-8">
                                        <label for="txtNome">Nome: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtNome" name="txtNome" placeholder="Nome">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="txtSigla">Sigla: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtSigla" name="txtSigla" placeholder="Sigla">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>                                    
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-4">
                                        <label for="txtCategoria">Categoria: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtCategoria" name="txtCategoria">
                                            <option value="0" selected>Selecione uma Categoria...</option>
                                        </select>
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>                                    
                                    <div class="form-group col-md-8">
                                        <label for="txtPortaria">Portaria: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtPortaria" name="txtPortaria" placeholder="Portaria">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label for="txtDescricao">Descrição: <span class="campo-obrigatorio">*</span></label>
                                        <textarea class="form-control" id="txtDescricao" name="txtDescricao" rows="3" placeholder="Descrição"></textarea>
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <button type="button" name="btnLimparCadastro" class="btn btn-warning">Limpar</button>
                                <button type="submit" name="btnSalvarCadastro" class="btn btn-success">Salvar</button>
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
                            <button type="button" name="btnFecharAtualizacao" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">                            
                            <form class="container-fluid" action="controller.curso/Atualizar" method="POST" name="formAtualizar">
                                <input type="hidden" class="form-control" id="txtIdAtt" name="txtIdAtt">
                                <div class="form-row">
                                    <div class="form-group col-md-8">
                                        <label for="txtNome">Nome: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtNomeAtt" name="txtNomeAtt" placeholder="Nome">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="txtSigla">Sigla: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtSiglaAtt" name="txtSiglaAtt" placeholder="Sigla">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>                                    
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label for="txtCategoria">Categoria: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtCategoriaAtt" name="txtCategoriaAtt" disabled>
                                            <option value="0" selected>Selecione uma Categoria...</option>
                                        </select>
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                    
                                    <div class="form-group col-md-9">
                                        <label for="txtPortaria">Portaria: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtPortariaAtt" name="txtPortariaAtt" placeholder="Portaria">
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label for="txtDescricaoAtt">Descrição: <span class="campo-obrigatorio">*</span></label>
                                        <textarea class="form-control" id="txtDescricaoAtt" name="txtDescricaoAtt" rows="3" placeholder="Descrição"></textarea>
                                        <div class="valid-feedback">Selva!</div>
                                        <div class="invalid-feedback">Campo Obrigatório!</div>
                                    </div>
                                </div>
                                <button type="button" name="btnLimparAtualizacao" class="btn btn-warning">Limpar</button>
                                <button type="submit" name="btnSalvarAtualizacao" class="btn btn-success">Salvar</button>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" name="btnFecharAtualizacao" class="btn btn-danger" data-dismiss="modal">Fechar</button>
                        </div>
                    </div>
                </div>
            </div>
                                        
            <!-- Modal Grade Curso-->
            <div class="modal fade" id="modalFormGradeCurso" tabindex="-1" role="dialog" aria-labelledby="modalFormGradeCurso" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title title" id="modalFormGradeCurso">Nova Grade</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">                            
                            <form class="container-fluid" action="controller.gradeCurricular/CadastrarGrade" method="POST" name="formCadastrarGrade">
                                <div class="form-row">
                                    <div class="form-group col-md-4">
                                        <label for="txtIdCursoGrade">Curso: </label>
                                        <input type="text" class="form-control" id="txtIdCursoGrade" name="txtIdCursoGrade" placeholder="Nome" readonly>
                                    </div>

                                    <div class="form-group col-md-4">
                                        <label for="txtSiglaGrade">Sigla: </label>
                                        <input type="text" class="form-control" id="txtSiglaGrade" name="txtSiglaGrade" placeholder="Sigla" readonly>
                                    </div>                                     
                                
                                    <div class="form-group col-md-4">
                                        <label for="txtCategoriaGrade ">Categoria: </label>
                                        <input type="text" class="form-control" id="txtCategoriaGrade" name="txtCategoriaGrade" placeholder="Grade" readonly>                                        
                                    </div>
                                </div>
                                
                                <div class="form-row">
                                    <div class="form-group col-md-10">
                                        <label for="txtDescricaoGrade">Descrição: </label>
                                        <input type="text" class="form-control" id="txtDescricaoGrade" name="txtDescricaoGrade" placeholder="Descricao">
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="txtAnoGrade">Ano: </label>
                                        <input type="text" class="form-control" id="txtAnoGrade" name="txtAnoGrade" placeholder="Ano">
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
        
        <script src="../../assets/js/dwr/curso/campos-dinamicos.js"></script>
        
        <script src="../../assets/js/formulario/validacao/curso/funcoesImportantes.js"></script>
        <script src="../../assets/js/formulario/validacao/curso/cadastro.js"></script>
        <script src="../../assets/js/formulario/validacao/curso/atualizacao.js"></script>  
        <script src="../../assets/js/bootstrap-validate.js"></script>
    </body>
</html>
