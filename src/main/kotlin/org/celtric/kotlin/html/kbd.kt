package org.celtric.kotlin.html

fun kbd(
    // Global
    css: String? = null,
    id: String? = null,
    title: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = InlineElement("kbd", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id,
    "title" to title
), other, data))

fun kbd(content: String) = kbd { content }
fun kbd(content: Node) = kbd { content }
fun kbd(content: List<Node>) = kbd { content }
