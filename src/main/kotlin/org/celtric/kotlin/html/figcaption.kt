package org.celtric.kotlin.html

fun figcaption(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = BlockElement("figcaption", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun figcaption(content: String) = figcaption { content }
fun figcaption(content: Node) = figcaption { content }
fun figcaption(content: List<Node>) = figcaption { content }
