/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    function limpa_formulário_cep() {
        // Limpa valores do formulário de cep.
        $("#txtNomeEndResid").val("");
        $("#txtNomeEndResid").removeClass("is-invalid");
        $("#txtNomeEndResid").removeClass("is-valid");

        $("#txtNumEndResid").val("");
        $("#txtNumEndResid").removeClass("is-invalid");
        $("#txtNumEndResid").removeClass("is-valid");

        $("#txtEstadoEndResid").val("");
        $("#txtEstadoEndResid").removeClass("is-invalid");
        $("#txtEstadoEndResid").removeClass("is-valid");

        $("#txtCidadeEndResid").val("");
        $("#txtCidadeEndResid").removeClass("is-invalid");
        $("#txtCidadeEndResid").removeClass("is-valid");

        $("#txtBairroEndResid").val("");
        $("#txtBairroEndResid").removeClass("is-invalid");
        $("#txtBairroEndResid").removeClass("is-valid");

        $("#txtCompEndResid").val("");
        $("#txtCompEndResid").removeClass("is-invalid");
        $("#txtCompEndResid").removeClass("is-valid");

        if(($("#txtEndCurso").val() == "resid") || ($("#txtEndCurso").val() == "0")){
            $("#txtEndCurso").val("0");
            $("#txtEndCurso").removeClass("is-invalid");
            $("#txtEndCurso").removeClass("is-valid");

            $("input[name=txtCepEndCurso]").val("");
            $("input[name=txtCepEndCurso]").removeClass("is-invalid");
            $("input[name=txtCepEndCurso]").removeClass("is-valid");

            $("input[name=txtNomeEndCurso]").val("");
            $("input[name=txtNomeEndCurso]").removeClass("is-invalid");
            $("input[name=txtNomeEndCurso]").removeClass("is-valid");

            $("input[name=txtNumEndCurso]").val("");
            $("input[name=txtNumEndCurso]").removeClass("is-invalid");
            $("input[name=txtNumEndCurso]").removeClass("is-valid");

            $("input[name=txtEstadoEndCurso]").val("");
            $("input[name=txtEstadoEndCurso]").removeClass("is-invalid");
            $("input[name=txtEstadoEndCurso]").removeClass("is-valid");

            $("input[name=txtCidadeEndCurso]").val("");
            $("input[name=txtCidadeEndCurso]").removeClass("is-invalid");
            $("input[name=txtCidadeEndCurso]").removeClass("is-valid");

            $("input[name=txtBairroEndCurso]").val("");
            $("input[name=txtBairroEndCurso]").removeClass("is-invalid");
            $("input[name=txtBairroEndCurso]").removeClass("is-valid");

            $("input[name=txtCompEndCurso]").val("");
            $("input[name=txtCompEndCurso]").removeClass("is-invalid");
            $("input[name=txtCompEndCurso]").removeClass("is-valid");

            $("input[name=txtPtRefEndCurso]").val("");
            $("input[name=txtPtRefEndCurso]").removeClass("is-invalid");
            $("input[name=txtPtRefEndCurso]").removeClass("is-valid");
        }
    }

    //Quando o campo cep perde o foco.
    $("#txtCepEndResid").change(function() {
        //Nova variável "cep" somente com dígitos.
        var cep = $(this).val().replace(/\D/g, '');
        //Verifica se campo cep possui valor informado.
        if (cep != "") {
            //Expressão regular para validar o CEP.
            var validacep = /^[0-9]{8}$/;
            //Valida o formato do CEP.
            if(validacep.test(cep)) {
                //Preenche os campos com "..." enquanto consulta webservice.
                $("#txtNomeEndResid").val("...");
                $("#txtEstadoEndResid").val("...");
                $("#txtCidadeEndResid").val("...");
                $("#txtBairroEndResid").val("...");
                $("#txtCompEndResid").val("...");
                //Consulta o webservice viacep.com.br/
                $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {
                    if (!("erro" in dados)) {
                        if($("#txtEndCurso").val() == "resid"){
                            $("#txtCepEndCurso").val($("#txtCepEndResid").val());
                            $("#txtCepEndCurso").removeClass("is-invalid");
                            $("#txtCepEndCurso").addClass("is-valid");
                        }
                        //Atualiza os campos com os valores da consulta.
                        if(dados.logradouro != ""){
                            $("#txtNomeEndResid").val(dados.logradouro);
                            $("#txtNomeEndResid").removeClass("is-invalid");
                            $("#txtNomeEndResid").addClass("is-valid");

                            if($("#txtEndCurso").val() == "resid"){
                                $("#txtNomeEndCurso").val(dados.logradouro);
                                $("#txtNomeEndCurso").removeClass("is-invalid");
                                $("#txtNomeEndCurso").addClass("is-valid");
                            }
                        }
                        else{
                            $("#txtNomeEndResid").val('');
                            $("#txtNomeEndResid").removeClass("is-invalid");
                            $("#txtNomeEndResid").removeClass("is-valid");

                            if($("#txtEndCurso").val() == "resid"){
                                $("#txtNomeEndCurso").val('');
                                $("#txtNomeEndCurso").removeClass("is-invalid");
                                $("#txtNomeEndCurso").removeClass("is-valid");
                            }
                        }

                        if(dados.uf != ""){
                            $("#txtEstadoEndResid").val(dados.uf);
                            $("#txtEstadoEndResid").removeClass("is-invalid");
                            $("#txtEstadoEndResid").addClass("is-valid");

                            if($("#txtEndCurso").val() == "resid"){
                                $("#txtEstadoEndCurso").val(dados.uf);
                                $("#txtEstadoEndCurso").removeClass("is-invalid");
                                $("#txtEstadoEndCurso").addClass("is-valid");
                            }
                        }
                        else{
                            $("#txtEstadoEndResid").val('');
                            $("#txtEstadoEndResid").removeClass("is-invalid");
                            $("#txtEstadoEndResid").removeClass("is-valid");

                            if($("#txtEndCurso").val() == "resid"){
                                $("#txtEstadoEndCurso").val('');
                                $("#txtEstadoEndCurso").removeClass("is-invalid");
                                $("#txtEstadoEndCurso").removeClass("is-valid");
                            }
                        }

                        if(dados.localidade != ""){
                            $("#txtCidadeEndResid").val(dados.localidade);
                            $("#txtCidadeEndResid").removeClass("is-invalid");
                            $("#txtCidadeEndResid").addClass("is-valid");

                            if($("#txtEndCurso").val() == "resid"){
                                $("#txtCidadeEndCurso").val(dados.localidade);
                                $("#txtCidadeEndCurso").removeClass("is-invalid");
                                $("#txtCidadeEndCurso").addClass("is-valid");
                            }
                        }
                        else{
                            $("#txtCidadeEndResid").val('');
                            $("#txtCidadeEndResid").removeClass("is-invalid");
                            $("#txtCidadeEndResid").removeClass("is-valid");

                            if($("#txtEndCurso").val() == "resid"){
                                $("#txtCidadeEndCurso").val('');
                                $("#txtCidadeEndCurso").removeClass("is-invalid");
                                $("#txtCidadeEndCurso").removeClass("is-valid");
                            }
                        }                            

                        if(dados.bairro != ""){
                            $("#txtBairroEndResid").val(dados.bairro);
                            $("#txtBairroEndResid").removeClass("is-invalid");
                            $("#txtBairroEndResid").addClass("is-valid");

                            if($("#txtEndCurso").val() == "resid"){
                                $("#txtBairroEndCurso").val(dados.bairro);
                                $("#txtBairroEndCurso").removeClass("is-invalid");
                                $("#txtBairroEndCurso").addClass("is-valid");
                            }
                        }
                        else{
                            $("#txtBairroEndResid").val('');
                            $("#txtBairroEndResid").removeClass("is-invalid");
                            $("#txtBairroEndResid").removeClass("is-valid");

                            if($("#txtEndCurso").val() == "resid"){
                                $("#txtBairroEndCurso").val('');
                                $("#txtBairroEndCurso").removeClass("is-invalid");
                                $("#txtBairroEndCurso").removeClass("is-valid");
                            }
                        }                            

                        if(dados.complemento != ""){
                            $("#txtCompEndResid").val(dados.complemento);
                            $("#txtCompEndResid").removeClass("is-invalid");
                            $("#txtCompEndResid").addClass("is-valid");

                            if($("#txtEndCurso").val() == "resid"){
                                $("#txtCompEndCurso").val(dados.complemento);
                                $("#txtCompEndCurso").removeClass("is-invalid");
                                $("#txtCompEndCurso").addClass("is-valid");
                            }
                        }
                        else{
                            $("#txtCompEndResid").val('');
                            $("#txtCompEndResid").removeClass("is-invalid");
                            $("#txtCompEndResid").removeClass("is-valid");

                            if($("#txtEndCurso").val() == "resid"){
                                $("#txtCompEndCurso").val('');
                                $("#txtCompEndCurso").removeClass("is-invalid");
                                $("#txtCompEndCurso").removeClass("is-valid");
                            }
                        }
                    }
                    else {
                        //CEP pesquisado não foi encontrado.
                        limpa_formulário_cep();
                        $("#txtCepEndResid").removeClass("is-valid");
                        $("#txtCepEndResid").addClass("is-invalid");
                        $(".invalid-cep").html("CEP não encontrado!");
                    }
                });
            }
            else {
                //cep é inválido.
                limpa_formulário_cep();
                $("#txtCepEndResid").removeClass("is-valid");
                $("#txtCepEndResid").addClass("is-invalid");
                $(".invalid-cep").html("CEP Inválido!");;
            }
        }
        else {
            //cep sem valor, limpa formulário.
            limpa_formulário_cep();
        }
    });

    $("#txtNumEndResid").change(function(){
        num = $(this).val();
        if($("#txtEndCurso").val() == "resid"){
            if(num != ""){
                $("#txtNumEndCurso").val(num);
                $("#txtNumEndCurso").removeClass("is-invalid");
                $("#txtNumEndCurso").addClass("is-valid");
            }
            else{
                $("#txtNumEndCurso").val('');
                $("#txtNumEndCurso").removeClass("is-invalid");
                $("#txtNumEndCurso").removeClass("is-valid");
            }
        }
    });
});