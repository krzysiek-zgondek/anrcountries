import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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

    tasks {
        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
}