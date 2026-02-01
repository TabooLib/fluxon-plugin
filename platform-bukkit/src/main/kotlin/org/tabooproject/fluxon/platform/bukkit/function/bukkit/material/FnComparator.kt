package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Comparator
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

@Requires(classes = ["org.bukkit.material.Comparator"])
@PlatformSide(Platform.BUKKIT)
object FnComparator {

    val TYPE = Type.fromClass(Comparator::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Comparator::class.java)
                .function("setSubtractionMode", returnsVoid().params(Type.Z)) { it.target?.setSubtractionMode(it.getBool(0)) }
                .function("isSubtractionMode", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSubtractionMode ?: false) }
                .function("setFacingDirection", returnsVoid().params(Type.OBJECT)) { it.target?.setFacingDirection(it.getRef(0) as BlockFace) }
                .function("facing", returnsObject().noParams()) { it.setReturnRef(it.target?.facing) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("isPowered", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPowered ?: false) }
                .function("isBeingPowered", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBeingPowered ?: false) }
        }
    }
}
