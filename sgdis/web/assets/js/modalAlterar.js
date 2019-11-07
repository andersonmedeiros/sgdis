/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function alterar_curso(id, nome, sigla, categoria, portaria, descricao){
    document.getElementById('txtIdAtt').value = id;
    document.getElementById('txtNomeAtt').value = nome;
    document.getElementById('txtSiglaAtt').value = sigla;
    document.getElementById('txtCategoriaAtt').value = categoria;
    document.getElementById('txtPortariaAtt').value = portaria;
    document.getElementById('txtDescricaoAtt').value = descricao;
}