package com.jcestariolli.demo.persistence

import com.jcestariolli.demo.domain.Demo

interface DemoRepositoryPort {

    fun saveOrUpdate(demo: Demo): Demo

    fun list(): List<Demo>?

    fun findBy(id: String): Demo?

    fun delete(id: String)

}