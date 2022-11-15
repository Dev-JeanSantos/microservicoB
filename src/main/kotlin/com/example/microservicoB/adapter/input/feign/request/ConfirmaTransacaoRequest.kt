package com.example.microservicoB.adapter.input.feign.request

import com.fasterxml.jackson.annotation.JsonProperty

data class ConfirmaTransacaoRequest(
    var transferenciaId: String,
    var reciboS3: String
)