function alimentaSelectForca(forcas){
    dwr.util.removeAllOptions("txtForca");
    dwr.util.addOptions("txtForca", [{id: "0", nome: "Selecione uma Força..."}], "id", "nome");
    dwr.util.addOptions("txtForca", forcas, "id", "nome");
}
FacadeAjax.getForcasDWR(alimentaSelectForca);

function alimentaSelectDependenteForca(idForca){
    FacadeAjax.getEstadosByForcaDWR(idForca, {
        callback: function(estados){
            dwr.util.removeAllOptions("txtEstadoForca");
            dwr.util.addOptions("txtEstadoForca", [{id: "0", nome: "Selecione um Estado..."}], "id", "nome");
            dwr.util.addOptions("txtEstadoForca", estados, "id", "nome");
        } 
    });
    
    FacadeAjax.getPGsByForcaExcetoCbSdDWR(idForca, {
        callback: function(postosgraduacoes){
            dwr.util.removeAllOptions("txtPGradCmtOM");
            dwr.util.addOptions("txtPGradCmtOM", [{id: "0", abreviatura: "Selecione um Posto/Graduação..."}], "id", "abreviatura");
            dwr.util.addOptions("txtPGradCmtOM", postosgraduacoes, "id", "abreviatura");
            
            dwr.util.removeAllOptions("txtPGradChImtoOM");
            dwr.util.addOptions("txtPGradChImtoOM", [{id: "0", abreviatura: "Selecione um Posto/Graduação..."}], "id", "abreviatura");
            dwr.util.addOptions("txtPGradChImtoOM", postosgraduacoes, "id", "abreviatura");
            
            dwr.util.removeAllOptions("txtPGradAl");
            dwr.util.addOptions("txtPGradAl", [{id: "0", abreviatura: "Selecione um Posto/Graduação..."}], "id", "abreviatura");
            dwr.util.addOptions("txtPGradAl", postosgraduacoes, "id", "abreviatura");
        }
    });
}
function alimentaSelectDependenteEstado(idForca, idEstado){
    FacadeAjax.getOmsByForcaAndEstadoDWR(idForca, idEstado, {
        callback: function(oms){
            dwr.util.removeAllOptions("txtNomeOM");
            dwr.util.addOptions("txtNomeOM", [{id: "0", nome: "Selecione uma OM..."}], "id", "nome");
            dwr.util.addOptions("txtNomeOM", oms, "id", "nome");
        } 
    });
}

function alimentaSelectDependenteOM(idOM){
    FacadeAjax.getOmByIdDWR(idOM, {
        callback:function(om){
            dwr.util.setValues({txtEndCepOM: om.cepEndereco,
                                txtEndNumOM: om.numendereco});
            $("#txtEndCepOM").trigger('change');
            
            if(om.numendereco != null && om.numendereco != ""){
                $("#txtEndNumOM").addClass("is-valid");
                $("#txtEndNumOM").removeClass("is-invalid");
            }else{
                $("#txtEndNumOM").removeClass("is-valid");
                $("#txtEndNumOM").removeClass("is-invalid");
            }
        }
    });
}

function alimentaSelectArma(armas){
    dwr.util.removeAllOptions("txtArmaAl");
    dwr.util.addOptions("txtArmaAl", [{id: "0", nome: "Selecione uma Arma..."}], "id", "nome");
    dwr.util.addOptions("txtArmaAl", armas, "id", "nome");
}
FacadeAjax.getQasQmsDWR(alimentaSelectArma);

function alimentaSelectEstadoNaturalidade(estados){
    dwr.util.removeAllOptions("txtNatEstAl");
    dwr.util.addOptions("txtNatEstAl", [{id: "0", nome: "Selecione um Estado..."}], "id", "nome");
    dwr.util.addOptions("txtNatEstAl", estados, "id", "nome");
}
FacadeAjax.getEstadosDWR(alimentaSelectEstadoNaturalidade);
function alimentaSelectDependenteEstadoNaturalidade(idEstado){
    FacadeAjax.getCidadesByEstadoDWR(idEstado, {
        callback: function(cidades){
            dwr.util.removeAllOptions("txtNatCidAl");
            dwr.util.addOptions("txtNatCidAl", [{id: "0", nome: "Selecione uma Cidade..."}], "id", "nome");
            dwr.util.addOptions("txtNatCidAl", cidades, "id", "nome");
        } 
    });
}

function alimentaSelectEstadoCivil(ecs){
    dwr.util.removeAllOptions("txtEstCivilAl");
    dwr.util.addOptions("txtEstCivilAl", [{id: "0", nome: "Selecione um Estado Civil..."}], "id", "nome");
    dwr.util.addOptions("txtEstCivilAl", ecs, "id", "nome");
}
FacadeAjax.getEstadosCivisDWR(alimentaSelectEstadoCivil);

function alimentaSelectEstadoTitEleitor(estados){
    dwr.util.removeAllOptions("txtTitEleitorEstAl");
    dwr.util.addOptions("txtTitEleitorEstAl", [{id: "0", nome: "Selecione um Estado..."}], "id", "nome");
    dwr.util.addOptions("txtTitEleitorEstAl", estados, "id", "nome");
}
FacadeAjax.getEstadosDWR(alimentaSelectEstadoTitEleitor);
function alimentaSelectDependenteEstadoTitEleitor(idEstado){
    FacadeAjax.getCidadesByEstadoDWR(idEstado, {
        callback: function(cidades){
            dwr.util.removeAllOptions("txtTitEleitorCidAl");
            dwr.util.addOptions("txtTitEleitorCidAl", [{id: "0", nome: "Selecione uma Cidade..."}], "id", "nome");
            dwr.util.addOptions("txtTitEleitorCidAl", cidades, "id", "nome");
        } 
    });
}

$("select[name=txtForca]").change(function(){
    alimentaSelectDependenteForca(this.value);
});
$("select[name=txtEstadoForca]").change(function(){
    var idForca = $("select[name=txtForca]").val();
    alimentaSelectDependenteEstado(idForca, this.value);
});
$("select[name=txtNomeOM]").change(function(){
    alimentaSelectDependenteOM(this.value);
});
$("select[name=txtNatEstAl]").change(function(){
    alimentaSelectDependenteEstadoNaturalidade(this.value);
});
$("select[name=txtTitEleitorEstAl]").change(function(){
    alimentaSelectDependenteEstadoTitEleitor(this.value);
});

/*function preencheFormulario(idtCandidato){
    FacadeAjax.getAlunoByIdentidadeDWR(idtCandidato, {
       callback:function(candidato){
            dwr.util.setValues({txtNomeAl: candidato.nome});
            dwr.util.setValues({txtSobrenomeAl: candidato.sobrenome});
            dwr.util.setValues({txtNomeGuerraAl: candidato.nomeguerra});
            dwr.util.setValues({txtIdtMilAl: candidato.identidade});
       }
    }); 
}

$(document).ready(function(){
    var idtCandidato = $("input[name=idtMilCandidato]").val();
    preencheFormulario(idtCandidato);
});*/