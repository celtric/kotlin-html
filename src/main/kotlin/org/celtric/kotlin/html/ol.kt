package org.celtric.kotlin.html

fun ol(
    // Optional
    type: String? = null,
    start: Int? = null,
    reversed: Boolean = false,

    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Mandatory
    content: () -> Any
) = BlockElement("ol", content(), AllAttributes(mapOf(
    "type" to type,
    "start" to start,
    "reversed" to reversed,
    "class" to css,
    "id" to id
), other, data))

fun ol(content: String) = ol { content }
fun ol(content: Node) = ol { content }
fun ol(content: List<Node>) = ol { content }
