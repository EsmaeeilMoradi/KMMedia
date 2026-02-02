import org.gradle.kotlin.dsl.invoke

plugins {
    alias(libs.plugins.android.library)
    kotlin("multiplatform")

}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {

                implementation(libs.kotlinx.coroutines.core)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.core.ktx)
                implementation(libs.androidx.appcompat)
                implementation(libs.material)
                implementation(libs.androidx.media3.exoplayer)
                implementation(libs.media3.ui)
            }
        }

        val iosMain by creating {
            dependsOn(commonMain)
        }
    }
}

android {
    namespace = "com.esm.media_core"
    compileSdk = 36

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}



