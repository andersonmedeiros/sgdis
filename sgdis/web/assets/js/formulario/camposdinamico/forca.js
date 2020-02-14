/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var dados_forca = {
    "forca":[
        {
            "sigla": "EB",
            "nome": "Exército Brasileiro",
            "estados": [
                {
                    "sigla": "AC",
                    "nome": "Acre",
                    "om": [
                        {
                            "sigla": "4ª DSM/31º CSM",
                            "nome": "4ª Delegacia do Serviço Militar da 31ª C S M"
                        },
                        {
                            "sigla": "61º BIS",
                            "nome": "61º Batalhão de Infantaria de Selva"
                        },
                        {
                            "sigla": "7º BEC",
                            "nome": "7º Batalhão de Engenharia de Construção"
                        },
                        {
                            "sigla": "CFAC/4º BIS",
                            "nome": "Comando de Fronteira Acre e 4º Batalhão de Infantaria de Selva"
                        }
                        
                    ]
                },
                {
                    "sigla": "AL",
                    "nome": "Alagoas",
                    "om": [
                        {
                            "sigla": "20ª CSM",
                            "nome": "20ª Circunscrição de Serviço Militar"
                        },
                        {
                            "sigla": "1ª DSM/20º CSM",
                            "nome": "1ª Delegacia do Serviço Militar da 20ª C S M"
                        },
                        {
                            "sigla": "4º DSM/20º CSM",
                            "nome": "4ª Delegacia do Serviço Militar da 20ª C S M"
                        },
                        {
                            "sigla": "5º DSM/20º CSM",
                            "nome": "5ª Delegacia do Serviço Militar da 20ª C S M"
                        },
                        {
                            "sigla": "6º DSM/20º CSM",
                            "nome": "6ª Delegacia do Serviço Militar da 20ª C S M"
                        },
                        {
                            "sigla": "TG 07/015",
                            "nome": "Tiro de Guerra de Arapiraca"
                        },
                        {
                            "sigla": "TG 07/007",
                            "nome": "Tiro de Guerra de Palmeira dos Índios"
                        },
                        {
                            "sigla": "TG 07/008",
                            "nome": "Tiro de Guerra de São José da Laje"
                        },
                        {
                            "sigla": "TG 07/022",
                            "nome": "Tiro de Guerra de Teotônio Vilela"
                        },
                        {
                            "sigla": "59º BIMTZ",
                            "nome": "59º Batalhão de Infantaria Motorizado"
                        }
                        
                    ]
                }
                
            ]
        }
    ]
    
};

function carregar_forca(id, estadoForca){
    if((id == "txtForca") && (estadoForca == null)){
        $("#txtForca").html("");
        $("#txtForca").append("<option value=0>Selecione uma Força...</option>");
        $("#txtForca").removeClass("is-invalid");
        $("#txtForca").removeClass("is-valid");
        
        for(var i=0; i<dados_forca.forca.length; i++){
            $("#txtForca").append("<option value="+"'"+dados_forca.forca[i].sigla+"'"+">"+dados_forca.forca[i].nome+"</option>");
        }
    }else{
        for(var i=0; dados_forca.forca.length; i++){
            if(dados_forca.forca[i].sigla == estadoForca){
                $("#txtEstadoForca").html("");
                $("#txtEstadoForca").append("<option value=0>Selecione um Estado...</option>");
                $("#txtEstadoForca").removeClass("is-invalid");
                $("#txtEstadoForca").removeClass("is-valid");
                for(var j=0; j<dados_forca.forca[i].estados.length; j++){
                    $("#txtEstadoForca").append("<option value="+"'"+dados_forca.forca[i].estados[j].sigla+"'"+">"+dados_forca.forca[i].estados[j].nome+"</option>");
                }
            }            
        }
    }
};

function carregar_estado_om(id, sigla_forca, estado_om){    
    for(var i=0; dados_forca.forca.length; i++){
        if(dados_forca.forca[i].sigla == sigla_forca){  
            for(var j=0; j<dados_forca.forca[i].estados.length; j++){
                if(dados_forca.forca[i].estados[j].sigla == estado_om){
                    $("#txtNomeOM").html("");
                    $("#txtNomeOM").append("<option value=0>Selecione uma Organização Militar...</option>");
                    $("#txtNomeOM").removeClass("is-invalid");
                    $("#txtNomeOM").removeClass("is-valid");
                    for(var k=0; k<dados_forca.forca[i].estados[j].om.length;k++){
                        $("#txtNomeOM").append("<option value="+"'"+dados_forca.forca[i].estados[j].om[k].sigla+"'"+">"+dados_forca.forca[i].estados[j].om[k].nome+"</option>");
                    }
                }

            }
        }            
    }
};

function carregar_sigla_om(id, sigla_forca, estado_om, sigla_om){    
    for(var i=0; dados_forca.forca.length; i++){
        if(dados_forca.forca[i].sigla == sigla_forca){  
            for(var j=0; j<dados_forca.forca[i].estados.length; j++){
                if(dados_forca.forca[i].estados[j].sigla == estado_om){
                    for(var k=0; k<dados_forca.forca[i].estados[j].om.length;k++){
                        if(dados_forca.forca[i].estados[j].om[k].sigla == sigla_om){
                            $("#txtAbrevOM").val(dados_forca.forca[i].estados[j].om[k].sigla);
                        }
                    }
                }

            }
        }            
    }
};

function limpa_form_om(){
    $("#txtEstadoForca").html("");
    $("#txtEstadoForca").append("<option value=0>Selecione um Estado...</option>");
    $("#txtEstadoForca").removeClass("is-invalid");
    $("#txtEstadoForca").removeClass("is-valid");

    $("#txtNomeOM").html("");
    $("#txtNomeOM").append("<option value=0>Selecione uma Organização Militar...</option>");
    $("#txtNomeOM").removeClass("is-invalid");
    $("#txtNomeOM").removeClass("is-valid");

    $("#txtAbrevOM").val('');
    $("#txtAbrevOM").removeClass("is-invalid");
    $("#txtAbrevOM").removeClass("is-valid");
}

$(function(){
    carregar_forca("txtForca"); 
    
    if($("#txtForca").val() == "0"){
        limpa_form_om();
    }
    $("#txtForca").change(function(){
        var estForca = $(this).val();
        if($("#txtForca").val() == "0"){
            limpa_form_om();
        }
        else if(estForca != null){
            carregar_forca("#txtEstadoForca", estForca);            
        }
    });
    
    $("#txtEstadoForca").change(function(){
        var estado_om = $(this).val();
        var sigla_forca = $("#txtForca").val();
        if($("#txtEstadoForca").val() == "0"){
            $("#txtNomeOM").html("");
            $("#txtNomeOM").append("<option value=0>Selecione uma Organização Militar...</option>");
            $("#txtNomeOM").removeClass("is-invalid");
            $("#txtNomeOM").removeClass("is-valid");
        }
        else if($("#txtEstadoForca").val() != null){
            carregar_estado_om("#txtNomeOM", sigla_forca, estado_om);            
        }
    });
    
    $("#txtNomeOM").change(function(){
        var sigla_om = $(this).val();
        var sigla_forca = $("#txtForca").val();
        var estado_om = $("#txtEstadoForca").val();
        
        carregar_sigla_om("#txtAbrevOM", sigla_forca, estado_om, sigla_om);            
        
    });
    
    
});