@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id ("kotlin-kapt")

}

android {
    namespace = "com.testcase.junit_testcase"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.testcase.junit_testcase"
        minSdk = 26
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    kapt {
        correctErrorTypes = true
    }

    sourceSets {
        val sharedTestDir = "src/sharedTest/java"
        getByName("test") {
            java.srcDir(sharedTestDir)
        }
        getByName("androidTest") {
            java.srcDirs(sharedTestDir)
        }
    }

}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)

    testImplementation(libs.junit)


    // To use the androidx.test.core APIs
    androidTestImplementation("androidx.test:core:1.5.0")
    // Kotlin extensions for androidx.test.core
    androidTestImplementation("androidx.test:core-ktx:1.5.0")

    // To use the JUnit Extension APIs
    androidTestImplementation(libs.androidx.test.ext.junit)
    // Kotlin extensions for androidx.test.ext.junit
    androidTestImplementation ("androidx.test.ext:junit-ktx:1.1.5")

    // To use the androidx.test.espresso
    androidTestImplementation(libs.espresso.core)

    // AndroidJUnitRunner and JUnit Rules
    androidTestImplementation("androidx.test:rules:1.5.0")

    //which enables validation and stubbing of intents sent out by the application under test.
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.5.1")

    implementation ("com.google.code.gson:gson:2.10.1")


    implementation("androidx.room:room-runtime:2.6.1")
//    annotationProcessor("androidx.room:room-compiler:2.6.1")
    implementation ("androidx.room:room-ktx:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")


    //Room Testing lib
    testImplementation ("androidx.room:room-testing:2.6.1")
    androidTestImplementation ("androidx.room:room-testing:2.6.1")

    // Dependencies for working with Architecture components (room,liveData)
    testImplementation  ("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation ("androidx.arch.core:core-testing:2.2.0")

    // Mockito framework
    testImplementation ("org.mockito:mockito-core:4.0.0")
    //mockito-kotlin
    testImplementation ("org.mockito.kotlin:mockito-kotlin:3.2.0")
    // for support final class in kotlin
    testImplementation ("org.mockito:mockito-inline:2.13.0")


    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0-RC2")



    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // test mock web server to test HTTP clint like retrofit
    testImplementation ("com.squareup.okhttp3:mockwebserver:5.0.0-alpha.12")



    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.activity:activity-ktx:1.8.2")



}

