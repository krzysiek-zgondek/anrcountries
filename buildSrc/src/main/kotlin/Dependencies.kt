object AndroidGradle {
    const val version = "3.5.3"
    const val classpath = "com.android.tools.build:gradle:$version"
}

object KotlinGradle {
    const val version = "1.3.61"
    const val classpath = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

    val dependencies = arrayOf(
        "implementation" to "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
    )
}

object AndroidX {
    val dependencies = arrayOf(
        "implementation" to "androidx.appcompat:appcompat:1.1.0",
        "implementation" to "androidx.core:core-ktx:1.2.0"
    )
}

object Tests {
    val dependencies = arrayOf(
        "testImplementation" to "junit:junit:4.12"
    )
}

val Classpaths = listOf(
    KotlinGradle.classpath,
    AndroidGradle.classpath
)

val Dependencies =
    KotlinGradle.dependencies + AndroidX.dependencies + Tests.dependencies

