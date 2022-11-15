package com.example.microservicoB.adapter.input.s3

import com.amazonaws.services.s3.AmazonS3
import com.example.microservicoB.adapter.input.feign.TransferenciaSqs
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.File

@Service
class S3Service(
    private val amazonS3: AmazonS3,
    private val objectMapper: ObjectMapper
) {

    @Value("\${bucket.name}")
    private lateinit var bucketName: String

    fun salvarReciboS3(transferenciaSqs: TransferenciaSqs): String {

        val recibo = File("recibo.txt")

        val reciboString = objectMapper.writeValueAsString(transferenciaSqs)
        recibo.writeText(reciboString)
        val key = "${transferenciaSqs.transferenciaId}.json"
        amazonS3.putObject(bucketName, key, recibo)

        return "s3://$bucketName/${key}"

    }
}