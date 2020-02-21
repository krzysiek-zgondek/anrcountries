plugins {
    kotlin("jvm")
    `java-library`
}

sourceSets {
    main {
        java.srcDir("src/main/kotlin")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    compileOnly(gradleApi())

    DependenciesDomain.forEach { (type, name) -> add(type, name) }
}
