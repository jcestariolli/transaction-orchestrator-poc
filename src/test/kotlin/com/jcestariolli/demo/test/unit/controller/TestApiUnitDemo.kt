package com.jcestariolli.demo.test.unit.controller

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.jcestariolli.demo.controller.dto.response.DemoResponseDto
import com.jcestariolli.demo.domain.Demo
import com.jcestariolli.demo.domain.extension.toDto
import com.jcestariolli.demo.service.DemoServicePort
import com.jcestariolli.demo.test.faker.mock.domain.fake
import com.jcestariolli.demo.test.faker.utils.localizedFaker
import com.jcestariolli.demo.test.utils.extension.parse
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TestApiUnitDemo(
    @Autowired private val objectMapper: ObjectMapper,
    @Autowired private val mvc: MockMvc,
) {
    @MockkBean
    private lateinit var demoService: DemoServicePort

    @Test
    fun `getDemos - should return HTTP Status 200 and a filled list`() {
        val demoList = listOf(Demo(id = UUID.randomUUID().toString()))
        every {
            demoService.list()
        } returns demoList

        val mvcResult: MvcResult = mvc.perform(
            MockMvcRequestBuilders.get("/demo").accept(MediaType.APPLICATION_JSON)
        ).andDo(
            MockMvcResultHandlers.print()
        ).andExpect(
            MockMvcResultMatchers.status().isOk
        ).andReturn()

        val expectedResponseDto = demoList.map { it.toDto() }
        val responseDto: List<DemoResponseDto> =
            mvcResult.parse(mapper = objectMapper, typeReference = object : TypeReference<List<DemoResponseDto>>() {})
        assertThat(responseDto).usingRecursiveComparison().isEqualTo(expectedResponseDto)
    }

    @Test
    fun `getDemos - should return HTTP Status 200 and an empty list`() {
        every {
            demoService.list()
        } returns null

        val mvcResult: MvcResult = mvc.perform(
            MockMvcRequestBuilders.get("/demo").accept(MediaType.APPLICATION_JSON)
        ).andDo(
            MockMvcResultHandlers.print()
        ).andExpect(
            MockMvcResultMatchers.status().isOk
        ).andReturn()

        val responseDto: List<DemoResponseDto> =
            mvcResult.parse(mapper = objectMapper, typeReference = object : TypeReference<List<DemoResponseDto>>() {})
        assertThat(responseDto).isEmpty()
    }

    @Test
    fun `getDemo - should return HTTP Status 200 a demo entity`() {
        val demoDomain = Demo.fake()
        every {
            demoService.findDemo(any())
        } returns demoDomain

        val mvcResult: MvcResult = mvc.perform(
            MockMvcRequestBuilders.get("/demo/${demoDomain.id}").accept(MediaType.APPLICATION_JSON)
        ).andDo(
            MockMvcResultHandlers.print()
        ).andExpect(
            MockMvcResultMatchers.status().isOk
        ).andReturn()

        val expectedResponseDto = demoDomain.toDto()
        val responseDto: DemoResponseDto =
            mvcResult.parse(mapper = objectMapper, typeReference = object : TypeReference<DemoResponseDto>() {})
        assertThat(responseDto).usingRecursiveComparison().isEqualTo(expectedResponseDto)
    }

    @Test
    fun `getDemo - should return HTTP Status 404 when demo is not found`() {
        every {
            demoService.findDemo(any())
        } returns null

        mvc.perform(
            MockMvcRequestBuilders.get("/demo/${localizedFaker.random.nextUUID()}").accept(MediaType.APPLICATION_JSON)
        ).andDo(
            MockMvcResultHandlers.print()
        ).andExpect(
            MockMvcResultMatchers.status().isNotFound
        ).andReturn()
    }
}