package com.example

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [MainApplication::class])
class HelloTests {

    @Test
    fun test(){

    }

}