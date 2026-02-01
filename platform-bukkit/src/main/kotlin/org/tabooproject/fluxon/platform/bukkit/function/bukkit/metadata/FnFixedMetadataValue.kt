package org.tabooproject.fluxon.platform.bukkit.function.bukkit.metadata

import org.bukkit.metadata.FixedMetadataValue
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.metadata.FixedMetadataValue"])
@PlatformSide(Platform.BUKKIT)
object FnFixedMetadataValue {

    val TYPE = Type.fromClass(FixedMetadataValue::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FixedMetadataValue::class.java)
                .function("invalidate", returnsObject().noParams()) { it.setReturnRef(it.target?.invalidate()) }
                .function("value", returnsObject().noParams()) { it.setReturnRef(it.target?.value()) }
        }
    }
}
