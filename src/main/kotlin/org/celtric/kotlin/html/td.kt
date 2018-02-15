package org.celtric.kotlin.html

fun td(
    // Optional
    colspan: Int? = null,
    rowspan: Int? = null,

    // Global
    css: String? = null,
    id: String? = null,
    title: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = BlockElement("td", content(), AllAttributes(mapOf(
    "colspan" to colspan?.toString(),
    "rowspan" to rowspan?.toString(),
    "class" to css,
    "id" to id,
    "title" to title
), other, data))

fun td(content: String) = td { content }
fun td(content: Node) = td { content }
fun td(content: List<Node>) = td { content }
