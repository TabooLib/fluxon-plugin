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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.memory.MemoryKey"])
@PlatformSide(Platform.BUKKIT)
object FnMemoryKey {

    val TYPE = Type.fromClass(MemoryKey::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MemoryKey::class.java)
                .function("key",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE).noParams()) { it.setReturnRef(it.target?.key) }
                .function("memoryClass",returns(Type.CLASS).noParams()) { it.setReturnRef(it.target?.getMemoryClass()) }
                .function("getByKey",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.memory.FnMemoryKey.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE)) { it.setReturnRef(MemoryKey.getByKey(it.getRef(0) as NamespacedKey)) }
                .function("values",returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(MemoryKey.values()) }
        }
    }
}
