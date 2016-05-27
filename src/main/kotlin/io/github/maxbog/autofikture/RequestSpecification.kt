package io.github.maxbog.autofikture

interface RequestSpecification {
    fun isSatisfiedBy(request : Any) : Boolean
}