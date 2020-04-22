 $("button[name=btnAlterar]").click(function(){
    //Campo Input Nome
    validInput("input[name=txtNomeAtt]");
    validInputTReal("input[name=txtNomeAtt]");
    
    //Campo Input Sigla
    validInput("input[name=txtSiglaAtt]");
    validInputTReal("input[name=txtSiglaAtt]");
    
    //Campo Select Categoria
    validSelect("select[name=txtCategoriaAtt]");
    validSelectTReal("select[name=txtCategoriaAtt]");
    
    //Campo Input Portaria
    validInput("input[name=txtPortariaAtt]");
    validInputTReal("input[name=txtPortariaAtt]");
    
    //Campo Input Descrição
    validTextarea("textarea[name=txtDescricaoAtt]");
    validTextareaTReal("textarea[name=txtDescricaoAtt]");
});

//OBRIGATORIEDADE
$("button[name=btnSalvarAtualizacao]").click(function(){
    if($("input[name=txtNomeAtt]").val() == ''){
        $("input[name=txtNomeAtt]").removeClass("is-valid");
        $("input[name=txtNomeAtt]").addClass("is-invalid");
        $("input[name=txtNomeAtt]").focus();
        return false;
    }
    else if($("input[name=txtSiglaAtt]").val() == ''){
        $("input[name=txtSiglaAtt]").removeClass("is-valid");
        $("input[name=txtSiglaAtt]").addClass("is-invalid");
        $("input[name=txtSiglaAtt]").focus();
        return false;
    }
    else if($("select[name=txtCategoriaAtt]").val() == '0'){
        $("select[name=txtCategoriaAtt]").removeClass("is-valid");
        $("select[name=txtCategoriaAtt]").addClass("is-invalid");
        $("select[name=txtCategoriaAtt]").focus();
        return false;
    }
    else if($("input[name=txtPortariaAtt]").val() == ''){
        $("input[name=txtPortariaAtt]").removeClass("is-valid");
        $("input[name=txtPortariaAtt]").addClass("is-invalid");
        $("input[name=txtPortariaAtt]").focus();
        return false;
    }
    else if($("textarea[name=txtDescricaoAtt]").val() == ''){
        $("textarea[name=txtDescricaoAtt]").removeClass("is-valid");
        $("textarea[name=txtDescricaoAtt]").addClass("is-invalid");
        $("textarea[name=txtDescricaoAtt]").focus();
        return false;
    }
});

