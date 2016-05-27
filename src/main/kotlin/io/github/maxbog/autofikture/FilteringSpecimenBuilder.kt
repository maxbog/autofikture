package io.github.maxbog.autofikture

class FilteringSpecimenBuilder(private val builder: SpecimenBuilder, private val specification: RequestSpecification) : SpecimenBuilderNode {
    override fun iterator(): Iterator<SpecimenBuilder> {
        return sequenceOf(builder).iterator()
    }

    override fun create(request: Any, context: SpecimenContext): Any {
        if(!specification.isSatisfiedBy(request)) {
            return NoSpecimen(request)
        }

        return builder.create(request, context)
    }

    override fun compose(builders: Sequence<SpecimenBuilder>): SpecimenBuilderNode {
        throw UnsupportedOperationException()
    }
}

data class NoSpecimen(val request : Any) {

}
