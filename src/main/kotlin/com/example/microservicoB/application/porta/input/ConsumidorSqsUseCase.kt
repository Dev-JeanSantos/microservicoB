package com.example.microservicoB.application.porta.input

import com.example.microservicoB.adapter.input.feign.request.ConfirmaTransacaoRequest
import com.example.microservicoB.adapter.input.feign.response.ConfirmaTransacaoResponse

interface ConsumidorSqsUseCase {
    fun enviandoConfirmacaoTransferencia(confirmaTransacao: ConfirmaTransacaoRequest): ConfirmaTransacaoResponse
}