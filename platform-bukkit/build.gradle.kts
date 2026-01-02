import io.izzel.taboolib.gradle.Bukkit
import io.izzel.taboolib.gradle.BukkitNMS
import io.izzel.taboolib.gradle.BukkitNMSUtil
import io.izzel.taboolib.gradle.BukkitUtil

taboolib {
    env {
        install(Bukkit)
        install(BukkitUtil)
        install(BukkitNMS)
        install(BukkitNMSUtil)
    }
    subproject = true
}


dependencies {
    compileOnly("ink.ptms.core:v12006:12006:mapped")
    compileOnly("public:PlaceholderAPI:2.10.9")
    compileOnly("ink.ptms.adyeshach:api:2.1.27")
}