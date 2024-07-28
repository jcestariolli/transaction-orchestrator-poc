package com.jcestariolli.test.controller.dto.request

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class TestRequestDto(

    @Schema(description = "A field to test text values", example = "Some text goes here", required = false)
    @JsonProperty(required = false)
    val textField: String? = null,

    @Schema(description = "A field to test boolean values", example = "true", required = false)
    @JsonProperty(required = false)
    val booleanField: Boolean? = null,

    @Schema(description = "A field to test decimal number values", example = "1.00", required = false)
    @JsonProperty(required = false)
    // TODO formatter / desserializer
    val decimalNumberField: BigDecimal? = null,

    @Schema(description = "A field to test date values", example = "2024-07-26", required = false)
    @JsonProperty(required = false)
    // TODO formatter / desserializer
    val dateField: Date? = null,
) {
    companion object
}