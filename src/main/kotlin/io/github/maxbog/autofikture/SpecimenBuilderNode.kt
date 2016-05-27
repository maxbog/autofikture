package io.github.maxbog.autofikture

interface SpecimenBuilderNode : SpecimenBuilder, Sequence<SpecimenBuilder> {
    fun compose(builders: Sequence<SpecimenBuilder>): SpecimenBuilderNode
}