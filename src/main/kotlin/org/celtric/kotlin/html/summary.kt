package org.celtric.kotlin.html

fun summary(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = BlockElement("summary", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun summary(content: String) = summary { content }
fun summary(content: Node) = summary { content }
fun summary(content: List<Node>) = summary { content }
