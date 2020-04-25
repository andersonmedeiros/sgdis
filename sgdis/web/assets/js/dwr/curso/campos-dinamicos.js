/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function montaSelectCategoria(categorias){
    dwr.util.removeAllOptions("txtCategoria");
    dwr.util.addOptions("txtCategoria", [{id: "0", nome: "Selecione uma Categoria..."}], "id", "nome");
    dwr.util.addOptions("txtCategoria", categorias, "id", "nome");
    dwr.util.removeAllOptions("txtCategoriaAtt");
    dwr.util.addOptions("txtCategoriaAtt", [{id: "0", nome: "Selecione uma Categoria..."}], "id", "nome");
    dwr.util.addOptions("txtCategoriaAtt", categorias, "id", "nome");
}
FacadeAjax.getCategoriasDWR(montaSelectCategoria);

function alteraCurso(idCurso, idCategoria){
    FacadeAjax.getCursoDWR(idCurso, {
        callback: function(curso){
            dwr.util.setValues({
                txtIdAtt: curso.id,
                txtNomeAtt: curso.nome,
                txtSiglaAtt: curso.sigla,
                txtCategoriaAtt: idCategoria,
                txtPortariaAtt: curso.portaria,
                txtDescricaoAtt: curso.descricao
            });
        }
    });
}
