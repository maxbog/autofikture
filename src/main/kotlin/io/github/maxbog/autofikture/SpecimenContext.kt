package io.github.maxbog.autofikture

interface SpecimenContext {
    fun resolve(request: Any) : Any
}