package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockDispenseEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@Requires(classes = ["org.bukkit.event.block.BlockDispenseEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockDispenseEvent {

    val TYPE = Type.fromClass(BlockDispenseEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockDispenseEvent::class.java)
                .function("item", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.item) }
                .function("setItem", returnsVoid().params(FnItemStack.TYPE)) { it.target?.setItem(it.getRef(0) as ItemStack) }
                .function("velocity", returns(FnVector.TYPE).noParams()) { it.setReturnRef(it.target?.velocity) }
                .function("setVelocity", returnsVoid().params(FnVector.TYPE)) { it.target?.setVelocity(it.getRef(0) as Vector) }
        }
    }
}
