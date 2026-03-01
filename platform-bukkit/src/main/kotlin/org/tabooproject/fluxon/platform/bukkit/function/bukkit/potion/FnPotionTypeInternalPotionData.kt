package org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion

import org.bukkit.potion.PotionType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.potion.PotionType\$InternalPotionData"])
@PlatformSide(Platform.BUKKIT)
object FnPotionTypeInternalPotionData {

    val TYPE = Type.fromClass(PotionType.InternalPotionData::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.potion.PotionType.InternalPotionData::class.java)
                // static
        }
    }
}
