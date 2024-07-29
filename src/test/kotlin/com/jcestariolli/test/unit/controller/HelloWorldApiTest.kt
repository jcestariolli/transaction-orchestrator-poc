package com.jcestariolli.test.unit.controller

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.jcestariolli.test.controller.dto.response.HelloWorldResponseDto
import com.jcestariolli.test.utils.parseMvcResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class HelloWorldApiTest(
    @Autowired private val objectMapper: ObjectMapper,
    @Autowired private val mvc: MockMvc,
) {

    @Test
    fun `getHelloWorld - should return HTTP Status 200`() {
        val mvcResult: MvcResult = mvc.perform(
            MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON)
        ).andDo(
            MockMvcResultHandlers.print()
        ).andExpect(
            MockMvcResultMatchers.status().isOk
        ).andReturn()

        val expectedResponseDto = HelloWorldResponseDto(message = "Success!")
        val responseDto: HelloWorldResponseDto = parseMvcResult(
            mapper = objectMapper,
            mvResult = mvcResult,
            valueTypeRef = object : TypeReference<HelloWorldResponseDto>() {}
        )
        assertThat(responseDto).usingRecursiveComparison().isEqualTo(expectedResponseDto)
    }
}