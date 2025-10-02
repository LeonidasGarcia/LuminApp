package com.luminteam.lumin.ui.markdown

import io.noties.prism4j.GrammarLocator
import io.noties.prism4j.Prism4j

class PythonGrammarLocator : GrammarLocator {
    override fun grammar(prism4j: Prism4j, language: String): Prism4j.Grammar? {
        return when (language) {
            "python" -> Prism_python.create(prism4j)
            else -> null
        }
    }

    override fun languages(): Set<String> {
        return setOf("python")
    }
}
