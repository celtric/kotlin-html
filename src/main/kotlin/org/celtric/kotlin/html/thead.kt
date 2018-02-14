package org.celtric.kotlin.html

fun thead(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = Element("thead", true, content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun thead(content: String) = thead { content }
fun thead(content: Node) = thead { content }
fun thead(content: List<Node>) = thead { content }
