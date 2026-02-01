package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.StructureSearchResult
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.util.StructureSearchResult"])
@PlatformSide(Platform.BUKKIT)
object FnStructureSearchResult {

    val TYPE = Type.fromClass(StructureSearchResult::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StructureSearchResult::class.java)
                .function("structure", returnsObject().noParams()) { it.setReturnRef(it.target?.structure) }
                .function("location", returnsObject().noParams()) { it.setReturnRef(it.target?.location) }
        }
    }
}
