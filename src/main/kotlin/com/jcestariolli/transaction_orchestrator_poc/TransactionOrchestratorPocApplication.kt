package com.jcestariolli.transaction_orchestrator_poc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.jcestariolli"])
class TransactionOrchestratorPocApplication

fun main(args: Array<String>) {
	runApplication<TransactionOrchestratorPocApplication>(*args)
}
