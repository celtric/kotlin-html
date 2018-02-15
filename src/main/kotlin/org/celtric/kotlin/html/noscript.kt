package org.celtric.kotlin.html

fun noscript(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = BlockElement("noscript", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun noscript(content: String) = noscript { content }
fun noscript(content: Node) = noscript { content }
fun noscript(content: List<Node>) = noscript { content }
