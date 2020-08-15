//Ao carregar ou recarregar a página
$(document).ready(function(){
    limpaCampoSelect("select[name=txtCurso]");
    limpaCampoSelect("select[name=txtCategoria]");
    limpaCampoSelect("select[name=txtTurma]");
    limpaCampoSelect("select[name=txtAvaliacao]");
    
    //Campo Select Curso
    validSelect("select[name=txtCurso]");
    validSelectTReal("select[name=txtCurso]");
    
    //Campo Select Categoria
    validSelect("select[name=txtCategoria]");
    validSelectTReal("select[name=txtCategoria]");
    
    //Campo Select Turma
    validSelect("select[name=txtTurma]");
    validSelectTReal("select[name=txtTurma]");
    
    //Campo Select Avaliação
    validSelect("select[name=txtAvaliacao]");
    validSelectTReal("select[name=txtAvaliacao]");
    
});

$("select[name=txtCurso]").change(function(){
   limpaCampoSelect("select[name=txtCategoria]");
   limpaCampoSelect("select[name=txtTurma]");
});

$("select[name=txtCategoria]").change(function(){
   limpaCampoSelect("select[name=txtTurma]");
});

//Obrigatoriedade
$("button[name=btnPesquisar]").click(function(){
    if($("select[name=txtCurso]").val() == '0'){
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
    else if($("select[name=txtTurma]").val() == '0'){
        $("select[name=txtTurma]").removeClass("is-valid");
        $("select[name=txtTurma]").addClass("is-invalid");
        $("select[name=txtTurma]").focus();
        return false;
    }
    else if($("select[name=txtAvaliacao]").val() == '0'){
        $("select[name=txtAvaliacao]").removeClass("is-valid");
        $("select[name=txtAvaliacao]").addClass("is-invalid");
        $("select[name=txtAvaliacao]").focus();
        return false;
    }
    else{        
        var idTurma = $("#txtTurma").val();
        //Avaliação Psicológica
        if($("select[name=txtAvaliacao]").val() == 1){
            getAvlPsicoAlunosByTurma(idTurma);  
        }
        //Inspeção de Saúde
        else if($("select[name=txtAvaliacao]").val() == 2){
            getISAlunosByTurma(idTurma);  
        }
        //Teste de Conhecimento Militar
        else if($("select[name=txtAvaliacao]").val() == 3){
            getTcmsAlunosByTurma(idTurma);  
        }
        //Exame de Aptidão Física
        else if($("select[name=txtAvaliacao]").val() == 4){
            getEafAlunosByTurma(idTurma);  
        }
    }
});