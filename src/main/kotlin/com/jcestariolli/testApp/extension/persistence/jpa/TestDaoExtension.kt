package com.jcestariolli.testApp.extension.persistence.jpa

import com.jcestariolli.testApp.domain.Test
import com.jcestariolli.testApp.persistence.jpa.dao.TestDao

fun TestDao.fromDomain(test: Test) = test.run {
    TestDao(
        id = null,
        textField = textField,
        booleanField = booleanField,
        decimalNumberField = decimalNumberField,
        dateField = dateField,
    )
}