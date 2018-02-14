package org.celtric.kotlin.html

fun footer(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = Element("footer", true, content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun footer(content: String) = footer { content }
fun footer(content: Node) = footer { content }
fun footer(content: List<Node>) = footer { content }
