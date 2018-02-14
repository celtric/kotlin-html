package org.celtric.kotlin.html

fun html(
    // Optional
    xmlns: String? = null,

    // Global
    css: String? = null,
    dir: String? = null,
    lang: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = Element("html", true, content(), AllAttributes(mapOf(
    "xmlns" to xmlns,
    "class" to css,
    "dir" to dir,
    "lang" to lang
), other, data))

fun html(content: String) = html { content }
fun html(content: Node) = html { content }
fun html(content: List<Node>) = html { content }
