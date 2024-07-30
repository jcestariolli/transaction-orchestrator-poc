package com.jcestariolli.demo.domain.extension

import com.jcestariolli.demo.controller.dto.request.DemoRequestDto
import com.jcestariolli.demo.controller.dto.response.DemoResponseDto
import com.jcestariolli.demo.domain.Demo

fun Demo.toDto(): DemoResponseDto = DemoResponseDto(
    id = id ?: "",
    textField = textField,
    booleanField = booleanField,
    decimalNumberField = decimalNumberField,
    dateField = dateField,
)

fun Demo.Companion.fromDto(
    id: String? = null, requestDto: DemoRequestDto
) = requestDto.run {
    Demo(
        id = id,
        textField = textField,
        booleanField = booleanField,
        decimalNumberField = decimalNumberField,
        dateField = dateField,
    )
}

