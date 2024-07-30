package com.jcestariolli.demo.controller

import com.jcestariolli.demo.controller.dto.response.BasicErrorResponseDto
import com.jcestariolli.shared.exception.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class DemoControllerAdvice : ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [ResourceNotFoundException::class])
    fun resourceNotFoundException(
        ex: ResourceNotFoundException,
        request: WebRequest?
    ): ResponseEntity<BasicErrorResponseDto> {
        val status = HttpStatus.NOT_FOUND
        val errorResponseDto = BasicErrorResponseDto(status.value().toString(), ex.message ?: "Resource not found")
        return ResponseEntity(errorResponseDto, status)
    }
}