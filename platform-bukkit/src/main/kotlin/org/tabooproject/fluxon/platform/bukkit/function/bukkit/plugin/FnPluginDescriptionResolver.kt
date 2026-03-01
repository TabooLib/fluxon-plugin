package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.plugin.PluginDescriptionResolver"])
@PlatformSide(Platform.BUKKIT)
object FnPluginDescriptionResolver {

    private val clazz = Class.forName("org.bukkit.plugin.PluginDescriptionResolver")


    val TYPE = Type.fromClass(clazz)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(clazz)
                // .function("addImplicitResolvers", returnsVoid().noParams()) { it.target?.addImplicitResolvers() }
        }
    }
}
