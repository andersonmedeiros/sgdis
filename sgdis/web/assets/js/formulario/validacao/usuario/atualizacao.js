//CB Anderson de Paula Andrade Medeiros
//Técnico em Informática
//01.08.2020

//Ao carregar ou recarregar a página
$(document).ready(function(){   
    //Campo Select Posto/Graduação
    validSelect("select[name=txtPGrad]");
    validSelectTReal("select[name=txtPGrad]");   
    
    //Campo Input Nome
    validInput("input[name=txtNome]");
    validInputTReal("input[name=txtNome]");
    
    //Campo Input Sobrenome
    validInput("input[name=txtSobrenome]");
    validInputTReal("input[name=txtSobrenome]");
    
    //Campo Input Nome Guerra
    validInput("input[name=txtNomeGuerra]");
    validInputTReal("input[name=txtNomeGuerra]");
    
    //Campo Input NGS
    validInput("input[name=txtNGS]");
    validInputTReal("input[name=txtNGS]");
    somenteNumero("input[name=txtNGS]");
});

//Obrigatoriedade
$("button[name=btnSalvarAtualizacao]").click(function(){
    if($("select[name=txtPGrad]").val() == '0'){
        $("select[name=txtPGrad]").removeClass("is-valid");
        $("select[name=txtPGrad]").addClass("is-invalid");
        $("select[name=txtPGrad]").focus();
        return false;
    }   
    else if($("input[name=txtNome]").val() == ''){
        $("input[name=txtNome]").removeClass("is-valid");
        $("input[name=txtNome]").addClass("is-invalid");
        $("input[name=txtNome]").focus();
        return false;
    }
    else if($("input[name=txtSobrenome]").val() == ''){
        $("input[name=txtSobrenome]").removeClass("is-valid");
        $("input[name=txtSobrenome]").addClass("is-invalid");
        $("input[name=txtSobrenome]").focus();
        return false;
    }
    else if($("input[name=txtNomeGuerra]").val() == ''){
        $("input[name=txtNomeGuerra]").removeClass("is-valid");
        $("input[name=txtNomeGuerra]").addClass("is-invalid");
        $("input[name=txtNomeGuerra]").focus();
        return false;
    }
    else if($("input[name=txtNGS]").val() == ''){
        $("input[name=txtNGS]").removeClass("is-valid");
        $("input[name=txtNGS]").addClass("is-invalid");
        $("input[name=txtNGS]").focus();
        return false;
    }
    else{        
        return true;
    }
});

