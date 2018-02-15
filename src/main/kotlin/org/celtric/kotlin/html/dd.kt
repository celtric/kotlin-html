package org.celtric.kotlin.html

fun dd(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = BlockElement("dd", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun dd(content: String) = dd { content }
fun dd(content: Node) = dd { content }
fun dd(content: List<Node>) = dd { content }
