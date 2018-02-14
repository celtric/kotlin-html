package org.celtric.kotlin.html

fun em(
    // Global
    css: String? = null,
    id: String? = null,
    title: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = Element("em", false, content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id,
    "title" to title
), other, data))

fun em(content: String) = em { content }
fun em(content: Node) = em { content }
fun em(content: List<Node>) = em { content }
