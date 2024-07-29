package com.jcestariolli.test.domain

import java.math.BigDecimal
import java.time.LocalDate

data class Test(
    val id: String? = null,
    val textField: String? = null,
    val booleanField: Boolean? = null,
    val decimalNumberField: BigDecimal? = null,
    val dateField: LocalDate? = null,
) {
    companion object
}