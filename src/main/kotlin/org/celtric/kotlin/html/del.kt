package org.celtric.kotlin.html

fun del(
    // Optional
    cite: String? = null,
    datetime: String? = null,

    // Global
    css: String? = null,
    id: String? = null,
    title: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = InlineElement("del", content(), AllAttributes(mapOf(
    "cite" to cite,
    "datetime" to datetime,
    "class" to css,
    "id" to id,
    "title" to title
), other, data))

fun del(content: String) = del { content }
fun del(content: Node) = del { content }
fun del(content: List<Node>) = del { content }
