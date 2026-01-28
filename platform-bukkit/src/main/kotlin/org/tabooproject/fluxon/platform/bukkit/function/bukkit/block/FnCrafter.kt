package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Crafter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.Crafter"])
@PlatformSide(Platform.BUKKIT)
object FnCrafter {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Crafter::class.java)
                .function("craftingTicks", returnsObject().noParams()) { it.target?.craftingTicks }
                .function("setCraftingTicks", returnsObject().params(Type.OBJECT)) { it.target?.setCraftingTicks(it.getInt(0).toInt()) }
                .function("isSlotDisabled", returns(Type.Z).params(Type.OBJECT)) { it.target?.isSlotDisabled(it.getInt(0).toInt()) }
                .function("setSlotDisabled", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.setSlotDisabled(
                        it.getInt(0).toInt(),
                        it.getBool(1)
                    )
                }
                .function("isTriggered", returns(Type.Z).noParams()) { it.target?.isTriggered }
                .function("setTriggered", returnsObject().params(Type.OBJECT)) { it.target?.setTriggered(it.getBool(0)) }
        }
    }
}
