plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "huutuong_63131631.ungdungbanhang"
    compileSdk = 35

    defaultConfig {
        applicationId = "huutuong_63131631.ungdungbanhang"
        minSdk = 25
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

dependencies {
    //glider
    implementation (libs.glide)
    //rxjava
    implementation (libs.rxandroid)
    implementation ("io.reactivex.rxjava3:rxjava:3.0.0")
    // Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation ("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}