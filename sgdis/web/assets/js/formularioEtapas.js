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