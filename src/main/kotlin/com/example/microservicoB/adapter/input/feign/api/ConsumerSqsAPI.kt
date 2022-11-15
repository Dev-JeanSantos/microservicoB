package com.example.microservicoB.adapter.input.feign.api

import com.example.microservicoB.adapter.input.feign.request.ConfirmaTransacaoRequest
import com.example.microservicoB.adapter.input.feign.response.ConfirmaTransacaoResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "transacaoClient", url = "http://localhost:8080")
interface ConsumerSqsAPI {

    @RequestMapping(method = [RequestMethod.POST], value = ["/v1/contas/confirmar_transferencias"], consumes = ["application/json"])
    fun enviaConfirmacao(@RequestBody
        confirmaTransacao: ConfirmaTransacaoRequest
    ): ConfirmaTransacaoResponse
}