//AO CARREGAR OU RECARREGAR A PÁGINA
//FUNÇÕES
//SELECT
function limpaCampoInput(campo){
    $(campo).val('0');    
    $(campo).removeClass("is-valid");
    $(campo).removeClass("is-invalid");
}

function limpaCampoSelect(campo){
    $(campo).val('0');    
    $(campo).removeClass("is-valid");
    $(campo).removeClass("is-invalid");
}

function validSelect(campo){
    if($(campo).val() != '0'){
        $(campo).removeClass("is-invalid");
        $(campo).addClass("is-valid");
    }
};

//DATA DE INÍCIO TURMA
function validDataInicioTurma(campo, campoAnoTurma){
    var anoTurma = $(campoAnoTurma).val();
    
    var dataInicioTurma = $(campo).val();
    var dataInicioTurmaSplit = dataInicioTurma.split('-');        
    var diaInicioTurma = dataInicioTurmaSplit[2];
    var mesInicioTurma = dataInicioTurmaSplit[1];
    var anoInicioTurma = dataInicioTurmaSplit[0];

    var dataAtual = new Date();
    var diaAtual = dataAtual.getDate();
    var mesAtual = (dataAtual.getMonth() + 1);
    var anoAtual = dataAtual.getFullYear();

    if(dataInicioTurma == ''){
    }
    else if(anoInicioTurma != anoTurma){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(".invalid-dataInicioTurma").html("Data Inválida! O ano de início não pode ser diferente do ano acima.");
    }
    else if((anoInicioTurma == anoAtual) && (mesInicioTurma == mesAtual) && (diaInicioTurma < diaAtual)){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(".invalid-dataInicioTurma").html("Data Inválida! Início da turma antes da data atual.");
    }       
    else if((anoInicioTurma == anoAtual) && (mesInicioTurma < mesAtual)){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(".invalid-dataInicioTurma").html("Data Inválida! Início da turma antes da data atual.");
    }       
    else if((anoInicioTurma < anoAtual)){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(".invalid-dataInicioTurma").html("Data Inválida! Início da turma antes da data atual.");
    }   
    else{
        $(campo).removeClass("is-invalid");
        $(campo).addClass("is-valid");
    }    
};

//DATA DE TÉRMINO TURMA
function validDataTerminoTurma(campoTermino, campoInicio, campoAnoTurma){
    var anoTurma = $(campoAnoTurma).val();
    
    var dataTerminoTurma = $(campoTermino).val();
    var dataTerminoTurmaSplit = dataTerminoTurma.split('-');        
    var diaTerminoTurma = dataTerminoTurmaSplit[2];
    var mesTerminoTurma = dataTerminoTurmaSplit[1];
    var anoTerminoTurma = dataTerminoTurmaSplit[0];

    var dataInicioTurma = $(campoInicio).val();
    var dataInicioTurmaSplit = dataInicioTurma.split('-');        
    var diaInicioTurma = dataInicioTurmaSplit[2];
    var mesInicioTurma = dataInicioTurmaSplit[1];
    var anoInicioTurma = dataInicioTurmaSplit[0];

    if(dataTerminoTurma == ''){
    }
    else if(anoTerminoTurma != anoTurma){
        $(campoTermino).removeClass("is-valid");
        $(campoTermino).addClass("is-invalid");
        $(".invalid-dataTerminoTurma").html("Data Inválida! O ano de término não pode ser diferente do ano acima.");
    }
    else if((anoTerminoTurma == anoInicioTurma) && (mesTerminoTurma == mesInicioTurma) && (diaTerminoTurma < diaInicioTurma)){
        $(campoTermino).removeClass("is-valid");
        $(campoTermino).addClass("is-invalid");
        $(".invalid-dataTerminoTurma").html("Data Inválida! Término da turma antes da data de início.");
    }       
    else if((anoTerminoTurma == anoInicioTurma) && (mesTerminoTurma < mesInicioTurma)){
        $(campoTermino).removeClass("is-valid");
        $(campoTermino).addClass("is-invalid");
        $(".invalid-dataTerminoTurma").html("Data Inválida! Término da turma antes da data de início.");
    }       
    else if((anoTerminoTurma < anoInicioTurma)){
        $(campoTermino).removeClass("is-valid");
        $(campoTermino).addClass("is-invalid");
        $(".invalid-dataTerminoTurma").html("Data Inválida! Término da turma antes da data de início.");
    }   
    else{
        $(campoTermino).removeClass("is-invalid");
        $(campoTermino).addClass("is-valid");
    }    
};

//AO MUDAR O VALOR DO CAMPO
//FUNÇÕES
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

//DATA DE INÍCIO TURMA
function validDataInicioTurmaTReal(campo, campoAnoTurma){
    $(campo).change(function(){
        var anoTurma = $(campoAnoTurma).val();
        
        var dataInicioTurma = $(campo).val();
        var dataInicioTurmaSplit = dataInicioTurma.split('-');        
        var diaInicioTurma = dataInicioTurmaSplit[2];
        var mesInicioTurma = dataInicioTurmaSplit[1];
        var anoInicioTurma = dataInicioTurmaSplit[0];

        var dataAtual = new Date();
        var diaAtual = dataAtual.getDate();
        var mesAtual = (dataAtual.getMonth() + 1);
        var anoAtual = dataAtual.getFullYear();

        if(dataInicioTurma == ''){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-dataInicioTurma").html("Campo Obrigatório!");
        }
        else if(anoInicioTurma != anoTurma){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-dataInicioTurma").html("Data Inválida! O ano de início não pode ser diferente do ano acima.");
        }
        else if((anoInicioTurma == anoAtual) && (mesInicioTurma == mesAtual) && (diaInicioTurma < diaAtual)){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-dataInicioTurma").html("Data Inválida! Início da turma antes da data atual.");
        }       
        else if((anoInicioTurma == anoAtual) && (mesInicioTurma < mesAtual)){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-dataInicioTurma").html("Data Inválida! Início da turma antes da data atual.");
        }       
        else if((anoInicioTurma < anoAtual)){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-dataInicioTurma").html("Data Inválida! Início da turma antes da data atual.");
        }   
        else{
            $(campo).removeClass("is-invalid");
            $(campo).addClass("is-valid");
        }
    });    
};

//DATA DE TERMINO TURMA
function validDataTerminoTurmaTReal(campoTermino, campoInicio, campoAnoTurma){
    $(campoTermino).change(function(){
        var anoTurma = $(campoAnoTurma).val();
        
        var dataTerminoTurma = $(campoTermino).val();
        var dataTerminoTurmaSplit = dataTerminoTurma.split('-');        
        var diaTerminoTurma = dataTerminoTurmaSplit[2];
        var mesTerminoTurma = dataTerminoTurmaSplit[1];
        var anoTerminoTurma = dataTerminoTurmaSplit[0];

        var dataInicioTurma = $(campoInicio).val();
        var dataInicioTurmaSplit = dataInicioTurma.split('-');        
        var diaInicioTurma = dataInicioTurmaSplit[2];
        var mesInicioTurma = dataInicioTurmaSplit[1];
        var anoInicioTurma = dataInicioTurmaSplit[0];

        if(dataTerminoTurma == ''){
            $(campoTermino).removeClass("is-valid");
            $(campoTermino).addClass("is-invalid");
            $(".invalid-dataInicioTurma").html("Campo Obrigatório!");
        }
        else if(anoTerminoTurma != anoTurma){
            $(campoTermino).removeClass("is-valid");
            $(campoTermino).addClass("is-invalid");
            $(".invalid-dataTerminoTurma").html("Data Inválida! O ano de término não pode ser diferente do ano acima.");
        }
        else if((anoTerminoTurma == anoInicioTurma) && (mesTerminoTurma == mesInicioTurma) && (diaTerminoTurma < diaInicioTurma)){
            $(campoTermino).removeClass("is-valid");
            $(campoTermino).addClass("is-invalid");
            $(".invalid-dataTerminoTurma").html("Data Inválida! Término da turma antes da data de início.");
        }       
        else if((anoTerminoTurma == anoInicioTurma) && (mesTerminoTurma < mesInicioTurma)){
            $(campoTermino).removeClass("is-valid");
            $(campoTermino).addClass("is-invalid");
            $(".invalid-dataTerminoTurma").html("Data Inválida! Término da turma antes da data de início.");
        }       
        else if((anoTerminoTurma < anoInicioTurma)){
            $(campoTermino).removeClass("is-valid");
            $(campoTermino).addClass("is-invalid");
            $(".invalid-dataTerminoTurma").html("Data Inválida! Término da turma antes da data de início.");
        }   
        else{
            $(campoTermino).removeClass("is-invalid");
            $(campoTermino).addClass("is-valid");
        }
    });    
};