package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.memory

import org.bukkit.NamespacedKey
import org.bukkit.entity.memory.MemoryKey
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.memory.MemoryKey"])
@PlatformSide(Platform.BUKKIT)
object FnMemoryKey {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MemoryKey::class.java)
                .function("key", returnsObject().noParams()) { it.target?.key }
                .function("memoryClass", returnsObject().noParams()) { it.target?.getMemoryClass() }
                .function("getByKey", returnsObject().params(Type.OBJECT)) { MemoryKey.getByKey(it.getRef(0) as NamespacedKey) }
                .function("values", returnsObject().noParams()) { MemoryKey.values() }
        }
    }
}
