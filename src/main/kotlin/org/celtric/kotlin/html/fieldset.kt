package org.celtric.kotlin.html

fun fieldset(
    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = BlockElement("fieldset", content(), AllAttributes(mapOf(
    "class" to css,
    "id" to id
), other, data))

fun fieldset(content: String) = fieldset { content }
fun fieldset(content: Node) = fieldset { content }
fun fieldset(content: List<Node>) = fieldset { content }
