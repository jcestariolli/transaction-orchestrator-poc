package com.jcestariolli.testApp.controller

import com.jcestariolli.testApp.controller.dto.response.BasicErrorResponseDto
import com.jcestariolli.testApp.controller.dto.response.HelloWorldResponseDto
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
        name = "Test API",
        description = "An API to expose commands to deal with tests resources",
    )
)
@RequestMapping("/test")
interface TestApi {

    @GetMapping(
        name = "Hello World for Test API",
        value = ["/hello-world"],
        produces = ["application/json"],
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200"),
            ApiResponse(
                responseCode = "4xx",
                content = [Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = Schema(implementation = BasicErrorResponseDto::class)
                )]
            ),
            ApiResponse(
                responseCode = "5xx",
                content = [Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = Schema(implementation = BasicErrorResponseDto::class)
                )]
            ),
        ]
    )
    fun getHelloWorld(): ResponseEntity<HelloWorldResponseDto> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}