package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.serialization

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.configuration.serialization.ConfigurationSerializable"])
@PlatformSide(Platform.BUKKIT)
object FnConfigurationSerializable {

    val TYPE = Type.fromClass(org.bukkit.configuration.serialization.ConfigurationSerializable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.configuration.serialization.ConfigurationSerializable::class.java)
                .function("serialize", returns(Type.MAP).noParams()) { it.setReturnRef(it.target?.serialize()) }
        }
    }
}
