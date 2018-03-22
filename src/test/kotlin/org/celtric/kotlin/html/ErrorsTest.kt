package org.celtric.kotlin.html

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ErrorsTest {

    @Test fun `offers useful message when invalid content is passed`() {
        val elementWithInvalidContent = span { listOf(listOf("Foo")) }

        assertThrows(HTMLException::class.java, { elementWithInvalidContent.render() })
            .let { assertEquals("Content must be String, Number, Node or List<Node>, SingletonList<SingletonList<String>> given.", it.message) }
    }
}
