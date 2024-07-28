package com.jcestariolli.transaction_orchestrator_poc.controller

import com.jcestariolli.transaction_orchestrator_poc.controller.dto.BasicErrorResponse
import com.jcestariolli.transaction_orchestrator_poc.controller.dto.test.TestSuccessResponse
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.tags.Tags
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Validated
@Tags(
    Tag(
        name = "TransactionOrchestratorApi",
        description = "An API to expose commands to deal with transactions",
    )
)
@RequestMapping("/transactions")
interface TransactionOrchestratorApi {

    @GetMapping(
        name = "Test request - First endpoint!",
        value = ["/test"],
        produces = ["application/json"],
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200"),
            ApiResponse(
                responseCode = "4xx",
                content = [Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = Schema(implementation = BasicErrorResponse::class)
                )]
            ),
            ApiResponse(
                responseCode = "5xx",
                content = [Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = Schema(implementation = BasicErrorResponse::class)
                )]
            ),
        ]
    )
    fun getTestEndpoint(): ResponseEntity<TestSuccessResponse> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}