package com.jcestariolli.test.controller.dto.response

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

@JsonInclude(JsonInclude.Include.NON_NULL)
data class BasicErrorResponseDto(
    @Schema(description = "HTTP status code", example = "x00")
    @JsonProperty
    val code: String,
    @Schema(description = "Error description", example = "Example of message")
    @JsonProperty
    val message: String,
) {
    companion object
}