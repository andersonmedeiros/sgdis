<%-- 
    Document   : cadastroCandidato
    Created on : 12/12/2019, 09:27:12
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
        <title>Cadastro de Candidato</title>
        
        <link rel="stylesheet" type="text/css" href="../assets/node_modules/bootstrap/compiler/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo_universal.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo_formulario_etapas.css">
        
    </head>
    <body>
        <header>
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
            <form id="formCadCandidato" class="col-md-10">
                <ul id="progress">
                    <li class="ativo">Dados Pessoais</li>
                    <li>Dados Militares</li>
                    <li>Dados Familiares</li>
                    <li>Dados de Endereço</li>
                    <li>Preparação</li>
                    
                </ul>

                <fieldset>
                    <div class="fieldset-header">
                        <h5 class="fieldset-title">Dados Pessoais</h5>
                    </div>
                    <div class="fieldset-body">
                        <div class="form-row">
                            <div class="form-group col-md-8">
                                <label for="txtNome">Nome: </label>
                                <input type="text" class="form-control" id="txtNome" name="txtNome" placeholder="Nome">
                            </div>

                            <div class="form-group col-md-4">
                                <label for="txtNomeGuerra">Nome Guerra: </label>
                                <input type="text" class="form-control" id="txtNomeGuerra" name="txtNomeGuerra" placeholder="Nome de Guerra">
                            </div>                
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="txtIdentidade">Identidade: </label>
                                <input type="text" class="form-control" id="txtIdentidade" name="txtIdentidade" placeholder="Identidade">
                            </div>  

                            <div class="form-group col-md-3">
                                <label for="txtCpf">CPF: </label>
                                <input type="text" class="form-control" id="txtCpf" name="txtCpf" placeholder="CPF">
                            </div>

                            <div class="form-group col-md-3">
                                <label for="txtPreccp">PRECCP: </label>
                                <input type="text" class="form-control" id="txtPreccp" name="txtPreccp" placeholder="PRECCP">
                            </div>
                            
                            <div class="form-group col-md-3">
                                <label for="txtCP">CP: </label>
                                <input type="text" class="form-control" id="txtCP" name="txtCP" placeholder="CP">
                            </div>                                
                        </div>
                        
                        <hr>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="txtTituloEleitor">Titulo Eleitor: </label>
                                <input type="text" class="form-control" id="txtTituloEleitor" name="txtTituloEleitor" placeholder="Titulo Eleitor">
                            </div>  

                            <div class="form-group col-md-1">
                                <label for="txtZona">Zona: </label>
                                <input type="text" class="form-control" id="txtZona" name="txtZona" placeholder="Zona">
                            </div>
                            <div class="form-group col-md-1">
                                <label for="txtSecao">Seção: </label>
                                <input type="text" class="form-control" id="txtSecao" name="txtSecao" placeholder="Seção">
                            </div>                              
                            <div class="form-group col-md-3">
                                <label for="txtCidade">Cidade: </label>
                                <input type="text" class="form-control" id="txtCidade" name="txtCidade" placeholder="Cidade">
                            </div>                              
                            <div class="form-group col-md-3">
                                <label for="txtEstado">Estado: </label>
                                <input type="text" class="form-control" id="txtEstado" name="txtEstado" placeholder="Estado">
                            </div>                              
                        </div>
                        <hr>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="txtPai">Pai: </label>
                                <input type="text" class="form-control" id="txtPai" name="txtPai" placeholder="Pai">
                            </div>  

                            <div class="form-group col-md-6">
                                <label for="txtMae">Mãe: </label>
                                <input type="text" class="form-control" id="txtMae" name="txtMae" placeholder="Mãe">
                            </div>                                                     
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-8">
                                <label for="txtEmail">Email: </label>
                                <input type="text" class="form-control" id="txtEmail" name="txtEmail" placeholder="Email">
                            </div>  

                            <div class="form-group col-md-4">
                                <label for="txtFone">Fone: </label>
                                <input type="text" class="form-control" id="txtFone" name="txtFone" placeholder="Fone">
                            </div>                                                     
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="txtEmail">Data de Praça: </label>
                                <input type="text" class="form-control" id="txtEmail" name="txtEmail" placeholder="Email">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtFone">Data de Nascimento: </label>
                                <input type="text" class="form-control" id="txtFone" name="txtFone" placeholder="Fone">
                            </div>                                                     
                            <div class="form-group col-md-4">
                                <label for="txtFone">Data da última promoção: </label>
                                <input type="text" class="form-control" id="txtFone" name="txtFone" placeholder="Fone">
                            </div>                                                     
                        </div>
                    </div>
                    
                    <button type="button" name="btnProximo" class="btn btn-danger prox acao" value="Proximo">Próximo</button>
                
                    
                </fieldset>

                <fieldset>
                    <div class="fieldset-header">
                        <h5 class="fieldset-title">Dados Militares</h5>
                    </div>
                    <div class="fieldset-body">
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="txtParentesco">Parentesco: </label>
                                <select class="form-control" id="txtParentesco" name="txtParentesco">
                                    <option value="0" selected>Selecione um Parentesco...</option>
                                </select>
                            </div>

                            <div class="form-group col-md-8">
                                <label for="txtNome">Nome: </label>
                                <input type="text" class="form-control" id="txtNome" name="txtNome" placeholder="Nome">
                            </div>               
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="txtCpf">CPF: </label>
                                <input type="text" class="form-control" id="txtCpf" name="txtCpf" placeholder="CPF">
                            </div> 

                            <div class="form-group col-md-3">
                                <label for="txttxtFone">Fone: </label>
                                <input type="text" class="form-control" id="txttxtFone" name="txtFone" placeholder="Fone">
                            </div>

                            <div class="form-group col-md-6">
                                <label for="txtEmail">Email: </label>
                                <input type="text" class="form-control" id="txtEmail" name="txtEmail" placeholder="Email">
                            </div>  
                        </div>
                    </div>
                    <button type="button" name="btnVoltar" class="btn btn-dark anterior acao">Anterior</button>
                    <button type="button" name="btnProximo" class="btn btn-danger prox acao" value="Proximo">Próximo</button>
                </fieldset>
                <fieldset>
                    <div class="fieldset-header">
                        <h4 class="fieldset-title">Dados Familiares</h4>
                    </div>
                    <div class="fieldset-body">
                        <div class="header-interno">
                            <h5 class="title-interno">Referência</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="txtParentesco">Parentesco: </label>
                                    <select class="form-control" id="txtParentesco" name="txtParentesco">
                                        <option value="0" selected>Selecione um Parentesco...</option>
                                    </select>
                                </div>

                                <div class="form-group col-md-8">
                                    <label for="txtNome">Nome: </label>
                                    <input type="text" class="form-control" id="txtNome" name="txtNome" placeholder="Nome">
                                </div>               
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <label for="txtCpf">CPF: </label>
                                    <input type="text" class="form-control" id="txtCpf" name="txtCpf" placeholder="CPF">
                                </div> 

                                <div class="form-group col-md-3">
                                    <label for="txttxtFone">Fone: </label>
                                    <input type="text" class="form-control" id="txttxtFone" name="txtFone" placeholder="Fone">
                                </div>

                                <div class="form-group col-md-6">
                                    <label for="txtEmail">Email: </label>
                                    <input type="text" class="form-control" id="txtEmail" name="txtEmail" placeholder="Email">
                                </div>  
                            </div>
                        </div>
                        
                        <div class="header-interno">
                            <h5 class="title-interno">Cônjuge</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="txtCpf">CPF: </label>
                                    <input type="text" class="form-control" id="txtCpf" name="txtCpf" placeholder="CPF">
                                </div> 

                                <div class="form-group col-md-8">
                                    <label for="txtNome">Nome: </label>
                                    <input type="text" class="form-control" id="txtNome" name="txtNome" placeholder="Nome">
                                </div>               
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="txttxtFone">Fone: </label>
                                    <input type="text" class="form-control" id="txttxtFone" name="txtFone" placeholder="Fone">
                                </div>

                                <div class="form-group col-md-8">
                                    <label for="txtEmail">Email: </label>
                                    <input type="text" class="form-control" id="txtEmail" name="txtEmail" placeholder="Email">
                                </div>  
                            </div>
                        </div>
                    </div>
                    <button type="button" name="btnAnterior" class="btn btn-dark anterior acao">Anterior</button>
                    <button type="button" name="btnProximo" class="btn btn-danger prox acao" value="Proximo">Próximo</button>
                </fieldset>
                <fieldset>
                    <div class="fieldset-header">
                        <h4 class="fieldset-title">Endereço</h4>
                    </div>
                    <div class="fieldset-body">                        
                        <div class="header-interno">
                            <h5 class="title-interno">Residência</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <label for="txtCEP">CEP: </label>
                                    <input type="text" class="form-control" id="txtCEP" name="txtCEP" placeholder="CEP">
                                </div> 
                                
                                <div class="form-group col-md-3">
                                    <label for="txtLog">Logradouro: </label>
                                    <select class="form-control" id="txtLog" name="txtLog">
                                        <option value="0" selected>Selecione um Logradouro...</option>
                                        <option value="Av">Avenida</option>
                                        <option value="Rua">Rua</option>                                        
                                    </select>
                                </div>

                                <div class="form-group col-md-6">
                                    <label for="txtNome">Nome: </label>
                                    <input type="text" class="form-control" id="txtNome" name="txtNome" placeholder="Nome">
                                </div>                                    
                            </div>                        
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <label for="txtPais">País: </label>
                                    <select class="form-control" id="txtPais" name="txtPais">
                                        <option value="0" selected>Selecione um País...</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="txtEstado">Estado: </label>
                                    <select class="form-control" id="txtEstado" name="txtEstado">
                                        <option value="0" selected>Selecione um Estado...</option>
                                    </select>
                                </div>                                    
                                <div class="form-group col-md-3">
                                    <label for="txtCidade">Cidade: </label>
                                    <select class="form-control" id="txtCidade" name="txtCidade">
                                        <option value="0" selected>Selecione uma Cidade...</option>
                                    </select>
                                </div>                                    
                                <div class="form-group col-md-3">
                                    <label for="txtBairro">Bairro: </label>
                                    <select class="form-control" id="txtBairo" name="txtBairro">
                                        <option value="0" selected>Selecione um Bairro...</option>
                                    </select>
                                </div>                                    
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="txtPtRef">Ponto de Referência: </label>
                                    <input type="text" class="form-control" id="txtPtRef" name="txtPtRef" placeholder="Ponto de Referência">
                                </div> 
                            </div>
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Endereço residencial durante o curso</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="txtEnd">Endereço: </label>
                                    <select class="form-control" id="txtEnd" name="txtEnd">
                                        <option value="0" selected>Selecione o endereço...</option>
                                        <option value="CIGS">CIGS</option>
                                        <option value="RESID">O mesmo de Residência</option>
                                        <option value="NOVO">Novo</option>
                                    </select>
                                </div>                                                 
                            </div>
                            <div class="fieldset-interno">
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label for="txtCEPNovo">CEP: </label>
                                        <input type="text" class="form-control" id="txtCEPNovo" name="txtCEPNovo" placeholder="CEP">
                                    </div> 

                                    <div class="form-group col-md-3">
                                        <label for="txtLog">Logradouro: </label>
                                        <select class="form-control" id="txtLog" name="txtLog">
                                            <option value="0" selected>Selecione um Logradouro...</option>
                                            <option value="Av">Avenida</option>
                                            <option value="Rua">Rua</option>                                        
                                        </select>
                                    </div>

                                    <div class="form-group col-md-6">
                                        <label for="txtNome">Nome: </label>
                                        <input type="text" class="form-control" id="txtNome" name="txtNome" placeholder="Nome">
                                    </div>                                    
                                </div>                        
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label for="txtPais">País: </label>
                                        <select class="form-control" id="txtPais" name="txtPais">
                                            <option value="0" selected>Selecione um País...</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="txtEstado">Estado: </label>
                                        <select class="form-control" id="txtEstado" name="txtEstado">
                                            <option value="0" selected>Selecione um Estado...</option>
                                        </select>
                                    </div>                                    
                                    <div class="form-group col-md-3">
                                        <label for="txtCidade">Cidade: </label>
                                        <select class="form-control" id="txtCidade" name="txtCidade">
                                            <option value="0" selected>Selecione uma Cidade...</option>
                                        </select>
                                    </div>                                    
                                    <div class="form-group col-md-3">
                                        <label for="txtBairro">Bairro: </label>
                                        <select class="form-control" id="txtBairo" name="txtBairro">
                                            <option value="0" selected>Selecione um Bairro...</option>
                                        </select>
                                    </div>                                    
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label for="txtPtRef">Ponto de Referência: </label>
                                        <input type="text" class="form-control" id="txtPtRef" name="txtPtRef" placeholder="Ponto de Referência">
                                    </div> 
                                </div>
                            </div>
                        </div>
                    </div>
                    <button type="button" name="btnAnterior" class="btn btn-dark anterior acao">Anterior</button>
                    <button type="button" name="btnProximo" class="btn btn-danger prox acao" value="Proximo">Próximo</button>
                    
                </fieldset>
                <fieldset>
                    <div class="fieldset-header">
                        <h5 class="fieldset-title">Preparação</h5>
                    </div>
                    <div class="fieldset-body">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="txtPrepFisica">Sua preparação física foi? </label>
                                <select class="form-control" id="txtPrepFisica" name="txtPrepFisica">
                                    <option value="0" selected>Selecione sua preparação física...</option>
                                    <option value="I">I</option>
                                    <option value="R">R</option>
                                    <option value="B">B</option>
                                    <option value="MB">MB</option>
                                    <option value="E">E</option>
                                </select>
                            </div>                              
                            <div class="form-group col-md-6">
                                <label for="txtApoioFam">Obteve apoio de sua família para realização do curso? </label>
                                <select class="form-control" id="txtApoioFam" name="txtApoioFam">
                                    <option value="0" selected>Selecione SIM ou NÃO...</option>
                                    <option value="S">SIM</option>
                                    <option value="N">NÃO</option>
                                </select>
                            </div>                              
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="txtApoioOM">Obteve apoio de sua OM durante o período de preparação para COS? </label>
                                <select class="form-control" id="txtApoioOM" name="txtApoioOM">
                                    <option value="0" selected>Selecione SIM ou NÃO...</option>
                                    <option value="S">SIM</option>
                                    <option value="N">NÃO</option>
                                </select>
                            </div>                              
                            <div class="form-group col-md-6">
                                <label for="txtCPrepCOS">Sua OM proporcionou um Curso de Preparação para o COS? </label>
                                <select class="form-control" id="txtCPrepCOS" name="txtCPrepCOS">
                                    <option value="0" selected>Selecione SIM ou NÃO...</option>
                                    <option value="S">SIM</option>
                                    <option value="N">NÃO</option>
                                </select>
                            </div>                              
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="txtProbRend">Há problemas que possam vir a comprometer seu rendimento no COS? </label>
                                <select class="form-control" id="txtProbRend" name="txtProbRend">
                                    <option value="0" selected>Selecione SIM ou NÃO...</option>
                                    <option value="S">SIM</option>
                                    <option value="N">NÃO</option>
                                </select>
                            </div>                              
                            <div class="form-group col-md-6">
                                <label for="txtTempoPrep">O tempo de sua preparação foi suficiente? </label>
                                <select class="form-control" id="txtTempoPrep" name="txtTempoPrep">
                                    <option value="0" selected>Selecione SIM ou NÃO...</option>
                                    <option value="S">SIM</option>
                                    <option value="N">NÃO</option>
                                </select>
                            </div>                              
                        </div>
                        <div class="form-row">                                                        
                            <div class="form-group col-md-6">
                                <label for="txtConsultaSite">Consultou o site do CIGS? </label>
                                <select class="form-control" id="txtConsultaSite" name="txtConsultaSite">
                                    <option value="0" selected>Selecione SIM ou NÃO...</option>
                                    <option value="S">SIM</option>
                                    <option value="N">NÃO</option>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="txtFatorMotivacao">Qual o fator que o motivou a realizar o COS? </label>
                                <input type="text" class="form-control" id="txtFatorMotivacao" name="txtFatorMotivacao" placeholder="Apenas um fator">
                            </div>                                                           
                        </div>
                        <div class="form-row">     
                            <div class="form-group col-md-12">
                                <label for="txtDedicacaoDoutOPS">Dedicou tempo suficiente para seu preparo intelectual no assunto de Doutrina de Operações na Selva? </label>
                                <select class="form-control" id="txtDedicacaoDoutOPS" name="txtDedicacaoDoutOPS">
                                    <option value="0" selected>Selecione SIM ou NÃO...</option>
                                    <option value="S">SIM</option>
                                    <option value="N">NÃO</option>
                                </select>
                            </div>                  
                        </div>
                    </div>
                    <button type="button" name="btnAnterior" class="btn btn-dark anterior acao">Anterior</button>
                    <button type="submit" name="btnSalvar" class="btn btn-success acao">Salvar</button>
                    
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
        <script src="../assets/js/formularioEtapas.js"></script>
        
    </body>
</html>
