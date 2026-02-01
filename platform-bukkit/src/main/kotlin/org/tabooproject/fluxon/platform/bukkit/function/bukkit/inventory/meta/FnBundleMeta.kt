package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BundleMeta
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

@Requires(classes = ["org.bukkit.inventory.meta.BundleMeta"])
@PlatformSide(Platform.BUKKIT)
object FnBundleMeta {

    val TYPE = Type.fromClass(BundleMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BundleMeta::class.java)
                .function("hasItems", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasItems() ?: false) }
                .function("items", returnsObject().noParams()) { it.setReturnRef(it.target?.items) }
                .function("setItems", returnsVoid().params(Type.OBJECT)) { it.target?.setItems(it.getRef(0) as List<ItemStack>) }
                .function("addItem", returnsVoid().params(Type.OBJECT)) { it.target?.addItem(it.getRef(0) as ItemStack) }
        }
    }
}
