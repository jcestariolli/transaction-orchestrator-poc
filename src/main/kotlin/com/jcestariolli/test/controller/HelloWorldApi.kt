package com.jcestariolli.test.controller

import com.jcestariolli.test.controller.dto.response.BasicErrorResponseDto
import com.jcestariolli.test.controller.dto.response.HelloWorldResponseDto
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.tags.Tags
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Validated
@Tags(
    Tag(
        name = "Hello World API",
        description = "An API to say hello world and assure that everything is running!",
    )
)
@RestController
@RequestMapping("/hello-world")
class HelloWorldApi {

    @GetMapping(
        name = "Hello World Endpoint",
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
        return ResponseEntity.ok(HelloWorldResponseDto(message = "Success!"))
    }

}