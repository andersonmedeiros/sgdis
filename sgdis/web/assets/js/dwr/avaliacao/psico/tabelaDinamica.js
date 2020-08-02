var colunasCandidatos = [
    function(avls){ return avls.identidadeAluno;},
    function(avls){ return avls.abreviaturaPostoGraduacaoAluno + " " + avls.nomeguerraAluno;},
    function(avls){ 
        if(avls.situacao == ''){return "<b>NÃO REALIZADO</b>";} 
        else if(avls.situacao == '1'){return "<b style=\"color: #125e12;\">INDICADO</b>";} 
        else if(avls.situacao == '2'){return "<b style=\"color: #ffc107;\">INDICADO COM RESTRIÇÃO</b>";}
        else if(avls.situacao == '3'){return "<b style=\"color: red;\">INAPTO</b>";};},
    function(avls){ 
        if(avls.situacao == ''){return "<button type=\"button\" id="+avls.identidadeAluno+" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#modalFormAvlPsico\" value=\"AvlPsico\" onclick=\"avlPsico("+"'"+avls.identidadeAluno+"'"+");\">Avaliar</button>";}
        else{return "<b>AVALIADO!</b>";}}
];

function getAvlPsicoAlunosByTurma(idTurma){
    FacadeAjax.getAvlPsicoAlunosByTurmaDWR(idTurma, {
        callback:function(avls){ 
            dwr.util.removeAllRows("candidatos");
            dwr.util.addRows("candidatos", avls, colunasCandidatos, { escapeHtml: false });            
        }
    });
}