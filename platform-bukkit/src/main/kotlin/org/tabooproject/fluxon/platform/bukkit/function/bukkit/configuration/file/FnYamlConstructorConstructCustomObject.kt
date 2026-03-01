package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.configuration.file.YamlConstructor\$ConstructCustomObject"])
@PlatformSide(Platform.BUKKIT)
object FnYamlConstructorConstructCustomObject {

    private val clazz = Class.forName("org.bukkit.configuration.file.YamlConstructor\$ConstructCustomObject")


    val TYPE = Type.fromClass(clazz)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(clazz)
                // static
        }
    }
}
