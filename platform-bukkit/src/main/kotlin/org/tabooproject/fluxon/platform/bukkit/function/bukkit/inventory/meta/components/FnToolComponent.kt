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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.meta.components.ToolComponent"])
@PlatformSide(Platform.BUKKIT)
object FnToolComponent {

    val TYPE = Type.fromClass(ToolComponent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ToolComponent::class.java)
                .function("defaultMiningSpeed", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.defaultMiningSpeed ?: 0f) }
                .function("setDefaultMiningSpeed", returnsVoid().params(Type.F)) { it.target?.setDefaultMiningSpeed(it.getFloat(0)) }
                .function("damagePerBlock", returns(Type.I).noParams()) { it.setReturnInt(it.target?.damagePerBlock ?: 0) }
                .function("setDamagePerBlock", returnsVoid().params(Type.I)) { it.target?.setDamagePerBlock(it.getInt(0)) }
                .function("rules", returnsObject().noParams()) { it.setReturnRef(it.target?.rules) }
                .function("setRules", returnsVoid().params(Type.OBJECT)) { it.target?.setRules(it.getRef(0) as List<ToolComponent.ToolRule>) }
                .function("addRule", returnsVoid().params(Type.OBJECT, Type.F, Type.Z)) {
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
                .function("removeRule", returnsVoid().params(Type.OBJECT)) { it.target?.removeRule(it.getRef(0) as ToolComponent.ToolRule) }
        }
    }
}

@Requires(classes = ["org.bukkit.inventory.meta.components.ToolComponent.ToolRule"])
@PlatformSide(Platform.BUKKIT)
object FnToolComponentToolRule {

    val TYPE = Type.fromClass(ToolComponent.ToolRule::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ToolComponent.ToolRule::class.java)
                .function("blocks", returnsObject().noParams()) { it.setReturnRef(it.target?.blocks) }
                .function("setBlocks", returnsVoid().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is Material -> (it.target as? ToolComponent.ToolRule)?.setBlocks(var1)
                        is Collection<*> -> (it.target as? ToolComponent.ToolRule)?.setBlocks(var1 as Collection<Material>)
                        is Tag<*> -> (it.target as? ToolComponent.ToolRule)?.setBlocks(var1 as Tag<Material>)
                        else -> throw IllegalArgumentException("参数 1 必须是 Material, Collection<Material>, 或 Tag<Material> 类型")
                    }
                }
                .function("speed", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.speed ?: 0f) }
                .function("setSpeed", returnsVoid().params(Type.F)) { it.target?.setSpeed(it.getFloat(0)) }
                .function("isCorrectForDrops", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCorrectForDrops() ?: false) }
                .function("setCorrectForDrops", returnsVoid().params(Type.Z)) { it.target?.setCorrectForDrops(it.getBool(0)) }
        }
    }
}
