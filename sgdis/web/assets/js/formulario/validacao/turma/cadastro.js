//Ao carregar ou recarregar a página
$(document).ready(function(){
    limpaCampoSelect("select[name=txtAno]");
    limpaCampoInput("input[name=txtDataInicio]");
    limpaCampoInput("input[name=txtDataFim]");
    limpaCampoSelect("select[name=txtCurso]");
    limpaCampoSelect("select[name=txtCategoria]");
    
    //Campo Select Ano Turma
    validSelect("select[name=txtAno]");
    validSelectTReal("select[name=txtAno]");
    
    //Campo Date Data Início Turma
    validDataInicioTurma("input[name=txtDataInicio]", "select[name=txtAno]");
    validDataInicioTurmaTReal("input[name=txtDataInicio]", "select[name=txtAno]");
    
    //Campo Date Data Término Turma
    validDataTerminoTurma("input[name=txtDataFim]", "input[name=txtDataInicio]", "select[name=txtAno]");
    validDataTerminoTurmaTReal("input[name=txtDataFim]", "input[name=txtDataInicio]", "select[name=txtAno]");
    
    //Campo Select Curso
    validSelect("select[name=txtCurso]");
    validSelectTReal("select[name=txtCurso]");
    
    //Campo Select Categoria
    validSelect("select[name=txtCategoria]");
    validSelectTReal("select[name=txtCategoria]");
});

$("select[name=txtCurso]").change(function(){
   limpaCampoSelect("select[name=txtCategoria]");
});

//Obrigatoriedade
$("button[name=btnSalvarTurma]").click(function(){
    var dataAtual = new Date();
    var diaAtual = dataAtual.getDate();
    var mesAtual = (dataAtual.getMonth() + 1);
    var anoAtual = dataAtual.getFullYear();
        
    var anoTurma = $("select[name=txtAno]").val();
        
    var dataInicioTurma = $("input[name=txtDataInicio]").val();
    var dataInicioTurmaSplit = dataInicioTurma.split('-');        
    var diaInicioTurma = dataInicioTurmaSplit[2];
    var mesInicioTurma = dataInicioTurmaSplit[1];
    var anoInicioTurma = dataInicioTurmaSplit[0];

    var dataTerminoTurma = $("input[name=txtDataFim]").val();
    var dataTerminoTurmaSplit = dataTerminoTurma.split('-');        
    var diaTerminoTurma = dataTerminoTurmaSplit[2];
    var mesTerminoTurma = dataTerminoTurmaSplit[1];
    var anoTerminoTurma = dataTerminoTurmaSplit[0];        
        
    if($("select[name=txtAno]").val() == '0'){
        $("select[name=txtAno]").removeClass("is-valid");
        $("select[name=txtAno]").addClass("is-invalid");
        $("select[name=txtAno]").focus();
        return false;
    }
    else if(dataInicioTurma == ''){
        $("input[name=txtDataInicio]").removeClass("is-valid");
        $("input[name=txtDataInicio]").addClass("is-invalid");
        $("input[name=txtDataInicio]").focus();
        $(".invalid-dataInicioTurma").html("Campo Obrigatório!");
        return false;
    }
    else if(anoInicioTurma != anoTurma){
        $("input[name=txtDataInicio]").removeClass("is-valid");
        $("input[name=txtDataInicio]").addClass("is-invalid");
        $("input[name=txtDataInicio]").focus();
        $(".invalid-dataInicioTurma").html("Data Inválida! O ano de início não pode ser diferente do ano acima.");
        return false;
    }
    else if((anoInicioTurma == anoAtual) && (mesInicioTurma == mesAtual) && (diaInicioTurma < diaAtual)){
        $("input[name=txtDataInicio]").removeClass("is-valid");
        $("input[name=txtDataInicio]").addClass("is-invalid");
        $("input[name=txtDataInicio]").focus();
        $(".invalid-dataInicioTurma").html("Data Inválida! Início da turma antes da data atual.");
        return false;
    }       
    else if((anoInicioTurma == anoAtual) && (mesInicioTurma < mesAtual)){
        $("input[name=txtDataInicio]").removeClass("is-valid");
        $("input[name=txtDataInicio]").addClass("is-invalid");
        $("input[name=txtDataInicio]").focus();
        $(".invalid-dataInicioTurma").html("Data Inválida! Início da turma antes da data atual.");
        return false;
    }       
    else if((anoInicioTurma < anoAtual)){
        $("input[name=txtDataInicio]").removeClass("is-valid");
        $("input[name=txtDataInicio]").addClass("is-invalid");
        $("input[name=txtDataInicio]").focus();
        $(".invalid-dataInicioTurma").html("Data Inválida! Início da turma antes da data atual.");
        return false;
    }
    else if(dataTerminoTurma == ''){
        $("input[name=txtDataFim]").removeClass("is-valid");
        $("input[name=txtDataFim]").addClass("is-invalid");
        $("input[name=txtDataFim]").focus();
        $(".invalid-dataInicioTurma").html("Campo Obrigatório!");
        return false;
    }
    else if(anoTerminoTurma != anoTurma){
        $("input[name=txtDataFim]").removeClass("is-valid");
        $("input[name=txtDataFim]").addClass("is-invalid");
        $("input[name=txtDataFim]").focus();
        $(".invalid-dataTerminoTurma").html("Data Inválida! O ano de término não pode ser diferente do ano acima.");
        return false;
    }
    else if((anoTerminoTurma == anoInicioTurma) && (mesTerminoTurma == mesInicioTurma) && (diaTerminoTurma < diaInicioTurma)){
        $("input[name=txtDataFim]").removeClass("is-valid");
        $("input[name=txtDataFim]").addClass("is-invalid");
        $("input[name=txtDataFim]").focus();
        $(".invalid-dataTerminoTurma").html("Data Inválida! Término da turma antes da data de início.");
        return false;
    }       
    else if((anoTerminoTurma == anoInicioTurma) && (mesTerminoTurma < mesInicioTurma)){
        $("input[name=txtDataFim]").removeClass("is-valid");
        $("input[name=txtDataFim]").addClass("is-invalid");
        $("input[name=txtDataFim]").focus();
        $(".invalid-dataTerminoTurma").html("Data Inválida! Término da turma antes da data de início.");
        return false;
    }       
    else if((anoTerminoTurma < anoInicioTurma)){
        $("input[name=txtDataFim]").removeClass("is-valid");
        $("input[name=txtDataFim]").addClass("is-invalid");
        $("input[name=txtDataFim]").focus();
        $(".invalid-dataTerminoTurma").html("Data Inválida! Término da turma antes da data de início.");
        return false;
    }
    else if($("select[name=txtCurso]").val() == '0'){
        $("select[name=txtCurso]").removeClass("is-valid");
        $("select[name=txtCurso]").addClass("is-invalid");
        $("select[name=txtCurso]").focus();
        return false;
    }
    else if($("select[name=txtCategoria]").val() == '0'){
        $("select[name=txtCategoria]").removeClass("is-valid");
        $("select[name=txtCategoria]").addClass("is-invalid");
        $("select[name=txtCategoria]").focus();
        return false;
    }
});