package com.example.microservicoB.application.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.services.sqs.AmazonSQSAsync
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class SQSConfig {

    @Value("\${amazon.dynamodb.endpoint:http://localhost:4566}")
    private lateinit var amazonDynamoDBEndpoint: String

    @Value("\${amazon.region:us-east-1}")
    private lateinit var amazonRegion: String

    @Value("\${amazon.aws.accesskey:desafio}")
    private lateinit var amazonAWSAccessKey: String

    @Value("\${amazon.aws.secretkey:desafio}")
    private lateinit var amazonAWSSecretKey: String


    @Bean
    @Primary
    fun amazonSQSAsync(): AmazonSQSAsync {
        return AmazonSQSAsyncClientBuilder.standard()
            .withEndpointConfiguration(EndpointConfiguration(amazonDynamoDBEndpoint, amazonRegion))
            .withCredentials(AWSStaticCredentialsProvider(BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey)))
            .build()
    }

    @Bean
    fun queueMessagingTemplate(): QueueMessagingTemplate {
        return QueueMessagingTemplate(amazonSQSAsync())
    }

    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper()
    }
}