package com.jcestariolli.test.controller

import com.jcestariolli.test.controller.dto.request.TestRequestDto
import com.jcestariolli.test.controller.dto.response.BasicErrorResponseDto
import com.jcestariolli.test.controller.dto.response.TestResponseDto
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.tags.Tags
import jakarta.validation.Valid
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

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
        name = "List all tests",
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
    fun getTests(): ResponseEntity<List<TestResponseDto>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @GetMapping(
        name = "Get test by id",
        value = ["/{id}"],
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
    fun getTest(
        @NotNull @PathVariable("id") testId: String
    ): ResponseEntity<TestResponseDto> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @PostMapping(
        name = "Create a new test",
        consumes = ["application/json"],
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
    fun createTest(
        @Valid @RequestBody test: TestRequestDto
    ): ResponseEntity<TestResponseDto> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @PutMapping(
        name = "Update test by id",
        value = ["/{id}"],
        consumes = ["application/json"],
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
    fun updateTest(
        @NotNull @PathVariable("id") testId: String,
        @Valid @RequestBody test: TestRequestDto
    ): ResponseEntity<TestResponseDto> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}