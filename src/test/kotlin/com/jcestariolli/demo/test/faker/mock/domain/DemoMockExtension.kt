package com.jcestariolli.demo.test.faker.mock.domain

import com.jcestariolli.demo.domain.Demo
import com.jcestariolli.demo.test.faker.utils.localizedFaker
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate

fun Demo.Companion.fake(
    id: String? = localizedFaker.random.nextUUID(),
    textField: String? = localizedFaker.lovecraft.words(),
    booleanField: Boolean? = localizedFaker.random.nextBoolean(),
    decimalNumberField: BigDecimal? = localizedFaker.random.nextFloat().toBigDecimal(),
    dateField: LocalDate? = LocalDate.now(),
) = Demo(
    id = id,
    textField = textField,
    booleanField = booleanField,
    decimalNumberField = decimalNumberField?.setScale(2, RoundingMode.HALF_EVEN),
    dateField = dateField
)