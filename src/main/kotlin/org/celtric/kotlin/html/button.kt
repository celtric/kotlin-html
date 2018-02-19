package org.celtric.kotlin.html

fun button(
    // Optional
    type: String? = null,
    name: String? = null,
    value: String? = null,
    disabled: Boolean = false,
    autofocus: Boolean = false,

    // Global
    css: String? = null,
    id: String? = null,
    title: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = InlineElement("button", content(), AllAttributes(mapOf(
    "type" to type,
    "name" to name,
    "value" to value,
    "disabled" to disabled,
    "autofocus" to autofocus,
    "class" to css,
    "id" to id,
    "title" to title
), other, data))
