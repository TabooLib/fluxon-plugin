package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Bed
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.Bed"])
@PlatformSide(Platform.BUKKIT)
object FnBed {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Bed::class.java)
                .function("part", returnsObject().noParams()) { it.target?.part }
                .function("setPart", returnsObject().params(Type.OBJECT)) { it.target?.setPart(it.getRef(0) as Bed.Part) }
                .function("isOccupied", returns(Type.Z).noParams()) { it.target?.isOccupied }
        }
    }
}
