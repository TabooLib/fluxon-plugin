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
                .function("rules",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.rules) }
                .function("setRules",returnsVoid().params(Type.LIST)) { it.target?.setRules(it.getRef(0) as List<ToolComponent.ToolRule>) }
                .function("addRule", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE, Type.F, Type.Z)) { it.target?.addRule(it.getRef(0) as Material, it.getFloat(1), it.getBool(2)) }
                .function("addRule", returnsVoid().params(org.tabooproject.fluxon.util.StandardTypes.COLLECTION, Type.F, Type.Z)) { it.target?.addRule(it.getRef(0) as Collection<Material>, it.getFloat(1), it.getBool(2)) }
                .function("addRule", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnTag.TYPE, Type.F, Type.Z)) { it.target?.addRule(it.getRef(0) as Tag<Material>, it.getFloat(1), it.getBool(2)) }
                .function("removeRule",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.components.FnToolComponentToolRule.TYPE)) { it.target?.removeRule(it.getRef(0) as ToolComponent.ToolRule) }
        }
    }
}

@Requires(classes = ["org.bukkit.inventory.meta.components.ToolComponent\$ToolRule"])
@PlatformSide(Platform.BUKKIT)
object FnToolComponentToolRule {

    val TYPE = Type.fromClass(ToolComponent.ToolRule::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ToolComponent.ToolRule::class.java)
                .function("blocks", returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.blocks) }
                .function("setBlocks", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { (it.target as? ToolComponent.ToolRule)?.setBlocks(it.getRef(0) as Material) }
                .function("setBlocks", returnsVoid().params(org.tabooproject.fluxon.util.StandardTypes.COLLECTION)) { (it.target as? ToolComponent.ToolRule)?.setBlocks(it.getRef(0) as Collection<Material>) }
                .function("setBlocks", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnTag.TYPE)) { (it.target as? ToolComponent.ToolRule)?.setBlocks(it.getRef(0) as Tag<Material>) }
                .function("speed", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.speed ?: 0f) }
                .function("setSpeed", returnsVoid().params(Type.F)) { it.target?.setSpeed(it.getFloat(0)) }
                .function("isCorrectForDrops", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCorrectForDrops() ?: false) }
                .function("setCorrectForDrops", returnsVoid().params(Type.Z)) { it.target?.setCorrectForDrops(it.getBool(0)) }
        }
    }
}
