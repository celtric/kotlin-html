package org.celtric.kotlin.html

fun hr(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap()
) = EmptyBlockElement("hr", AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))
