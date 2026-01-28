package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Lockable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.Lockable"])
@PlatformSide(Platform.BUKKIT)
object FnLockable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Lockable::class.java)
                .function("isLocked", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isLocked) }
                .function("lock", returnsObject().noParams()) { it.setReturnRef(it.target?.lock) }
                .function("setLock", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setLock(it.getString(0))) }
        }
    }
}
