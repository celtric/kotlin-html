package org.celtric.kotlin.html

fun map(
    // Optional
    name: String? = null,

    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = BlockElement("map", content(), AllAttributes(mapOf(
    "name" to name,
    "class" to css,
    "id" to id
), other, data))

fun map(content: String) = map { content }
fun map(content: Node) = map { content }
fun map(content: List<Node>) = map { content }
