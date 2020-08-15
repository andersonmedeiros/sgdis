
//Ao carregar ou recarregar a página
$(document).ready(function(){      
    //--
    //Avaliação Psicológica
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
    
    //--
    //Teste de Conhecimento Militar
    limpaCampoInput("input[name=txtTCMT]");
    limpaCampoInput("input[name=txtTCMP]");
    
    //Campo Input Identidade
    validIdentidadeAl("input[name=txtIdentidadeAlTCM]");
    validIdentidadeAlTReal("input[name=txtIdentidadeAlTCM]");

    //Campo Input Posto/Graduação
    validInput("input[name=txtPGradAlTCM]");
    validInputTReal("input[name=txtPGradAlTCM]");

    //Campo Input Nome Guerra
    validInput("input[name=txtNomeGuerraAlTCM]");
    validInputTReal("input[name=txtNomeGuerraAlTCM]");

    //Campo Input TCMT
    validInput("input[name=txtTCMT]");
    validInputTReal("input[name=txtTCMT]");

    //Campo Input TCMP
    validInput("input[name=txtTCMP]");
    validInputTReal("input[name=txtTCMP]");
    
    //--
    //Inspeção de Saúde
    limpaCampoSelect("select[name=txtSitIS]");
    
    //Campo Input Identidade
    validIdentidadeAl("input[name=txtIdentidadeAlIS]");
    validIdentidadeAlTReal("input[name=txtIdentidadeAlIS]");

    //Campo Input Posto/Graduação
    validInput("input[name=txtPGradAlIS]");
    validInputTReal("input[name=txtPGradAlIS]");

    //Campo Input Nome Guerra
    validInput("input[name=txtNomeGuerraAlIS]");
    validInputTReal("input[name=txtNomeGuerraAlIS]");
    
    //Campo Select Situação
    validSelect("select[name=txtSitIS]");
    validSelectTReal("select[name=txtSitIS]");
    
    //--
    //Exame de Aptidão de Física
    //Primeira Tentativa
    limpaCampoSelect("select[name=txtSexoEafTent1]");
    limpaCampoInput("input[name=txtCorridaEafTent1]");
    limpaCampoInput("input[name=txtAbdSupraEafTent1]");
    limpaCampoInput("input[name=txtFlexaoBracoEafTent1]");
    limpaCampoInput("input[name=txtFlexaoBarraEafTent1]");
    limpaCampoInput("input[name=txtSuspBarraEafTent1]");
    limpaCampoInput("input[name=txtNadoSubmersoEafTent1]");
    limpaCampoInput("input[name=txtCordaVerticalEafTent1]");
    limpaCampoInput("input[name=txtPPMEafTent1]");
    limpaCampoInput("input[name=txtNatUtlEafTent1]");
    limpaCampoInput("input[name=txtFlutuacaoEafTent1]");
    limpaCampoInput("input[name=txtMarchaEafTent1]");
    
    //Segunda Tentativa
    limpaCampoSelect("select[name=txtSexoEafTent2]");
    limpaCampoInput("input[name=txtCorridaEafTent2]");
    limpaCampoInput("input[name=txtAbdSupraEafTent2]");
    limpaCampoInput("input[name=txtFlexaoBracoEafTent2]");
    limpaCampoInput("input[name=txtFlexaoBarraEafTent2]");
    limpaCampoInput("input[name=txtSuspBarraEafTent2]");
    limpaCampoInput("input[name=txtNadoSubmersoEafTent2]");
    limpaCampoInput("input[name=txtCordaVerticalEafTent2]");
    limpaCampoInput("input[name=txtPPMEafTent2]");
    limpaCampoInput("input[name=txtNatUtlEafTent2]");
    limpaCampoInput("input[name=txtFlutuacaoEafTent2]");
    limpaCampoInput("input[name=txtMarchaEafTent2]");
    
    //Campo Input Identidade
    validIdentidadeAl("input[name=txtIdentidadeAlEafTent1]");
    validIdentidadeAlTReal("input[name=txtIdentidadeAlEafTent1]");

    //Campo Input Posto/Graduação
    validInput("input[name=txtPGradAlEafTent1]");
    validInputTReal("input[name=txtPGradAlEafTent1]");

    //Campo Input Nome Guerra
    validInput("input[name=txtNomeGuerraAlEafTent1]");
    validInputTReal("input[name=txtNomeGuerraAlEafTent1]");

    //Campo Select Sexo
    validSelect("select[name=txtSexoEafTent1]");
    validSelectTReal("select[name=txtSexoEafTent1]");

    //Campo Input Corrida
    validInput("input[name=txtCorridaEafTent1]");
    validInputTReal("input[name=txtCorridaEafTent1]");

    //Campo Input Abdominal
    validInput("input[name=txtAbdSupraEafTent1]");
    validInputTReal("input[name=txtAbdSupraEafTent1]");

    //Campo Input Flexão Braço
    validInput("input[name=txtFlexaoBracoEafTent1]");
    validInputTReal("input[name=txtFlexaoBracoEafTent1]");

    //Campo Input Flexão Barra
    validInput("input[name=txtFlexaoBarraEafTent1]");
    validInputTReal("input[name=txtFlexaoBarraEafTent1]");

    //Campo Input Suspensão Barra
    validInput("input[name=txtSuspBarraEafTent1]");
    validInputTReal("input[name=txtSuspBarraEafTent1]");
    
    //Campo Select Nado Submerso
    validSelect("select[name=txtNadoSubmersoEafTent1]");
    validSelectTReal("select[name=txtNadoSubmersoEafTent1]");
    
    //Campo Select Corda Vertical
    validSelect("select[name=txtCordaVerticalEafTent1]");
    validSelectTReal("select[name=txtCordaVerticalEafTent1]");
    
    //Campo Input PPM
    validInput("input[name=txtPPMEafTent1]");
    validInputTReal("input[name=txtPPMEafTent1]");
    
    //Campo Input Natação Utilltária
    validInput("input[name=txtNatUtlEafTent1]");
    validInputTReal("input[name=txtNatUtlEafTent1]");
    
    //Campo Input Flutuação
    validInput("input[name=txtFlutuacaoEafTent1]");
    validInputTReal("input[name=txtFlutuacaoEafTent1]");
    
    //Campo Input Marcha 15km
    validInput("input[name=txtMarchaEafTent1]");
    validInputTReal("input[name=txtMarchaEafTent1]");
    
    
    //Campo Input Identidade
    validIdentidadeAl("input[name=txtIdentidadeAlEafTent2]");
    validIdentidadeAlTReal("input[name=txtIdentidadeAlEafTent2]");

    //Campo Input Posto/Graduação
    validInput("input[name=txtPGradAlEafTent2]");
    validInputTReal("input[name=txtPGradAlEafTent2]");

    //Campo Input Nome Guerra
    validInput("input[name=txtNomeGuerraAlEafTent2]");
    validInputTReal("input[name=txtNomeGuerraAlEafTent2]");

    //Campo Select Sexo
    validSelect("select[name=txtSexoEafTent2]");
    validSelectTReal("select[name=txtSexoEafTent2]");

    //Campo Input Corrida
    validInput("input[name=txtCorridaEafTent2]");
    validInputTReal("input[name=txtCorridaEafTent2]");

    //Campo Input Abdominal
    validInput("input[name=txtAbdSupraEafTent2]");
    validInputTReal("input[name=txtAbdSupraEafTent2]");

    //Campo Input Flexão Braço
    validInput("input[name=txtFlexaoBracoEafTent2]");
    validInputTReal("input[name=txtFlexaoBracoEafTent2]");

    //Campo Input Flexão Barra
    validInput("input[name=txtFlexaoBarraEafTent2]");
    validInputTReal("input[name=txtFlexaoBarraEafTent2]");

    //Campo Input Suspensão Barra
    validInput("input[name=txtSuspBarraEafTent2]");
    validInputTReal("input[name=txtSuspBarraEafTent2]");
    
    //Campo Select Nado Submerso
    validSelect("select[name=txtNadoSubmersoEafTent2]");
    validSelectTReal("select[name=txtNadoSubmersoEafTent2]");
    
    //Campo Select Corda Vertical
    validSelect("select[name=txtCordaVerticalEafTent2]");
    validSelectTReal("select[name=txtCordaVerticalEafTent2]");
    
    //Campo Input PPM
    validInput("input[name=txtPPMEafTent2]");
    validInputTReal("input[name=txtPPMEafTent2]");
    
    //Campo Input Natação Utilltária
    validInput("input[name=txtNatUtlEafTent2]");
    validInputTReal("input[name=txtNatUtlEafTent2]");
    
    //Campo Input Flutuação
    validInput("input[name=txtFlutuacaoEafTent2]");
    validInputTReal("input[name=txtFlutuacaoEafTent2]");
    
    //Campo Input Marcha 15km
    validInput("input[name=txtMarchaEafTent2]");
    validInputTReal("input[name=txtMarchaEafTent2]");
});

$("select[name=txtSitAvlPsico]").change(function(){
   limpaCampoInput("input[name=txtRtoAvlPsico]");
});

//Obrigatoriedade
//Avaliação Psicológica
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

//Teste de Conhecimento Militar
$("button[name=btnSalvarTCM]").click(function(){
    var identidadeAl = $("input[name=txtIdentidadeAlTCM]").val().replace("-", "");   
    if(identidadeAl == ''){
        $("input[name=txtIdentidadeAlTCM]").removeClass("is-valid");
        $("input[name=txtIdentidadeAlTCM]").addClass("is-invalid");
        $("input[name=txtIdentidadeAlTCM]").focus();
        $(".invalid-identidadeAl").html("Campo Obrigatório!");
        return false;
    }
    else if(identidadeAl == '0000000000' || identidadeAl == '1111111111' || identidadeAl == '2222222222' || identidadeAl == '3333333333' ||                 
            identidadeAl == '4444444444' || identidadeAl == '5555555555' || identidadeAl == '6666666666' || identidadeAl == '7777777777' ||                 
            identidadeAl == '8888888888' || identidadeAl == '9999999999'){
        $("input[name=txtIdentidadeAlTCM]").removeClass("is-valid");
        $("input[name=txtIdentidadeAlTCM]").addClass("is-invalid");

        $(".invalid-identidadeAl").html("Identidade Militar Inválida!");
        $("input[name=txtIdentidadeAlTCM]").focus();
        return false;
    }
    else if($("input[name=txtTCMT]").val() == ''){
        $("input[name=txtTCMT]").removeClass("is-valid");
        $("input[name=txtTCMT]").addClass("is-invalid");
        $("input[name=txtTCMT]").focus();
        return false;
    }
    else if($("input[name=txtTCMP]").val() == ''){
        $("input[name=txtTCMP]").removeClass("is-valid");
        $("input[name=txtTCMP]").addClass("is-invalid");
        $("input[name=txtTCMP]").focus();
        return false;
    }
    else{      
        return true;
    }
});

//Exame de Aptidão Física
$("button[name=btnSalvarEafTent1]").click(function(){
    var identidadeAl = $("input[name=txtIdentidadeAlEafTent1]").val().replace("-", "");   
    if(identidadeAl == ''){
        $("input[name=txtIdentidadeAlEafTent1]").removeClass("is-valid");
        $("input[name=txtIdentidadeAlEafTent1]").addClass("is-invalid");
        $("input[name=txtIdentidadeAlEafTent1]").focus();
        $(".invalid-identidadeAl").html("Campo Obrigatório!");
        return false;
    }
    else if(identidadeAl == '0000000000' || identidadeAl == '1111111111' || identidadeAl == '2222222222' || identidadeAl == '3333333333' ||                 
            identidadeAl == '4444444444' || identidadeAl == '5555555555' || identidadeAl == '6666666666' || identidadeAl == '7777777777' ||                 
            identidadeAl == '8888888888' || identidadeAl == '9999999999'){
        $("input[name=txtIdentidadeAlEafTent1]").removeClass("is-valid");
        $("input[name=txtIdentidadeAlEafTent1]").addClass("is-invalid");

        $(".invalid-identidadeAl").html("Identidade Militar Inválida!");
        $("input[name=txtIdentidadeAlEafTent1]").focus();
        return false;
    }
    else if($("select[name=txtSexoEafTent1]").val() == '0'){
        $("select[name=txtSexoEafTent1]").removeClass("is-valid");
        $("select[name=txtSexoEafTent1]").addClass("is-invalid");
        $("select[name=txtSexoEafTent1]").focus();
        return false;
    }
    else if($("select[name=txtSexoEafTent1]").val() == 'M'){
        if($("input[name=txtCorridaEafTent1]").val() == ''){
            $("input[name=txtCorridaEafTent1]").removeClass("is-valid");
            $("input[name=txtCorridaEafTent1]").addClass("is-invalid");
            $("input[name=txtCorridaEafTent1]").focus();
            return false;
        }
        else if($("input[name=txtAbdSupraEafTent1]").val() == ''){
            $("input[name=txtAbdSupraEafTent1]").removeClass("is-valid");
            $("input[name=txtAbdSupraEafTent1]").addClass("is-invalid");
            $("input[name=txtAbdSupraEafTent1]").focus();
            return false;
        }
        else if($("input[name=txtFlexaoBracoEafTent1]").val() == ''){
            $("input[name=txtFlexaoBracoEafTent1]").removeClass("is-valid");
            $("input[name=txtFlexaoBracoEafTent1]").addClass("is-invalid");
            $("input[name=txtFlexaoBracoEafTent1]").focus();
            return false;
        }
        else if($("input[name=txtFlexaoBarraEafTent1]").val() == ''){
            $("input[name=txtFlexaoBarraEafTent1]").removeClass("is-valid");
            $("input[name=txtFlexaoBarraEafTent1]").addClass("is-invalid");
            $("input[name=txtFlexaoBarraEafTent1]").focus();
            return false;
        }
        else if($("select[name=txtNadoSubmersoEafTent1]").val() == '0'){
            $("select[name=txtNadoSubmersoEafTent1]").removeClass("is-valid");
            $("select[name=txtNadoSubmersoEafTent1]").addClass("is-invalid");
            $("select[name=txtNadoSubmersoEafTent1]").focus();
            return false;
        }
        else if($("select[name=txtCordaVerticalEafTent1]").val() == '0'){
            $("select[name=txtCordaVerticalEafTent1]").removeClass("is-valid");
            $("select[name=txtCordaVerticalEafTent1]").addClass("is-invalid");
            $("select[name=txtCordaVerticalEafTent1]").focus();
            return false;
        }
        else if($("input[name=txtPPMEafTent1]").val() == ''){
            $("input[name=txtPPMEafTent1]").removeClass("is-valid");
            $("input[name=txtPPMEafTent1]").addClass("is-invalid");
            $("input[name=txtPPMEafTent1]").focus();
            return false;
        }
        else if($("input[name=txtNatUtlEafTent1]").val() == ''){
            $("input[name=txtNatUtlEafTent1]").removeClass("is-valid");
            $("input[name=txtNatUtlEafTent1]").addClass("is-invalid");
            $("input[name=txtNatUtlEafTent1]").focus();
            return false;
        }
        else if($("input[name=txtFlutuacaoEafTent1]").val() == ''){
            $("input[name=txtFlutuacaoEafTent1]").removeClass("is-valid");
            $("input[name=txtFlutuacaoEafTent1]").addClass("is-invalid");
            $("input[name=txtFlutuacaoEafTent1]").focus();
            return false;
        }
        else if($("input[name=txtMarchaEafTent1]").val() == ''){
            $("input[name=txtMarchaEafTent1]").removeClass("is-valid");
            $("input[name=txtMarchaEafTent1]").addClass("is-invalid");
            $("input[name=txtMarchaEafTent1]").focus();
            return false;
        }
    }
    else if($("select[name=txtSexoEafTent1]").val() == 'F'){
        if($("input[name=txtCorridaEafTent1]").val() == ''){
            $("input[name=txtCorridaEafTent1]").removeClass("is-valid");
            $("input[name=txtCorridaEafTent1]").addClass("is-invalid");
            $("input[name=txtCorridaEafTent1]").focus();
            return false;
        }
        else if($("input[name=txtAbdSupraEafTent1]").val() == ''){
            $("input[name=txtAbdSupraEafTent1]").removeClass("is-valid");
            $("input[name=txtAbdSupraEafTent1]").addClass("is-invalid");
            $("input[name=txtAbdSupraEafTent1]").focus();
            return false;
        }
        else if($("input[name=txtFlexaoBracoEafTent1]").val() == ''){
            $("input[name=txtFlexaoBracoEafTent1]").removeClass("is-valid");
            $("input[name=txtFlexaoBracoEafTent1]").addClass("is-invalid");
            $("input[name=txtFlexaoBracoEafTent1]").focus();
            return false;
        }
        else if($("input[name=txtSuspBarraEafTent1]").val() == ''){
            $("input[name=txtSuspBarraEafTent1]").removeClass("is-valid");
            $("input[name=txtSuspBarraEafTent1]").addClass("is-invalid");
            $("input[name=txtSuspBarraEafTent1]").focus();
            return false;
        }
        else if($("select[name=txtNadoSubmersoEafTent1]").val() == '0'){
            $("select[name=txtNadoSubmersoEafTent1]").removeClass("is-valid");
            $("select[name=txtNadoSubmersoEafTent1]").addClass("is-invalid");
            $("select[name=txtNadoSubmersoEafTent1]").focus();
            return false;
        }
        else if($("select[name=txtCordaVerticalEafTent1]").val() == '0'){
            $("select[name=txtCordaVerticalEafTent1]").removeClass("is-valid");
            $("select[name=txtCordaVerticalEafTent1]").addClass("is-invalid");
            $("select[name=txtCordaVerticalEafTent1]").focus();
            return false;
        }
        else if($("input[name=txtPPMEafTent1]").val() == ''){
            $("input[name=txtPPMEafTent1]").removeClass("is-valid");
            $("input[name=txtPPMEafTent1]").addClass("is-invalid");
            $("input[name=txtPPMEafTent1]").focus();
            return false;
        }
        else if($("input[name=txtNatUtlEafTent1]").val() == ''){
            $("input[name=txtNatUtlEafTent1]").removeClass("is-valid");
            $("input[name=txtNatUtlEafTent1]").addClass("is-invalid");
            $("input[name=txtNatUtlEafTent1]").focus();
            return false;
        }
        else if($("input[name=txtFlutuacaoEafTent1]").val() == ''){
            $("input[name=txtFlutuacaoEafTent1]").removeClass("is-valid");
            $("input[name=txtFlutuacaoEafTent1]").addClass("is-invalid");
            $("input[name=txtFlutuacaoEafTent1]").focus();
            return false;
        }
        else if($("input[name=txtMarchaEafTent1]").val() == ''){
            $("input[name=txtMarchaEafTent1]").removeClass("is-valid");
            $("input[name=txtMarchaEafTent1]").addClass("is-invalid");
            $("input[name=txtMarchaEafTent1]").focus();
            return false;
        }
    }    
    else{      
        return true;
    }
});


$("button[name=btnSalvarEafTent2]").click(function(){
    var identidadeAl = $("input[name=txtIdentidadeAlEafTent2]").val().replace("-", "");   
    if(identidadeAl == ''){
        $("input[name=txtIdentidadeAlEafTent2]").removeClass("is-valid");
        $("input[name=txtIdentidadeAlEafTent2]").addClass("is-invalid");
        $("input[name=txtIdentidadeAlEafTent2]").focus();
        $(".invalid-identidadeAl").html("Campo Obrigatório!");
        return false;
    }
    else if(identidadeAl == '0000000000' || identidadeAl == '1111111111' || identidadeAl == '2222222222' || identidadeAl == '3333333333' ||                 
            identidadeAl == '4444444444' || identidadeAl == '5555555555' || identidadeAl == '6666666666' || identidadeAl == '7777777777' ||                 
            identidadeAl == '8888888888' || identidadeAl == '9999999999'){
        $("input[name=txtIdentidadeAlEafTent2]").removeClass("is-valid");
        $("input[name=txtIdentidadeAlEafTent2]").addClass("is-invalid");

        $(".invalid-identidadeAl").html("Identidade Militar Inválida!");
        $("input[name=txtIdentidadeAlEafTent2]").focus();
        return false;
    }
    else if($("select[name=txtSexoEafTent2]").val() == '0'){
        $("select[name=txtSexoEafTent2]").removeClass("is-valid");
        $("select[name=txtSexoEafTent2]").addClass("is-invalid");
        $("select[name=txtSexoEafTent2]").focus();
        return false;
    }
    else if($("select[name=txtSexoEafTent2]").val() == 'M'){
        if($("#div-eaf-tent2-10").css("display") == "block"){
            if($("input[name=txtCorridaEafTent2]").val() == ''){
                $("input[name=txtCorridaEafTent2]").removeClass("is-valid");
                $("input[name=txtCorridaEafTent2]").addClass("is-invalid");
                $("input[name=txtCorridaEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-11").css("display") == "block"){
            if($("input[name=txtAbdSupraEafTent2]").val() == ''){
                $("input[name=txtAbdSupraEafTent2]").removeClass("is-valid");
                $("input[name=txtAbdSupraEafTent2]").addClass("is-invalid");
                $("input[name=txtAbdSupraEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-12").css("display") == "block"){
            if($("input[name=txtFlexaoBracoEafTent2]").val() == ''){
                $("input[name=txtFlexaoBracoEafTent2]").removeClass("is-valid");
                $("input[name=txtFlexaoBracoEafTent2]").addClass("is-invalid");
                $("input[name=txtFlexaoBracoEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-13").css("display") == "block"){
            if($("input[name=txtFlexaoBarraEafTent2]").val() == ''){
                $("input[name=txtFlexaoBarraEafTent2]").removeClass("is-valid");
                $("input[name=txtFlexaoBarraEafTent2]").addClass("is-invalid");
                $("input[name=txtFlexaoBarraEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-15").css("display") == "block"){
            if($("select[name=txtNadoSubmersoEafTent2]").val() == '0'){
                $("select[name=txtNadoSubmersoEafTent2]").removeClass("is-valid");
                $("select[name=txtNadoSubmersoEafTent2]").addClass("is-invalid");
                $("select[name=txtNadoSubmersoEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-16").css("display") == "block"){
            if($("select[name=txtCordaVerticalEafTent2]").val() == '0'){
                $("select[name=txtCordaVerticalEafTent2]").removeClass("is-valid");
                $("select[name=txtCordaVerticalEafTent2]").addClass("is-invalid");
                $("select[name=txtCordaVerticalEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-17").css("display") == "block"){
            if($("input[name=txtPPMEafTent2]").val() == ''){
                $("input[name=txtPPMEafTent2]").removeClass("is-valid");
                $("input[name=txtPPMEafTent2]").addClass("is-invalid");
                $("input[name=txtPPMEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-18").css("display") == "block"){
            if($("input[name=txtNatUtlEafTent2]").val() == ''){
                $("input[name=txtNatUtlEafTent2]").removeClass("is-valid");
                $("input[name=txtNatUtlEafTent2]").addClass("is-invalid");
                $("input[name=txtNatUtlEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-19").css("display") == "block"){
            if($("input[name=txtFlutuacaoEafTent2]").val() == ''){
                $("input[name=txtFlutuacaoEafTent2]").removeClass("is-valid");
                $("input[name=txtFlutuacaoEafTent2]").addClass("is-invalid");
                $("input[name=txtFlutuacaoEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-20").css("display") == "block"){
            if($("input[name=txtMarchaEafTent2]").val() == ''){
                $("input[name=txtMarchaEafTent2]").removeClass("is-valid");
                $("input[name=txtMarchaEafTent2]").addClass("is-invalid");
                $("input[name=txtMarchaEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
    }
    else if($("select[name=txtSexoEafTent2]").val() == 'F'){
        if($("#div-eaf-tent2-10").css("display") == "block"){
            if($("input[name=txtCorridaEafTent2]").val() == ''){
                $("input[name=txtCorridaEafTent2]").removeClass("is-valid");
                $("input[name=txtCorridaEafTent2]").addClass("is-invalid");
                $("input[name=txtCorridaEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-11").css("display") == "block"){
            if($("input[name=txtAbdSupraEafTent2]").val() == ''){
                $("input[name=txtAbdSupraEafTent2]").removeClass("is-valid");
                $("input[name=txtAbdSupraEafTent2]").addClass("is-invalid");
                $("input[name=txtAbdSupraEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-12").css("display") == "block"){
            if($("input[name=txtFlexaoBracoEafTent2]").val() == ''){
                $("input[name=txtFlexaoBracoEafTent2]").removeClass("is-valid");
                $("input[name=txtFlexaoBracoEafTent2]").addClass("is-invalid");
                $("input[name=txtFlexaoBracoEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-14").css("display") == "block"){
            if($("input[name=txtSuspBarraEafTent2]").val() == ''){
                $("input[name=txtSuspBarraEafTent2]").removeClass("is-valid");
                $("input[name=txtSuspBarraEafTent2]").addClass("is-invalid");
                $("input[name=txtSuspBarraEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-15").css("display") == "block"){
            if($("select[name=txtNadoSubmersoEafTent2]").val() == '0'){
                $("select[name=txtNadoSubmersoEafTent2]").removeClass("is-valid");
                $("select[name=txtNadoSubmersoEafTent2]").addClass("is-invalid");
                $("select[name=txtNadoSubmersoEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-16").css("display") == "block"){
            if($("select[name=txtCordaVerticalEafTent2]").val() == '0'){
                $("select[name=txtCordaVerticalEafTent2]").removeClass("is-valid");
                $("select[name=txtCordaVerticalEafTent2]").addClass("is-invalid");
                $("select[name=txtCordaVerticalEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-17").css("display") == "block"){
            if($("input[name=txtPPMEafTent2]").val() == ''){
                $("input[name=txtPPMEafTent2]").removeClass("is-valid");
                $("input[name=txtPPMEafTent2]").addClass("is-invalid");
                $("input[name=txtPPMEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-18").css("display") == "block"){
            if($("input[name=txtNatUtlEafTent2]").val() == ''){
                $("input[name=txtNatUtlEafTent2]").removeClass("is-valid");
                $("input[name=txtNatUtlEafTent2]").addClass("is-invalid");
                $("input[name=txtNatUtlEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-19").css("display") == "block"){
            if($("input[name=txtFlutuacaoEafTent2]").val() == ''){
                $("input[name=txtFlutuacaoEafTent2]").removeClass("is-valid");
                $("input[name=txtFlutuacaoEafTent2]").addClass("is-invalid");
                $("input[name=txtFlutuacaoEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
        else if($("#div-eaf-tent2-20").css("display") == "block"){
            if($("input[name=txtMarchaEafTent2]").val() == ''){
                $("input[name=txtMarchaEafTent2]").removeClass("is-valid");
                $("input[name=txtMarchaEafTent2]").addClass("is-invalid");
                $("input[name=txtMarchaEafTent2]").focus();
                return false;
            }
            else{      
                return true;
            }
        }
    }
});

$("button[name=btnSalvarIS]").click(function(){
    var identidadeAl = $("input[name=txtIdentidadeAlIS]").val().replace("-", "");   
    if(identidadeAl == ''){
        $("input[name=txtIdentidadeAlIS]").removeClass("is-valid");
        $("input[name=txtIdentidadeAlIS]").addClass("is-invalid");
        $("input[name=txtIdentidadeAlIS]").focus();
        $(".invalid-identidadeAl").html("Campo Obrigatório!");
        return false;
    }
    else if(identidadeAl == '0000000000' || identidadeAl == '1111111111' || identidadeAl == '2222222222' || identidadeAl == '3333333333' ||                 
            identidadeAl == '4444444444' || identidadeAl == '5555555555' || identidadeAl == '6666666666' || identidadeAl == '7777777777' ||                 
            identidadeAl == '8888888888' || identidadeAl == '9999999999'){
        $("input[name=txtIdentidadeAlIS]").removeClass("is-valid");
        $("input[name=txtIdentidadeAlIS]").addClass("is-invalid");

        $(".invalid-identidadeAl").html("Identidade Militar Inválida!");
        $("input[name=txtIdentidadeAlIS]").focus();
        return false;
    }
    else if($("select[name=txtSitIS]").val() == '0'){
        $("select[name=txtSitIS]").removeClass("is-valid");
        $("select[name=txtSitIS]").addClass("is-invalid");
        $("select[name=txtSitIS]").focus();
        return false;
    }
    else{      
        return true;
    }
        
    
});