package com.jcestariolli.test.extension.persistence.jpa

import com.jcestariolli.test.domain.Test
import com.jcestariolli.test.persistence.jpa.dao.TestDao

fun TestDao.fromDomain(test: Test) = test.run {
    TestDao(
        id = null,
        textField = textField,
        booleanField = booleanField,
        decimalNumberField = decimalNumberField,
        dateField = dateField,
    )
}