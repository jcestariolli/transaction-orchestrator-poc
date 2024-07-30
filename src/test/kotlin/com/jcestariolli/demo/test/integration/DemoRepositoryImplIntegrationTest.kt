package com.jcestariolli.demo.test.integration

import com.jcestariolli.demo.domain.Demo
import com.jcestariolli.demo.persistence.impl.DemoRepositoryImpl
import com.jcestariolli.demo.persistence.jpa.dao.DemoDao
import com.jcestariolli.demo.persistence.jpa.dao.extension.fromDomain
import com.jcestariolli.demo.persistence.jpa.dao.extension.toDomain
import com.jcestariolli.demo.test.faker.mock.domain.fake
import com.jcestariolli.demo.test.faker.utils.localizedFaker
import com.jcestariolli.shared.exception.ResourceNotFoundException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ActiveProfiles
import kotlin.test.assertEquals
import kotlin.test.assertNull

@ActiveProfiles("test")
@DataJpaTest
internal class DemoRepositoryImplIntegrationTest(
    @Autowired
    val testEntityManager: TestEntityManager,
    @Autowired
    val demoRepository: DemoRepositoryImpl
) {

    @Test
    fun `list - should return null when respository is empty`() {
        assertNull(demoRepository.list())
    }

    @Test
    fun `list - should return Demo list when repository has data`() {
        val demoMockList = List(localizedFaker.random.nextInt(min = 1, max = 10)) {
            Demo.fake()
        }.sortedBy { it.id }
        demoMockList.forEach {
            testEntityManager.persist(DemoDao.fromDomain(it))
        }

        val demoResultList = demoRepository.list()?.sortedBy { it.id }

        assertEquals(demoResultList?.size, demoMockList.size)
        assertThat(demoResultList).usingRecursiveComparison().isEqualTo(demoMockList)
    }

    @Test
    fun `findBy - should find Demo by id`() {
        val demoMock = Demo.fake()
        testEntityManager.persist(DemoDao.fromDomain(demoMock))
        val result = demoRepository.findBy(id = demoMock.id ?: "")

        assertThat(result).usingRecursiveComparison().isEqualTo(demoMock)
    }

    @Test
    fun `findBy - should throw ResourceNotFoundException when Demo id does not exist`() {
        assertThrows<ResourceNotFoundException> {
            demoRepository.findBy(id = localizedFaker.random.nextUUID())
        }
    }

    @Test
    fun `save - should save new Demo`() {
        val demoMock = Demo.fake(id = null)
        val result = demoRepository.saveOrUpdate(demo = demoMock)
        val persistedResult = testEntityManager.find(DemoDao::class.java, result.id).toDomain()

        assertThat(result).usingRecursiveComparison().ignoringFields("id").isEqualTo(demoMock)
        assertThat(persistedResult).usingRecursiveComparison().isEqualTo(result)
    }

    @Test
    fun `save - should update Demo when it exists in repository`() {
        val demoMock = Demo.fake()
        val updatedDemoMock = demoMock.copy(textField = localizedFaker.bojackHorseman.quotes())
        testEntityManager.persist(DemoDao.fromDomain(demoMock))

        val updatedResult = demoRepository.saveOrUpdate(demo = updatedDemoMock)
        val persistedResult = testEntityManager.find(DemoDao::class.java, updatedDemoMock.id).toDomain()

        assertThat(updatedResult).usingRecursiveComparison().isEqualTo(updatedDemoMock)
        assertThat(persistedResult).usingRecursiveComparison().isEqualTo(updatedDemoMock)
    }

    @Test
    fun `save - should throw ResourceNotFoundException whe Demo does not exist in repository`() {
        assertThrows<ResourceNotFoundException> {
            demoRepository.saveOrUpdate(demo = Demo.fake())
        }
    }

}