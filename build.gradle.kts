import kotlinx.coroutines.suspendAtomicCancellableCoroutine

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val hiltPluginVersion by extra("2.36")
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.0-alpha01")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltPluginVersion")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
