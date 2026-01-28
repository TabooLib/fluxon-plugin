package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.TreeSpecies
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.TreeSpecies"])
@PlatformSide(Platform.BUKKIT)
object FnTreeSpecies {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TreeSpecies::class.java)
                .function("data", returnsObject().noParams()) { it.target?.data }
                // static
                .function("getByData", returnsObject().params(Type.OBJECT)) { TreeSpecies.getByData(it.getInt(0).toByte()) }
        }
    }
}
