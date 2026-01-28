package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Campfire
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

@Requires(classes = ["org.bukkit.block.Campfire"])
@PlatformSide(Platform.BUKKIT)
object FnCampfire {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Campfire::class.java)
                .function("size", returns(Type.I).noParams()) { it.setReturnRef(it.target?.size) }
                .function("getItem", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getItem(it.getInt(0).toInt())) }
                .function("setItem", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.setItem(it.getInt(0).toInt(), it.getRef(1) as ItemStack)) }
                .function("getCookTime", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getCookTime(it.getInt(0).toInt())) }
                .function("setCookTime", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.setCookTime(it.getInt(0).toInt(), it.getInt(1).toInt())) }
                .function("getCookTimeTotal", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getCookTimeTotal(it.getInt(0).toInt())) }
                .function("setCookTimeTotal", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.setCookTimeTotal(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt()
                    ))
                }
        }
    }
}
