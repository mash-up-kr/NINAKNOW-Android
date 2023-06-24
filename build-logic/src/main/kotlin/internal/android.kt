/*
 * Designed and developed by "옴마야" Team 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/mash-up-kr/WeQuiz-Android/blob/main/LICENSE
 */

@file:Suppress("UnstableApiUsage")

package internal

import Plugins
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

internal fun Project.configureAndroid(extension: CommonExtension<*, *, *, *>) {
    extension.apply {
        compileSdk = ApplicationConstants.CompileSdk

        defaultConfig {
            minSdk = ApplicationConstants.MinSdk
        }

        sourceSets {
            getByName("main").java.srcDir("src/main/kotlin")
        }

        compileOptions {
            sourceCompatibility = ApplicationConstants.JavaVersion
            targetCompatibility = ApplicationConstants.JavaVersion
        }

        extensions.configure<KotlinProjectExtension> {
            jvmToolchain(ApplicationConstants.JavaVersionAsInt)
        }

        if (pluginManager.hasPlugin(libs.findPlugin("kotlin-detekt").get().get().pluginId)) {
            dependencies.add("detektPlugins", libs.findLibrary("detekt-plugin-formatting").get())
        }
    }
}

internal val Project.isAndroidProject: Boolean
    get() = pluginManager.hasPlugin(Plugins.AndroidApplication) ||
            pluginManager.hasPlugin(Plugins.AndroidLibrary)

internal val Project.androidExtensions: CommonExtension<*, *, *, *>
    get() {
        return if (pluginManager.hasPlugin(Plugins.AndroidApplication)) {
            extensions.getByType<BaseAppModuleExtension>()
        } else if (pluginManager.hasPlugin(Plugins.AndroidLibrary)) {
            extensions.getByType<LibraryExtension>()
        } else {
            throw GradleException("The provided project does not have the Android plugin applied. ($name)")
        }
    }
