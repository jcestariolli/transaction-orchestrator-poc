package com.jcestariolli.demo.service

import com.jcestariolli.demo.domain.Demo

interface DemoServicePort{

    fun saveOrUpdate(demo: Demo): Demo

    fun list(): List<Demo>?

    fun findDemo(id: String): Demo?

    fun delete(id: String)
}