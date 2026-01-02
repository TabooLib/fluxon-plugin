import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_1_8
import io.izzel.taboolib.gradle.Basic
import io.izzel.taboolib.gradle.CommandHelper
import io.izzel.taboolib.gradle.Bukkit
import io.izzel.taboolib.gradle.BukkitNMS
import io.izzel.taboolib.gradle.BukkitNMSUtil
import io.izzel.taboolib.gradle.BukkitUtil
import io.izzel.taboolib.gradle.Velocity
import io.izzel.taboolib.gradle.BungeeCord
import io.izzel.taboolib.gradle.MinecraftChat


plugins {
    java
    id("io.izzel.taboolib") version "2.0.27"
    id("org.jetbrains.kotlin.jvm") version "2.2.0"
}

taboolib {
    env {
        install(Basic)
        install(CommandHelper)
        install(MinecraftChat)
        install(Bukkit)
        install(BukkitUtil)
        install(BukkitNMS)
        install(BukkitNMSUtil)
        install(Velocity)
        install(BungeeCord)
        // repoTabooLib = project.repositories.mavenLocal().url.toString()
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
    taboo("org.tabooproject.fluxon:core:1.4.5") { isTransitive = false }
    taboo("org.tabooproject.fluxon:inst-core:1.4.5") { isTransitive = false }
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

// 子模块统一配置
configure(subprojects) {
    apply(plugin = "java")
    apply(plugin = "io.izzel.taboolib")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    taboolib {
        env {
            install(Basic)
            install(MinecraftChat)
        }
        version { taboolib = "6.2.4-5902762" }
    }
    
    repositories {
        mavenCentral()
    }
    
    dependencies {
        taboo("org.tabooproject.fluxon:core:1.4.5") { isTransitive = false }
        compileOnly(kotlin("stdlib"))
        compileOnly(rootProject.fileTree("libs"))
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
}

// Shade打包：将所有子模块合并到一个jar
tasks {
    jar {
        archiveBaseName.set("FluxonPlugin")
        from(rootProject.findProject(":platform-bukkit")!!.sourceSets["main"].output)
        from(rootProject.findProject(":platform-bungeecord")!!.sourceSets["main"].output)
        from(rootProject.findProject(":platform-velocity")!!.sourceSets["main"].output)
    }
}