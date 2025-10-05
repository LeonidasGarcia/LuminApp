package com.luminteam.lumin.ui.markdown

class MarkdownStringBuilder() {
    var markdownString: String = """"""

    fun addTitle(text: String): MarkdownStringBuilder {
        markdownString += """# ${text}
"""
        return this
    }

    fun addSubtitle(text: String): MarkdownStringBuilder {
        markdownString += """## ${text}
"""
        return this
    }

    fun addParagraph(text: String): MarkdownStringBuilder {
        markdownString += """${text}
"""
        return this
    }

    fun addCode(text: String): MarkdownStringBuilder {
        markdownString += """```python
${text}
```
"""
        return this
    }

    fun addOutput(text: String): MarkdownStringBuilder {
        markdownString += """```txt
Output: ${text}
```
"""
        return this
    }

    fun build(): String {
        return markdownString
    }

}