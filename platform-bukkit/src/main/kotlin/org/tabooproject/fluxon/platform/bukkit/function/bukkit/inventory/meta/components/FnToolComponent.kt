package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.components

import org.bukkit.inventory.meta.components.ToolComponent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnToolComponent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ToolComponent::class.java)
                .function("defaultMiningSpeed", 0) { it.target?.defaultMiningSpeed }
                .function("setDefaultMiningSpeed", 1) { it.target?.setDefaultMiningSpeed(it.getNumber(0).toFloat()) }
                .function("damagePerBlock", 0) { it.target?.damagePerBlock }
                .function("setDamagePerBlock", 1) { it.target?.setDamagePerBlock(it.getNumber(0).toInt()) }
                .function("rules", 0) { it.target?.rules }
                .function("setRules", 1) { it.target?.setRules(it.getArgument(0) as List<ToolComponent.ToolRule>) }
                .function("addRule", 3) {
                    // ToolRule addRule(@NotNull Material var1, @Nullable Float var2, @Nullable Boolean var3)
                    // ToolRule addRule(@NotNull Collection<Material> var1, @Nullable Float var2, @Nullable Boolean var3)
                    // ToolRule addRule(@NotNull Tag<Material> var1, @Nullable Float var2, @Nullable Boolean var3)
                    TODO()
                }
                .function("removeRule", 1) { it.target?.removeRule(it.getArgument(0) as ToolComponent.ToolRule) }

            registerExtension(ToolComponent.ToolRule::class.java)
                .function("blocks", 0) { it.target?.blocks }
                .function("setBlocks", 1) {
                    // void setBlocks(@NotNull Material var1)
                    // void setBlocks(@NotNull Collection<Material> var1)
                    // void setBlocks(@NotNull Tag<Material> var1)
                    TODO()
                }
                .function("speed", 0) { it.target?.speed }
                .function("setSpeed", 1) { it.target?.setSpeed(it.getNumber(0).toFloat()) }
                .function("isCorrectForDrops", 0) { it.target?.isCorrectForDrops() }
                .function("setCorrectForDrops", 1) { it.target?.setCorrectForDrops(it.getBoolean(0)) }
        }
    }
}
