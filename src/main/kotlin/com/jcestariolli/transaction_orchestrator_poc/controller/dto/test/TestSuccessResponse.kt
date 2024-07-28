package com.jcestariolli.transaction_orchestrator_poc.controller.dto.test

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

@JsonInclude(JsonInclude.Include.NON_NULL)
data class TestSuccessResponse(
    @Schema(description = "Message of success", example = "Success!")
    @JsonProperty
    val message: String,
) {
    companion object
}