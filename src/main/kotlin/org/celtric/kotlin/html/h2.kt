package org.celtric.kotlin.html

fun h2(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = Element("h2", true, content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun h2(content: String) = h2 { content }
fun h2(content: Node) = h2 { content }
fun h2(content: List<Node>) = h2 { content }
