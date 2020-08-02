//Ao carregar ou recarregar a página
$(document).ready(function(){      
    limpaCampoSelect("select[name=txtSitAvlPsico]");
    limpaCampoInput("input[name=txtRtoAvlPsico]");
    
    //Campo Input Identidade
    validIdentidadeAl("input[name=txtIdentidadeAl]");
    validIdentidadeAlTReal("input[name=txtIdentidadeAl]");
    
    //Campo Input Posto/Graduação
    validInput("input[name=txtPGradAl]");
    validInputTReal("input[name=txtPGradAl]");
    
    //Campo Input Nome Guerra
    validInput("input[name=txtNomeGuerraAl]");
    validInputTReal("input[name=txtNomeGuerraAl]");
    
    //Campo Select Situação Avl Psico
    validSelect("select[name=txtSitAvlPsico]");
    validSelectTReal("select[name=txtSitAvlPsico]");
    
    //Campo Input Restrição Avl Psico
    validInput("input[name=txtRtoAvlPsico]");
    validInputTReal("input[name=txtRtoAvlPsico]");
});

$("select[name=txtSitAvlPsico]").change(function(){
   limpaCampoInput("input[name=txtRtoAvlPsico]");
});

//Obrigatoriedade
$("button[name=btnSalvarAvlPsico]").click(function(){
    var identidadeAl = $("input[name=txtIdentidadeAl]").val().replace("-", "");      
        
    if(identidadeAl == ''){
        $("input[name=txtIdentidadeAl]").removeClass("is-valid");
        $("input[name=txtIdentidadeAl]").addClass("is-invalid");
        $("input[name=txtIdentidadeAl]").focus();
        $(".invalid-identidadeAl").html("Campo Obrigatório!");
        return false;
    }
    else if(identidadeAl == '0000000000' || identidadeAl == '1111111111' || identidadeAl == '2222222222' || identidadeAl == '3333333333' ||                 
            identidadeAl == '4444444444' || identidadeAl == '5555555555' || identidadeAl == '6666666666' || identidadeAl == '7777777777' ||                 
            identidadeAl == '8888888888' || identidadeAl == '9999999999'){
        $("input[name=txtIdentidadeAl]").removeClass("is-valid");
        $("input[name=txtIdentidadeAl]").addClass("is-invalid");
        
        $(".invalid-identidadeAl").html("Identidade Militar Inválida!");
        $("input[name=txtIdentidadeAl]").focus();
        return false;
    }
    else if($("select[name=txtSitAvlPsico]").val() == '0'){
        $("select[name=txtSitAvlPsico]").removeClass("is-valid");
        $("select[name=txtSitAvlPsico]").addClass("is-invalid");
        $("select[name=txtSitAvlPsico]").focus();
        return false;
    }
    else if($("select[name=txtSitAvlPsico]").val() === '2'){        
        if($("input[name=txtRtoAvlPsico]").val() === ''){
            $("input[name=txtRtoAvlPsico]").removeClass("is-valid");
            $("input[name=txtRtoAvlPsico]").addClass("is-invalid");
            $("input[name=txtRtoAvlPsico]").focus();
            return false;
        }
        else{        
            return true;
        }
    }
    else{        
        return true;
    }
});