package org.celtric.kotlin.html

class HTMLException(message: String) : RuntimeException(message)

data class RenderingOptions(
        val indentWith: String = "    ",
        val indentLevel: Int = 0,
        val lineSeparator: String = System.lineSeparator()) {
    fun indent() = indentWith.repeat(indentLevel)
    fun nextLevel() = copy(indentLevel = indentLevel + 1)
}

private typealias Options = RenderingOptions

//---[ Nodes ]--------------------------------------------------------------------------//

sealed class Node {
    abstract fun render(opt: Options = Options()): String
    abstract fun isBlock(): Boolean
    operator fun plus(text: String): List<Node> = plus(Text(text))
    operator fun plus(node: Node): List<Node> = listOf(this, node)
    operator fun plus(nodes: List<Node>): List<Node> = listOf(this) + nodes
    fun toList(): List<Node> = listOf(this)
}

class DocumentType(val type: String) : Node() {
    override fun render(opt: Options) = "${opt.indent()}<!DOCTYPE $type>${opt.lineSeparator}"
    override fun isBlock() = true
}

class Text(val content: String) : Node() {
    override fun render(opt: Options) = content
    override fun isBlock() = false
}

// Due to Kotlin's function overloading limitations, we are forced to use Any for content and check for valid types at
// runtime.
// @see https://discuss.kotlinlang.org/t/overloaded-function-with-lambda-parameter-of-different-return-types/6053
class Element(val name: String, val _isBlock: Boolean, val content: Any, val attributes: AllAttributes) : Node() {

    override fun render(opt: Options): String {
        val renderableContent: Node = when {
            content is String -> Text(content)
            content is Node -> content
            (content is List<*> && content.first() is Node) -> @Suppress("UNCHECKED_CAST") NodeList(content as List<Node>)
            else -> throw HTMLException("Content must be String, Node or List<Node>, ${contentType(content)} given.")
        }

        val renderedContent =
                if (renderableContent.isBlock()) "${opt.lineSeparator}${renderableContent.render(opt.nextLevel())}${opt.indent()}"
                else renderableContent.render()

        return "${opt.indent()}<$name${attributes.render()}>$renderedContent</$name>" + if (isBlock()) opt.lineSeparator else ""
    }

    private fun contentType(content: Any): String = when {
        content !is Collection<*> -> content.javaClass.simpleName
        content.isEmpty() -> "${content.javaClass.simpleName}<?>"
        content.first() is Collection<*> -> "${content.javaClass.simpleName}<${contentType(content.first()!!)}>"
        else -> "${content.javaClass.simpleName}<${content.first()!!.javaClass.simpleName}>"
    }

    override fun isBlock() = _isBlock
}

class EmptyElement(val name: String, val _isBlock: Boolean, val attributes: AllAttributes? = null) : Node() {
    override fun render(opt: Options) =
            "${opt.indent()}<$name${attributes?.render()}>" + if (isBlock()) opt.lineSeparator else ""
    override fun isBlock() = _isBlock
}

//---[ Lists of nodes ]-----------------------------------------------------------------//

private class NodeList(val nodes: List<Node>) : Node() {
    override fun render(opt: Options) = nodes.render(opt)
    override fun isBlock() = nodes.any { it.isBlock() }
}

fun List<Node>.render(opt: Options = Options()) = joinToString("") { it.render(opt) }
operator fun List<Node>.plus(text: String): List<Node> = plus(Text(text))
// TODO: can the call to the overloaded plus operator be delegated without this casting hack?
@Suppress("UNCHECKED_CAST")
operator fun List<Node>.plus(node: Node): List<Node> = ((this as List<Any>) + node) as List<Node>
@Suppress("UNCHECKED_CAST")
operator fun List<Node>.plus(nodes: List<Node>): List<Node> = ((this as List<Any>) + nodes) as List<Node>

//---[ Attributes ]---------------------------------------------------------------------//

typealias Attributes = Map<String, String?>

private fun Attributes.renderAttributes(prefix: String = "") =
        filter { it.value != null }
        .map { " $prefix${it.key}=\"${it.value}\"" }.joinToString("")

class AllAttributes(val common: Attributes, val other: Attributes, val data: Attributes) {
    fun render() = common.renderAttributes() + other.renderAttributes()+ data.renderAttributes("data-")
}
