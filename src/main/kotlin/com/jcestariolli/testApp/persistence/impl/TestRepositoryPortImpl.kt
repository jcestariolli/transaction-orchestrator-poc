package com.jcestariolli.testApp.persistence.impl

import com.jcestariolli.testApp.domain.Test
import com.jcestariolli.testApp.persistence.TestRepositoryPort
import com.jcestariolli.testApp.persistence.jpa.TestRepositoryJpa
import org.springframework.stereotype.Component

@Component
class TestRepositoryPortImpl(
    val testRepositoryJpa: TestRepositoryJpa
): TestRepositoryPort {
    override fun saveOrUpdate(test: Test): Test {
        TODO("Not yet implemented")
    }

    override fun list(): List<Test>? {
        TODO("Not yet implemented")
    }

    override fun findTest(id: String): Test? {
        TODO("Not yet implemented")
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }
}