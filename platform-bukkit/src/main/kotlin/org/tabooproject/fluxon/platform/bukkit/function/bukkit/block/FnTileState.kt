package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.TileState
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence.FnPersistentDataContainer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.TileState"])
@PlatformSide(Platform.BUKKIT)
object FnTileState {

    val TYPE = Type.fromClass(TileState::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TileState::class.java)
                .function("persistentDataContainer", returns(FnPersistentDataContainer.TYPE).noParams()) { it.setReturnRef(it.target?.persistentDataContainer) }
        }
    }
}
