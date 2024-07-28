package com.jcestariolli.testApp.service

import com.jcestariolli.testApp.domain.Test

interface TestServicePort{

    fun saveOrUpdate(test: Test): Test

    fun list(): List<Test>?

    fun findTest(id: String): Test?

    fun delete(id: String)
}