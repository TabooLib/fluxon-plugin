package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ItemDisplay
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.ItemDisplay"])
@PlatformSide(Platform.BUKKIT)
object FnItemDisplay {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemDisplay::class.java)
                .function("itemStack", returnsObject().noParams()) { it.setReturnRef(it.target?.itemStack) }
                .function("setItemStack", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setItemStack(it.getRef(0) as ItemStack)) }
                .function("itemDisplayTransform", returnsObject().noParams()) { it.setReturnRef(it.target?.itemDisplayTransform) }
                .function("setItemDisplayTransform", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setItemDisplayTransform(it.getRef(0) as ItemDisplay.ItemDisplayTransform)) }
        }
    }
}
