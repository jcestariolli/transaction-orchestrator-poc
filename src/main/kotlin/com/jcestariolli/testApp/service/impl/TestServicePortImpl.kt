package com.jcestariolli.testApp.service.impl

import com.jcestariolli.testApp.domain.Test
import com.jcestariolli.testApp.persistence.TestRepositoryPort
import com.jcestariolli.testApp.service.TestServicePort
import org.springframework.stereotype.Service

@Service
class TestServicePortImpl(
    testRepositoryPort: TestRepositoryPort
) : TestServicePort {
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