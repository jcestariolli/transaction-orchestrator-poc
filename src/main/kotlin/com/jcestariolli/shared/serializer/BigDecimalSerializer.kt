package com.jcestariolli.shared.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import java.math.BigDecimal
import java.math.RoundingMode

class BigDecimalSerializer: StdSerializer<BigDecimal>(BigDecimal::class.java) {
    override fun serialize(value: BigDecimal?, generator: JsonGenerator?, provider: SerializerProvider?) {
        generator?.writeNumber(value?.setScale(2, RoundingMode.HALF_EVEN))
    }

}