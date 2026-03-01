package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.configuration.file.YamlRepresenter\$RepresentConfigurationSerializable"])
@PlatformSide(Platform.BUKKIT)
object FnYamlRepresenterRepresentConfigurationSerializable {

    private val clazz = Class.forName("org.bukkit.configuration.file.YamlRepresenter\$RepresentConfigurationSerializable")


    val TYPE = Type.fromClass(clazz)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(clazz)
                // static
        }
    }
}
