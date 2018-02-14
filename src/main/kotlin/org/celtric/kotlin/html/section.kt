package org.celtric.kotlin.html

fun section(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = Element("section", true, content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun section(content: String) = section { content }
fun section(content: Node) = section { content }
fun section(content: List<Node>) = section { content }
