package com.example

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.boot.runApplication
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject
import kotlin.random.Random

class HelloTests {

    @Test
    fun `GIVEN springboot in certain state WHEN a restart happens THEN it should preserve the state`(){
        val restTemplate = TestRestTemplate()
        val webserverPort = Random.nextInt(10000, 10100)
        val appContext = runApplication<MainApplication>("--server.port=$webserverPort")

        restTemplate.getForObject<String>("http://localhost:$webserverPort/hello") shouldBe "Ok 0"

        appContext.close()
        runApplication<MainApplication>("--server.port=$webserverPort")

        restTemplate.getForObject<String>("http://localhost:$webserverPort/hello") shouldBe "Ok 1"

        appContext.close()
    }
}