package com.example.microservicoB.adapter.input.feign

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class TransferenciaSqs (
        @JsonProperty("valor")
        var valor: BigDecimal,
        @JsonProperty("contaDebito")
        var contaDebito: String = "",
        @JsonProperty("contaCredito")
        var contaCredito: String,
        @JsonProperty("transferenciaId")
        var transferenciaId: String,
){
        init {
            this.transferenciaId = this.transferenciaId.split("_").last()
        }
}