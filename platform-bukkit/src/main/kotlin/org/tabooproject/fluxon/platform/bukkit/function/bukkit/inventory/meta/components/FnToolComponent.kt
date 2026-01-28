package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.components

import org.bukkit.Material
import org.bukkit.Tag
import org.bukkit.inventory.meta.components.ToolComponent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.components.ToolComponent"])
@PlatformSide(Platform.BUKKIT)
object FnToolComponent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ToolComponent::class.java)
                .function("defaultMiningSpeed", returnsObject().noParams()) { it.target?.defaultMiningSpeed }
                .function("setDefaultMiningSpeed", returnsObject().params(Type.OBJECT)) { it.target?.setDefaultMiningSpeed(it.getFloat(0)) }
                .function("damagePerBlock", returnsObject().noParams()) { it.target?.damagePerBlock }
                .function("setDamagePerBlock", returnsObject().params(Type.OBJECT)) { it.target?.setDamagePerBlock(it.getInt(0).toInt()) }
                .function("rules", returnsObject().noParams()) { it.target?.rules }
                .function("setRules", returnsObject().params(Type.OBJECT)) { it.target?.setRules(it.getRef(0) as List<ToolComponent.ToolRule>) }
                .function("addRule", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is Material -> it.target?.addRule(var1, it.getFloat(1), it.getBool(2))
                        is Collection<*> -> it.target?.addRule(
                            var1 as Collection<Material>,
                            it.getFloat(1),
                            it.getBool(2)
                        )

                        is Tag<*> -> it.target?.addRule(
                            var1 as Tag<Material>,
                            it.getFloat(1),
                            it.getBool(2)
                        )

                        else -> throw IllegalArgumentException("参数 1 必须是 Material, Collection<Material>, 或 Tag<Material> 类型")
                    }
                }
                .function("removeRule", returnsObject().params(Type.OBJECT)) { it.target?.removeRule(it.getRef(0) as ToolComponent.ToolRule) }
        }
    }
}

@Requires(classes = ["org.bukkit.inventory.meta.components.ToolComponent.ToolRule"])
@PlatformSide(Platform.BUKKIT)
object FnToolComponentToolRule {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ToolComponent.ToolRule::class.java)
                .function("blocks", returnsObject().noParams()) { it.target?.blocks }
                .function("setBlocks", returnsObject().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is Material -> (it.target as? ToolComponent.ToolRule)?.setBlocks(var1)
                        is Collection<*> -> (it.target as? ToolComponent.ToolRule)?.setBlocks(var1 as Collection<Material>)
                        is Tag<*> -> (it.target as? ToolComponent.ToolRule)?.setBlocks(var1 as Tag<Material>)
                        else -> throw IllegalArgumentException("参数 1 必须是 Material, Collection<Material>, 或 Tag<Material> 类型")
                    }
                }
                .function("speed", returnsObject().noParams()) { it.target?.speed }
                .function("setSpeed", returnsObject().params(Type.OBJECT)) { it.target?.setSpeed(it.getFloat(0)) }
                .function("isCorrectForDrops", returns(Type.Z).noParams()) { it.target?.isCorrectForDrops() }
                .function("setCorrectForDrops", returnsObject().params(Type.OBJECT)) { it.target?.setCorrectForDrops(it.getBool(0)) }
        }
    }
}
