package org.celtric.kotlin.html

fun body(
    // Optional
    lang: String? = null,

    // Global
    css: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = Element("body", true, content(), AllAttributes(mapOf(
    "class" to css,
    "lang" to lang
), other, data))

fun body(content: String) = body { content }
fun body(content: Node) = body { content }
fun body(content: List<Node>) = body { content }
