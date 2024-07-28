package com.jcestariolli.transaction_orchestrator_poc.controller.impl

import com.jcestariolli.transaction_orchestrator_poc.controller.TransactionOrchestratorApi
import com.jcestariolli.transaction_orchestrator_poc.controller.dto.test.TestSuccessResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class TransactionOrchestratorApiController : TransactionOrchestratorApi {
    override fun getTestEndpoint(): ResponseEntity<TestSuccessResponse> {
        return ResponseEntity.ok(TestSuccessResponse(message = "Test Success!"))

    }
}