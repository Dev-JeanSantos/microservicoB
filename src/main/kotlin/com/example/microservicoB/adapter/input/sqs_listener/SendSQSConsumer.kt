package com.example.microservicoB.adapter.input.sqs_listener

import com.example.microservicoB.adapter.input.feign.TransferenciaSqs
import com.example.microservicoB.adapter.input.feign.api.ConsumerSqsAPI
import com.example.microservicoB.adapter.input.feign.request.ConfirmaTransacaoRequest
import com.example.microservicoB.adapter.input.s3.S3Service
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener
import org.springframework.stereotype.Component

@Component
class SendSQSConsumer(
    private val objectMapper: ObjectMapper,
    private val microsservicoAAPI: ConsumerSqsAPI,
    private val s3Service: S3Service


) {

    @SqsListener("data-sqs")
    fun resourcesMessage(mensagem:String){
        val transferenciaSqs = objectMapper.readValue(mensagem, TransferenciaSqs::class.java)
        val caminhoS3 = s3Service.salvarReciboS3(transferenciaSqs)
        val possivel = ConfirmaTransacaoRequest(transferenciaSqs.transferenciaId, caminhoS3)
        println(possivel)
        microsservicoAAPI.enviaConfirmacao(possivel)
    }
}