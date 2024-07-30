package com.jcestariolli.demo.service.impl

import com.jcestariolli.demo.domain.Demo
import com.jcestariolli.shared.exception.ResourceNotFoundException
import com.jcestariolli.demo.persistence.DemoRepositoryPort
import com.jcestariolli.demo.service.DemoServicePort
import org.springframework.stereotype.Service

@Service
class DemoServiceImpl(
    val demoRepository: DemoRepositoryPort
) : DemoServicePort {
    @Throws(ResourceNotFoundException::class)
    override fun saveOrUpdate(demo: Demo): Demo = demoRepository.saveOrUpdate(demo = demo)

    override fun list(): List<Demo>? = demoRepository.list()

    @Throws(ResourceNotFoundException::class)
    override fun findDemo(id: String): Demo? = demoRepository.findBy(id = id)

    @Throws(ResourceNotFoundException::class)
    override fun delete(id: String) = demoRepository.delete(id = id)
}