package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Material
import org.bukkit.entity.Animals
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnAnimals {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Animals::class.java)
                .function("breedCause", 0) { it.target?.breedCause }
                .function("setBreedCause", 1) { it.target?.setBreedCause(UUID.fromString(it.getString(0))) }
                .function("isLoveMode", 0) { it.target?.isLoveMode }
                .function("loveModeTicks", 0) { it.target?.loveModeTicks }
                .function("setLoveModeTicks", 1) { it.target?.setLoveModeTicks(it.getNumber(0).toInt()) }
                .function("isBreedItem", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is ItemStack -> it.target?.isBreedItem(var1)
                        is Material -> it.target?.isBreedItem(var1)
                        else -> throw IllegalArgumentException("参数必须是 ItemStack 或 Material 类型")
                    }
                }
        }
    }
}
