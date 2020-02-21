object AndroidGradle {
    const val version = "3.5.3"
    const val classpath = "com.android.tools.build:gradle:$version"
}

object KotlinGradle {
    const val version = "1.3.61"
    const val classpath = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

    val dependencies = arrayOf(
        "implementation" to "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
    )
}

object KotlinCoroutines {
    const val version = "1.3.3"
    val dependencies = arrayOf(
        "implementation" to "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    )
}

object KotlinCoroutinesAndroid {
    val dependencies = arrayOf(
        "implementation" to "org.jetbrains.kotlinx:kotlinx-coroutines-android:${KotlinCoroutines.version}"
    )
}

object AndroidX {
    val lifecycleVersion = "2.2.0"

    val dependencies = arrayOf(
        "implementation" to "androidx.appcompat:appcompat:1.1.0",
        "implementation" to "androidx.recyclerview:recyclerview:1.1.0",
        "implementation" to "androidx.swiperefreshlayout:swiperefreshlayout:1.0.0",
        "implementation" to "androidx.constraintlayout:constraintlayout:1.1.3",
        "implementation" to "androidx.core:core-ktx:1.2.0",
        "implementation" to "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion",
        "implementation" to "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
    )
}

object Koin {
    const val version = "2.0.1"

    val dependencies = arrayOf(
        "implementation" to "org.koin:koin-core:$version"
    )
}

object KoinAndroid {
    val dependencies = arrayOf(
        "implementation" to "org.koin:koin-android:${Koin.version}",
        "implementation" to "org.koin:koin-androidx-viewmodel:${Koin.version}"
    )
}

object Retrofit {
    const val version = "2.7.1"

    val dependencies = arrayOf(
        "implementation" to "com.squareup.retrofit2:retrofit:$version",
        "implementation" to "com.squareup.retrofit2:converter-moshi:$version"
    )
}

object OkHttp {
    const val version = "4.4.0"

    val dependencies = arrayOf(
        "implementation" to "com.squareup.okhttp3:logging-interceptor:$version"
    )
}

object Moshi {
    const val version = "1.9.2"

    val dependencies = arrayOf(
        "implementation" to "com.squareup.moshi:moshi:$version",
        "implementation" to "com.squareup.moshi:moshi-kotlin:$version"
    )
}

object ThreeTen {
    const val version = "1.4.1"

    val dependencies = arrayOf(
        "implementation" to "org.threeten:threetenbp:$version"
    )
}

object Tests {
    val dependencies = arrayOf(
        "testImplementation" to "junit:junit:4.12",
        "testImplementation" to "org.mockito:mockito-core:3.2.4"
    )
}

val Classpaths = listOf(
    KotlinGradle.classpath,
    AndroidGradle.classpath
)

val DependenciesAndroid =
    KotlinGradle.dependencies +
            KotlinCoroutines.dependencies +
            KotlinCoroutinesAndroid.dependencies +
            AndroidX.dependencies +
            Koin.dependencies +
            KoinAndroid.dependencies +
            Retrofit.dependencies +
            Moshi.dependencies +
            Tests.dependencies

val DependenciesData =
    KotlinGradle.dependencies +
            KotlinCoroutines.dependencies +
            Koin.dependencies +
            Retrofit.dependencies +
            Moshi.dependencies +
            OkHttp.dependencies +
            ThreeTen.dependencies +
            Tests.dependencies

val DependenciesDomain =
    KotlinGradle.dependencies +
            KotlinCoroutines.dependencies +
            Tests.dependencies
