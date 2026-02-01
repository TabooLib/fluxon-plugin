package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Campfire
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.Campfire"])
@PlatformSide(Platform.BUKKIT)
object FnCampfire {

    val TYPE = Type.fromClass(Campfire::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Campfire::class.java)
                .function("size", returns(Type.I).noParams()) { it.setReturnInt(it.target?.size ?: 0) }
                .function("getItem", returns(FnItemStack.TYPE).params(Type.I)) { it.setReturnRef(it.target?.getItem(it.getInt(0).toInt())) }
                .function("setItem", returnsVoid().params(Type.I, FnItemStack.TYPE)) {
                    it.target?.setItem(it.getInt(0), it.getRef(1) as ItemStack)
                }
                .function("getCookTime", returns(Type.I).params(Type.I)) {
                    it.setReturnInt(it.target?.getCookTime(it.getInt(0)) ?: 0)
                }
                .function("setCookTime", returnsVoid().params(Type.I, Type.I)) {
                    it.target?.setCookTime(it.getInt(0), it.getInt(1))
                }
                .function("getCookTimeTotal", returns(Type.I).params(Type.I)) {
                    it.setReturnInt(it.target?.getCookTimeTotal(it.getInt(0)) ?: 0)
                }
                .function("setCookTimeTotal", returnsVoid().params(Type.I, Type.I)) {
                    it.target?.setCookTimeTotal(
                        it.getInt(0),
                        it.getInt(1)
                    )
                }
        }
    }
}
