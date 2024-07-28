package com.jcestariolli.testApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.jcestariolli"])
class TestApplication

fun main(args: Array<String>) {
	runApplication<TestApplication>(*args)
}
