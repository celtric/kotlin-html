package org.celtric.kotlin.html

fun tr(
    // Global
    css: String? = null,
    id: String? = null,
    title: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = Element("tr", true, content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id,
    "title" to title
), other, data))

fun tr(content: String) = tr { content }
fun tr(content: Node) = tr { content }
fun tr(content: List<Node>) = tr { content }
