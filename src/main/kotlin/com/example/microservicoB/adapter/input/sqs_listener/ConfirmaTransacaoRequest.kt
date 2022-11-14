package com.example.microservicoB.adapter.input.sqs_listener

import com.fasterxml.jackson.annotation.JsonProperty

data class ConfirmaTransacaoRequest(
    @JsonProperty("transferencia_id")
    val transferenciaId: String,
    @JsonProperty("recibo_s3")
    val reciboS3: String
)