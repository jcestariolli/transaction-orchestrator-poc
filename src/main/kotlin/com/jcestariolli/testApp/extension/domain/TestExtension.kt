package com.jcestariolli.testApp.extension.domain

import com.jcestariolli.testApp.controller.dto.request.TestRequestDto
import com.jcestariolli.testApp.controller.dto.response.TestResponseDto
import com.jcestariolli.testApp.domain.Test

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

