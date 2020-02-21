plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    //extract to properties
    val ciVersionCode = 1
    val ciVersionName = "1.0"

    val sdkMin = 21
    val sdkMax = 29

    compileSdkVersion(sdkMax)

    buildToolsVersion = "29.0.2"

    defaultConfig {
        applicationId = "com.source.countries"
        versionCode = ciVersionCode
        versionName = ciVersionName

        minSdkVersion(sdkMin)
        targetSdkVersion(sdkMax)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    Dependencies.forEach { (type, name) ->
        add(type, name)
    }
}
