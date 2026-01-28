package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.NamespacedKey
import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.NamespacedKey"])
@PlatformSide(Platform.BUKKIT)
object FnNamespacedKey {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NamespacedKey::class.java)
                .function("namespace", returnsObject().noParams()) { it.setReturnRef(it.target?.namespace) }
                .function("key", returnsObject().noParams()) { it.setReturnRef(it.target?.key) }
                .function("hashCode", returns(Type.I).noParams()) { it.setReturnRef(it.target?.hashCode()) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.equals(it.getRef(0))) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                // static
                .function("minecraft", returnsObject().params(Type.OBJECT)) { it.setReturnRef(NamespacedKey.minecraft(it.getString(0)!!)) }
                // static
                .function("fromString", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        NamespacedKey.fromString(it.getString(0)!!)
                    } else {
                        NamespacedKey.fromString(it.getString(0)!!, it.getRef(1) as Plugin)
                    })
                }
                .function("fromString", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        NamespacedKey.fromString(it.getString(0)!!)
                    } else {
                        NamespacedKey.fromString(it.getString(0)!!, it.getRef(1) as Plugin)
                    })
                }
        }
    }
}
