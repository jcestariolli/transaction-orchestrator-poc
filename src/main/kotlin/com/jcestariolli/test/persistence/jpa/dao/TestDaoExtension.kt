package com.jcestariolli.test.persistence.jpa.dao

import com.jcestariolli.test.domain.Test
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

fun TestDao.Companion.fromDomain(test: Test) = test.run {
    TestDao(
        id = id ?: UUID.randomUUID().toString(),
        textField = textField,
        booleanField = booleanField,
        decimalNumberField = decimalNumberField,
        dateField = dateField?.let { Date.from(it.atStartOfDay(ZoneId.systemDefault()).toInstant()) },
    )
}

fun TestDao.toDomain() = Test(
    id = id,
    textField = textField,
    booleanField = booleanField,
    decimalNumberField = decimalNumberField,
    dateField = dateField?.let { Instant.ofEpochMilli(it.time).atZone(ZoneId.systemDefault()).toLocalDate() },
)
