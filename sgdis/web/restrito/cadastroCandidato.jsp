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
                    <li class="ativo">OM Atual</li>
                    <li>Dados Individuais</li>
                    <li>Saúde</li>
                    <li>Dados Militares</li>
                    <li>Dados Familiares</li>
                    <li>Dados de Endereço</li>
                    <li>Cursos/Estágios</li>
                    <li>Preparação</li>
                </ul>
                <fieldset>
                    <div class="fieldset-header">
                        <h5 class="fieldset-title">Organização Militar Atual</h5>
                    </div>
                    <div class="fieldset-body">
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="txtForca">Força: </label><spam class="campo-obrigatorio"> *</spam>
                                <select class="form-control" id="txtForca" name="txtForca">
                                    <option value="0" selected>Selecione uma Força...</option>                                  
                                    <option value="mb">Marinha do Barsil</option>                                  
                                    <option value="eb">Exército Brasileiro</option>                                  
                                    <option value="fab">Força Aérea Brasileira</option>                                  
                                    <option value="1000">Outra</option>                                  
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtGCmdo">Grande Comando: </label><spam class="campo-obrigatorio"> *</spam>
                                <input type="text" class="form-control" id="txtGCmdo" name="txtGCmdo" placeholder="Ex.: CMA"> 
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtEscEnq">Escalão Enquadrante: </label><spam class="campo-obrigatorio"> *</spam>
                                <input type="text" class="form-control" id="txtEscEnq" name="txtEscEnq" placeholder="Ex.: 12ª RM, 16ª Bda Inf Sl etc."> 
                            </div>
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Organização Militar - OM</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">                            
                                <div class="form-group col-md-3">
                                    <label for="txtAbrevOM">Abreviatura: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtAbrevOM" name="txtAbrevOM" placeholder="Ex.: CIGS"> 
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="txtNomeOM">Nome: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtNomeOM" name="txtNomeOM" placeholder="Ex.: Centro de Instrução de Guerra na Selva"> 
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="txtFoneOM">Fone: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtFoneOM" name="txtFoneOM" placeholder="Ex.: (00) 0000-0000"> 
                                </div>
                            </div>
                            <div class="header-interno">
                                <h5 class="title-interno">Comandante</h5>
                            </div>
                            <div class="fieldset-interno">
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label for="txtPGradCmtOM">Posto/Graduação: </label><spam class="campo-obrigatorio"> *</spam>
                                        <select class="form-control" id="txtPGradCmtOM" name="txtPGradCmtOM">
                                            <option value="0" selected>Selecione um Posto/Graduação...</option>                                     
                                        </select>
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="txtNomeCmtOM">Nome: </label><spam class="campo-obrigatorio"> *</spam>
                                        <input type="text" class="form-control" id="txtNomeCmtOM" name="txtNomeCmtOM" placeholder="Ex.: Fulano"> 
                                    </div>
                                    <div class="form-group col-md-5">
                                        <label for="txtSobrenomeCmtOM">Sobrenome: </label><spam class="campo-obrigatorio"> *</spam>
                                        <input type="text" class="form-control" id="txtSobrenomeCmtOM" name="txtSobrenomeCmtOM" placeholder="Ex.: de Tal"> 
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="txtNomeGuerraCmtOM">Nome de Guerra: </label><spam class="campo-obrigatorio"> *</spam>
                                        <input type="text" class="form-control" id="txtNomeGuerraCmtOM" name="txtNomeGuerraCmtOM" placeholder="Ex.: De Tal"> 
                                    </div>
                                </div>
                            </div>
                            <div class="header-interno">
                                <h5 class="title-interno">Chefe Imediato</h5>
                            </div>
                            <div class="fieldset-interno">
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label for="txtPGradChImtoOM">Posto/Graduação: </label><spam class="campo-obrigatorio"> *</spam>
                                        <select class="form-control" id="txtPGradChImtoOM" name="txtPGradChImtoOM">
                                            <option value="0" selected>Selecione um Posto/Graduação...</option>                                     
                                        </select>
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="txtNomeChImtoOM">Nome: </label><spam class="campo-obrigatorio"> *</spam>
                                        <input type="text" class="form-control" id="txtNomeChImtoOM" name="txtNomeChImtoOM" placeholder="Ex.: Fulano"> 
                                    </div>
                                    <div class="form-group col-md-5">
                                        <label for="txtSobrenomeChImtoOM">Sobrenome: </label><spam class="campo-obrigatorio"> *</spam>
                                        <input type="text" class="form-control" id="txtSobrenomeChImtoOM" name="txtSobrenomeChImtoOM" placeholder="Ex.: de Tal"> 
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="txtNomeGuerraChImtoOM">Nome de Guerra: </label><spam class="campo-obrigatorio"> *</spam>
                                        <input type="text" class="form-control" id="txtNomeGuerraCmtOM" name="txtNomeGuerraChImtoOM" placeholder="Ex.: De Tal"> 
                                    </div>
                                </div>
                            </div>
                            <div class="header-interno">
                                <h5 class="title-interno">Endereço da OM</h5>
                            </div>
                            <div class="fieldset-interno">
                                <div class="form-row">
                                    <div class="form-group col-md-2">
                                        <label for="txtEndCepOM">CEP: </label><spam class="campo-obrigatorio"> *</spam>
                                        <input type="text" class="form-control" id="txtEndCepOM" name="txtEndCepOM" placeholder="Ex.: 00000-000">
                                    </div> 

                                    <div class="form-group col-md-3">
                                        <label for="txtEndLogOM">Logradouro: </label><spam class="campo-obrigatorio"> *</spam>
                                        <select class="form-control" id="txtEndLogOM" name="txtEndLogOM">
                                            <option value="0" selected>Selecione um Logradouro...</option>                                      
                                        </select>
                                    </div>

                                    <div class="form-group col-md-5">
                                        <label for="txtEndNomeOM">Nome: </label><spam class="campo-obrigatorio"> *</spam>
                                        <input type="text" class="form-control" id="txtEndNomeOM" name="txtEndNomeOM" placeholder="Ex.: Constantino Nery">
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="txtEndNumOM">Número: </label><spam class="campo-obrigatorio"> *</spam>
                                        <input type="text" class="form-control" id="txtEndNumOM" name="txtEndNumOM" placeholder="Ex.: 1000">
                                    </div>                                 
                                </div>                        
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label for="txtEndPaisOM">País: </label><spam class="campo-obrigatorio"> *</spam>
                                        <select class="form-control" id="txtEndPaisOM" name="txtEndPaisOM">
                                            <option value="0" selected>Selecione um País...</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="txtEndEstadoOM">Estado: </label><spam class="campo-obrigatorio"> *</spam>
                                        <select class="form-control" id="txtEndEstadoOM" name="txtEndEstadoOM">
                                            <option value="0" selected>Selecione um Estado...</option>
                                        </select>
                                    </div>                                    
                                    <div class="form-group col-md-3">
                                        <label for="txtEndCidadeOM">Cidade: </label><spam class="campo-obrigatorio"> *</spam>
                                        <select class="form-control" id="txtEndCidadeOM" name="txtEndCidadeOM">
                                            <option value="0" selected>Selecione uma Cidade...</option>
                                        </select>
                                    </div>                                    
                                    <div class="form-group col-md-3">
                                        <label for="txtEndBairroOM">Bairro: </label><spam class="campo-obrigatorio"> *</spam>
                                        <select class="form-control" id="txtEndBairoOM" name="txtEndBairroOM">
                                            <option value="0" selected>Selecione um Bairro...</option>
                                        </select>
                                    </div>                                    
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="txtEndCompOM">Complemento: </label>
                                        <input type="text" class="form-control" id="txtEndCompOM" name="txtCompOM" placeholder="Ex.: Quadra, Apartamento etc.">
                                    </div> 
                                    <div class="form-group col-md-6">
                                        <label for="txtEndPtRefom">Ponto de Referência: </label>
                                        <input type="text" class="form-control" id="txtEndPtRefOM" name="txtEndPtRefOM" placeholder="Ex.: Próximo a Arena da Amazônia">
                                    </div> 
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <button type="button" name="btnProximo" class="btn btn-danger prox acao" value="Proximo">Próximo</button>
                </fieldset>
                <fieldset>
                    <div class="fieldset-header">
                        <h5 class="fieldset-title">Dados Individuais</h5>
                    </div>
                    <div class="fieldset-body">
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="txtPGradAl">Posto/Graduação: </label><spam class="campo-obrigatorio"> *</spam>
                                <select class="form-control" id="txtPGradAl" name="txtPGradAl">
                                    <option value="0" selected>Selecione um Posto/Graduação...</option>                                     
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtArmaAl">Arma: </label><spam class="campo-obrigatorio"> *</spam>
                                <select class="form-control" id="txtArmaAl" name="txtArmaAl">
                                    <option value="0" selected>Selecione uma Arma...</option>                                     
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtDataPracaAl">Última Data de Praça: </label><spam class="campo-obrigatorio"> *</spam>
                                <input type="text" class="form-control" id="txtDataPracaAl" name="txtDataPracaAl" placeholder="Ex.: DD/MM/AAAA">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="txtNomeAl">Nome: </label><spam class="campo-obrigatorio"> *</spam>
                                <input type="text" class="form-control" id="txtNomeAl" name="txtNomeAl" placeholder="Ex.: Fulano">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="txtSobrenomeAl">Sobrenome: </label><spam class="campo-obrigatorio"> *</spam>
                                <input type="text" class="form-control" id="txtSobrenomeAl" name="txtSobrenomeAl" placeholder="Ex.: de Tal">
                            </div>
                            <div class="form-group col-md-3">
                                <label for="txtNomeGuerraAl">Nome Guerra: </label><spam class="campo-obrigatorio"> *</spam>
                                <input type="text" class="form-control" id="txtNomeGuerraAl" name="txtNomeGuerraAl" placeholder="Ex.: De Tal">
                            </div>                
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="txtIdtMilAl">Identidade Militar: </label><spam class="campo-obrigatorio"> *</spam>
                                <input type="text" class="form-control" id="txtIdtMilAl" name="txtIdtMilAl" placeholder="Ex. 000000000-0">
                            </div>
                            <div class="form-group col-md-3">
                                <label for="txtPreccpAl">Prec-CP: </label>
                                <input type="text" class="form-control" id="txtPreccpAl" name="txtPreccpAl" placeholder="Ex.: 000000000">
                            </div>
                            <div class="form-group col-md-3">
                                <label for="txtCPAl">CP: </label>
                                <input type="text" class="form-control" id="txtCPAl" name="txtCPAl" placeholder="Ex.: 000000">
                            </div>
                            <div class="form-group col-md-3">
                                <label for="txtCpfAl">CPF: </label><spam class="campo-obrigatorio"> *</spam>
                                <input type="text" class="form-control" id="txtCpfAl" name="txtCpfAl" placeholder="Ex.: 000.000.000-00">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="txtDataNascAl">Data de Nascimento: </label><spam class="campo-obrigatorio"> *</spam>
                                <input type="text" class="form-control" id="txtDataNascAl" name="txtDataNascAl" placeholder="Ex.: DD/MM/AAAA">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtNatEstAl">Naturalidade (Estado): </label><spam class="campo-obrigatorio"> *</spam>
                                <input type="text" class="form-control" id="txtNatEstAl" name="txtNatEstAl" placeholder="Ex.: Amazonas">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtNatCidAl">Naturalidade (Cidade): </label><spam class="campo-obrigatorio"> *</spam>
                                <input type="text" class="form-control" id="txtNatCidAl" name="txtNatCidAl" placeholder="Ex.: Manaus">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="txtEstCivilAl">Estado Civil: </label><spam class="campo-obrigatorio"> *</spam>
                                <select class="form-control" id="txtEstCivilAl" name="txtEstCivilAl">
                                    <option value="0" selected>Selecione um estado civil...</option>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="txtSexoAl">Sexo: </label><spam class="campo-obrigatorio"> *</spam>
                                <select class="form-control" id="txtSexoAl" name="txtSexoAl">
                                    <option value="0" selected>Selecione um sexo...</option>
                                    <option value="m">Masculino</option>
                                    <option value="f">Feminino</option>
                                </select>
                            </div>
                        </div>   
                        <div class="form-row">
                            <div class="form-group col-md-2">
                                <label for="txtTSAl">Tipo Sanguíneo: </label><spam class="campo-obrigatorio"> *</spam>
                                <select class="form-control" id="txtTSAl" name="txtTSAl">
                                    <option value="0" selected>Selecione um tipo sanguíneo...</option>
                                    <option value="a">A</option>
                                    <option value="b">B</option>
                                    <option value="ab">AB</option>
                                    <option value="o">O</option>
                                </select>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="txtFatorRHAl">Fator RH: </label><spam class="campo-obrigatorio"> *</spam>
                                <select class="form-control" id="txtFatorRHAl" name="txtFatorRHAl">
                                    <option value="0" selected>Selecione um fator RH...</option>
                                    <option value="pos">+</option>
                                    <option value="neg">-</option>
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtPaiAl">Pai: </label>
                                <input type="text" class="form-control" id="txtPaiAl" name="txtPaiAl" placeholder="Ex.: Fulano de Tal">
                            </div>  

                            <div class="form-group col-md-4">
                                <label for="txtMaeAl">Mãe: </label>
                                <input type="text" class="form-control" id="txtMaeAl" name="txtMaeAl" placeholder="Ex.: Fulana de Tal">
                            </div>                                                    
                        </div>
                                               
                        <div class="header-interno">
                            <h5 class="title-interno">Título Eleitoral</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <label for="txtTitEleitorNumAl">Título Eleitoral: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtTitEleitorNumAl" name="txtTitEleitorNumAl" placeholder="Ex.: 0000 0000 0000">
                                </div>  

                                <div class="form-group col-md-2">
                                    <label for="txtTitEleitorZonaAl">Zona Eleitoral: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtTitEleitorZonaAl" name="txtTitEleitorZonaAl" placeholder="Ex.: 000">
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="txtTitEleitorSecaoAl">Seção Eleitoral: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtTitEleitorSecaoAl" name="txtTitEleitorSecaoAl" placeholder="Ex.: 0000">
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="txtTitEleitorEstAl">Estado: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtTitEleitorEstAl" name="txtTitEleitorAl" placeholder="Ex.: Amazonas">
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="txtTitEleitorCidAl">Cidade: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtTitEleitorCidAl" name="txtTitEleitorCidAl" placeholder="Ex.: Manaus">
                                </div>                                                      
                            </div>
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Informações Bancárias</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="txtBancoAl">Banco: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtBancoAl" name="txtBancoAl" placeholder="Ex.: Banco do Brasil">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="txtAgenciaAl">Agência: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtAgenciaAl" name="txtAgenciaAl" placeholder="Ex.: 0000-0">
                                </div>                                                     
                                <div class="form-group col-md-4">
                                    <label for="txtContaAl">Conta: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtContaAl" name="txtContaAl" placeholder="Ex.: 00000000000-0">
                                </div>                                                     
                            </div>
                        </div>                        
                        <div class="header-interno">
                            <h5 class="title-interno">Contatos</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-8">
                                    <label for="txtEmailAl">Email: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtEmailAl" name="txtEmailAl" placeholder="Ex.: fulanodetal@gmail.com">
                                </div>  

                                <div class="form-group col-md-4">
                                    <label for="txtFoneAl">Fone: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtFoneAl" name="txtFoneAl" placeholder="Ex.: (00) 00000-0000">
                                </div>                                                     
                            </div>
                        </div>                       
                                                
                        <div class="header-interno">
                            <h5 class="title-interno">Uniforme</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <label for="txtNumCoturnoAl">Número Coturno: </label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtTamCoturnoAl" name="txtTamCoturnoAl">
                                        <option value="0" selected>Selecione um tamanho...</option>
                                        <option value="37">37</option>
                                        <option value="38">38</option>
                                        <option value="39">39</option>
                                        <option value="40">40</option>
                                        <option value="41">41</option>
                                        <option value="42">42</option>
                                        <option value="43">43</option>
                                        <option value="44">44</option>
                                        <option value="45">45</option>
                                        <option value="46">46</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="txtTamGandAl">Tamanho Gandola: </label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtTamGandAl" name="txtTamGandAl">
                                        <option value="0" selected>Selecione um tamanho...</option>
                                        <option value="pp">PP</option>
                                        <option value="p">P</option>
                                        <option value="m">M</option>
                                        <option value="g">G</option>
                                        <option value="gg">GG</option>
                                    </select>
                                </div>                                                     
                                <div class="form-group col-md-3">
                                    <label for="txtTamCalcaAl">Tamanho Calça: </label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtTamCalcaAl" name="txtTamCalcaAl">
                                        <option value="0" selected>Selecione um tamanho...</option>
                                        <option value="pp">PP</option>
                                        <option value="p">P</option>
                                        <option value="m">M</option>
                                        <option value="g">G</option>
                                        <option value="gg">GG</option>
                                    </select>
                                </div>                                                     
                                <div class="form-group col-md-3">
                                    <label for="txtTamCamisaCamufladaAl">Tamanho Camisa Camfuflada: </label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtTamCamisaCamufladaAl" name="txtTamCamisaCamufladaAl">
                                        <option value="0" selected>Selecione um tamanho...</option>
                                        <option value="pp">PP</option>
                                        <option value="p">P</option>
                                        <option value="m">M</option>
                                        <option value="g">G</option>
                                        <option value="gg">GG</option>
                                    </select>
                                </div>                                                     
                            </div>
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Cateira Nacional de Habilitação - CNH</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="txtPossuiCNH">Possui CNH?</label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtPossuiCNH" name="txtPossuiCNH">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div id="divCNH" class="fieldset-interno fieldset-dependente" style="display: none;">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="txtCNHNumAl">Número: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtCNHNumAl" name="txtCNHNumAl" placeholder="Ex. 00000000000">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="txtCNHCatAl">Categoria: </label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtCNHCatAl" name="txtCNHCatAl">
                                        <option value="0" selected>Selecione uma categoria...</option>
                                        <option value="a">A</option>
                                        <option value="b">B</option>
                                        <option value="ab">AB</option>
                                        <option value="c">C</option>
                                        <option value="d">D</option>
                                        <option value="e">E</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="txtCNHDataValAl">Data de Validade: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtCNHDataValAl" name="txtCNHDataValAl" placeholder="Ex. 00/00/0000">
                                </div>  
                            </div>
                        </div>                        
                        <div class="header-interno">
                            <h5 class="title-interno">Veículo</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="txtTraraVeiculo">Durante o curso trará veículo para o CIGS?</label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtTraraVeiculo" name="txtTraraVeiculo">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div id="divVeiculos" class="fieldset-interno fieldset-dependente" style="display: none;">
                            <div class="header-interno">
                                <h5 class="title-interno">Veículos</h5>
                            </div>
                            <div id="fieldsetVeiculos" class="fieldset-interno">

                            </div>
                            <button type="button" id="btnAddVeiculo" name="btnAddVeiculo" class="btn btn-success" style="margin-left: 0; font-weight: bold; ">+</button>
                        </div>                       
                    </div>
                    <button type="button" name="btnVoltar" class="btn btn-dark anterior acao">Anterior</button>
                    <button type="button" name="btnProximo" class="btn btn-danger prox acao" value="Proximo">Próximo</button>
                </fieldset>
                <fieldset>
                    <div class="fieldset-header">
                        <h5 class="fieldset-title">Saúde</h5>
                    </div>
                    <div class="fieldset-body">
                        <div class="header-interno">
                            <h5 class="title-interno">Saúde</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="txtFumante">Fumante?</label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtFumante" name="txtFumante">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="txtAlergico">Alérgico?</label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtAlergico" name="txtAlergico">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                            </div>
                            <div id="divAlergia" class="fieldset-interno fieldset-dependente" style="display: none;">
                                <div class="header-interno">
                                    <h5 class="title-interno">Alergias</h5>
                                </div>
                                <div id="fieldsetAlergias" class="fieldset-interno">
                                    
                                </div>
                                <button type="button" id="btnAddAlergia" name="btnAddAlergia" class="btn btn-success" style="margin-left: 0; font-weight: bold; ">+</button>
                            </div>
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Medicação</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="txtUsoMtoCt">Faz uso de medicamentos controlados?</label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtUsoMtoCt" name="txtUsoMtoCt">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div id="divMtoCt" class="fieldset-interno fieldset-dependente" style="display: none;">
                            <div class="header-interno">
                                <h5 class="title-interno">Medicamento Controlado</h5>
                            </div>
                            <div id="fieldsetMtoCt" class="fieldset-interno">

                            </div>
                            <button type="button" id="btnAddMtoCt" name="btnAddMtoCt" class="btn btn-success" style="margin-left: 0; font-weight: bold; ">+</button>
                        </div>
                    </div>
                    <button type="button" name="btnVoltar" class="btn btn-dark anterior acao">Anterior</button>
                    <button type="button" name="btnProximo" class="btn btn-danger prox acao" value="Proximo">Próximo</button>
                </fieldset>
                <fieldset>
                    <div class="fieldset-header">
                        <h5 class="fieldset-title">Dados Militares</h5>
                    </div>
                    <div class="fieldset-body">
                        <div class="header-interno">
                            <h5 class="title-interno">Formação</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">                                
                                <div class="form-group col-md-7">
                                    <label for="txtFormEscNome">Escola de Formação: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtFormEscNome" name="txtFormEscNome" placeholder="Ex.: Escola de Sargentos das Armas">
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="txtFormEscAbrev">Abreviatura: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtFormEscAbrev" name="txtFormEscAbrev" placeholder="Ex.: ESA">
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="txtFormTurma">Turma</label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtFormTurma" name="txtFormTurma" placeholder="Ex.: 2018">
                                </div>  
                            </div>                            
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Comportamento</h5>
                        </div>
                        <div class="fieldset-interno">                            
                            <div class="form-row">                                
                                <div class="form-group col-md-12">
                                    <label for="txtComportamento">Comportamento:</label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtComportamento" name="txtComportamento">
                                        <option value="0" selected>Selecione um comportamento...</option>
                                    </select>
                                </div>                                
                            </div>                            
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Promoção</h5>
                        </div>
                        <div class="fieldset-interno">                            
                            <div class="form-row">                            
                            <div class="form-group col-md-4">
                                <label for="txtDataUltPromo">Data da última promoção: </label><spam class="campo-obrigatorio"> *</spam>
                                <input type="text" class="form-control" id="txtDataUltPromo" name="txtDataUltPromo" placeholder="Ex.: DD/MM/AAAA">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtQaPromo">Está no QA para Promoção?</label><spam class="campo-obrigatorio"> *</spam>
                                <select class="form-control" id="txtQaPromo" name="txtQaPromo">
                                    <option value="0" selected>Selecione SIM ou NÃO...</option>
                                    <option value="s">SIM</option>
                                    <option value="n">NÃO</option>
                                </select>
                            </div>
                                <div id="divQaQuando" class="form-group col-md-4" style="display: none;">
                                <label for="txtQaQuanoPromo">Quando?</label><spam class="campo-obrigatorio"> *</spam>
                                <input type="text" class="form-control" id="txtQaQuanoPromo" name="txtQaQuanoPromo" placeholder="Ex.: DD/MM/AAAA">
                            </div>
                        </div>                            
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Teste de Aptidão Física - TAF</h5>
                        </div>
                        <div class="fieldset-interno">                            
                            <div class="form-row">                                
                                <div class="form-group col-md-6">
                                    <label for="txtDataUltTaf">Data do último TAF:</label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtDataUltTaf" name="txtDataUltTaf" placeholder="Ex.: 00/00/0000">
                                </div>                                
                                <div class="form-group col-md-6">
                                    <label for="txtMencaoTAF">Menção:</label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtMencaoTAF" name="txtMencaoTAF">
                                        <option value="0" selected>Selecione uma menção...</option>
                                        <option value="I">I</option>
                                        <option value="R">R</option>
                                        <option value="B">B</option>
                                        <option value="MB">MB</option>
                                        <option value="E">E</option>
                                    </select>
                                </div>                                
                            </div> 
                            
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Últimas três funções</h5>
                        </div>
                        <div class="fieldset-interno">                            
                            <div class="form-row">                                
                                <div class="form-group col-md-4">
                                    <label for="txtFunc1">Função 1:</label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtFunc1" name="txtFunc1" placeholder="Ex.: Cmt Pel">
                                </div>                                
                                <div class="form-group col-md-4">
                                    <label for="txtFunc2">Função 2:</label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtFunc2" name="txtFunc2" placeholder="Ex.: Cmt Cia">
                                </div>                                
                                <div class="form-group col-md-4">
                                    <label for="txtFunc3">Função 3:</label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtFunc3" name="txtFunc3" placeholder="Ex.: Enc Mat">
                                </div>                         
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
                                    <label for="txtParentesco">Parentesco: </label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtParentesco" name="txtParentesco">
                                        <option value="0" selected>Selecione um Parentesco...</option>
                                    </select>
                                </div>

                                <div class="form-group col-md-8">
                                    <label for="txtNome">Nome: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtNome" name="txtNome" placeholder="Nome">
                                </div>               
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <label for="txtCpf">CPF: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtCpf" name="txtCpf" placeholder="CPF">
                                </div> 

                                <div class="form-group col-md-3">
                                    <label for="txttxtFone">Fone: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txttxtFone" name="txtFone" placeholder="Fone">
                                </div>

                                <div class="form-group col-md-6">
                                    <label for="txtEmail">Email: </label><spam class="campo-obrigatorio"> *</spam>
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
                                    <label for="txtCpf">CPF: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtCpf" name="txtCpf" placeholder="CPF">
                                </div> 

                                <div class="form-group col-md-8">
                                    <label for="txtNome">Nome: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtNome" name="txtNome" placeholder="Nome">
                                </div>               
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="txttxtFone">Fone: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txttxtFone" name="txtFone" placeholder="Fone">
                                </div>

                                <div class="form-group col-md-8">
                                    <label for="txtEmail">Email: </label><spam class="campo-obrigatorio"> *</spam>
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
                                <div class="form-group col-md-2">
                                    <label for="txtCEP">CEP: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtCEP" name="txtCEP" placeholder="CEP">
                                </div> 
                                
                                <div class="form-group col-md-3">
                                    <label for="txtLog">Logradouro: </label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtLog" name="txtLog">
                                        <option value="0" selected>Selecione um Logradouro...</option>
                                        <option value="Av">Avenida</option>
                                        <option value="Rua">Rua</option>                                        
                                    </select>
                                </div>

                                <div class="form-group col-md-6">
                                    <label for="txtNome">Nome: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtNome" name="txtNome" placeholder="Nome">
                                </div>
                                <div class="form-group col-md-1">
                                    <label for="txtNum">Número: </label><spam class="campo-obrigatorio"> *</spam>
                                    <input type="text" class="form-control" id="txtNum" name="txtNum" placeholder="Número">
                                </div>                                 
                            </div>                        
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <label for="txtPais">País: </label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtPais" name="txtPais">
                                        <option value="0" selected>Selecione um País...</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="txtEstado">Estado: </label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtEstado" name="txtEstado">
                                        <option value="0" selected>Selecione um Estado...</option>
                                    </select>
                                </div>                                    
                                <div class="form-group col-md-3">
                                    <label for="txtCidade">Cidade: </label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtCidade" name="txtCidade">
                                        <option value="0" selected>Selecione uma Cidade...</option>
                                    </select>
                                </div>                                    
                                <div class="form-group col-md-3">
                                    <label for="txtBairro">Bairro: </label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtBairo" name="txtBairro">
                                        <option value="0" selected>Selecione um Bairro...</option>
                                    </select>
                                </div>                                    
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="txtEndCompOM">Complemento: </label>
                                    <input type="text" class="form-control" id="txtEndCompOM" name="txtCompOM" placeholder="Ex.: Quadra, Apartamento etc.">
                                </div> 
                                <div class="form-group col-md-6">
                                    <label for="txtEndPtRefom">Ponto de Referência: </label>
                                    <input type="text" class="form-control" id="txtEndPtRefOM" name="txtEndPtRefOM" placeholder="Ex.: Próximo a Arena da Amazônia">
                                </div> 
                            </div>
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Endereço residencial durante o curso</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="txtEndCurso">Endereço: </label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtEndCurso" name="txtEndCurso">
                                        <option value="0" selected>Selecione o endereço...</option>                                        
                                        <option value="resid">O mesmo de Residência</option>
                                        <option value="cigs">CIGS</option>
                                        <option value="novo">Novo</option>
                                    </select>
                                </div>                                                 
                            </div>
                            <div class="fieldset-interno">
                                <div class="form-row">
                                    <div class="form-group col-md-2">
                                        <label for="txtCepEndCurso">CEP: </label>
                                        <input type="text" class="form-control" id="txtCepEndCurso" name="txtCepEndCurso" placeholder="CEP">
                                    </div> 

                                    <div class="form-group col-md-3">
                                        <label for="txtLogEndCurso">Logradouro: </label>
                                        <select class="form-control" id="txtLogEndCurso" name="txtLogEndCurso">
                                            <option value="0" selected>Selecione um Logradouro...</option>
                                            <option value="Av">Avenida</option>
                                            <option value="Rua">Rua</option>                                        
                                        </select>
                                    </div>

                                    <div class="form-group col-md-6">
                                        <label for="txtNomeEndCurso">Nome: </label>
                                        <input type="text" class="form-control" id="txtNomeEndCurso" name="txtNomeEndCurso" placeholder="Nome">
                                    </div>
                                    <div class="form-group col-md-1">
                                        <label for="txtNumEndCurso">Número: </label>
                                        <input type="text" class="form-control" id="txtNumEndCurso" name="txtNumEndCurso" placeholder="Número">
                                    </div> 
                                </div>                        
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label for="txtPaisEndCurso">País: </label>
                                        <select class="form-control" id="txtPaisEndCurso" name="txtPaisEndCurso">
                                            <option value="0" selected>Selecione um País...</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="txtEstadoEndCurso">Estado: </label>
                                        <select class="form-control" id="txtEstadoEndCurso" name="txtEstadoEndCurso">
                                            <option value="0" selected>Selecione um Estado...</option>
                                        </select>
                                    </div>                                    
                                    <div class="form-group col-md-3">
                                        <label for="txtCidadeEndCurso">Cidade: </label>
                                        <select class="form-control" id="txtCidadeEndCurso" name="txtCidadeEndCurso">
                                            <option value="0" selected>Selecione uma Cidade...</option>
                                        </select>
                                    </div>                                    
                                    <div class="form-group col-md-3">
                                        <label for="txtBairroEndCurso">Bairro: </label>
                                        <select class="form-control" id="txtBairo" name="txtBairroEndCurso">
                                            <option value="0" selected>Selecione um Bairro...</option>
                                        </select>
                                    </div>                                    
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="txtEndCompOM">Complemento: </label>
                                        <input type="text" class="form-control" id="txtEndCompOM" name="txtCompOM" placeholder="Ex.: Quadra, Apartamento etc.">
                                    </div> 
                                    <div class="form-group col-md-6">
                                        <label for="txtEndPtRefom">Ponto de Referência: </label>
                                        <input type="text" class="form-control" id="txtEndPtRefOM" name="txtEndPtRefOM" placeholder="Ex.: Próximo a Arena da Amazônia">
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
                        <h5 class="fieldset-title">Idiomas, Cursos e Estágios</h5>
                    </div>
                    <div class="fieldset-body">
                        <div class="header-interno">
                            <h5 class="title-interno">Idiomas</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="txtHabIdiomas">É habilitado em Idiomas?</label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtHabIdiomas" name="txtHabIdiomas">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div id="divIdiomas" class="fieldset-interno fieldset-dependente" style="display: none;">
                            <div class="header-interno">
                                <h5 class="title-interno">Idiomas</h5>
                            </div>
                            <div id="fieldsetIdiomas" class="fieldset-interno">

                            </div>
                            <button type="button" id="btnAddIdioma" name="btnAddIdioma" class="btn btn-success" style="margin-left: 0; font-weight: bold; ">+</button>
                        </div>
                        
                        <div class="header-interno">
                            <h5 class="title-interno">Cursos</h5>
                        </div>
                        <div class="fieldset-interno">                            
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="txtPossuiCAperf">Possui curso de aperfeiçoamento?</label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtPossuiCAperf" name="txtPossuiCAperf">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                                
                                <div class="form-group col-md-4">
                                    <label for="txtPossuiCAltEstudos">Possui cursos de altos estudos?</label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtPossuiCAltEstudos" name="txtPossuiCAltEstudos">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="txtPossuiCExtsEsp">Possui cursos extensão ou especialização?</label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtPossuiCExtsEsp" name="txtPossuiCExtsEsp">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div id="divCAperf" class="fieldset-interno fieldset-dependente" style="display: none;">
                            <div class="header-interno">
                                <h5 class="title-interno">Curso de Aperfeiçoamento</h5>
                            </div>
                            <div id="fieldsetCAperf" class="fieldset-interno">
                                <div class="form-row">
                                    <div class="form-group col-md-8">
                                        <label for="txtCAperf">Curso: </label><spam class="campo-obrigatorio"> *</spam>
                                        <input type="text" class="form-control" id="txtCAperf" name="txtCAperf" placeholder="Ex.: ESAO">
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="txtAnCAperf">Ano de Conclusão: </label><spam class="campo-obrigatorio"> *</spam>
                                        <input type="text" class="form-control" id="txtAnoCAperf" name="txtAnoCAperf" placeholder="Ex.: 2018">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="divCAltEstudos" class="fieldset-interno fieldset-dependente" style="display: none;">
                            <div class="header-interno">
                                <h5 class="title-interno">Cursos de Altos Estudos</h5>
                            </div>
                            <div id="fieldsetCAltEstudos" class="fieldset-interno">

                            </div>
                            <button type="button" id="btnAddCAltEstudos" name="btnAddCAltEstudos" class="btn btn-success" style="margin-left: 0; font-weight: bold; ">+</button>
                        </div>
                        
                        <div id="divCExtsEsp" class="fieldset-interno fieldset-dependente" style="display: none;">
                            <div class="header-interno">
                                <h5 class="title-interno">Curso de Extensão ou Especialização</h5>
                            </div>
                            <div id="fieldsetCExtsEsp" class="fieldset-interno">

                            </div>
                            <button type="button" id="btnAddCExtsEsp" name="btnAddCExtsEsp" class="btn btn-success" style="margin-left: 0; font-weight: bold; ">+</button>
                        </div>
                        
                        <div class="header-interno">
                            <h5 class="title-interno">Estágios</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="txtPossuiEstMil">Possui estágios militares operacionais?</label><spam class="campo-obrigatorio"> *</spam>
                                    <select class="form-control" id="txtPossuiEstMil" name="txtPossuiEstMil">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div id="divEstagios" class="fieldset-interno fieldset-dependente" style="display: none;">
                            <div class="header-interno">
                                <h5 class="title-interno">Estágios</h5>
                            </div>
                            <div id="fieldsetEstagios" class="fieldset-interno">

                            </div>
                            <button type="button" id="btnAddEstagio" name="btnAddEstagio" class="btn btn-success" style="margin-left: 0; font-weight: bold; ">+</button>
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
                                <label for="txtPrepFisica">Sua preparação física foi? </label><spam class="campo-obrigatorio"> *</spam>
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
                                <label for="txtApoioFam">Obteve apoio de sua família para realização do curso? </label><spam class="campo-obrigatorio"> *</spam>
                                <select class="form-control" id="txtApoioFam" name="txtApoioFam">
                                    <option value="0" selected>Selecione SIM ou NÃO...</option>
                                    <option value="S">SIM</option>
                                    <option value="N">NÃO</option>
                                </select>
                            </div>                              
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="txtApoioOM">Obteve apoio de sua OM durante o período de preparação para COS? </label><spam class="campo-obrigatorio"> *</spam>
                                <select class="form-control" id="txtApoioOM" name="txtApoioOM">
                                    <option value="0" selected>Selecione SIM ou NÃO...</option>
                                    <option value="S">SIM</option>
                                    <option value="N">NÃO</option>
                                </select>
                            </div>                              
                            <div class="form-group col-md-6">
                                <label for="txtCPrepCOS">Sua OM proporcionou um Curso de Preparação para o COS? </label><spam class="campo-obrigatorio"> *</spam>
                                <select class="form-control" id="txtCPrepCOS" name="txtCPrepCOS">
                                    <option value="0" selected>Selecione SIM ou NÃO...</option>
                                    <option value="S">SIM</option>
                                    <option value="N">NÃO</option>
                                </select>
                            </div>                              
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="txtProbRend">Há problemas que possam vir a comprometer seu rendimento no COS? </label><spam class="campo-obrigatorio"> *</spam>
                                <select class="form-control" id="txtProbRend" name="txtProbRend">
                                    <option value="0" selected>Selecione SIM ou NÃO...</option>
                                    <option value="S">SIM</option>
                                    <option value="N">NÃO</option>
                                </select>
                            </div>                              
                            <div class="form-group col-md-6">
                                <label for="txtTempoPrep">O tempo de sua preparação foi suficiente? </label><spam class="campo-obrigatorio"> *</spam>
                                <select class="form-control" id="txtTempoPrep" name="txtTempoPrep">
                                    <option value="0" selected>Selecione SIM ou NÃO...</option>
                                    <option value="S">SIM</option>
                                    <option value="N">NÃO</option>
                                </select>
                            </div>                              
                        </div>
                        <div class="form-row">                                                        
                            <div class="form-group col-md-6">
                                <label for="txtConsultaSite">Consultou o site do CIGS? </label><spam class="campo-obrigatorio"> *</spam>
                                <select class="form-control" id="txtConsultaSite" name="txtConsultaSite">
                                    <option value="0" selected>Selecione SIM ou NÃO...</option>
                                    <option value="S">SIM</option>
                                    <option value="N">NÃO</option>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="txtFatorMotivacao">Qual o fator que o motivou a realizar o COS? </label><spam class="campo-obrigatorio"> *</spam>
                                <input type="text" class="form-control" id="txtFatorMotivacao" name="txtFatorMotivacao" placeholder="Apenas um fator">
                            </div>                                                           
                        </div>
                        <div class="form-row">     
                            <div class="form-group col-md-12">
                                <label for="txtDedicacaoDoutOPS">Dedicou tempo suficiente para seu preparo intelectual no assunto de Doutrina de Operações na Selva? </label><spam class="campo-obrigatorio"> *</spam>
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
