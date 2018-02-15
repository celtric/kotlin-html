package org.celtric.kotlin.html

fun address(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = BlockElement("address", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun address(content: String) = address { content }
fun address(content: Node) = address { content }
fun address(content: List<Node>) = address { content }
