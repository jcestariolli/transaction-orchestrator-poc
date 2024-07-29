package com.jcestariolli.test.persistence.jpa.dao

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import java.math.BigDecimal
import java.util.*

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "test")
data class TestDao(
    @Id
    val id: String,

    @Column(nullable = true)
    val textField: String? = null,

    @Column(nullable = true)
    val booleanField: Boolean? = null,

    @Column(nullable = true)
    val decimalNumberField: BigDecimal? = null,

    @Column @Temporal(TemporalType.DATE)
    val dateField: Date? = null,
) {
    companion object
}