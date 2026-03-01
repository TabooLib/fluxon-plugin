package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ItemDisplay
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.ItemDisplay"])
@PlatformSide(Platform.BUKKIT)
object FnItemDisplay {

    val TYPE = Type.fromClass(ItemDisplay::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemDisplay::class.java)
                .function("itemStack",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.itemStack) }
                .function("setItemStack",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setItemStack(it.getRef(0) as ItemStack) }
                .function("itemDisplayTransform", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnItemDisplayItemDisplayTransform.TYPE).noParams()) { it.setReturnRef(it.target?.itemDisplayTransform) }
                .function("setItemDisplayTransform", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnItemDisplayItemDisplayTransform.TYPE)) { it.target?.setItemDisplayTransform(it.getRef(0) as ItemDisplay.ItemDisplayTransform) }
                .function("setItemDisplayTransform", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnItemDisplayItemDisplayTransform.enumValue(it.getString(0))?.let { p0 -> it.target?.setItemDisplayTransform(p0) } }
        }
    }
}
