#The standard build processes of the Android SDK (with Ant, Gradle, Android Studio, and Eclipse)
#already integrate ProGuard with all the proper settings. You only need to enable ProGuard.

# Uncomment this to preserve the line number information for
# debugging stack traces.
-keepattributes SourceFile,LineNumberTable

-keep class com.source.countries.listcountries.model.** { *; }

#moshi kotlin reflect
-keep class kotlin.reflect.jvm.internal.** { *; }
-keep class kotlin.Metadata { *; }