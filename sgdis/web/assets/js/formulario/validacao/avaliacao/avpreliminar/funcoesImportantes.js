//AO CARREGAR OU RECARREGAR A PÁGINA
//FUNÇÕES
//SELECT
function limpaCampoInput(campo){
    $(campo).val('');    
    $(campo).removeClass("is-valid");
    $(campo).removeClass("is-invalid");
}

function limpaCampoSelect(campo){
    $(campo).val('0');    
    $(campo).removeClass("is-valid");
    $(campo).removeClass("is-invalid");
}

//Select
function validSelect(campo){
    if($(campo).val() != '0'){
        $(campo).removeClass("is-invalid");
        $(campo).addClass("is-valid");
    }
};

//Input
function validInput(campo){
    if($(campo).val() != ''){
        $(campo).removeClass("is-invalid");
        $(campo).addClass("is-valid");
    }
};

//IDENTIDADE MILITAR
function validIdentidadeAl(campo){  
    var idtMilAl = $(campo).val().replace("-","").replace("(","").replace(")","").replace(" ","");
    
    if(idtMilAl == ''){
    }
    else if(idtMilAl == '0000000000' || idtMilAl == '1111111111' || idtMilAl == '2222222222' || idtMilAl == '3333333333' ||                 
            idtMilAl == '4444444444' || idtMilAl == '5555555555' || idtMilAl == '6666666666' || idtMilAl == '7777777777' ||                 
            idtMilAl == '8888888888' || idtMilAl == '9999999999'){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(".invalid-identidadeAl").html("Identidade Militar Inválida!");
    }
    else{
        $(campo).removeClass("is-invalid");
        $(campo).addClass("is-valid");
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

//Input
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

//IDENTIDADE MILITAR
function validIdentidadeAlTReal(campo){ 
    $(campo).change(function(){
        var idtMilAl = $(campo).val().replace("-","").replace(" ","");
        if(idtMilAl == ''){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-identidadeAl").html("Campo Obrigatório!");
        }
        else if(idtMilAl == '0000000000' || idtMilAl == '1111111111' || idtMilAl == '2222222222' || idtMilAl == '3333333333' ||                 
                idtMilAl == '4444444444' || idtMilAl == '5555555555' || idtMilAl == '6666666666' || idtMilAl == '7777777777' ||                 
                idtMilAl == '8888888888' || idtMilAl == '9999999999'){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-identidadeAl").html("Identidade Militar Inválida!");  
        }
        else{
            $(campo).removeClass("is-invalid");
            $(campo).addClass("is-valid");
        }
    });
};