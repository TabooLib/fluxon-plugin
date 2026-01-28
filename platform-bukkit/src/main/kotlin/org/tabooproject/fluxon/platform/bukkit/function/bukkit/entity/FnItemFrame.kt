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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.ItemFrame"])
@PlatformSide(Platform.BUKKIT)
object FnItemFrame {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemFrame::class.java)
                .function("item", returnsObject().noParams()) { it.setReturnRef(it.target?.item) }
                .function("setItem", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setItem(it.getRef(0) as ItemStack)
                    } else {
                        it.target?.setItem(it.getRef(0) as ItemStack, it.getBool(1))
                    })
                }
                .function("setItem", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setItem(it.getRef(0) as ItemStack)
                    } else {
                        it.target?.setItem(it.getRef(0) as ItemStack, it.getBool(1))
                    })
                }
                .function("itemDropChance", returnsObject().noParams()) { it.setReturnRef(it.target?.itemDropChance) }
                .function("setItemDropChance", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setItemDropChance(it.getFloat(0))) }
                .function("rotation", returnsObject().noParams()) { it.setReturnRef(it.target?.rotation) }
                .function("setRotation", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setRotation(it.getRef(0) as Rotation)) }
                .function("isVisible", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isVisible) }
                .function("setVisible", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setVisible(it.getBool(0))) }
                .function("isFixed", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isFixed) }
                .function("setFixed", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setFixed(it.getBool(0))) }
        }
    }
}
