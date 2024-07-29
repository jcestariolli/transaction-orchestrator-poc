package com.jcestariolli.test.utils

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.test.web.servlet.MvcResult
import java.io.IOException

fun <T> parseMvcResult(mapper: ObjectMapper, result: MvcResult, responseClass: Class<T>?): T {
    return try {
        val contentAsString = result.response.contentAsString
        mapper.readValue(contentAsString, responseClass)
    } catch (e: IOException) {
        throw RuntimeException(e)
    }
}

fun <T> parseMvcResult(mapper: ObjectMapper, mvResult: MvcResult, valueTypeRef: TypeReference<T>?): T {
    return try {
        val contentAsString = mvResult.response.contentAsString
        mapper.readValue(contentAsString, valueTypeRef)
    } catch (e: IOException) {
        throw RuntimeException(e)
    }
}

fun asJsonString(mapper: ObjectMapper, obj: Any?): String? {
    return try {
        mapper.writeValueAsString(obj)
    } catch (e: Exception) {
        throw RuntimeException(e)
    }
}
