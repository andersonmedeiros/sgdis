function montaSelectCurso(cursos){
    dwr.util.removeAllOptions("txtCurso");
    dwr.util.addOptions("txtCurso", [{id: "0", sigla: "Selecione um Curso..."}], "id", "sigla");
    dwr.util.addOptions("txtCurso", cursos, "id", "sigla");
}

FacadeAjax.getCursosDWR(montaSelectCurso);
function montaSelectDependenteCurso(idCurso){
    FacadeAjax.getCategoriasByCursoDWR(idCurso, {
       callback: function(categorias){
           dwr.util.removeAllOptions("txtCategoria");
           dwr.util.addOptions("txtCategoria", [{id: "0", nome: "Selecione uma Categoria..."}], "id", "nome");
           dwr.util.addOptions("txtCategoria", categorias, "id", "nome");
       } 
    });
}

function montaSelectDependenteCursoAndCategoria(idCurso, idCategoria){
    FacadeAjax.getTurmasAbertasByCursoAndCategoriaDWR(idCurso, idCategoria, {
       callback: function(turmas){
           dwr.util.removeAllOptions("txtTurma");
           dwr.util.addOptions("txtTurma", [{id: "0", turma: "Selecione uma Turma..."}], "id", "turma");
           dwr.util.addOptions("txtTurma", turmas, "id", "turma");
       } 
    });
}

$("select[name=txtCurso]").change(function(){
    montaSelectDependenteCurso(this.value);
});

$("select[name=txtCategoria]").change(function(){
    var idCurso = $("select[name=txtCurso]").val();
    montaSelectDependenteCursoAndCategoria(idCurso, this.value);
});

var functionValidSelectTReal = function(campo){
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

/*$("select[name=txtAvaliacao]").change(function(){
    var av = $("select[name=txtAvaliacao]").val();
    
    if(av == 1){*/
function avlPsico(identidade){
    FacadeAjax.getAlunoByIdentidadeDWR(identidade, {
        callback: function(aluno){
            dwr.util.setValues({
                txtIdTurma: $("select[name=txtTurma]").val(),
                txtAvlPsico: $("select[name=txtAvaliacao]").val(),
                txtIdentidadeAl: aluno.identidade,
                txtPGradAl: aluno.abreviaturaPostoGraduacao,
                txtNomeGuerraAl: aluno.nomeguerra,
                txtSitAvlPsico: '0',
                txtRtoAvlPsico: ""
            });
        }
    });
}       

functionValidSelectTReal("#txtSitAvlPsico");
$("#txtSitAvlPsico").change(function() {
    if($("#txtSitAvlPsico").val() === "2"){
        $("#div-rtoavlpsico").css("display", "block");        
    }
    else if($("#txtSitAvlPsico").val() === "0" || $("#txtSitAvlPsico").val() === "1" || $("#txtSitAvlPsico").val() === "3"){
        $("#div-rtoavlpsico").css("display", "none");

        $("input[name=txtRtoAvlPsico]").val('');
        $("input[name=txtRtoAvlPsico]").removeClass("is-invalid");
        $("input[name=txtRtoAvlPsico]").removeClass("is-valid");
    }
});

function tcm(identidade){
    FacadeAjax.getAlunoByIdentidadeDWR(identidade, {
        callback: function(aluno){
            dwr.util.setValues({
                txtIdTurmaTCM: $("select[name=txtTurma]").val(),
                txtAvlTCM: $("select[name=txtAvaliacao]").val(),
                txtIdentidadeAlTCM: aluno.identidade,
                txtPGradAlTCM: aluno.abreviaturaPostoGraduacao,
                txtNomeGuerraAlTCM: aluno.nomeguerra,
                txtTCMT: '',
                txtTCMP: ''
            });
        }
    });
}       

$("select[name=txtSexoEafTent1]").change(function() {
    if($("select[name=txtSexoEafTent1]").val() == "M"){
        $("#div-barra-fem").css("display", "none"); 
        $("input[name=txtSuspBarraEafTent1]").val('');
        $("input[name=txtSuspBarraEafTent1]").removeClass("is-invalid");
        $("input[name=txtSuspBarraEafTent1]").removeClass("is-valid");
        
        $("#div-barra-masc").css("display", "block");                
    }
    else if($("select[name=txtSexoEafTent1]").val() == "F"){
        $("#div-barra-masc").css("display", "none"); 
        $("input[name=txtFlexaoBarraEafTent1]").val('');
        $("input[name=txtFlexaoBarraEafTent1]").removeClass("is-invalid");
        $("input[name=txtFlexaoBarraEafTent1]").removeClass("is-valid");
        
        $("#div-barra-fem").css("display", "block");  
    }
});

function eafTent1(identidade){
    FacadeAjax.getAlunoByIdentidadeDWR(identidade, {
        callback: function(aluno){
            dwr.util.setValues({
                txtIdTurmaEafTent1: $("select[name=txtTurma]").val(),
                txtAvlEafTent1: $("select[name=txtAvaliacao]").val(),
                txtIdentidadeAlEafTent1: aluno.identidade,
                txtPGradAlEafTent1: aluno.abreviaturaPostoGraduacao,
                txtNomeGuerraAlEafTent1: aluno.nomeguerra
            });
        }
    });
}       

function eafTent2(identidade, situacao){
    FacadeAjax.getAlunoByIdentidadeDWR(identidade, {
        callback: function(aluno){
            dwr.util.setValues({
                txtIdTurmaEafTent2: $("select[name=txtTurma]").val(),
                txtAvlEafTent2: $("select[name=txtAvaliacao]").val(),
                txtIdentidadeAlEafTent2: aluno.identidade,
                txtPGradAlEafTent2: aluno.abreviaturaPostoGraduacao,
                txtNomeGuerraAlEafTent2: aluno.nomeguerra
            });
        }
    });
    
    $("#div-eaf-tent2-"+situacao).css("display", "block");
}       
        
function is(identidade){
    FacadeAjax.getAlunoByIdentidadeDWR(identidade, {
        callback: function(aluno){
            dwr.util.setValues({
                txtIdTurmaIS: $("select[name=txtTurma]").val(),
                txtIS: $("select[name=txtAvaliacao]").val(),
                txtIdentidadeAlIS: aluno.identidade,
                txtPGradAlIS: aluno.abreviaturaPostoGraduacao,
                txtNomeGuerraAlIS: aluno.nomeguerra
            });
        }
    });
}  
