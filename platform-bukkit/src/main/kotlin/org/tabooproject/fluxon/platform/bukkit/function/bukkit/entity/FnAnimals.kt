package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Animals
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*

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
                    // boolean isBreedItem(@NotNull ItemStack var1)
                    // boolean isBreedItem(@NotNull Material var1)
                    TODO()
                }
        }
    }
}
