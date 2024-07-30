package com.jcestariolli.demo.domain

import java.math.BigDecimal
import java.time.LocalDate

data class Demo(
    val id: String? = null,
    val textField: String? = null,
    val booleanField: Boolean? = null,
    val decimalNumberField: BigDecimal? = null,
    val dateField: LocalDate? = null,
) {
    companion object
}