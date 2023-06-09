import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin:Plugin<Project> {
    override fun apply(target: Project) {

        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            pluginManager.apply("com.android.application")
            extensions.getByType<ApplicationExtension>().apply {
                buildFeatures {
                    compose = true
                }
                composeOptions {
                    kotlinCompilerExtensionVersion = "1.4.6"
                }
            }
            dependencies {
                val bom = libs.findLibrary("compose-bom").get()
                add("implementation", platform(bom))
                add("androidTestImplementation", platform(bom))
                add("implementation",libs.findLibrary("ui").get())
                add("implementation",libs.findLibrary("ui-tooling-preview").get())
                add("implementation",libs.findLibrary("ui-graphics").get())
                add("implementation",libs.findLibrary("material3").get())
                add("debugImplementation",libs.findLibrary("ui-tooling").get())
            }
        }
    }
}