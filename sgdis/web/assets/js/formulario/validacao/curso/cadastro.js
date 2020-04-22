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

