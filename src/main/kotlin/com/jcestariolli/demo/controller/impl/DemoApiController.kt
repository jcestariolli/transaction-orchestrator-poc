package com.jcestariolli.demo.controller.impl

import com.jcestariolli.demo.controller.DemoApi
import com.jcestariolli.demo.controller.dto.request.DemoRequestDto
import com.jcestariolli.demo.controller.dto.response.DemoResponseDto
import com.jcestariolli.demo.domain.Demo
import com.jcestariolli.demo.domain.extension.fromDto
import com.jcestariolli.demo.domain.extension.toDto
import com.jcestariolli.demo.service.DemoServicePort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoApiController(
    val demoService: DemoServicePort
) : DemoApi {
    override fun getDemos(): ResponseEntity<List<DemoResponseDto>> =
        demoService.list()?.map { it.toDto() }?.let { ResponseEntity.ok(it) } ?: ResponseEntity.ok(emptyList())

    override fun getDemo(demoId: String): ResponseEntity<DemoResponseDto> =
        demoService.findDemo(id = demoId)?.let { ResponseEntity.ok(it.toDto()) } ?: ResponseEntity(HttpStatus.NOT_FOUND)

    override fun createDemo(demoRequestBody: DemoRequestDto): ResponseEntity<DemoResponseDto> =
        demoService.saveOrUpdate(demo = Demo.fromDto(requestDto = demoRequestBody))
            .let { ResponseEntity.ok(it.toDto()) }

    override fun updateDemo(demoId: String, demoRequestBody: DemoRequestDto): ResponseEntity<DemoResponseDto> =
        demoService.saveOrUpdate(demo = Demo.fromDto(id = demoId, requestDto = demoRequestBody))
            .let { ResponseEntity.ok(it.toDto()) }

}