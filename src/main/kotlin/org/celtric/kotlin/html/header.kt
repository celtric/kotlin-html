package org.celtric.kotlin.html

fun header(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = Element("header", true, content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun header(content: String) = header { content }
fun header(content: Node) = header { content }
fun header(content: List<Node>) = header { content }
