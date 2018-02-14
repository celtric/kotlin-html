package org.celtric.kotlin.html

fun img(
    // Mandatory
    src: String,
    alt: String,

    // Global
    css: String? = null,
    id: String? = null,
    title: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap()
) = EmptyElement("img", false, AllAttributes(mapOf(
    "src" to src,
    "alt" to alt,
    "class" to css,
    "id" to id,
    "title" to title
), other, data))
