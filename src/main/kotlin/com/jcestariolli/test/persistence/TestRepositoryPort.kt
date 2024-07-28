package com.jcestariolli.test.persistence

import com.jcestariolli.test.domain.Test

interface TestRepositoryPort {

    fun saveOrUpdate(test: Test): Test

    fun list(): List<Test>?

    fun findTest(id: String): Test?

    fun delete(id: String)

}