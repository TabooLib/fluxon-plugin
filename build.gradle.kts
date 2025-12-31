import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_1_8
import io.izzel.taboolib.gradle.Basic
import io.izzel.taboolib.gradle.CommandHelper
import io.izzel.taboolib.gradle.Bukkit
import io.izzel.taboolib.gradle.Velocity
import io.izzel.taboolib.gradle.BungeeCord


plugins {
    java
    id("io.izzel.taboolib") version "2.0.27"
    id("org.jetbrains.kotlin.jvm") version "2.2.0"
}

taboolib {
    env {
        install(Basic)
        install(CommandHelper)
        install(Bukkit)
        install(Velocity)
        install(BungeeCord)
    }
    description {
        name = "FluxonPlugin"
        contributors {
            name("sky")
        }
    }
    version { taboolib = "6.2.4-5902762" }
}

repositories {
    mavenCentral()
}

dependencies {
    taboo("org.tabooproject.fluxon:core:1.4.3")
    // compileOnly("ink.ptms.core:v12004:12004:mapped")
    // compileOnly("ink.ptms.core:v12004:12004:universal")
    compileOnly(kotlin("stdlib"))
    compileOnly(fileTree("libs"))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<KotlinCompile> {
    compilerOptions {
        jvmTarget.set(JVM_1_8)
        freeCompilerArgs.add("-Xjvm-default=all")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}