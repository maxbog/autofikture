package io.github.maxbog.autofikture

/**
 * Created by dvkc73 on 2016-05-25.
 */
object Generate {
    val fixture = Fixture()

    fun anyString(): String {
        return any<String>()
    }

    inline fun <reified T> any() : T {
        return fixture.create<T>()
    }
}