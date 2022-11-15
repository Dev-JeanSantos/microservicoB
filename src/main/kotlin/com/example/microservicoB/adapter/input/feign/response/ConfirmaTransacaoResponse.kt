package com.example.microservicoB.adapter.input.feign.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ConfirmaTransacaoResponse (
    @JsonProperty("mensagem")
    var mensagem: String
)