package org.celtric.kotlin.html

fun table(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = Element("table", true, content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun table(content: String) = table { content }
fun table(content: Node) = table { content }
fun table(content: List<Node>) = table { content }
