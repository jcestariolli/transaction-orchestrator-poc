package com.jcestariolli.test.extension.domain

import com.jcestariolli.test.controller.dto.request.TestRequestDto
import com.jcestariolli.test.controller.dto.response.TestResponseDto
import com.jcestariolli.test.domain.Test

fun Test.toDto() : TestResponseDto = TestResponseDto(
    id = id?: "",
    textField = textField,
    booleanField = booleanField,
    decimalNumberField = decimalNumberField,
    dateField = dateField,
)

fun Test.Companion.fromDto(requestDto: TestRequestDto) = requestDto.run {
    Test(
        id = null,
        textField = textField,
        booleanField = booleanField,
        decimalNumberField = decimalNumberField,
        dateField = dateField,
    )
}

