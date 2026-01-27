package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.NamespacedKey
import org.bukkit.Registry
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.Registry"])
@PlatformSide(Platform.BUKKIT)
object FnRegistry {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Registry::class.java)
                .function("get", 1) { it.target?.get(it.getArgument(0) as NamespacedKey) }
                .function("stream", 0) { it.target?.stream() }
                .function("iterator", 0) { it.target?.iterator() }
                .function("match", 0) { it.target?.match(it.getString(0)!!) }
        }
    }
}

@Requires(classes = ["org.bukkit.Registry.SimpleRegistry"])
@PlatformSide(Platform.BUKKIT)
object FnRegistrySimpleRegistry {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Registry.SimpleRegistry::class.java)
                .function("get", 1) { it.target?.get(it.getArgument(0) as NamespacedKey) }
                .function("stream", 0) { it.target?.stream() }
                .function("iterator", 0) { it.target?.iterator() }
                .function("type", 0) { it.target?.type }
        }
    }
}
