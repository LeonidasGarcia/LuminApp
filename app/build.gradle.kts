plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.luminteam.lumin"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.luminteam.lumin"
        minSdk = 34
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
    implementation("com.github.qawaz:compose-code-editor:2.0.3") {
        exclude(group = "org.jetbrains", module = "annotations-java5")
    }
    implementation(libs.androidx.compose.foundation)
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
    implementation("androidx.credentials:credentials:1.6.0-beta03")
    implementation("androidx.credentials:credentials-play-services-auth:1.6.0-beta03")
    implementation("com.google.android.libraries.identity.googleid:googleid:1.1.1")
    implementation(platform("com.google.firebase:firebase-bom:34.4.0"))
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.android.gms:play-services-auth:21.0.0")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.9.4")

    implementation("io.ktor:ktor-client-core:3.1.2")
    implementation("io.ktor:ktor-client-cio:3.1.2")
    implementation("io.ktor:ktor-client-content-negotiation:3.1.2")
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.1.2")

    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.lifecycle.viewmodel.navigation3)
    implementation(libs.androidx.material3.adaptive.navigation3)
    implementation(libs.kotlinx.serialization.core)

    implementation("com.google.accompanist:accompanist-systemuicontroller:0.34.0")

    implementation("androidx.core:core-splashscreen:1.0.1")
}