package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Material
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMaterial {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Material::class.java)
                .function("isSolid", 0) { it.target?.isSolid }
                .function("isItem", 0) { it.target?.isItem }
                .function("isRecord", 0) { it.target?.isRecord }
                .function("isOccluding", 0) { it.target?.isOccluding }
                .function("isInteractable", 0) { it.target?.isInteractable }
                .function("isFuel", 0) { it.target?.isFuel }
                .function("isFlammable", 0) { it.target?.isFlammable }
                .function("isEdible", 0) { it.target?.isEdible }
                .function("isBurnable", 0) { it.target?.isBurnable }
                .function("isBlock", 0) { it.target?.isBlock }
                .function("isAir", 0) { it.target?.isAir }
                .function("hasGravity", 0) { it.target?.hasGravity() }
                .function("slipperiness", 0) { it.target?.slipperiness }
                .function("hardness", 0) { it.target?.hardness }
                .function("slot", 0) { it.target?.equipmentSlot?.name }
                .function("blastResistance", 0) { it.target?.blastResistance }
                .function("creativeCategory", 0) { it.target?.creativeCategory }
                .function("maxDurability", 0) { it.target?.maxDurability }
        }
    }
}
