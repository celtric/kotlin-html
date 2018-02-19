package org.celtric.kotlin.html

fun pre(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = BlockElement("pre", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun pre(content: String) = pre { content }
fun pre(content: Node) = pre { content }
fun pre(content: List<Node>) = pre { content }
