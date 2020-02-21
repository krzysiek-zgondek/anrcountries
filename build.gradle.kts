plugins {
    `kotlin-dsl`
}

buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        Classpaths.forEach { classpath(it) }
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}