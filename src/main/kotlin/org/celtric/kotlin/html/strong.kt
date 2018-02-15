package org.celtric.kotlin.html

fun strong(
    // Global
    css: String? = null,
    id: String? = null,
    title: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = InlineElement("strong", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id,
    "title" to title
), other, data))

fun strong(content: String) = strong { content }
fun strong(content: Node) = strong { content }
fun strong(content: List<Node>) = strong { content }
