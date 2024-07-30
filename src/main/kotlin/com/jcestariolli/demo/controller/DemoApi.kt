package com.jcestariolli.demo.controller

import com.jcestariolli.demo.controller.dto.request.DemoRequestDto
import com.jcestariolli.demo.controller.dto.response.BasicErrorResponseDto
import com.jcestariolli.demo.controller.dto.response.DemoResponseDto
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
        name = "Demo API",
        description = "An API to expose commands to deal with demo resources",
    )
)
@RequestMapping("/demo")
interface DemoApi {

    @GetMapping(
        name = "List all demos",
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
    fun getDemos(): ResponseEntity<List<DemoResponseDto>> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @GetMapping(
        name = "Get demo by id",
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
    fun getDemo(
        @NotNull @PathVariable("id") demoId: String
    ): ResponseEntity<DemoResponseDto> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @PostMapping(
        name = "Create a new demo",
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
    fun createDemo(
        @Valid @RequestBody demoRequestBody: DemoRequestDto
    ): ResponseEntity<DemoResponseDto> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @PutMapping(
        name = "Update demo by id",
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
    fun updateDemo(
        @NotNull @PathVariable("id") demoId: String,
        @Valid @RequestBody demoRequestBody: DemoRequestDto
    ): ResponseEntity<DemoResponseDto> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

}