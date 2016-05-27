package io.github.maxbog.autofikture

class CompositeSpecimenBuilder(private val builders: Sequence<SpecimenBuilder>) : SpecimenBuilderNode {

    constructor(vararg builders: SpecimenBuilder) : this(builders.asSequence()) {
    }

    override fun compose(builders: Sequence<SpecimenBuilder>): SpecimenBuilderNode {
        return CompositeSpecimenBuilder(builders)
    }

    override fun create(request: Any, context: SpecimenContext): Any {
        return builders
                .map { it.create(request, context) }
                .takeWhile { it is NoSpecimen }
                .firstOrNull()
                ?: NoSpecimen(request)
    }

    override fun iterator(): Iterator<SpecimenBuilder> {
        return builders.iterator()
    }

    companion object {
        fun composeIfMultiple(builders: Sequence<SpecimenBuilder>): SpecimenBuilder {
            if(builders.count() == 1) {
                return builders.first()
            }
            return CompositeSpecimenBuilder(builders)
        }
    }
}