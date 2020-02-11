/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var forca = {"forca":[
                        {"id":"1", "nome":"Marinha do Brasil", "sigla":"mb"},
                        {"id":"2", "nome":"Exército Brasileiro", "sigla":"eb"},
                        {"id":"3", "nome":"Força Aérea Brasileira", "sigla":"fab"}
                    ]};



var dados = {
    "estados":[
        {"nome":"Amazonas", "sigla":"AM", 
            "cidades":[
                {"id":"1", "nome":"Manaus"},
                {"id":"2", "nome":"Manacapuru"}
            ]
        },
        {"nome":"Roraima", "sigla":"RR", 
            "cidades":[
                {"id":"1", "nome":"Aquela"},
                {"id":"2", "nome":"Aquilo"}
            ]
        },
        {"nome":"Para", "sigla":"PA", 
            "cidades":[
                {"id":"1", "nome":"Belem"},
                {"id":"2", "nome":"Santarem"}
            ]
        }
    ]
    
    
};

function carregar_dados(id, cidadeId){
    //var html = '';
    if((id == 'txtEndEstadoOM') && (cidadeId == null)){
        $("#txtEndEstadoOM").html("");
        $("#txtEndEstadoOM").append("<option value=0>Selecione um Estado...</option>");
        for(var i=0; i<dados.estados.length; i++){
            $("#txtEndEstadoOM").append("<option value="+dados.estados[i].sigla+">"+dados.estados[i].nome+"</option>");
            //html += "<option value="+dados.estados[i].sigla+">"+dados.estados[i].nome+"</option>";
        }
    }else{
        //$("#txtEndCidadeOM").remove('<option>');
        for(var i=0; dados.estados.length; i++){
            if(dados.estados[i].sigla == cidadeId){
                $("#txtEndCidadeOM").html("");
                $("#txtEndCidadeOM").append("<option value=0>Selecione a cidade...</option>");
                for(var j=0; j<dados.estados[i].cidades.length; j++){
                    $("#txtEndCidadeOM").append("<option value="+dados.estados[i].sigla+">"+dados.estados[i].cidades[j].nome+"</option>");
                    //html += "<option value="+dados.estados[i].sigla+">"+dados.estados[i].cidades[j].nome+"</option>";
                }
            }
        }
    }
    //$("#"+id).html(html);
}

$(document).ready(function(){     
    carregar_dados('txtEndEstadoOM');
    $("#txtEndEstadoOM").change(function(){
        var cidadeId = $(this).val();
        if(cidadeId != null){
            carregar_dados('txtEndCidadeOM', cidadeId);
        }
    });
    
    for(var i=0;i<forca.forca.length;i++){
        $("#txtForca").append("<option value="+forca.forca[i].sigla+">"+forca.forca[i].nome+"</option>");
    }
});