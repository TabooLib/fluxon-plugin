package org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion

import org.bukkit.potion.PotionData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.potion.PotionData"])
@PlatformSide(Platform.BUKKIT)
object FnPotionData {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionData::class.java)
                .function("type", 0) { it.target?.type }
                .function("isUpgraded", 0) { it.target?.isUpgraded }
                .function("isExtended", 0) { it.target?.isExtended }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
        }
    }
}
