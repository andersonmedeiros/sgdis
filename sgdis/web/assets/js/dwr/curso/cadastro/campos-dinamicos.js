/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function montaSelectCategoria(categorias){
    dwr.util.removeAllOptions("txtCategoria");
    dwr.util.addOptions("txtCategoria", [{id: "0", nome: "Selecione uma Categoria..."}], "id", "nome");
    dwr.util.addOptions("txtCategoria", categorias, "id", "nome");
}
FacadeAjax.getCategorias(montaSelectCategoria);
