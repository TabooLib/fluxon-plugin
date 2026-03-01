package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Chest
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Chest"])
@PlatformSide(Platform.BUKKIT)
object FnChest {

    val TYPE = Type.fromClass(Chest::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Chest::class.java)
                .function("type", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type.FnChestType.TYPE).noParams()) { it.setReturnRef(it.target?.type) }
                .function("setType", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type.FnChestType.TYPE)) { it.target?.setType(it.getRef(0) as Chest.Type)  }
                .function("setType", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type.FnChestType.enumValue(it.getString(0))?.let { p0 -> it.target?.setType(p0)  } }
        }
    }
}
