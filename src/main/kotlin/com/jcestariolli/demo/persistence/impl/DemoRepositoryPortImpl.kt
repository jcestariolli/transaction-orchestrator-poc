package com.jcestariolli.demo.persistence.impl

import com.jcestariolli.demo.domain.Demo
import com.jcestariolli.shared.exception.ResourceNotFoundException
import com.jcestariolli.demo.persistence.jpa.dao.extension.fromDomain
import com.jcestariolli.demo.persistence.jpa.dao.extension.toDomain
import com.jcestariolli.demo.persistence.DemoRepositoryPort
import com.jcestariolli.demo.persistence.jpa.DemoRepositoryJpa
import com.jcestariolli.demo.persistence.jpa.dao.DemoDao
import org.springframework.stereotype.Component

@Component
class DemoRepositoryPortImpl(
    val demoRepositoryJpa: DemoRepositoryJpa
) : DemoRepositoryPort {

    private val resourceName = "demo"
    override fun saveOrUpdate(demo: Demo): Demo {
        demo.id?.let {
            if (!demoRepositoryJpa.existsById(it))
                throw ResourceNotFoundException(resourceName = resourceName, resourceId = it)
        }
        return demoRepositoryJpa.save(DemoDao.fromDomain(demo)).toDomain()
    }

    override fun list(): List<Demo>? =
        demoRepositoryJpa.findAll().takeIf { it.isNotEmpty() }?.mapNotNull { it?.toDomain() }

    override fun findTest(id: String): Demo? = demoRepositoryJpa.findById(id).takeIf {
        it.isPresent
    }?.get()?.toDomain() ?: throw ResourceNotFoundException(
        resourceName = resourceName,
        resourceId = id
    )

    override fun delete(id: String) =
        demoRepositoryJpa.findById(id).takeIf {
            it.isPresent
        }?.get()?.let {
            demoRepositoryJpa.delete(it)
        } ?: throw ResourceNotFoundException(
            resourceName = resourceName,
            resourceId = id
        )

}