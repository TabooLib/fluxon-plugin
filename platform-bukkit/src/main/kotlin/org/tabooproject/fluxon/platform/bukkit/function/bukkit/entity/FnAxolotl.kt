package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Axolotl
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Axolotl"])
@PlatformSide(Platform.BUKKIT)
object FnAxolotl {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Axolotl::class.java)
                .function("isPlayingDead", returns(Type.Z).noParams()) { it.target?.isPlayingDead }
                .function("setPlayingDead", returnsObject().params(Type.OBJECT)) { it.target?.setPlayingDead(it.getBool(0)) }
                .function("variant", returnsObject().noParams()) { it.target?.variant }
                .function("setVariant", returnsObject().params(Type.OBJECT)) { it.target?.setVariant(it.getRef(0) as Axolotl.Variant) }
        }
    }
}
