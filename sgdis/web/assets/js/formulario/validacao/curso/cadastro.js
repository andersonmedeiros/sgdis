/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//AO CARREGAR OU RECARREGAR A PÁGINA
//SELECT
function validSelect(campo){
    if($(campo).val() != '0'){
        $(campo).removeClass("is-invalid");
        $(campo).addClass("is-valid");
    }
};

//INPUT
function validInput(campo){
    if($(campo).val() != ''){
        $(campo).removeClass("is-invalid");
        $(campo).addClass("is-valid");
    }
};

//TEXTAREA
function validTextarea(campo){
    if($(campo).val() != ''){
        $(campo).removeClass("is-invalid");
        $(campo).addClass("is-valid");
    }
};

//AO MUDAR O VALOR DO CAMPO
//SELECT
function validSelectTReal(campo){
    $(campo).change(function(){
        if($(campo).val() != '0'){
            $(campo).removeClass("is-invalid");
            $(campo).addClass("is-valid");
        }else{
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
        }
    });    
};

//INPUT
function validInputTReal(campo){
    $(campo).change(function(){
        if($(campo).val() != ''){
            $(campo).removeClass("is-invalid");
            $(campo).addClass("is-valid");
        }else{
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
        }
    });
};

//TEXTAREA
function validTextareaTReal(campo){
    $(campo).change(function(){
        if($(campo).val() != ''){
            $(campo).removeClass("is-invalid");
            $(campo).addClass("is-valid");
        }else{
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
        }
    });
};

$(document).ready(function(){   
    //Campo Input Nome
    validInput("input[name=txtNome]");
    validInputTReal("input[name=txtNome]");
    
    //Campo Input Sigla
    validInput("input[name=txtSigla]");
    validInputTReal("input[name=txtSigla]");
    
    //Campo Select Categoria
    validSelect("select[name=txtCategoria]");
    validSelectTReal("select[name=txtCategoria]");
    
    //Campo Input Portaria
    validInput("input[name=txtPortaria]");
    validInputTReal("input[name=txtPortaria]");
    
    //Campo Input Descrição
    validTextarea("textarea[name=txtDescricao]");
    validTextareaTReal("textarea[name=txtDescricao]");
});

//OBRIGATORIEDADE
$("button[name=btnSalvarCadastro]").click(function(){
    if($("input[name=txtNome]").val() == ''){
        $("input[name=txtNome]").removeClass("is-valid");
        $("input[name=txtNome]").addClass("is-invalid");
        $("input[name=txtNome]").focus();
        return false;
    }
    else if($("input[name=txtSigla]").val() == ''){
        $("input[name=txtSigla]").removeClass("is-valid");
        $("input[name=txtSigla]").addClass("is-invalid");
        $("input[name=txtSigla]").focus();
        return false;
    }
    else if($("select[name=txtCategoria]").val() == '0'){
        $("select[name=txtCategoria]").removeClass("is-valid");
        $("select[name=txtCategoria]").addClass("is-invalid");
        $("select[name=txtCategoria]").focus();
        return false;
    }
    else if($("input[name=txtPortaria]").val() == ''){
        $("input[name=txtPortaria]").removeClass("is-valid");
        $("input[name=txtPortaria]").addClass("is-invalid");
        $("input[name=txtPortaria]").focus();
        return false;
    }
    else if($("textarea[name=txtDescricao]").val() == ''){
        $("textarea[name=txtDescricao]").removeClass("is-valid");
        $("textarea[name=txtDescricao]").addClass("is-invalid");
        $("textarea[name=txtDescricao]").focus();
        return false;
    }
});

