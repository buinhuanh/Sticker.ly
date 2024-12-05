// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
//    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.android.application") version "8.2.0" apply false  // Cập nhật lên phiên bản mới hơn (8.2.0 hoặc cao hơn)
    id("com.android.library") version "8.2.0" apply false
    alias(libs.plugins.google.gms.google.services) apply false
}