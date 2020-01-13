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
   
   //Etapa 1: OM ATUAL
   $("button[name=btnProximo2]").click(function(){       
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
    });
    
    //Etapa 2: DADOS INDIVIDUAIS
    $("button[name=btnProximo3]").click(function(){
        //Dados Individuais
        if($("select[name=txtPGradAl]").val() == '0'){
            $("select[name=txtPGradAl]").removeClass("is-valid");
            $("select[name=txtPGradAl]").addClass("is-invalid");
            $("select[name=txtPGradAl]").focus();
        }
        else if($("select[name=txtArmaAl]").val() == '0'){
            $("select[name=txtArmaAl]").removeClass("is-valid");
            $("select[name=txtArmaAl]").addClass("is-invalid");
            $("select[name=txtArmaAl]").focus();
        }
        else if($("input[name=txtUltDataPracaAl]").val() == ''){
            $("input[name=txtUltDataPracaAl]").removeClass("is-valid");
            $("input[name=txtUltDataPracaAl]").addClass("is-invalid");
            $("input[name=txtUltDataPracaAl]").focus();
        }
        else if($("input[name=txtNomeAl]").val() == ''){
            $("input[name=txtNomeAl]").removeClass("is-valid");
            $("input[name=txtNomeAl]").addClass("is-invalid");
            $("input[name=txtNomeAl]").focus();
        }
        else if($("input[name=txtSobrenomeAl]").val() == ''){
            $("input[name=txtSobrenomeAl]").removeClass("is-valid");
            $("input[name=txtSobrenomeAl]").addClass("is-invalid");
            $("input[name=txtSobrenomeAl]").focus();
        }
        else if($("input[name=txtNomeGuerraAl]").val() == ''){
            $("input[name=txtNomeGuerraAl]").removeClass("is-valid");
            $("input[name=txtNomeGuerraAl]").addClass("is-invalid");
            $("input[name=txtNomeGuerraAl]").focus();
        }
        else if($("input[name=txtIdtMilAl]").val() == ''){
            $("input[name=txtIdtMilAl]").removeClass("is-valid");
            $("input[name=txtIdtMilAl]").addClass("is-invalid");
            $("input[name=txtIdtMilAl]").focus();
        }
        else if($("input[name=txtCpfAl]").val() == ''){
            $("input[name=txtCpfAl]").removeClass("is-valid");
            $("input[name=txtCpfAl]").addClass("is-invalid");
            $("input[name=txtCpfAl]").focus();
        }
        else if($("input[name=txtDataNascAl]").val() == ''){
            $("input[name=txtDataNascAl]").removeClass("is-valid");
            $("input[name=txtDataNascAl]").addClass("is-invalid");
            $("input[name=txtDataNascAl]").focus();
        }
        else if($("input[name=txtNatEstAl]").val() == ''){
            $("input[name=txtNatEstAl]").removeClass("is-valid");
            $("input[name=txtNatEstAl]").addClass("is-invalid");
            $("input[name=txtNatEstAl]").focus();
        }
        else if($("input[name=txtNatCidAl]").val() == ''){
            $("input[name=txtNatCidAl]").removeClass("is-valid");
            $("input[name=txtNatCidAl]").addClass("is-invalid");
            $("input[name=txtNatCidAl]").focus();
        }
        else if($("select[name=txtEstCivilAl]").val() == '0'){
            $("select[name=txtEstCivilAl]").removeClass("is-valid");
            $("select[name=txtEstCivilAl]").addClass("is-invalid");
            $("select[name=txtEstCivilAl]").focus();
        }
        else if($("select[name=txtSexoAl]").val() == '0'){
            $("select[name=txtSexoAl]").removeClass("is-valid");
            $("select[name=txtSexoAl]").addClass("is-invalid");
            $("select[name=txtSexoAl]").focus();
        }
        else if($("select[name=txtTSAl]").val() == '0'){
            $("select[name=txtTSAl]").removeClass("is-valid");
            $("select[name=txtTSAl]").addClass("is-invalid");
            $("select[name=txtTSAl]").focus();
        }
        else if($("select[name=txtFatorRHAl]").val() == '0'){
            $("select[name=txtFatorRHAl]").removeClass("is-valid");
            $("select[name=txtFatorRHAl]").addClass("is-invalid");
            $("select[name=txtFatorRHAl]").focus();
        }
        else if($("input[name=txtTitEleitorNumAl]").val() == ''){
            $("input[name=txtTitEleitorNumAl]").removeClass("is-valid");
            $("input[name=txtTitEleitorNumAl]").addClass("is-invalid");
            $("input[name=txtTitEleitorNumAl]").focus();
        }
        else if($("input[name=txtTitEleitorZonaAl]").val() == ''){
            $("input[name=txtTitEleitorZonaAl]").removeClass("is-valid");
            $("input[name=txtTitEleitorZonaAl]").addClass("is-invalid");
            $("input[name=txtTitEleitorZonaAl]").focus();
        }
        else if($("input[name=txtTitEleitorSecaoAl]").val() == ''){
            $("input[name=txtTitEleitorSecaoAl]").removeClass("is-valid");
            $("input[name=txtTitEleitorSecaoAl]").addClass("is-invalid");
            $("input[name=txtTitEleitorSecaoAl]").focus();
        }
        else if($("input[name=txtTitEleitorEstAl]").val() == ''){
            $("input[name=txtTitEleitorEstAl]").removeClass("is-valid");
            $("input[name=txtTitEleitorEstAl]").addClass("is-invalid");
            $("input[name=txtTitEleitorEstAl]").focus();
        }
        else if($("input[name=txtTitEleitorCidAl]").val() == ''){
            $("input[name=txtTitEleitorCidAl]").removeClass("is-valid");
            $("input[name=txtTitEleitorCidAl]").addClass("is-invalid");
            $("input[name=txtTitEleitorCidAl]").focus();
        }
        else if($("input[name=txtBancoAl]").val() == ''){
            $("input[name=txtBancoAl]").removeClass("is-valid");
            $("input[name=txtBancoAl]").addClass("is-invalid");
            $("input[name=txtBancoAl]").focus();
        }
        else if($("input[name=txtAgenciaAl]").val() == ''){
            $("input[name=txtAgenciaAl]").removeClass("is-valid");
            $("input[name=txtAgenciaAl]").addClass("is-invalid");
            $("input[name=txtAgenciaAl]").focus();
        }
        else if($("input[name=txtContaAl]").val() == ''){
            $("input[name=txtContaAl]").removeClass("is-valid");
            $("input[name=txtContaAl]").addClass("is-invalid");
            $("input[name=txtContaAl]").focus();
        }
        else if($("input[name=txtEmailAl]").val() == ''){
            $("input[name=txtEmailAl]").removeClass("is-valid");
            $("input[name=txtEmailAl]").addClass("is-invalid");
            $("input[name=txtEmailAl]").focus();
        }
        else if($("input[name=txtFoneAl]").val() == ''){
            $("input[name=txtFoneAl]").removeClass("is-valid");
            $("input[name=txtFoneAl]").addClass("is-invalid");
            $("input[name=txtFoneAl]").focus();
        }
        else if($("select[name=txtNumCoturnoAl]").val() == '0'){
            $("select[name=txtNumCoturnoAl]").removeClass("is-valid");
            $("select[name=txtNumCoturnoAl]").addClass("is-invalid");
            $("select[name=txtNumCoturnoAl]").focus();
        }
        else if($("select[name=txtTamGandAl]").val() == '0'){
            $("select[name=txtTamGandAl]").removeClass("is-valid");
            $("select[name=txtTamGandAl]").addClass("is-invalid");
            $("select[name=txtTamGandAl]").focus();
        }
        else if($("select[name=txtTamCalcaAl]").val() == '0'){
            $("select[name=txtTamCalcaAl]").removeClass("is-valid");
            $("select[name=txtTamCalcaAl]").addClass("is-invalid");
            $("select[name=txtTamCalcaAl]").focus();
        }
        else if($("select[name=txtTamCamCmfAl]").val() == '0'){
            $("select[name=txtTamCamCmfAl]").removeClass("is-valid");
            $("select[name=txtTamCamCmfAl]").addClass("is-invalid");
            $("select[name=txtTamCamCmfAl]").focus();
        }
        else if($("select[name=txtPossuiCNH]").val() == '0'){
            $("select[name=txtPossuiCNH]").removeClass("is-valid");
            $("select[name=txtPossuiCNH]").addClass("is-invalid");
            $("select[name=txtPossuiCNH]").focus();
        }
        else if($("select[name=txtTraraVeiculo]").val() == '0'){
            $("select[name=txtTraraVeiculo]").removeClass("is-valid");
            $("select[name=txtTraraVeiculo]").addClass("is-invalid");
            $("select[name=txtTraraVeiculo]").focus();
        } 
        //Não possui CNH
        else if($("select[name=txtPossuiCNH]").val() == 'n'){                       
            //Não possui Veículo
            if($("select[name=txtTraraVeiculo]").val() == 'n'){
                prox($(this));
            }
            //Possui Veículo
            else if($("select[name=txtTraraVeiculo]").val() == 's'){
                for(var i=0;i<($("input[name=txtPlacaVeiculoAl").length);i++){
                    if($("select[name=txtTipoVeiculoAl]").eq(i).val() == '0' ){
                        $("select[name=txtTipoVeiculoAl]").eq(i).removeClass("is-valid");
                        $("select[name=txtTipoVeiculoAl]").eq(i).addClass("is-invalid");
                        $("select[name=txtTipoVeiculoAl]").eq(i).focus();
                        break;
                    }                    
                    else if($("input[name=txtMarcaVeiculoAl]").eq(i).val() == ''){
                        $("input[name=txtMarcaVeiculoAl]").eq(i).removeClass("is-valid");
                        $("input[name=txtMarcaVeiculoAl]").eq(i).addClass("is-invalid");
                        $("input[name=txtMarcaVeiculoAl]").eq(i).focus();
                        break;
                    }
                    else if($("input[name=txtModeloVeiculoAl]").eq(i).val() == ''){
                        $("input[name=txtModeloVeiculoAl]").eq(i).removeClass("is-valid");
                        $("input[name=txtModeloVeiculoAl]").eq(i).addClass("is-invalid");
                        $("input[name=txtModeloVeiculoAl]").eq(i).focus();
                        break;
                    }
                    else if($("input[name=txtCorVeiculoAl]").eq(i).val() == ''){
                        $("input[name=txtCorVeiculoAl]").eq(i).removeClass("is-valid");
                        $("input[name=txtCorVeiculoAl]").eq(i).addClass("is-invalid");
                        $("input[name=txtCorVeiculoAl]").eq(i).focus();
                        break;
                    }
                    else if($("input[name=txtPlacaVeiculoAl]").eq(i).val() == ''){
                        $("input[name=txtPlacaVeiculoAl]").eq(i).removeClass("is-valid");
                        $("input[name=txtPlacaVeiculoAl]").eq(i).addClass("is-invalid");
                        $("input[name=txtPlacaVeiculoAl]").eq(i).focus();
                        break;
                    }
                    else if(($("input[name=txtPlacaVeiculoAl]").eq($("input[name=txtPlacaVeiculoAl]").length-1).val()) != ''){
                        prox($(this));
                    }
                }                       
            }
        }        
        //Possui CNH
       else if($("select[name=txtPossuiCNH]").val() == 's'){
            if($("input[name=txtCNHNumAl]").val() == ''){
                $("input[name=txtCNHNumAl]").removeClass("is-valid");
                $("input[name=txtCNHNumAl]").addClass("is-invalid");
                $("input[name=txtCNHNumAl]").focus();
            }
            else if($("select[name=txtCNHCatgAl]").val() == '0'){
                $("select[name=txtCNHCatgAl]").removeClass("is-valid");
                $("select[name=txtCNHCatgAl]").addClass("is-invalid");
                $("select[name=txtCNHCatgAl]").focus();
            }
            else if($("input[name=txtCNHDataValAl]").val() == ''){
                $("input[name=txtCNHDataValAl]").removeClass("is-valid");
                $("input[name=txtCNHDataValAl]").addClass("is-invalid");
                $("input[name=txtCNHDataValAl]").focus();
            }            
            //Não possui Veículo
            else if($("select[name=txtTraraVeiculo]").val() == 'n'){
                prox($(this));
            }
            //Possui Veículo
            else if($("select[name=txtTraraVeiculo]").val() == 's'){
                for(var i=0;i<($("input[name=txtPlacaVeiculoAl").length);i++){
                    if($("select[name=txtTipoVeiculoAl]").eq(i).val() == '0' ){
                        $("select[name=txtTipoVeiculoAl]").eq(i).removeClass("is-valid");
                        $("select[name=txtTipoVeiculoAl]").eq(i).addClass("is-invalid");
                        $("select[name=txtTipoVeiculoAl]").eq(i).focus();
                        break;
                    }                    
                    else if($("input[name=txtMarcaVeiculoAl]").eq(i).val() == ''){
                        $("input[name=txtMarcaVeiculoAl]").eq(i).removeClass("is-valid");
                        $("input[name=txtMarcaVeiculoAl]").eq(i).addClass("is-invalid");
                        $("input[name=txtMarcaVeiculoAl]").eq(i).focus();
                        break;
                    }
                    else if($("input[name=txtModeloVeiculoAl]").eq(i).val() == ''){
                        $("input[name=txtModeloVeiculoAl]").eq(i).removeClass("is-valid");
                        $("input[name=txtModeloVeiculoAl]").eq(i).addClass("is-invalid");
                        $("input[name=txtModeloVeiculoAl]").eq(i).focus();
                        break;
                    }
                    else if($("input[name=txtCorVeiculoAl]").eq(i).val() == ''){
                        $("input[name=txtCorVeiculoAl]").eq(i).removeClass("is-valid");
                        $("input[name=txtCorVeiculoAl]").eq(i).addClass("is-invalid");
                        $("input[name=txtCorVeiculoAl]").eq(i).focus();
                        break;
                    }
                    else if($("input[name=txtPlacaVeiculoAl]").eq(i).val() == ''){
                        $("input[name=txtPlacaVeiculoAl]").eq(i).removeClass("is-valid");
                        $("input[name=txtPlacaVeiculoAl]").eq(i).addClass("is-invalid");
                        $("input[name=txtPlacaVeiculoAl]").eq(i).focus();
                        break;
                    }
                    else if(($("input[name=txtPlacaVeiculoAl]").eq($("input[name=txtPlacaVeiculoAl]").length-1).val()) != ''){
                        prox($(this));
                    }
                }
            }
        }   
        //Próxima Etapa
        else{
            prox($(this));
        }
    });
    
    //Etapa 3: SAÚDE
    $("button[name=btnProximo4]").click(function(){
        if($("select[name=txtFumante]").val() == '0'){
            $("select[name=txtFumante]").removeClass("is-valid");
            $("select[name=txtFumante]").addClass("is-invalid");
            $("select[name=txtFumante]").focus();
        }
        else if($("select[name=txtAlergico]").val() == '0'){
            $("select[name=txtAlergico]").removeClass("is-valid");
            $("select[name=txtAlergico]").addClass("is-invalid");
            $("select[name=txtAlergico]").focus();
        }
        else if($("select[name=txtUsoMtoCt]").val() == '0'){
            $("select[name=txtUsoMtoCt]").removeClass("is-valid");
            $("select[name=txtUsoMtoCt]").addClass("is-invalid");
            $("select[name=txtUsoMtoCt]").focus();
        }
        else if($("select[name=txtUsoTermErgSupAli]").val() == '0'){
            $("select[name=txtUsoTermErgSupAli]").removeClass("is-valid");
            $("select[name=txtUsoTermErgSupAli]").addClass("is-invalid");
            $("select[name=txtUsoTermErgSupAli]").focus();
        }        
        else if(($("select[name=txtAlergico]").val() == 'n') && ($("select[name=txtUsoMtoCt]").val() == 'n') && ($("select[name=txtUsoTermErgSupAli]").val() == 'n')){
            prox($(this));
        }
        else if(($("select[name=txtAlergico]").val() == 's') && ($("select[name=txtUsoMtoCt]").val() == 'n') && ($("select[name=txtUsoTermErgSupAli]").val() == 'n')){
            for(var i=0;i<($("input[name=txtAlergia").length);i++){
                if($("input[name=txtAlergia]").eq(i).val() == '' ){
                    $("input[name=txtAlergia]").eq(i).removeClass("is-valid");
                    $("input[name=txtAlergia]").eq(i).addClass("is-invalid");
                    $("input[name=txtAlergia]").eq(i).focus();
                    break;
                }
                else if(($("input[name=txtAlergia]").eq($("input[name=txtAlergia]").length-1).val()) != ''){
                    prox($(this));
                }
            }
        }
        else if(($("select[name=txtAlergico]").val() == 'n') && ($("select[name=txtUsoMtoCt]").val() == 's') && ($("select[name=txtUsoTermErgSupAli]").val() == 'n')){
            for(var i=0;i<($("select[name=txtTpMtoCt").length);i++){
                if($("input[name=txtNomeMtoCt]").eq(i).val() == '' ){
                    $("input[name=txtNomeMtoCt]").eq(i).removeClass("is-valid");
                    $("input[name=txtNomeMtoCt]").eq(i).addClass("is-invalid");
                    $("input[name=txtNomeMtoCt]").eq(i).focus();
                    break;
                }
                else if($("input[name=txtFrqMtoCt]").eq(i).val() == '' ){
                    $("input[name=txtFrqMtoCt]").eq(i).removeClass("is-valid");
                    $("input[name=txtFrqMtoCt]").eq(i).addClass("is-invalid");
                    $("input[name=txtFrqMtoCt]").eq(i).focus();
                    break;
                }
                else if($("select[name=txtTpMtoCt]").eq(i).val() == '0' ){
                    $("select[name=txtTpMtoCt]").eq(i).removeClass("is-valid");
                    $("select[name=txtTpMtoCt]").eq(i).addClass("is-invalid");
                    $("select[name=txtTpMtoCt]").eq(i).focus();
                    break;
                }
                else if(($("select[name=txtTpMtoCt]").eq($("select[name=txtTpMtoCt]").length-1).val()) != '0'){
                    prox($(this));
                }
            }
        }
        else if(($("select[name=txtAlergico]").val() == 'n') && ($("select[name=txtUsoMtoCt]").val() == 'n') && ($("select[name=txtUsoTermErgSupAli]").val() == 's')){
            for(var i=0;i<($("input[name=txtNomeTermErgSupAli").length);i++){
                if($("input[name=txtNomeTermErgSupAli]").eq(i).val() == '' ){
                    $("input[name=txtNomeTermErgSupAli]").eq(i).removeClass("is-valid");
                    $("input[name=txtNomeTermErgSupAli]").eq(i).addClass("is-invalid");
                    $("input[name=txtNomeTermErgSupAli]").eq(i).focus();
                    break;
                }
                else if(($("input[name=txtNomeTermErgSupAli]").eq($("input[name=txtNomeTermErgSupAli]").length-1).val()) != ''){
                    prox($(this));
                }
            }
        }        
        else if(($("select[name=txtAlergico]").val() == 'n') && ($("select[name=txtUsoMtoCt]").val() == 's') && ($("select[name=txtUsoTermErgSupAli]").val() == 's')){
            var prontoMtoCt = 0;
            var prontoTermErgSupAli = 0;
            
            for(var i=0;i<($("select[name=txtTpMtoCt").length);i++){
                if($("input[name=txtNomeMtoCt]").eq(i).val() == '' ){
                    $("input[name=txtNomeMtoCt]").eq(i).removeClass("is-valid");
                    $("input[name=txtNomeMtoCt]").eq(i).addClass("is-invalid");
                    $("input[name=txtNomeMtoCt]").eq(i).focus();
                    break;
                }
                else if($("input[name=txtFrqMtoCt]").eq(i).val() == '' ){
                    $("input[name=txtFrqMtoCt]").eq(i).removeClass("is-valid");
                    $("input[name=txtFrqMtoCt]").eq(i).addClass("is-invalid");
                    $("input[name=txtFrqMtoCt]").eq(i).focus();
                    break;
                }
                else if($("select[name=txtTpMtoCt]").eq(i).val() == '0' ){
                    $("select[name=txtTpMtoCt]").eq(i).removeClass("is-valid");
                    $("select[name=txtTpMtoCt]").eq(i).addClass("is-invalid");
                    $("select[name=txtTpMtoCt]").eq(i).focus();
                    break;
                }
                else if(($("select[name=txtTpMtoCt]").eq($("select[name=txtTpMtoCt]").length-1).val()) != '0'){
                    prontoMtoCt=1;
                }
            }             
            for(var i=0;i<($("input[name=txtNomeTermErgSupAli").length);i++){
                if($("input[name=txtNomeTermErgSupAli]").eq(i).val() == '' ){
                    $("input[name=txtNomeTermErgSupAli]").eq(i).removeClass("is-valid");
                    $("input[name=txtNomeTermErgSupAli]").eq(i).addClass("is-invalid");
                    $("input[name=txtNomeTermErgSupAli]").eq(i).focus();
                    break;
                }
                else if(($("input[name=txtNomeTermErgSupAli]").eq($("input[name=txtNomeTermErgSupAli]").length-1).val()) != ''){
                    prontoTermErgSupAli = 1;
                }
            }            
            if((prontoMtoCt == 1) && (prontoTermErgSupAli == 1)){
                prox($(this));
            }
        }
        else if(($("select[name=txtAlergico]").val() == 's') && ($("select[name=txtUsoMtoCt]").val() == 'n') && ($("select[name=txtUsoTermErgSupAli]").val() == 's')){
            var prontoAlergico = 0;
            var prontoTermErgSupAli = 0;
            
            for(var i=0;i<($("input[name=txtAlergia").length);i++){
                if($("input[name=txtAlergia]").eq(i).val() == '' ){
                    $("input[name=txtAlergia]").eq(i).removeClass("is-valid");
                    $("input[name=txtAlergia]").eq(i).addClass("is-invalid");
                    $("input[name=txtAlergia]").eq(i).focus();
                    break;
                }
                else if(($("input[name=txtAlergia]").eq($("input[name=txtAlergia]").length-1).val()) != ''){
                    prontoAlergico = 1;
                }
            }             
            for(var i=0;i<($("input[name=txtNomeTermErgSupAli").length);i++){
                if($("input[name=txtNomeTermErgSupAli]").eq(i).val() == '' ){
                    $("input[name=txtNomeTermErgSupAli]").eq(i).removeClass("is-valid");
                    $("input[name=txtNomeTermErgSupAli]").eq(i).addClass("is-invalid");
                    $("input[name=txtNomeTermErgSupAli]").eq(i).focus();
                    break;
                }
                else if(($("input[name=txtNomeTermErgSupAli]").eq($("input[name=txtNomeTermErgSupAli]").length-1).val()) != ''){
                    prontoTermErgSupAli = 1;
                }
            }            
            if((prontoAlergico == 1) && (prontoTermErgSupAli == 1)){
                prox($(this));
            }
        }
        else if(($("select[name=txtAlergico]").val() == 's') && ($("select[name=txtUsoMtoCt]").val() == 's') && ($("select[name=txtUsoTermErgSupAli]").val() == 'n')){
            var prontoAlergico = 0;
            var prontoMtoCt = 0;
            
            for(var i=0;i<($("input[name=txtAlergia").length);i++){
                if($("input[name=txtAlergia]").eq(i).val() == '' ){
                    $("input[name=txtAlergia]").eq(i).removeClass("is-valid");
                    $("input[name=txtAlergia]").eq(i).addClass("is-invalid");
                    $("input[name=txtAlergia]").eq(i).focus();
                    break;
                }
                else if(($("input[name=txtAlergia]").eq($("input[name=txtAlergia]").length-1).val()) != ''){
                    prontoAlergico = 1;
                }
            }             
            for(var i=0;i<($("select[name=txtTpMtoCt").length);i++){
                if($("input[name=txtNomeMtoCt]").eq(i).val() == '' ){
                    $("input[name=txtNomeMtoCt]").eq(i).removeClass("is-valid");
                    $("input[name=txtNomeMtoCt]").eq(i).addClass("is-invalid");
                    $("input[name=txtNomeMtoCt]").eq(i).focus();
                    break;
                }
                else if($("input[name=txtFrqMtoCt]").eq(i).val() == '' ){
                    $("input[name=txtFrqMtoCt]").eq(i).removeClass("is-valid");
                    $("input[name=txtFrqMtoCt]").eq(i).addClass("is-invalid");
                    $("input[name=txtFrqMtoCt]").eq(i).focus();
                    break;
                }
                else if($("select[name=txtTpMtoCt]").eq(i).val() == '0' ){
                    $("select[name=txtTpMtoCt]").eq(i).removeClass("is-valid");
                    $("select[name=txtTpMtoCt]").eq(i).addClass("is-invalid");
                    $("select[name=txtTpMtoCt]").eq(i).focus();
                    break;
                }
                else if(($("select[name=txtTpMtoCt]").eq($("select[name=txtTpMtoCt]").length-1).val()) != '0'){
                    prontoMtoCt=1;
                }
            }            
            if((prontoAlergico == 1) && (prontoMtoCt == 1)){
                prox($(this));
            }
        }
        
        else if(($("select[name=txtAlergico]").val() == 's') && ($("select[name=txtUsoMtoCt]").val() == 's') && ($("select[name=txtUsoTermErgSupAli]").val() == 's')){
            var prontoAlergico = 0;
            var prontoMtoCt = 0;
            var prontoTermErgSupAli =0;
            
            for(var i=0;i<($("input[name=txtAlergia").length);i++){
                if($("input[name=txtAlergia]").eq(i).val() == '' ){
                    $("input[name=txtAlergia]").eq(i).removeClass("is-valid");
                    $("input[name=txtAlergia]").eq(i).addClass("is-invalid");
                    $("input[name=txtAlergia]").eq(i).focus();
                    break;
                }
                else if(($("input[name=txtAlergia]").eq($("input[name=txtAlergia]").length-1).val()) != ''){
                    prontoAlergico = 1;
                }
            }             
            for(var i=0;i<($("select[name=txtTpMtoCt").length);i++){
                if($("input[name=txtNomeMtoCt]").eq(i).val() == '' ){
                    $("input[name=txtNomeMtoCt]").eq(i).removeClass("is-valid");
                    $("input[name=txtNomeMtoCt]").eq(i).addClass("is-invalid");
                    $("input[name=txtNomeMtoCt]").eq(i).focus();
                    break;
                }
                else if($("input[name=txtFrqMtoCt]").eq(i).val() == '' ){
                    $("input[name=txtFrqMtoCt]").eq(i).removeClass("is-valid");
                    $("input[name=txtFrqMtoCt]").eq(i).addClass("is-invalid");
                    $("input[name=txtFrqMtoCt]").eq(i).focus();
                    break;
                }
                else if($("select[name=txtTpMtoCt]").eq(i).val() == '0' ){
                    $("select[name=txtTpMtoCt]").eq(i).removeClass("is-valid");
                    $("select[name=txtTpMtoCt]").eq(i).addClass("is-invalid");
                    $("select[name=txtTpMtoCt]").eq(i).focus();
                    break;
                }
                else if(($("select[name=txtTpMtoCt]").eq($("select[name=txtTpMtoCt]").length-1).val()) != '0'){
                    prontoMtoCt=1;
                }
            }            
            for(var i=0;i<($("input[name=txtNomeTermErgSupAli").length);i++){
                if($("input[name=txtNomeTermErgSupAli]").eq(i).val() == '' ){
                    $("input[name=txtNomeTermErgSupAli]").eq(i).removeClass("is-valid");
                    $("input[name=txtNomeTermErgSupAli]").eq(i).addClass("is-invalid");
                    $("input[name=txtNomeTermErgSupAli]").eq(i).focus();
                    break;
                }
                else if(($("input[name=txtNomeTermErgSupAli]").eq($("input[name=txtNomeTermErgSupAli]").length-1).val()) != ''){
                    prontoTermErgSupAli = 1;
                }
            }            
            if((prontoAlergico == 1) && (prontoMtoCt == 1) && (prontoTermErgSupAli == 1)){
                prox($(this));
            }
        }        
    });
    
    //Etapa 4: DADOS MILITARES
    $("button[name=btnProximo5]").click(function(){
        if($("input[name=txtFormEscNome]").val() == ''){
            $("input[name=txtFormEscNome]").removeClass("is-valid");
            $("input[name=txtFormEscNome]").addClass("is-invalid");
            $("input[name=txtFormEscNome]").focus();
        }
        else if($("input[name=txtFormEscAbrev]").val() == ''){
            $("input[name=txtFormEscAbrev]").removeClass("is-valid");
            $("input[name=txtFormEscAbrev]").addClass("is-invalid");
            $("input[name=txtFormEscAbrev]").focus();
        }
        else if($("input[name=txtFormTurma]").val() == ''){
            $("input[name=txtFormTurma]").removeClass("is-valid");
            $("input[name=txtFormTurma]").addClass("is-invalid");
            $("input[name=txtFormTurma]").focus();
        }
        else if($("select[name=txtCptmAl]").val() == '0'){
            $("select[name=txtCptmAl]").removeClass("is-valid");
            $("select[name=txtCptmAl]").addClass("is-invalid");
            $("select[name=txtCptmAl]").focus();
        }
        else if($("input[name=txtDataUltProm]").val() == ''){
            $("input[name=txtDataUltProm]").removeClass("is-valid");
            $("input[name=txtDataUltProm]").addClass("is-invalid");
            $("input[name=txtDataUltProm]").focus();
        }
        else if($("select[name=txtQaProm]").val() == '0'){
            $("select[name=txtQaProm]").removeClass("is-valid");
            $("select[name=txtQaProm]").addClass("is-invalid");
            $("select[name=txtQaProm]").focus();
        }
        else if($("select[name=txtQaProm]").val() == 's'){
            if($("input[name=txtQaQuandoProm]").val() == ''){
                $("input[name=txtQaQuandoProm]").removeClass("is-valid");
                $("input[name=txtQaQuandoProm]").addClass("is-invalid");
                $("input[name=txtQaQuandoProm]").focus();                
            }
            else if($("input[name=txtDataUltTAF]").val() == ''){
                $("input[name=txtDataUltTAF]").removeClass("is-valid");
                $("input[name=txtDataUltTAF]").addClass("is-invalid");
                $("input[name=txtDataUltTAF]").focus();                
            }
            else if($("select[name=txtMencaoTAF]").val() == '0'){
                $("select[name=txtMencaoTAF]").removeClass("is-valid");
                $("select[name=txtMencaoTAF]").addClass("is-invalid");
                $("select[name=txtMencaoTAF]").focus();
            }
            else if($("input[name=txtFunc1]").val() == ''){
                $("input[name=txtFunc1]").removeClass("is-valid");
                $("input[name=txtFunc1]").addClass("is-invalid");
                $("input[name=txtFunc1]").focus();                
            }
            else if($("input[name=txtFunc2]").val() == ''){
                $("input[name=txtFunc2]").removeClass("is-valid");
                $("input[name=txtFunc2]").addClass("is-invalid");
                $("input[name=txtFunc2]").focus();                
            }
            else if($("input[name=txtFunc3]").val() == ''){
                $("input[name=txtFunc3]").removeClass("is-valid");
                $("input[name=txtFunc3]").addClass("is-invalid");
                $("input[name=txtFunc3]").focus();                
            }
            else{
                prox($(this));
            }
        }
        else if($("select[name=txtQaProm]").val() == 'n'){            
            if($("input[name=txtDataUltTAF]").val() == ''){
                $("input[name=txtDataUltTAF]").removeClass("is-valid");
                $("input[name=txtDataUltTAF]").addClass("is-invalid");
                $("input[name=txtDataUltTAF]").focus();                
            }
            else if($("select[name=txtMencaoTAF]").val() == '0'){
                $("select[name=txtMencaoTAF]").removeClass("is-valid");
                $("select[name=txtMencaoTAF]").addClass("is-invalid");
                $("select[name=txtMencaoTAF]").focus();
            }
            else if($("input[name=txtFunc1]").val() == ''){
                $("input[name=txtFunc1]").removeClass("is-valid");
                $("input[name=txtFunc1]").addClass("is-invalid");
                $("input[name=txtFunc1]").focus();                
            }
            else if($("input[name=txtFunc2]").val() == ''){
                $("input[name=txtFunc2]").removeClass("is-valid");
                $("input[name=txtFunc2]").addClass("is-invalid");
                $("input[name=txtFunc2]").focus();                
            }
            else if($("input[name=txtFunc3]").val() == ''){
                $("input[name=txtFunc3]").removeClass("is-valid");
                $("input[name=txtFunc3]").addClass("is-invalid");
                $("input[name=txtFunc3]").focus();                
            }
            else{
                prox($(this));
            }
        }
        
    });
});

