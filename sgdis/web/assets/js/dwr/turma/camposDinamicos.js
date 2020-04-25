/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var dataAtual = new Date();
var anoAtual = dataAtual.getFullYear();

for(var i=0; i<3; i++, anoAtual++){
    $("select[name=txtAno]").append("<option value='"+anoAtual+"'>"+anoAtual+"</option>");
}

function montaSelectCurso(listBeans){
    dwr.util.removeAllOptions("txtCurso");
    dwr.util.addOptions("txtCurso", [{id: "0", sigla: "Selecione um Curso..."}], "id", "sigla");
    dwr.util.addOptions("txtCurso", listBeans, "id", "sigla");
}
FacadeAjax.getCursosDWR(montaSelectCurso);
function montaSelectDependenteCurso(idCurso){
    FacadeAjax.getCategoriasByCursoDWR(idCurso, {
       callback: function(list){
           dwr.util.removeAllOptions("txtCategoria");
           dwr.util.addOptions("txtCategoria", [{id: "0", nome: "Selecione uma Categoria..."}], "id", "nome");
           dwr.util.addOptions("txtCategoria", list, "id", "nome");
       } 
    });
}

$("select[name=txtCurso").change(function(){
    montaSelectDependenteCurso(this.value);
});