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
                                <label for="txtForca">Força: </label>
                                <select class="form-control" id="txtForca" name="txtForca">
                                    <option value="0" selected>Selecione uma Força...</option>                                  
                                    <option value="1000">Outra</option>                                  
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtGCmdo">Grande Comando: </label>
                                <input type="text" class="form-control" id="txtGCmdo" name="txtGCmdo" placeholder="Ex.: CMA"> 
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtEscEnq">Escalão Enquadrante: </label>
                                <input type="text" class="form-control" id="txtEscEnq" name="txtEscEnq" placeholder="Ex.: 12ª RM, 16ª Bda Inf Sl etc."> 
                            </div>
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Organização Militar - OM</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">                            
                                <div class="form-group col-md-3">
                                    <label for="txtAbrevOM">Abreviatura: </label>
                                    <input type="text" class="form-control" id="txtAbrevOM" name="txtAbrevOM" placeholder="Ex.: CIGS"> 
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="txtNomeOM">Nome: </label>
                                    <input type="text" class="form-control" id="txtNomeOM" name="txtNomeOM" placeholder="Ex.: Centro de Instrução de Guerra na Selva"> 
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="txtFoneOM">Fone: </label>
                                    <input type="text" class="form-control" id="txtFoneOM" name="txtFoneOM" placeholder="Ex.: (00) 0000-0000"> 
                                </div>
                            </div>
                            <div class="header-interno">
                                <h5 class="title-interno">Comandante</h5>
                            </div>
                            <div class="fieldset-interno">
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label for="txtPGradCmtOM">Posto/Graduação: </label>
                                        <select class="form-control" id="txtPGradCmtOM" name="txtPGradCmtOM">
                                            <option value="0" selected>Selecione um Posto/Graduação...</option>                                     
                                        </select>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="txtNomeCmtOM">Nome Completo: </label>
                                        <input type="text" class="form-control" id="txtNomeCmtOM" name="txtNomeCmtOM" placeholder="Ex.: Fulano de Tal"> 
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="txtNomeGuerraCmtOM">Nome de Guerra: </label>
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
                                        <label for="txtPGradChImtoOM">Posto/Graduação: </label>
                                        <select class="form-control" id="txtPGradChImtoOM" name="txtPGradChImtoOM">
                                            <option value="0" selected>Selecione um Posto/Graduação...</option>                                     
                                        </select>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="txtNomeChImtoOM">Nome Completo: </label>
                                        <input type="text" class="form-control" id="txtNomeChImtoOM" name="txtNomeChImtoOM" placeholder="Ex.: Fulano de Tal"> 
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="txtNomeGuerraChImtoOM">Nome de Guerra: </label>
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
                                        <label for="txtEndCepOM">CEP: </label>
                                        <input type="text" class="form-control" id="txtEndCepOM" name="txtEndCepOM" placeholder="CEP">
                                    </div> 

                                    <div class="form-group col-md-3">
                                        <label for="txtEndLogOM">Logradouro: </label>
                                        <select class="form-control" id="txtEndLogOM" name="txtEndLogOM">
                                            <option value="0" selected>Selecione um Logradouro...</option>
                                            <option value="Av">Avenida</option>
                                            <option value="Rua">Rua</option>                                        
                                        </select>
                                    </div>

                                    <div class="form-group col-md-6">
                                        <label for="txtEndNomeOM">Nome: </label>
                                        <input type="text" class="form-control" id="txtEndNomeOM" name="txtEndNomeOM" placeholder="Nome">
                                    </div>
                                    <div class="form-group col-md-1">
                                        <label for="txtEndNumOM">Número: </label>
                                        <input type="text" class="form-control" id="txtEndNumOM" name="txtEndNumOM" placeholder="Número">
                                    </div>                                 
                                </div>                        
                                <div class="form-row">
                                    <div class="form-group col-md-3">
                                        <label for="txtEndPaisOM">País: </label>
                                        <select class="form-control" id="txtEndPaisOM" name="txtEndPaisOM">
                                            <option value="0" selected>Selecione um País...</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="txtEndEstadoOM">Estado: </label>
                                        <select class="form-control" id="txtEndEstadoOM" name="txtEndEstadoOM">
                                            <option value="0" selected>Selecione um Estado...</option>
                                        </select>
                                    </div>                                    
                                    <div class="form-group col-md-3">
                                        <label for="txtEndCidadeOM">Cidade: </label>
                                        <select class="form-control" id="txtEndCidadeOM" name="txtEndCidadeOM">
                                            <option value="0" selected>Selecione uma Cidade...</option>
                                        </select>
                                    </div>                                    
                                    <div class="form-group col-md-3">
                                        <label for="txtEndBairroOM">Bairro: </label>
                                        <select class="form-control" id="txtEndBairoOM" name="txtEndBairroOM">
                                            <option value="0" selected>Selecione um Bairro...</option>
                                        </select>
                                    </div>                                    
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label for="txtEndPtRefom">Ponto de Referência: </label>
                                        <input type="text" class="form-control" id="txtEndPtRefOM" name="txtEndPtRefOM" placeholder="Ponto de Referência">
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
                            <div class="form-group col-md-6">
                                <label for="txtPGrad">Posto/Graduação: </label>
                                <select class="form-control" id="txtPGrad" name="txtPGrad">
                                    <option value="0" selected>Selecione um Posto/Graduação...</option>                                     
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="txtDataPraca">Última Data de Praça: </label>
                                <input type="text" class="form-control" id="txtDataPraca" name="txtDataPraca" placeholder="Ex.: DD/MM/AAAA">
                            </div>
                        </div>
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
                                <label for="txtIdtMil">Identidade Militar: </label>
                                <input type="text" class="form-control" id="txtIdtMil" name="txtIdtMil" placeholder="Ex. 000000000-0">
                            </div>                           

                            <div class="form-group col-md-3">
                                <label for="txtPreccp">Prec-CP: </label>
                                <input type="text" class="form-control" id="txtPreccp" name="txtPreccp" placeholder="Ex.: 000000000">
                            </div>
                            
                            <div class="form-group col-md-3">
                                <label for="txtCP">CP: </label>
                                <input type="text" class="form-control" id="txtCP" name="txtCP" placeholder="Ex.: 000000">
                            </div>
                            
                            <div class="form-group col-md-3">
                                <label for="txtCpf">CPF: </label>
                                <input type="text" class="form-control" id="txtCpf" name="txtCpf" placeholder="Ex.: 000.000.000-00">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="txtDataNasc">Data de Nascimento: </label>
                                <input type="text" class="form-control" id="txtDataNasc" name="txtDataNasc" placeholder="Ex.: DD/MM/AAAA">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtNatEst">Naturalidade (Estado): </label>
                                <input type="text" class="form-control" id="txtNatEst" name="txtNatEst" placeholder="Estado">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtNatCid">Naturalidade (Cidade): </label>
                                <input type="text" class="form-control" id="txtNatCid" name="txtNatCid" placeholder="Cidade">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="txtEstCivil">Estado Civil: </label>
                                <select class="form-control" id="txtEstCivil" name="txtEstCivil">
                                    <option value="0" selected>Selecione um estado civil...</option>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="txtSexo">Sexo: </label>
                                <select class="form-control" id="txtSexo" name="txtSexo">
                                    <option value="0" selected>Selecione um sexo...</option>
                                    <option value="M">Masculino</option>
                                    <option value="F">Feminino</option>
                                </select>
                            </div>
                        </div>   
                        <div class="form-row">
                            <div class="form-group col-md-2">
                                <label for="txtSexo">Tipo Sanguíneo: </label>
                                <select class="form-control" id="txtSexo" name="txtSexo">
                                    <option value="0" selected>Selecione um tipo sanguíneo...</option>
                                    <option value="M">O</option>
                                    <option value="F">A</option>
                                </select>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="txtSexo">Fator RH: </label>
                                <select class="form-control" id="txtSexo" name="txtSexo">
                                    <option value="0" selected>Selecione um fator RH...</option>
                                    <option value="M">+</option>
                                    <option value="F">-</option>
                                </select>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtPai">Pai: </label>
                                <input type="text" class="form-control" id="txtPai" name="txtPai" placeholder="Pai">
                            </div>  

                            <div class="form-group col-md-4">
                                <label for="txtMae">Mãe: </label>
                                <input type="text" class="form-control" id="txtMae" name="txtMae" placeholder="Mãe">
                            </div>                                                    
                        </div>
                                               
                        <div class="header-interno">
                            <h5 class="title-interno">Título Eleitoral</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <label for="txtTituloEleitor">Título Eleitoral: </label>
                                    <input type="text" class="form-control" id="txtTituloEleitor" name="txtTituloEleitor" placeholder="Titulo Eleitor">
                                </div>  

                                <div class="form-group col-md-2">
                                    <label for="txtZona">Zona Eleitoral: </label>
                                    <input type="text" class="form-control" id="txtZona" name="txtZona" placeholder="Zona">
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="txtSecao">Seção Eleitoral: </label>
                                    <input type="text" class="form-control" id="txtSecao" name="txtSecao" placeholder="Seção">
                                </div>                              
                                <div class="form-group col-md-2">
                                    <label for="txtCidade">Cidade: </label>
                                    <input type="text" class="form-control" id="txtCidade" name="txtCidade" placeholder="Cidade">
                                </div>                              
                                <div class="form-group col-md-2">
                                    <label for="txtEstado">Estado: </label>
                                    <input type="text" class="form-control" id="txtEstado" name="txtEstado" placeholder="Estado">
                                </div>                              
                            </div>
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Informações Bancárias</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="txtBanco">Banco: </label>
                                    <input type="text" class="form-control" id="txtBanco" name="txtBanco" placeholder="Banco">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="txtAgencia">Agência: </label>
                                    <input type="text" class="form-control" id="txtAgencia" name="txtAgencia" placeholder="Agência">
                                </div>                                                     
                                <div class="form-group col-md-4">
                                    <label for="txtConta">Conta: </label>
                                    <input type="text" class="form-control" id="txtConta" name="txtConta" placeholder="Conta">
                                </div>                                                     
                            </div>
                        </div>                        
                        <div class="header-interno">
                            <h5 class="title-interno">Contatos</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-8">
                                    <label for="txtEmail">Email: </label>
                                    <input type="text" class="form-control" id="txtEmail" name="txtEmail" placeholder="Ex.: fulanodetal@gmail.com">
                                </div>  

                                <div class="form-group col-md-4">
                                    <label for="txtFone">Fone: </label>
                                    <input type="text" class="form-control" id="txtFone" name="txtFone" placeholder="Ex.: (00) 00000-0000">
                                </div>                                                     
                            </div>
                        </div>                       
                                                
                        <div class="header-interno">
                            <h5 class="title-interno">Uniforme</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <label for="txtNumCoturno">Número Coturno: </label>
                                    <select class="form-control" id="txtTamCoturno" name="txtTamCoturno">
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
                                    <label for="txtTamGand">Tamanho Gandola: </label>
                                    <select class="form-control" id="txtTamGand" name="txtTamGand">
                                        <option value="0" selected>Selecione um tamanho...</option>
                                        <option value="pp">PP</option>
                                        <option value="p">P</option>
                                        <option value="m">M</option>
                                        <option value="g">G</option>
                                        <option value="gg">GG</option>
                                    </select>
                                </div>                                                     
                                <div class="form-group col-md-3">
                                    <label for="txtTamCalca">Tamanho Calça: </label>
                                    <select class="form-control" id="txtTamCalca" name="txtTamCalca">
                                        <option value="0" selected>Selecione um tamanho...</option>
                                        <option value="pp">PP</option>
                                        <option value="p">P</option>
                                        <option value="m">M</option>
                                        <option value="g">G</option>
                                        <option value="gg">GG</option>
                                    </select>
                                </div>                                                     
                                <div class="form-group col-md-3">
                                    <label for="txtTamCamisaCamuflada">Tamanho Camisa Camfuflada: </label>
                                    <select class="form-control" id="txtTamCamisaCamuflada" name="txtTamCamisaCamuflada">
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
                                    <label for="txtPossuiCNH">Possui CNH?</label>
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
                                    <label for="txtCNHNum">Número: </label>
                                    <input type="text" class="form-control" id="txtCNHNum" name="txtCNHNum" placeholder="Ex. 00000000000">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="txtCNHCat">Categoria: </label>
                                    <select class="form-control" id="txtCNHCat" name="txtCNHCat">
                                        <option value="0" selected>Selecione uma categoria...</option>
                                        <option value="A">A</option>
                                        <option value="B">B</option>
                                        <option value="AB">AB</option>
                                        <option value="C">C</option>
                                        <option value="D">D</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="txtCNHDataVal">Data de Validade: </label>
                                    <input type="text" class="form-control" id="txtCNHDataVal" name="txtCNHDataVal" placeholder="Ex. 00/00/0000">
                                </div>  
                            </div>
                        </div>                        
                        <div class="header-interno">
                            <h5 class="title-interno">Veículo</h5>
                        </div>
                        <div class="fieldset-interno">
                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="txtPossuiVeiculo">Possui Veículo?</label>
                                    <select class="form-control" id="txtPossuiVeiculo" name="txtPossuiVeiculo">
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
                                    <label for="txtFumante">Fumante?</label>
                                    <select class="form-control" id="txtFumante" name="txtFumante">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="txtAlergico">Alérgico?</label>
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
                                <div class="form-group col-md-3">
                                    <label for="txtFormEscAbrev">Escola de Formação: Abreviatura</label>
                                    <input type="text" class="form-control" id="txtFormEscAbrev" name="txtFormEscAbrev" placeholder="Ex.: ESA">
                                </div>
                                <div class="form-group col-md-7">
                                    <label for="txtFormEscNome">Escola de Formação: Nome</label>
                                    <input type="text" class="form-control" id="txtFormEscNome" name="txtFormEscNome" placeholder="Ex.: Escola de Sargentos das Armas">
                                </div>  
                                <div class="form-group col-md-2">
                                    <label for="txtFormTurma">Turma</label>
                                    <input type="text" class="form-control" id="txtFormTurma" name="txtFormTurma" placeholder="Ex.: 2018">
                                </div>  
                            </div>                            
                        </div>
                        <div class="header-interno">
                            <h5 class="title-interno">Comportamento</h5>
                        </div>
                        <div class="fieldset-interno">                            
                            <div class="form-row">                                
                                <div class="form-group col-md-4">
                                    <label for="txtComportamento">Comportamento:</label>
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
                                <label for="txtDataUltPromo">Data da última promoção: </label>
                                <input type="text" class="form-control" id="txtDataUltPromo" name="txtDataUltPromo" placeholder="Ex.: DD/MM/AAAA">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="txtQaPromo">Está no QA para Promoção?</label>
                                <select class="form-control" id="txtQaPromo" name="txtQaPromo">
                                    <option value="0" selected>Selecione SIM ou NÃO...</option>
                                    <option value="s">SIM</option>
                                    <option value="n">NÃO</option>
                                </select>
                            </div>
                                <div id="divQaQuando" class="form-group col-md-4" style="display: none;">
                                <label for="txtQaQuanoPromo">Quando?</label>
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
                                    <label for="txtDataUltTaf">Data do último TAF:</label>
                                    <input type="text" class="form-control" id="txtDataUltTaf" name="txtDataUltTaf" placeholder="Ex.: 00/00/0000">
                                </div>                                
                                <div class="form-group col-md-6">
                                    <label for="txtMencaoTAF">Menção:</label>
                                    <select class="form-control" id="txtMencaoTAF" name="txtMencaoTAF">
                                        <option value="0" selected>Selecione uma menção...</option>
                                        <option value="I" selected>I</option>
                                        <option value="R" selected>R</option>
                                        <option value="B" selected>B</option>
                                        <option value="MB" selected>MB</option>
                                        <option value="E" selected>E</option>
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
                                    <label for="txtFunc1">Função 1:</label>
                                    <input type="text" class="form-control" id="txtFunc1" name="txtFunc1" placeholder="Ex.: Cmt Pel">
                                </div>                                
                                <div class="form-group col-md-4">
                                    <label for="txtFunc2">Função 2:</label>
                                    <input type="text" class="form-control" id="txtFunc2" name="txtFunc2" placeholder="Ex.: Cmt Cia">
                                </div>                                
                                <div class="form-group col-md-4">
                                    <label for="txtFunc3">Função 3:</label>
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
                                <div class="form-group col-md-2">
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
                                <div class="form-group col-md-1">
                                    <label for="txtNum">Número: </label>
                                    <input type="text" class="form-control" id="txtNum" name="txtNum" placeholder="Número">
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
                                    <label for="txtEndCurso">Endereço: </label>
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
                                    <div class="form-group col-md-12">
                                        <label for="txtPtRefEndCurso">Ponto de Referência: </label>
                                        <input type="text" class="form-control" id="txtPtRef" name="txtPtRefEndCurso" placeholder="Ponto de Referência">
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
                                    <label for="txtHabIdiomas">É habilitado em Idiomas?</label>
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
                                    <label for="txtPossuiCAperf">Possui curso de aperfeiçoamento?</label>
                                    <select class="form-control" id="txtPossuiCAperf" name="txtPossuiCAperf">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                                
                                <div class="form-group col-md-4">
                                    <label for="txtPossuiCAltEstudos">Possui cursos de altos estudos?</label>
                                    <select class="form-control" id="txtPossuiCAltEstudos" name="txtPossuiCAltEstudos">
                                        <option value="0" selected>Selecione SIM ou NÃO...</option>
                                        <option value="s">SIM</option>
                                        <option value="n">NÃO</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="txtPossuiCExtsEsp">Possui cursos extensão ou especialização?</label>
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
                                        <label for="txtCAperf">Curso: </label>
                                        <input type="text" class="form-control" id="txtCAperf" name="txtCAperf" placeholder="Ex.: ESAO">
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="txtAnCAperf">Ano de Conclusão: </label>
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
                                    <label for="txtPossuiEstMil">Possui estágios militares operacionais?</label>
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
