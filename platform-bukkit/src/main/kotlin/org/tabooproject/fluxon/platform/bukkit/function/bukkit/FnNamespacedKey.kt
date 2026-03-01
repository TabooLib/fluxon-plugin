package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.NamespacedKey
import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.NamespacedKey"])
@PlatformSide(Platform.BUKKIT)
object FnNamespacedKey {

    val TYPE = Type.fromClass(NamespacedKey::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NamespacedKey::class.java)
                .function("namespace", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.namespace) }
                .function("key", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.key) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                // static
                .function("minecraft", returns(TYPE).params(Type.STRING)) { it.setReturnRef(NamespacedKey.minecraft(it.getString(0)!!)) }
                // static
                .function("fromString", returns(TYPE).params(Type.STRING)) {
                    it.setReturnRef(NamespacedKey.fromString(it.getString(0)!!))
                }
                .function("fromString", returns(TYPE).params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) {
                    it.setReturnRef(NamespacedKey.fromString(it.getString(0)!!, it.getRef(1) as Plugin))
                }
        }
    }
}
