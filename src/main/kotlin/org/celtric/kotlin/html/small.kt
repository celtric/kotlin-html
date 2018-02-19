package org.celtric.kotlin.html

fun small(
    // Global
    css: String? = null,
    id: String? = null,
    title: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = InlineElement("small", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id,
    "title" to title
), other, data))

fun small(content: String) = small { content }
fun small(content: Node) = small { content }
fun small(content: List<Node>) = small { content }
