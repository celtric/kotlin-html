package org.celtric.kotlin.html

fun dfn(
    // Optional
    title: String? = null,

    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = InlineElement("dfn", content(), AllAttributes(mapOf(
    "title" to title,
    "class" to css,
    "id" to id
), other, data))

fun dfn(content: String) = dfn { content }
fun dfn(content: Node) = dfn { content }
fun dfn(content: List<Node>) = dfn { content }
