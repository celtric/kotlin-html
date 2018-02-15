package org.celtric.kotlin.html

fun h4(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = BlockElement("h4", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun h4(content: String) = h4 { content }
fun h4(content: Node) = h4 { content }
fun h4(content: List<Node>) = h4 { content }
