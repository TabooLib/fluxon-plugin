package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.MaterialData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMaterialData {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MaterialData::class.java)
                .function("data", 0) { it.target?.data }
                .function("setData", 1) { it.target?.setData(it.getNumber(0).toByte()) }
                .function("itemType", 0) { it.target?.itemType }
                .function("toItemStack", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.toItemStack()
                    } else {
                        it.target?.toItemStack(it.getNumber(0).toInt())
                    }
                }
                .function("toString", 0) { it.target?.toString() }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
