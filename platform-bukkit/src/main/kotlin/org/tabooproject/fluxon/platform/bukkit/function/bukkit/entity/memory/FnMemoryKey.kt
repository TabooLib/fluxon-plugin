package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.memory

import org.bukkit.NamespacedKey
import org.bukkit.entity.memory.MemoryKey
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMemoryKey {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MemoryKey::class.java)
                .function("key", 0) { it.target?.key }
                .function("memoryClass", 0) { it.target?.getMemoryClass() }
                .function("byKey", 1) { MemoryKey.getByKey(it.getArgument(0) as NamespacedKey) }
                .function("values", 0) { MemoryKey.values() }
        }
    }
}
