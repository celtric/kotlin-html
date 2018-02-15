package org.celtric.kotlin.html

fun bdi(
    // Optional
    dir: String? = null,

    // Global
    css: String? = null,
    id: String? = null,
    title: String? = null,

    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> Any
) = InlineElement("bdi", content(), AllAttributes(mapOf(
    "dir" to dir,
    "class" to css,
    "id" to id,
    "title" to title
), other, data))
