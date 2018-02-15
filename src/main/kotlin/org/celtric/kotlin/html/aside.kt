package org.celtric.kotlin.html

fun aside(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = BlockElement("aside", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun aside(content: String) = aside { content }
fun aside(content: Node) = aside { content }
fun aside(content: List<Node>) = aside { content }
