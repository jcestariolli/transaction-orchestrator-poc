package com.jcestariolli.test.mock.extension.domain

import com.jcestariolli.test.domain.Test
import com.jcestariolli.test.mock.extension.localizedFaker
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate

fun Test.Companion.fake(
    id: String? = localizedFaker.random.nextUUID(),
    textField: String? = localizedFaker.lovecraft.words(),
    booleanField: Boolean? = localizedFaker.random.nextBoolean(),
    decimalNumberField: BigDecimal? = localizedFaker.random.nextFloat().toBigDecimal(),
    dateField: LocalDate? = LocalDate.now(),
) = Test(
    id = id,
    textField = textField,
    booleanField = booleanField,
    decimalNumberField = decimalNumberField?.setScale(2, RoundingMode.HALF_EVEN),
    dateField = dateField
)