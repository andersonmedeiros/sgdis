/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    //Validação ao mudar o valor dos campos
    //Etapa 1: OM ATUAL
    //Campo Select Força
    $("select[name=txtForca]").change(function(){
         if($("select[name=txtForca]").val() != '0'){
             $("select[name=txtForca]").removeClass("is-invalid");
             $("select[name=txtForca]").addClass("is-valid");
         }else{
             $("select[name=txtForca]").removeClass("is-valid");
             $("select[name=txtForca]").addClass("is-invalid");
         }
    });

    //Campo Input Grande Comando
    $("input[name=txtGCmdo]").change(function(){
         if($("input[name=txtGCmdo]").val() != ''){
             $("input[name=txtGCmdo]").removeClass("is-invalid");
             $("input[name=txtGCmdo]").addClass("is-valid");
         }else{
             $("input[name=txtGCmdo]").removeClass("is-valid");
             $("input[name=txtGCmdo]").addClass("is-invalid");
         }
    });

    //Campo Input Escalão Ennquadrante
    $("input[name=txtEscEnq]").change(function(){
         if($("input[name=txtEscEnq]").val() != ''){
             $("input[name=txtEscEnq]").removeClass("is-invalid");
             $("input[name=txtEscEnq]").addClass("is-valid");
         }else{
             $("input[name=txtEscEnq]").removeClass("is-valid");
             $("input[name=txtEscEnq]").addClass("is-invalid");
         }
    });

    //Campo Input Nome OM
    $("input[name=txtNomeOM]").change(function(){
         if($("input[name=txtNomeOM]").val() != ''){
             $("input[name=txtNomeOM]").removeClass("is-invalid");
             $("input[name=txtNomeOM]").addClass("is-valid");
         }else{
             $("input[name=txtNomeOM]").removeClass("is-valid");
             $("input[name=txtNomeOM]").addClass("is-invalid");
         }
    }); 

    //Campo Input Abreviatura OM
    $("input[name=txtAbrevOM]").change(function(){
         if($("input[name=txtAbrevOM]").val() != ''){
             $("input[name=txtAbrevOM]").removeClass("is-invalid");
             $("input[name=txtAbrevOM]").addClass("is-valid");
         }else{
             $("input[name=txtAbrevOM]").removeClass("is-valid");
             $("input[name=txtAbrevOM]").addClass("is-invalid");
         }
    }); 

    //Campo Input Fone
    $("input[name=txtFoneOM]").change(function(){
         if($("input[name=txtFoneOM]").val() != ''){
             $("input[name=txtFoneOM]").removeClass("is-invalid");
             $("input[name=txtFoneOM]").addClass("is-valid");
         }else{
             $("input[name=txtFoneOM]").removeClass("is-valid");
             $("input[name=txtFoneOM]").addClass("is-invalid");
         }
    }); 

    //Campo Select Posto/Graduação Cmt OM
    $("select[name=txtPGradCmtOM]").change(function(){
         if($("select[name=txtPGradCmtOM]").val() != '0'){
             $("select[name=txtPGradCmtOM]").removeClass("is-invalid");
             $("select[name=txtPGradCmtOM]").addClass("is-valid");
         }else{
             $("select[name=txtPGradCmtOM]").removeClass("is-valid");
             $("select[name=txtPGradCmtOM]").addClass("is-invalid");
         }
    }); 

    //Campo Input Nome Cmt OM
    $("input[name=txtNomeCmtOM]").change(function(){
         if($("input[name=txtNomeCmtOM]").val() != ''){
             $("input[name=txtNomeCmtOM]").removeClass("is-invalid");
             $("input[name=txtNomeCmtOM]").addClass("is-valid");
         }else{
             $("input[name=txtNomeCmtOM]").removeClass("is-valid");
             $("input[name=txtNomeCmtOM]").addClass("is-invalid");
         }
    }); 

    //Campo Input Sobrenome Cmt OM
    $("input[name=txtSobrenomeCmtOM]").change(function(){
         if($("input[name=txtSobrenomeCmtOM]").val() != ''){
             $("input[name=txtSobrenomeCmtOM]").removeClass("is-invalid");
             $("input[name=txtSobrenomeCmtOM]").addClass("is-valid");
         }else{
             $("input[name=txtSobrenomeCmtOM]").removeClass("is-valid");
             $("input[name=txtSobrenomeCmtOM]").addClass("is-invalid");
         }
    }); 

    //Campo Input Nome de Guerra Cmt OM
    $("input[name=txtNomeGuerraCmtOM]").change(function(){
         if($("input[name=txtNomeGuerraCmtOM]").val() != ''){
             $("input[name=txtNomeGuerraCmtOM]").removeClass("is-invalid");
             $("input[name=txtNomeGuerraCmtOM]").addClass("is-valid");
         }else{
             $("input[name=txtNomeGuerraCmtOM]").removeClass("is-valid");
             $("input[name=txtNomeGuerraCmtOM]").addClass("is-invalid");
         }
    }); 

    //Campo Select Posto/Graduação Ch Imediato
    $("select[name=txtPGradChImtoOM]").change(function(){
         if($("select[name=txtPGradChImtoOM]").val() != '0'){
             $("select[name=txtPGradChImtoOM]").removeClass("is-invalid");
             $("select[name=txtPGradChImtoOM]").addClass("is-valid");
         }else{
             $("select[name=txtPGradChImtoOM]").removeClass("is-valid");
             $("select[name=txtPGradChImtoOM]").addClass("is-invalid");
         }
    }); 

    //Campo Input Nome Ch Imediato
    $("input[name=txtNomeChImtoOM]").change(function(){
         if($("input[name=txtNomeChImtoOM]").val() != ''){
             $("input[name=txtNomeChImtoOM]").removeClass("is-invalid");
             $("input[name=txtNomeChImtoOM]").addClass("is-valid");
         }else{
             $("input[name=txtNomeChImtoOM]").removeClass("is-valid");
             $("input[name=txtNomeChImtoOM]").addClass("is-invalid");
         }
    }); 

    //Campo Input Sobrenome Ch Imediato
    $("input[name=txtSobrenomeChImtoOM]").change(function(){
         if($("input[name=txtSobrenomeChImtoOM]").val() != ''){
             $("input[name=txtSobrenomeChImtoOM]").removeClass("is-invalid");
             $("input[name=txtSobrenomeChImtoOM]").addClass("is-valid");
         }else{
             $("input[name=txtSobrenomeChImtoOM]").removeClass("is-valid");
             $("input[name=txtSobrenomeChImtoOM]").addClass("is-invalid");
         }
    }); 

    //Campo Input Nome de Guerra Ch Imediato
    $("input[name=txtNomeGuerraChImtoOM]").change(function(){
         if($("input[name=txtNomeGuerraChImtoOM]").val() != ''){
             $("input[name=txtNomeGuerraChImtoOM]").removeClass("is-invalid");
             $("input[name=txtNomeGuerraChImtoOM]").addClass("is-valid");
         }else{
             $("input[name=txtNomeGuerraChImtoOM]").removeClass("is-valid");
             $("input[name=txtNomeGuerraChImtoOM]").addClass("is-invalid");
         }
    });   

    //Campo Input CEP
    $("input[name=txtEndCepOM]").change(function(){
         if($("input[name=txtEndCepOM]").val() != ''){
             $("input[name=txtEndCepOM]").removeClass("is-invalid");
             $("input[name=txtEndCepOM]").addClass("is-valid");
         }else{
             $("input[name=txtEndCepOM]").removeClass("is-valid");
             $("input[name=txtEndCepOM]").addClass("is-invalid");
         }
    });   

    //Campo Select Logradouro
    $("select[name=txtEndLogOM]").change(function(){
         if($("select[name=txtEndLogOM]").val() != '0'){
             $("select[name=txtEndLogOM]").removeClass("is-invalid");
             $("select[name=txtEndLogOM]").addClass("is-valid");
         }else{
             $("select[name=txtEndLogOM]").removeClass("is-valid");
             $("select[name=txtEndLogOM]").addClass("is-invalid");
         }
    });    

    //Campo Input Endereço
    $("input[name=txtEndNomeOM]").change(function(){
         if($("input[name=txtEndNomeOM]").val() != ''){
             $("input[name=txtEndNomeOM]").removeClass("is-invalid");
             $("input[name=txtEndNomeOM]").addClass("is-valid");
         }else{
             $("input[name=txtEndNomeOM]").removeClass("is-valid");
             $("input[name=txtEndNomeOM]").addClass("is-invalid");
         }
    });   

    //Campo Input Número
    $("input[name=txtEndNumOM]").change(function(){
         if($("input[name=txtEndNumOM]").val() != ''){
             $("input[name=txtEndNumOM]").removeClass("is-invalid");
             $("input[name=txtEndNumOM]").addClass("is-valid");
         }else{
             $("input[name=txtEndNumOM]").removeClass("is-valid");
             $("input[name=txtEndNumOM]").addClass("is-invalid");
         }
    });

    //Campo Select País
    $("select[name=txtEndPaisOM]").change(function(){
         if($("select[name=txtEndPaisOM]").val() != '0'){
             $("select[name=txtEndPaisOM]").removeClass("is-invalid");
             $("select[name=txtEndPaisOM]").addClass("is-valid");
         }else{
             $("select[name=txtEndPaisOM]").removeClass("is-valid");
             $("select[name=txtEndPaisOM]").addClass("is-invalid");
         }
    });

    //Campo Select Estado
    $("select[name=txtEndEstadoOM]").change(function(){
         if($("select[name=txtEndEstadoOM]").val() != '0'){
             $("select[name=txtEndEstadoOM]").removeClass("is-invalid");
             $("select[name=txtEndEstadoOM]").addClass("is-valid");
         }else{
             $("select[name=txtEndEstadoOM]").removeClass("is-valid");
             $("select[name=txtEndEstadoOM]").addClass("is-invalid");
         }
    });

    //Campo Select Cidade
    $("select[name=txtEndCidadeOM]").change(function(){
         if($("select[name=txtEndCidadeOM]").val() != '0'){
             $("select[name=txtEndCidadeOM]").removeClass("is-invalid");
             $("select[name=txtEndCidadeOM]").addClass("is-valid");
         }else{
             $("select[name=txtEndCidadeOM]").removeClass("is-valid");
             $("select[name=txtEndCidadeOM]").addClass("is-invalid");
         }
    });

    //Campo Select Bairro
    $("select[name=txtEndBairroOM]").change(function(){
         if($("select[name=txtEndBairroOM]").val() != '0'){
             $("select[name=txtEndBairroOM]").removeClass("is-invalid");
             $("select[name=txtEndBairroOM]").addClass("is-valid");
         }else{
             $("select[name=txtEndBairroOM]").removeClass("is-valid");
             $("select[name=txtEndBairroOM]").addClass("is-invalid");
         }
    });

    //Validação ao mudar o valor dos campos
    //Etapa 2: DADOS INDIVIDUAIS
    //Campo Select Posto/Graduação
    $("select[name=txtPGradAl]").change(function(){
         if($("select[name=txtPGradAl]").val() != '0'){
             $("select[name=txtPGradAl]").removeClass("is-invalid");
             $("select[name=txtPGradAl]").addClass("is-valid");
         }else{
             $("select[name=txtPGradAl]").removeClass("is-valid");
             $("select[name=txtPGradAl]").addClass("is-invalid");
         }
    });

    //Campo Select Arma
    $("select[name=txtArmaAl]").change(function(){
         if($("select[name=txtArmaAl]").val() != '0'){
             $("select[name=txtArmaAl]").removeClass("is-invalid");
             $("select[name=txtArmaAl]").addClass("is-valid");
         }else{
             $("select[name=txtArmaAl]").removeClass("is-valid");
             $("select[name=txtArmaAl]").addClass("is-invalid");
         }
    });

    //Campo Input Última Data de Praça
    $("input[name=txtUltDataPracaAl]").change(function(){
         if($("input[name=txtUltDataPracaAl]").val() != ''){
             $("input[name=txtUltDataPracaAl]").removeClass("is-invalid");
             $("input[name=txtUltDataPracaAl]").addClass("is-valid");
         }else{
             $("input[name=txtUltDataPracaAl]").removeClass("is-valid");
             $("input[name=txtUltDataPracaAl]").addClass("is-invalid");
         }
    });
    
    //Campo Input Nome
    $("input[name=txtNomeAl]").change(function(){
         if($("input[name=txtNomeAl]").val() != ''){
             $("input[name=txtNomeAl]").removeClass("is-invalid");
             $("input[name=txtNomeAl]").addClass("is-valid");
         }else{
             $("input[name=txtNomeAl]").removeClass("is-valid");
             $("input[name=txtNomeAl]").addClass("is-invalid");
         }
    });
    
    //Campo Input Sobrenome
    $("input[name=txtSobrenomeAl]").change(function(){
         if($("input[name=txtSobrenomeAl]").val() != ''){
             $("input[name=txtSobrenomeAl]").removeClass("is-invalid");
             $("input[name=txtSobrenomeAl]").addClass("is-valid");
         }else{
             $("input[name=txtSobrenomeAl]").removeClass("is-valid");
             $("input[name=txtSobrenomeAl]").addClass("is-invalid");
         }
    });
    
    //Campo Input Nome de Guerra
    $("input[name=txtNomeGuerraAl]").change(function(){
         if($("input[name=txtNomeGuerraAl]").val() != ''){
             $("input[name=txtNomeGuerraAl]").removeClass("is-invalid");
             $("input[name=txtNomeGuerraAl]").addClass("is-valid");
         }else{
             $("input[name=txtNomeGuerraAl]").removeClass("is-valid");
             $("input[name=txtNomeGuerraAl]").addClass("is-invalid");
         }
    });
    
    //Campo Input Identidade Militar
    $("input[name=txtIdtMilAl]").change(function(){
         if($("input[name=txtIdtMilAl]").val() != ''){
             $("input[name=txtIdtMilAl]").removeClass("is-invalid");
             $("input[name=txtIdtMilAl]").addClass("is-valid");
         }else{
             $("input[name=txtIdtMilAl]").removeClass("is-valid");
             $("input[name=txtIdtMilAl]").addClass("is-invalid");
         }
    });
    
    //Campo Input CPF
    $("input[name=txtCpfAl]").change(function(){
         if($("input[name=txtCpfAl]").val() != ''){
             $("input[name=txtCpfAl]").removeClass("is-invalid");
             $("input[name=txtCpfAl]").addClass("is-valid");
         }else{
             $("input[name=txtCpfAl]").removeClass("is-valid");
             $("input[name=txtCpfAl]").addClass("is-invalid");
         }
    });
    
    //Campo Input Data de Nascimento
    $("input[name=txtDataNascAl]").change(function(){
         if($("input[name=txtDataNascAl]").val() != ''){
             $("input[name=txtDataNascAl]").removeClass("is-invalid");
             $("input[name=txtDataNascAl]").addClass("is-valid");
         }else{
             $("input[name=txtDataNascAl]").removeClass("is-valid");
             $("input[name=txtDataNascAl]").addClass("is-invalid");
         }
    });
    
    //Campo Input Naturalidade (Estado)
    $("input[name=txtNatEstAl]").change(function(){
         if($("input[name=txtNatEstAl]").val() != ''){
             $("input[name=txtNatEstAl]").removeClass("is-invalid");
             $("input[name=txtNatEstAl]").addClass("is-valid");
         }else{
             $("input[name=txtNatEstAl]").removeClass("is-valid");
             $("input[name=txtNatEstAl]").addClass("is-invalid");
         }
    });
    
    //Campo Input Naturalidade (Cidade)
    $("input[name=txtNatCidAl]").change(function(){
         if($("input[name=txtNatCidAl]").val() != ''){
             $("input[name=txtNatCidAl]").removeClass("is-invalid");
             $("input[name=txtNatCidAl]").addClass("is-valid");
         }else{
             $("input[name=txtNatCidAl]").removeClass("is-valid");
             $("input[name=txtNatCidAl]").addClass("is-invalid");
         }
    });
    
    //Campo Select Estado Civil
    $("select[name=txtEstCivilAl]").change(function(){
         if($("select[name=txtEstCivilAl]").val() != '0'){
             $("select[name=txtEstCivilAl]").removeClass("is-invalid");
             $("select[name=txtEstCivilAl]").addClass("is-valid");
         }else{
             $("select[name=txtEstCivilAl]").removeClass("is-valid");
             $("select[name=txtEstCivilAl]").addClass("is-invalid");
         }
    });
    
    //Campo Select Sexo
    $("select[name=txtSexoAl]").change(function(){
         if($("select[name=txtSexoAl]").val() != '0'){
             $("select[name=txtSexoAl]").removeClass("is-invalid");
             $("select[name=txtSexoAl]").addClass("is-valid");
         }else{
             $("select[name=txtSexoAl]").removeClass("is-valid");
             $("select[name=txtSexoAl]").addClass("is-invalid");
         }
    });
    
    //Campo Select Tipo Sanguíneo
    $("select[name=txtTSAl]").change(function(){
         if($("select[name=txtTSAl]").val() != '0'){
             $("select[name=txtTSAl]").removeClass("is-invalid");
             $("select[name=txtTSAl]").addClass("is-valid");
         }else{
             $("select[name=txtTSAl]").removeClass("is-valid");
             $("select[name=txtTSAl]").addClass("is-invalid");
         }
    });
    
    //Campo Select Fator RH
    $("select[name=txtFatorRHAl]").change(function(){
         if($("select[name=txtFatorRHAl]").val() != '0'){
             $("select[name=txtFatorRHAl]").removeClass("is-invalid");
             $("select[name=txtFatorRHAl]").addClass("is-valid");
         }else{
             $("select[name=txtFatorRHAl]").removeClass("is-valid");
             $("select[name=txtFatorRHAl]").addClass("is-invalid");
         }
    });    
        
    //Campo Input Titulo Eleitoral
    $("input[name=txtTitEleitorNumAl]").change(function(){
         if($("input[name=txtTitEleitorNumAl]").val() != ''){
             $("input[name=txtTitEleitorNumAl]").removeClass("is-invalid");
             $("input[name=txtTitEleitorNumAl]").addClass("is-valid");
         }else{
             $("input[name=txtTitEleitorNumAl]").removeClass("is-valid");
             $("input[name=txtTitEleitorNumAl]").addClass("is-invalid");
         }
    });
        
    //Campo Input Zona Eleitoral
    $("input[name=txtTitEleitorZonaAl]").change(function(){
         if($("input[name=txtTitEleitorZonaAl]").val() != ''){
             $("input[name=txtTitEleitorZonaAl]").removeClass("is-invalid");
             $("input[name=txtTitEleitorZonaAl]").addClass("is-valid");
         }else{
             $("input[name=txtTitEleitorZonaAl]").removeClass("is-valid");
             $("input[name=txtTitEleitorZonaAl]").addClass("is-invalid");
         }
    });
        
    //Campo Input Seção Eleitoral
    $("input[name=txtTitEleitorSecaoAl]").change(function(){
         if($("input[name=txtTitEleitorSecaoAl]").val() != ''){
             $("input[name=txtTitEleitorSecaoAl]").removeClass("is-invalid");
             $("input[name=txtTitEleitorSecaoAl]").addClass("is-valid");
         }else{
             $("input[name=txtTitEleitorSecaoAl]").removeClass("is-valid");
             $("input[name=txtTitEleitorSecaoAl]").addClass("is-invalid");
         }
    });
        
    //Campo Input Titulo Eleitor Estado
    $("input[name=txtTitEleitorEstAl]").change(function(){
         if($("input[name=txtTitEleitorEstAl]").val() != ''){
             $("input[name=txtTitEleitorEstAl]").removeClass("is-invalid");
             $("input[name=txtTitEleitorEstAl]").addClass("is-valid");
         }else{
             $("input[name=txtTitEleitorEstAl]").removeClass("is-valid");
             $("input[name=txtTitEleitorEstAl]").addClass("is-invalid");
         }
    });
        
    //Campo Input Titulo Eleitor Cidade
    $("input[name=txtTitEleitorCidAl]").change(function(){
         if($("input[name=txtTitEleitorCidAl]").val() != ''){
             $("input[name=txtTitEleitorCidAl]").removeClass("is-invalid");
             $("input[name=txtTitEleitorCidAl]").addClass("is-valid");
         }else{
             $("input[name=txtTitEleitorCidAl]").removeClass("is-valid");
             $("input[name=txtTitEleitorCidAl]").addClass("is-invalid");
         }
    });
        
    //Campo Input Banco
    $("input[name=txtBancoAl]").change(function(){
         if($("input[name=txtBancoAl]").val() != ''){
             $("input[name=txtBancoAl]").removeClass("is-invalid");
             $("input[name=txtBancoAl]").addClass("is-valid");
         }else{
             $("input[name=txtBancoAl]").removeClass("is-valid");
             $("input[name=txtBancoAl]").addClass("is-invalid");
         }
    });
        
    //Campo Input Agência
    $("input[name=txtAgenciaAl]").change(function(){
         if($("input[name=txtAgenciaAl]").val() != ''){
             $("input[name=txtAgenciaAl]").removeClass("is-invalid");
             $("input[name=txtAgenciaAl]").addClass("is-valid");
         }else{
             $("input[name=txtAgenciaAl]").removeClass("is-valid");
             $("input[name=txtAgenciaAl]").addClass("is-invalid");
         }
    });
        
    //Campo Input Conta
    $("input[name=txtContaAl]").change(function(){
         if($("input[name=txtContaAl]").val() != ''){
             $("input[name=txtContaAl]").removeClass("is-invalid");
             $("input[name=txtContaAl]").addClass("is-valid");
         }else{
             $("input[name=txtContaAl]").removeClass("is-valid");
             $("input[name=txtContaAl]").addClass("is-invalid");
         }
    });
        
    //Campo Input Email
    $("input[name=txtEmailAl]").change(function(){
         if($("input[name=txtEmailAl]").val() != ''){
             $("input[name=txtEmailAl]").removeClass("is-invalid");
             $("input[name=txtEmailAl]").addClass("is-valid");
         }else{
             $("input[name=txtEmailAl]").removeClass("is-valid");
             $("input[name=txtEmailAl]").addClass("is-invalid");
         }
    });
        
    //Campo Input Fone
    $("input[name=txtFoneAl]").change(function(){
         if($("input[name=txtFoneAl]").val() != ''){
             $("input[name=txtFoneAl]").removeClass("is-invalid");
             $("input[name=txtFoneAl]").addClass("is-valid");
         }else{
             $("input[name=txtFoneAl]").removeClass("is-valid");
             $("input[name=txtFoneAl]").addClass("is-invalid");
         }
    });    
        
    //Campo Select Número Coturno
    $("select[name=txtNumCoturnoAl]").change(function(){
         if($("select[name=txtNumCoturnoAl]").val() != '0'){
             $("select[name=txtNumCoturnoAl]").removeClass("is-invalid");
             $("select[name=txtNumCoturnoAl]").addClass("is-valid");
         }else{
             $("select[name=txtNumCoturnoAl]").removeClass("is-valid");
             $("select[name=txtNumCoturnoAl]").addClass("is-invalid");
         }
    });
        
    //Campo Select Tamanho Gandola
    $("select[name=txtTamGandAl]").change(function(){
         if($("select[name=txtTamGandAl]").val() != '0'){
             $("select[name=txtTamGandAl]").removeClass("is-invalid");
             $("select[name=txtTamGandAl]").addClass("is-valid");
         }else{
             $("select[name=txtTamGandAl]").removeClass("is-valid");
             $("select[name=txtTamGandAl]").addClass("is-invalid");
         }
    });
        
    //Campo Select Tamanho Calça
    $("select[name=txtTamCalcaAl]").change(function(){
         if($("select[name=txtTamCalcaAl]").val() != '0'){
             $("select[name=txtTamCalcaAl]").removeClass("is-invalid");
             $("select[name=txtTamCalcaAl]").addClass("is-valid");
         }else{
             $("select[name=txtTamCalcaAl]").removeClass("is-valid");
             $("select[name=txtTamCalcaAl]").addClass("is-invalid");
         }
    });
        
    //Campo Select Tamanho Camuflada
    $("select[name=txtTamCamCmfAl]").change(function(){
         if($("select[name=txtTamCamCmfAl]").val() != '0'){
             $("select[name=txtTamCamCmfAl]").removeClass("is-invalid");
             $("select[name=txtTamCamCmfAl]").addClass("is-valid");
         }else{
             $("select[name=txtTamCamCmfAl]").removeClass("is-valid");
             $("select[name=txtTamCamCmfAl]").addClass("is-invalid");
         }
    });
    
    //Campo Select Possui CNH
    $("select[name=txtPossuiCNH]").change(function(){
        if($("select[name=txtPossuiCNH]").val() == '0'){            
           $("select[name=txtPossuiCNH]").removeClass("is-valid");
           $("select[name=txtPossuiCNH]").addClass("is-invalid");
        }
        else if($("select[name=txtPossuiCNH]").val() == 's'){
            $("select[name=txtPossuiCNH]").removeClass("is-invalid");
            $("select[name=txtPossuiCNH]").addClass("is-valid");
            //Campo Input CNH Num
            $("input[name=txtCNHNumAl]").change(function(){
                if($("input[name=txtCNHNumAl]").val() != ''){
                    $("input[name=txtCNHNumAl]").removeClass("is-invalid");
                    $("input[name=txtCNHNumAl]").addClass("is-valid");
                }else{
                    $("input[name=txtCNHNumAl]").removeClass("is-valid");
                    $("input[name=txtCNHNumAl]").addClass("is-invalid");
                }
            });            
                
            //Campo Select CNH Categoria
            $("select[name=txtCNHCatgAl]").change(function(){
                if($("select[name=txtCNHCatgAl]").val() != '0'){
                    $("select[name=txtCNHCatgAl]").removeClass("is-invalid");
                    $("select[name=txtCNHCatgAl]").addClass("is-valid");
                }else{
                    $("select[name=txtCNHCatgAl]").removeClass("is-valid");
                    $("select[name=txtCNHCatgAl]").addClass("is-invalid");
                }
            });
            
            //Campo Input Data Validade
            $("input[name=txtCNHDataValAl]").change(function(){
                if($("input[name=txtCNHDataValAl]").val() != ''){
                    $("input[name=txtCNHDataValAl]").removeClass("is-invalid");
                    $("input[name=txtCNHDataValAl]").addClass("is-valid");
                }else{
                    $("input[name=txtCNHDataValAl]").removeClass("is-valid");
                    $("input[name=txtCNHDataValAl]").addClass("is-invalid");
                }
            });
        }else if($("select[name=txtPossuiCNH]").val() == 'n'){
            $("select[name=txtPossuiCNH]").removeClass("is-invalid");
            $("select[name=txtPossuiCNH]").addClass("is-valid");
            
            $("input[name=txtCNHNumAl]").val('');
            $("input[name=txtCNHNumAl]").removeClass("is-invalid");
            $("input[name=txtCNHNumAl]").removeClass("is-valid");
            
            $("select[name=txtCNHCatgAl]").val('0');
            $("select[name=txtCNHCatgAl]").removeClass("is-invalid");
            $("select[name=txtCNHCatgAl]").removeClass("is-valid");
            
            $("input[name=txtCNHDataValAl]").val('');            
            $("input[name=txtCNHDataValAl]").removeClass("is-invalid");
            $("input[name=txtCNHDataValAl]").removeClass("is-valid");
        }
    });
    
    //Campo Select Trará veículo para o CIGS
    $("select[name=txtTraraVeiculo]").change(function(){
        if($("select[name=txtTraraVeiculo]").val() != '0'){
            $("select[name=txtTraraVeiculo]").removeClass("is-invalid");
            $("select[name=txtTraraVeiculo]").addClass("is-valid");
                
            //Campo Select Veiculo Tipo
            $("select[name=txtTipoVeiculoAl]").change(function(){
                if($("select[name=txtTipoVeiculoAl]").val() != '0'){
                    $("select[name=txtTipoVeiculoAl]").removeClass("is-invalid");
                    $("select[name=txtTipoVeiculoAl]").addClass("is-valid");
                }else{
                    $("select[name=txtTipoVeiculoAl]").removeClass("is-valid");
                    $("select[name=txtTipoVeiculoAl]").addClass("is-invalid");
                }
            });
            
            //Campo Input Veiculo Marca
            $("input[name=txtMarcaVeiculoAl]").change(function(){
                if($("input[name=txtMarcaVeiculoAl]").val() != ''){
                    $("input[name=txtMarcaVeiculoAl]").removeClass("is-invalid");
                    $("input[name=txtMarcaVeiculoAl]").addClass("is-valid");
                }else{
                    $("input[name=txtMarcaVeiculoAl]").removeClass("is-valid");
                    $("input[name=txtMarcaVeiculoAl]").addClass("is-invalid");
                }
            });
            
            //Campo Input Veiculo Modelo
            $("input[name=txtModeloVeiculoAl]").change(function(){
                if($("input[name=txtModeloVeiculoAl]").val() != ''){
                    $("input[name=txtModeloVeiculoAl]").removeClass("is-invalid");
                    $("input[name=txtModeloVeiculoAl]").addClass("is-valid");
                }else{
                    $("input[name=txtModeloVeiculoAl ]").removeClass("is-valid");
                    $("input[name=txtModeloVeiculoAl ]").addClass("is-invalid");
                }
            });
            
            //Campo Input Veiculo Cor
            $("input[name=txtCorVeiculoAl]").change(function(){
                if($("input[name=txtCorVeiculoAl]").val() != ''){
                    $("input[name=txtCorVeiculoAl]").removeClass("is-invalid");
                    $("input[name=txtCorVeiculoAl]").addClass("is-valid");
                }else{
                    $("input[name=txtCorVeiculoAl]").removeClass("is-valid");
                    $("input[name=txtCorVeiculoAl]").addClass("is-invalid");
                }
            });
            
            //Campo Input Veiculo Placa
            $("input[name=txtPlacaVeiculoAl]").change(function(){
                if($("input[name=txtPlacaVeiculoAl]").val() != ''){
                    $("input[name=txtPlacaVeiculoAl]").removeClass("is-invalid");
                    $("input[name=txtPlacaVeiculoAl]").addClass("is-valid");
                }else{
                    $("input[name=txtPlacaVeiculoAl]").removeClass("is-valid");
                    $("input[name=txtPlacaVeiculoAl]").addClass("is-invalid");
                }
            });
        }else{
           $("select[name=txtTraraVeiculo]").removeClass("is-valid");
           $("select[name=txtTraraVeiculo]").addClass("is-invalid");
        }
    });
    
    //Validação ao mudar o valor dos campos
    //Etapa 3: SAÚDE
    //Campo Select Fumante
    $("select[name=txtFumante]").change(function(){
        if($("select[name=txtFumante]").val() != '0'){
            $("select[name=txtFumante]").removeClass("is-invalid");
            $("select[name=txtFumante]").addClass("is-valid");
        }else{
            $("select[name=txtFumante]").removeClass("is-valid");
            $("select[name=txtFumante]").addClass("is-invalid");
        }
    });
    //Campo Select Alérgico
    $("select[name=txtAlergico]").change(function(){
        if($("select[name=txtAlergico]").val() != '0'){
            $("select[name=txtAlergico]").removeClass("is-invalid");
            $("select[name=txtAlergico]").addClass("is-valid");
        }else{
            $("select[name=txtAlergico]").removeClass("is-valid");
            $("select[name=txtAlergico]").addClass("is-invalid");
        }
    });
    //Campo Select Medicamentos Controlados
    $("select[name=txtUsoMtoCt]").change(function(){
        if($("select[name=txtUsoMtoCt]").val() != '0'){
            $("select[name=txtUsoMtoCt]").removeClass("is-invalid");
            $("select[name=txtUsoMtoCt]").addClass("is-valid");
        }else{
            $("select[name=txtUsoMtoCt]").removeClass("is-valid");
            $("select[name=txtUsoMtoCt]").addClass("is-invalid");
        }
    });
    //Campo Select Termogênicos, Ergogênicos ou Suplementos Alimentares
    $("select[name=txtUsoTermErgSupAli]").change(function(){
        if($("select[name=txtUsoTermErgSupAli]").val() != '0'){
            $("select[name=txtUsoTermErgSupAli]").removeClass("is-invalid");
            $("select[name=txtUsoTermErgSupAli]").addClass("is-valid");
        }else{
            $("select[name=txtUsoTermErgSupAli]").removeClass("is-valid");
            $("select[name=txtUsoTermErgSupAli]").addClass("is-invalid");
        }
    });
    
});
