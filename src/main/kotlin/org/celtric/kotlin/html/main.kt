package org.celtric.kotlin.html

fun main(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = Element("main", true, content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun main(content: String) = main { content }
fun main(content: Node) = main { content }
fun main(content: List<Node>) = main { content }
