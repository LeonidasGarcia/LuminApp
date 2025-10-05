import org.gradle.kotlin.dsl.credentials
import org.gradle.kotlin.dsl.get
import java.io.FileInputStream
import java.util.Properties

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

val githubProperties = Properties()
try {
    githubProperties.load(FileInputStream(rootDir.resolve("github.properties")))
} catch (ignored: Exception) {

}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.github.com/Qawaz/compose-code-editor") {
            name = "GitHubPackages"
            credentials {
                username =
                    (githubProperties["gpr.usr"] ?: System.getenv("GPR_USER")).toString()
                password =
                    (githubProperties["gpr.key"] ?: System.getenv("GPR_API_KEY")).toString()
            }
        }
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "Lumin"
include(":app")
