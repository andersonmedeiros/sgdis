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

$("select[name=txtCurso").change(function(){
    montaSelectDependenteCurso(this.value);
});

$("select[name=txtCategoria").change(function(){
    var idCurso = $("select[name=txtCurso]").val();
    montaSelectDependenteCursoAndCategoria(idCurso, this.value);
});

function avlPsico(identidade){
    FacadeAjax.getAlunoByIdentidadeDWR(identidade, {
        callback: function(aluno){
            dwr.util.setValues({
                txtIdTurma: $("select[name=txtTurma]").val(),
                txtIdentidadeAl: aluno.identidade,
                txtPGradAl: aluno.abreviaturaPostoGraduacao,
                txtNomeGuerraAl: aluno.nomeguerra,
                txtSitAvlPsico: '0',
                txtRtoAvlPsico: ""
            });
        }
    });
}

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