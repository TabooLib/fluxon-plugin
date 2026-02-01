package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.SizedFireball
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

@Requires(classes = ["org.bukkit.entity.SizedFireball"])
@PlatformSide(Platform.BUKKIT)
object FnSizedFireball {

    val TYPE = Type.fromClass(SizedFireball::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SizedFireball::class.java)
                .function("displayItem", returnsObject().noParams()) { it.setReturnRef(it.target?.displayItem) }
                .function("setDisplayItem", returnsVoid().params(Type.OBJECT)) { it.target?.setDisplayItem(it.getRef(0) as ItemStack) }
        }
    }
}
