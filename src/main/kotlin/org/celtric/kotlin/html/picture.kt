package org.celtric.kotlin.html

fun picture(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = BlockElement("picture", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun picture(content: String) = picture { content }
fun picture(content: Node) = picture { content }
fun picture(content: List<Node>) = picture { content }
