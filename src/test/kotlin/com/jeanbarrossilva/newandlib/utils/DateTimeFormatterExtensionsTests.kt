package com.jeanbarrossilva.newandlib.utils

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import kotlin.test.Test
import kotlin.test.assertEquals

internal class DateTimeFormatterExtensionsTests {
    @Test
    fun `GIVEN a DateTime WHEN formatting it with a GradleWrapperPropertiesDateTimeFormatter THEN it is formatted correctly`() {
        val date = LocalDate.of(2023, 3, 12)
        val time = LocalTime.of(6, 35, 30)
        val dateTime = LocalDateTime.of(date, time)
        val zoneId = ZoneId.of("America/Sao_Paulo")
        val zonedDateTime = ZonedDateTime.of(dateTime, zoneId)
        assertEquals(
            "Sun Mar 12 06:35:30 BRT 2023",
            zonedDateTime.format(GradleWrapperPropertiesHeaderDateTimeFormatter())
        )
    }
}
