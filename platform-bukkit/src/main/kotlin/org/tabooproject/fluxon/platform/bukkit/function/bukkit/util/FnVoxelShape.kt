package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.BoundingBox
import org.bukkit.util.VoxelShape
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.util.VoxelShape"])
@PlatformSide(Platform.BUKKIT)
object FnVoxelShape {

    val TYPE = Type.fromClass(VoxelShape::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(VoxelShape::class.java)
                .function("boundingBoxes",returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.boundingBoxes) }
                .function("overlaps",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE)) { it.setReturnRef(it.target?.overlaps(it.getRef(0) as BoundingBox)) }
        }
    }
}
