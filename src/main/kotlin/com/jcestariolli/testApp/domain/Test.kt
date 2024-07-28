package com.jcestariolli.testApp.domain

import java.math.BigDecimal
import java.util.*

data class Test(
    val id: String? = null,
    val textField: String? = null,
    val booleanField: Boolean? = null,
    val decimalNumberField: BigDecimal? = null,
    val dateField: Date? = null,
) {
    companion object
}