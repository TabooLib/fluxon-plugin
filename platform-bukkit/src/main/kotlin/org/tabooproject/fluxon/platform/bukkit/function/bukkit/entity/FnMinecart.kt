package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.block.data.BlockData
import org.bukkit.entity.Minecart
import org.bukkit.material.MaterialData
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMinecart {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Minecart::class.java)
                .function("setDamage", 1) { it.target?.setDamage(it.getNumber(0).toDouble()) }
                .function("damage", 0) { it.target?.damage }
                .function("maxSpeed", 0) { it.target?.maxSpeed }
                .function("setMaxSpeed", 1) { it.target?.setMaxSpeed(it.getNumber(0).toDouble()) }
                .function("isSlowWhenEmpty", 0) { it.target?.isSlowWhenEmpty }
                .function("setSlowWhenEmpty", 1) { it.target?.setSlowWhenEmpty(it.getBoolean(0)) }
                .function("flyingVelocityMod", 0) { it.target?.flyingVelocityMod }
                .function("setFlyingVelocityMod", 1) { it.target?.setFlyingVelocityMod(it.getArgument(0) as Vector) }
                .function("derailedVelocityMod", 0) { it.target?.derailedVelocityMod }
                .function(
                    "setDerailedVelocityMod",
                    1
                ) { it.target?.setDerailedVelocityMod(it.getArgument(0) as Vector) }
                .function("setDisplayBlock", 1) { it.target?.setDisplayBlock(it.getArgument(0) as MaterialData) }
                .function("displayBlock", 0) { it.target?.displayBlock }
                .function("setDisplayBlockData", 1) { it.target?.setDisplayBlockData(it.getArgument(0) as BlockData) }
                .function("displayBlockData", 0) { it.target?.displayBlockData }
                .function("setDisplayBlockOffset", 1) { it.target?.setDisplayBlockOffset(it.getNumber(0).toInt()) }
                .function("displayBlockOffset", 0) { it.target?.displayBlockOffset }
        }
    }
}
