package org.celtric.kotlin.html

fun title(
    // Custom
    other: Attributes = emptyMap(),
    data: Attributes = emptyMap(),

    // Content
    content: () -> String
) = Element("title", true, Text(content()), AllAttributes(emptyMap(), other, data))

fun title(content: String) = title { content }
