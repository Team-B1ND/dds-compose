import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.compose.ComposeBuildConfig.composeVersion
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.multiplatform.maven)
    alias(libs.plugins.jetbrains.compose)
    id("maven-publish")
}

kotlin {

    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "DodamDesignsystem"
            isStatic = true
            binaryOptions["bundleId"] = "com.b1nd.dodam.designsystem"
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.androidx.compose.ui.tooling.preview)
            implementation(libs.androidx.compose.ui.tooling)
            implementation(libs.coil.network.okhttp)
        }

        commonMain.dependencies {
            implementation(libs.androidx.core)
            implementation(libs.kotlinx.collections.immutable)
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.animation)
            implementation(libs.compose.components.ui.tooling.preview)

            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlinx.io.core)
            implementation(libs.kotlinx.io.bytestring)

            implementation(libs.coil)
            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor)
            implementation(libs.ktor.client.core)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }

}

compose.resources {
    publicResClass = true
    packageOfResClass = "com.b1nd.dodam.designsystem.resources"
    generateResClass = always
}

mavenPublishing {

    coordinates(
        groupId = "com.b1nd.dodam",
        artifactId = "dodam-design-system",
        version = "1.3.4"
    )

    pom {
        name.set("CMM Library for Dodam Compose Design System")
        description.set("This library is an Android Compose Multi-platform Design System based on the Dodam Dodam Design System.")
        inceptionYear.set("2024")
        url.set("https://github.com/Team-B1ND/dds-compose")

        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        // Specify SCM information
        scm {
            url.set("https://github.com/Team-B1ND/dds-compose")
        }

        // Specify Developer infomation
        developers {
            developer {
                id = "Team-B1ND"
                email = "mdev_team@dgsw.hs.kr"
                name = "Team-B1ND"
            }
        }
    }

    // Configure publishing to Maven Central
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    // Enable GPG signing for all publications
    signAllPublications()
}

android {
    namespace = "com.b1nd.dodam.designsystem"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    composeCompiler {
        enableStrongSkippingMode = true

        reportsDestination = layout.buildDirectory.dir("compose_compiler")
        stabilityConfigurationFile = rootProject.layout.projectDirectory.file("stability_config.conf")
    }
    buildFeatures {
        compose = true
    }
}
