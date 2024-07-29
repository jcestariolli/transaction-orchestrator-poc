package com.jcestariolli.test.persistence.impl

import com.jcestariolli.test.domain.Test
import com.jcestariolli.shared.exception.ResourceNotFoundException
import com.jcestariolli.test.persistence.jpa.dao.fromDomain
import com.jcestariolli.test.persistence.jpa.dao.toDomain
import com.jcestariolli.test.persistence.TestRepositoryPort
import com.jcestariolli.test.persistence.jpa.TestRepositoryJpa
import com.jcestariolli.test.persistence.jpa.dao.TestDao
import org.springframework.stereotype.Component

@Component
class TestRepositoryPortImpl(
    val testRepositoryJpa: TestRepositoryJpa
) : TestRepositoryPort {
    override fun saveOrUpdate(test: Test): Test {
        test.id?.let {
            if (!testRepositoryJpa.existsById(it))
                throw ResourceNotFoundException(resourceName = "test", resourceId = it)
        }
        return testRepositoryJpa.save(TestDao.fromDomain(test)).toDomain()
    }

    override fun list(): List<Test>? =
        testRepositoryJpa.findAll().takeIf { it.isNotEmpty() }?.mapNotNull { it?.toDomain() }

    override fun findTest(id: String): Test? = testRepositoryJpa.findById(id).takeIf {
        it.isPresent
    }?.get()?.toDomain() ?: throw ResourceNotFoundException(
        resourceName = "test",
        resourceId = id
    )

    override fun delete(id: String) =
        testRepositoryJpa.findById(id).takeIf {
            it.isPresent
        }?.get()?.let {
            testRepositoryJpa.delete(it)
        } ?: throw ResourceNotFoundException(
            resourceName = "test",
            resourceId = id
        )

}