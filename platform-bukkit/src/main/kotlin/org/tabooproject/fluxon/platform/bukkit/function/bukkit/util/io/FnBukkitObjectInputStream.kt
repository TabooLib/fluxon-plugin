package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.io

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.util.io.BukkitObjectInputStream"])
@PlatformSide(Platform.BUKKIT)
object FnBukkitObjectInputStream {

    val TYPE = Type.fromClass(org.bukkit.util.io.BukkitObjectInputStream::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.util.io.BukkitObjectInputStream::class.java)
                // static newIOException
                // .function("resolveObject", returns(Type.OBJECT).params(Type.OBJECT)) { it.setReturnRef(it.target?.resolveObject(it.getRef(0) as java.lang.Object)) }
        }
    }
}
