package com.example.microservicoB

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableSqs
@EnableFeignClients
class MicroservicoBApplication

fun main(args: Array<String>) {
	runApplication<MicroservicoBApplication>(*args)
}
