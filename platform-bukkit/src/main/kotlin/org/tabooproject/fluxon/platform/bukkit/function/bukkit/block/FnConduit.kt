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
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.Conduit"])
@PlatformSide(Platform.BUKKIT)
object FnConduit {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Conduit::class.java)
                .function("isActive", returns(Type.Z).noParams()) { it.target?.isActive }
                .function("isHunting", returns(Type.Z).noParams()) { it.target?.isHunting }
                .function("frameBlocks", returnsObject().noParams()) { it.target?.frameBlocks }
                .function("frameBlockCount", returnsObject().noParams()) { it.target?.frameBlockCount }
                .function("range", returnsObject().noParams()) { it.target?.range }
                .function("setTarget", returnsObject().params(Type.OBJECT)) { it.target?.setTarget(it.getRef(0) as LivingEntity) }
                .function("target", returnsObject().noParams()) { it.target?.target }
                .function("hasTarget", returns(Type.Z).noParams()) { it.target?.hasTarget() }
                .function("huntingArea", returnsObject().noParams()) { it.target?.huntingArea }
        }
    }
}
