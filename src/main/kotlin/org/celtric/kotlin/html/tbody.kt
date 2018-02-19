package org.celtric.kotlin.html

fun tbody(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = BlockElement("tbody", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun tbody(content: String) = tbody { content }
fun tbody(content: Node) = tbody { content }
fun tbody(content: List<Node>) = tbody { content }
