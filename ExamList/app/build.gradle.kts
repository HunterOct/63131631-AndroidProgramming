plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "ntu.huutuong.examlist"
    compileSdk = 34

    defaultConfig {
        applicationId = "ntu.huutuong.examlist"
        minSdk = 25
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
//    implementation("com.android.support:recyclerview-v7:25.0.0")
//    implementation("com.android.support:appcompat-v7:25.0.0")
//    implementation("com.android.support:design:23.0.1")
//    implementation("com.prolificinteractive:material-calendarview:1.7.0")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}