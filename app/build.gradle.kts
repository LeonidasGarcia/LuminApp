plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.luminteam.lumin"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.luminteam.lumin"
        minSdk = 24
        targetSdk = 36
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx) {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation(libs.androidx.lifecycle.runtime.ktx) {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation(libs.androidx.activity.compose) {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation(platform(libs.androidx.compose.bom)) {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation(libs.androidx.compose.ui) {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation(libs.androidx.compose.ui.graphics) {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation(libs.androidx.compose.ui.tooling.preview) {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation(libs.androidx.compose.material3) {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation("com.github.jeziellago:compose-markdown:0.5.7") {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation("io.noties.markwon:core:4.6.2") {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation("io.noties.markwon:syntax-highlight:4.6.2") {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation("io.noties:prism4j:2.0.0") {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation("io.noties.markwon:ext-strikethrough:4.6.2") {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation("io.noties.markwon:ext-tables:4.6.2") {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation("io.noties.markwon:ext-tasklist:4.6.2") {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation("io.noties.markwon:html:4.6.2") {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation("io.noties.markwon:linkify:4.6.2") {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }

    implementation("androidx.appcompat:appcompat:1.7.1") {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation("com.google.android.material:material:1.13.0") {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }

    testImplementation(libs.junit) {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    androidTestImplementation(libs.androidx.junit) {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    androidTestImplementation(libs.androidx.espresso.core) {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    androidTestImplementation(platform(libs.androidx.compose.bom)) {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    androidTestImplementation(libs.androidx.compose.ui.test.junit4) {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    debugImplementation(libs.androidx.compose.ui.tooling) {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    debugImplementation(libs.androidx.compose.ui.test.manifest) {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
}