package org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion

import org.bukkit.potion.PotionData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.potion.PotionData"])
@PlatformSide(Platform.BUKKIT)
object FnPotionData {

    val TYPE = Type.fromClass(PotionData::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PotionData::class.java)
                .function("type", returnsObject().noParams()) { it.setReturnRef(it.target?.type) }
                .function("isUpgraded", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isUpgraded ?: false) }
                .function("isExtended", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isExtended ?: false) }
                .function("hashCode", returns(Type.I).noParams()) { it.setReturnInt(it.target?.hashCode() ?: 0) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.equals(it.getRef(0)) ?: false)
                }
        }
    }
}
