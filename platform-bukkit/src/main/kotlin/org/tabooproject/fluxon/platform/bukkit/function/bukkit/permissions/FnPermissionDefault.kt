package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.PermissionDefault
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.permissions.PermissionDefault"])
@PlatformSide(Platform.BUKKIT)
object FnPermissionDefault {

    val TYPE = Type.fromClass(PermissionDefault::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PermissionDefault::class.java)
                .function("getValue", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getValue(it.getBool(0))) }
                // static
                .function("getByName", returnsObject().params(Type.OBJECT)) { it.setReturnRef(PermissionDefault.getByName(it.getString(0)!!)) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
