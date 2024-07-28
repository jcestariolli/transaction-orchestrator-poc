package com.jcestariolli.test.controller.impl

import com.jcestariolli.test.controller.TestApi
import com.jcestariolli.test.controller.dto.response.HelloWorldResponseDto
import com.jcestariolli.test.service.TestServicePort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class TestApiController(
    val testServicePort: TestServicePort
) : TestApi {
    override fun getHelloWorld(): ResponseEntity<HelloWorldResponseDto> {
        return ResponseEntity.ok(HelloWorldResponseDto(message = "Success!"))
    }
}