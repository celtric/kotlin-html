![](https://img.shields.io/circleci/project/github/celtric/kotlin-html.svg)
![](https://img.shields.io/github/license/celtric/kotlin-html.svg)
[ ![Download](https://api.bintray.com/packages/celtric/maven/kotlin-html/images/download.svg) ](https://bintray.com/celtric/maven/kotlin-html/_latestVersion)

# kotlin-html

_kotlin-html_ is an experimental library to generate HTML in Kotlin.

This library is heavily inspired by [kotlinx.html](https://github.com/Kotlin/kotlinx.html), but with a strong emphasis on composability.

## Getting started

You can define HTML elements independently from an HTML document. The following code:

```kotlin
p("A paragraph").render()
```

will render the following HTML:

```html
<p>A paragraph</p>
```

### Composability

You can join any number elements:

```html
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

### Attributes

Attributes are optional. If you wish to define them, you must use a block for the content:

```kotlin
p("A paragraph") // Text-only element, cannot contain attributes
p { "A paragraph" } // Equivalent to previous line
p(css = "a-class") { "A paragraph" } // Same paragraph with "a-class" class
```

HTML

```html
<p>A paragraph</p>
<p>A paragraph</p>
<p class="a-class">A paragraph</p>
```

### Text

You can join elements and text:

```kotlin
strong("Strongly") + " disagree"
p(strong("Strongly") + " disagree")
```

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
doctype("html") + html {
    head {
        title("Document title") +
        meta(charset = "utf-8") +
        link(href = "css/style.css", rel = "stylesheet")
    } +
    body {
        div(css = "container") {
            h1("A title") +
            p(css = "introduction") {
                "A paragraph"
            } +
            ul {
                li(a("http://www.example.com/", "A link")) +
                li(a("http://www.example.com/", "A second link"))
            }
        }
    }
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
