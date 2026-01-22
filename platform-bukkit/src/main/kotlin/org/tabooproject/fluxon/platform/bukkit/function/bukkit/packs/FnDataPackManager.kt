package org.tabooproject.fluxon.platform.bukkit.function.bukkit.packs

import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.World
import org.bukkit.entity.EntityType
import org.bukkit.packs.DataPackManager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnDataPackManager {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DataPackManager::class.java)
                .function("dataPacks", 0) { it.target?.dataPacks }
                .function("getDataPack", 1) { it.target?.getDataPack(it.getArgument(0) as NamespacedKey) }
                .function("getEnabledDataPacks", 1) { it.target?.getEnabledDataPacks(it.getArgument(0) as World) }
                .function("getDisabledDataPacks", 1) { it.target?.getDisabledDataPacks(it.getArgument(0) as World) }
                .function("isEnabledByFeature", 2) {
                    when (val var1 = it.getArgument(0)) {
                        is Material -> it.target?.isEnabledByFeature(var1, it.getArgument(1) as World)
                        is EntityType -> it.target?.isEnabledByFeature(var1, it.getArgument(1) as World)
                        else -> throw IllegalArgumentException("参数必须是 Material 或 EntityType 类型")
                    }
                }
        }
    }
}
