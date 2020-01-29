/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//VARIÁVEIS AUXILIARES
var camposOk = 1; //testar se todos campos foram preenchidos corretamente
var cpfOk = 0; //testar validade do cpf


//AO CARREGAR OU RECARREGAR A PÁGINA
//FUNÇÕES
//SELECT
function validSelect(campo){
    if($(campo).val() != '0'){
        $(campo).removeClass("is-invalid");
        $(campo).addClass("is-valid");
        camposOk = 1;
    }
    else{
        camposOk = 0;
    }
};

//INPUT
function validInput(campo){
    if($(campo).val() != ''){
        $(campo).removeClass("is-invalid");
        $(campo).addClass("is-valid");
        camposOk = 1;
    }
    else{
        camposOk = 0;
    }
};
    
//FONE
function validFone(campo){
    var foneOM = $(campo).val().replace("-","").replace("(","").replace(")","").replace(" ","");
    if(foneOM == ''){
        camposOk = 0;
    }
    else if(foneOM == '0000000000' || foneOM == '1111111111' || foneOM == '2222222222' || foneOM == '3333333333' ||                 
            foneOM == '4444444444' || foneOM == '5555555555' || foneOM == '6666666666' || foneOM == '7777777777' ||                 
            foneOM == '8888888888' || foneOM == '9999999999'){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(".invalid-fone").html("Fone Inválido!");
        camposOk = 0;
    }
    else{
        $(campo).removeClass("is-invalid");
        $(campo).addClass("is-valid");
        camposOk = 1;
    }
};

//CEP
function validCEP(campo){  
    var endCepOM = $(campo).val().replace("-","").replace("(","").replace(")","").replace(" ","");
    if(endCepOM == ''){
        camposOk = 0;
    }
    else if(endCepOM == '00000000' || endCepOM == '11111111' || endCepOM == '22222222' || endCepOM == '33333333' ||                 
            endCepOM == '44444444' || endCepOM == '55555555' || endCepOM == '66666666' || endCepOM == '77777777' ||                 
            endCepOM == '88888888' || endCepOM == '99999999'){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(".invalid-cep").html("CEP Inválido!");
        camposOk = 0;
    }
    else{
        $(campo).removeClass("is-invalid");
        $(campo).addClass("is-valid");
        camposOk = 1;
    }
};

//DATA DE NASCIMENTO
function validDataNascAl(campo){  
    camposOk = 0;
    var dataNascAl = $(campo).val();
    var dataNascAlSplit = dataNascAl.split('-');        
    var diaNascAl = dataNascAlSplit[2];
    var mesNascAl = dataNascAlSplit[1];
    var anoNascAl = dataNascAlSplit[0];

    var dataAtual = new Date();
    var diaAtual = dataAtual.getDate();
    var mesAtual = (dataAtual.getMonth() + 1);
    var anoAtual = dataAtual.getFullYear();

    if(dataNascAl == ''){
        camposOk = 0;
    }       
    else if((anoNascAl == anoAtual) && (mesNascAl == mesAtual) && (diaNascAl > diaAtual)){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(".invalid-dataNascAl").html("Data Inválida!");
        camposOk = 0;
    }       
    else if((anoNascAl == anoAtual) && (mesNascAl > mesAtual)){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(".invalid-dataNascAl").html("Data Inválida!");
        camposOk = 0;
    }       
    else if((anoNascAl > anoAtual)){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(".invalid-dataNascAl").html("Data Inválida!");
        camposOk = 0;
    }       
    else if((anoAtual - anoNascAl) < 18){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(".invalid-dataNascAl").html("O Militar deve ter uma idade mínima de 18 anos!!");
        camposOk = 0;
    }       
    else{
        $(campo).removeClass("is-invalid");
        $(campo).addClass("is-valid");
        camposOk = 1;
    }
};

//IDENTIDADE MILITAR
function validIdtMilAl(campo){  
    camposOk = 0;
    var idtMilAl = $(campo).val().replace("-","").replace("(","").replace(")","").replace(" ","");
    
    if(idtMilAl == ''){
        camposOk = 0;
    }
    else if(idtMilAl == '0000000000' || idtMilAl == '1111111111' || idtMilAl == '2222222222' || idtMilAl == '3333333333' ||                 
            idtMilAl == '4444444444' || idtMilAl == '5555555555' || idtMilAl == '6666666666' || idtMilAl == '7777777777' ||                 
            idtMilAl == '8888888888' || idtMilAl == '9999999999'){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(".invalid-idtMilAl").html("Identidade Militar Inválida!");
        camposOk = 0;
    }
    else{
        $(campo).removeClass("is-invalid");
        $(campo).addClass("is-valid");
        camposOk = 1;
    }
};

//CPF
function validCPFAl(campo){
    camposOk = 0;
    var cpfAl = $(campo).val().replace(".","").replace(".","").replace("-","");
    
    if(cpfAl == ''){
        cpfOk = 0;
        camposOk = 0;
    }
    else if(cpfAl == '00000000000' || cpfAl == '11111111111' || cpfAl == '22222222222' || cpfAl == '33333333333' ||                 
            cpfAl == '44444444444' || cpfAl == '55555555555' || cpfAl == '66666666666' || cpfAl == '77777777777' ||                 
            cpfAl == '88888888888' || cpfAl == '99999999999'){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(".invalid-cpfAl").html("CPF Inválido!");
        cpfOk = 0;
        camposOk = 0;
    }else{
        // Valida 1o digito	
        var add = 0;	
        for (var i=0; i < 9; i ++)		
            add += parseInt(cpfAl.charAt(i)) * (10 - i);	
            var rev = 11 - (add % 11);	
            if (rev == 10 || rev == 11)		
                rev = 0;	
            if (rev != parseInt(cpfAl.charAt(9))){
                $(campo).removeClass("is-valid");
                $(campo).addClass("is-invalid");
                $(".invalid-cpfAl").html("CPF Inválido!");
                cpfOk = 0;
                camposOk = 0;
            }else{
                $(campo).removeClass("is-invalid");
                $(campo).addClass("is-valid");
                cpfOk = 1;
                camposOk = 1;
            }
        // Valida 2o digito	
        add = 0;	
        for (var i = 0; i < 10; i ++)		
            add += parseInt(cpfAl.charAt(i)) * (11 - i);	
        rev = 11 - (add % 11);	
        if (rev == 10 || rev == 11)	
            rev = 0;	
        if (rev != parseInt(cpfAl.charAt(10))){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-cpfAl").html("CPF Inválido!");
            cpfOk = 0;
            camposOk = 0;
        }else{
            $(campo).removeClass("is-invalid");
            $(campo).addClass("is-valid");
            cpfOk = 1;
            camposOk = 1;
        }    
    } 
};

//AO MUDAR O VALOR DO CAMPO
//FUNÇÕES
//SELECT
function validSelectTReal(campo){
    camposOk = 0;
    $(campo).change(function(){
        if($(campo).val() != '0'){
            $(campo).removeClass("is-invalid");
            $(campo).addClass("is-valid");
            camposOk = 1;
        }else{
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            camposOk = 0;
        }
    });
    
};

//INPUT
function validInputTReal(campo){
    $(campo).change(function(){
        if($(campo).val() != ''){
            $(campo).removeClass("is-invalid");
            $(campo).addClass("is-valid");
            camposOk = 1;
        }else{
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            camposOk = 0;
        }
    });
};
//FONE
function validFoneTReal(campo){  
    $(campo).change(function(){
        var foneOM = $(campo).val().replace("-","").replace("(","").replace(")","").replace(" ","");
        if(foneOM == ''){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-fone").html("Campo Obrigatório!");
            camposOk = 0;
        }
        else if(foneOM == '0000000000' || foneOM == '1111111111' || foneOM == '2222222222' || foneOM == '3333333333' ||                 
                foneOM == '4444444444' || foneOM == '5555555555' || foneOM == '6666666666' || foneOM == '7777777777' ||                 
                foneOM == '8888888888' || foneOM == '9999999999'){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-fone").html("Fone Inválido!")
            camposOk = 0;
        }
        else{
            $(campo).removeClass("is-invalid");
            $(campo).addClass("is-valid");
            camposOk = 1;
        }
    });
};

//CEP
function validCEPTReal(campo){  
    $(campo).change(function(){
        var endCepOM = $(campo).val().replace("-","").replace("(","").replace(")","").replace(" ","");
        if(endCepOM == ''){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-cep").html("Campo Obrigatório!");
            camposOk = 0;
        }
        else if(endCepOM == '00000000' || endCepOM == '11111111' || endCepOM == '22222222' || endCepOM == '33333333' ||                 
                endCepOM == '44444444' || endCepOM == '55555555' || endCepOM == '66666666' || endCepOM == '77777777' ||                 
                endCepOM == '88888888' || endCepOM == '99999999'){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-cep").html("CEP Inválido!");       
            camposOk = 0;
        }
        else{
            $(campo).removeClass("is-invalid");
            $(campo).addClass("is-valid");
            camposOk = 1;
        }
    });
};

//DATA DE NASCIMENTO
function validDataNascAlTReal(campo){ 
    camposOk = 0;
    $(campo).change(function(){
        var dataNascAl = $(campo).val();
        var dataNascAlSplit = dataNascAl.split('-');        
        var diaNascAl = dataNascAlSplit[2];
        var mesNascAl = dataNascAlSplit[1];
        var anoNascAl = dataNascAlSplit[0];
        
        var dataAtual = new Date();
        var diaAtual = dataAtual.getDate();
        var mesAtual = (dataAtual.getMonth() + 1);
        var anoAtual = dataAtual.getFullYear();
        
        if(dataNascAl == ''){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-dataNascAl").html("Campo Obrigatório!");
            camposOk = 0;
        }       
        else if((anoNascAl == anoAtual) && (mesNascAl == mesAtual) && (diaNascAl > diaAtual)){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-dataNascAl").html("Data Inválida!");
            camposOk = 0;
        }       
        else if((anoNascAl == anoAtual) && (mesNascAl > mesAtual)){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-dataNascAl").html("Data Inválida!");
            camposOk = 0;
        }       
        else if((anoNascAl > anoAtual)){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-dataNascAl").html("Data Inválida!");
            camposOk = 0;
        }       
        else if((anoAtual - anoNascAl) < 18){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-dataNascAl").html("O Militar deve ter uma idade mínima de 18 anos!!");
            camposOk = 0;
        }       
        else{
            $(campo).removeClass("is-invalid");
            $(campo).addClass("is-valid");
            camposOk = 1;
        }
    });    
};

//IDENTIDADE MILITAR
function validIdtMilAlTReal(campo){ 
    camposOk = 0;
    $(campo).change(function(){
        var idtMilAl = $(campo).val().replace("-","").replace(" ","");
        if(idtMilAl == ''){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-idtMilAl").html("Campo Obrigatório!");
            camposOk = 0;
        }
        else if(idtMilAl == '0000000000' || idtMilAl == '1111111111' || idtMilAl == '2222222222' || idtMilAl == '3333333333' ||                 
                idtMilAl == '4444444444' || idtMilAl == '5555555555' || idtMilAl == '6666666666' || idtMilAl == '7777777777' ||                 
                idtMilAl == '8888888888' || idtMilAl == '9999999999'){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-idtMilAl").html("Identidade Militar Inválida!");   
            camposOk = 0;
        }
        else{
            $(campo).removeClass("is-invalid");
            $(campo).addClass("is-valid");
            camposOk = 1;
        }
    });
};

//CPF
function validCPFAlTReal(campo){
    camposOk = 0;
    $(campo).change(function(){
        var cpfAl = $(campo).val().replace(".","").replace(".","").replace("-","");
        if(cpfAl == ''){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-cpfAl").html("Campo Obrigatório!");
            cpfOk = 0;
            camposOk = 0;
        }
        else if(cpfAl == '00000000000' || cpfAl == '11111111111' || cpfAl == '22222222222' || cpfAl == '33333333333' ||                 
                cpfAl == '44444444444' || cpfAl == '55555555555' || cpfAl == '66666666666' || cpfAl == '77777777777' ||                 
                cpfAl == '88888888888' || cpfAl == '99999999999'){
            $(campo).removeClass("is-valid");
            $(campo).addClass("is-invalid");
            $(".invalid-cpfAl").html("CPF Inválido!");
            cpfOk = 0;
            camposOk = 0;
        }else{
            // Valida 1o digito	
            var add = 0;	
            for (var i=0; i < 9; i ++)		
                add += parseInt(cpfAl.charAt(i)) * (10 - i);	
                var rev = 11 - (add % 11);	
                if (rev == 10 || rev == 11)		
                    rev = 0;	
                if (rev != parseInt(cpfAl.charAt(9))){
                    $(campo).removeClass("is-valid");
                    $(campo).addClass("is-invalid");
                    $(".invalid-cpfAl").html("CPF Inválido!");
                    cpfOk = 0;
                    camposOk = 0;
                }else{
                    $(campo).removeClass("is-invalid");
                    $(campo).addClass("is-valid");
                    cpfOk = 1;
                    camposOk = 1;
                }
            // Valida 2o digito	
            add = 0;	
            for (var i = 0; i < 10; i ++)		
                add += parseInt(cpfAl.charAt(i)) * (11 - i);	
            rev = 11 - (add % 11);	
            if (rev == 10 || rev == 11)	
                rev = 0;	
            if (rev != parseInt(cpfAl.charAt(10))){
                $(campo).removeClass("is-valid");
                $(campo).addClass("is-invalid");
                $(".invalid-cpfAl").html("CPF Inválido!");
                cpfOk = 0;
                camposOk = 0;
            }else{
                $(campo).removeClass("is-invalid");
                $(campo).addClass("is-valid");
                cpfOk = 1;
                camposOk = 1;
            }    
        }        
    });
};

$(document).ready(function(){
   
    //Etapa 1: OM ATUAL
    //Campo Select Força
    validSelect("select[name=txtForca]");
    validSelectTReal("select[name=txtForca]");
    
    //Campo Input Grande Comando
    validInput("input[name=txtGCmdo]");
    validInputTReal("input[name=txtGCmdo]");
    
    //Campo Input Escalão Ennquadrante
    validInput("input[name=txtEscEnq]");
    validInputTReal("input[name=txtEscEnq]");

    //Campo Input Nome OM
    validInput("input[name=txtNomeOM]"); 
    validInputTReal("input[name=txtNomeOM]"); 

    //Campo Input Abreviatura OM
    validInput("input[name=txtAbrevOM]"); 
    validInputTReal("input[name=txtAbrevOM]"); 

    //Campo Input Fone
    validFone("input[name=txtFoneOM]");
    validFoneTReal("input[name=txtFoneOM]");

    //Campo Select Posto/Graduação Cmt OM
    validSelect("select[name=txtPGradCmtOM]");
    validSelectTReal("select[name=txtPGradCmtOM]");

    //Campo Input Nome Cmt OM
    validInput("input[name=txtNomeCmtOM]"); 
    validInputTReal("input[name=txtNomeCmtOM]"); 

    //Campo Input Sobrenome Cmt OM
    validInput("input[name=txtSobrenomeCmtOM]");
    validInputTReal("input[name=txtSobrenomeCmtOM]");

    //Campo Input Nome de Guerra Cmt OM
    validInput("input[name=txtNomeGuerraCmtOM]");
    validInputTReal("input[name=txtNomeGuerraCmtOM]");

    //Campo Select Posto/Graduação Ch Imediato
    validSelect("select[name=txtPGradChImtoOM]");
    validSelectTReal("select[name=txtPGradChImtoOM]");

    //Campo Input Nome Ch Imediato
    validInput("input[name=txtNomeChImtoOM]");
    validInputTReal("input[name=txtNomeChImtoOM]");

    //Campo Input Sobrenome Ch Imediato
    validInput("input[name=txtSobrenomeChImtoOM]");
    validInputTReal("input[name=txtSobrenomeChImtoOM]");

    //Campo Input Nome de Guerra Ch Imediato
    validInput("input[name=txtNomeGuerraChImtoOM]");
    validInputTReal("input[name=txtNomeGuerraChImtoOM]");

    //Campo Input CEP
    validCEP("input[name=txtEndCepOM]");   
    validCEPTReal("input[name=txtEndCepOM]");   

    //Campo Select Logradouro
    validSelect("select[name=txtEndLogOM]");
    validSelectTReal("select[name=txtEndLogOM]");

    //Campo Input Endereço
    validInput("input[name=txtEndNomeOM]");  
    validInputTReal("input[name=txtEndNomeOM]");  

    //Campo Input Número
    validInput("input[name=txtEndNumOM]");
    validInputTReal("input[name=txtEndNumOM]");

    //Campo Select País
    validSelect("select[name=txtEndPaisOM]");
    validSelectTReal("select[name=txtEndPaisOM]");

    //Campo Select Estado
    validSelect("select[name=txtEndEstadoOM]");
    validSelectTReal("select[name=txtEndEstadoOM]");

    //Campo Select Cidade
    validSelect("select[name=txtEndCidadeOM]");
    validSelectTReal("select[name=txtEndCidadeOM]");

    //Campo Select Bairro
    validSelect("select[name=txtEndBairroOM]");
    validSelectTReal("select[name=txtEndBairroOM]");
     alert(camposOk);
});

//AO CLICAR NO BOTÃO PRÓXIMO OU SALVAR (OBRIGATORIEDADE)
//FUNÇÕES
//SELECT
function validSelectObg(campo){
    camposOk = 0;
    if($(campo).val() == '0'){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(campo).focus();
        return false;
        camposOk = 0;
    }else{
        return true;
        camposOk = 1;
    }
};


//INPUT
function validInputObg(campo){
    camposOk = 0;
    if($(campo).val() == ''){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(campo).focus();
        return false;
        camposOk = 0;
    }else{
        return true;
        camposOk = 1;
    }
};

//FONE
function validFoneObg(campo, foneOM){
    camposOk = 0;
    if(foneOM == ''){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(campo).focus();
        $(".invalid-fone").html("Campo Obrigatório!");   
        return false;
        camposOk = 0;
    }
    else if(foneOM == '0000000000' || foneOM == '1111111111' || foneOM == '2222222222' || foneOM == '3333333333' ||                 
             foneOM == '4444444444' || foneOM == '5555555555' || foneOM == '6666666666' || foneOM == '7777777777' ||                 
             foneOM == '8888888888' || foneOM == '9999999999'){             
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(campo).focus();
        $(".invalid-fone").html("Fone Inválido!");
        return false;
        camposOk = 0;
    }
    else{
        return true;
        camposOk = 1;
    }
};

//CEP
function validCEPObg(campo, endCepOM){
    camposOk = 0;
    if(endCepOM == ''){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(campo).focus();
        $(".invalid-cep").html("Campo Obrigatório!");
        return false;
        camposOk = 0;
    }
    else if(endCepOM == '00000000' || endCepOM == '11111111' || endCepOM == '22222222' || endCepOM == '33333333' ||                 
            endCepOM == '44444444' || endCepOM == '55555555' || endCepOM == '66666666' || endCepOM == '77777777' ||                 
            endCepOM == '88888888' || endCepOM == '99999999'){
        $(campo).removeClass("is-valid");
        $(campo).addClass("is-invalid");
        $(campo).focus();
        $(".invalid-cep").html("CEP Inválido!");
        return false;
        camposOk = 0;
    }
    else{
        return true;
        camposOk = 1;
    }
}

$(function(){
    var atual_fs, prox_fs, anterior_fs;
    
    function proximo(elemento){
        atual_fs = $(elemento).parent();
        prox_fs = $(elemento).parent().next();

        $('#progress li').eq($('fieldset').index(prox_fs)).addClass('ativo');
        atual_fs.hide(800);
        prox_fs.show(800);
    }

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
    
    //OBRIGATORIEDADE
    //Etapa 1: OM ATUAL
    $("button[name=btnProximo2]").click(function(){
        var foneOM = $("input[name=txtFoneOM]").val().replace("-","").replace("(","").replace(")","").replace(" ","");
        var endCepOM = $("input[name=txtEndCepOM]").val().replace("_","").replace("_","").replace("_","").replace("_","").replace("_","").replace("_","").replace("_","").replace("_","").replace("-","");
        
        validSelectObg("select[name=txtEndBairroOM]");
        validSelectObg("select[name=txtEndCidadeOM]");
        validSelectObg("select[name=txtEndEstadoOM]");
        validSelectObg("select[name=txtEndPaisOM]");
        
        validInputObg("input[name=txtEndNumOM]");
        validInputObg("input[name=txtEndNomeOM]");
        validSelectObg("select[name=txtEndLogOM]");
        validCEPObg("input[name=txtEndCepOM]", endCepOM);
        
        validInputObg("input[name=txtNomeGuerraChImtoOM]");
        validInputObg("input[name=txtSobrenomeChImtoOM]");
        validInputObg("input[name=txtNomeChImtoOM]");
        validSelectObg("select[name=txtPGradChImtoOM]");
        
        validInputObg("input[name=txtNomeGuerraCmtOM]");
        validInputObg("input[name=txtSobrenomeCmtOM]");
        validInputObg("input[name=txtNomeCmtOM]");
        validSelectObg("select[name=txtPGradCmtOM]");
        
        validFoneObg("input[name=txtFoneOM]", foneOM);
        validInputObg("input[name=txtAbrevOM]");
        validInputObg("input[name=txtNomeOM]");
        
        validInputObg("input[name=txtEscEnq]");
        validInputObg("input[name=txtGCmdo]");
        validSelectObg("select[name=txtForca]");        
     
        //Próxima Etapa
        //else {
        if(camposOk == 0){
            proximo($(this));
        }
    });
});
