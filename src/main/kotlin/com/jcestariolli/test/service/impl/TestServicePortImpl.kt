package com.jcestariolli.test.service.impl

import com.jcestariolli.test.domain.Test
import com.jcestariolli.shared.exception.ResourceNotFoundException
import com.jcestariolli.test.persistence.TestRepositoryPort
import com.jcestariolli.test.service.TestServicePort
import org.springframework.stereotype.Service

@Service
class TestServicePortImpl(
    val testRepository: TestRepositoryPort
) : TestServicePort {
    @Throws(ResourceNotFoundException::class)
    override fun saveOrUpdate(test: Test): Test = testRepository.saveOrUpdate(test = test)

    override fun list(): List<Test>? = testRepository.list()

    @Throws(ResourceNotFoundException::class)
    override fun findTest(id: String): Test? = testRepository.findTest(id = id)

    @Throws(ResourceNotFoundException::class)
    override fun delete(id: String) = testRepository.delete(id = id)
}