package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.NamespacedKey
import org.bukkit.Registry
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.Registry"])
@PlatformSide(Platform.BUKKIT)
object FnRegistry {

    val TYPE = Type.fromClass(Registry::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Registry::class.java)
                .function("get", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.get(it.getRef(0) as NamespacedKey)) }
                .function("stream", returnsObject().noParams()) { it.setReturnRef(it.target?.stream()) }
                .function("iterator", returnsObject().noParams()) { it.setReturnRef(it.target?.iterator()) }
                .function("match", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.match(it.getString(0)!!)) }
        }
    }
}

@Requires(classes = ["org.bukkit.Registry.SimpleRegistry"])
@PlatformSide(Platform.BUKKIT)
object FnRegistrySimpleRegistry {

    val TYPE = Type.fromClass(Registry.SimpleRegistry::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Registry.SimpleRegistry::class.java)
                .function("get", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.get(it.getRef(0) as NamespacedKey)) }
                .function("stream", returnsObject().noParams()) { it.setReturnRef(it.target?.stream()) }
                .function("iterator", returnsObject().noParams()) { it.setReturnRef(it.target?.iterator()) }
                .function("type", returnsObject().noParams()) { it.setReturnRef(it.target?.type) }
        }
    }
}
