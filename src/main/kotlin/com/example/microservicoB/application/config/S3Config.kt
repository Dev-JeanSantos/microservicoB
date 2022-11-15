package com.example.microservicoB.application.config

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AWSConfig {

    @Value("\${amazon.dynamodb.endpoint:http://localhost:4566}")
    private lateinit var amazonDynamoDBEndpoint: String

    @Value("\${amazon.region:us-east-1}")
    private lateinit var amazonRegion: String

    @Value("\${amazon.aws.accesskey:desafio}")
    private lateinit var amazonAWSAccessKey: String

    @Value("\${amazon.aws.secretkey:desafio}")
    private lateinit var amazonAWSSecretKey: String

    fun credentials(): AWSCredentials {
        return BasicAWSCredentials(amazonAWSAccessKey,amazonAWSSecretKey)
    }

    @Bean
    fun amazonS3(): AmazonS3 {
        return AmazonS3ClientBuilder
            .standard().withEndpointConfiguration(
                    AwsClientBuilder.EndpointConfiguration(
                            amazonDynamoDBEndpoint,
                            amazonRegion
                    )
            )
            .enablePathStyleAccess()
            .withCredentials(AWSStaticCredentialsProvider(credentials()))
            .build()
    }
}