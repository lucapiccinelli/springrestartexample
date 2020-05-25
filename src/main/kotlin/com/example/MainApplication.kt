package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class MainApplication

fun main(args: Array<String>){
    runApplication<MainApplication>(*args)
}

@RestController
class HelloController(){
    var counter = 0

    @GetMapping("hello")
    fun get() = "Ok ${counter++}"

}