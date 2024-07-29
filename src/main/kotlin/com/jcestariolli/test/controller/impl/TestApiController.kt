package com.jcestariolli.test.controller.impl

import com.jcestariolli.test.controller.TestApi
import com.jcestariolli.test.controller.dto.request.TestRequestDto
import com.jcestariolli.test.controller.dto.response.TestResponseDto
import com.jcestariolli.test.domain.Test
import com.jcestariolli.test.domain.fromDto
import com.jcestariolli.test.domain.toDto
import com.jcestariolli.test.service.TestServicePort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class TestApiController(
    val testService: TestServicePort
) : TestApi {
    override fun getTests(): ResponseEntity<List<TestResponseDto>> =
        testService.list()?.map { it.toDto() }?.let { ResponseEntity.ok(it) } ?: ResponseEntity.ok(emptyList())

    override fun getTest(testId: String): ResponseEntity<TestResponseDto> =
        testService.findTest(id = testId)?.let { ResponseEntity.ok(it.toDto()) } ?: ResponseEntity(HttpStatus.NOT_FOUND)

    override fun createTest(test: TestRequestDto): ResponseEntity<TestResponseDto> =
        testService.saveOrUpdate(test = Test.fromDto(requestDto = test)).let { ResponseEntity.ok(it.toDto()) }

    override fun updateTest(testId: String, test: TestRequestDto): ResponseEntity<TestResponseDto> =
        testService.saveOrUpdate(test = Test.fromDto(id = testId, requestDto = test))
            .let { ResponseEntity.ok(it.toDto()) }

}