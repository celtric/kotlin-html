package org.celtric.kotlin.html

fun h3(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = Element("h3", true, content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun h3(content: String) = h3 { content }
fun h3(content: Node) = h3 { content }
fun h3(content: List<Node>) = h3 { content }
