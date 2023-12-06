plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = libs.versions.sdk.compile.get().toInt()

    buildFeatures {
        compose = true
    }

    defaultConfig {
        applicationId = "com.mxalbert.sharedelements.demo"
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()
        versionName = project.property("VERSION_NAME") as String
        versionCode = 1
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    namespace = "com.mxalbert.sharedelements.demo"
}

dependencies {
    implementation(platform(libs.compose.bom))
    implementation(projects.sharedElements)
    implementation(libs.androidx.core)
    implementation(libs.androidx.activity.compose)
    implementation(libs.compose.ui.ui)
    implementation(libs.compose.material.material)
}
