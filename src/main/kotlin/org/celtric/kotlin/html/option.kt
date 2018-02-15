package org.celtric.kotlin.html

fun option(
    // Optional
    value: String? = null,
    label: String? = null,
    selected: Boolean = false,
    disabled: Boolean = false,

    // Global
    css: String? = null,
    id: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = BlockElement("option", content(), AllAttributes(mapOf(
    "value" to value,
    "label" to label,
    "selected" to selected,
    "disabled" to disabled,
    "class" to css,
    "id" to id
), other, data))

fun option(content: String) = option { content }
fun option(content: Node) = option { content }
fun option(content: List<Node>) = option { content }
