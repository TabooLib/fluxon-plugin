package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Crafter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.Crafter"])
@PlatformSide(Platform.BUKKIT)
object FnCrafter {

    val TYPE = Type.fromClass(Crafter::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Crafter::class.java)
                .function("craftingTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.craftingTicks ?: 0) }
                .function("setCraftingTicks", returnsVoid().params(Type.I)) { it.target?.setCraftingTicks(it.getInt(0)) }
                .function("isSlotDisabled", returns(Type.Z).params(Type.I)) { it.setReturnBool(it.target?.isSlotDisabled(it.getInt(0)) ?: false) }
                .function("setSlotDisabled", returnsVoid().params(Type.I, Type.Z)) {
                    it.target?.setSlotDisabled(
                        it.getInt(0),
                        it.getBool(1)
                    )
                }
                .function("isTriggered", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isTriggered ?: false) }
                .function("setTriggered", returnsVoid().params(Type.Z)) { it.target?.setTriggered(it.getBool(0)) }
        }
    }
}
