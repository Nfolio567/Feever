import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)

    id("com.google.gms.google-services")
    kotlin("plugin.serialization") version "2.3.0"
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            export("io.github.mirzemehdi:kmpnotifier:1.6.1")
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    jvm()
    
    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            // https://mvnrepository.com/artifact/io.github.mirzemehdi/kmpnotifier
            implementation("io.github.mirzemehdi:kmpnotifier:1.6.1")
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            api("io.github.mirzemehdi:kmpnotifier:1.6.1")
            // https://mvnrepository.com/artifact/com.squareup.okio/okio
            implementation("com.squareup.okio:okio:3.16.4")
            // Source: https://mvnrepository.com/artifact/io.ktor/ktor-client-core
            implementation("io.ktor:ktor-client-core:3.3.3")
            // Source: https://mvnrepository.com/artifact/io.ktor/ktor-client-cio
            implementation("io.ktor:ktor-client-cio:3.3.3")
            // Source: https://mvnrepository.com/artifact/io.ktor/ktor-client-content-negotiation
            implementation("io.ktor:ktor-client-content-negotiation:3.3.3")
            // Source: https://mvnrepository.com/artifact/io.ktor/ktor-serialization-kotlinx-json
            implementation("io.ktor:ktor-serialization-kotlinx-json:3.3.3")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
        }
    }
}

android {
    namespace = "one.nfolio.feever"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "one.nfolio.feever"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "one.nfolio.feever.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "one.nfolio.feever"
            packageVersion = "1.0.0"
        }
    }
}
