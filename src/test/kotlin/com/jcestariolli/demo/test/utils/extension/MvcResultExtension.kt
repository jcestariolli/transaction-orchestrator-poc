package com.jcestariolli.demo.test.utils.extension

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.test.web.servlet.MvcResult
import java.io.IOException

fun <T> MvcResult.parse(mapper: ObjectMapper, classType: Class<T>?): T {
    return try {
        val contentAsString = this.response.contentAsString
        mapper.readValue(contentAsString, classType)
    } catch (e: IOException) {
        throw RuntimeException(e)
    }
}

fun <T> MvcResult.parse(mapper: ObjectMapper, typeReference: TypeReference<T>?): T {
    return try {
        val contentAsString = this.response.contentAsString
        mapper.readValue(contentAsString, typeReference)
    } catch (e: IOException) {
        throw RuntimeException(e)
    }
}
