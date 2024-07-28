package com.jcestariolli.test.controller.dto.response

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

@JsonInclude(JsonInclude.Include.NON_NULL)
data class HelloWorldResponseDto(
    @Schema(description = "Hello world message", example = "Hello World - Success!")
    @JsonProperty
    val message: String,
) {
    companion object
}