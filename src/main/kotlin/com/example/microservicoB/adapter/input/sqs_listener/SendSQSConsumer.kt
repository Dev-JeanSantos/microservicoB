package com.example.microservicoB.adapter.input.sqs_listener

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.stereotype.Component

@Component
class SendSQSConsumer(
    private val objectMapper: ObjectMapper,
    private val microsservicoAAPI: MicrosservicoAAPI

) {

    @SqsListener("data-sqs")
    fun resourcesMessage(mensagem:String){
        val transferenciaSqs = objectMapper.readValue(mensagem, TransferenciaSqs::class.java)

        println(transferenciaSqs.valor)

        val possivel = ConfirmaTransacaoRequest(transferenciaSqs.transferenciaId, "qualquer_coisa")
        println(possivel)
        microsservicoAAPI.enviaConfirmacao(possivel)
    }
}