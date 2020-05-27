package com.example

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.boot.SpringApplication
import org.springframework.boot.runApplication
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject
import kotlin.random.Random

class HelloTests {

    @Test
    fun `GIVEN springboot in certain state WHEN a restart happens THEN it should preserve the state`(){
        val restTemplate = TestRestTemplate()
        var webserverPort = Random.nextInt(10000, 10100)

        val appContext = SpringApplication.run(MainApplication::class.java, "--server.port=$webserverPort")
        restTemplate.getForObject<String>("http://localhost:$webserverPort/hello") shouldBe "Ok 0"

        appContext.registerShutdownHook()

        webserverPort = Random.nextInt(10000, 10100)
        val newContext = SpringApplication.run(MainApplication::class.java, "--server.port=$webserverPort")
        restTemplate.getForObject<String>("http://localhost:$webserverPort/hello") shouldBe "Ok 1"

        newContext.registerShutdownHook()
    }
}