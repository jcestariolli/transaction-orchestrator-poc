package com.jcestariolli.testApp.persistence

import com.jcestariolli.testApp.domain.Test

interface TestRepositoryPort {

    fun saveOrUpdate(test: Test): Test

    fun list(): List<Test>?

    fun findTest(id: String): Test?

    fun delete(id: String)

}