package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.Material
import org.bukkit.block.Jukebox
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnJukeboxInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.library.xseries.XMaterial
import kotlin.jvm.optionals.getOrNull

@Requires(classes = ["org.bukkit.block.Jukebox"])
@PlatformSide(Platform.BUKKIT)
object FnJukebox {

    val TYPE = Type.fromClass(Jukebox::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Jukebox::class.java)
                .function("playing", returns(FnMaterial.TYPE).noParams()) { it.setReturnRef(it.target?.playing) }
                .function("setPlaying", returnsVoid().params(FnMaterial.TYPE)) { it.target?.setPlaying(it.getRef(0) as Material) }
                .function("setPlaying", returnsVoid().params(Type.STRING)) { it.target?.setPlaying(FnMaterial.enumValue(it.getString(0))) }

                .function("hasRecord", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasRecord() ?: false) }
                .function("record", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.record) }
                .function("setRecord",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setRecord(it.getRef(0) as ItemStack) }

                .function("isPlaying", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPlaying ?: false) }
                .function("startPlaying", returnsVoid().noParams()) { it.target?.startPlaying() }
                .function("stopPlaying", returnsVoid().noParams()) { it.target?.stopPlaying() }

                .function("eject", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.eject()) }

                .function("inventory", returns(FnJukeboxInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("snapshotInventory", returns(FnJukeboxInventory.TYPE).noParams()) { it.setReturnRef(it.target?.snapshotInventory) }
        }
    }
}
