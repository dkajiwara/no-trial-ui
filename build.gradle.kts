plugins {
    java
    kotlin("jvm") version "2.3.20"
    id("org.jetbrains.intellij.platform") version "2.16.0"
}

group = "com.dkajiwara.plugin"
version = "1.0.0"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

// Read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin.html
dependencies {
    intellijPlatform {
        intellijIdea("2026.1")
    }
}

intellijPlatform {
    buildSearchableOptions.set(false)

    pluginConfiguration {
        ideaVersion {
            sinceBuild = "261.22158"
        }

        name = "no-trial-ui"

        changeNotes = """
            Hide trial widget to free up toolbar space.
        """
    }
}

tasks.withType<JavaCompile>().configureEach {
    sourceCompatibility = "21"
    targetCompatibility = "21"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

kotlin {
    jvmToolchain(21)
}
