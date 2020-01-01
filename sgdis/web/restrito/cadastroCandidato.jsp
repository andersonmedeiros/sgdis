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
                                <label for="txtForca">Força: <span class="campo-obrigatorio">*</span></label>
                                <select class="form-control" id="txtForca" name="txtForca">
                                    <option value="0" selected>Selecione uma Força...</option>                                  
                                    <option value="mb">Marinha do Barsil</option>                                  
                                    <option value="eb">Exército Brasileiro</option>                                  
                                    <option value="fab">Força Aérea Brasileira</option>                                  
                                    <option value="1000">Outra</option>                                  
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtGCmdo">Grande Comando: <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control" id="txtGCmdo" name="txtGCmdo" placeholder="Ex.: CMA"> 
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtEscEnq">Escalão Enquadrante: <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control" id="txtEscEnq" name="txtEscEnq" placeholder="Ex.: 12ª RM, 16ª Bda Inf Sl etc."> 
                            </div>
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Organização Militar - OM</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">                            
                                <div class="form-group col-md-3">
                                    <label for="txtAbrevOM">Abreviatura: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtAbrevOM" name="txtAbrevOM" placeholder="Ex.: CIGS"> 
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="txtNomeOM">Nome: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtNomeOM" name="txtNomeOM" placeholder="Ex.: Centro de Instrução de Guerra na Selva"> 
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="txtFoneOM">Fone: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtFoneOM" name="txtFoneOM" placeholder="Ex.: (00) 0000-0000"> 
                                </div>
                            </div>
                            <div class="header-interno">
                                <h5 class="title-interno">Comandante</h5>
                            </div>
                            <div class="fieldset-interno">
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label for="txtPGradCmtOM">Posto/Graduação: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtPGradCmtOM" name="txtPGradCmtOM">
                                            <option value="0" selected>Selecione um Posto/Graduação...</option>                                     
                                        </select>
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="txtNomeCmtOM">Nome: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtNomeCmtOM" name="txtNomeCmtOM" placeholder="Ex.: Fulano"> 
                                    </div>
                                    <div class="form-group col-md-5">
                                        <label for="txtSobrenomeCmtOM">Sobrenome: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtSobrenomeCmtOM" name="txtSobrenomeCmtOM" placeholder="Ex.: de Tal"> 
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="txtNomeGuerraCmtOM">Nome de Guerra: <span class="campo-obrigatorio">*</span></label>
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
                                        <label for="txtPGradChImtoOM">Posto/Graduação: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtPGradChImtoOM" name="txtPGradChImtoOM">
                                            <option value="0" selected>Selecione um Posto/Graduação...</option>                                     
                                        </select>
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="txtNomeChImtoOM">Nome: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtNomeChImtoOM" name="txtNomeChImtoOM" placeholder="Ex.: Fulano"> 
                                    </div>
                                    <div class="form-group col-md-5">
                                        <label for="txtSobrenomeChImtoOM">Sobrenome: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtSobrenomeChImtoOM" name="txtSobrenomeChImtoOM" placeholder="Ex.: de Tal"> 
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="txtNomeGuerraChImtoOM">Nome de Guerra: <span class="campo-obrigatorio">*</span></label>
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
                                        <label for="txtEndCepOM">CEP: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtEndCepOM" name="txtEndCepOM" placeholder="Ex.: 00000-000">
                                    </div> 

                                    <div class="form-group col-md-3">
                                        <label for="txtEndLogOM">Logradouro: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtEndLogOM" name="txtEndLogOM">
                                            <option value="0" selected>Selecione um Logradouro...</option>                                      
                                        </select>
                                    </div>

                                    <div class="form-group col-md-5">
                                        <label for="txtEndNomeOM">Nome: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtEndNomeOM" name="txtEndNomeOM" placeholder="Ex.: Constantino Nery">
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="txtEndNumOM">Número: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtEndNumOM" name="txtEndNumOM" placeholder="Ex.: 1000">
                                    </div>                                 
                                </div>                        
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label for="txtEndPaisOM">País: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtEndPaisOM" name="txtEndPaisOM">
                                            <option value="0" selected>Selecione um País...</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="txtEndEstadoOM">Estado: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtEndEstadoOM" name="txtEndEstadoOM">
                                            <option value="0" selected>Selecione um Estado...</option>
                                        </select>
                                    </div>                                    
                                    <div class="form-group col-md-3">
                                        <label for="txtEndCidadeOM">Cidade: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtEndCidadeOM" name="txtEndCidadeOM">
                                            <option value="0" selected>Selecione uma Cidade...</option>
                                        </select>
                                    </div>                                    
                                    <div class="form-group col-md-3">
                                        <label for="txtEndBairroOM">Bairro: <span class="campo-obrigatorio">*</span></label>
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
                                        <label for="txtEndPtRefOM">Ponto de Referência: </label>
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
                                <label for="txtPGradAl">Posto/Graduação: <span class="campo-obrigatorio">*</span></label>
                                <select class="form-control" id="txtPGradAl" name="txtPGradAl">
                                    <option value="0" selected>Selecione um Posto/Graduação...</option>                                     
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtArmaAl">Arma: <span class="campo-obrigatorio">*</span></label>
                                <select class="form-control" id="txtArmaAl" name="txtArmaAl">
                                    <option value="0" selected>Selecione uma Arma...</option>                                     
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtDataPracaAl">Última Data de Praça: <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control" id="txtDataPracaAl" name="txtDataPracaAl" placeholder="Ex.: DD/MM/AAAA">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="txtNomeAl">Nome: <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control" id="txtNomeAl" name="txtNomeAl" placeholder="Ex.: Fulano">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="txtSobrenomeAl">Sobrenome: <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control" id="txtSobrenomeAl" name="txtSobrenomeAl" placeholder="Ex.: de Tal">
                            </div>
                            <div class="form-group col-md-3">
                                <label for="txtNomeGuerraAl">Nome Guerra: <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control" id="txtNomeGuerraAl" name="txtNomeGuerraAl" placeholder="Ex.: De Tal">
                            </div>                
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="txtIdtMilAl">Identidade Militar: <span class="campo-obrigatorio">*</span></label>
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
                                <label for="txtCpfAl">CPF: <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control" id="txtCpfAl" name="txtCpfAl" placeholder="Ex.: 000.000.000-00">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="txtDataNascAl">Data de Nascimento: <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control" id="txtDataNascAl" name="txtDataNascAl" placeholder="Ex.: DD/MM/AAAA">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtNatEstAl">Naturalidade (Estado): <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control" id="txtNatEstAl" name="txtNatEstAl" placeholder="Ex.: Amazonas">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtNatCidAl">Naturalidade (Cidade): <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control" id="txtNatCidAl" name="txtNatCidAl" placeholder="Ex.: Manaus">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="txtEstCivilAl">Estado Civil: <span class="campo-obrigatorio">*</span></label>
                                <select class="form-control" id="txtEstCivilAl" name="txtEstCivilAl">
                                    <option value="0" selected>Selecione um estado civil...</option>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="txtSexoAl">Sexo: <span class="campo-obrigatorio">*</span></label>
                                <select class="form-control" id="txtSexoAl" name="txtSexoAl">
                                    <option value="0" selected>Selecione um sexo...</option>
                                    <option value="m">Masculino</option>
                                    <option value="f">Feminino</option>
                                </select>
                            </div>
                        </div>   
                        <div class="form-row">
                            <div class="form-group col-md-2">
                                <label for="txtTSAl">Tipo Sanguíneo: <span class="campo-obrigatorio">*</span></label>
                                <select class="form-control" id="txtTSAl" name="txtTSAl">
                                    <option value="0" selected>Selecione um tipo sanguíneo...</option>
                                    <option value="a">A</option>
                                    <option value="b">B</option>
                                    <option value="ab">AB</option>
                                    <option value="o">O</option>
                                </select>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="txtFatorRHAl">Fator RH: <span class="campo-obrigatorio">*</span></label>
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
                                    <label for="txtTitEleitorNumAl">Título Eleitoral: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtTitEleitorNumAl" name="txtTitEleitorNumAl" placeholder="Ex.: 0000 0000 0000">
                                </div>  

                                <div class="form-group col-md-2">
                                    <label for="txtTitEleitorZonaAl">Zona Eleitoral: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtTitEleitorZonaAl" name="txtTitEleitorZonaAl" placeholder="Ex.: 000">
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="txtTitEleitorSecaoAl">Seção Eleitoral: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtTitEleitorSecaoAl" name="txtTitEleitorSecaoAl" placeholder="Ex.: 0000">
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="txtTitEleitorEstAl">Estado: <span class="campo-obrigatorio"> *</span></label>
                                    <input type="text" class="form-control" id="txtTitEleitorEstAl" name="txtTitEleitorAl" placeholder="Ex.: Amazonas">
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="txtTitEleitorCidAl">Cidade: <span class="campo-obrigatorio"> *</span></label>
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
                                    <label for="txtBancoAl">Banco: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtBancoAl" name="txtBancoAl" placeholder="Ex.: Banco do Brasil">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="txtAgenciaAl">Agência: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtAgenciaAl" name="txtAgenciaAl" placeholder="Ex.: 0000-0">
                                </div>                                                     
                                <div class="form-group col-md-4">
                                    <label for="txtContaAl">Conta: <span class="campo-obrigatorio">*</span></label>
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
                                    <label for="txtEmailAl">Email: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtEmailAl" name="txtEmailAl" placeholder="Ex.: fulanodetal@gmail.com">
                                </div>  

                                <div class="form-group col-md-4">
                                    <label for="txtFoneAl">Fone: <span class="campo-obrigatorio">*</span></label>
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
                                    <label for="txtNumCoturnoAl">Número Coturno: <span class="campo-obrigatorio">*</span></label>
                                    <select class="form-control" id="txtNumCoturnoAl" name="txtNumCoturnoAl">
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
                                    <label for="txtTamGandAl">Tamanho Gandola: <span class="campo-obrigatorio">*</span></label>
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
                                    <label for="txtTamCalcaAl">Tamanho Calça: <span class="campo-obrigatorio">*</span></label>
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
                                    <label for="txtTamCamCmfAl">Tamanho Camisa Camfuflada: <span class="campo-obrigatorio">*</span></label>
                                    <select class="form-control" id="txtTamCamCmfAl" name="txtTamCamCmfAl">
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
                                <div class="form-group col-md-12">
                                    <label for="txtPossuiCNH">Possui CNH?<span class="campo-obrigatorio"> *</span></label>
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
                                    <label for="txtCNHNumAl">Número: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtCNHNumAl" name="txtCNHNumAl" placeholder="Ex. 00000000000">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="txtCNHCatgAl">Categoria: <span class="campo-obrigatorio">*</span></label>
                                    <select class="form-control" id="txtCNHCatgAl" name="txtCNHCatgAl">
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
                                    <label for="txtCNHDataValAl">Data de Validade: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtCNHDataValAl" name="txtCNHDataValAl" placeholder="Ex. 00/00/0000">
                                </div>  
                            </div>
                        </div>                        
                        <div class="header-interno">
                            <h5 class="title-interno">Veículo</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="txtTraraVeiculo">Durante o curso trará veículo para o CIGS?<span class="campo-obrigatorio"> *</span></label>
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
                                <div class="form-group col-md-12">
                                    <label for="txtFumante">Fumante?<span class="campo-obrigatorio"> *</span></label>
                                    <select class="form-control" id="txtFumante" name="txtFumante">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Alergia</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="txtAlergico">Alérgico?<span class="campo-obrigatorio"> *</span></label>
                                    <select class="form-control" id="txtAlergico" name="txtAlergico">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div id="divAlergias" class="fieldset-interno fieldset-dependente" style="display: none;">
                            <div class="header-interno">
                                <h5 class="title-interno">Quais?</h5>
                            </div>
                            <div id="fieldsetAlergias" class="fieldset-interno">

                            </div>
                            <button type="button" id="btnAddAlergia" name="btnAddAlergia" class="btn btn-success" style="margin-left: 0; font-weight: bold; ">+</button>
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Medicação</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="txtUsoMtoCt">Faz uso de medicamentos controlados?<span class="campo-obrigatorio"> *</span></label>
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
                                <h5 class="title-interno">Quais?</h5>
                            </div>
                            <div id="fieldsetMtoCt" class="fieldset-interno">

                            </div>
                            <button type="button" id="btnAddMtoCt" name="btnAddMtoCt" class="btn btn-success" style="margin-left: 0; font-weight: bold; ">+</button>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="txtUsoTermErgSupAli">Fez uso de Termogênicos, Ergogênicos ou Suplementos Alimentares a menos de 3 meses?<span class="campo-obrigatorio"> *</span></label>
                                    <select class="form-control" id="txtUsoTermErgSupAli" name="txtUsoTermErgSupAli">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div id="divTermErgSupAli" class="fieldset-interno fieldset-dependente" style="display: none;">
                            <div class="header-interno">
                                <h5 class="title-interno">Quais?</h5>
                            </div>
                            <div id="fieldsetTermErgSupAli" class="fieldset-interno">

                            </div>
                            <button type="button" id="btnAddTermErgSupAli" name="btnAddTermErgSupAli" class="btn btn-success" style="margin-left: 0; font-weight: bold; ">+</button>
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
                                    <label for="txtFormEscNome">Escola de Formação: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtFormEscNome" name="txtFormEscNome" placeholder="Ex.: Escola de Sargentos das Armas">
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="txtFormEscAbrev">Abreviatura: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtFormEscAbrev" name="txtFormEscAbrev" placeholder="Ex.: ESA">
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="txtFormTurma">Turma: <span class="campo-obrigatorio">*</span></label>
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
                                    <label for="txtCptmAl">Comportamento: <span class="campo-obrigatorio">*</span></label>
                                    <select class="form-control" id="txtCptmAl" name="txtCptmAl">
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
                                <label for="txtDataUltProm">Data da última promoção: <span class="campo-obrigatorio">*</span></label>
                                <input type="text" class="form-control" id="txtDataUltProm" name="txtDataUltProm" placeholder="Ex.: DD/MM/AAAA">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtQaProm">Está no QA para Promoção?<span class="campo-obrigatorio"> *</span></label>
                                <select class="form-control" id="txtQaProm" name="txtQaProm">
                                    <option value="0" selected>Selecione SIM ou NÃO...</option>
                                    <option value="s">SIM</option>
                                    <option value="n">NÃO</option>
                                </select>
                            </div>
                                <div id="divQaQuando" class="form-group col-md-4" style="display: none;">
                                <label for="txtQaQuanoProm">Quando?<span class="campo-obrigatorio"> *</span></label>
                                <input type="text" class="form-control" id="txtQaQuanoProm" name="txtQaQuanoProm" placeholder="Ex.: DD/MM/AAAA">
                            </div>
                        </div>                            
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Teste de Aptidão Física - TAF</h5>
                        </div>
                        <div class="fieldset-interno">                            
                            <div class="form-row">                                
                                <div class="form-group col-md-6">
                                    <label for="txtDataUltTAF">Data do último TAF: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtDataUltTAF" name="txtDataUltTAF" placeholder="Ex.: 00/00/0000">
                                </div>                                
                                <div class="form-group col-md-6">
                                    <label for="txtMencaoTAF">Menção: <span class="campo-obrigatorio">*</span></label>
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
                            <h5 class="title-interno">Últimas Três Funções</h5>
                        </div>
                        <div class="fieldset-interno">                            
                            <div class="form-row">                                
                                <div class="form-group col-md-4">
                                    <label for="txtFunc1">Função 1: <span class="campo-obrigatorio"> *</span></label>
                                    <input type="text" class="form-control" id="txtFunc1" name="txtFunc1" placeholder="Ex.: Cmt Pel">
                                </div>                                
                                <div class="form-group col-md-4">
                                    <label for="txtFunc2">Função 2: <span class="campo-obrigatorio"> *</span></label>
                                    <input type="text" class="form-control" id="txtFunc2" name="txtFunc2" placeholder="Ex.: Cmt Cia">
                                </div>                                
                                <div class="form-group col-md-4">
                                    <label for="txtFunc3">Função 3: <span class="campo-obrigatorio"> *</span></label>
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
                            <h5 class="title-interno">Cônjuge</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="txtPossuiConjuge">Possui Cônjuge?<span class="campo-obrigatorio"> *</span></label>
                                    <select class="form-control" id="txtPossuiConjuge" name="txtPossuiConjuge">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div id="divConjuge" class="fieldset-interno fieldset-dependente" style="display: none;">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="txtCpfConjuge">CPF: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtCpfConjuge" name="txtCpfConjuge" placeholder="Ex.: 000.000.000-00">
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="txtNomeConjuge">Nome: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtNomeConjuge" name="txtNomeConjuge" placeholder="Ex.: Fulano">
                                </div>
                                <div class="form-group col-md-5">
                                    <label for="txtSobrenomeConjuge">Sobrenome: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtSobrenomeConjuge" name="txtSobrenomeConjuge" placeholder="Ex.: de Tal">
                                </div>               
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-8">
                                    <label for="txtEmailConjuge">Email: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtEmailConjuge" name="txtEmailConjuge" placeholder="Ex.: fulanodetal@gmail.com">
                                </div>                                  
                                <div class="form-group col-md-4">
                                    <label for="txtFoneConjuge">Fone: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtFoneConjuge" name="txtFoneConjuge" placeholder="Ex.: (00) 00000-0000">
                                </div>
                            </div>
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Referência</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="txtParentescoRef">Parentesco: <span class="campo-obrigatorio">*</span></label>
                                    <select class="form-control" id="txtParentescoRef" name="txtParentescoRef">
                                        <option value="0" selected>Selecione um Parentesco...</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="txtNomeRef">Nome: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtNomeRef" name="txtNomeRef" placeholder="Ex.: Fulano">
                                </div>
                                <div class="form-group col-md-5">
                                    <label for="txtSobrenomeRef">Sobrenome: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtSobrenomeRef" name="txtSobrenomeRef" placeholder="Ex.: de Tal">
                                </div>               
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <label for="txtCpfRef">CPF: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtCpfRef" name="txtCpfRef" placeholder="Ex.: 000.000.000-00">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="txtEmailRef">Email: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtEmailRef" name="txtEmailRef" placeholder="Ex.: fulanodetal@gmail.com">
                                </div> 
                                <div class="form-group col-md-3">
                                    <label for="txtFoneRef">Fone: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtFoneRef" name="txtFoneRef" placeholder="Ex.: (00) 00000-0000">
                                </div>                                 
                            </div>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="txtAddRefConclusao">Deseja adicionar um contato como referência em caso de conclusão do curso e demais informações?<span class="campo-obrigatorio"> *</span></label>
                                    <select class="form-control" id="txtAddRefConclusao" name="txtAddRefConclusao">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div id="divRefConclusao" class="fieldset-interno fieldset-dependente" style="display: none;">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="txtParentescoRefConclusao">Parentesco: <span class="campo-obrigatorio">*</span></label>
                                    <select class="form-control" id="txtParentescoRefConclusao" name="txtParentescoRefConclusao">
                                        <option value="0" selected>Selecione um Parentesco...</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="txtNomeRefConclusao">Nome: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtNomeRefConclusao" name="txtNomeRefConclusao" placeholder="Ex.: Fulano">
                                </div>
                                <div class="form-group col-md-5">
                                    <label for="txtSobrenomeRefConclusao">Sobrenome: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtSobrenomeRefConclusao" name="txtSobrenomeRefConclusao" placeholder="Ex.: de Tal">
                                </div>               
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <label for="txtCpfRefConclusao">CPF: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtCpfRefConclusao" name="txtCpfRefConclusao" placeholder="Ex.: 000.000.000-00">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="txtEmailRefConclusao">Email: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtEmailRefConclusao" name="txtEmailRefConclusao" placeholder="Ex.: fulanodetal@gmail.com">
                                </div> 
                                <div class="form-group col-md-3">
                                    <label for="txtFoneRefConclusao">Fone: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtFoneRefConclusao" name="txtFoneRefConclusao" placeholder="Ex.: (00) 00000-0000">
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
                                    <label for="txtCepEndResid">CEP: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtCepEndResid" name="txtCepEndResid" placeholder="Ex.: 00000-000">
                                </div> 

                                <div class="form-group col-md-3">
                                    <label for="txtLogEndResid">Logradouro: <span class="campo-obrigatorio">*</span></label>
                                    <select class="form-control" id="txtLogEndResid" name="txtLogEndResid">
                                        <option value="0" selected>Selecione um Logradouro...</option>                                      
                                    </select>
                                </div>

                                <div class="form-group col-md-5">
                                    <label for="txtNomeEndResid">Nome: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtNomeEndResid" name="txtNomeEndResid" placeholder="Ex.: Constantino Nery">
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="txtNumEndResid">Número: <span class="campo-obrigatorio">*</span></label>
                                    <input type="text" class="form-control" id="txtNumEndResid" name="txtNumEndResid" placeholder="Ex.: 1000">
                                </div>                                 
                            </div>                        
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <label for="txtPaisEndResid">País: <span class="campo-obrigatorio">*</span></label>
                                    <select class="form-control" id="txtPaisEndResid" name="txtPaisEndResid">
                                        <option value="0" selected>Selecione um País...</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="txtEstadoEndResid">Estado: <span class="campo-obrigatorio">*</span></label>
                                    <select class="form-control" id="txtEstadoEndResid" name="txtEstadoEndResid">
                                        <option value="0" selected>Selecione um Estado...</option>
                                    </select>
                                </div>                                    
                                <div class="form-group col-md-3">
                                    <label for="txtCidadeEndResid">Cidade: <span class="campo-obrigatorio">*</span></label>
                                    <select class="form-control" id="txtCidadeEndResid" name="txtCidadeEndResid">
                                        <option value="0" selected>Selecione uma Cidade...</option>
                                    </select>
                                </div>                                    
                                <div class="form-group col-md-3">
                                    <label for="txtBairroEndResid">Bairro: <span class="campo-obrigatorio">*</span></label>
                                    <select class="form-control" id="txtBairoEndResid" name="txtBairroEndResid">
                                        <option value="0" selected>Selecione um Bairro...</option>
                                    </select>
                                </div>                                    
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="txtCompEndResid">Complemento: </label>
                                    <input type="text" class="form-control" id="txtCompEndResid" name="txtCompEndResid" placeholder="Ex.: Quadra, Apartamento etc.">
                                </div> 
                                <div class="form-group col-md-6">
                                    <label for="txtPtRefEndResid">Ponto de Referência: </label>
                                    <input type="text" class="form-control" id="txtPtRefEndResid" name="txtPtRefEndResid" placeholder="Ex.: Próximo a Arena da Amazônia">
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
                                        <label for="txtCepEndCurso">CEP: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtCepEndCurso" name="txtCepEndCurso" placeholder="Ex.: 00000-000">
                                    </div> 

                                    <div class="form-group col-md-3">
                                        <label for="txtLogEndCurso">Logradouro: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtLogEndCurso" name="txtLogEndCurso">
                                            <option value="0" selected>Selecione um Logradouro...</option>                                      
                                        </select>
                                    </div>

                                    <div class="form-group col-md-5">
                                        <label for="txtNomeEndCurso">Nome: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtNomeEndCurso" name="txtNomeEndCurso" placeholder="Ex.: Constantino Nery">
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="txtNumEndCurso">Número: <span class="campo-obrigatorio">*</span></label>
                                        <input type="text" class="form-control" id="txtNumEndCurso" name="txtNumEndCurso" placeholder="Ex.: 1000">
                                    </div>                                 
                                </div>                        
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label for="txtPaisEndCurso">País: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtPaisEndCurso" name="txtPaisEndCurso">
                                            <option value="0" selected>Selecione um País...</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="txtEstadoEndCurso">Estado: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtEstadoEndCurso" name="txtEstadoEndCurso">
                                            <option value="0" selected>Selecione um Estado...</option>
                                        </select>
                                    </div>                                    
                                    <div class="form-group col-md-3">
                                        <label for="txtCidadeEndCurso">Cidade: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtCidadeEndCurso" name="txtCidadeEndCurso">
                                            <option value="0" selected>Selecione uma Cidade...</option>
                                        </select>
                                    </div>                                    
                                    <div class="form-group col-md-3">
                                        <label for="txtBairroEndCurso">Bairro: <span class="campo-obrigatorio">*</span></label>
                                        <select class="form-control" id="txtBairroEndCurso" name="txtBairroEndCurso">
                                            <option value="0" selected>Selecione um Bairro...</option>
                                        </select>
                                    </div>                                    
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="txtCompEndCurso">Complemento: </label>
                                        <input type="text" class="form-control" id="txtCompEndCurso" name="txtCompEndCurso" placeholder="Ex.: Quadra, Apartamento etc.">
                                    </div> 
                                    <div class="form-group col-md-6">
                                        <label for="txtPtRefEndCurso">Ponto de Referência: </label>
                                        <input type="text" class="form-control" id="txtPtRefEndCurso" name="txtPtRefEndCurso" placeholder="Ex.: Próximo a Arena da Amazônia">
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
        <script src="../assets/js/bootstrap-validate.js"></script>
        <script>
            
                bootstrapValidate("#txtNomeOM", "min:5:Minimo 5 porra, caralho");
        </script>
    </body>
</html>
