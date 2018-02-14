package org.celtric.kotlin.html

fun tfoot(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = Element("tfoot", true, content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun tfoot(content: String) = tfoot { content }
fun tfoot(content: Node) = tfoot { content }
fun tfoot(content: List<Node>) = tfoot { content }
