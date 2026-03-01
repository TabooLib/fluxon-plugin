package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Rotation
import org.bukkit.entity.ItemFrame
import org.bukkit.inventory.ItemStack
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

@Requires(classes = ["org.bukkit.entity.ItemFrame"])
@PlatformSide(Platform.BUKKIT)
object FnItemFrame {

    val TYPE = Type.fromClass(ItemFrame::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemFrame::class.java)
                .function("item",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.item) }
                .function("setItem",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setItem(it.getRef(0) as ItemStack) }
                .function("setItem",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE, Type.Z)) {
                    it.target?.setItem(it.getRef(0) as ItemStack, it.getBool(1))
                }
                .function("itemDropChance", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.itemDropChance ?: 0f) }
                .function("setItemDropChance", returnsVoid().params(Type.F)) { it.target?.setItemDropChance(it.getFloat(0)) }
                .function("rotation",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnRotation.TYPE).noParams()) { it.setReturnRef(it.target?.rotation) }
                .function("setRotation",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnRotation.TYPE)) { it.target?.setRotation(it.getRef(0) as Rotation) }
                .function("isVisible", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isVisible ?: false) }
                .function("setVisible", returnsVoid().params(Type.Z)) { it.target?.setVisible(it.getBool(0)) }
                .function("isFixed", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isFixed ?: false) }
                .function("setFixed", returnsVoid().params(Type.Z)) { it.target?.setFixed(it.getBool(0)) }
        }
    }
}
