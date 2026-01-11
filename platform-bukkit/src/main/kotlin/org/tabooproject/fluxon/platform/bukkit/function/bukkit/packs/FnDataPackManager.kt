package org.tabooproject.fluxon.platform.bukkit.function.bukkit.packs

import org.bukkit.NamespacedKey
import org.bukkit.World
import org.bukkit.packs.DataPackManager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnDataPackManager {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DataPackManager::class.java)
                .function("dataPacks", 0) { it.target?.dataPacks }
                .function("dataPack", 1) { it.target?.getDataPack(it.getArgument(0) as NamespacedKey) }
                .function("enabledDataPacks", 1) { it.target?.getEnabledDataPacks(it.getArgument(0) as World) }
                .function("disabledDataPacks", 1) { it.target?.getDisabledDataPacks(it.getArgument(0) as World) }
                .function("isEnabledByFeature", 2) {
                    // boolean isEnabledByFeature(@NotNull Material var1, @NotNull World var2)
                    // boolean isEnabledByFeature(@NotNull EntityType var1, @NotNull World var2)
                    TODO()
                }
        }
    }
}
