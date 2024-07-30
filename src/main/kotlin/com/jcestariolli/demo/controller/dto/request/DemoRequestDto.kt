package com.jcestariolli.demo.controller.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class DemoRequestDto(

    @Schema(description = "A field to test text values", example = "Some text goes here", required = false)
    @JsonProperty(required = false)
    val textField: String? = null,

    @Schema(description = "A field to test boolean values", example = "true", required = false)
    @JsonProperty(required = false)
    val booleanField: Boolean? = null,

    @Schema(description = "A field to test decimal number values", example = "123.45", required = false)
    @JsonProperty(required = false)
    val decimalNumberField: BigDecimal? = null,

    @Schema(description = "A field to test date values", example = "2024-07-26", required = false)
    @JsonProperty(required = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    val dateField: LocalDate? = null,
) {
    companion object
}