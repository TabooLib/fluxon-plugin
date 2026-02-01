package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionAttachment
import org.bukkit.permissions.PermissionRemovedExecutor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.permissions.PermissionAttachment"])
@PlatformSide(Platform.BUKKIT)
object FnPermissionAttachment {

    val TYPE = Type.fromClass(PermissionAttachment::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PermissionAttachment::class.java)
                .function("plugin", returnsObject().noParams()) { it.setReturnRef(it.target?.plugin) }
                .function("setRemovalCallback", returnsVoid().params(Type.OBJECT)) { it.target?.setRemovalCallback(it.getRef(0) as PermissionRemovedExecutor) }
                .function("removalCallback", returnsObject().noParams()) { it.setReturnRef(it.target?.removalCallback) }
                .function("permissible", returnsObject().noParams()) { it.setReturnRef(it.target?.permissible) }
                .function("setPermission", returnsVoid().params(Type.OBJECT, Type.Z)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.setPermission(var1, it.getBool(1))
                        is Permission -> it.target?.setPermission(var1, it.getBool(1))
                        else -> throw IllegalArgumentException("参数必须是 String 或 Permission 类型")
                    }
                }
                .function("unsetPermission", returnsVoid().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.unsetPermission(var1)
                        is Permission -> it.target?.unsetPermission(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 Permission 类型")
                    }
                }
                .function("remove", returnsVoid().noParams()) { it.target?.remove() }
        }
    }
}
