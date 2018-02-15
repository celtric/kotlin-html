package org.celtric.kotlin.html

fun template(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = BlockElement("template", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun template(content: String) = template { content }
fun template(content: Node) = template { content }
fun template(content: List<Node>) = template { content }
