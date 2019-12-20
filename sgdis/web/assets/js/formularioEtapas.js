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

$("#txtQaPromo").change(function() {
    if($("#txtQaPromo").val() === "s"){
        $("#divQaQuando").css("display", "block");
    }
    else if($("#txtQaPromo").val() === "n" || $("#txtQaPromo").val() === "0"){
        $("#divQaQuando").css("display", "none");
    }
});

$("#txtPossuiCNH").change(function() {
    if($("#txtPossuiCNH").val() === "s"){
        $("#divCNH").css("display", "block");
    }
    else if($("#txtPossuiCNH").val() === "n" || $("#txtPossuiCNH").val() === "0"){
        $("#divCNH").css("display", "none");
    }
});

$("#txtPossuiVeiculo").change(function() {
    if($("#txtPossuiVeiculo").val() === "s"){
        $("#divVeiculo").css("display", "block");
    }
    else if($("#txtPossuiVeiculo").val() === "n" || $("#txtPossuiVeiculo").val() === "0"){
        $("#divVeiculo").css("display", "none");
    }
});

$("#txtAlergico").change(function() {    
    if($("#txtAlergico").val() === "s"){
        $("#divAlergia").css("display", "block");        
    }
    else if($("#txtAlergico").val() === "n" || $("#txtAlergico").val() === "0"){
        $("#divAlergia").css("display", "none");
        $("#fieldsetAlergias .form-row").remove();
        j=1;
    }
});

var j = document.querySelectorAll('#fd_dados_dependente .form-row').length + 1;
$("#btnAddAlergia").click(function(){           
    $("#linha"+j).remove();
    $("#fieldsetAlergias").append("<div id=linha"+j+" class=\"form-row\">"+
                                  "  <div class=\"form-group col-md-12\">"+
                                  "      <label for=txtAlergia"+ j +">Alergia "+j+": </label>"+
                                  "      <input type=\"text\" class=\"form-control\" id=txtAlergia"+ j +" name=\"txtAlergia\" placeholder=\"Ex.: Rémedio tal\">"+
                                  "  </div>"+
                                  "</div>");
    j++;
});