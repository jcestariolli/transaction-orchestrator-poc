package com.jcestariolli.test.domain

import com.jcestariolli.test.controller.dto.request.TestRequestDto
import com.jcestariolli.test.controller.dto.response.TestResponseDto

fun Test.toDto(): TestResponseDto = TestResponseDto(
    id = id ?: "",
    textField = textField,
    booleanField = booleanField,
    decimalNumberField = decimalNumberField,
    dateField = dateField,
)

fun Test.Companion.fromDto(
    id: String? = null, requestDto: TestRequestDto
) = requestDto.run {
    Test(
        id = id,
        textField = textField,
        booleanField = booleanField,
        decimalNumberField = decimalNumberField,
        dateField = dateField,
    )
}

