package org.celtric.kotlin.html

fun li(
    // Optional
    value: String? = null,

    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = BlockElement("li", content(), AllAttributes(mapOf(
    "value" to value,
    "class" to css,
    "id" to id
), other, data))

fun li(content: String) = li { content }
fun li(content: Node) = li { content }
fun li(content: List<Node>) = li { content }
