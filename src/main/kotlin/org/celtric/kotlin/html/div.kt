package org.celtric.kotlin.html

fun div(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = Element("div", true, content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun div(content: String) = div { content }
fun div(content: Node) = div { content }
fun div(content: List<Node>) = div { content }
