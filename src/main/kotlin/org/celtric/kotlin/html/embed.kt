package org.celtric.kotlin.html

fun embed(
    // Mandatory
    type: String,
    src: String,
    width: Int,
    height: Int,

    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap()
) = EmptyBlockElement("embed", AllAttributes(mapOf(
    "type" to type,
    "src" to src,
    "width" to width,
    "height" to height,
    "class" to css,
    "id" to id
), other, data))
