package com.example.microservicoB.adapter.input.sqs_listener

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "transacaoClient", url = "http://localhost:8080")
interface MicrosservicoAAPI {

    @RequestMapping(method = [RequestMethod.POST], value = ["/v1/contas/confirmar_transferencias"], consumes = ["application/json"])
    fun enviaConfirmacao(
        confirmaTransacao: ConfirmaTransacaoRequest
    ): ConfirmaTransacaoResponse
}