package com.jeanbarrossilva.newandlib.utils

import java.time.format.DateTimeFormatter

/**
 * [DateTimeFormatter] that formats date-time for it to be like the commented one in Android
 * Studio's `gradle-wrapper.properties`'s header, such as "Thu Mar 06:35:30 BRT 2023".
 **/
@Suppress("FunctionName")
internal fun GradleWrapperPropertiesHeaderDateTimeFormatter(): DateTimeFormatter {
    return DateTimeFormatter.ofPattern("E MMM d HH:mm:ss z yyyy")
}
