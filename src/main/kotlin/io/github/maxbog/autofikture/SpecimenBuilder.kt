package io.github.maxbog.autofikture

/**
 * Created by dvkc73 on 2016-05-27.
 */

interface SpecimenBuilder {
    fun create(request: Any, context: SpecimenContext): Any
}

