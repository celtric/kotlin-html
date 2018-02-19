package org.celtric.kotlin.html

fun canvas(
    // Mandatory
    width: Int,
    height: Int,

    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = BlockElement("canvas", content(), AllAttributes(mapOf(
    "width" to width,
    "height" to height,
    "class" to css,
    "id" to id
), other, data))
