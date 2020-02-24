import com.android.build.gradle.internal.dsl.SigningConfig

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    kotlin("kapt")
}

android {
    val ciProperties = readProperties("version.properties")
        ?: throw IllegalStateException("need version file")

    compileSdkVersion(29)

    buildToolsVersion = "29.0.2"

    signingConfigs {
        getByName("debug") {
            applySignings("signings.properties", "debug")
        }
        register("release") {
            applySignings("signings.properties", "release")
        }
    }

    defaultConfig {
        applicationId = ciProperties.getProperty("applicationId")
        versionCode = ciProperties.getProperty("versionCode")?.toInt()
        versionName = ciProperties.getProperty("ciVersionName")

        minSdkVersion(21)
        targetSdkVersion(29)
    }

    buildTypes {
        getByName("debug") {
            signingConfig = signingConfigs["debug"]
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"

            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("release") {
            signingConfig = signingConfigs["release"]
            versionNameSuffix = "-release"

            isMinifyEnabled = true
            isShrinkResources = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    sourceSets["main"].java.srcDir("src/main/kotlin")
    sourceSets["test"].java.srcDir("src/test/kotlin")

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    bundle{
        abi{
            enableSplit = false
        }
    }

    testOptions {
        unitTests.apply{
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))

    DependenciesAndroid.forEach { (type, name) -> add(type, name) }
}

fun SigningConfig.applySignings(path: String, type: String) {
    val properties = readProperties(path)
        ?: throw IllegalStateException("need signing keys")

    storeFile = file(properties.getProperty("keyStoreFile"))
    storePassword = properties.getProperty("keyStorePassword")
    keyAlias = properties.getProperty("${type}KeyAlias")
    keyPassword = properties.getProperty("${type}KeyPassword")
}