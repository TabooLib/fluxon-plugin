package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.Location
import org.bukkit.block.Beehive
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.Beehive"])
@PlatformSide(Platform.BUKKIT)
object FnBeehive {

    val TYPE = Type.fromClass(Beehive::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Beehive::class.java)
                .function("flower", returnsObject().noParams()) { it.setReturnRef(it.target?.flower) }
                .function("setFlower", returnsVoid().params(Type.OBJECT)) { it.target?.setFlower(it.getRef(0) as Location) }
                .function("isSedated", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSedated ?: false) }
        }
    }
}
