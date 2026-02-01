package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Conduit
import org.bukkit.entity.LivingEntity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.Conduit"])
@PlatformSide(Platform.BUKKIT)
object FnConduit {

    val TYPE = Type.fromClass(Conduit::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Conduit::class.java)
                .function("isActive", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isActive ?: false) }
                .function("isHunting", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isHunting ?: false) }
                .function("frameBlocks", returnsObject().noParams()) { it.setReturnRef(it.target?.frameBlocks) }
                .function("frameBlockCount", returns(Type.I).noParams()) { it.setReturnInt(it.target?.frameBlockCount ?: 0) }
                .function("range", returns(Type.I).noParams()) { it.setReturnInt(it.target?.range ?: 0) }
                .function("setTarget", returnsVoid().params(Type.OBJECT)) { it.target?.setTarget(it.getRef(0) as LivingEntity) }
                .function("target", returnsObject().noParams()) { it.setReturnRef(it.target?.target) }
                .function("hasTarget", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasTarget() ?: false) }
                .function("huntingArea", returnsObject().noParams()) { it.setReturnRef(it.target?.huntingArea) }
        }
    }
}
