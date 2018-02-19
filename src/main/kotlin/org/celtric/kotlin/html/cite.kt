package org.celtric.kotlin.html

fun cite(
    // Global
    css: String? = null,
    id: String? = null,
    title: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = InlineElement("cite", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id,
    "title" to title
), other, data))

fun cite(content: String) = cite { content }
fun cite(content: Node) = cite { content }
fun cite(content: List<Node>) = cite { content }
