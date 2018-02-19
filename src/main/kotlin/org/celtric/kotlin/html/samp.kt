package org.celtric.kotlin.html

fun samp(
    // Global
    css: String? = null,
    id: String? = null,
    title: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = InlineElement("samp", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id,
    "title" to title
), other, data))

fun samp(content: String) = samp { content }
fun samp(content: Node) = samp { content }
fun samp(content: List<Node>) = samp { content }
