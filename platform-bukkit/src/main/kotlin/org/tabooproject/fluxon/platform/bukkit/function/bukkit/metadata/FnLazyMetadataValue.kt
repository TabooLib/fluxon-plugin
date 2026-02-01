package org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata

import org.bukkit.metadata.LazyMetadataValue
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.metadata.LazyMetadataValue"])
@PlatformSide(Platform.BUKKIT)
object FnLazyMetadataValue {

    val TYPE = Type.fromClass(LazyMetadataValue::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LazyMetadataValue::class.java)
                .function("value", returnsObject().noParams()) { it.setReturnRef(it.target?.value()) }
        }
    }
}
