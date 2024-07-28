package com.jcestariolli.test.service

import com.jcestariolli.test.domain.Test

interface TestServicePort{

    fun saveOrUpdate(test: Test): Test

    fun list(): List<Test>?

    fun findTest(id: String): Test?

    fun delete(id: String)
}