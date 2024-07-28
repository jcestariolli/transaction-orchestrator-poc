package com.jcestariolli.testApp.controller.impl

import com.jcestariolli.testApp.controller.TestApi
import com.jcestariolli.testApp.controller.dto.response.HelloWorldResponseDto
import com.jcestariolli.testApp.service.TestServicePort
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