package io.github.maxbog.autofikture

class FixedBuilder(private val specimen : Any) : SpecimenBuilder {
    override fun create(request: Any, context: SpecimenContext): Any {
        return specimen
    }
}

