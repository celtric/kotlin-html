package org.celtric.kotlin.html

fun nav(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = Element("nav", true, content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun nav(content: String) = nav { content }
fun nav(content: Node) = nav { content }
fun nav(content: List<Node>) = nav { content }
