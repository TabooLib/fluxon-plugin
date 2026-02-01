package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ThrownPotion
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.ThrownPotion"])
@PlatformSide(Platform.BUKKIT)
object FnThrownPotion {

    val TYPE = Type.fromClass(ThrownPotion::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ThrownPotion::class.java)
                .function("effects", returnsObject().noParams()) { it.setReturnRef(it.target?.effects) }
                .function("item", returnsObject().noParams()) { it.setReturnRef(it.target?.item) }
                .function("setItem", returnsVoid().params(Type.OBJECT)) { it.target?.setItem(it.getRef(0) as ItemStack) }
        }
    }
}
