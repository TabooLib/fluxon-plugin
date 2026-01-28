package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.Material
import org.bukkit.block.DecoratedPot
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.DecoratedPot"])
@PlatformSide(Platform.BUKKIT)
object FnDecoratedPot {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DecoratedPot::class.java)
                .function("setSherd", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.setSherd(
                        it.getRef(0) as DecoratedPot.Side,
                        it.getRef(1) as Material
                    ))
                }
                .function("getSherd", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getSherd(it.getRef(0) as DecoratedPot.Side)) }
                .function("shards", returnsObject().noParams()) { it.setReturnRef(it.target?.shards) }
                .function("inventory", returnsObject().noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("snapshotInventory", returnsObject().noParams()) { it.setReturnRef(it.target?.snapshotInventory) }
        }
    }
}
