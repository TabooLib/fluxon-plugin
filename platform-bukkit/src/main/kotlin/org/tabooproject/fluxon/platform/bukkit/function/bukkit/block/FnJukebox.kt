package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.Material
import org.bukkit.block.Jukebox
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.Jukebox"])
@PlatformSide(Platform.BUKKIT)
object FnJukebox {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Jukebox::class.java)
                .function("playing", returnsObject().noParams()) { it.target?.playing }
                .function("setPlaying", returnsObject().params(Type.OBJECT)) { it.target?.setPlaying(it.getRef(0) as Material) }
                .function("hasRecord", returns(Type.Z).noParams()) { it.target?.hasRecord() }
                .function("record", returnsObject().noParams()) { it.target?.record }
                .function("setRecord", returnsObject().params(Type.OBJECT)) { it.target?.setRecord(it.getRef(0) as ItemStack) }
                .function("isPlaying", returns(Type.Z).noParams()) { it.target?.isPlaying }
                .function("startPlaying", returnsObject().noParams()) { it.target?.startPlaying() }
                .function("stopPlaying", returnsObject().noParams()) { it.target?.stopPlaying() }
                .function("eject", returnsObject().noParams()) { it.target?.eject() }
                .function("inventory", returnsObject().noParams()) { it.target?.inventory }
                .function("snapshotInventory", returnsObject().noParams()) { it.target?.snapshotInventory }
        }
    }
}
