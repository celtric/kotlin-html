package org.celtric.kotlin.html

fun sup(
    // Global
    css: String? = null,
    id: String? = null,
    title: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = InlineElement("sup", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id,
    "title" to title
), other, data))

fun sup(content: String) = sup { content }
fun sup(content: Node) = sup { content }
fun sup(content: List<Node>) = sup { content }
