/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function(){
   var atual_fs, prox_fs, anterior_fs;
   
   $('.prox').click(function(){
       atual_fs = $(this).parent();
       prox_fs = $(this).parent().next();
       $('#progress li').eq($('fieldset').index(prox_fs)).addClass('ativo');
       atual_fs.hide(800);
       prox_fs.show(800);
        
   });
   
   $('.anterior').click(function(){
       atual_fs = $(this).parent();
       anterior_fs = $(this).parent().prev();
       $('#progress li').eq($('fieldset').index(atual_fs)).removeClass('ativo');
       atual_fs.hide(800);
       anterior_fs.show(800);
        
   });
   
   $('#formCadCandidato button[type=button]').click(function(){
      return false; 
   });
    
});

$("#txtEndCurso").change(function() {
    //Endereço do Centro de Instrução de Guerra na Selva
    if($("#txtEndCurso").val() === "cigs"){
        $("#txtCepEndCurso").val("69033000");
        
        $("#txtLogEndCurso").val("");
        $("#txtNomeEndCurso").val("São Jorge");
        $("#txtNumEndCurso").val("750");
        $("#txtPaisEndCurso").val("0");
        $("#txtEstadoEndCurso").val("0");
        $("#txtCidadeEndCurso").val("");
        $("#txtBairroEndCurso").val("");
        $("#txtPtRefEndCurso").val("");
    }
    //Mesmo endereço de residêcnia
    else if($("#txtEndCurso").val() === "resid"){
        $("#txtCepEndCurso").val($("#txtCEP").val());
    }
    //Novo
    else if($("#txtEndCurso").val() === "novo" || $("#txtEndCurso").val() === "0"){
        $("#txtCepEndCurso").val("");
        $("#txtLogEndCurso").val("");
        $("#txtNomeEndCurso").val("");
        $("#txtNumEndCurso").val("");
        $("#txtPaisEndCurso").val("0");
        $("#txtEstadoEndCurso").val("0");
        $("#txtCidadeEndCurso").val("0");
        $("#txtBairroEndCurso").val("0");
        $("#txtPtRefEndCurso").val("0");
    }
});

//Acionamento form CNH
$("#txtPossuiCNH").change(function() {
    if($("#txtPossuiCNH").val() === "s"){
        $("#divCNH").css("display", "block");
    }
    else if($("#txtPossuiCNH").val() === "n" || $("#txtPossuiCNH").val() === "0"){
        $("#divCNH").css("display", "none");
    }
});

//Acionamento form Veiculos
var qtdeVeiculos = document.querySelectorAll('#fieldsetVeiculos .form-row').length + 1;

$("#txtTraraVeiculo").change(function() {    
    if($("#txtTraraVeiculo").val() === "s"){
        $("#divVeiculos").css("display", "block");        
    }
    else if($("#txtTraraVeiculo").val() === "n" || $("#txtTraraVeiculo").val() === "0"){
        $("#divVeiculos").css("display", "none");
        $("#fieldsetVeiculos .form-row").remove();
        qtdeVeiculos = 1;
    }
});

$("#btnAddVeiculo").click(function(){           
    $("#linha" + qtdeVeiculos).remove();
    $("#fieldsetVeiculos").append("<div id=linha"+ qtdeVeiculos +" class=\"form-row\">"+
                                  "  <div class=\"form-group col-md-2\">"+
                                  "      <label for=txtTipoVeiculoAl"+ qtdeVeiculos +">Tipo: <span class=\"campo-obrigatorio\">*</span></label>"+
                                  "      <select class=\"form-control\" id=txtTipoVeiculoAl"+ qtdeVeiculos +" name=\"txtTipoVeiculoAl\">"+
                                  "         <option value=\"0\" selected>Selecione o tipo...</option>"+
                                  "         <option value=\"motocicleta\">Motocicleta</option>"+
                                  "         <option value=\"automovel\">Automóvel</option>"+
                                  "         <option value=\"microonibus\">Microônibus</option>"+
                                  "         <option value=\"onibus\">Ônibus</option>"+
                                  "     </select>"+
                                  "  </div>"+
                                  "  <div class=\"form-group col-md-3\">"+
                                  "      <label for=txtMarcaVeiculoAl"+ qtdeVeiculos +">Marca: <span class=\"campo-obrigatorio\">*</span></label>"+
                                  "      <input type=\"text\" class=\"form-control\" id=txtMarcaVeiculoAl"+ qtdeVeiculos +" name=\"txtMarcaVeiculoAl\" placeholder=\"Ex.: Hyundai\">"+
                                  "  </div>"+
                                  "  <div class=\"form-group col-md-3\">"+
                                  "      <label for=txtModeloVeiculoAl"+ qtdeVeiculos +">Modelo: <span class=\"campo-obrigatorio\">*</span></label>"+
                                  "      <input type=\"text\" class=\"form-control\" id=txtModeloVeiculoAl"+ qtdeVeiculos +" name=\"txtModeloVeiculoAl\" placeholder=\"Ex.: HB20S\">"+
                                  "  </div>"+
                                  "  <div class=\"form-group col-md-2\">"+
                                  "      <label for=txtCorVeiculoAl"+ qtdeVeiculos +">Cor: <span class=\"campo-obrigatorio\">*</span></label>"+
                                  "      <input type=\"text\" class=\"form-control\" id=txtCorVeiculoAl"+ qtdeVeiculos +" name=\"txtCorVeiculoAl\" placeholder=\"Ex.: Vermelho\">"+
                                  "  </div>"+
                                  "  <div class=\"form-group col-md-2\">"+
                                  "      <label for=txtPlacaVeiculoAl"+ qtdeVeiculos +">Placa: <span class=\"campo-obrigatorio\">*</span></label>"+
                                  "      <input type=\"text\" class=\"form-control\" id=txtPlacaVeiculoAl"+ qtdeVeiculos +" name=\"txtPlacaVeiculoAl\" placeholder=\"Ex.: XXX 0X00\">"+
                                  "  </div>"+
                                  "</div>");
    qtdeVeiculos++;
});

//Acionamento form Alergias
var qtdeAlergias = document.querySelectorAll('#fieldsetAlergias .form-row').length + 1;

$("#txtAlergico").change(function() {    
    if($("#txtAlergico").val() === "s"){
        $("#divAlergias").css("display", "block");        
    }
    else if($("#txtAlergico").val() === "n" || $("#txtAlergico").val() === "0"){
        $("#divAlergias").css("display", "none");
        $("#fieldsetAlergias .form-row").remove();
        qtdeAlergias = 1;
    }
});

$("#btnAddAlergia").click(function(){
    $("#fieldsetAlergias").append("<div id=linha" +qtdeAlergias+ " class=\"form-row\">"+
                                  "  <div class=\"form-group col-md-12\">"+
                                  "      <label for=txtAlergia"+ qtdeAlergias +">Alergia: <span class=\"campo-obrigatorio\">*</span></label>"+
                                  "      <input type=\"text\" class=\"form-control\" id=txtAlergia"+ qtdeAlergias +" name=\"txtAlergia\" placeholder=\"Ex.: Rémedio tal\">"+
                                  "  </div>"+
                                  "</div>");
    qtdeAlergias++;
});

//Acionamento form Medicamento Controlado
var qtdeMtoCt = document.querySelectorAll('#fieldsetMtoCt .form-row').length + 1;

$("#txtUsoMtoCt").change(function() {    
    if($("#txtUsoMtoCt").val() === "s"){
        $("#divMtoCt").css("display", "block");        
    }
    else if($("#txtUsoMtoCt").val() === "n" || $("#txtUsoMtoCt").val() === "0"){
        $("#divMtoCt").css("display", "none");
        $("#fieldsetMtoCt .form-row").remove();
        qtdeMtoCt = 1;
    }
});

$("#btnAddMtoCt").click(function(){
    $("#fieldsetMtoCt").append("<div id=linha" + qtdeMtoCt + " class=\"form-row\">"+
                                  "  <div class=\"form-group col-md-8\">"+
                                  "      <label for=txtNomeMtoCt"+ qtdeMtoCt +">Nome: <span class=\"campo-obrigatorio\"> *</span></label>"+
                                  "      <input type=\"text\" class=\"form-control\" id=txtNomeMtoCt"+ qtdeMtoCt +" name=\"txtNomeMtoCt\" placeholder=\"Ex.: Rémedio tal\">"+
                                  "  </div>"+
                                  "  <div class=\"form-group col-md-2\">"+
                                  "      <label for=txtFrqMtoCt"+ qtdeMtoCt +">Frequência: <span class=\"campo-obrigatorio\">*</span></label>"+
                                  "      <input type=\"text\" class=\"form-control\" id=txtFrqMtoCt"+ qtdeMtoCt +" name=\"txtFrqMtoCt\" placeholder=\"Ex.: vezes\">"+
                                  "  </div>"+
                                  "  <div class=\"form-group col-md-2\">"+
                                  "      <label for=txtFrqMtoCt"+ qtdeMtoCt +">Por: <span class=\"campo-obrigatorio\">*</span></label>"+
                                  "      <select class=\"form-control\" id=txtTpMtoCt"+ qtdeMtoCt +" name=\"txtTpMtoCt\">"+
                                  "         <option value=\"0\" selected>Selecione o tipo...</option>"+
                                  "         <option value=\"hr\">Hora</option>"+
                                  "         <option value=\"dia\">Dia</option>"+
                                  "         <option value=\"sem\">Semana</option>"+
                                  "         <option value=\"mes\">Mês</option>"+
                                  "         <option value=\"ano\">Ano</option>"+
                                  "     </select>"+
                                  "  </div>"+
                                  "</div>");
    qtdeMtoCt++;
});

//Acionamento form Termogênicos, Ergonênicos e Suplementos Alimentares
var qtdeTermErgSupAli = document.querySelectorAll('#fieldsetTermErgSupAli .form-row').length + 1;

$("#txtUsoTermErgSupAli").change(function() {    
    if($("#txtUsoTermErgSupAli").val() === "s"){
        $("#divTermErgSupAli").css("display", "block");        
    }
    else if($("#txtUsoTermErgSupAli").val() === "n" || $("#txtUsoTermErgSupAli").val() === "0"){
        $("#divTermErgSupAli").css("display", "none");
        $("#fieldsetTermErgSupAli .form-row").remove();
        qtdeTermErgSupAli = 1;
    }
});

$("#btnAddTermErgSupAli").click(function(){
    $("#fieldsetTermErgSupAli").append("<div id=linha" + qtdeTermErgSupAli + " class=\"form-row\">"+
                                  "  <div class=\"form-group col-md-12\">"+
                                  "      <label for=txtNomeTermErgSupAli"+ qtdeTermErgSupAli +">Nome: <spam class=\"campo-obrigatorio\">*</span></label>"+
                                  "      <input type=\"text\" class=\"form-control\" id=txtNomeTermErgSupAli"+ qtdeTermErgSupAli +" name=\"txtNomeTermErgSupAli\" placeholder=\"Ex.: Rémedio tal\">"+
                                  "  </div>"+
                                  "</div>");
    qtdeTermErgSupAli++;
});

//Acionamento form Data do QA de Promoção
$("#txtQaProm").change(function() {
    if($("#txtQaProm").val() === "s"){
        $("#divQaQuando").css("display", "block");
    }
    else if($("#txtQaProm").val() === "n" || $("#txtQaProm").val() === "0"){
        $("#divQaQuando").css("display", "none");
    }
});

//Acionamento form Cônjuge
$("#txtPossuiConjuge").change(function() {
    if($("#txtPossuiConjuge").val() === "s"){
        $("#divConjuge").css("display", "block");
    }
    else if($("#txtPossuiConjuge").val() === "n" || $("#txtPossuiConjuge").val() === "0"){
        $("#divConjuge").css("display", "none");
    }
});

//Acionamento form Referência Conclusão de Curso
$("#txtAddRefConclusao").change(function() {
    if($("#txtAddRefConclusao").val() === "s"){
        $("#divRefConclusao").css("display", "block");
    }
    else if($("#txtAddRefConclusao").val() === "n" || $("#txtAddRefConclusao").val() === "0"){
        $("#divRefConclusao").css("display", "none");
    }
});

//Acionamento form Idiomas
var qtdeIdiomas = document.querySelectorAll('#fieldsetIdiomas .form-row').length + 1;

$("#txtHabIdiomas").change(function() {    
    if($("#txtHabIdiomas").val() === "s"){
        $("#divIdiomas").css("display", "block");        
    }
    else if($("#txtHabIdiomas").val() === "n" || $("#txtHabIdiomas").val() === "0"){
        $("#divIdiomas").css("display", "none");
        $("#fieldsetIdiomas .form-row").remove();
        qtdeIdiomas = 1;
    }
});

$("#btnAddIdioma").click(function(){           
    $("#linha" + qtdeIdiomas).remove();
    $("#fieldsetIdiomas").append("<div id=linha"+ qtdeIdiomas +" class=\"form-row\">"+
                                  "  <div class=\"form-group col-md-8\">"+
                                  "      <label for=txtIdioma"+ qtdeIdiomas +">Idioma: </label>"+"<spam class=\"campo-obrigatorio\"> *</spam>"+
                                  "      <input type=\"text\" class=\"form-control\" id=txtIdioma"+ qtdeIdiomas +" name=\"txtIdioma\" placeholder=\"Ex.: Espanhol\">"+
                                  "  </div>"+
                                  "  <div class=\"form-group col-md-4\">"+
                                  "      <label for=txtIplIdioma"+ qtdeIdiomas +">IPL: </label>"+"<spam class=\"campo-obrigatorio\"> *</spam>"+
                                  "      <input type=\"text\" class=\"form-control\" id=txtIplIdioma"+ qtdeIdiomas +" name=\"txtIplIdioma\" placeholder=\"Ex.: \">"+
                                  "  </div>"+
                                  "</div>");
    qtdeIdiomas++;
});

//Acionamento form Estagios
var qtdeEstagios = document.querySelectorAll('#fieldsetEstagios .form-row').length + 1;

$("#txtPossuiEstMil").change(function() {    
    if($("#txtPossuiEstMil").val() === "s"){
        $("#divEstagios").css("display", "block");        
    }
    else if($("#txtPossuiEstMil").val() === "n" || $("#txtPossuiEstMil").val() === "0"){
        $("#divEstagios").css("display", "none");
        $("#fieldsetEstagios .form-row").remove();
        qtdeEstagios = 1;
    }
});

$("#btnAddEstagio").click(function(){           
    $("#linha" + qtdeEstagios).remove();
    $("#fieldsetEstagios").append("<div id=linha"+ qtdeEstagios +" class=\"form-row\">"+
                                  "  <div class=\"form-group col-md-8\">"+
                                  "      <label for=txtEstagio"+ qtdeEstagios +">Estagio "+ qtdeEstagios +": </label>"+
                                  "      <input type=\"text\" class=\"form-control\" id=txtEstagio"+ qtdeEstagios +" name=\"txtEstagio\" placeholder=\"Ex.: Caatinga\">"+
                                  "  </div>"+
                                  "  <div class=\"form-group col-md-4\">"+
                                  "      <label for=txtAnoEstagio"+ qtdeEstagios +">Ano de Conclusão "+ qtdeEstagios +": </label>"+
                                  "      <input type=\"text\" class=\"form-control\" id=txtAnoEstagio"+ qtdeEstagios +" name=\"txtAnoEstagio\" placeholder=\"Ex.: 2018\">"+
                                  "  </div>"+  
                                  "</div>");
    qtdeEstagios++;
});

//Acionamento form Curso Aperfeiçoamento

$("#txtPossuiCAperf").change(function() {
    if($("#txtPossuiCAperf").val() === "s"){
        $("#divCAperf").css("display", "block");
    }
    else if($("#txtPossuiCAperf").val() === "n" || $("#txtPossuiCAperf").val() === "0"){
        $("#divCAperf").css("display", "none");
    }
});

//Acionamento form Curso de Altos Estudos
var qtdeCAltEstudos = document.querySelectorAll('#fieldsetCAltEstudos .form-row').length + 1;

$("#txtPossuiCAltEstudos").change(function() {    
    if($("#txtPossuiCAltEstudos").val() === "s"){
        $("#divCAltEstudos").css("display", "block");        
    }
    else if($("#txtPossuiCAltEstudos").val() === "n" || $("#txtPossuiCAltEstudos").val() === "0"){
        $("#divCAltEstudos").css("display", "none");
        $("#fieldsetCAltEstudos .form-row").remove();
        qtdeCAltEstudos = 1;
    }
});

$("#btnAddCAltEstudos").click(function(){           
    $("#linha" + qtdeCAltEstudos).remove();
    $("#fieldsetCAltEstudos").append("<div id=linha"+ qtdeCAltEstudos +" class=\"form-row\">"+
                                  "  <div class=\"form-group col-md-8\">"+
                                  "      <label for=txtCAltEstudos"+ qtdeCAltEstudos +">Curso de Altos Estudos "+ qtdeCAltEstudos +": </label>"+
                                  "      <input type=\"text\" class=\"form-control\" id=txtCAltEstudos"+ qtdeCAltEstudos +" name=\"txtCAltEstudos\" placeholder=\"Ex.: Caatinga\">"+
                                  "  </div>"+
                                  "  <div class=\"form-group col-md-4\">"+
                                  "      <label for=txtAnoCAltEstudos"+ qtdeCAltEstudos +">Ano de Conclusão "+ qtdeCAltEstudos +": </label>"+
                                  "      <input type=\"text\" class=\"form-control\" id=txtAnoCAltEstudos"+ qtdeCAltEstudos +" name=\"txtAnoCAltEstudos\" placeholder=\"Ex.: 2018\">"+
                                  "  </div>"+
                                  "</div>");
    qtdeCAltEstudos++;
});

//Acionamento form Curso de Extensão ou Especialização
var qtdeCExtsEsp = document.querySelectorAll('#fieldsetCExtsEsp .form-row').length + 1;

$("#txtPossuiCExtsEsp").change(function() {    
    if($("#txtPossuiCExtsEsp").val() === "s"){
        $("#divCExtsEsp").css("display", "block");        
    }
    else if($("#txtPossuiCExtsEsp").val() === "n" || $("#txtPossuiCExtsEsp").val() === "0"){
        $("#divCExtsEsp").css("display", "none");
        $("#fieldsetCExtsEsp .form-row").remove();
        qtdeCExtsEsp = 1;
    }
});

$("#btnAddCExtsEsp").click(function(){           
    $("#linha" + qtdeCExtsEsp).remove();
    $("#fieldsetCExtsEsp").append("<div id=linha"+ qtdeCExtsEsp +" class=\"form-row\">"+
                                  "  <div class=\"form-group col-md-3\">"+
                                  "      <label for=txtTipoCExtsEsp"+ qtdeCExtsEsp +">Tipo"+ qtdeCExtsEsp +": </label>"+
                                  "      <select class=\"form-control\" id=txtTipoCExtsEsp"+ qtdeCExtsEsp +" name=\"txtTipoCExtsEsp\">"+
                                  "         <option value=\"0\" selected>Selecione o tipo...</option>"+
                                  "         <option value=\"Exts\">Extensão</option>"+
                                  "         <option value=\"Esp\">Especialização</option>"+
                                  "     </select>"+
                                  "  </div>"+
                                  "  <div class=\"form-group col-md-6\">"+
                                  "      <label for=txtCExtsEsp"+ qtdeCExtsEsp +">Curso"+ qtdeCExtsEsp +": </label>"+
                                  "      <input type=\"text\" class=\"form-control\" id=txtCExtsEsp"+ qtdeCExtsEsp +" name=\"txtCExtsEsp\" placeholder=\"Ex.: Básico Paraquedista\">"+
                                  "  </div>"+
                                  "  <div class=\"form-group col-md-3\">"+
                                  "      <label for=txtAnoCExtsEsp"+ qtdeCExtsEsp +">Ano de Conclusão "+ qtdeCExtsEsp +": </label>"+
                                  "      <input type=\"text\" class=\"form-control\" id=txtAnoCExtsEsp"+ qtdeCExtsEsp +" name=\"txtAnoCExtsEsp\" placeholder=\"Ex.: 2018\">"+
                                  "  </div>"+
                                  "</div>");
    qtdeCExtsEsp++;
});
