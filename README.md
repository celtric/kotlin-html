![](https://img.shields.io/circleci/project/github/celtric/kotlin-html.svg)
![](https://img.shields.io/github/license/celtric/kotlin-html.svg)
[ ![Download](https://api.bintray.com/packages/celtric/maven/kotlin-html/images/download.svg) ](https://bintray.com/celtric/maven/kotlin-html/_latestVersion)

# kotlin-html

_kotlin-html_ is an experimental library to generate HTML in Kotlin.

This library is heavily inspired by [kotlinx.html](https://github.com/Kotlin/kotlinx.html), but with a strong emphasis on composability.

## Getting started

You can define HTML elements independently from an HTML document. The following code:

```kotlin
p("A paragraph")
```

will render the following HTML when `.render()` is called:

```html
<p>A paragraph</p>
```

### Composability

You can join any number of elements:

```kotlin
p("First paragraph") + p("Second paragraph")
```

HTML:

```html
<p>First paragraph</p>
<p>Second paragraph</p>
```

You can also easily interact with list transformations:

```kotlin
val people = listOf("Gael", "Laura", "Ricard")

ul { people.map { li(it) } }
```

HTML:

```html
<ul>
    <li>Gael</li>
    <li>Laura</li>
    <li>Ricard</li>
</ul>
```

Working with functions is also straightforward:

```kotlin
ul { numbers() }

fun actors() = li("One") + li("Two") + li("Three")
```

HTML:

```html
<ul>
    <li>One</li>
    <li>Two</li>
    <li>Three</li>
</ul>
```

### Attributes

Attributes are optional. If you wish to define them, you must use a block for the content:

```kotlin
p("A paragraph") // Text-only element, cannot contain attributes
p { "A paragraph" } // Equivalent to previous line
p(classes = "a-class") { "A paragraph" } // Same paragraph with "a-class" class
```

HTML

```html
<p>A paragraph</p>
<p>A paragraph</p>
<p class="a-class">A paragraph</p>
```

Each element offers some relevant attributes depending on its tag:

```kotlin
a(href = "http://www.example.com/", target = "_blank") { "A link" }
img(src = "/img/logo.png", alt = "Our site")
```

HTML

```html
<a href="http://www.example.com/" target="_blank">A link</a>
<img src="/img/logo.png" alt="Our site">
```

In case you wish to define other attributes you can do so using `other`:

```kotlin
div(other = mapOf("key" to "value")) { "Content" }
```

HTML

```html
<div key="value">Content</div>
```

Custom data attributes are also supported:

```kotlin
div(data = mapOf("user" to "celtric")) { "Content" }
```

HTML

```html
<div data-user="celtric">Content</div>
```

### Text

You can join elements and text:

```kotlin
strong("Strongly") + " disagree"
p(strong("Strongly") + " disagree")
```

HTML:

```html
<strong>Strongly</strong> disagree
<p><strong>Strongly</strong> disagree</p>
```

Due to a limitation in Kotlin's overloading capabilities, a native string cannot be the first element in a list:

```kotlin
"foo" + strong("bar") // NOT allowed by Kotlin operator overloading
text("foo") + strong("bar") // Valid Kotlin
strong("foo") + "bar" // Valid Kotlin, as the native string is not the first element
```

## Full example

```kotlin
import org.celtric.kotlin.html.*

fun main(args : Array<String>) {
    val document = doctype("html") + html {
        head {
            title("Document title") +
            meta(charset = "utf-8") +
            link(href = "css/style.css", rel = "stylesheet")
        } +
        body {
            div(classes = "container") {
                h1("A title") +
                p(classes = "introduction") {
                    "A paragraph"
                } +
                ul {
                    li(a("http://www.example.com/", "A link")) +
                    li(a("http://www.example.com/", "A second link"))
                }
            }
        }
    }

    print(document.render())
}
```

HTML:

```html
<!DOCTYPE html>
<html>
    <head>
        <title>Document title</title>
        <meta charset="utf-8">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>A title</h1>
            <p class="introduction">A paragraph</p>
            <ul>
                <li><a href="http://www.example.com/">A link</a></li>
                <li><a href="http://www.example.com/">A second link</a></li>
            </ul>
        </div>
    </body>
</html>
```
