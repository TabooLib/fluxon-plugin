package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.CaveVinesPlant
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.block.data.type.CaveVinesPlant"])
@PlatformSide(Platform.BUKKIT)
object FnCaveVinesPlant {

    val TYPE = Type.fromClass(CaveVinesPlant::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CaveVinesPlant::class.java)
                .function("isBerries", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBerries ?: false) }
                .function("setBerries", returnsVoid().params(Type.Z)) { it.target?.setBerries(it.getBool(0)) }
        }
    }
}
