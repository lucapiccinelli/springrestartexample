package com.example

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [MainApplication::class])
class HelloTests(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `GIVEN springboot in certain state WHEN a restart happens THEN it should preserve the state`(){
        restTemplate.getForObject<String>("/hello") shouldBe "Ok 0"

        restart()

        restTemplate.getForObject<String>("/hello") shouldBe "Ok 1"
    }
}