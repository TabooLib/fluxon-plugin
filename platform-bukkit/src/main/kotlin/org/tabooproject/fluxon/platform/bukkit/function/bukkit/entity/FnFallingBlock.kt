package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.FallingBlock
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.FallingBlock"])
@PlatformSide(Platform.BUKKIT)
object FnFallingBlock {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FallingBlock::class.java)
                .function("material", 0) { it.target?.material }
                .function("blockData", 0) { it.target?.blockData }
                .function("dropItem", 0) { it.target?.dropItem }
                .function("setDropItem", 1) { it.target?.setDropItem(it.getBoolean(0)) }
                .function("cancelDrop", 0) { it.target?.cancelDrop }
                .function("setCancelDrop", 1) { it.target?.setCancelDrop(it.getBoolean(0)) }
                .function("canHurtEntities", 0) { it.target?.canHurtEntities() }
                .function("setHurtEntities", 1) { it.target?.setHurtEntities(it.getBoolean(0)) }
                .function("damagePerBlock", 0) { it.target?.damagePerBlock }
                .function("setDamagePerBlock", 1) { it.target?.setDamagePerBlock(it.getNumber(0).toFloat()) }
                .function("maxDamage", 0) { it.target?.maxDamage }
                .function("setMaxDamage", 1) { it.target?.setMaxDamage(it.getNumber(0).toInt()) }
        }
    }
}
