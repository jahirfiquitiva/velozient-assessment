# kotlin-project-template

**dependency versions:**

- [kotlin 1.8.0](https://github.com/JetBrains/kotlin/releases/tag/v1.8.0)
- [gradle 7.5](https://github.com/gradle/gradle/releases/tag/v7.5.0)
- [junit 5.9.2](https://github.com/junit-team/junit5/releases/tag/r5.9.2)

**run gradle build.**

~~~sh
$ ./gradlew build
~~~

**run gradle tests.**

~~~sh
$ ./gradlew test
~~~

**sample main file.**

~~~kotlin
package hello

fun main(vararg args: String) {
    println("hello world!")
}
~~~

**sample test file.**

~~~kotlin
package hello

import kotlin.test.Test
import kotlin.test.assertEquals

class WorldTest {

    @Test
    fun `2 + 3 equals 5`() {
        assertEquals(5, 2 + 3)
    }

}
~~~
