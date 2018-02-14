package org.celtric.kotlin.html

import org.junit.jupiter.api.Test

internal class TextTest {

    @Test fun single_text() {
        text("A text").assertRenders("A text")
        text { "A text" }.assertRenders("A text")
    }

    @Test fun composed_text() {
        (text("A") + " " + "text").assertRenders("A text")
        (text("A") + " " + text("text")).assertRenders("A text")
        (text("A") + text(" ") + "text").assertRenders("A text")
        (text("A") + text(" ") + text("text")).assertRenders("A text")
    }

    @Test fun text_inside_other_elements() {
        p("A text").assertRenders("<p>A text</p>\n")
        p(text("A text")).assertRenders("<p>A text</p>\n")
        p(text("A") + " " + "text").assertRenders("<p>A text</p>\n")
    }
}
