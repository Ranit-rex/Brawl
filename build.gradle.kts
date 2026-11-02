plugins {
    id("com.android.library")
}

android {
    namespace = "com.neowarriors.admobbridge"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    implementation("com.google.android.gms:play-services-ads:25.5.0")
}
