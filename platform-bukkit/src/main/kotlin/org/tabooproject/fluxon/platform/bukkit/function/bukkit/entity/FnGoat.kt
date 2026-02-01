package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Goat
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Goat"])
@PlatformSide(Platform.BUKKIT)
object FnGoat {

    val TYPE = Type.fromClass(Goat::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Goat::class.java)
                .function("hasLeftHorn", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasLeftHorn() ?: false) }
                .function("setLeftHorn", returnsVoid().params(Type.Z)) { it.target?.setLeftHorn(it.getBool(0)) }
                .function("hasRightHorn", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasRightHorn() ?: false) }
                .function("setRightHorn", returnsVoid().params(Type.Z)) { it.target?.setRightHorn(it.getBool(0)) }
                .function("isScreaming", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isScreaming ?: false) }
                .function("setScreaming", returnsVoid().params(Type.Z)) { it.target?.setScreaming(it.getBool(0)) }
        }
    }
}
