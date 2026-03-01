package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Horse
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Horse"])
@PlatformSide(Platform.BUKKIT)
object FnHorse {

    val TYPE = Type.fromClass(Horse::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Horse::class.java)
                .function("color", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnHorseColor.TYPE).noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnHorseColor.TYPE)) { it.target?.setColor(it.getRef(0) as Horse.Color)  }
                .function("setColor", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnHorseColor.enumValue(it.getString(0))?.let { p0 -> it.target?.setColor(p0)  } }
                .function("style", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnHorseStyle.TYPE).noParams()) { it.setReturnRef(it.target?.style) }
                .function("setStyle", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnHorseStyle.TYPE)) { it.target?.setStyle(it.getRef(0) as Horse.Style)  }
                .function("setStyle", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnHorseStyle.enumValue(it.getString(0))?.let { p0 -> it.target?.setStyle(p0)  } }
                .function("isCarryingChest", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCarryingChest ?: false) }
                .function("setCarryingChest", returnsVoid().params(Type.Z)) { it.target?.setCarryingChest(it.getBool(0)) }
                .function("inventory", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
        }
    }
}
