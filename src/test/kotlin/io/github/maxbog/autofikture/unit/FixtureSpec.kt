package io.github.maxbog.autofikture.unit

import io.github.maxbog.autofikture.Fixture
import io.kotlintest.specs.ShouldSpec
import org.assertj.core.api.Assertions.*

/**
 * Created by dvkc73 on 2016-05-25.
 */
class FixtureSpec : ShouldSpec() {
    init {
        should("generate different string each time") {

            val fixture = Fixture()

            val str1 = fixture.create<String>()
            val str2 = fixture.create<String>()

            assertThat(str1).isNotEqualTo(str2)
        }
    }
}
