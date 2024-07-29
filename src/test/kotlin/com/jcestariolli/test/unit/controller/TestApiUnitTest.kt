package com.jcestariolli.test.unit.controller

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.jcestariolli.test.controller.dto.response.TestResponseDto
import com.jcestariolli.test.domain.toDto
import com.jcestariolli.test.mock.extension.domain.fake
import com.jcestariolli.test.mock.extension.localizedFaker
import com.jcestariolli.test.service.TestServicePort
import com.jcestariolli.test.utils.parseMvcResult
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
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
import java.util.*
import com.jcestariolli.test.domain.Test as TestDomain

@SpringBootTest
@AutoConfigureMockMvc
class TestApiUnitTest(
    @Autowired private val objectMapper: ObjectMapper,
    @Autowired private val mvc: MockMvc,
) {
    @MockkBean
    private lateinit var testService: TestServicePort

    @Test
    fun `getTests - should return HTTP Status 200 and a filled list`() {
        val testList = listOf(TestDomain(id = UUID.randomUUID().toString()))
        every {
            testService.list()
        } returns testList


        val mvcResult: MvcResult = mvc.perform(
            MockMvcRequestBuilders.get("/test").accept(MediaType.APPLICATION_JSON)
        ).andDo(
            MockMvcResultHandlers.print()
        ).andExpect(
            MockMvcResultMatchers.status().isOk
        ).andReturn()

        val expectedResponseDto = testList.map { it.toDto() }
        val responseDto: List<TestResponseDto> = parseMvcResult(
            mapper = objectMapper,
            mvResult = mvcResult,
            valueTypeRef = object : TypeReference<List<TestResponseDto>>() {}
        )
        assertThat(responseDto).usingRecursiveComparison().isEqualTo(expectedResponseDto)
    }

    @Test
    fun `getTests - should return HTTP Status 200 and an empty list`() {
        every {
            testService.list()
        } returns null

        val mvcResult: MvcResult = mvc.perform(
            MockMvcRequestBuilders.get("/test").accept(MediaType.APPLICATION_JSON)
        ).andDo(
            MockMvcResultHandlers.print()
        ).andExpect(
            MockMvcResultMatchers.status().isOk
        ).andReturn()

        val responseDto: List<TestResponseDto> = parseMvcResult(
            mapper = objectMapper,
            mvResult = mvcResult,
            valueTypeRef = object : TypeReference<List<TestResponseDto>>() {}
        )
        assertThat(responseDto).isEmpty()
    }

    @Test
    fun `getTest - should return HTTP Status 200 a test entity`() {
        val testDomain = TestDomain.fake()
        every {
            testService.findTest(any())
        } returns testDomain

        val mvcResult: MvcResult = mvc.perform(
            MockMvcRequestBuilders.get("/test/${testDomain.id}").accept(MediaType.APPLICATION_JSON)
        ).andDo(
            MockMvcResultHandlers.print()
        ).andExpect(
            MockMvcResultMatchers.status().isOk
        ).andReturn()

        val expectedResponseDto = testDomain.toDto()
        val responseDto: TestResponseDto = parseMvcResult(
            mapper = objectMapper,
            mvResult = mvcResult,
            valueTypeRef = object : TypeReference<TestResponseDto>() {}
        )
        assertThat(responseDto).usingRecursiveComparison().isEqualTo(expectedResponseDto)
    }

    @Test
    fun `getTest - should return HTTP Status 404 when test is not found`() {
        every {
            testService.findTest(any())
        } returns null

        mvc.perform(
            MockMvcRequestBuilders.get("/test/${localizedFaker.random.nextUUID()}").accept(MediaType.APPLICATION_JSON)
        ).andDo(
            MockMvcResultHandlers.print()
        ).andExpect(
            MockMvcResultMatchers.status().isNotFound
        ).andReturn()
    }
}