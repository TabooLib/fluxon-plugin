package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.components

import org.bukkit.Material
import org.bukkit.Tag
import org.bukkit.inventory.meta.components.ToolComponent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
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
                    when (val var1 = it.getArgument(0)) {
                        is Material -> it.target?.addRule(var1, it.getNumber(1).toFloat(), it.getBoolean(2))
                        is Collection<*> -> it.target?.addRule(
                            var1 as Collection<Material>,
                            it.getNumber(1).toFloat(),
                            it.getBoolean(2)
                        )

                        is Tag<*> -> it.target?.addRule(
                            var1 as Tag<Material>,
                            it.getNumber(1).toFloat(),
                            it.getBoolean(2)
                        )

                        else -> throw IllegalArgumentException("参数 1 必须是 Material, Collection<Material>, 或 Tag<Material> 类型")
                    }
                }
                .function("removeRule", 1) { it.target?.removeRule(it.getArgument(0) as ToolComponent.ToolRule) }

            registerExtension(ToolComponent.ToolRule::class.java)
                .function("blocks", 0) { it.target?.blocks }
                .function("setBlocks", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is Material -> (it.target as? ToolComponent.ToolRule)?.setBlocks(var1)
                        is Collection<*> -> (it.target as? ToolComponent.ToolRule)?.setBlocks(var1 as Collection<Material>)
                        is Tag<*> -> (it.target as? ToolComponent.ToolRule)?.setBlocks(var1 as Tag<Material>)
                        else -> throw IllegalArgumentException("参数 1 必须是 Material, Collection<Material>, 或 Tag<Material> 类型")
                    }
                }
                .function("speed", 0) { it.target?.speed }
                .function("setSpeed", 1) { it.target?.setSpeed(it.getNumber(0).toFloat()) }
                .function("isCorrectForDrops", 0) { it.target?.isCorrectForDrops() }
                .function("setCorrectForDrops", 1) { it.target?.setCorrectForDrops(it.getBoolean(0)) }
        }
    }
}
