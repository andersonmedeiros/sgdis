$("select[name=txtAvaliacao]").change(function(){
    dwr.util.removeAllRows("candidatos");
    var avl = $("select[name=txtAvaliacao]").val();
    if(avl == 0){
        $("#avl>thead>tr>th").remove();
    }
    else if(avl == 1){
        $("#avl>thead>tr>th").remove();
        $("#avl>thead>tr").append("<th>IDENTIDADE</th>");
        $("#avl>thead>tr").append("<th>MILITAR</th>");
        $("#avl>thead>tr").append("<th>AVALIAÇÃO</th>");
        $("#avl>thead>tr").append("<th>AÇÃO</th>");
    }
    else if(avl == 2){
        $("#avl>thead>tr>th").remove();
        $("#avl>thead>tr").append("<th>IDENTIDADE</th>");
        $("#avl>thead>tr").append("<th>MILITAR</th>");
        $("#avl>thead>tr").append("<th>AVALIAÇÃO</th>");
        $("#avl>thead>tr").append("<th>AÇÃO</th>");
    }
    else if(avl == 3){
        $("#avl>thead>tr>th").remove();
        $("#avl>thead>tr").append("<th>IDENTIDADE</th>");
        $("#avl>thead>tr").append("<th>MILITAR</th>");
        $("#avl>thead>tr").append("<th>TCMT</th>");
        $("#avl>thead>tr").append("<th>TCMP</th>");
        $("#avl>thead>tr").append("<th>AÇÃO</th>");
    }
    else if(avl == 4){
        $("#avl>thead>tr>th").remove();
        $("#avl>thead>tr").append("<th>IDENTIDADE</th>");
        $("#avl>thead>tr").append("<th>MILITAR</th>");
        $("#avl>thead>tr").append("<th>1ª TENTATIVA</th>");
        $("#avl>thead>tr").append("<th>2ª TENTATIVA</th>");
        $("#avl>thead>tr").append("<th>AÇÃO</th>");
    }
});

var colunasCandidatosAvlPsico = [
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
            dwr.util.addRows("candidatos", avls, colunasCandidatosAvlPsico, { escapeHtml: false });            
        }
    });
    $("#div-btn-pdf").css("display", "block");
}

var colunasCandidatosTCM = [
    function(tcms){ return tcms.identidadeAluno;},
    function(tcms){ return tcms.abreviaturaPostoGraduacaoAluno + " " + tcms.nomeguerraAluno;},
    function(tcms){ 
        if(tcms.tcmt == ''){return "<b>NÃO REALIZADO</b>";}
        else if(tcms.tcmt < 5){
            return "<b style=\"color: red;\">"+ tcms.tcmt +" (REPROVADO)</b>";
        }else{
            return "<b style=\"color: #125e12;\">"+ tcms.tcmt +" (APROVADO)</b>";
        }        
    },
    function(tcms){ 
        if(tcms.tcmp == ''){return "<b>NÃO REALIZADO</b>";}
        else if(tcms.tcmp < 5){
            return "<b style=\"color: red;\">"+ tcms.tcmp +" (REPROVADO)</b>";
        }else{
            return "<b style=\"color: #125e12;\">"+ tcms.tcmp +" (APROVADO)</b>";
        }
    },
    function(tcms){ 
        if(tcms.tcmt == '' && tcms.tcmp == ''){return "<button type=\"button\" id="+tcms.identidadeAluno+" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#modalFormTCM\" value=\"Tcm\" onclick=\"tcm("+"'"+tcms.identidadeAluno+"'"+");\">Lançar</button>";}
        else{return "<b>AVALIADO!</b>";}}
];

function getTcmsAlunosByTurma(idTurma){
    FacadeAjax.getTcmsAlunosByTurmaDWR(idTurma, {
        callback:function(tcms){ 
            dwr.util.removeAllRows("candidatos");
            dwr.util.addRows("candidatos", tcms, colunasCandidatosTCM, { escapeHtml: false });            
        }
    });
    $("#div-btn-pdf").css("display", "block");
}

var colunasCandidatosEaf = [
    function(eafs){ return eafs.identidadeAluno;},
    function(eafs){ return eafs.abreviaturaPostoGraduacaoAluno + " " + eafs.nomeguerraAluno;},
    //1ª Tentativa
    function(eafs){ 
        if(eafs.situacao == ''){return "<b>NÃO REALIZADO</b>";}
        else if(eafs.situacao == 1){
            return "<b style=\"color: #125e12;\">APTO</b>";
        }
        else if(eafs.situacao == 2){
            return "<b style=\"color: red;\">INAPTO</b>";
        }else if(eafs.situacao >= 10){
            return "<b style=\"color: #ffc107;\">INAPTO</b>";
        }        
    },
    //2ª Tentativa
    function(eafs){
        if(eafs.situacaoRec == ''){return "-";}
        else if(eafs.situacaoRec == 1){
            return "<b style=\"color: #125e12;\">APTO</b>";
        }else if(eafs.situacaoRec == 2){
            return "<b style=\"color: red;\">INAPTO</b>";
        }
    },
    function(eafs){ 
        if(eafs.situacao == ''){
            return "<button type=\"button\" id="+eafs.identidadeAluno+" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#modalFormEafTent1\" value=\"EafTent1\" onclick=\"eafTent1("+"'"+eafs.identidadeAluno+"'"+");\">Lançar 1ª Tentativa</button>";
        }else if(eafs.situacao == 1){
            return "<b>AVALIADO!</b>";
        }else if(eafs.situacao == 2){
            return "<b>AVALIADO!</b>";
        }else if(eafs.situacao >= 10 && eafs.situacaoRec == ''){
            return "<button type=\"button\" id="+eafs.identidadeAluno+" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#modalFormEafTent2\" value=\"EafTent2\" onclick=\"eafTent2("+"'"+eafs.identidadeAluno+"'"+","+"'"+eafs.situacao+"'"+");\">Lançar 2ª Tentativa</button>";
        }else if(eafs.situacao >= 10 && eafs.situacaoRec != ''){
            return "<b>AVALIADO!</b>";
        }
    }
];

function getEafAlunosByTurma(idTurma){
    FacadeAjax.getEafsAlunosByTurmaDWR(idTurma, {
        callback:function(eafs){ 
            dwr.util.removeAllRows("candidatos");
            dwr.util.addRows("candidatos", eafs, colunasCandidatosEaf, { escapeHtml: false });            
        }
    });
    $("#div-btn-pdf").css("display", "block");
}

var colunasCandidatosIS = [
    function(eafs){ return eafs.identidadeAluno;},
    function(eafs){ return eafs.abreviaturaPostoGraduacaoAluno + " " + eafs.nomeguerraAluno;},
    function(eafs){ 
        if(eafs.situacao == ''){return "<b>NÃO REALIZADO</b>";}
        else if(eafs.situacao == 1){
            return "<b style=\"color: #125e12;\">APTO</b>";
        }
        else if(eafs.situacao == 2){
            return "<b style=\"color: red;\">INAPTO</b>";
        }      
    },
    function(eafs){ 
        if(eafs.situacao == ''){
            return "<button type=\"button\" id="+eafs.identidadeAluno+" class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#modalFormIS\" value=\"IS\" onclick=\"is("+"'"+eafs.identidadeAluno+"'"+");\">Lançar</button>";
        }else if(eafs.situacao == 1){
            return "<b>AVALIADO!</b>";
        }else if(eafs.situacao == 2){
            return "<b>AVALIADO!</b>";
        }
    }
];

function getISAlunosByTurma(idTurma){
    FacadeAjax.getISAlunosByTurmaDWR(idTurma, {
        callback:function(eafs){ 
            dwr.util.removeAllRows("candidatos");
            dwr.util.addRows("candidatos", eafs, colunasCandidatosIS, { escapeHtml: false });            
        }
    });
    $("#div-btn-pdf").css("display", "block");
}
