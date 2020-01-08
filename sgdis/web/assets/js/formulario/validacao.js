/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
   var atual_fs, prox_fs, anterior_fs;
   var form = $("#formCadCandidato");
   
   
   function prox(elemento){
       atual_fs = $(elemento).parent();
       prox_fs = $(elemento).parent().next();
       
       $('#progress li').eq($('fieldset').index(prox_fs)).addClass('ativo');
       atual_fs.hide(800);
       prox_fs.show(800);
        
   }
   
   $('.anterior').click(function(){
       atual_fs = $(this).parent();
       anterior_fs = $(this).parent().prev();
       $('#progress li').eq($('fieldset').index(atual_fs)).removeClass('ativo');
       atual_fs.hide(800);
       anterior_fs.show(800);
        
   });
   
   $('#formCadCandidato button[type=button]').click(function(){
      return false; 
   });
   
   $("#btnProximo2").click(function(){
       //var array = form.serializeArray();
       
        if($("select[name=txtForca]").val() == '0'){
            $("select[name=txtForca]").removeClass("is-valid");
            $("select[name=txtForca]").addClass("is-invalid");
            $("select[name=txtForca]").focus();
        }
        else if($("input[name=txtGCmdo]").val() == ''){
            $("input[name=txtGCmdo]").removeClass("is-valid");
            $("input[name=txtGCmdo]").addClass("is-invalid");
            $("input[name=txtGCmdo]").focus();
        }
        else if($("input[name=txtEscEnq]").val() == ''){
            $("input[name=txtEscEnq]").removeClass("is-valid");
            $("input[name=txtEscEnq]").addClass("is-invalid");
            $("input[name=txtEscEnq]").focus();
        }
        //Organização Militar - OM
        else if($("input[name=txtNomeOM]").val() == ''){
            $("input[name=txtNomeOM]").removeClass("is-valid");
            $("input[name=txtNomeOM]").addClass("is-invalid");
            $("input[name=txtNomeOM]").focus();
        }
        else if($("input[name=txtAbrevOM]").val() == ''){
            $("input[name=txtAbrevOM]").removeClass("is-valid");
            $("input[name=txtAbrevOM]").addClass("is-invalid");
            $("input[name=txtAbrevOM]").focus();
        }
        else if($("input[name=txtFoneOM]").val() == ''){
            $("input[name=txtFoneOM]").removeClass("is-valid");
            $("input[name=txtFoneOM]").addClass("is-invalid");
            $("input[name=txtFoneOM]").focus();
        }
        //Comandante
        else if($("select[name=txtPGradCmtOM]").val() == '0'){
            $("select[name=txtPGradCmtOM]").removeClass("is-valid");
            $("select[name=txtPGradCmtOM]").addClass("is-invalid");
            $("select[name=txtPGradCmtOM]").focus();
        }
        else if($("input[name=txtNomeCmtOM]").val() == ''){
            $("input[name=txtNomeCmtOM]").removeClass("is-valid");
            $("input[name=txtNomeCmtOM]").addClass("is-invalid");
            $("input[name=txtNomeCmtOM]").focus();
        }
        else if($("input[name=txtSobrenomeCmtOM]").val() == ''){
            $("input[name=txtSobrenomeCmtOM]").removeClass("is-valid");
            $("input[name=txtSobrenomeCmtOM]").addClass("is-invalid");
            $("input[name=txtSobrenomeCmtOM]").focus();
        }
        else if($("input[name=txtNomeGuerraCmtOM]").val() == ''){
            $("input[name=txtNomeGuerraCmtOM]").removeClass("is-valid");
            $("input[name=txtNomeGuerraCmtOM]").addClass("is-invalid");
            $("input[name=txtNomeGuerraCmtOM]").focus();
        }
        //Chefe Imediato
        else if($("select[name=txtPGradChImtoOM]").val() == '0'){
            $("select[name=txtPGradChImtoOM]").removeClass("is-valid");
            $("select[name=txtPGradChImtoOM]").addClass("is-invalid");
            $("select[name=txtPGradChImtoOM]").focus();
        }
        else if($("input[name=txtNomeChImtoOM]").val() == ''){
            $("input[name=txtNomeChImtoOM]").removeClass("is-valid");
            $("input[name=txtNomeChImtoOM]").addClass("is-invalid");
            $("input[name=txtNomeChImtoOM]").focus();
        }
        else if($("input[name=txtSobrenomeChImtoOM]").val() == ''){
            $("input[name=txtSobrenomeChImtoOM]").removeClass("is-valid");
            $("input[name=txtSobrenomeChImtoOM]").addClass("is-invalid");
            $("input[name=txtSobrenomeChImtoOM]").focus();
        }
        else if($("input[name=txtNomeGuerraChImtoOM]").val() == ''){
            $("input[name=txtNomeGuerraChImtoOM]").removeClass("is-valid");
            $("input[name=txtNomeGuerraChImtoOM]").addClass("is-invalid");
            $("input[name=txtNomeGuerraChImtoOM]").focus();
        }
        //Endereço da OM
        else if($("input[name=txtEndCepOM]").val() == ''){
            $("input[name=txtEndCepOM]").removeClass("is-valid");
            $("input[name=txtEndCepOM]").addClass("is-invalid");
            $("input[name=txtEndCepOM]").focus();
        }
        else if($("select[name=txtEndLogOM]").val() == '0'){
            $("select[name=txtEndLogOM]").removeClass("is-valid");
            $("select[name=txtEndLogOM]").addClass("is-invalid");
            $("select[name=txtEndLogOM]").focus();
        }
        else if($("input[name=txtEndNomeOM]").val() == ''){
            $("input[name=txtEndNomeOM]").removeClass("is-valid");
            $("input[name=txtEndNomeOM]").addClass("is-invalid");
            $("input[name=txtEndNomeOM]").focus();
        }
        else if($("input[name=txtEndNumOM]").val() == ''){
            $("input[name=txtEndNumOM]").removeClass("is-valid");
            $("input[name=txtEndNumOM]").addClass("is-invalid");
            $("input[name=txtEndNumOM]").focus();
        }
        else if($("select[name=txtEndPaisOM]").val() == '0'){
            $("select[name=txtEndPaisOM]").removeClass("is-valid");
            $("select[name=txtEndPaisOM]").addClass("is-invalid");
            $("select[name=txtEndPaisOM]").focus();
        }
        else if($("select[name=txtEndEstadoOM]").val() == '0'){
            $("select[name=txtEndEstadoOM]").removeClass("is-valid");
            $("select[name=txtEndEstadoOM]").addClass("is-invalid");
            $("select[name=txtEndEstadoOM]").focus();
        }
        else if($("select[name=txtEndCidadeOM]").val() == '0'){
            $("select[name=txtEndCidadeOM]").removeClass("is-valid");
            $("select[name=txtEndCidadeOM]").addClass("is-invalid");
            $("select[name=txtEndCidadeOM]").focus();
        }
        else if($("select[name=txtEndBairroOM]").val() == '0'){
            $("select[name=txtEndBairroOM]").removeClass("is-valid");
            $("select[name=txtEndBairroOM]").addClass("is-invalid");
            $("select[name=txtEndBairroOM]").focus();
        }
        
        //Próxima Etapa
        else{
            prox($(this));
        }
       
       /*if(array[0].value == '0'){
           $("#txtForca").addClass("is-invalid");
       }else{
           prox($(this));
       }*/
   });
   
   //Validação ao mudar o valor dos campos
   //Etapa 1: OM ATUAL
   //Campo Select Força
   $("select[name=txtForca]").blur(function(){
        if($("select[name=txtForca]").val() != '0'){
            $("select[name=txtForca]").removeClass("is-invalid");
            $("select[name=txtForca]").addClass("is-valid");
        }else{
            $("select[name=txtForca]").removeClass("is-valid");
            $("select[name=txtForca]").addClass("is-invalid");
        }
   });
   
   //Campo Input Grande Comando
   $("input[name=txtGCmdo]").blur(function(){
        if($("input[name=txtGCmdo]").val() != ''){
            $("input[name=txtGCmdo]").removeClass("is-invalid");
            $("input[name=txtGCmdo]").addClass("is-valid");
        }else{
            $("input[name=txtGCmdo]").removeClass("is-valid");
            $("input[name=txtGCmdo]").addClass("is-invalid");
        }
   });
   
   //Campo Input Escalão Ennquadrante
   $("input[name=txtEscEnq]").blur(function(){
        if($("input[name=txtEscEnq]").val() != ''){
            $("input[name=txtEscEnq]").removeClass("is-invalid");
            $("input[name=txtEscEnq]").addClass("is-valid");
        }else{
            $("input[name=txtEscEnq]").removeClass("is-valid");
            $("input[name=txtEscEnq]").addClass("is-invalid");
        }
   });
  
   //Campo Input Nome OM
   $("input[name=txtNomeOM]").blur(function(){
        if($("input[name=txtNomeOM]").val() != ''){
            $("input[name=txtNomeOM]").removeClass("is-invalid");
            $("input[name=txtNomeOM]").addClass("is-valid");
        }else{
            $("input[name=txtNomeOM]").removeClass("is-valid");
            $("input[name=txtNomeOM]").addClass("is-invalid");
        }
   }); 
  
   //Campo Input Abreviatura OM
   $("input[name=txtAbrevOM]").blur(function(){
        if($("input[name=txtAbrevOM]").val() != ''){
            $("input[name=txtAbrevOM]").removeClass("is-invalid");
            $("input[name=txtAbrevOM]").addClass("is-valid");
        }else{
            $("input[name=txtAbrevOM]").removeClass("is-valid");
            $("input[name=txtAbrevOM]").addClass("is-invalid");
        }
   }); 
  
   //Campo Input Fone
   $("input[name=txtFoneOM]").blur(function(){
        if($("input[name=txtFoneOM]").val() != ''){
            $("input[name=txtFoneOM]").removeClass("is-invalid");
            $("input[name=txtFoneOM]").addClass("is-valid");
        }else{
            $("input[name=txtFoneOM]").removeClass("is-valid");
            $("input[name=txtFoneOM]").addClass("is-invalid");
        }
   }); 
  
   //Campo Select Posto/Graduação Cmt OM
   $("select[name=txtPGradCmtOM]").blur(function(){
        if($("select[name=txtPGradCmtOM]").val() != '0'){
            $("select[name=txtPGradCmtOM]").removeClass("is-invalid");
            $("select[name=txtPGradCmtOM]").addClass("is-valid");
        }else{
            $("select[name=txtPGradCmtOM]").removeClass("is-valid");
            $("select[name=txtPGradCmtOM]").addClass("is-invalid");
        }
   }); 
  
   //Campo Input Nome Cmt OM
   $("input[name=txtNomeCmtOM]").blur(function(){
        if($("input[name=txtNomeCmtOM]").val() != ''){
            $("input[name=txtNomeCmtOM]").removeClass("is-invalid");
            $("input[name=txtNomeCmtOM]").addClass("is-valid");
        }else{
            $("input[name=txtNomeCmtOM]").removeClass("is-valid");
            $("input[name=txtNomeCmtOM]").addClass("is-invalid");
        }
   }); 
  
   //Campo Input Sobrenome Cmt OM
   $("input[name=txtSobrenomeCmtOM]").blur(function(){
        if($("input[name=txtSobrenomeCmtOM]").val() != ''){
            $("input[name=txtSobrenomeCmtOM]").removeClass("is-invalid");
            $("input[name=txtSobrenomeCmtOM]").addClass("is-valid");
        }else{
            $("input[name=txtSobrenomeCmtOM]").removeClass("is-valid");
            $("input[name=txtSobrenomeCmtOM]").addClass("is-invalid");
        }
   }); 
  
   //Campo Input Nome de Guerra Cmt OM
   $("input[name=txtNomeGuerraCmtOM]").blur(function(){
        if($("input[name=txtNomeGuerraCmtOM]").val() != ''){
            $("input[name=txtNomeGuerraCmtOM]").removeClass("is-invalid");
            $("input[name=txtNomeGuerraCmtOM]").addClass("is-valid");
        }else{
            $("input[name=txtNomeGuerraCmtOM]").removeClass("is-valid");
            $("input[name=txtNomeGuerraCmtOM]").addClass("is-invalid");
        }
   }); 
  
   //Campo Select Posto/Graduação Ch Imediato
   $("select[name=txtPGradChImtoOM]").blur(function(){
        if($("select[name=txtPGradChImtoOM]").val() != '0'){
            $("select[name=txtPGradChImtoOM]").removeClass("is-invalid");
            $("select[name=txtPGradChImtoOM]").addClass("is-valid");
        }else{
            $("select[name=txtPGradChImtoOM]").removeClass("is-valid");
            $("select[name=txtPGradChImtoOM]").addClass("is-invalid");
        }
   }); 
  
   //Campo Input Nome Ch Imediato
   $("input[name=txtNomeChImtoOM]").blur(function(){
        if($("input[name=txtNomeChImtoOM]").val() != ''){
            $("input[name=txtNomeChImtoOM]").removeClass("is-invalid");
            $("input[name=txtNomeChImtoOM]").addClass("is-valid");
        }else{
            $("input[name=txtNomeChImtoOM]").removeClass("is-valid");
            $("input[name=txtNomeChImtoOM]").addClass("is-invalid");
        }
   }); 
  
   //Campo Input Sobrenome Ch Imediato
   $("input[name=txtSobrenomeChImtoOM]").blur(function(){
        if($("input[name=txtSobrenomeChImtoOM]").val() != ''){
            $("input[name=txtSobrenomeChImtoOM]").removeClass("is-invalid");
            $("input[name=txtSobrenomeChImtoOM]").addClass("is-valid");
        }else{
            $("input[name=txtSobrenomeChImtoOM]").removeClass("is-valid");
            $("input[name=txtSobrenomeChImtoOM]").addClass("is-invalid");
        }
   }); 
  
   //Campo Input Nome de Guerra Ch Imediato
   $("input[name=txtNomeGuerraChImtoOM]").blur(function(){
        if($("input[name=txtNomeGuerraChImtoOM]").val() != ''){
            $("input[name=txtNomeGuerraChImtoOM]").removeClass("is-invalid");
            $("input[name=txtNomeGuerraChImtoOM]").addClass("is-valid");
        }else{
            $("input[name=txtNomeGuerraChImtoOM]").removeClass("is-valid");
            $("input[name=txtNomeGuerraChImtoOM]").addClass("is-invalid");
        }
   });   
  
   //Campo Input CEP
   $("input[name=txtEndCepOM]").blur(function(){
        if($("input[name=txtEndCepOM]").val() != ''){
            $("input[name=txtEndCepOM]").removeClass("is-invalid");
            $("input[name=txtEndCepOM]").addClass("is-valid");
        }else{
            $("input[name=txtEndCepOM]").removeClass("is-valid");
            $("input[name=txtEndCepOM]").addClass("is-invalid");
        }
   });   
     
   //Campo Select Logradouro
   $("select[name=txtEndLogOM]").blur(function(){
        if($("select[name=txtEndLogOM]").val() != '0'){
            $("select[name=txtEndLogOM]").removeClass("is-invalid");
            $("select[name=txtEndLogOM]").addClass("is-valid");
        }else{
            $("select[name=txtEndLogOM]").removeClass("is-valid");
            $("select[name=txtEndLogOM]").addClass("is-invalid");
        }
   });    
     
   //Campo Input Endereço
   $("input[name=txtEndNomeOM]").blur(function(){
        if($("input[name=txtEndNomeOM]").val() != ''){
            $("input[name=txtEndNomeOM]").removeClass("is-invalid");
            $("input[name=txtEndNomeOM]").addClass("is-valid");
        }else{
            $("input[name=txtEndNomeOM]").removeClass("is-valid");
            $("input[name=txtEndNomeOM]").addClass("is-invalid");
        }
   });   
     
   //Campo Input Número
   $("input[name=txtEndNumOM]").blur(function(){
        if($("input[name=txtEndNumOM]").val() != ''){
            $("input[name=txtEndNumOM]").removeClass("is-invalid");
            $("input[name=txtEndNumOM]").addClass("is-valid");
        }else{
            $("input[name=txtEndNumOM]").removeClass("is-valid");
            $("input[name=txtEndNumOM]").addClass("is-invalid");
        }
   });
        
   //Campo Select País
   $("select[name=txtEndPaisOM]").blur(function(){
        if($("select[name=txtEndPaisOM]").val() != '0'){
            $("select[name=txtEndPaisOM]").removeClass("is-invalid");
            $("select[name=txtEndPaisOM]").addClass("is-valid");
        }else{
            $("select[name=txtEndPaisOM]").removeClass("is-valid");
            $("select[name=txtEndPaisOM]").addClass("is-invalid");
        }
   });
        
   //Campo Select Estado
   $("select[name=txtEndEstadoOM]").blur(function(){
        if($("select[name=txtEndEstadoOM]").val() != '0'){
            $("select[name=txtEndEstadoOM]").removeClass("is-invalid");
            $("select[name=txtEndEstadoOM]").addClass("is-valid");
        }else{
            $("select[name=txtEndEstadoOM]").removeClass("is-valid");
            $("select[name=txtEndEstadoOM]").addClass("is-invalid");
        }
   });
        
   //Campo Select Cidade
   $("select[name=txtEndCidadeOM]").blur(function(){
        if($("select[name=txtEndCidadeOM]").val() != '0'){
            $("select[name=txtEndCidadeOM]").removeClass("is-invalid");
            $("select[name=txtEndCidadeOM]").addClass("is-valid");
        }else{
            $("select[name=txtEndCidadeOM]").removeClass("is-valid");
            $("select[name=txtEndCidadeOM]").addClass("is-invalid");
        }
   });
        
   //Campo Select Bairro
   $("select[name=txtEndBairroOM]").blur(function(){
        if($("select[name=txtEndBairroOM]").val() != '0'){
            $("select[name=txtEndBairroOM]").removeClass("is-invalid");
            $("select[name=txtEndBairroOM]").addClass("is-valid");
        }else{
            $("select[name=txtEndBairroOM]").removeClass("is-valid");
            $("select[name=txtEndBairroOM]").addClass("is-invalid");
        }
   });
});

