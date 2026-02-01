package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Lockable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.Lockable"])
@PlatformSide(Platform.BUKKIT)
object FnLockable {

    val TYPE = Type.fromClass(Lockable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Lockable::class.java)
                .function("isLocked", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLocked ?: false) }
                .function("lock", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.lock) }
                .function("setLock", returnsVoid().params(Type.STRING)) { it.target?.setLock(it.getString(0)) }
        }
    }
}
