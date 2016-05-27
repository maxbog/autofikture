package io.github.maxbog.autofikture

import com.google.common.reflect.TypeToken

class ExactTypeSpecification(private val type: TypeToken<*>) : RequestSpecification {
    override fun isSatisfiedBy(request: Any): Boolean {
        return type.equals(request)
    }
}