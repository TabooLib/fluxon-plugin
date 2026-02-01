package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Axolotl
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

@Requires(classes = ["org.bukkit.entity.Axolotl"])
@PlatformSide(Platform.BUKKIT)
object FnAxolotl {

    val TYPE = Type.fromClass(Axolotl::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Axolotl::class.java)
                .function("isPlayingDead", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPlayingDead ?: false) }
                .function("setPlayingDead", returnsVoid().params(Type.Z)) { it.target?.setPlayingDead(it.getBool(0)) }
                .function("variant", returnsObject().noParams()) { it.setReturnRef(it.target?.variant) }
                .function("setVariant", returnsVoid().params(Type.OBJECT)) { it.target?.setVariant(it.getRef(0) as Axolotl.Variant) }
        }
    }
}
