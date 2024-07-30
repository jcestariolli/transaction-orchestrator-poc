package com.jcestariolli.demo.persistence.jpa.dao.extension

import com.jcestariolli.demo.domain.Demo
import com.jcestariolli.demo.persistence.jpa.dao.DemoDao
import java.time.Instant
import java.time.ZoneId
import java.util.*

fun DemoDao.Companion.fromDomain(demo: Demo) = demo.run {
    DemoDao(
        id = id ?: UUID.randomUUID().toString(),
        textField = textField,
        booleanField = booleanField,
        decimalNumberField = decimalNumberField,
        dateField = dateField?.let { Date.from(it.atStartOfDay(ZoneId.systemDefault()).toInstant()) },
    )
}

fun DemoDao.toDomain() = Demo(
    id = id,
    textField = textField,
    booleanField = booleanField,
    decimalNumberField = decimalNumberField,
    dateField = dateField?.let { Instant.ofEpochMilli(it.time).atZone(ZoneId.systemDefault()).toLocalDate() },
)
